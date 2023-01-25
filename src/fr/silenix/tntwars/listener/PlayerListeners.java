 package fr.silenix.tntwars.listener;
 
 import Enum.EtatPartie;
 import Enum.EtatTNT;
 import Fonctions.CreateWorld;
 import Fonctions.Fonctions;
import Fonctions.IndexKit;
import fr.silenix.tntwars.GMain;
 import fr.silenix.tntwars.entity.Joueur;
 import fr.silenix.tntwars.entity.Kit;
 import fr.silenix.tntwars.entity.Tnt;
 import fr.silenix.tntwars.tasks.TaskLancementPartie;
 import fr.silenix.tntwars.tasks.TaskRejoindPartieEnCours;
 import fr.silenix.tntwars.timer.TimerAllumage;
 import fr.silenix.tntwars.timer.TimerInvisibility;
 import java.util.Arrays;
 import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
 import org.bukkit.Location;
 import org.bukkit.Material;
 import org.bukkit.World;
 import org.bukkit.block.Block;
 import org.bukkit.block.BlockState;
 import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Horse;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
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
 
 
 
 
 
 
 public class PlayerListeners
   implements Listener
 {
   private GMain main;
   
   public PlayerListeners(GMain main) {
     this.main = main;
   }
 
 
   
   @EventHandler
   public void onJoin(PlayerJoinEvent event) {
     Player player = event.getPlayer();
 
     
     Joueur joueur = new Joueur(player, player.getName(), main.Sans_Equipe, main.list_kits.get(0), main.list_kits.get(0));
     main.listeConnecte.add(joueur);
 
     
     player.setInvulnerable(false);
     player.setExp(0.0F);
     player.setInvisible(false);
     
     player.setFoodLevel(20);
     player.setMaxHealth(20.0D);
     player.setHealth(20.0D);
 
     
     player.getInventory().clear();
     player.setScoreboard(main.board);
 
 
 
 
     
     if (!main.isState(EtatPartie.FinJeu)) {
       
       main.listeJoueurs.add(joueur);
       if (main.listeJoueurs.size() == 1) {
         
         main.world = ((Joueur)main.listeJoueurs.get(0)).getPlayer().getWorld();
         
         CreateWorld createWorld = new CreateWorld(main);
         createWorld.Creationworld();
       } 
 
 
 
 
 
 
 
 
 
 
 
 
       
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
         player.sendMessage("§6[§eTntWars§6] §eLe jeux a déjà démarrer mais vous pouvez rejoindre une équipe! ");
         player.teleport(main.map_en_cours.LocationSalleMort);
         event.setJoinMessage(null);
 
 
 
         ItemStack customcompasse = new ItemStack(Material.COMPASS, 1);
         ItemMeta customC2 = customcompasse.getItemMeta();
         customC2.setDisplayName("Choisir le kit");
         customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
         customC2.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
         customC2.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
         customcompasse.setItemMeta(customC2);
         player.getInventory().setItem(4, customcompasse);
 
 
         
         TaskRejoindPartieEnCours cycle = new TaskRejoindPartieEnCours(main, joueur);
         cycle.runTaskTimer((Plugin)main, 0L, 20L);
       } 
 
 
 
 
 
 
 
 
 
       
       if (main.isState(EtatPartie.AttenteJoueur) || main.isState(EtatPartie.Lancement)) {
         player.teleport(new Location(player.getWorld(), 6.0D, 1.0D, 1.0D));
         
         player.setGameMode(GameMode.ADVENTURE);
         event.setJoinMessage("§6[§eTntWars§6] §6" + player.getName() + " §evient de se connecter à la partie.   §5<§d" + main.listeJoueurs.size() + "§5/§d" + Bukkit.getMaxPlayers() + "§5>");
 
         
         if (main.isState(EtatPartie.AttenteJoueur) && main.listeJoueurs.size() >= 2) {
           
           main.setState(EtatPartie.Lancement);
           
           TaskLancementPartie start = new TaskLancementPartie(main);
           start.runTaskTimer(main, 0L, 20L);
         } 
       } 
 
 
 
 
       
       if (main.isState(EtatPartie.Prejeu)) {
         
         player.setInvisible(false);
         player.teleport(main.map_en_cours.getLocationVisite());
 
 
 
 
 
         
         player.setGameMode(GameMode.ADVENTURE);
         event.setJoinMessage("§6[§eTntWars§6] §6" + player.getName() + " §evient de se connecter à la partie.   §5<§d" + main.listeJoueurs.size() + "§5/§d" + Bukkit.getMaxPlayers() + "§5>");
       } 
     } 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     if (main.isState(EtatPartie.FinJeu)) {
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
     
     
     for(Entity entity : joueur.getPlayer().getWorld().getEntities()) {
			if(entity instanceof Wolf) {
				Wolf wolf = (Wolf) entity;
				if(wolf.getOwner() != null) {
					if(wolf.getOwner().getName() == joueur.getPlayer().getName()) {
						wolf.setTarget(joueur.getPlayer());
						
					}
				}
				
			
			}
		}
     
     main.listeJoueurs.remove(joueur);
     main.listeConnecte.remove(joueur);
     player.setPlayerListName(player.getName());
     event.setQuitMessage(String.valueOf(player.getName()) + " est partie.");
 
     
     boolean stillPlayer = Fonctions.stillPlayer(main, joueur.getEquipe().getCouleur());
     if (!stillPlayer) {
       Tnt tnt = main.listTnt.stream()
         .filter(t -> t.getEquipe().getCouleur().equals(joueur.getEquipe().getCouleur()))
         .findFirst()
         .get();
       
       tnt.setEtat(EtatTNT.Explose);
     } 
     if (main.isState(EtatPartie.JeuEnCours)) {
    	 main.CheckWin();
     }
     
   }
 
 
   
   @EventHandler
   public void onPlace(BlockPlaceEvent event) {
     BlockState block_replaced = event.getBlockReplacedState();
     Block block_placed = event.getBlock();
     Block block_against = event.getBlockAgainst();
     Player player = event.getPlayer();
     
     Joueur joueur = main.listeJoueurs.stream()
       .filter(p -> player.getName().equals(p.getNom()))
       .findAny()
       .orElse(null);
     
     if (!main.isState(EtatPartie.JeuEnCours)) {
       event.setCancelled(true);
       return;
     } 
     if (main.AllowBlockPoserCasser.contains(block_placed.getType())) {
       if (block_replaced.getType() != Material.AIR) {
         event.setCancelled(true);
         return;
       } 
       if (main.ListWool.contains(block_placed.getType()) && 
         joueur.getEquipe().getLaine() == block_placed.getType() && 
         main.ListTacticien.contains(block_against.getType()) && 
         block_against.getType() != joueur.getEquipe().getBlockTactique()) {
         event.setCancelled(true);
         
         return;
       } 
       
       return;
     } 
     
     event.setCancelled(true);
   }
 
 
 
   
   @EventHandler
   public void onBreak(BlockBreakEvent event) {
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
     Player player = (Player)event.getWhoClicked();
     
     Joueur joueur = main.listeJoueurs.stream()
       .filter(p -> player.getName().equals(p.getPlayer().getName()))
       .findAny()
       .orElse(null);
 
 
     
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
 
 
       
       Kit kit = main.list_kits.stream()
         .filter(k -> k.getItemSelection().getType().equals(current.getType()))
         .findFirst()
         .get();
 
       
       joueur.setProchainKit(kit);
       player.sendMessage("§6[§eTntWars§6] §eKit " + kit.getNom() + " sélectionné");
       player.closeInventory();
     } 
   }
 
 
 
 
 
   
   @EventHandler
   public void onInteractEntity(PlayerInteractEntityEvent event) {
     if (event.getRightClicked() instanceof Player) {
       
       Player player = event.getPlayer();
       Player victim = (Player)event.getRightClicked();
       
       Joueur joueur = main.listeJoueurs.stream()
         .filter(p -> player.getName().equals(p.getNom()))
         .findAny()
         .orElse(null);
       Joueur joueur_victime = main.listeJoueurs.stream()
         .filter(p -> victim.getName().equals(p.getNom()))
         .findAny()
         .orElse(null);
 
 
       
       if (joueur.getEquipe() == joueur_victime.getEquipe())
       {
         if (player.getInventory().getItemInMainHand().getType() == Material.GLISTERING_MELON_SLICE) {
           if (joueur_victime.getKit() != main.list_kits.get(3)) {
             if (joueur_victime.getPlayer().getHealth() > (joueur_victime.getKit().getPointVie() - 3.0F)) {
               victim.setHealth(joueur_victime.getKit().getPointVie());
             } else {
               victim.setHealth(victim.getHealth() + 2.0D);
             } 
           }
 
 
 
           
           return;
         } 
       }
 
 
 
       
       if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_CLUSTER) {
         player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
 
         
         main.SpawnTeleportation(joueur_victime);
 
 
         
         return;
       } 
 
 
       
       
       
       if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.INK_SAC) {



           victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20*10, 7));

           return;
       }
       
       if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.SHULKER_BOX) {



           victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20*10, 1));

           return;
       }
       
       if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.COBWEB) {



           victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20*10, 7));

           return;
       }
       
       if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.WITHER_ROSE) {



           victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20*10, 7));

           return;
       }
       
       if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.CRIMSON_FUNGUS) {



           victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20*10, 7));

           return;
       }
       
       if(((HumanEntity) player).getInventory().getItemInMainHand().getType() == Material.PUFFERFISH) {



           victim.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20*15, 8));

           return;
       }
     } 
   }
 
 
 
 
 
 
 
 
 
   
   @SuppressWarnings("deprecation")
   @EventHandler
   public void onInteract(PlayerInteractEvent event) {
     Player player = event.getPlayer();
     Player player2 = event.getPlayer();
     
     ItemStack it = event.getItem();
     Block block = event.getClickedBlock();
 
     
     Joueur joueur = main.listeJoueurs.stream()
       .filter(p -> player2.getName().equals(p.getNom()))
       .findAny()
       .orElse(null);
 
     
     if (it == null) {
       return;
     }
     
     
     if(it.getType() == Material.SADDLE){
    	 
         if(joueur.getKit() == main.list_kits.get(IndexKit.Chevalier))
         {
        	 
        	 Horse horsebrown = (Horse) player.getWorld().spawn(player.getLocation(), Horse.class);
	         horsebrown.setAdult();
	         horsebrown.setTamed(true);
	         horsebrown.setOwner(player);
	         horsebrown.getInventory().setSaddle(new ItemStack(Material.SADDLE));
	         horsebrown.setCustomName(joueur.getEquipe().getColor() + "Horse");
	         horsebrown.setPassenger(player);
         }
         
         if(joueur.getKit() == main.list_kits.get(IndexKit.PigRider))
         {
        	 
        	 Pig pig = (Pig) player.getWorld().spawn(player.getLocation(), Pig.class);
        	 pig.setAdult();
        	 pig.setSaddle(true);
        	 pig.setCustomName(joueur.getEquipe().getColor() + "Pig");
        	 pig.setPassenger(player);
         }
         
         
     }
     
     
     
     
     if(it.getType() == Material.BONE){
        
         
         Wolf wolf = (Wolf) player.getWorld().spawn(player.getLocation(), Wolf.class);
         wolf.setAdult();
         wolf.setTamed(true);
         wolf.setOwner(player);
         
         
         //wolf.getInventory().setSaddle(new ItemStack(Material.SADDLE));
         wolf.setCustomName("Loup");
         
         
         
         
         if (player.getInventory().getItemInMainHand().getType() == Material.BONE) {
             player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
          }
     }
     
     
     
     
     if (it.getType() == Material.COMPASS) {
 
       
       Inventory inv = Bukkit.createInventory(null, 27, "§7Choix d'équipe");
       
       ItemStack customwoolteamblue = new ItemStack(Material.BLUE_WOOL, 1);
       ItemMeta customWTB = customwoolteamblue.getItemMeta();
       customWTB.setDisplayName("Rejoindre l'§quipe bleu");
 
       
       customWTB.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
       customwoolteamblue.setItemMeta(customWTB);
 
 
 
 
 
       
       ItemStack customwoolteamred = new ItemStack(Material.RED_WOOL, 1);
       ItemMeta customWTR = customwoolteamred.getItemMeta();
       customWTR.setDisplayName("Rejoindre l'§quipe rouge");
 
       
       customWTR.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
       customwoolteamred.setItemMeta(customWTR);
       inv.setItem(11, customwoolteamred);
       inv.setItem(14, customwoolteamblue);
 
 
       
       player.openInventory(inv);
     } 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     if (it.getType() == Material.NETHER_STAR) {
       Inventory inv2 = Bukkit.createInventory(null, 45, "§5Choix du kit");
 
       
       int emplacement = 0;
       
       for (Kit kit : main.list_kits) {
         
         ItemStack customironsword = new ItemStack(kit.getItemSelection().getType(), 1);
         ItemMeta customIS = customironsword.getItemMeta();
         customIS.setDisplayName("§5Kit " + kit.getNom());
         customIS.setLore(kit.getDescription());
         customironsword.setItemMeta(customIS);
         
         inv2.setItem(emplacement, customironsword);
         emplacement++;
       } 
 
 
 
 
       
       player.openInventory(inv2);
     } 
 
 
     
     if (it.getType() == Material.GUNPOWDER) {
       World world = player.getWorld();
       world.createExplosion(player.getLocation(), 7.0F, false, false);
     } 
     
     if (it.getType() == Material.FIRE_CHARGE) {
       Fireball f = (Fireball)player.launchProjectile(Fireball.class);
       f.setIsIncendiary(false);
       f.setVelocity(f.getVelocity().multiply(150));
       f.setBounce(false);

       player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
     } 
 
 
 
 
 
 
 
 
 
 
     
     if (it.getType() == Material.BLAZE_POWDER)
     {
       
       if (event.getClickedBlock().getType() == Material.TNT && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
         
         Tnt tnt = main.listTnt.stream()
           .filter(t -> t.getLocation().equals(block.getLocation()))
           .findFirst()
           .get();
 
 
         
         if (joueur.getEquipe() != tnt.getEquipe())
         {
           if (tnt.getEtat() == EtatTNT.Eteinte)
           {
             if (tnt.getVie() < main.Avancement_Max_Global_TNT) {
               tnt.setVie(tnt.getVie() + 1);
 
 
               
               if (tnt.getVie() == main.Avancement_Max_Global_TNT) {
                 Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT " + tnt.getEquipe().getCouleur() + " §ea été allumée!");
                 tnt.setEtat(EtatTNT.Allume);
                 TimerAllumage start = new TimerAllumage(main, tnt.getEquipe().getCouleur());
                 start.runTaskTimer((Plugin)main, 0L, 20L);
               } 
             } 
           }
         }
       } 
     }
 
 
 
 
 
     
     if (it.getType() == Material.FEATHER)
     {
       if (event.getClickedBlock().getType() == Material.TNT && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
         
         Tnt tnt = main.listTnt.stream()
           .filter(t -> t.getLocation().equals(block.getLocation()))
           .findFirst()
           .get();
 
         
         if (tnt.getEtat() == EtatTNT.Allume && joueur.getEquipe() == tnt.getEquipe())
         {
           if (tnt.getVie() > 0) {
             tnt.setVie(tnt.getVie() - 1);
 
             
             if (tnt.getVie() == 0) {
               Bukkit.broadcastMessage("§6[§eTntWars§6] §eLa TNT " + tnt.getEquipe().getCouleur() + " §ea été étteinte.");
               tnt.setEtat(EtatTNT.Eteinte);
             } 
           } 
         }
       } 
     }
 
 
 
 
 
 
     //TODO FACTEUR
     if (it.getType() == Material.AMETHYST_SHARD && joueur.getKit() == main.list_kits.get(6)) {
       if (joueur.getEquipe() == main.Equipe_bleu) {
         if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_SHARD) {
           player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
         }
         player.teleport(main.map_en_cours.getLocationSpawnEquipeArray(1));
       } 
       if (joueur.getEquipe() == main.Equipe_rouge) {
         if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_SHARD) {
           player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
         }
         player.teleport(main.map_en_cours.getLocationSpawnEquipeArray(0));
       } 
     } 
 
 
     
     if (it.getType() == Material.BLACK_BANNER && joueur.getKit() == main.list_kits.get(5)) {
       player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
       TimerInvisibility start = new TimerInvisibility(main, player);
       start.runTaskTimer((Plugin)main, 0L, 20L);
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
 
 
     
     Joueur joueur = main.listeJoueurs.stream()
       .filter(p -> pl.getName().equals(p.getPlayer().getName()))
       .findAny()
       .orElse(null);
     
     Location l = pl.getLocation();
     Block under = (new Location(pl.getWorld(), l.getX(), l.getY() - 1.0D, l.getZ())).getBlock();
 
     
     if (main.ListTacticien.contains(under.getType()) && 
       joueur.getEquipe().getBlockTactique() != under.getType()) {
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
       if(e.getExited() instanceof Player) {
           
           if(e.getVehicle() instanceof Horse) {
               Horse horse = (Horse) e.getVehicle();
              
               horse.remove();
                   
                  
           }
           
           if(e.getVehicle() instanceof Pig) {
               Pig pig = (Pig) e.getVehicle();
              
               pig.remove();
                   
                  
           }
       }
   }
 
   
   @EventHandler
   public void onBlockDamage(BlockDamageEvent event) {
     Block block = event.getBlock();
     Player player = event.getPlayer();
     
     Joueur joueur = main.listeJoueurs.stream()
       .filter(p -> player.getName().equals(p.getPlayer().getName()))
       .findAny()
       .orElse(null);
     
     if (main.ListTacticien.contains(block.getType()))
     {
       
       event.setInstaBreak(true);
     }
   }
 }


