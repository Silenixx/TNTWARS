package fr.silenix.tntwars.timer;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.silenix.tntwars.GMain;

public class TimerRedemarrage extends BukkitRunnable{

	private GMain main;
	private int timer =30;

	
	
	
	
	public TimerRedemarrage(GMain main) {
		this.main = main;
	}
	
	



	@Override
	public void run() {
		if (timer==30 ) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eVictoire de la team: ");
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §6"+timer+" §esecondes.");
			
		}
		if (timer==10 || timer==5 || timer==4 || timer==3 || timer==2) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §6"+timer+" §esecondes.");
			
		}
		if (timer==1) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu dans §61 §eseconde.");
		}
		if (timer==0) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eRedemmarage du mode de jeu.");
			main.remiseazero();
			cancel();
			//Bukkit.spigot().restart();
			
		}
		
		timer--;
		
	}
	
	

}
