/*    */ package fr.silenix.tntwars.tasks;
/*    */ 
/*    */ import Enum.EtatPartie;
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import fr.silenix.tntwars.entity.Joueur;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class TaskDebutPartie extends BukkitRunnable {
/* 11 */   private int timer = 20;
/*    */   private GMain main;
/*    */   
/*    */   public TaskDebutPartie(GMain main) {
/* 15 */     this.main = main;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 20 */     if (this.main.listeJoueurs.size() < 2) {
/* 21 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eAnnulation de début de partie par manque de joueur");
/* 22 */       cancel();
/* 23 */       for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
/* 24 */         Joueur joueur = this.main.listeJoueurs.get(i);
/* 25 */         joueur.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), 6.0D, 1.0D, 1.0D));
/* 26 */         joueur.getPlayer().setExp(0.0F);
/*    */       } 
/* 28 */       this.main.setState(EtatPartie.AttenteJoueur);
/*    */     }
/* 30 */     else if (this.main.isState(EtatPartie.Prejeu)) {
/* 31 */       for (Joueur pls : this.main.listeJoueurs) {
/* 32 */         pls.getPlayer().setLevel(this.timer);
/*    */       }
/* 34 */       if (this.timer == 45 || this.timer == 30 || this.timer == 20 || this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2 || this.timer == 1) {
/* 35 */         Bukkit.broadcastMessage("§6[§eTntWars§6] §eLancement de la partie dans §6" + this.timer + "§e secondes.");
/*    */       }
/* 37 */       else if (this.timer == 0) {
/* 38 */         Bukkit.broadcastMessage("§6[§eTntWars§6] §eLancement de la partie! Que la meilleure équipe gagne!");
/* 39 */         this.main.setState(EtatPartie.JeuEnCours);
/* 40 */         this.main.AutoAddTeam(this.main.map_en_cours.getNbEquipe());
/* 41 */         for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
/* 42 */           Joueur joueur = this.main.listeJoueurs.get(i);
/* 43 */           this.main.SpawnTeleportation(joueur);
/* 44 */           joueur.getPlayer().getInventory().clear();
/* 45 */           if (joueur.getProchainKit() == this.main.Sans_Kit) {
/* 46 */             joueur.setProchainKit(this.main.list_kits.get(0));
/*    */           }
/* 48 */           this.main.GamePlay(joueur);
/*    */         } 
/* 50 */         this.main.CheckWin();
/* 51 */         cancel();
/*    */       } 
/*    */     } 
/* 54 */     this.timer--;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\tasks\TaskDebutPartie.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */