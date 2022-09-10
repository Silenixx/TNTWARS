package fr.silenix.tntwars.timer;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerImmortality extends BukkitRunnable{

	private int timer=3;
	private Player player;
	
	
	
	
	public TimerImmortality(Player player) {
		this.player = player;
	}
	
	
	@Override
	public void run() {

		if (timer==3) {
			player.setInvulnerable(true);
			//player.sendMessage("§5[§dSilenixGames§5] §bRespawn dans §54 §bsecondes");
		}
		if (timer==2) {
			//player.sendMessage("§5[§dSilenixGames§5] §bRespawn dans §52 §bsecondes");
		}
		if (timer==1) {
			//player.sendMessage("§5[§dSilenixGames§5] §bRespawn dans §51 §bseconde");
		}
		if (timer==0) {
			//player.sendMessage("§5[§dSilenixGames§5]Respawn en cours");
			//main.respawn(player);
			player.setInvulnerable(false);
			cancel();
			
			
		}
		
		timer--;
		
	}
	
	

}