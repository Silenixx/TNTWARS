package fr.silenix.tntwars.tasks;
import java.util.Arrays;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import Enum.EtatPartie;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;

public class TaskLancementPartie extends BukkitRunnable{
	private int timer = 15;
	private GMain main;
	static World world = Bukkit.getWorld("world");

	public TaskLancementPartie(GMain main) {
		this.main = main;
	}

	@Override
	public void run() {
		if(main.listeJoueurs.size()  < 2) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eAnnulation de début de partie par manque de joueur");
			cancel();
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				joueur.getPlayer().setExp(0);
			}
			main.setState(EtatPartie.AttenteJoueur);
		}
		else if(main.isState(EtatPartie.Lancement)) {
			for(Joueur pls : main.listeJoueurs) {
				pls.getPlayer().setLevel(timer);
			}
			
			if(timer==35 || timer ==10 || timer ==5 || timer==4 || timer==3|| timer==2|| timer==1) {
				Bukkit.broadcastMessage("§6[§eTntWars§6] §eTéléportation vers la carte de jeu dans §6" + timer +"§e secondes.");
			}
			
			else if(timer == 0) {
				Random random = new Random();
				int value_random_en_cours = random.nextInt((main.list_maps.size() - 1) + 1) +1;
				main.map_en_cours = main.list_maps.get(value_random_en_cours-1);
				Bukkit.broadcastMessage("§6[§eTntWars§6] §ePour cette partie la map §6" + main.map_en_cours.Nom + "§e a été choisie.");
				
				main.efface_laine();
				
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"killall parrot");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"killall pig");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"killall horse");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"killall dog");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"killall wolf");
				
				for(int i=0; i < main.listeJoueurs.size(); i++) {
					Joueur joueur = main.listeJoueurs.get(i);
					joueur.getPlayer().teleport(main.map_en_cours.LocationVisite);
					
					ItemStack customcompasse = new ItemStack(Material.COMPASS,1);
					ItemMeta customC2 = customcompasse.getItemMeta();
					customC2.setDisplayName("Selectionneur d'équipe");
					customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
					customC2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					customC2.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
					customcompasse.setItemMeta(customC2);
					joueur.getPlayer().getInventory().setItem(8,customcompasse);
				}
				main.setState(EtatPartie.Prejeu);
				TaskDebutPartie start = new TaskDebutPartie(main);
				start.runTaskTimer(main, 0, 20);
				cancel();
			}
		}
		timer--;
	}
}