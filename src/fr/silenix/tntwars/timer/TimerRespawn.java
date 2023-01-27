 package fr.silenix.tntwars.timer;
 
 import Enum.EtatPartie;
 import fr.silenix.tntwars.GMain;
 import org.bukkit.entity.Player;
 import org.bukkit.scheduler.BukkitRunnable;
 
 
 
 
 
 
 public class TimerRespawn
   extends BukkitRunnable
 {
   private GMain main;
   private int timer = 10;
 
   
   private Player player;
 
   
   public TimerRespawn(GMain main, Player player) {
     this.main = main;
     this.player = player;
   }
 
 
   
   public void run() {
     if (this.main.isState(EtatPartie.FinJeu)) {
       cancel();
     }
 
     
     if (this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2) {
       this.player.sendMessage(Constante.Constantes.PluginName + "Respawn dans §5" + this.timer + " §esecondes");
     }
     else if (this.timer == 1) {
       this.player.sendMessage(Constante.Constantes.PluginName + "Respawn dans §51 §eseconde");
     }
     else if (this.timer == 0) {
       this.player.sendMessage(Constante.Constantes.PluginName + "Respawn");
       this.main.respawn(this.player);
       cancel();
     } 
     
     this.timer--;
   }
 }


