/*    */ package fr.silenix.tntwars.tasks;
/*    */ 
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import fr.silenix.tntwars.entity.Joueur;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class TaskRejoindPartieEnCours extends BukkitRunnable {
/*    */   private GMain main;
/*    */   private Joueur joueur;
/* 12 */   static World world = Bukkit.getWorld("world");
/* 13 */   private int timer = 10;
/*    */   
/*    */   public TaskRejoindPartieEnCours(GMain main, Joueur joueur) {
/* 16 */     this.main = main;
/* 17 */     this.joueur = joueur;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void run() {
/* 24 */     if (this.joueur.getEquipe() != this.main.Sans_Equipe) {
/*    */       
/* 26 */       if (this.timer == 35 || this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2 || this.timer == 1 || this.timer == 0) {
/* 27 */         this.joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eVous allez rejoindre la partie dans §5" + this.timer + "§b secondes.");
/* 28 */         if (this.timer == 0) {
/* 29 */           this.joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eVous avez rejoind le jeu. Amusez vous bien!");
/* 30 */           if (this.joueur.getKit() == this.main.Sans_Kit) {
/* 31 */             this.joueur.setKit(this.main.list_kits.get(0));
/* 32 */             this.joueur.setProchainKit(this.main.list_kits.get(0));
/*    */           } 
/* 34 */           this.joueur.getPlayer().getInventory().clear();
/* 35 */           this.main.respawn(this.joueur.getPlayer());
/* 36 */           cancel();
/*    */         } 
/*    */       } 
/* 39 */       this.timer--;
/*    */     } 
/*    */   }
/*    */ }


