package fr.silenix.tntwars.listener;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Enum.EtatPartie;
import fr.silenix.tntwars.main;
import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.tasks.TaskLancementPartie;

//import fr.silenix.tntwars.entity.Joueur;


public class PlayerListeners implements Listener{
	
	private main main;


	public PlayerListeners(main main) {
		this.main = main;
	}
	
	
	 @EventHandler
     public void onPlayerJoin(PlayerJoinEvent event) {
		 
		 Player player = event.getPlayer();
		 Joueur joueur = new Joueur(player,main.Sans_Equipe,main.Sans_Kit); //kit par défaut est le sans kit
		 main.listeJoueurs.add(joueur);
	 
	 
	 
		 joueur.getPlayer().getInventory().clear();
	 
	 
	 
	 
	 
	 
	 
	 
		 if(!main.isState(EtatPartie.FinJeu)) { //si le joueur rejoint la partie avant la fin du jeu on lui donne le selectionneur d'équipe
				
				ItemStack customnetherstar = new ItemStack(Material.NETHER_STAR,1);
				ItemMeta customNS = customnetherstar.getItemMeta();
				customNS.setDisplayName("Selectionneur d'équipe");
				
				customNS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customNS.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customNS.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				customnetherstar.setItemMeta(customNS);
				joueur.getPlayer().getInventory().setItem(4,customnetherstar);
				
				
				ItemStack customcompasse = new ItemStack(Material.COMPASS,1);
				ItemMeta customC2 = customcompasse.getItemMeta();
				customC2.setDisplayName("Choisir le kit");
				
				customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customC2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customC2.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				customcompasse.setItemMeta(customC2);
				joueur.getPlayer().getInventory().setItem(8,customcompasse);
				
				
				
				
				ItemStack custombed = new ItemStack(Material.RED_BED,1);
				ItemMeta customB = custombed.getItemMeta();
				customB.setDisplayName("Retour au lobby");
				
				customB.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customB.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customB.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				custombed.setItemMeta(customB);
				joueur.getPlayer().getInventory().setItem(0,custombed);
			}
		 
		 
		 
		 if(main.isState(EtatPartie.FinJeu)) {
			 	joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
			 	joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eLe jeu est terminé, revenez pour la partie suivante !");
		 	}
		 
		 
		 if(main.isState(EtatPartie.AttenteJoueur) || main.isState(EtatPartie.Lancement)) {
			 	joueur.getPlayer().teleport(main.spawn_general);
			
			 	joueur.getPlayer().setInvisible(false);
				
				/*if(!main.getPlayer().contains(player)) {
					main.players.add(player);
						
				}*/
				
			 	joueur.getPlayer().setGameMode(GameMode.ADVENTURE);
				event.setJoinMessage("§6[§eTntWars§6] §6" + player.getName()+ " §evient de se connecter à la partie.   §5<§d"+ main.listeJoueurs.size()+"§5/§d"+ Bukkit.getMaxPlayers()+"§5>");
			
			
			
			
				if(main.isState(EtatPartie.AttenteJoueur)  && main.listeJoueurs.size()  >= 2) {
						
					main.setState(EtatPartie.Lancement);
					TaskLancementPartie start = new TaskLancementPartie(main);
					start.runTaskTimer(main, 0, 20);
					
						
				}
			}
	 
	 
	 
	 
	 }
	 
	 @EventHandler
		public void onQuit(PlayerQuitEvent event) {
			
			
			
			Player player = event.getPlayer();
			
			
			main.listeJoueurs.remove(main.listeJoueurs.stream()
					  .filter(p -> player.getName().equals(p.getPlayer().getName()))
					  .findAny()
					  .orElse(null));
			
			
				
				
			player.setPlayerListName(player.getName());
				
			
			
			event.setQuitMessage(player.getName() + " left.");
			
			
		}
	
	
	
}
