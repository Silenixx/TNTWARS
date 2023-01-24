/*     */ package fr.silenix.tntwars.listener;
/*     */ 
/*     */ import Enum.EtatPartie;
/*     */ import Enum.EtatTNT;
/*     */ import Fonctions.CreateWorld;
/*     */ import Fonctions.Fonctions;
/*     */ import fr.silenix.tntwars.GMain;
/*     */ import fr.silenix.tntwars.entity.Joueur;
/*     */ import fr.silenix.tntwars.entity.Kit;
/*     */ import fr.silenix.tntwars.entity.Tnt;
/*     */ import fr.silenix.tntwars.tasks.TaskLancementPartie;
/*     */ import fr.silenix.tntwars.tasks.TaskRejoindPartieEnCours;
/*     */ import fr.silenix.tntwars.timer.TimerAllumage;
/*     */ import fr.silenix.tntwars.timer.TimerInvisibility;
/*     */ import java.util.Arrays;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockState;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Fireball;
/*     */ import org.bukkit.entity.Item;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.block.BlockBreakEvent;
/*     */ import org.bukkit.event.block.BlockDamageEvent;
/*     */ import org.bukkit.event.block.BlockPlaceEvent;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.inventory.InventoryMoveItemEvent;
/*     */ import org.bukkit.event.player.PlayerDropItemEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerListeners
/*     */   implements Listener
/*     */ {
/*     */   private GMain main;
/*     */   
/*     */   public PlayerListeners(GMain main) {
/*  60 */     this.main = main;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent event) {
/*  67 */     Player player = event.getPlayer();
/*     */ 
/*     */     
/*  70 */     Joueur joueur = new Joueur(player, player.getName(), main.Sans_Equipe, main.list_kits.get(0), main.list_kits.get(0));
/*  71 */     main.listeConnecte.add(joueur);
/*     */ 
/*     */     
/*  74 */     player.setInvulnerable(false);
/*  75 */     player.setExp(0.0F);
/*  76 */     player.setInvisible(false);
/*     */     
/*  78 */     player.setFoodLevel(20);
/*  79 */     player.setMaxHealth(20.0D);
/*  80 */     player.setHealth(20.0D);
/*     */ 
/*     */     
/*  83 */     player.getInventory().clear();
/*  84 */     player.setScoreboard(main.board);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     if (!main.isState(EtatPartie.FinJeu)) {
/*     */       
/*  92 */       main.listeJoueurs.add(joueur);
/*  93 */       if (main.listeJoueurs.size() == 1) {
/*     */         
/*  95 */         main.world = ((Joueur)main.listeJoueurs.get(0)).getPlayer().getWorld();
/*     */         
/*  97 */         CreateWorld createWorld = new CreateWorld(main);
/*  98 */         createWorld.CreationWorld();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 113 */       ItemStack customnetherstars = new ItemStack(Material.NETHER_STAR, 1);
/* 114 */       ItemMeta customNSs = customnetherstars.getItemMeta();
/* 115 */       customNSs.setDisplayName("Choisir le kit");
/* 116 */       customNSs.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
/* 117 */       customNSs.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 118 */       customNSs.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 119 */       customnetherstars.setItemMeta(customNSs);
/* 120 */       player.getInventory().setItem(0, customnetherstars);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 140 */       if (main.isState(EtatPartie.JeuEnCours)) {
/* 141 */         player.setGameMode(GameMode.ADVENTURE);
/* 142 */         player.setInvisible(true);
/* 143 */         player.sendMessage("§6[§eTntWars§6] §eLe jeux a déjà démarrer mais vous pouvez rejoindre une équipe! ");
/* 144 */         player.teleport(main.map_en_cours.LocationSalleMort);
/* 145 */         event.setJoinMessage(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 153 */         TaskRejoindPartieEnCours cycle = new TaskRejoindPartieEnCours(main, joueur);
/* 154 */         cycle.runTaskTimer((Plugin)main, 0L, 20L);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 166 */       if (main.isState(EtatPartie.AttenteJoueur) || main.isState(EtatPartie.Lancement)) {
/* 167 */         player.teleport(new Location(player.getWorld(), 6.0D, 1.0D, 1.0D));
/*     */         
/* 169 */         player.setGameMode(GameMode.ADVENTURE);
/* 170 */         event.setJoinMessage("§6[§eTntWars§6] §6" + player.getName() + " §evient de se connecter à la partie.   §5<§d" + main.listeJoueurs.size() + "§5/§d" + Bukkit.getMaxPlayers() + "§5>");
/*     */ 
/*     */         
/* 173 */         if (main.isState(EtatPartie.AttenteJoueur) && main.listeJoueurs.size() >= 2) {
/*     */           
/* 175 */           main.setState(EtatPartie.Lancement);
/*     */           
/* 177 */           TaskLancementPartie start = new TaskLancementPartie(main);
/* 178 */           start.runTaskTimer(main, 0L, 20L);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 186 */       if (main.isState(EtatPartie.Prejeu)) {
/*     */         
/* 188 */         player.setInvisible(false);
/* 189 */         player.teleport(main.map_en_cours.getLocationVisite());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 196 */         player.setGameMode(GameMode.ADVENTURE);
/* 197 */         event.setJoinMessage("§6[§eTntWars§6] §6" + player.getName() + " §evient de se connecter à la partie.   §5<§d" + main.listeJoueurs.size() + "§5/§d" + Bukkit.getMaxPlayers() + "§5>");
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     if (main.isState(EtatPartie.FinJeu)) {
/* 218 */       player.setGameMode(GameMode.SPECTATOR);
/* 219 */       player.sendMessage("§6[§eTntWars§6] §eLe jeu est terminé, revenez pour la partie suivante !");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onQuit(PlayerQuitEvent event) {
/* 232 */     Player player = event.getPlayer();
/* 233 */     Joueur joueur = main.listeJoueurs.stream()
/* 234 */       .filter(p -> player.getName().equals(p.getNom()))
/* 235 */       .findAny()
/* 236 */       .orElse(null);
/*     */     
/* 238 */     main.listeJoueurs.remove(joueur);
/* 239 */     main.listeConnecte.remove(joueur);
/* 240 */     player.setPlayerListName(player.getName());
/* 241 */     event.setQuitMessage(String.valueOf(player.getName()) + " est partie.");
/*     */ 
/*     */     
/* 244 */     boolean stillPlayer = Fonctions.stillPlayer(main, joueur.getEquipe().getCouleur());
/* 245 */     if (!stillPlayer) {
/* 246 */       Tnt tnt = main.listTnt.stream()
/* 247 */         .filter(t -> t.getEquipe().getCouleur().equals(joueur.getEquipe().getCouleur()))
/* 248 */         .findFirst()
/* 249 */         .get();
/*     */       
/* 251 */       tnt.setEtat(EtatTNT.Explose);
/*     */     } 
/*     */     
/* 254 */     main.CheckWin();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlace(BlockPlaceEvent event) {
/* 261 */     BlockState block_replaced = event.getBlockReplacedState();
/* 262 */     Block block_placed = event.getBlock();
/* 263 */     Block block_against = event.getBlockAgainst();
/* 264 */     Player player = event.getPlayer();
/*     */     
/* 266 */     Joueur joueur = main.listeJoueurs.stream()
/* 267 */       .filter(p -> player.getName().equals(p.getNom()))
/* 268 */       .findAny()
/* 269 */       .orElse(null);
/*     */     
/* 271 */     if (!main.isState(EtatPartie.JeuEnCours)) {
/* 272 */       event.setCancelled(true);
/*     */       return;
/*     */     } 
/* 275 */     if (main.AllowBlockPoserCasser.contains(block_placed.getType())) {
/* 276 */       if (block_replaced.getType() != Material.AIR) {
/* 277 */         event.setCancelled(true);
/*     */         return;
/*     */       } 
/* 280 */       if (main.ListWool.contains(block_placed.getType()) && 
/* 281 */         joueur.getEquipe().getLaine() == block_placed.getType() && 
/* 282 */         main.ListTacticien.contains(block_against.getType()) && 
/* 283 */         block_against.getType() != joueur.getEquipe().getBlockTactique()) {
/* 284 */         event.setCancelled(true);
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 292 */     event.setCancelled(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onBreak(BlockBreakEvent event) {
/* 300 */     if (!main.isState(EtatPartie.JeuEnCours)) {
/* 301 */       event.setCancelled(true);
/*     */       return;
/*     */     } 
/* 304 */     if (main.AllowBlockPoserCasser.contains(event.getBlock().getType())) {
/*     */       return;
/*     */     }
/* 307 */     event.setCancelled(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onClick(InventoryClickEvent event) {
/* 318 */     Inventory inv = event.getInventory();
/* 319 */     Player player = (Player)event.getWhoClicked();
/*     */     
/* 321 */     Joueur joueur = main.listeJoueurs.stream()
/* 322 */       .filter(p -> player.getName().equals(p.getPlayer().getName()))
/* 323 */       .findAny()
/* 324 */       .orElse(null);
/*     */ 
/*     */ 
/*     */     
/* 328 */     ItemStack current = event.getCurrentItem();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 335 */     if (current == null)
/*     */       return; 
/* 337 */     if (inv.contains(Material.RED_WOOL)) {
/* 338 */       if (current.getType() == Material.RED_WOOL) {
/* 339 */         player.closeInventory();
/* 340 */         main.RejoindEquipe(joueur, main.Equipe_rouge, main.map_en_cours.getNbEquipe());
/* 341 */       } else if (current.getType() == Material.BLUE_WOOL) {
/* 342 */         player.closeInventory();
/* 343 */         main.RejoindEquipe(joueur, main.Equipe_bleu, main.map_en_cours.getNbEquipe());
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     if (inv.contains(Material.HEART_OF_THE_SEA) && inv.contains(Material.BEACON)) {
/*     */ 
/*     */ 
/*     */       
/* 354 */       Kit kit = main.list_kits.stream()
/* 355 */         .filter(k -> k.getItemSelection().getType().equals(current.getType()))
/* 356 */         .findFirst()
/* 357 */         .get();
/*     */ 
/*     */       
/* 360 */       joueur.setProchainKit(kit);
/* 361 */       player.sendMessage("§6[§eTntWars§6] §eKit " + kit.getNom() + " sélectionné");
/* 362 */       player.closeInventory();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onInteractEntity(PlayerInteractEntityEvent event) {
/* 373 */     if (event.getRightClicked() instanceof Player) {
/*     */       
/* 375 */       Player player = event.getPlayer();
/* 376 */       Player victim = (Player)event.getRightClicked();
/*     */       
/* 378 */       Joueur joueur = main.listeJoueurs.stream()
/* 379 */         .filter(p -> player.getName().equals(p.getNom()))
/* 380 */         .findAny()
/* 381 */         .orElse(null);
/* 382 */       Joueur joueur_victime = main.listeJoueurs.stream()
/* 383 */         .filter(p -> player.getName().equals(p.getNom()))
/* 384 */         .findAny()
/* 385 */         .orElse(null);
/*     */ 
/*     */ 
/*     */       
/* 389 */       if (joueur.getEquipe() == joueur_victime.getEquipe())
/*     */       {
/* 391 */         if (player.getInventory().getItemInMainHand().getType() == Material.GLISTERING_MELON_SLICE) {
/* 392 */           if (joueur_victime.getKit() != main.list_kits.get(3)) {
/* 393 */             if (joueur_victime.getPlayer().getHealth() > (joueur_victime.getKit().getPointVie() - 3.0F)) {
/* 394 */               victim.setHealth(joueur_victime.getKit().getPointVie());
/*     */             } else {
/* 396 */               victim.setHealth(victim.getHealth() + 2.0D);
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 410 */       if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_CLUSTER) {
/* 411 */         player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
/*     */ 
/*     */         
/* 414 */         main.SpawnTeleportation(joueur);
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 423 */       if (joueur.getEquipe() != joueur_victime.getEquipe())
/*     */       {
/* 425 */         if (player.getInventory().getItemInMainHand().getType() == Material.INK_SAC) {
/*     */ 
/*     */ 
/*     */           
/* 429 */           victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 7));
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */       
/* 436 */       if (joueur.getEquipe() != joueur_victime.getEquipe())
/*     */       {
/* 438 */         if (player.getInventory().getItemInMainHand().getType() == Material.SHULKER_BOX) {
/*     */ 
/*     */ 
/*     */           
/* 442 */           victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 300, 7));
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */       
/* 449 */       if (joueur.getEquipe() != joueur_victime.getEquipe())
/*     */       {
/* 451 */         if (player.getInventory().getItemInMainHand().getType() == Material.COBWEB) {
/*     */ 
/*     */ 
/*     */           
/* 455 */           victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 7));
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */       
/* 461 */       if (joueur.getEquipe() != joueur_victime.getEquipe())
/*     */       {
/* 463 */         if (player.getInventory().getItemInMainHand().getType() == Material.WITHER_ROSE) {
/*     */ 
/*     */ 
/*     */           
/* 467 */           victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 300, 7));
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */       
/* 473 */       if (joueur.getEquipe() != joueur_victime.getEquipe())
/*     */       {
/* 475 */         if (player.getInventory().getItemInMainHand().getType() == Material.CRIMSON_FUNGUS) {
/*     */ 
/*     */ 
/*     */           
/* 479 */           victim.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 7));
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */       
/* 485 */       if (joueur.getEquipe() != joueur_victime.getEquipe())
/*     */       {
/* 487 */         if (player.getInventory().getItemInMainHand().getType() == Material.PUFFERFISH) {
/*     */ 
/*     */ 
/*     */           
/* 491 */           victim.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 300, 7));
/*     */           return;
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onInteract(PlayerInteractEvent event) {
/* 509 */     Player player = event.getPlayer();
/* 510 */     Player player2 = event.getPlayer();
/*     */     
/* 512 */     ItemStack it = event.getItem();
/* 513 */     Block block = event.getClickedBlock();
/*     */ 
/*     */     
/* 516 */     Joueur joueur = main.listeJoueurs.stream()
/* 517 */       .filter(p -> player2.getName().equals(p.getNom()))
/* 518 */       .findAny()
/* 519 */       .orElse(null);
/*     */ 
/*     */     
/* 522 */     if (it == null) {
/*     */       return;
/*     */     }
/*     */     
/* 526 */     if (it.getType() == Material.COMPASS) {
/*     */ 
/*     */       
/* 529 */       Inventory inv = Bukkit.createInventory(null, 27, "§7Choix d'équipe");
/*     */       
/* 531 */       ItemStack customwoolteamblue = new ItemStack(Material.BLUE_WOOL, 1);
/* 532 */       ItemMeta customWTB = customwoolteamblue.getItemMeta();
/* 533 */       customWTB.setDisplayName("Rejoindre l'§quipe bleu");
/*     */ 
/*     */       
/* 536 */       customWTB.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 537 */       customwoolteamblue.setItemMeta(customWTB);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 544 */       ItemStack customwoolteamred = new ItemStack(Material.RED_WOOL, 1);
/* 545 */       ItemMeta customWTR = customwoolteamred.getItemMeta();
/* 546 */       customWTR.setDisplayName("Rejoindre l'§quipe rouge");
/*     */ 
/*     */       
/* 549 */       customWTR.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 550 */       customwoolteamred.setItemMeta(customWTR);
/* 551 */       inv.setItem(11, customwoolteamred);
/* 552 */       inv.setItem(14, customwoolteamblue);
/*     */ 
/*     */ 
/*     */       
/* 556 */       player.openInventory(inv);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 579 */     if (it.getType() == Material.NETHER_STAR) {
/* 580 */       Inventory inv2 = Bukkit.createInventory(null, 45, "§5Choix du kit");
/*     */ 
/*     */       
/* 583 */       int emplacement = 0;
/*     */       
/* 585 */       for (Kit kit : main.list_kits) {
/*     */         
/* 587 */         ItemStack customironsword = new ItemStack(kit.getItemSelection().getType(), 1);
/* 588 */         ItemMeta customIS = customironsword.getItemMeta();
/* 589 */         customIS.setDisplayName("§5Kit " + kit.getNom());
/* 590 */         customIS.setLore(kit.getDescription());
/* 591 */         customironsword.setItemMeta(customIS);
/*     */         
/* 593 */         inv2.setItem(emplacement, customironsword);
/* 594 */         emplacement++;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 601 */       player.openInventory(inv2);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 606 */     if (it.getType() == Material.GUNPOWDER) {
/* 607 */       World world = player.getWorld();
/* 608 */       world.createExplosion(player.getLocation(), 7.0F, false, false);
/*     */     } 
/*     */     
/* 611 */     if (it.getType() == Material.FIRE_CHARGE) {
/* 612 */       Fireball f = (Fireball)player.launchProjectile(Fireball.class);
/* 613 */       f.setIsIncendiary(false);
/* 614 */       f.setVelocity(f.getVelocity().multiply(50));
/* 615 */       f.setBounce(false);
/* 616 */       player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 629 */     if (it.getType() == Material.BLAZE_POWDER)
/*     */     {
/*     */       
/* 632 */       if (event.getClickedBlock().getType() == Material.TNT && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
/*     */         
/* 634 */         Tnt tnt = main.listTnt.stream()
/* 635 */           .filter(t -> t.getLocation().equals(block.getLocation()))
/* 636 */           .findFirst()
/* 637 */           .get();
/*     */ 
/*     */ 
/*     */         
/* 641 */         if (joueur.getEquipe() != tnt.getEquipe())
/*     */         {
/* 643 */           if (tnt.getEtat() == EtatTNT.Eteinte)
/*     */           {
/* 645 */             if (tnt.getVie() < main.Avancement_Max_Global_TNT) {
/* 646 */               tnt.setVie(tnt.getVie() + 1);
/*     */ 
/*     */ 
/*     */               
/* 650 */               if (tnt.getVie() == main.Avancement_Max_Global_TNT) {
/* 651 */                 Bukkit.broadcastMessage("§6[§eTntWars§6] §4Attention! §eLa TNT " + tnt.getEquipe().getCouleur() + " §ea été allumée!");
/* 652 */                 tnt.setEtat(EtatTNT.Allume);
/* 653 */                 TimerAllumage start = new TimerAllumage(main, tnt.getEquipe().getCouleur());
/* 654 */                 start.runTaskTimer((Plugin)main, 0L, 20L);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 667 */     if (it.getType() == Material.FEATHER)
/*     */     {
/* 669 */       if (event.getClickedBlock().getType() == Material.TNT && event.getAction() == Action.RIGHT_CLICK_BLOCK) {
/*     */         
/* 671 */         Tnt tnt = main.listTnt.stream()
/* 672 */           .filter(t -> t.getLocation().equals(block.getLocation()))
/* 673 */           .findFirst()
/* 674 */           .get();
/*     */ 
/*     */         
/* 677 */         if (tnt.getEtat() == EtatTNT.Allume && joueur.getEquipe() == tnt.getEquipe())
/*     */         {
/* 679 */           if (tnt.getVie() > 0) {
/* 680 */             tnt.setVie(tnt.getVie() - 1);
/*     */ 
/*     */             
/* 683 */             if (tnt.getVie() == 0) {
/* 684 */               Bukkit.broadcastMessage("§6[§eTntWars§6] §eLa TNT " + tnt.getEquipe().getCouleur() + " §ea été étteinte.");
/* 685 */               tnt.setEtat(EtatTNT.Eteinte);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 698 */     if (it.getType() == Material.AMETHYST_SHARD && joueur.getKit() == main.list_kits.get(6)) {
/* 699 */       if (joueur.getEquipe() == main.Equipe_bleu) {
/* 700 */         if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_SHARD) {
/* 701 */           player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
/*     */         }
/* 703 */         player.teleport(main.map_en_cours.getLocationSpawnEquipeArray(1));
/*     */       } 
/* 705 */       if (joueur.getEquipe() == main.Equipe_rouge) {
/* 706 */         if (player.getInventory().getItemInMainHand().getType() == Material.AMETHYST_SHARD) {
/* 707 */           player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
/*     */         }
/* 709 */         player.teleport(main.map_en_cours.getLocationSpawnEquipeArray(0));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 715 */     if (it.getType() == Material.BLACK_BANNER && joueur.getKit() == main.list_kits.get(5)) {
/* 716 */       player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
/* 717 */       TimerInvisibility start = new TimerInvisibility(main, player);
/* 718 */       start.runTaskTimer((Plugin)main, 0L, 20L);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onTouch(InventoryMoveItemEvent event) {
/* 734 */     ItemStack item = event.getItem();
/*     */     
/* 736 */     if (item.getType() == Material.PLAYER_HEAD) {
/* 737 */       event.setCancelled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onTouch(PlayerMoveEvent e) {
/* 747 */     Player pl = e.getPlayer();
/*     */ 
/*     */ 
/*     */     
/* 751 */     Joueur joueur = main.listeJoueurs.stream()
/* 752 */       .filter(p -> pl.getName().equals(p.getPlayer().getName()))
/* 753 */       .findAny()
/* 754 */       .orElse(null);
/*     */     
/* 756 */     Location l = pl.getLocation();
/* 757 */     Block under = (new Location(pl.getWorld(), l.getX(), l.getY() - 1.0D, l.getZ())).getBlock();
/*     */ 
/*     */     
/* 760 */     if (main.ListTacticien.contains(under.getType()) && 
/* 761 */       joueur.getEquipe().getBlockTactique() != under.getType()) {
/* 762 */       under.setType(Material.AIR);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPlayerDrop(PlayerDropItemEvent event) {
/* 771 */     Item item = event.getItemDrop();
/*     */     
/* 773 */     if (!main.ListWool.contains(item.getItemStack().getType())) {
/* 774 */       event.setCancelled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onBlockDamage(BlockDamageEvent event) {
/* 783 */     Block block = event.getBlock();
/* 784 */     Player player = event.getPlayer();
/*     */     
/* 786 */     Joueur joueur = main.listeJoueurs.stream()
/* 787 */       .filter(p -> player.getName().equals(p.getPlayer().getName()))
/* 788 */       .findAny()
/* 789 */       .orElse(null);
/*     */     
/* 791 */     if (main.ListTacticien.contains(block.getType()))
/*     */     {
/*     */       
/* 794 */       event.setInstaBreak(true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\listener\PlayerListeners.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */