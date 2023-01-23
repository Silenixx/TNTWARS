/*    */ package fr.silenix.tntwars.timer;
/*    */ 
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class TimerImmortality
/*    */   extends BukkitRunnable
/*    */ {
/* 10 */   private int timer = 3;
/*    */   
/*    */   private Player player;
/*    */   
/*    */   private GMain main;
/*    */   
/*    */   public TimerImmortality(GMain main, Player player) {
/* 17 */     this.main = main;
/* 18 */     this.player = player;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 25 */     if (this.timer == 3) {
/* 26 */       this.player.setInvulnerable(true);
/* 27 */       this.player.sendMessage("§6[§eTntWars§6] §eImmortalité pendant 3 §bsecondes");
/*    */     } 
/* 29 */     if (this.timer == 2) {
/* 30 */       this.player.sendMessage("§6[§eTntWars§6] §eImmortalité pendant 2 §bsecondes");
/*    */     }
/* 32 */     if (this.timer == 1) {
/* 33 */       this.player.sendMessage("§6[§eTntWars§6] §eImmortalité pendant 1 §bseconde");
/*    */     }
/* 35 */     if (this.timer == 0) {
/* 36 */       this.player.sendMessage("§6[§eTntWars§6] §eFin d'Immortalité");
/*    */       
/* 38 */       this.player.setInvulnerable(false);
/* 39 */       cancel();
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 44 */     this.timer--;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\timer\TimerImmortality.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */