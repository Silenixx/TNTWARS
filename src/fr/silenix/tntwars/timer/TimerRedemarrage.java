package fr.silenix.tntwars.timer;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerRedemarrage extends BukkitRunnable{

	private fr.silenix.tntwars.main main;
	private int timer =30;

	
	
	
	
	public TimerRedemarrage(fr.silenix.tntwars.main main) {
		this.main = main;
	}
	
	



	@Override
	public void run() {
		if (timer==30 || timer==10 || timer==5 || timer==4 || timer==3 || timer==2) {
			Bukkit.broadcastMessage("�6[�eTntWars�6] �eRedemmarage du mode de jeu dans �6"+timer+" �esecondes.");
			
		}
		if (timer==1) {
			Bukkit.broadcastMessage("�6[�eTntWars�6] �eRedemmarage du mode de jeu dans �61 �eseconde.");
		}
		if (timer==0) {
			Bukkit.broadcastMessage("�6[�eTntWars�6] �eRedemmarage du mode de jeu.");
			main.remiseazero();
			cancel();
			//Bukkit.spigot().restart();
			
		}
		
		timer--;
		
	}
	
	

}