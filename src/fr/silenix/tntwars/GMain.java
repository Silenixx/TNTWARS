package fr.silenix.tntwars;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
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
import fr.silenix.tntwars.timer.TimerRespawn;




public class GMain extends JavaPlugin{
	
	
	//public int Timer_Global_TNT = 30;
	public int Avancement_Max_Global_TNT = 50;
	public int Vie_Global_Joueur = 40;
	
	
	World world = Bukkit.getWorld("world");
	public Location spawn_general = new Location(world,6,1,1);
	
	public Equipe Equipe_rouge = new Equipe("Rouge",false);
	public Equipe Equipe_bleu = new Equipe("Bleu",false);
	public Equipe Equipe_vert = new Equipe("Vert",false);
	public Equipe Equipe_jaune = new Equipe("Jaune",false);
	public Equipe Sans_Equipe = new Equipe("Sans Equipe",true);
	
	public Tnt tnt_rouge = new Tnt(Equipe_rouge, 0, EtatTNT.Eteinte);
	public Tnt tnt_bleu = new Tnt(Equipe_bleu, 0, EtatTNT.Eteinte);
	public Tnt tnt_vert = new Tnt(Equipe_vert, 0, EtatTNT.Eteinte);
	public Tnt tnt_jaune = new Tnt(Equipe_jaune, 0, EtatTNT.Eteinte);
	
	
	
	
	public Kit Sans_Kit = new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Guerrier = new Kit(
					"Sans Kit",
					new ItemStack(Material.IRON_HELMET),
					new ItemStack(Material.IRON_CHESTPLATE),
					new ItemStack(Material.IRON_LEGGINGS),
					new ItemStack(Material.IRON_BOOTS),
					new ItemStack(Material.IRON_SWORD),
					20,
					null,
					null,
					true);
	public Kit Endermen = new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Kamikaze=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit OneShot=new Kit("Sans Kit",null,null,null,null,null,1,null,null,true);
	public Kit Elytra=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Ninja=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Savior=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit PigRider=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Chevalier=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Pirate=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit DogMaster=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Trident=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Squid=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Barbare=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit SnowMan=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Tank=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Archer=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Sorcier=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Ghost=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Healer=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Pyro=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Builder=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	public Kit Alchimiste=new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
	
	
	
	
	
	
	
	
	public Map map_en_cours;
	
	
	
	
	
	public List<Map> list_maps = new ArrayList<>();
	
	
	
	
	
	public List<Joueur> listeJoueurs = new ArrayList<>();
	public List<Joueur> listeConnecte = new ArrayList<>();
	private EtatPartie Etat;


	
	
	
	

	
	
	
	
	@Override
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	
	setState(EtatPartie.AttenteJoueur);

	list_maps.add( new Map(
			2,
			"chateau",
			new Location(world,431,132,7),
			new ArrayList<Location>(Arrays.asList(new Location(world,501,13,24), new Location(world,365,13,4))),
			new ArrayList<Location>(Arrays.asList(new Location(world,523,13,18), new Location(world,341,8,10))),
			new Location(world,501,13,24),
			new Location(world,221,-66,-114),
			new Location(world,644,103,141)));
	
	
	
	
		
	pm.registerEvents(new PlayerListeners(this) , this);
	pm.registerEvents(new DamageListeners(this), this);
	

	}
	
	public boolean isState (EtatPartie EtatPartie) {
		return this.Etat == EtatPartie;
	}
	
	public void setState(EtatPartie EtatPartie) {
		this.Etat = EtatPartie;
	}
	
	
	public void efface_laine() {
		
		
		
		
		for (int x = map_en_cours.getLocationMapBorne1().getBlockX();x!=map_en_cours.getLocationMapBorne2().getBlockX(); x++) {
			for (int y=map_en_cours.getLocationMapBorne1().getBlockY();y!=map_en_cours.getLocationMapBorne2().getBlockY(); y++) {
				for (int z=map_en_cours.getLocationMapBorne1().getBlockZ();z!=map_en_cours.getLocationMapBorne2().getBlockZ(); z++) {
					/*if(!(world.getBlockAt(x, y, z).getType() == Material.BLUE_WOOL) && !(world.getBlockAt(x, y, z).getType() == Material.RED_WOOL)) {
						
					}*/
					if (world.getBlockAt(x, y, z).getType() == Material.BLUE_WOOL || world.getBlockAt(x, y, z).getType() == Material.RED_WOOL) {
							
						world.getBlockAt(x, y, z).setType(Material.AIR);
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
			Joueur joueur = listeJoueurs.get(i);
			
			if(joueur.getEquipe()!= Sans_Equipe) {
					return;
			}
			switch(NbEquipe) {
				case 2:
				
				
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
			
			
			
			
			
			
			joueur.getPlayer().getInventory().setBoots(joueur.getKit().getBoots());
			joueur.getPlayer().getInventory().setChestplate(joueur.getKit().getChestplate());
			joueur.getPlayer().getInventory().setHelmet(joueur.getKit().getHelmet());
			joueur.getPlayer().getInventory().setLeggings(joueur.getKit().getLegging());
			
			
			
			
			
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
			
			
			sethealth(joueur);
			
			
			
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
		
		
		
		
		listeJoueurs.clear();
		
		for(int i=0; i<listeConnecte.size();i++) {
	         Joueur joueur_tempo = new Joueur(listeConnecte.get(i).getPlayer(),listeConnecte.get(i).getPlayer().getName(),Sans_Equipe,Sans_Kit);
	         listeJoueurs.add(joueur_tempo);
	        }
		
		
		
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
	}

	public void eliminate(Player player) {
		Joueur joueur = (listeJoueurs.stream()
				  .filter(p -> player.getName().equals(p.getPlayer().getName()))
				  .findAny()
				  .orElse(null));

		player.setInvulnerable(true);
		
		
		player.getInventory().clear();
		
		player.teleport(map_en_cours.getLocationSalleMort());
		
		player.setFoodLevel(20);
		sethealth(joueur);
		player.setGameMode(GameMode.ADVENTURE);
		player.sendMessage("vous etes mort");
		player.setInvisible(true);
		
		


		
		
		ItemStack customcompasse = new ItemStack(Material.COMPASS,1);
		ItemMeta customC2 = customcompasse.getItemMeta();
		customC2.setDisplayName("Choisir le kit");
		
		customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
		customC2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		customC2.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
		
		customcompasse.setItemMeta(customC2);
		joueur.getPlayer().getInventory().setItem(8,customcompasse);
		
		
		
		TimerRespawn cycle = new TimerRespawn(this, player);
		cycle.runTaskTimer(this, 0, 20);
		
		
		
	}
		
	@SuppressWarnings("deprecation")
	public void sethealth(Joueur joueur) {
		
		if(!isState(EtatPartie.JeuEnCours)) {
			joueur.getPlayer().setMaxHealth(joueur.getKit().getPointVie());
			joueur.getPlayer().setHealth(joueur.getKit().getPointVie());
			joueur.getPlayer().setFoodLevel(20);
		}
		
	}

	public void respawn(Player player) {
			player.setGameMode(GameMode.SURVIVAL);
			player.setInvisible(false);
			
			Joueur joueur = (listeJoueurs.stream()
					  .filter(p -> player.getName().equals(p.getPlayer().getName()))
					  .findAny()
					  .orElse(null));


			
			player.setFoodLevel(20);
			player.setHealth(20);
			
			
			
			
			SpawnTeleportation(joueur);
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect clear "+ joueur.getPlayer().getName());
			GamePlay(joueur);
			//attribution_du_kit(joueur);
			
		
		}

	public void RejoindEquipe(Joueur joueur, Equipe equipe, int NbEquipe) {
		
		
		

		
		if(joueur.getEquipe()==equipe) {
			joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eVous etes déja "+equipe.getCouleur()+".");
		}
		
		if(joueur.getEquipe()!=equipe) {
			
			
				
			if( listeJoueurs.size() /NbEquipe >= getSize(equipe)) {
				
				if(listeJoueurs.size()==2 && NbEquipe==2) {
					if(equipe == Equipe_bleu) {
						if(getSize(equipe)==1 && getSize(Equipe_jaune)==0) {
							joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les "+equipe.getCouleur()+" essayez une autre équipe ou plus tard.");
							return;
						}
					}else {
						if(getSize(equipe)==1 && getSize(Equipe_bleu)==0) {
							joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les "+equipe.getCouleur()+" essaie les rouges ou plus tard.");
							return;
						}
					}
					
				}  
				
				
				
				
				joueur.setEquipe(equipe);

				
				joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eVous avez rejoinds l'équipe "+equipe.getCouleur()+".");
			} else {
				joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les "+equipe.getCouleur()+" essayez une autre équipe ou plus tard.");
			}
			
			
			
			
			
			
			
			
			
			
		}
			
		
		
		
		
	}


		
		

	

	
	
}