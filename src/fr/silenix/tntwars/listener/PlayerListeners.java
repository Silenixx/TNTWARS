package fr.silenix.tntwars.listener;

import java.util.Arrays;







import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
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
import fr.silenix.tntwars.GMain;

import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.tasks.TaskLancementPartie;
import fr.silenix.tntwars.tasks.TaskRejoindPartieEnCours;
import fr.silenix.tntwars.timer.TimerAllumageBlue;
import fr.silenix.tntwars.timer.TimerAllumageRed;
import fr.silenix.tntwars.timer.TimerInvisibility;

//import fr.silenix.tntwars.entity.Joueur;


public class PlayerListeners implements Listener{
	
	private GMain main;
	
	static World world = Bukkit.getWorld("world");


	public PlayerListeners(GMain main) {
		this.main = main;
	}
	
	
	 @EventHandler
     public void onJoin(PlayerJoinEvent event) {
		 Player player = event.getPlayer();
		 
		 
		 Joueur joueur = new Joueur(player,player.getName(),main.Sans_Equipe,main.Sans_Kit);
		 main.listeConnecte.add(joueur);
		 
		 
		 player.setInvulnerable(false);
		 player.setExp(0);
		 player.setInvisible(false);
		 
		 player.setFoodLevel(20);
		 player.setHealth(20);
		 

		 player.getInventory().clear();
		 
		 
		 
		 
	 
		 if(!main.isState(EtatPartie.FinJeu)) { //si le joueur rejoint la partie avant la fin du jeu on lui donne le selectionneur d'équipe
				
			 main.listeJoueurs.add(joueur);
			 	ItemStack customnetherstar = new ItemStack(Material.NETHER_STAR,1);
				ItemMeta customNS = customnetherstar.getItemMeta();
				customNS.setDisplayName("Selectionneur d'équipe");
				
				customNS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customNS.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customNS.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				customnetherstar.setItemMeta(customNS);
				player.getInventory().setItem(4,customnetherstar);
				
				
				ItemStack customcompasse = new ItemStack(Material.COMPASS,1);
				ItemMeta customC2 = customcompasse.getItemMeta();
				customC2.setDisplayName("Choisir le kit");
				
				customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customC2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customC2.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				customcompasse.setItemMeta(customC2);
				player.getInventory().setItem(8,customcompasse);
				
				
				
				
				ItemStack custombed = new ItemStack(Material.RED_BED,1);
				ItemMeta customB = custombed.getItemMeta();
				customB.setDisplayName("Retour au lobby");
				
				customB.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customB.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customB.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
				
				custombed.setItemMeta(customB);
				player.getInventory().setItem(0,custombed);
			
				
				
				
				
				if (!main.isState(EtatPartie.AttenteJoueur) && !main.isState(EtatPartie.FinJeu) && !main.isState(EtatPartie.Lancement)) {
					player.setGameMode(GameMode.ADVENTURE);
					player.setInvisible(true);
					player.sendMessage("§5[§dSilenixGames§5] §bLe jeux a déja démarrer mais vous pouvez rejoindre une équipe! ");
					event.setJoinMessage(null);
					
					
					ItemStack customcompasses = new ItemStack(Material.COMPASS,1);
					ItemMeta customC22 = customcompasses.getItemMeta();
					customC22.setDisplayName("Choisir le kit");
					
					customC22.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
					customC22.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					customC22.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
					
					customcompasses.setItemMeta(customC22);
					player.getInventory().setItem(8,customcompasses);
					
					
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
				//player.sendMessage("tu as clické sur team rouge");
				main.RejoindEquipe(joueur, main.Equipe_rouge, main.map_en_cours.getNbEquipe());
			}else if (current.getType()==Material.BLUE_WOOL) {
				player.closeInventory();
				//player.sendMessage("tu as clické sur team bleu");
				main.RejoindEquipe(joueur, main.Equipe_bleu, main.map_en_cours.getNbEquipe());
			}
		}
		
		
		
		
		if(inv.contains(Material.DIAMOND_SWORD) && inv.contains(Material.STONE_SWORD)) {
			if (current.getType()==Material.STONE_SWORD) {
				joueur.setKit(main.Tank); 
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Tank sélectionné");
				
			}
		
			if (current.getType()==Material.DIAMOND_SWORD) {
				joueur.setKit(main.Guerrier);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Guerrier sélectionné");
				
			}
			if (current.getType()==Material.BOW) {
				joueur.setKit(main.Archer);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Archer sélectionné");
				
			}
			if (current.getType()==Material.ENDER_EYE) {
				joueur.setKit(main.Ghost);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Ghost sélectionné");
				
			}
			if (current.getType()==Material.GLISTERING_MELON_SLICE) {
				joueur.setKit(main.Healer);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Healer sélectionné");
				
			}
			if (current.getType()==Material.FLINT_AND_STEEL) {
				joueur.setKit(main.Pyro);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Pyro sélectionné");
				
			}
			if (current.getType()==Material.SHEARS) {
				joueur.setKit(main.Builder);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Builder sélectionné");
				
			}
			if (current.getType()==Material.BLAZE_ROD) {
				joueur.setKit(main.Sorcier);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Sorcier sélectionné");
				
			}
			if (current.getType()==Material.POTION) {
				joueur.setKit(main.Alchimiste);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Alchimiste sélectionné");
				
			}
			if (current.getType()==Material.ENDER_PEARL) {
				joueur.setKit(main.Endermen);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit EnderMan sélectionné");
				
			}
			if (current.getType()==Material.SNOWBALL) {
				joueur.setKit(main.SnowMan);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Snowman sélectionné");
				
			}
			if (current.getType()==Material.END_CRYSTAL) {
				joueur.setKit(main.OneShot);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit OneShot sélectionné");
				
			}
			if (current.getType()==Material.BLACK_BANNER) {
				joueur.setKit(main.Ninja);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Ninja sélectionné");
				
			}
			if (current.getType()==Material.AMETHYST_SHARD) {
				joueur.setKit(main.Savior);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Savior sélectionné");
				
			}
			if (current.getType()==Material.DIAMOND_AXE) {
				joueur.setKit(main.Barbare);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Barbare sélectionné");
				
			}
			if (current.getType()==Material.TNT) {
				joueur.setKit(main.Kamikaze);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Kamikaze sélectionné");
				
			}
			if (current.getType()==Material.BONE) {
				joueur.setKit(main.DogMaster);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit DogMaster sélectionné");
				
			}
			if (current.getType()==Material.SKELETON_SKULL) {
				joueur.setKit(main.Pirate);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Pirate sélectionné");
				
			}
			if (current.getType()==Material.SADDLE) {
				joueur.setKit(main.Chevalier);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Chevalier sélectionné");
				
			}
			if (current.getType()==Material.CARROT_ON_A_STICK) {
				joueur.setKit(main.PigRider);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit PigRider sélectionné");
				
			}
			if (current.getType()==Material.TRIDENT) {
				joueur.setKit(main.Trident);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Trident sélectionné");
				
			}
			if (current.getType()==Material.ELYTRA) {
				joueur.setKit(main.Elytra);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Elytra sélectionné");
				
			}
			if (current.getType()==Material.INK_SAC) {
				joueur.setKit(main.Squid);
				player.closeInventory();
				player.sendMessage("§6[§eTntWars§6] §eKit Squid sélectionné");
				
			}
			
			
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
					if(joueur_victime.getKit()!=main.OneShot){
						if(victim.getHealth()>37.0) {
							victim.setHealth(40.0);
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
			
			
			if(it.getType() == Material.NETHER_STAR /*&& it.getItemMeta().getDisplayName().equalsIgnoreCase("Selectionneur d'équipe")*/){


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
			
			
			
			
			
			
			if(it.getType() == Material.COMPASS) {
				Inventory inv2 = Bukkit.createInventory(null, 45, "§5Choix du kit");
				
				ItemStack customironsword = new ItemStack(Material.STONE_SWORD,1);
				ItemMeta customIS = customironsword.getItemMeta();
				customIS.setDisplayName("§5Kit Tank");
				
				//customWTB.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTB.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customIS.setLore(Arrays.asList("§bArmure en diamand","§bEpée en pierre","§dCe kit n'est pas fait pour la négociation.","§dLancez vous dans le combat avec pour écraser vos enemeies"));
				
				customironsword.setItemMeta(customIS);
				
				
				
				ItemStack customdiamondsword = new ItemStack(Material.DIAMOND_SWORD,1);
				ItemMeta customDS = customdiamondsword.getItemMeta();
				customDS.setDisplayName("§5Kit Soldat");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customDS.setLore(Arrays.asList("§bArmure en fer","§bEpée en diamant","§dCe kit est fait pour les mordues de PVP.","§dVous ferez partie des combattants majeurs de votre équipe."));
				
				customdiamondsword.setItemMeta(customDS);
				
				ItemStack custombow = new ItemStack(Material.BOW,1);
				ItemMeta customBOW = custombow.getItemMeta();
				customBOW.setDisplayName("§5Kit Archer");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customBOW.setLore(Arrays.asList("§bArc enchanté","§bArmure en maille","§dLe kit archer est un soutien essentiel pour votre équipe."));
				
				custombow.setItemMeta(customBOW);
				
				
				
				ItemStack customendereye = new ItemStack(Material.ENDER_EYE,1);
				ItemMeta customEE = customendereye.getItemMeta();
				customEE.setDisplayName("§5Kit Ghost");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customEE.setLore(Arrays.asList("§bEpée en bois","§bTotalement invisible","§dLe kit Ghost vous rendra invisivle pour ","§dinfiltrer les lignes enemies. Soyez discret et assasin."));
				
				customendereye.setItemMeta(customEE);
				
				
				
				
				ItemStack customglistering_melon_slice = new ItemStack(Material.GLISTERING_MELON_SLICE,1);
				ItemMeta customBlS = customglistering_melon_slice.getItemMeta();
				customBlS.setDisplayName("§5Kit Healer");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customBlS.setLore(Arrays.asList("§bEpée en pierre","§bArmure maille","§dLe kit des medecins, utilisez-le ","§dpour soigner vos compagnons."));
				
				customglistering_melon_slice.setItemMeta(customBlS);
				
				
				
				ItemStack customflintandsteel = new ItemStack(Material.FLINT_AND_STEEL,1);
				ItemMeta customFAS = customflintandsteel.getItemMeta();
				customFAS.setDisplayName("§5Kit Pyro");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customFAS.setLore(Arrays.asList("§bEpée en pierre","§bArmure fer","§dPour les pyroman du dimanche "));
				
				customflintandsteel.setItemMeta(customFAS);
				
				
				
				ItemStack customshears = new ItemStack(Material.SHEARS,1);
				ItemMeta customSHEARS = customshears.getItemMeta();
				customSHEARS.setDisplayName("§5Kit Builder");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customSHEARS.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customshears.setItemMeta(customSHEARS);
				
				
				ItemStack customblaze = new ItemStack(Material.BLAZE_ROD,1);
				ItemMeta customSSS = customblaze.getItemMeta();
				customSSS.setDisplayName("§5Kit Sorcier");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customSSS.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customblaze.setItemMeta(customSSS);
				
				
				
				ItemStack custompotion = new ItemStack(Material.POTION,1);
				ItemMeta customPOTION = custompotion.getItemMeta();
				customPOTION.setDisplayName("§5Kit Alchimiste");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customPOTION.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				custompotion.setItemMeta(customPOTION);
				
				
				
				ItemStack customendermen = new ItemStack(Material.ENDER_PEARL,1);
				ItemMeta customENDERMEN = customendermen.getItemMeta();
				customENDERMEN.setDisplayName("§5Kit Endermen");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customENDERMEN.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customendermen.setItemMeta(customENDERMEN);
				
				
				
				ItemStack customsnowball = new ItemStack(Material.SNOWBALL,1);
				ItemMeta customSNOWBALL = customsnowball.getItemMeta();
				customSNOWBALL.setDisplayName("§5Kit Snowman");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customSNOWBALL.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customsnowball.setItemMeta(customSNOWBALL);
				
				
				
				ItemStack customendcrystal = new ItemStack(Material.END_CRYSTAL,1);
				ItemMeta customEC = customendcrystal.getItemMeta();
				customEC.setDisplayName("§5Kit Oneshot");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customEC.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customendcrystal.setItemMeta(customEC);
				
				
				
				ItemStack customninja = new ItemStack(Material.BLACK_BANNER,1);
				ItemMeta customNINJA = customninja.getItemMeta();
				customNINJA.setDisplayName("§5Kit Ninja");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customNINJA.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customninja.setItemMeta(customNINJA);
				
				
				ItemStack customamethystshard = new ItemStack(Material.AMETHYST_SHARD,1);
				ItemMeta customASHARD = customamethystshard.getItemMeta();
				customASHARD.setDisplayName("§5Kit Savior");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customASHARD.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customamethystshard.setItemMeta(customASHARD);
				
				
				
				ItemStack custombarbare = new ItemStack(Material.DIAMOND_AXE,1);
				ItemMeta customBARBARE = custombarbare.getItemMeta();
				customBARBARE.setDisplayName("§5Kit Barbare");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customBARBARE.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				custombarbare.setItemMeta(customBARBARE);
				
				
				ItemStack customtnt = new ItemStack(Material.TNT,1);
				ItemMeta customTNT = customtnt.getItemMeta();
				customTNT.setDisplayName("§5Kit Kamikaze");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customTNT.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customtnt.setItemMeta(customTNT);
				
				
				
				
				ItemStack custombone = new ItemStack(Material.BONE,1);
				ItemMeta customBONE = custombone.getItemMeta();
				customBONE.setDisplayName("§5Kit DogMaster");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customBONE.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				custombone.setItemMeta(customBONE);
				
				
				ItemStack customskeleton = new ItemStack(Material.SKELETON_SKULL,1);
				ItemMeta customSKELETON = customskeleton.getItemMeta();
				customSKELETON.setDisplayName("§5Kit Pirate");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customSKELETON.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customskeleton.setItemMeta(customSKELETON);
				
				
				ItemStack customsaddle = new ItemStack(Material.SADDLE,1);
				ItemMeta customSADDLE = customsaddle.getItemMeta();
				customSADDLE.setDisplayName("§5Kit Chevalier");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customSADDLE.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customsaddle.setItemMeta(customSADDLE);
				
				
				ItemStack custompigrider = new ItemStack(Material.CARROT_ON_A_STICK,1);
				ItemMeta customPIGRIDER = custompigrider.getItemMeta();
				customPIGRIDER.setDisplayName("§5Kit PigRider");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customPIGRIDER.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				custompigrider.setItemMeta(customPIGRIDER);
				
				
				
				ItemStack customtrident = new ItemStack(Material.TRIDENT,1);
				ItemMeta customTRIDENT = customtrident.getItemMeta();
				customTRIDENT.setDisplayName("§5Kit Trident");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customTRIDENT.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customtrident.setItemMeta(customTRIDENT);
				
				ItemStack customelytra = new ItemStack(Material.ELYTRA,1);
				ItemMeta customELYTRA = customelytra.getItemMeta();
				customELYTRA.setDisplayName("§5Kit Elytra");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customELYTRA.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customelytra.setItemMeta(customELYTRA);
				
				
				
				
				ItemStack customsquid = new ItemStack(Material.INK_SAC,1);
				ItemMeta customSQUID = customsquid.getItemMeta();
				customSQUID.setDisplayName("§5Kit Squid");
				
				//customWTR.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				//customWTR.addItemFlags(ItemFlag.HIDE_ENCHANTS);
				customSQUID.setLore(Arrays.asList("§btest","§btest","§dtest"));
				
				customsquid.setItemMeta(customSQUID);
				
				
				inv2.setItem(0, customelytra);
				inv2.setItem(1, customtrident);
				inv2.setItem(2, custompigrider);
				inv2.setItem(3, customsaddle);
				inv2.setItem(4, customskeleton);
				inv2.setItem(5, custombone);
				inv2.setItem(6, customtnt);
				inv2.setItem(7, custombarbare);
				inv2.setItem(8, customninja);
				inv2.setItem(9, custompotion);
				inv2.setItem(10, customblaze);
				inv2.setItem(11, customflintandsteel);
				inv2.setItem(12, customglistering_melon_slice);
				inv2.setItem(13, customendereye);
				inv2.setItem(14, customironsword);
				inv2.setItem(15, customdiamondsword);
				inv2.setItem(16, custombow);
				inv2.setItem(17, customshears);
				inv2.setItem(18, customendermen);
				inv2.setItem(19, customsnowball);
				inv2.setItem(20, customendcrystal);
				inv2.setItem(21, customsquid);
				inv2.setItem(22, customamethystshard);
				
				
				
				

				
				
				/*
				*/
				
				
				
				
				
				
				
				
				
				player.openInventory(inv2);
				
			}
			
			
			if(it.getType() == Material.GUNPOWDER) {
				World world = player.getWorld();
				//world.createExplosion(player.getLocation(), 6, false);
				world.createExplosion(player.getLocation(), 7, false, false);
				
			}
			
			if(it.getType() == Material.FIRE_CHARGE) {
				//world.createExplosion(player.getLocation(), 6, false);
				
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
								Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
			
								
								if(main.tnt_bleu.getVie() ==main.Avancement_Max_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §9bleue §ea été allumée!");
									main.tnt_bleu.setEtat(EtatTNT.Allume);
									TimerAllumageBlue start = new TimerAllumageBlue(main);
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
							Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
						
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
								Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
							
								if(main.tnt_rouge.getVie() ==main.Avancement_Max_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §crouge §ea été allumée!");
									main.tnt_rouge.setEtat(EtatTNT.Allume);
									TimerAllumageRed start = new TimerAllumageRed(main);
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
							Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
						
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

				if (it.getType() == Material.AMETHYST_SHARD && joueur.getKit()==main.Savior) {
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
				
				
				if (it.getType() == Material.BLACK_BANNER && joueur.getKit()==main.Ninja) {
					player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
					TimerInvisibility start = new TimerInvisibility(main,player);
					start.runTaskTimer(main, 0, 20);
				}
			    
			
				
				
			
			
				
				
				
			
				
				
				
				
				
				
					
			
				
			
			
			
				

		    
			
			     
				
			

			
			
			
		}
	
	
	
}
