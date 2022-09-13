package fr.silenix.tntwars.timer;



import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatPartie;
import fr.silenix.tntwars.GMain;



public class TimerRespawn extends BukkitRunnable{
	
	
	private GMain main;
	private int timer=10;
	private Player player;
	
	
	
	
	public TimerRespawn(GMain main , Player player) {
		this.main = main;
		this.player = player;
	}
	
	
	@Override
	public void run() {
		if(main.isState(EtatPartie.FinJeu)) {
			cancel();
		}

		if (timer==10) {
			player.sendMessage("§6[§eTntWars§6] §eRespawn dans §510 §esecondes");
		}
		if (timer==5) {
			player.sendMessage("§6[§eTntWars§6] §eRespawn dans §55 §esecondes");
		}
		if (timer==4) {
			player.sendMessage("§6[§eTntWars§6] §eRespawn dans §54 §esecondes");
		}
		if (timer==3) {
			player.sendMessage("§6[§eTntWars§6] §eRespawn dans §53 §esecondes");
		}
		if (timer==2) {
			player.sendMessage("§6[§eTntWars§6] §eRespawn dans §52 §esecondes");
		}
		if (timer==1) {
			player.sendMessage("§6[§eTntWars§6] §eRespawn dans §51 §ebseconde");
		}
		if (timer==0) {
			player.sendMessage("§6[§eTntWars§6] §eRespawn en cours");
			main.respawn(player);
			cancel();
			
			
		}
		
		timer--;
		
	}
	
	

}
