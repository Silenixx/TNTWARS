/*    */ package fr.silenix.tntwars.timer;
/*    */ 
/*    */ import Enum.EtatTNT;
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.ChatColor;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TimerScoreboard
/*    */   extends BukkitRunnable
/*    */ {
/*    */   private GMain main;
/*    */   
/*    */   public TimerScoreboard(GMain main) {
/* 21 */     this.main = main;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 32 */     if (this.main.listeConnecte.size() != 0) {
/* 33 */       this.main.connecter_score = Bukkit.getOnlinePlayers().size();
/* 34 */       this.main.cblue = this.main.tnt_bleu.getVie() * 2;
/* 35 */       this.main.cred = this.main.tnt_rouge.getVie() * 2;
/* 36 */       this.main.timeblue = this.main.tnt_bleu.getTimer();
/* 37 */       this.main.timered = this.main.tnt_rouge.getTimer();
/*    */ 
/*    */ 
/*    */       
/* 41 */       this.main.taille_blue = this.main.getSize("Bleu");
/* 42 */       this.main.taille_red = this.main.getSize("Rouge");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 49 */       if (Bukkit.getOnlinePlayers().size() == 0) {
/* 50 */         this.main.onlineCounter.setSuffix(ChatColor.AQUA + "0");
/*    */       } else {
/* 52 */         this.main.onlineCounter.setSuffix(ChatColor.GRAY + this.main.connecter_score + "  (" + ChatColor.BLUE + this.main.taille_blue + ChatColor.GRAY + "|" + ChatColor.RED + this.main.taille_red + ChatColor.GRAY + ")");
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 57 */       if (this.main.tnt_rouge.getEtat() == EtatTNT.Eteinte) {
/* 58 */         this.main.boardred.setSuffix(ChatColor.RED + this.main.cred + ChatColor.RED + "%");
/*    */       }
/* 60 */       if (this.main.tnt_rouge.getEtat() == EtatTNT.Allume) {
/* 61 */         this.main.boardred.setSuffix(ChatColor.RED + this.main.cred + ChatColor.RED + "%    " + ChatColor.RED + this.main.timered + ChatColor.RED + "s");
/*    */       }
/*    */ 
/*    */ 
/*    */       
/* 66 */       if (this.main.tnt_bleu.getEtat() == EtatTNT.Eteinte) {
/* 67 */         this.main.boardblue.setSuffix(ChatColor.BLUE + this.main.cblue + ChatColor.BLUE + "%");
/*    */       }
/* 69 */       if (this.main.tnt_bleu.getEtat() == EtatTNT.Allume)
/* 70 */         this.main.boardblue.setSuffix(ChatColor.BLUE + this.main.cblue + ChatColor.BLUE + "%    " + ChatColor.BLUE + this.main.timeblue + ChatColor.BLUE + "s"); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\timer\TimerScoreboard.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */