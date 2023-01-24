/*     */ package fr.silenix.tntwars.listener;
/*     */ 
/*     */ import Enum.EtatPartie;
/*     */ import Fonctions.Fonctions;
/*     */ import fr.silenix.tntwars.GMain;
/*     */ import fr.silenix.tntwars.entity.Joueur;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.entity.Arrow;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.Fireball;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Snowball;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityExplodeEvent;
/*     */ import org.bukkit.event.player.PlayerMoveEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DamageListeners
/*     */   implements Listener
/*     */ {
/*     */   private GMain main;
/*     */   
/*     */   public DamageListeners(GMain main) {
/*  37 */     this.main = main;
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onDamage(EntityDamageEvent event) {
/*  43 */     Entity victim = event.getEntity();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     if (!this.main.isState(EtatPartie.JeuEnCours)) {
/*  50 */       event.setCancelled(true);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  55 */     if (event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) || event.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
/*  56 */       Player player = (Player)victim;
/*  57 */       Joueur joueur = this.main.listeJoueurs.stream()
/*  58 */         .filter(p -> player.getName().equals(p.getPlayer().getName()))
/*  59 */         .findAny()
/*  60 */         .orElse(null);
/*  61 */       if (joueur.getKit() == this.main.list_kits.get(2)) {
/*  62 */         event.setCancelled(true);
/*  63 */         event.setDamage(0.0D);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  69 */     if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
/*  70 */       Player player = (Player)victim;
/*  71 */       event.setDamage(0.0D);
/*  72 */       this.main.eliminate(player);
/*     */     } 
/*     */ 
/*     */     
/*  76 */     if (victim instanceof Player) {
/*  77 */       Player player = (Player)victim;
/*  78 */       if (player.getHealth() <= event.getDamage()) {
/*     */ 
/*     */ 
/*     */         
/*  82 */         event.setDamage(0.0D);
/*  83 */         this.main.eliminate(player);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  88 */     if (victim instanceof org.bukkit.block.data.type.Fire) {
/*  89 */       Player player = (Player)victim;
/*  90 */       if (player.getHealth() <= event.getDamage()) {
/*     */ 
/*     */ 
/*     */         
/*  94 */         event.setDamage(0.0D);
/*  95 */         this.main.eliminate(player);
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
/*     */   @EventHandler
/*     */   public void onEntityExplode(EntityExplodeEvent event) {
/* 109 */     List<Block> blocksToUndo = new ArrayList<>();
/* 110 */     for (Block block : event.blockList()) {
/* 111 */       if (block.getType() != Material.BLUE_WOOL && block.getType() != Material.RED_WOOL) {
/* 112 */         blocksToUndo.add(block);
/*     */       }
/*     */     } 
/*     */     
/* 116 */     event.blockList().removeAll(blocksToUndo);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onTouch(PlayerMoveEvent e) {
/* 136 */     Player pl = e.getPlayer();
/*     */     
/* 138 */     Material m = e.getPlayer().getLocation().getBlock().getType();
/*     */     
/* 140 */     Joueur joueur = this.main.listeJoueurs.stream()
/* 141 */       .filter(p -> pl.getName().equals(p.getPlayer().getName()))
/* 142 */       .findAny()
/* 143 */       .orElse(null);
/*     */     
/* 145 */     if (m == Material.WATER && 
/* 146 */       joueur.getKit() == this.main.list_kits.get(1)) {
/* 147 */       this.main.eliminate(pl);
/* 148 */       pl.sendMessage("un enderman ne peut pas nager ");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void onPpv(EntityDamageByEntityEvent event) {
/* 160 */     Entity victim = event.getEntity();
/*     */ 
/*     */     
/* 163 */     if (!this.main.isState(EtatPartie.JeuEnCours)) {
/* 164 */       event.setCancelled(true);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 169 */     if (victim instanceof Player) {
/* 170 */       Player players = (Player)victim;
/* 171 */       Joueur joueur_victime = this.main.listeJoueurs.stream()
/* 172 */         .filter(p -> players.getName().equals(p.getPlayer().getName()))
/* 173 */         .findAny()
/* 174 */         .orElse(null);
/*     */ 
/*     */       
/* 177 */       Entity damager = event.getDamager();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 182 */       if (damager instanceof Arrow) {
/* 183 */         Arrow arrow = (Arrow)damager;
/* 184 */         if (arrow.getShooter() instanceof Player) {
/* 185 */           Player killer_arrow = (Player)arrow.getShooter();
/*     */           
/* 187 */           Joueur joueur_killer = this.main.listeJoueurs.stream()
/* 188 */             .filter(p -> killer_arrow.getName().equals(p.getPlayer().getName()))
/* 189 */             .findAny()
/* 190 */             .orElse(null);
/*     */           
/* 192 */           if (joueur_killer.getEquipe() == joueur_victime.getEquipe()) {
/* 193 */             event.setDamage(0.0D);
/* 194 */             event.setCancelled(true);
/*     */             return;
/*     */           } 
/* 197 */           if (joueur_victime.getKit() == this.main.list_kits.get(1)) {
/* 198 */             event.setDamage(0.0D);
/* 199 */             event.setCancelled(true);
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 208 */       if (damager instanceof Fireball) {
/* 209 */         Fireball fireball = (Fireball)damager;
/* 210 */         if (fireball.getShooter() instanceof Player) {
/* 211 */           Player killer_fireball = (Player)fireball.getShooter();
/*     */           
/* 213 */           Joueur joueur_killer = this.main.listeJoueurs.stream()
/* 214 */             .filter(p -> killer_fireball.getName().equals(p.getPlayer().getName()))
/* 215 */             .findAny()
/* 216 */             .orElse(null);
/*     */ 
/*     */           
/* 219 */           if (joueur_killer.getEquipe() == joueur_victime.getEquipe()) {
/* 220 */             event.setDamage(0.0D);
/* 221 */             event.setCancelled(true);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 235 */       if (damager instanceof Snowball) {
/* 236 */         Snowball snowball = (Snowball)damager;
/* 237 */         if (snowball.getShooter() instanceof Player) {
/* 238 */           Player killer_snowball = (Player)snowball.getShooter();
/*     */           
/* 240 */           Joueur joueur_killer = this.main.listeJoueurs.stream()
/* 241 */             .filter(p -> killer_snowball.getName().equals(p.getPlayer().getName()))
/* 242 */             .findAny()
/* 243 */             .orElse(null);
/*     */ 
/*     */           
/* 246 */           if (joueur_killer.getEquipe() == joueur_victime.getEquipe()) {
/* 247 */             event.setDamage(0.0D);
/* 248 */             event.setCancelled(true);
/*     */             
/*     */             return;
/*     */           } 
/*     */           
/* 253 */           event.setDamage(13.0D);
/* 254 */           if (joueur_victime.getPlayer().getHealth() <= event.getDamage()) {
/* 255 */             event.setDamage(0.0D);
/* 256 */             event.setCancelled(true);
/* 257 */             this.main.eliminate(joueur_victime.getPlayer());
/*     */           } 
/*     */         } 
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
/*     */ 
/*     */ 
/*     */       
/* 361 */       if (damager instanceof Player) {
/*     */         
/* 363 */         Joueur joueur_killer = this.main.listeJoueurs.stream()
/* 364 */           .filter(p -> damager.getName().equals(p.getPlayer().getName()))
/* 365 */           .findAny()
/* 366 */           .orElse(null);
/*     */         
/* 368 */         if (joueur_killer.getKit() == this.main.list_kits.get(3)) {
/* 369 */           Bukkit.broadcastMessage(String.valueOf(damager.getName()) + " vient de tuer " + players.getDisplayName());
/* 370 */           damager.sendMessage("Tu viens de tuer " + players.getName());
/* 371 */           event.setDamage(0.0D);
/* 372 */           this.main.eliminate(players);
/*     */         } 
/*     */ 
/*     */         
/* 376 */         if (joueur_killer.getKit() == this.main.list_kits.get(39)) {
/*     */ 
/*     */           
/* 379 */           double vue_victim = Fonctions.getDirectionVue(joueur_victime.getPlayer());
/* 380 */           double vue_killer = Fonctions.getDirectionVue(joueur_killer.getPlayer());
/*     */ 
/*     */           
/* 383 */           if (vue_victim > 315.0D || vue_victim < 45.0D) {
/*     */ 
/*     */ 
/*     */             
/* 387 */             if (vue_victim > 315.0D) {
/*     */               
/* 389 */               if (vue_killer >= 0.0D && vue_killer <= 45.0D) {
/* 390 */                 double diff = 360.0D - vue_victim + vue_killer;
/* 391 */                 vue_victim -= 180.0D;
/* 392 */                 vue_killer = vue_victim + diff;
/*     */               }
/*     */               else {
/*     */                 
/* 396 */                 vue_victim -= 180.0D;
/* 397 */                 vue_killer -= 180.0D;
/*     */               } 
/*     */ 
/*     */ 
/*     */               
/* 402 */               if (vue_victim > vue_killer && vue_killer > vue_victim - 45.0D) {
/* 403 */                 event.setDamage(0.0D);
/* 404 */                 joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par un spy");
/* 405 */                 this.main.eliminate(players);
/*     */               } 
/* 407 */               if (vue_victim < vue_killer && vue_killer < vue_victim + 45.0D) {
/* 408 */                 event.setDamage(0.0D);
/* 409 */                 joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par un spy");
/* 410 */                 this.main.eliminate(players);
/*     */               } 
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 420 */             if (vue_victim < 45.0D)
/*     */             {
/* 422 */               if (vue_killer >= 315.0D && vue_killer <= 360.0D) {
/* 423 */                 double diff = vue_victim + 360.0D - vue_killer;
/* 424 */                 vue_victim += 180.0D;
/* 425 */                 vue_killer = vue_victim - diff;
/*     */               }
/*     */               else {
/*     */                 
/* 429 */                 vue_victim += 180.0D;
/* 430 */                 vue_killer += 180.0D;
/*     */               } 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 436 */               if (vue_victim > vue_killer && vue_killer > vue_victim - 45.0D) {
/* 437 */                 event.setDamage(0.0D);
/* 438 */                 joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par un spy");
/* 439 */                 this.main.eliminate(players);
/*     */               } 
/* 441 */               if (vue_victim < vue_killer && vue_killer < vue_victim + 45.0D) {
/* 442 */                 event.setDamage(0.0D);
/* 443 */                 joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par un spy");
/* 444 */                 this.main.eliminate(players);
/*     */               
/*     */               }
/*     */ 
/*     */             
/*     */             }
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 454 */             if (vue_victim > vue_killer && vue_killer > vue_victim - 45.0D) {
/* 455 */               event.setDamage(0.0D);
/* 456 */               joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par un spy");
/* 457 */               this.main.eliminate(players);
/*     */             } 
/* 459 */             if (vue_victim < vue_killer && vue_killer < vue_victim + 45.0D) {
/* 460 */               event.setDamage(0.0D);
/* 461 */               joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par un spy");
/* 462 */               this.main.eliminate(players);
/*     */             } 
/*     */           } 
/*     */         } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 549 */       if (players.getHealth() <= event.getDamage())
/*     */       {
/* 551 */         if (damager instanceof Player) {
/* 552 */           Player killer_parjoueur = (Player)damager;
/* 553 */           Joueur joueur_killer = this.main.listeJoueurs.stream()
/* 554 */             .filter(p -> killer_parjoueur.getName().equals(p.getPlayer().getName()))
/* 555 */             .findAny()
/* 556 */             .orElse(null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 564 */           Bukkit.broadcastMessage(String.valueOf(killer_parjoueur.getDisplayName()) + " vient de tuer " + players.getDisplayName());
/* 565 */           killer_parjoueur.sendMessage("Tu viens de tuer " + players.getName());
/*     */           
/* 567 */           if (joueur_killer.getKit() == this.main.list_kits.get(4)) {
/* 568 */             killer_parjoueur.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FIREWORK_ROCKET) });
/*     */           }
/* 570 */           if (joueur_killer.getKit() == this.main.list_kits.get(1)) {
/* 571 */             killer_parjoueur.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL) });
/*     */           }
/* 573 */           if (joueur_killer.getKit() == this.main.list_kits.get(5)) {
/* 574 */             killer_parjoueur.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BLACK_BANNER) });
/*     */           }
/*     */ 
/*     */           
/* 578 */           event.setDamage(0.0D);
/* 579 */           this.main.eliminate(players);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\listener\DamageListeners.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */