package fr.silenix.tntwars.listener;

import java.util.Arrays;








import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import Enum.EtatPartie;
import Enum.EtatTNT;
import Fonctions.IndexKit;
import fr.silenix.tntwars.GMain;

import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.entity.Kit;
import fr.silenix.tntwars.tasks.TaskLancementPartie;
import fr.silenix.tntwars.tasks.TaskRejoindPartieEnCours;
import fr.silenix.tntwars.timer.TimerAllumage;
import fr.silenix.tntwars.timer.TimerInvisibility;

//import fr.silenix.tntwars.entity.Joueur;


public class PlayerListeners implements Listener{
	
	private GMain main;
	
	static World world = Bukkit.getWorld("world");


	public PlayerListeners(GMain main) {
		this.main = main;
	}
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
     public void onJoin(PlayerJoinEvent event) {
		 Player player = event.getPlayer();
		 
		 
		 Joueur joueur = new Joueur(player,player.getName(),main.Sans_Equipe,main.list_kits.get(IndexKit.Sans_Kit),main.list_kits.get(IndexKit.Sans_Kit));
		 main.listeConnecte.add(joueur);
		 
		 
		 player.setInvulnerable(false);
		 player.setExp(0);
		 player.setInvisible(false);
		 
		 player.setFoodLevel(20);
		 player.setMaxHealth(20);
		 player.setHealth(20);
		 

		 player.getInventory().clear();
		 player.setScoreboard(main.board);
		 
		 
		 
		 
	 
		 if(!main.isState(EtatPartie.FinJeu)) { //si le joueur rejoint la partie avant la fin du jeu on lui donne le selectionneur d'équipe
				
			 main.listeJoueurs.add(joueur);
			 	ItemStack customnetherstar = new ItemStack(Material.NETHER_STAR,1);
				ItemMeta customNS = customnetherstar.getItemMeta();
				customNS.setDisplayName("Choisir le kit");
				
				customNS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customNS.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customNS.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				customnetherstar.setItemMeta(customNS);
				player.getInventory().setItem(0,customnetherstar);
				
				

				
				
				
				
				/*ItemStack custombed = new ItemStack(Material.RED_BED,1);
				ItemMeta customB = custombed.getItemMeta();
				customB.setDisplayName("Retour au lobby");
				
				customB.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customB.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customB.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				custombed.setItemMeta(customB);
				player.getInventory().setItem(0,custombed);*/
			
				
				
				
				
				if (!main.isState(EtatPartie.AttenteJoueur) && !main.isState(EtatPartie.FinJeu) && !main.isState(EtatPartie.Lancement)) {
					player.setGameMode(GameMode.ADVENTURE);
					player.setInvisible(true);
					player.sendMessage("§5[§dSilenixGames§5] §bLe jeux a déja démarrer mais vous pouvez rejoindre une équipe! ");
					event.setJoinMessage(null);
					
					
					ItemStack customnetherstars = new ItemStack(Material.NETHER_STAR,1);
					ItemMeta customNSs = customnetherstars.getItemMeta();
					customNSs.setDisplayName("Choisir le kit");
					customNSs.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
					customNSs.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					customNSs.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
					customnetherstars.setItemMeta(customNSs);
					player.getInventory().setItem(0,customnetherstars);
					
					
					TaskRejoindPartieEnCours cycle = new TaskRejoindPartieEnCours(main, joueur);
					cycle.runTaskTimer(main, 0, 20);
					


					
					

				}
				
				
				
				
				
				if(main.isState(EtatPartie.AttenteJoueur) || main.isState(EtatPartie.Lancement)) {
				 	player.teleport(main.spawn_general);
				
				 	player.setGameMode(GameMode.ADVENTURE);
					event.setJoinMessage("§6[§eTntWars§6] §6" + player.getName()+ " §evient de se connecter à la partie.   §5<§d"+ main.listeJoueurs.size()+"§5/§d"+ Bukkit.getMaxPlayers()+"§5>");
				
				
					if(main.isState(EtatPartie.AttenteJoueur)  && main.listeJoueurs.size()  >= 2) {
							
						main.setState(EtatPartie.Lancement);
						TaskLancementPartie start = new TaskLancementPartie(main);
						start.runTaskTimer(main, 0, 20);
						
							
					}
					
					
				}
				
				if(main.isState(EtatPartie.Prejeu)) {
					
					player.setInvisible(false);
					player.teleport(main.map_en_cours.getLocationVisite());
					
					
					
					
					
					
					player.setGameMode(GameMode.ADVENTURE);
					event.setJoinMessage("§6[§eTntWars§6] §6" + player.getName()+ " §evient de se connecter à la partie.   §5<§d"+ main.listeJoueurs.size()+"§5/§d"+ Bukkit.getMaxPlayers()+"§5>");
				
				
				
				
						
				}
				
				
				
				
				
		 
		 
		 }
		 
		 
		 
		 if(main.isState(EtatPartie.FinJeu)) {
			 	player.setGameMode(GameMode.SPECTATOR);
			 	player.sendMessage("§6[§eTntWars§6] §eLe jeu est terminé, revenez pour la partie suivante !");
		 	}
		 
		 
		 
	 
	 
	 
	 
	 }
	 
	 @EventHandler
	 public void onQuit(PlayerQuitEvent event) {
			Player player = event.getPlayer();
			Joueur joueur = main.listeJoueurs.stream()
					  .filter(p -> player.getName().equals(p.getNom()))
					  .findAny()
					  .orElse(null);
			
			main.listeJoueurs.remove(joueur);
			main.listeConnecte.remove(joueur);
			player.setPlayerListName(player.getName());
			event.setQuitMessage(player.getName() + " est partie.");
			
			
			
		}
	 
	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		BlockState block_replaced = event.getBlockReplacedState();
		
		if(!main.isState(EtatPartie.JeuEnCours)) {
			event.setCancelled(true);
			return;
		}else {
			if(event.getBlock().getType() == Material.RED_WOOL || event.getBlock().getType() == Material.BLUE_WOOL) {
				if(block_replaced.getType() == Material.WATER ) {
					event.setCancelled(true);
					return;
				}
				return;
			}else {
				event.setCancelled(true);
				return;
			}
		}
			
	}
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if(!main.isState(EtatPartie.JeuEnCours)) {
			event.setCancelled(true);
			return;
		}else {
			if(event.getBlock().getType() == Material.RED_WOOL || event.getBlock().getType() == Material.BLUE_WOOL) {
				return;
			}else {
				event.setCancelled(true);
				return;
			}
		}
		
		
	}
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();
		
		Joueur joueur = main.listeJoueurs.stream()
				  .filter(p -> player.getName().equals(p.getPlayer().getName()))
				  .findAny()
				  .orElse(null);
		
		
		
		ItemStack current = event.getCurrentItem();
		
		
		
		
		
		
		if (current==null) return;
		
		if(inv.contains(Material.RED_WOOL)) {
			if (current.getType()==Material.RED_WOOL) {
				player.closeInventory();
				main.RejoindEquipe(joueur, main.Equipe_rouge, main.map_en_cours.getNbEquipe());
			}else if (current.getType()==Material.BLUE_WOOL) {
				player.closeInventory();
				main.RejoindEquipe(joueur, main.Equipe_bleu, main.map_en_cours.getNbEquipe());
			}
		}
		
		
		
		
		if(inv.contains(Material.HEART_OF_THE_SEA) && inv.contains(Material.BEACON)) {
			
			
			
			Kit kit = main.list_kits.stream()
					.filter(k  ->  k.getItemSelection().getType().equals(current.getType()))
					.findFirst()
					.get();
			
			
			joueur.setProchainKit(kit); 
			player.closeInventory();
			player.sendMessage("§6[§eTntWars§6] §eKit "+ kit.getNom() +" sélectionné");
			

		}
	}

	@EventHandler
	public void onInteractEntity(PlayerInteractEntityEvent event) {
		if(event.getRightClicked() instanceof Player)
        {
            Player player = event.getPlayer();
            Player victim = (Player) event.getRightClicked();
            
            Joueur joueur = main.listeJoueurs.stream()
					  .filter(p -> player.getName().equals(p.getNom()))
					  .findAny()
					  .orElse(null);
            Joueur joueur_victime = main.listeJoueurs.stream()
					  .filter(p -> victim.getName().equals(p.getNom()))
					  .findAny()
					  .orElse(null);
            
            /*if(!(player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD)) {
            	return;
            }*/
            
            /*if(player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {
            	if(main.TeamBlue.contains(player) && main.TeamBlue.contains(victim)) {
            		
            		if(victim.getHealth()>17.0) {
            			victim.setHealth(20.0);
            		}else {
            			victim.setHealth(victim.getHealth() + 1.0);
            		}
            		
            	}
            	
            	if(main.TeamRed.contains(player) && main.TeamRed.contains(victim)) {
            		
            		if(victim.getHealth()>17.0) {
            			victim.setHealth(20.0);
            		}else {
            			victim.setHealth(victim.getHealth() + 1.0);
            		}
            	}
            }*/
            
            if(joueur.getEquipe()== joueur_victime.getEquipe()) {
				
				if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.GLISTERING_MELON_SLICE) {
					if(joueur_victime.getKit()!=main.list_kits.get(IndexKit.OneShot)){
						if(joueur_victime.getPlayer().getHealth()>joueur_victime.getKit().getPointVie()-3) {
							victim.setHealth(joueur_victime.getKit().getPointVie());
	            		}else {
	            			victim.setHealth(victim.getHealth() + 2.0);
	            		}
					}
					return;
				}
				
			}
			

			
			
			
			
				
			if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.AMETHYST_CLUSTER) {
				((HumanEntity) player).getInventory().getItemInMainHand().setAmount(((HumanEntity) player).getInventory().getItemInMainHand().getAmount() - 1);
		        
				
				main.SpawnTeleportation(joueur);
				return;
			}
				

			

			
			
			if(joueur.getEquipe()!= joueur_victime.getEquipe()) {
				
				if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.INK_SAC) {
					
		            
					
					victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*15, 7));
					
					return;
				}
				
			}
			
			
            
            
			
            
        }
		
		
	}
	 
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
			
			Player player = event.getPlayer();
			Player player2 = event.getPlayer();
			//Action action = event.getAction();
			ItemStack it = event.getItem();
			Block block = event.getClickedBlock();
			
			
			Joueur joueur = main.listeJoueurs.stream()
					  .filter(p -> player2.getName().equals(p.getNom()))
					  .findAny()
					  .orElse(null);
			
			
			if (it==null) return;
			
			//setStateTntBlue(GStateTntBlue.BLUE_ETTEINTE);
			//setStateTntRed(GStateTntRed.RED_ETTEINTE);
			
			//Location tntblue = new Location (world, -5, 85, -9);
			
			
			if(it.getType() == Material.COMPASS /*&& it.getItemMeta().getDisplayName().equalsIgnoreCase("Selectionneur d'équipe")*/){


				Inventory inv = Bukkit.createInventory(null, 27, "§7Choix d'équipe");
				
				ItemStack customwoolteamblue = new ItemStack(Material.BLUE_WOOL,1);
				ItemMeta customWTB = customwoolteamblue.getItemMeta();
				customWTB.setDisplayName("Rejoindre l'équipe bleu");
				
				//customWTB.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTB.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customWTB.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				customwoolteamblue.setItemMeta(customWTB);
				
				
				
				
				
				
				ItemStack customwoolteamred = new ItemStack(Material.RED_WOOL,1);
				ItemMeta customWTR = customwoolteamred.getItemMeta();
				customWTR.setDisplayName("Rejoindre l'équipe rouge");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customWTR.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				customwoolteamred.setItemMeta(customWTR);
				
				inv.setItem(11, customwoolteamred);
				inv.setItem(14, customwoolteamblue);
				
				
				
				player.openInventory(inv);
			}
			
			
			
			
			
			
			/*if(it.getType() == Material.RED_BED) {
				

				
				ByteArrayDataOutput out = ByteStreams.newDataOutput();
				out.writeUTF("Connect");
				out.writeUTF("lobby");
				player.sendPluginMessage(main, "BungeeCord", out.toByteArray());
			}*/
			
			
			
			
			
			
			if(it.getType() == Material.NETHER_STAR) {
				Inventory inv2 = Bukkit.createInventory(null, 45, "§5Choix du kit");
				
				
				int emplacement = 0;

                for (Kit kit : main.list_kits) {

                    ItemStack customironsword = new ItemStack(kit.getItemSelection().getType(),1);
                    ItemMeta customIS = customironsword.getItemMeta();
                    customIS.setDisplayName("§5Kit "+ kit.getNom());
                    customIS.setLore(kit.getDescription());
                    customironsword.setItemMeta(customIS);

                    inv2.setItem(emplacement, customironsword);
                    emplacement++;
                }
				
				
				
				player.openInventory(inv2);
				
			}
			
			
			if(it.getType() == Material.GUNPOWDER) {
				World world = player.getWorld();
				world.createExplosion(player.getLocation(), 7, false, false);
			}
			
			if(it.getType() == Material.FIRE_CHARGE) {
				Fireball f = player.launchProjectile(Fireball.class);
				f.setIsIncendiary(false);
				f.setVelocity(f.getVelocity().multiply(50));
				f.setBounce(false);
				player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			}
			

				if(it.getType() == Material.BLAZE_POWDER &&  event.getAction()==Action.RIGHT_CLICK_BLOCK ) {
				
					if (joueur.getEquipe() != main.Equipe_bleu  && (main.map_en_cours.getLocationTntArray(1).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(1).getX()-3)  && (main.map_en_cours.getLocationTntArray(1).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(1).getZ()-3) ) {
						
						if (main.tnt_bleu.getEtat()==EtatTNT.Eteinte) {
							
							if (main.tnt_bleu.getVie()<main.Avancement_Max_Global_TNT && event.getClickedBlock().getType() == Material.TNT) {
								main.tnt_bleu.setVie(main.tnt_bleu.getVie()+1);
								//Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
			
								
								if(main.tnt_bleu.getVie() ==main.Avancement_Max_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §9bleue §ea été allumée!");
									main.tnt_bleu.setEtat(EtatTNT.Allume);
									TimerAllumage start = new TimerAllumage(main,"Bleu");
									start.runTaskTimer(main, 0, 20);
								}
							}
						}
					}
				}
				
				
				
				
				if (it.getType() == Material.FEATHER && event.getAction()==Action.RIGHT_CLICK_BLOCK) {
					
					if (main.tnt_bleu.getEtat()==EtatTNT.Allume && joueur.getEquipe() == main.Equipe_bleu && (main.map_en_cours.getLocationTntArray(1).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(1).getX()-3)  && (main.map_en_cours.getLocationTntArray(1).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(1).getZ()-3) ){
						
						if (main.tnt_bleu.getVie()>0 && event.getClickedBlock().getType() == Material.TNT) {
							main.tnt_bleu.setVie(main.tnt_bleu.getVie()-1);
							//Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
						
							if(main.tnt_bleu.getVie() ==0) {
								Bukkit.broadcastMessage("§6[§eTntWars§6] §eLa TNT §9bleue §ea été étteinte.");
								main.tnt_bleu.setEtat(EtatTNT.Eteinte);
							}
						}
					}
				}
				
			
			
			
				if(it.getType() == Material.BLAZE_POWDER && event.getAction()==Action.RIGHT_CLICK_BLOCK   ) {
				
				  
				
					if (joueur.getEquipe() != main.Equipe_rouge && (main.map_en_cours.getLocationTntArray(0).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(0).getX()-3)  && (main.map_en_cours.getLocationTntArray(0).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(0).getZ()-3)  ) {
						
						
						if (main.tnt_rouge.getEtat()==EtatTNT.Eteinte) {
							if (main.tnt_rouge.getVie()<main.Avancement_Max_Global_TNT && event.getClickedBlock().getType() == Material.TNT) {
								main.tnt_rouge.setVie(main.tnt_rouge.getVie()+1);
								//Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
							
								if(main.tnt_rouge.getVie() ==main.Avancement_Max_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §crouge §ea été allumée!");
									main.tnt_rouge.setEtat(EtatTNT.Allume);
									TimerAllumage start = new TimerAllumage(main,"Rouge");
									start.runTaskTimer(main, 0, 20);
								}
							}
						}
					}
				}
				
				
				
				if (it.getType() == Material.FEATHER && event.getAction()==Action.RIGHT_CLICK_BLOCK  ) {
					
					
					if (main.tnt_rouge.getEtat()==EtatTNT.Allume && joueur.getEquipe() == main.Equipe_rouge &&  (main.map_en_cours.getLocationTntArray(0).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(0).getX()-3)  && (main.map_en_cours.getLocationTntArray(0).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(0).getZ()-3)) {
						if (main.tnt_rouge.getVie()>0 && event.getClickedBlock().getType() == Material.TNT) {
							main.tnt_rouge.setVie(main.tnt_rouge.getVie()-1);
							//Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
						
							if(main.tnt_rouge.getVie() ==0) {
								Bukkit.broadcastMessage("§6[§eTntWars§6] §eLa TNT §crouge §ea été étteinte.");
								main.tnt_rouge.setEtat(EtatTNT.Eteinte);
							}
						}
					}
				}
				
				if(it.getType() == Material.BLAZE_POWDER && joueur.getEquipe() != main.Equipe_jaune && event.getAction()==Action.RIGHT_CLICK_BLOCK && main.map_en_cours.getNbEquipe()>=4) {
					
					  
					
					if (event.getClickedBlock().getType() == Material.TNT && (main.map_en_cours.getLocationTntArray(3).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(3).getX()-3)  && (main.map_en_cours.getLocationTntArray(3).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(3).getZ()-3)  ) {
						
						
						if (main.tnt_jaune.getEtat()==EtatTNT.Eteinte) {
							if (main.tnt_jaune.getVie()<main.Avancement_Max_Global_TNT) {
								main.tnt_jaune.setVie(main.tnt_jaune.getVie()+1);
							
								if(main.tnt_jaune.getVie() ==main.Avancement_Max_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §cjaune §ea été allumée!");
									main.tnt_jaune.setEtat(EtatTNT.Allume);
									//TimerAllumageYellow start = new TimerAllumageYellow(main);
									//start.runTaskTimer(main, 0, 20);
								}
							}
						}
					}
				}
				
				
				
				if (it.getType() == Material.FEATHER && joueur.getEquipe() == main.Equipe_jaune && main.map_en_cours.getNbEquipe()>=4) {
					
					
					if (main.tnt_jaune.getEtat()==EtatTNT.Allume && event.getAction()==Action.RIGHT_CLICK_BLOCK &&  (main.map_en_cours.getLocationTntArray(3).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(3).getX()-3)  && (main.map_en_cours.getLocationTntArray(3).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(3).getZ()-3)) {
						if (main.tnt_jaune.getVie()>0) {
							main.tnt_jaune.setVie(main.tnt_jaune.getVie()-1);
						
							if(main.tnt_jaune.getVie() ==0) {
								Bukkit.broadcastMessage("§6[§eTntWars§6] §eLa TNT §cjaune §ea été étteinte.");
								main.tnt_jaune.setEtat(EtatTNT.Eteinte);
							}
						}
					}
				}
			
			
				if(it.getType() == Material.BLAZE_POWDER && joueur.getEquipe() != main.Equipe_vert && event.getAction()==Action.RIGHT_CLICK_BLOCK && main.map_en_cours.getNbEquipe()>=3) {
					
					  
					
					if (event.getClickedBlock().getType() == Material.TNT && (main.map_en_cours.getLocationTntArray(2).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(2).getX()-3)  && (main.map_en_cours.getLocationTntArray(2).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(2).getZ()-3)  ) {
						
						
						if (main.tnt_vert.getEtat()==EtatTNT.Eteinte) {
							if (main.tnt_vert.getVie()<main.Avancement_Max_Global_TNT) {
								main.tnt_vert.setVie(main.tnt_vert.getVie()+1);
							
								if(main.tnt_vert.getVie() ==main.Avancement_Max_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §cjaune §ea été allumée!");
									main.tnt_vert.setEtat(EtatTNT.Allume);
									//TimerAllumageGreen start = new TimerAllumageGreen(main);
									//start.runTaskTimer(main, 0, 20);
								}
							}
						}
					}
				}
				
				
				
				if (it.getType() == Material.FEATHER && joueur.getEquipe() == main.Equipe_vert && main.map_en_cours.getNbEquipe()>=3) {
					
					
					if (main.tnt_vert.getEtat()==EtatTNT.Allume && event.getAction()==Action.RIGHT_CLICK_BLOCK &&  (main.map_en_cours.getLocationTntArray(2).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(2).getX()-3)  && (main.map_en_cours.getLocationTntArray(2).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(2).getZ()-3)) {
						if (main.tnt_vert.getVie()>0) {
							main.tnt_vert.setVie(main.tnt_vert.getVie()-1);
						
							if(main.tnt_vert.getVie() ==0) {
								Bukkit.broadcastMessage("§6[§eTntWars§6] §eLa TNT §cjaune §ea été étteinte.");
								main.tnt_vert.setEtat(EtatTNT.Eteinte);
							}
						}
					}
				}

				if (it.getType() == Material.AMETHYST_SHARD && joueur.getKit()==main.list_kits.get(IndexKit.Savior)) {
					if(joueur.getEquipe()==main.Equipe_bleu) {
						if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_SHARD) {
							player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			            };
						player.teleport(main.map_en_cours.getLocationSpawnEquipeArray(1));
					}
					if(joueur.getEquipe()==main.Equipe_rouge) {
						if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_SHARD) {
							player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			            }
						player.teleport(main.map_en_cours.getLocationSpawnEquipeArray(0));
					}
					
				}
				
				
				if (it.getType() == Material.BLACK_BANNER && joueur.getKit()==main.list_kits.get(IndexKit.Ninja)) {
					player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
					TimerInvisibility start = new TimerInvisibility(main,player);
					start.runTaskTimer(main, 0, 20);
				}
			    
			
				
				
			
			
				
				
				
			
				
				
				
				
				
				
					
			
				
			
			
			
				

		    
			
			     
				
			

			
			
			
		}
	
	
	
}
