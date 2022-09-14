package fr.silenix.tntwars.timer;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatPartie;
import fr.silenix.tntwars.GMain;



public class TimerInvisibility extends BukkitRunnable{

	private GMain main;
	private int timer=10;
	private Player player;
	
	
	
	
	public TimerInvisibility(GMain main , Player player) {
		this.main = main;
		this.player = player;
	}
	
	
	@Override
	public void run() {
		if(main.isState(EtatPartie.FinJeu)) {
			cancel();
		}

		if (timer==10) {
			player.setInvisible(true);
			player.sendMessage("invisible pendant 10 secondes");
		}
		if (timer==0) {
			player.setInvisible(false);
			cancel();
			
			
		}
		
		timer--;
		
	}
	
	

}
