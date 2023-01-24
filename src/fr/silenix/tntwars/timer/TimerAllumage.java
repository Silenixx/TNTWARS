/*    */ package fr.silenix.tntwars.timer;
/*    */ 
/*    */ import Constante.Constantes;
/*    */ import Enum.EtatPartie;
/*    */ import Enum.EtatTNT;
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import fr.silenix.tntwars.entity.Joueur;
/*    */ import fr.silenix.tntwars.entity.Tnt;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.GameMode;
/*    */ import org.bukkit.Particle;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ 
/*    */ public class TimerAllumage
/*    */   extends BukkitRunnable
/*    */ {
/*    */   private GMain main;
/*    */   private String couleur;
/*    */   
/*    */   public TimerAllumage(GMain main, String couleur) {
/* 23 */     this.main = main;
/* 24 */     this.couleur = couleur;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 32 */     Tnt tnt = this.main.listTnt.stream()
/* 33 */       .filter(t -> t.getEquipe().getCouleur().equals(this.couleur))
/* 34 */       .findFirst()
/* 35 */       .get();
/*    */ 
/*    */     
/* 38 */     if (tnt.getEtat() == EtatTNT.Eteinte) {
/* 39 */       Bukkit.broadcastMessage(String.valueOf(Constantes.PluginName) + " Explosion Tnt " + this.couleur + "  §e§vit§e.");
/* 40 */       tnt.setVie(0);
/* 41 */       tnt.setTimer(30);
/* 42 */       cancel();
/*    */     }
/* 44 */     else if (this.main.isState(EtatPartie.FinJeu)) {
/* 45 */       cancel();
/*    */     }
/* 47 */     else if (tnt.getTimer() == 30 && tnt.getEtat() == EtatTNT.Allume) {
/* 48 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §630 §bsecondes avant l'explosion de la TNT " + this.couleur + ".");
/* 49 */       for (int j = 0; j < this.main.listeJoueurs.size(); j++) {
/* 50 */         Joueur joueur = this.main.listeJoueurs.get(j);
/* 51 */         joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F, 1.0F);
/*    */       }
/*    */     
/* 54 */     } else if (tnt.getTimer() == 25 || tnt.getTimer() == 20 || tnt.getTimer() == 15 || tnt.getTimer() == 10 || tnt.getTimer() == 5 || tnt.getTimer() == 3 || tnt.getTimer() == 2) {
/* 55 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6" + tnt.getTimer() + " §esecondes avant l'explosion de la TNT " + this.couleur + ".");
/*    */     }
/* 57 */     else if (tnt.getTimer() == 1) {
/* 58 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6" + tnt.getTimer() + " §eseconde avant l'explosion de la TNT " + this.couleur + ".");
/*    */     }
/* 60 */     else if (tnt.getTimer() == 0) {
/* 61 */       tnt.setEtat(EtatTNT.Explose);
/* 62 */       this.main.CheckWin();
/*    */       
/* 64 */       Bukkit.getWorld("world").spawnParticle(Particle.EXPLOSION_HUGE, this.main.map_en_cours.getLocationTntArray(tnt.getIndex()), 100, 1.0D, 1.0D, 1.0D);
/*    */       
/* 66 */       for (int j = 0; j < this.main.listeJoueurs.size(); j++) {
/* 67 */         Joueur joueur = this.main.listeJoueurs.get(j);
/* 68 */         if (joueur.getEquipe() == tnt.getEquipe()) {
/* 69 */           joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
/*    */         }
/* 71 */         joueur.getPlayer().playSound(this.main.map_en_cours.getLocationTntArray(tnt.getIndex()), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 3.0F, 1.0F);
/*    */       } 
/* 73 */       cancel();
/*    */     } 
/* 75 */     if (tnt.getTimer() != 0) {
/* 76 */       tnt.setTimer(tnt.getTimer() - 1);
/*    */     }
/* 78 */     Bukkit.getWorld("world").spawnParticle(Particle.LAVA, this.main.map_en_cours.getLocationTntArray(tnt.getIndex()), 100, 1.0D, 1.0D, 1.0D);
/* 79 */     for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
/* 80 */       Joueur joueur = this.main.listeJoueurs.get(i);
/* 81 */       joueur.getPlayer().playSound(this.main.map_en_cours.getLocationTntArray(tnt.getIndex()), Sound.ENTITY_CREEPER_PRIMED, 0.6F, 0.6F);
/*    */     } 
/*    */   }
/*    */ }


