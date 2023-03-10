package fr.silenix.tntwars.listener;

import Enum.EtatPartie;
import Enum.EtatTNT;
import Fonctions.CreateWorld;
import Fonctions.Fonctions;
import Fonctions.IndexKit;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.Bdd.RequeteSql;
import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.entity.Kit;
import fr.silenix.tntwars.entity.Tnt;
import fr.silenix.tntwars.tasks.TaskLancementPartie;
import fr.silenix.tntwars.tasks.TaskRejoindPartieEnCours;
import fr.silenix.tntwars.timer.TimerAllumage;
import fr.silenix.tntwars.timer.TimerInvisibility;
import fr.silenix.tntwars.timer.TimerRocket;
import fr.silenix.tntwars.timer.TimerSpell;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Horse;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListeners implements Listener {

	private GMain main;

	public PlayerListeners(GMain main) {
		this.main = main;
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();

		RequeteSql requete = new RequeteSql(main);
		int money = requete.GetMoneyJoueur(player.getName());
		
		Joueur joueur = new Joueur(player, player.getName(), main.Sans_Equipe, main.list_kits.get(0),
				main.list_kits.get(0), money);
		Bukkit.broadcastMessage(joueur.getNom() + "     money =  "+ money);
		main.listeConnecte.add(joueur);
		
		if (main.listeConnecte.size() == 1 && main.isfirstJoueur) {

			main.world = ((Joueur) main.listeConnecte.get(0)).getPlayer().getWorld();

			CreateWorld createWorld = new CreateWorld(main);
			createWorld.Creationworld();
			main.isfirstJoueur = false;
		}
		
		player.teleport(new Location(player.getWorld(), -828.0D, 76.0D, -321.0D, -90, 0));

		player.setGameMode(GameMode.ADVENTURE);
		
		joueur.getPlayer().setFlying(false);
		joueur.getPlayer().setAllowFlight(false);
		
		
		
		
		main.CheckWin();

		player.setInvulnerable(false);
		player.setExp(0.0F);
		player.setInvisible(false);

		player.setFoodLevel(20);
		player.setMaxHealth(20.0D);
		player.setHealth(20.0D);

		player.getInventory().clear();
		player.setScoreboard(main.board);
 
		event.setJoinMessage(null);
		
		
		ItemStack customnWHITE_BANNER = new ItemStack(Material.WHITE_BANNER, 1);
		ItemMeta customWB = customnWHITE_BANNER.getItemMeta();
		customWB.setDisplayName("Rejoindre la partie");
		customWB.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
		customWB.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		customWB.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
		customnWHITE_BANNER.setItemMeta(customWB);
		player.getInventory().setItem(0, customnWHITE_BANNER);

		

	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		Joueur joueur = main.listeConnecte.stream().filter(p -> player.getName().equals(p.getNom())).findAny()
				.orElse(null);

		main.DeleteAnimals(joueur);
		
		main.deletejoueurscoreboard(joueur, joueur.getEquipe());

		if (main.listeJoueurs.contains(joueur)) {
			main.listeJoueurs.remove(joueur);
		}
		main.listeConnecte.remove(joueur);
		
		player.setPlayerListName(player.getName());
		event.setQuitMessage("??5[??d-??5] ??d" + player.getName());

		if (joueur.getEquipe() != main.Sans_Equipe) {
			boolean stillPlayer = Fonctions.stillPlayer(main, joueur.getEquipe().getCouleur());
			if (!stillPlayer) {
				Tnt tnt = main.listTnt.stream()
						.filter(t -> t.getEquipe().getCouleur().equals(joueur.getEquipe().getCouleur())).findFirst()
						.get();

				tnt.setEtat(EtatTNT.Explose);
			}
		}

		/*if (main.isState(EtatPartie.JeuEnCours)) {
			main.CheckWin();
		}*/
		if(Bukkit.getOnlinePlayers().size() > 0) {
			main.CheckWin();
		}
		if(Bukkit.getOnlinePlayers().size() == 0) {
			main.remiseazero();
		}
		
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		BlockState block_replaced = event.getBlockReplacedState();
		Block block_placed = event.getBlock();
		Block block_against = event.getBlockAgainst();
		Player player = event.getPlayer();

		Joueur joueur = main.listeConnecte.stream().filter(p -> player.getName().equals(p.getNom())).findAny()
				.orElse(null);

		if(!main.listeJoueurs.contains(joueur)) {
			if(main.list_joueur_casser_poser.contains(joueur.getPlayer().getName())){
				return;
			}
		}
		
		if (!main.isState(EtatPartie.JeuEnCours)) {
			event.setCancelled(true);
			return;
		}
		if (main.AllowBlockPoserCasser.contains(block_placed.getType())) {
			if (block_replaced.getType() != Material.AIR) {
				event.setCancelled(true);
				return;
			}
			if (main.ListWool.contains(block_placed.getType())
					&& joueur.getEquipe().getLaine() == block_placed.getType()
					&& main.ListTacticien.contains(block_against.getType())
					&& block_against.getType() != joueur.getEquipe().getBlockTactique()) {
				event.setCancelled(true);

				return;
			}

			return;
		}

		event.setCancelled(true);
	}

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		
		Player player = event.getPlayer();

		Joueur joueur = main.listeConnecte.stream().filter(p -> player.getName().equals(p.getNom())).findAny()
				.orElse(null);
		
		if(!main.listeJoueurs.contains(joueur)) {
			if(main.list_joueur_casser_poser.contains(joueur.getPlayer().getName())){
				return;
			}
		}
		
		if (!main.isState(EtatPartie.JeuEnCours)) {
			event.setCancelled(true);
			return;
		}
		if (main.AllowBlockPoserCasser.contains(event.getBlock().getType())) {
			return;
		}
		event.setCancelled(true);
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		Inventory inv = event.getInventory();
		Player player = (Player) event.getWhoClicked();

		Joueur joueur = main.listeJoueurs.stream().filter(p -> player.getName().equals(p.getPlayer().getName()))
				.findAny().orElse(null);

		ItemStack current = event.getCurrentItem();

		if (current == null)
			return;
		if (inv.contains(Material.RED_WOOL)) {
			if (current.getType() == Material.RED_WOOL) {
				player.closeInventory();
				main.RejoindEquipe(joueur, main.Equipe_rouge, main.map_en_cours.getNbEquipe());
			} else if (current.getType() == Material.BLUE_WOOL) {
				player.closeInventory();
				main.RejoindEquipe(joueur, main.Equipe_bleu, main.map_en_cours.getNbEquipe());
			}
		}

		if (inv.contains(Material.HEART_OF_THE_SEA) && inv.contains(Material.BEACON)) {

			Kit kit = main.list_kits.stream().filter(k -> k.getItemSelection().getType().equals(current.getType()))
					.findFirst().get();

			joueur.setProchainKit(kit);
			player.sendMessage(Constante.Constantes.PluginName + "Kit " + kit.getNom() + " s??lectionn??");
			player.closeInventory();
		}
	}

	@EventHandler
	public void onInteractEntity(PlayerInteractEntityEvent event) {
		if (event.getRightClicked() instanceof Player) {

			Player player = event.getPlayer();
			Player victim = (Player) event.getRightClicked();

			Joueur joueur = main.listeJoueurs.stream().filter(p -> player.getName().equals(p.getNom())).findAny()
					.orElse(null);
			Joueur joueur_victime = main.listeJoueurs.stream().filter(p -> victim.getName().equals(p.getNom()))
					.findAny().orElse(null);
			
			
			if (!main.listeJoueurs.contains(joueur_victime) || !main.listeJoueurs.contains(joueur)){
				event.setCancelled(true);
				return;
			}
			
			if (joueur.getEquipe() == joueur_victime.getEquipe()) {
				if (player.getInventory().getItemInMainHand().getType() == Material.GLISTERING_MELON_SLICE) {
					if (joueur_victime.getKit() != main.list_kits.get(IndexKit.OneShot)) {
						if (joueur_victime.getPlayer().getHealth() > (joueur_victime.getKit().getPointVie() - 3.0F)) {
							victim.setHealth(joueur_victime.getKit().getPointVie());
							victim.playSound(victim.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
							player.playSound(victim.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
						} else {
							victim.setHealth(victim.getHealth() + 2.0D);
							victim.playSound(victim.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3, 3);
							player.playSound(victim.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 3, 3);
						}
					}

					return;
				}
			}

			if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_CLUSTER) {
				player.getInventory().getItemInMainHand()
						.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);

				main.SpawnTeleportation(joueur_victime);

				return;
			}

			if (((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.INK_SAC) {

				if(!victim.hasPotionEffect(PotionEffectType.BLINDNESS)) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 10, 7));
					player.sendMessage("Vous avez aveugl?? " +  victim.getName());
					victim.sendMessage("Vous avez ??t?? aveugl??(e) par " +  player.getName());
				}
				return;
			}

			if (((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.SHULKER_BOX) {

				if(!victim.hasPotionEffect(PotionEffectType.LEVITATION)) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20 * 10, 1));
					player.sendMessage("Vous avez lanc?? un sort de l??vitation sur " + victim.getName());
					victim.sendMessage("Vous avez re??u un sort de l??vitation par " + player.getName());
				}
				
				return;
			}

			if (((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.COBWEB) {

				if(!victim.hasPotionEffect(PotionEffectType.SLOW)) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 10, 7));
					player.sendMessage("Vous avez immobilis?? " + victim.getName());
					victim.sendMessage("Vous avez ??t?? imobilis??(e) par " +  player.getName());
				}
				return;
			}

			if (((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.WITHER_ROSE) {

				if(!victim.hasPotionEffect(PotionEffectType.WITHER)) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20 * 10, 7));
					player.sendMessage("Vous avez maudit " +  victim.getName());
					victim.sendMessage("Vous avez ??t?? maudit(e) par " +  player.getName());
				}
				return;
			}

			if (((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.CRIMSON_FUNGUS) {

				if(!victim.hasPotionEffect(PotionEffectType.POISON)) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 10, 7));
					player.sendMessage("Vous avez empoisonn?? " +  victim.getName());
					victim.sendMessage("Vous avez ??t?? empoisonn??(e) par " +  player.getName());
				}
				return;
			}

			if (((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.PUFFERFISH) {

				if(!victim.hasPotionEffect(PotionEffectType.CONFUSION)) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 15, 8));
					player.sendMessage("Vous avez rendu malade " +  victim.getName());
					victim.sendMessage("Vous ??tes tomb??(e) malade ?? cause de " +  player.getName());
				}
				return;
			}
		}
	}

	/*
	 * @EventHandler public void onInter(PlayerInteractEvent e) {
	 */

	/*
	 * final BukkitScheduler scheduler = Bukkit.getScheduler();
	 * 
	 * final int task = scheduler.scheduleSyncRepeatingTask(main, new Runnable() {
	 * public void run() { //s.getWorld().playEffect(s.getLocation(), Effect.HEART,
	 * 10);
	 * 
	 * Bukkit.getWorld("world").spawnParticle(Particle.SMOKE_NORMAL,
	 * s.getLocation(), 100, 1.0D, 1.0D, 1.0D); if(s.isOnGround() || s.isDead()) {
	 * s.remove();
	 * 
	 * break; } } }, 0L, 0L);
	 * 
	 */

	// s.getWorld().playSound(s.getLocation(), Sound.ENTITY_CHICKEN_EGG, 10.0F,
	// 1.0F);

	/*
	 * scheduler.scheduleSyncDelayedTask((Plugin) this, new Runnable() { public void
	 * run() { for (int i = 0; i < 20; i++) {
	 * s.getWorld().playEffect(s.getLocation(), Effect.FLAME, 15);
	 * Bukkit.getWorld("world").spawnParticle(Particle.FLAME, s.getLocation(), 15,
	 * 1.0D, 1.0D, 1.0D); } s.remove(); scheduler.cancelTask(task); } }, 20);
	 */
	/*
	 * } }
	 */

	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		

		ItemStack it = event.getItem();
		Block block = event.getClickedBlock();

		Joueur joueur = main.listeConnecte.stream().filter(p -> player.getName().equals(p.getNom())).findAny()
				.orElse(null);

		if (it == null) {
			return;
		}
		
		
		
		if (it.getType() == Material.WHITE_BANNER) {
			
			player.getInventory().remove(Material.WHITE_BANNER);
			
			if (main.isState(EtatPartie.FinJeu)) {
				player.setGameMode(GameMode.SPECTATOR);
				Bukkit.broadcastMessage("??5[??d+??5] ??d" + player.getName());
				player.sendMessage(Constante.Constantes.PluginName + "Le jeu est termin??, une partie va bient??t recommencer !");
				player.teleport(main.map_en_cours.getLocationVisite());
			}

			if (!main.isState(EtatPartie.FinJeu)) {

				
				
				
				
				
				
				
				main.listeJoueurs.add(joueur);
				

				ItemStack customnetherstars = new ItemStack(Material.NETHER_STAR, 1);
				ItemMeta customNSs = customnetherstars.getItemMeta();
				customNSs.setDisplayName("Choisir le kit");
				customNSs.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
				customNSs.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
				customNSs.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
				customnetherstars.setItemMeta(customNSs);
				player.getInventory().setItem(0, customnetherstars);

				
				
				
				
				
				
				if (main.isState(EtatPartie.JeuEnCours)) {
					player.setGameMode(GameMode.ADVENTURE);
					player.setInvisible(true);
					player.sendMessage(Constante.Constantes.PluginName + "Le jeux a d??j?? d??marrer veuillez choisir une ??quipe pour rejoindre! ");
					player.teleport(main.map_en_cours.LocationSalleMort);
					Bukkit.broadcastMessage("??5[??d+??5] ??d" + player.getName());

					ItemStack customcompasse = new ItemStack(Material.COMPASS, 1);
					ItemMeta customC2 = customcompasse.getItemMeta();
					customC2.setDisplayName("Choisir le kit");
					customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
					customC2.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
					customC2.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
					customcompasse.setItemMeta(customC2);
					player.getInventory().setItem(4, customcompasse);

					TaskRejoindPartieEnCours cycle = new TaskRejoindPartieEnCours(main, joueur);
					cycle.runTaskTimer((Plugin) main, 0L, 20L);
				}
				
				
				
				
				

				if (main.isState(EtatPartie.AttenteJoueur) || main.isState(EtatPartie.Lancement)) {
					
					Bukkit.broadcastMessage(
							Constante.Constantes.PluginName + "" + player.getName() + " ??evient de rejoindre la partie.   ??5<??d"
									+ main.listeJoueurs.size() + "??5/??d" + Bukkit.getMaxPlayers() + "??5>");

					if (main.isState(EtatPartie.AttenteJoueur) && main.listeJoueurs.size() >= 2) {

						main.setState(EtatPartie.Lancement);

						TaskLancementPartie start = new TaskLancementPartie(main);
						start.runTaskTimer(main, 0L, 20L);
					}
				}
				
				
				
				

				if (main.isState(EtatPartie.Prejeu)) {

					player.setInvisible(false);
					player.teleport(main.map_en_cours.getLocationVisite());

					player.setGameMode(GameMode.SURVIVAL);
					
					joueur.getPlayer().setAllowFlight(true);
					joueur.getPlayer().setFlying(true);
					
					
					Bukkit.broadcastMessage(
							Constante.Constantes.PluginName + " " + player.getName() + " ??evient de rejoindre la partie.   ??5<??d"
									+ main.listeJoueurs.size() + "??5/??d" + Bukkit.getMaxPlayers() + "??5>");
				}
			}
		}
		
		
		if (it.getType() == Material.SADDLE) {
			if (!joueur.getPlayer().isInsideVehicle()) {
				if (joueur.getKit() == main.list_kits.get(IndexKit.Chevalier)) {

					Horse horsebrown = (Horse) player.getWorld().spawn(player.getLocation(), Horse.class);
					horsebrown.setAdult();
					horsebrown.setTamed(true);
					horsebrown.setOwner(player);
					horsebrown.getInventory().setSaddle(new ItemStack(Material.SADDLE));
					horsebrown.setCustomName(joueur.getEquipe().getColor() + "Horse");
					horsebrown.setPassenger(player);
				}

				if (joueur.getKit() == main.list_kits.get(IndexKit.PigRider)) {

					Pig pig = (Pig) player.getWorld().spawn(player.getLocation(), Pig.class);
					pig.setAdult();
					pig.setSaddle(true);
					pig.setCustomName("Pig");
					pig.setPassenger(player);
				}
			}

		}

		if (it.getType() == Material.GOLD_INGOT) {
			if (joueur.getKit() == main.list_kits.get(IndexKit.Pirate)) {

				Parrot parrot = (Parrot) player.getWorld().spawn(player.getLocation(), Parrot.class);
				parrot.setAdult();
				parrot.setOwner(player);
				parrot.setCustomName("Parrot");
				parrot.setLootTable(null);

			}
			if (player.getInventory().getItemInMainHand().getType() == Material.GOLD_INGOT) {
				player.getInventory().getItemInMainHand()
						.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			}
		}

		if (it.getType() == Material.BONE) {

			Wolf wolf = (Wolf) player.getWorld().spawn(player.getLocation(), Wolf.class);
			wolf.setAdult();
			wolf.setTamed(true);
			wolf.setOwner(player);

			// wolf.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			wolf.setCustomName("Loup");

			if (player.getInventory().getItemInMainHand().getType() == Material.BONE) {
				player.getInventory().getItemInMainHand()
						.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			}
		}

		if (it.getType() == Material.COMPASS) {

			Inventory inv = Bukkit.createInventory(null, 27, "??7Choix d'??quipe");

			ItemStack customwoolteamblue = new ItemStack(Material.BLUE_WOOL, 1);
			ItemMeta customWTB = customwoolteamblue.getItemMeta();
			customWTB.setDisplayName("Rejoindre l'??quipe bleu");

			customWTB.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
			customwoolteamblue.setItemMeta(customWTB);

			ItemStack customwoolteamred = new ItemStack(Material.RED_WOOL, 1);
			ItemMeta customWTR = customwoolteamred.getItemMeta();
			customWTR.setDisplayName("Rejoindre l'??quipe rouge");

			customWTR.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
			customwoolteamred.setItemMeta(customWTR);
			inv.setItem(11, customwoolteamred);
			inv.setItem(14, customwoolteamblue);

			player.openInventory(inv);
		}

		/*
		 * if (event.getItem().getType().equals(Material.LEGACY_GOLD_HOE)) { if
		 * (event.getItem().getItemMeta().getDisplayName().equals(ChatColor.RED +
		 * "Particle Wand")) { if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
		 * Set<Material> n = null; List<Block> list =
		 * event.getPlayer().getLineOfSight(n, 50); for (Block b : list) { if
		 * (b.getType() != Material.AIR) { break; }
		 * 
		 * PacketPlayOutWorldParticles packet = new
		 * PacketPlayOutWorldParticles(EnumParticle.HEART, true, b.getX(), b.getY(),
		 * b.getZ(), 0, 0, 0, 1, 1); ((CraftPlayer)
		 * e.getPlayer()).getHandle().playerConnection.sendPacket(packet); } } } }
		 */

		if (it.getType() == Material.NETHER_STAR) {
			Inventory inv2 = Bukkit.createInventory(null, 45, "??5Choix du kit");

			int emplacement = 0;

			for (Kit kit : main.list_kits) {

				ItemStack customironsword = new ItemStack(kit.getItemSelection().getType(), 1);
				ItemMeta customIS = customironsword.getItemMeta();
				customIS.setDisplayName("??5Kit " + kit.getNom());
				customIS.setLore(kit.getDescription());
				customironsword.setItemMeta(customIS);

				inv2.setItem(emplacement, customironsword);
				emplacement++;
			}

			player.openInventory(inv2);
		}

		if (it.getType() == Material.LEVER) {
			World world = player.getWorld();
			world.createExplosion(player.getLocation(), 25, false, false);
			player.sendMessage("Vous vous ??tes sacrifi?? en faisant une ??norme explosion");
			main.eliminate(player);
		}
		if (it.getType() == Material.GUNPOWDER) {
			World world = player.getWorld();
			world.createExplosion(player.getTargetBlockExact(400).getLocation(), 5, false, false);
			if (player.getInventory().getItemInMainHand().getType() == Material.GUNPOWDER) {
				player.getInventory().getItemInMainHand()
						.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			}
		}

		if (it.getType() == Material.FIRE_CHARGE) {
			Fireball f = (Fireball) player.launchProjectile(Fireball.class);
			f.setIsIncendiary(false);
			f.setVelocity(f.getVelocity().multiply(150));
			f.setBounce(false);

			player.getInventory().getItemInMainHand()
					.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
		}

		if (it.getType() == Material.END_ROD) {

			Player p = event.getPlayer();
			if ((event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& event.getItem().getType() == Material.END_ROD) {
				if (p.getInventory().contains(Material.HEART_OF_THE_SEA)) {
					final Snowball s = (Snowball) p.launchProjectile(Snowball.class);
					s.setVelocity(/* p.getLocation().getDirection().multiply(1.0D) */ s.getVelocity().multiply(1.40));
					s.setGravity(false);
					p.getInventory().remove(Material.HEART_OF_THE_SEA);
					TimerSpell start = new TimerSpell(/*main,*/ s, p);
					start.runTaskTimer((Plugin) main, 0L, 3L);

				}

			}

			/*
			 * Arrow arrow = (Arrow)player.launchProjectile(Arrow.class);
			 * 
			 * arrow.setVelocity(arrow.getVelocity().multiply(0.5)); arrow.setBounce(false);
			 * arrow.setGravity(false);
			 * 
			 * 
			 * 
			 * Bukkit.getWorld("world").spawnParticle(Particle.SMOKE_LARGE,
			 * arrow.getLocation(), 100, 1.0D, 1.0D, 1.0D);
			 * 
			 * 
			 * if(arrow.isOnGround()) { arrow.remove(); }
			 */

		}

		if (it.getType() == Material.CROSSBOW) {
			if (joueur.getKit() == main.list_kits.get(IndexKit.Rocketman)) {
				if (joueur.getPlayer().getInventory().contains(Material.HEART_OF_THE_SEA)) {
					joueur.getPlayer().getInventory().remove(Material.HEART_OF_THE_SEA);

					TimerRocket start = new TimerRocket(/*main,*/ joueur.getPlayer());
					start.runTaskTimer((Plugin) main, 0L, 20L);

				}

			}
		}

		if (it.getType() == Material.BLAZE_POWDER) {
			if (event.getClickedBlock() == null) {
				return;
			}
			if (event.getClickedBlock().getType() == Material.TNT && event.getAction() == Action.RIGHT_CLICK_BLOCK) {

				Tnt tnt = main.listTnt.stream().filter(t -> t.getLocation().equals(block.getLocation())).findFirst()
						.get();

				if (joueur.getEquipe() != tnt.getEquipe()) {
					if (tnt.getEtat() == EtatTNT.Eteinte) {
						if (tnt.getVie() < main.Avancement_Max_Global_TNT) {
							tnt.setVie(tnt.getVie() + 1);
							joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, 1, 1);

							if (tnt.getVie() == main.Avancement_Max_Global_TNT) {
								Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Attention! ??eLa TNT "
										+ tnt.getEquipe().getCouleur() + " ??ea ??t?? allum??e!");
								tnt.setEtat(EtatTNT.Allume);
								for (Joueur joueurs : main.listeJoueurs) {
									if (joueurs.getEquipe() == tnt.getEquipe()) {
										joueurs.getPlayer().sendTitle(ChatColor.DARK_RED + "TNT ALLUM??E !",
												ChatColor.RED + "30 secondes pour la d??samorcer");
									}

								}

								TimerAllumage start = new TimerAllumage(main, tnt.getEquipe().getCouleur());
								start.runTaskTimer((Plugin) main, 0L, 20L);
							}
						}
					}
				}
			}
		}

		if (it.getType() == Material.FEATHER) {

			if (event.getClickedBlock() == null) {
				return;
			}
			if (event.getClickedBlock().getType() == Material.TNT && event.getAction() == Action.RIGHT_CLICK_BLOCK) {

				Tnt tnt = main.listTnt.stream().filter(t -> t.getLocation().equals(block.getLocation())).findFirst()
						.get();

				if (tnt.getEtat() == EtatTNT.Allume && joueur.getEquipe() == tnt.getEquipe()) {
					if (tnt.getVie() > 0) {
						tnt.setVie(tnt.getVie() - 1);

						if (tnt.getVie() == 0) {
							Bukkit.broadcastMessage(
									Constante.Constantes.PluginName + "La TNT " + tnt.getEquipe().getCouleur() + " ??ea ??t?? ??teinte.");
							tnt.setEtat(EtatTNT.Eteinte);
						}
					}
				}
			}
		}

		// TODO FACTEUR
		if (it.getType() == Material.AMETHYST_SHARD && joueur.getKit() == main.list_kits.get(6)) {
			if (joueur.getEquipe() == main.Equipe_bleu) {
				if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_SHARD) {
					player.getInventory().getItemInMainHand()
							.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				}
				player.teleport(main.map_en_cours.getLocationSpawnEquipeArray(1));
			}
			if (joueur.getEquipe() == main.Equipe_rouge) {
				if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_SHARD) {
					player.getInventory().getItemInMainHand()
							.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
				}
				player.teleport(main.map_en_cours.getLocationSpawnEquipeArray(0));
			}
		}

		if (it.getType() == Material.BLACK_BANNER && joueur.getKit() == main.list_kits.get(5)) {
			player.getInventory().getItemInMainHand()
					.setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
			TimerInvisibility start = new TimerInvisibility(main, player);
			start.runTaskTimer(main, 0L, 20L);
		}
	}

	@EventHandler
	public void onTouch(InventoryMoveItemEvent event) {
		ItemStack item = event.getItem();

		if (item.getType() == Material.PLAYER_HEAD) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onTouch(PlayerMoveEvent e) {
		Player pl = e.getPlayer();

		Joueur joueur = main.listeJoueurs.stream().filter(p -> pl.getName().equals(p.getPlayer().getName())).findAny()
				.orElse(null);

		Location l = pl.getLocation();
		Block under = (new Location(pl.getWorld(), l.getX(), l.getY() - 1.0D, l.getZ())).getBlock();

		if (main.ListTacticien.contains(under.getType()) && joueur.getEquipe().getBlockTactique() != under.getType()) {
			under.setType(Material.AIR);
		}
	}

	@EventHandler
	public void onPlayerDrop(PlayerDropItemEvent event) {
		Item item = event.getItemDrop();

		if (!main.ListWool.contains(item.getItemStack().getType())) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onPLayerDismount(VehicleExitEvent e) {
		if (e.getExited() instanceof Player) {

			if (e.getVehicle() instanceof Horse) {
				Horse horse = (Horse) e.getVehicle();

				horse.remove();

			}

			if (e.getVehicle() instanceof Pig) {
				Pig pig = (Pig) e.getVehicle();

				pig.remove();

			}
		}
	}

	@EventHandler
	public void onBlockDamage(BlockDamageEvent event) {
		Block block = event.getBlock();
		//Player player = event.getPlayer();

		

		if (main.ListTacticien.contains(block.getType())) {

			event.setInstaBreak(true);
		}
	}
}
