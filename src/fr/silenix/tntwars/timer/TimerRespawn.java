/*    */ package fr.silenix.tntwars.timer;
/*    */ 
/*    */ import Enum.EtatPartie;
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimerRespawn
/*    */   extends BukkitRunnable
/*    */ {
/*    */   private GMain main;
/* 17 */   private int timer = 10;
/*    */ 
/*    */   
/*    */   private Player player;
/*    */ 
/*    */   
/*    */   public TimerRespawn(GMain main, Player player) {
/* 24 */     this.main = main;
/* 25 */     this.player = player;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 31 */     if (this.main.isState(EtatPartie.FinJeu)) {
/* 32 */       cancel();
/*    */     }
/*    */ 
/*    */     
/* 36 */     if (this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2) {
/* 37 */       this.player.sendMessage("§6[§eTntWars§6] §eRespawn dans §5" + this.timer + " §esecondes");
/*    */     }
/* 39 */     else if (this.timer == 1) {
/* 40 */       this.player.sendMessage("§6[§eTntWars§6] §eRespawn dans §51 §ebseconde");
/*    */     }
/* 42 */     else if (this.timer == 0) {
/* 43 */       this.player.sendMessage("§6[§eTntWars§6] §eRespawn en cours");
/* 44 */       this.main.respawn(this.player);
/* 45 */       cancel();
/*    */     } 
/*    */     
/* 48 */     this.timer--;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\timer\TimerRespawn.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */