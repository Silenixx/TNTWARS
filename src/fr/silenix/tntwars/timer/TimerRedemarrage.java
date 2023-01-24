 package fr.silenix.tntwars.timer;
 
 import fr.silenix.tntwars.GMain;
 import fr.silenix.tntwars.entity.Equipe;
 import org.bukkit.Bukkit;
 import org.bukkit.scheduler.BukkitRunnable;
 
 public class TimerRedemarrage
   extends BukkitRunnable
 {
   private GMain main;
   private int timer = 30;
 
 
 
 
   
   public TimerRedemarrage(GMain main) {
     this.main = main;
   }
 
 
 
 
 
   
   public void run() {
     if (this.timer == 30) {
       Equipe gagnant = this.main.RenvoieGagnant();
       
       Bukkit.broadcastMessage("§6[§eTntWars§6] §eVictoire de la team: " + gagnant.getCouleur());
       Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §6" + this.timer + " §esecondes.");
     } 
     
     if (this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2) {
       Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §6" + this.timer + " §esecondes.");
     }
     
     if (this.timer == 1) {
       Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §61 §eseconde.");
     }
     if (this.timer == 0) {
       Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu.");
       this.main.remiseazero();
       cancel();
     } 
 
 
     
     this.timer--;
   }
 }


