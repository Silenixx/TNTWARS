package fr.silenix.tntwars.listener;

import java.util.Arrays;



import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import Enum.EtatPartie;
import Enum.EtatTNT;
import fr.silenix.tntwars.main;
import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.tasks.TaskLancementPartie;
import fr.silenix.tntwars.timer.TimerAllumageBlue;
import fr.silenix.tntwars.timer.TimerAllumageRed;

//import fr.silenix.tntwars.entity.Joueur;


public class PlayerListeners implements Listener{
	
	private main main;


	public PlayerListeners(main main) {
		this.main = main;
	}
	
	
	 @EventHandler
     public void onPlayerJoin(PlayerJoinEvent event) {
		 
		 Player player = event.getPlayer();
		 Joueur joueur = new Joueur(player,main.Sans_Equipe,main.Sans_Kit);
		
		  
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
		@EventHandler
		public void onInteract(PlayerInteractEvent event) {
			
			Player player = event.getPlayer();
			//Action action = event.getAction();
			ItemStack it = event.getItem();
			Block block = event.getClickedBlock();
			
			
			Joueur joueur = main.listeJoueurs.stream()
					  .filter(p -> player.getName().equals(p.getPlayer().getName()))
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
			
			
			
			
			
			
			
			
			
			
				if(it.getType() == Material.BLAZE_POWDER && joueur.getEquipe() != main.Equipe_bleu && event.getAction()==Action.RIGHT_CLICK_BLOCK ) {
				
				
				
				
				
					if ((main.map_en_cours.getLocationTntArray(1).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(1).getX()-3)  && (main.map_en_cours.getLocationTntArray(1).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(1).getZ()-3) && event.getClickedBlock().getType() == Material.TNT ) {
						
						if (main.tnt_bleu.getEtat()==EtatTNT.Eteinte) {
							
							if (main.tnt_bleu.getVie()<main.Vie_Global_TNT) {
								main.tnt_bleu.setVie(main.tnt_bleu.getVie()+1);
			
								
								if(main.tnt_bleu.getVie() ==main.Vie_Global_TNT) {
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
						
						if (main.tnt_bleu.getVie()>0) {
							main.tnt_bleu.setVie(main.tnt_bleu.getVie()-1);
						
							if(main.tnt_bleu.getVie() ==0) {
								Bukkit.broadcastMessage("§6[§eTntWars§6] §eLa TNT §9bleue §ea été étteinte.");
								main.tnt_bleu.setEtat(EtatTNT.Eteinte);
							}
						}
					}
				}
				
			
			
			
				if(it.getType() == Material.BLAZE_POWDER && joueur.getEquipe() != main.Equipe_rouge && event.getAction()==Action.RIGHT_CLICK_BLOCK) {
				
				  
				
					if (event.getClickedBlock().getType() == Material.TNT && (main.map_en_cours.getLocationTntArray(0).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(0).getX()-3)  && (main.map_en_cours.getLocationTntArray(0).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(0).getZ()-3)  ) {
						
						
						if (main.tnt_rouge.getEtat()==EtatTNT.Eteinte) {
							if (main.tnt_rouge.getVie()<main.Vie_Global_TNT) {
								main.tnt_rouge.setVie(main.tnt_rouge.getVie()+1);
							
								if(main.tnt_rouge.getVie() ==main.Vie_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §crouge §ea été allumée!");
									main.tnt_rouge.setEtat(EtatTNT.Allume);
									TimerAllumageRed start = new TimerAllumageRed(main);
									start.runTaskTimer(main, 0, 20);
								}
							}
						}
					}
				}
				
				
				
				if (it.getType() == Material.FEATHER && joueur.getEquipe() == main.Equipe_rouge ) {
					
					
					if (main.tnt_rouge.getEtat()==EtatTNT.Allume && event.getAction()==Action.RIGHT_CLICK_BLOCK &&  (main.map_en_cours.getLocationTntArray(0).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(0).getX()-3)  && (main.map_en_cours.getLocationTntArray(0).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(0).getZ()-3)) {
						if (main.tnt_rouge.getVie()>0) {
							main.tnt_rouge.setVie(main.tnt_rouge.getVie()-1);
						
							if(main.tnt_rouge.getVie() ==0) {
								Bukkit.broadcastMessage("§6[§eTntWars§6] §eLa TNT §crouge §ea été étteinte.");
								main.tnt_rouge.setEtat(EtatTNT.Eteinte);
							}
						}
					}
				}
				
				if(it.getType() == Material.BLAZE_POWDER && joueur.getEquipe() != main.Equipe_jaune && event.getAction()==Action.RIGHT_CLICK_BLOCK) {
					
					  
					
					if (event.getClickedBlock().getType() == Material.TNT && (main.map_en_cours.getLocationTntArray(3).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(3).getX()-3)  && (main.map_en_cours.getLocationTntArray(3).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(3).getZ()-3)  ) {
						
						
						if (main.tnt_jaune.getEtat()==EtatTNT.Eteinte) {
							if (main.tnt_jaune.getVie()<main.Vie_Global_TNT) {
								main.tnt_jaune.setVie(main.tnt_jaune.getVie()+1);
							
								if(main.tnt_jaune.getVie() ==main.Vie_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §cjaune §ea été allumée!");
									main.tnt_jaune.setEtat(EtatTNT.Allume);
									//TimerAllumageYellow start = new TimerAllumageYellow(main);
									//start.runTaskTimer(main, 0, 20);
								}
							}
						}
					}
				}
				
				
				
				if (it.getType() == Material.FEATHER && joueur.getEquipe() == main.Equipe_jaune ) {
					
					
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
			
			
				if(it.getType() == Material.BLAZE_POWDER && joueur.getEquipe() != main.Equipe_vert && event.getAction()==Action.RIGHT_CLICK_BLOCK) {
					
					  
					
					if (event.getClickedBlock().getType() == Material.TNT && (main.map_en_cours.getLocationTntArray(2).getX()+3)>block.getX() && block.getX()>(main.map_en_cours.getLocationTntArray(2).getX()-3)  && (main.map_en_cours.getLocationTntArray(2).getZ()+3)>block.getZ() && block.getZ()>(main.map_en_cours.getLocationTntArray(2).getZ()-3)  ) {
						
						
						if (main.tnt_vert.getEtat()==EtatTNT.Eteinte) {
							if (main.tnt_vert.getVie()<main.Vie_Global_TNT) {
								main.tnt_vert.setVie(main.tnt_vert.getVie()+1);
							
								if(main.tnt_vert.getVie() ==main.Vie_Global_TNT) {
									Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT §cjaune §ea été allumée!");
									main.tnt_vert.setEtat(EtatTNT.Allume);
									//TimerAllumageGreen start = new TimerAllumageGreen(main);
									//start.runTaskTimer(main, 0, 20);
								}
							}
						}
					}
				}
				
				
				
				if (it.getType() == Material.FEATHER && joueur.getEquipe() == main.Equipe_vert ) {
					
					
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

			
			
				
				/*Bukkit.broadcastMessage("compteur bleu map 1="+main.compteur_tnt_bleu.size());
				Bukkit.broadcastMessage("compteur rouge map 1="+main.compteur_tnt_rouge.size());
				Bukkit.broadcastMessage("random numero 1="+main.value_random.get(0));*/
				
			
			
			
			
				
				
				
			
				
				
				
				
				
				
					
			
				
			//Location tntred = new Location(world, 16, 85, -15);
			
			
				

		    
			
			     
				
			

			
			
			
		}
	
	
	
}
