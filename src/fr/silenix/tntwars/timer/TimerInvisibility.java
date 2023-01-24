 package fr.silenix.tntwars.timer;
 
 import Enum.EtatPartie;
 import fr.silenix.tntwars.GMain;
 import org.bukkit.entity.Player;
 import org.bukkit.scheduler.BukkitRunnable;
 
 
 
 public class TimerInvisibility
   extends BukkitRunnable
 {
   private GMain main;
   private int timer = 10;
 
   
   private Player player;
 
   
   public TimerInvisibility(GMain main, Player player) {
     this.main = main;
     this.player = player;
   }
 
 
   
   public void run() {
     if (this.main.isState(EtatPartie.FinJeu)) {
       cancel();
     }
     
     if (this.timer == 10) {
       this.player.setInvisible(true);
       this.player.sendMessage(Constante.Constantes.PluginName + "Invisible pendant 10 secondes");
     } 
     if (this.timer == 0) {
       this.player.setInvisible(false);
       cancel();
     } 
 
 
     
     this.timer--;
   }
 }


