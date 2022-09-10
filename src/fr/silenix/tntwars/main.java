package fr.silenix.tntwars;

import java.util.ArrayList;



import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import Enum.EtatPartie;
import Enum.EtatTNT;
import fr.silenix.tntwars.entity.Equipe;
import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.entity.Kit;
import fr.silenix.tntwars.entity.Map;
import fr.silenix.tntwars.entity.Tnt;
import fr.silenix.tntwars.listener.DamageListeners;
import fr.silenix.tntwars.listener.PlayerListeners;
import fr.silenix.tntwars.tasks.TaskLancementPartie;
import fr.silenix.tntwars.timer.TimerImmortality;
import fr.silenix.tntwars.timer.TimerRedemarrage;




public class main extends JavaPlugin{
	
	
	public int Timer_Global_TNT = 30;
	public int Vie_Global_TNT = 50;
	
	public Location spawn_general = new Location(Bukkit.getWorld("world"),6,1,1);
	
	public Equipe Equipe_rouge = new Equipe("Rouge",false);
	public Equipe Equipe_bleu = new Equipe("Bleu",false);
	public Equipe Equipe_vert = new Equipe("Vert",false);
	public Equipe Equipe_jaune = new Equipe("Jaune",false);
	public Equipe Sans_Equipe = new Equipe("Sans Equipe",true);
	
	public Tnt tnt_rouge = new Tnt(Equipe_rouge, Vie_Global_TNT, EtatTNT.Eteinte);
	public Tnt tnt_bleu = new Tnt(Equipe_rouge, Vie_Global_TNT, EtatTNT.Eteinte);
	public Tnt tnt_vert = new Tnt(Equipe_rouge, Vie_Global_TNT, EtatTNT.Eteinte);
	public Tnt tnt_jaune = new Tnt(Equipe_rouge, Vie_Global_TNT, EtatTNT.Eteinte);
	
	public Kit Sans_Kit = new Kit("Sans Kit",null,null,null,null,10,null,null,true);
	public Kit Guerrier = new Kit("Sans Kit",null,null,null,null,10,null,null,true);
	
	
	
	
	
	
	public Map map_en_cours;
	
	
	
	
	
	
	
	public List<Joueur> listeJoueurs = new ArrayList<>();
	
	
	public List<Map> list_maps = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	private EtatPartie EtatPartie;

	public boolean isState (EtatPartie EtatPartie) {
		return this.EtatPartie == EtatPartie;
	}
	
	public void setState(EtatPartie EtatPartie) {
		this.EtatPartie = EtatPartie;
	}
	
	
	
	
	public List<Joueur> getJoueur(){
		return listeJoueurs;
		
	}
	
	
	
	
	
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	
	
	

	
	
	pm.registerEvents(new PlayerListeners(this) , this);
	pm.registerEvents(new DamageListeners(), this);
	
	
	
	list_maps.add(
		new Map(
				2,
				"chateau",
				new Location(Bukkit.getWorld("world"),30,167,-315),
				new ArrayList<Location>(Arrays.asList(new Location(Bukkit.getWorld("world"),30,11,-242), new Location(Bukkit.getWorld("world"),30,11,-386))),
				new ArrayList<Location>(Arrays.asList(new Location(Bukkit.getWorld("world"),30,9,-371), new Location(Bukkit.getWorld("world"),30,9,-257))),
				new Location(Bukkit.getWorld("world"),30,167,-315),
				new Location(Bukkit.getWorld("world"),30,167,-315),
				new Location(Bukkit.getWorld("world"),30,167,-315)
				)
		
		
		
		);
	
	
	
	
	

	
	

	}
	
	
	public void efface_laine() {
		
		
		for (int x = map_en_cours.getLocationMapBorne1().getBlockX();x!=map_en_cours.getLocationMapBorne2().getBlockX(); x++) {
			for (int y=map_en_cours.getLocationMapBorne1().getBlockY();y!=map_en_cours.getLocationMapBorne2().getBlockY(); y++) {
				for (int z=map_en_cours.getLocationMapBorne1().getBlockZ();z!=map_en_cours.getLocationMapBorne2().getBlockZ(); z++) {
					/*if(!(world.getBlockAt(x, y, z).getType() == Material.BLUE_WOOL) && !(world.getBlockAt(x, y, z).getType() == Material.RED_WOOL)) {
						
					}*/
					if (Bukkit.getWorld("world").getBlockAt(x, y, z).getType() == Material.BLUE_WOOL || Bukkit.getWorld("world").getBlockAt(x, y, z).getType() == Material.RED_WOOL) {
							
						Bukkit.getWorld("world").getBlockAt(x, y, z).setType(Material.AIR);
					}
			                
				}
			}
		}
		
		
	}
	
	
	public int getSize(Equipe Equipe) {
		int nombre_joueur = 0;
	    for(int i=0; i < listeJoueurs.size(); i++) {
			Joueur joueur = listeJoueurs.get(i);
			if (joueur.getEquipe() == Equipe ) {
				nombre_joueur ++;
			} 
				
	    }
	    return nombre_joueur; 
	}
	
	public void AutoAddTeam(int NbEquipe) {
		
		
		for(int i=0; i < listeJoueurs.size(); i++) {
			Joueur joueur = getJoueur().get(i);
			
			if(joueur.getEquipe()!= Sans_Equipe) {
					return;
			}
			switch(NbEquipe) {
				case 1:
				
				
				if(getSize(Equipe_bleu) < getSize(Equipe_rouge)) {
		
					joueur.setEquipe(Equipe_bleu);

					return;
				}
				
				
				if(getSize(Equipe_bleu) > getSize(Equipe_rouge)) {
		
					joueur.setEquipe(Equipe_rouge);
					return;
				}
				
				if(getSize(Equipe_bleu) == getSize(Equipe_rouge)) {
		
					joueur.setEquipe(Equipe_bleu);
					return;
				}
				
				
			}
			
		}
		


	}
	
	public void GamePlay(Joueur joueur) {
		
		//for(int i=0; i < getPlayer().size(); i++) {
			
			
			joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
			joueur.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
			
			
			ItemStack customironsword = new ItemStack(Material.IRON_SWORD,1);
			ItemMeta customIS = customironsword.getItemMeta();
			customIS.setDisplayName("a supprimer c'est un test");
			
			customIS.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
			customIS.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			customIS.setLore(Arrays.asList("a supprimer c'est un test","deuxieme","troisieme"));
			customironsword.setItemMeta(customIS);
			
			
			
			//UpdateBelowScoreboard(player);
			
			ItemStack customblazepowder = new ItemStack(Material.BLAZE_POWDER,1);
			ItemMeta customBP = customblazepowder.getItemMeta();
			customBP.setDisplayName("Clique droit pour allumer la TNT adverse");
			
			customBP.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
			customBP.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			customBP.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
			customblazepowder.setItemMeta(customBP);
			
			ItemStack customfeather = new ItemStack(Material.FEATHER,1);
			ItemMeta customFF = customfeather.getItemMeta();
			customFF.setDisplayName("Clique droit pour désamorcer sa TNT");
			
			customFF.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
			customFF.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			customFF.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
			customfeather.setItemMeta(customFF);
			joueur.getPlayer().getInventory().setItem(8, customfeather);
			joueur.getPlayer().getInventory().setItem(7, customblazepowder);
			
			
			
			
			
			
			TimerImmortality start = new TimerImmortality( joueur.getPlayer());
			start.runTaskTimer(this, 0, 20);
			
			
			
		
		
	}
	

	public void SpawnTeleportation(Joueur joueur) {
		
		if(joueur.getEquipe()==Equipe_rouge) {
			joueur.getPlayer().teleport(map_en_cours.getLocationSpawnEquipeArray(0));
		}
		
		if(joueur.getEquipe()==Equipe_bleu) {
			joueur.getPlayer().teleport(map_en_cours.getLocationSpawnEquipeArray(1));
		}
		
		if(joueur.getEquipe()==Equipe_vert) {
			joueur.getPlayer().teleport(map_en_cours.getLocationSpawnEquipeArray(2));
		}
		if(joueur.getEquipe()==Equipe_jaune) {
			joueur.getPlayer().teleport(map_en_cours.getLocationSpawnEquipeArray(3));
		}
		
		
		
		
	}

	public void CheckWin() {
		int nombre_de_tnt_explose=0;

				
		if(tnt_rouge.getEtat()== EtatTNT.Explose) {
			nombre_de_tnt_explose++;
			}
		if(tnt_bleu.getEtat()== EtatTNT.Explose) {
			nombre_de_tnt_explose++;
			}
		if(nombre_de_tnt_explose == map_en_cours.getNbEquipe()-1) {
			
			
			TimerRedemarrage cycle = new TimerRedemarrage(this);
			cycle.runTaskTimer(this, 0, 20);
		}
				


	}

	public void remiseazero() {
		tnt_rouge.setEtat(EtatTNT.Eteinte);
		tnt_bleu.setEtat(EtatTNT.Eteinte);
		tnt_vert.setEtat(EtatTNT.Eteinte);
		tnt_jaune.setEtat(EtatTNT.Eteinte);
		
		
		
		
		
		for(int i =0; i<5;i++){
	         Collections.shuffle(listeJoueurs);
	         //System.out.println(arlist);
	        }
		
		for(int i=0; i<listeJoueurs.size();i++) {
			Joueur joueur = listeJoueurs.get(i) ;
			
			joueur.getPlayer().setInvulnerable(false);
			
			
			joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
			joueur.getPlayer().getInventory().clear();
			
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
			
			joueur.getPlayer().setInvisible(false);
			
			
			
			
			
			joueur.getPlayer().teleport(spawn_general);
			
		}
		
		
		if(isState(EtatPartie.AttenteJoueur)  && listeJoueurs.size()  >= 2 && !isState(EtatPartie.Lancement)) {
			
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eAssez de monde pour relancer une nouvelle partie.");
			setState(EtatPartie.Lancement);
			TaskLancementPartie start = new TaskLancementPartie(this);
			start.runTaskTimer(this, 0, 20);
		}
		
		
		/*PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new GPlayerListeners(this) , this);
		pm.registerEvents(new GDamageListeners(this), this);*/
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}