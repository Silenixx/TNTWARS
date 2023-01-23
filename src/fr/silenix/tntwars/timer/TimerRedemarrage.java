/*    */ package fr.silenix.tntwars.timer;
/*    */ 
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import fr.silenix.tntwars.entity.Equipe;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class TimerRedemarrage
/*    */   extends BukkitRunnable
/*    */ {
/*    */   private GMain main;
/* 12 */   private int timer = 30;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TimerRedemarrage(GMain main) {
/* 19 */     this.main = main;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 28 */     if (this.timer == 30) {
/* 29 */       Equipe gagnant = this.main.RenvoieGagnant();
/*    */       
/* 31 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eVictoire de la team: " + gagnant.getCouleur());
/* 32 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §6" + this.timer + " §esecondes.");
/*    */     } 
/*    */     
/* 35 */     if (this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2) {
/* 36 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §6" + this.timer + " §esecondes.");
/*    */     }
/*    */     
/* 39 */     if (this.timer == 1) {
/* 40 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §61 §eseconde.");
/*    */     }
/* 42 */     if (this.timer == 0) {
/* 43 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu.");
/* 44 */       this.main.remiseazero();
/* 45 */       cancel();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 50 */     this.timer--;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\timer\TimerRedemarrage.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */