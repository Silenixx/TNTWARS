/*    */ package fr.silenix.tntwars.timer;
/*    */ 
/*    */ import Enum.EtatPartie;
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimerInvisibility
/*    */   extends BukkitRunnable
/*    */ {
/*    */   private GMain main;
/* 14 */   private int timer = 10;
/*    */ 
/*    */   
/*    */   private Player player;
/*    */ 
/*    */   
/*    */   public TimerInvisibility(GMain main, Player player) {
/* 21 */     this.main = main;
/* 22 */     this.player = player;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 28 */     if (this.main.isState(EtatPartie.FinJeu)) {
/* 29 */       cancel();
/*    */     }
/*    */     
/* 32 */     if (this.timer == 10) {
/* 33 */       this.player.setInvisible(true);
/* 34 */       this.player.sendMessage("§6[§eTntWars§6] §eInvisible pendant 10 secondes");
/*    */     } 
/* 36 */     if (this.timer == 0) {
/* 37 */       this.player.setInvisible(false);
/* 38 */       cancel();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 43 */     this.timer--;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\timer\TimerInvisibility.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */