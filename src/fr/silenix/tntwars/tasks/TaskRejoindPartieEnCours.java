package fr.silenix.tntwars.tasks;

import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.World;

import org.bukkit.scheduler.BukkitRunnable;

import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;



public class TaskRejoindPartieEnCours extends BukkitRunnable{
	
	@SuppressWarnings("unused")
	private GMain main;
	@SuppressWarnings("unused")
	private Joueur joueur;
	
	
	static World world = Bukkit.getWorld("world");
	

	public static Location spawnbleu = new Location (world, -6, 85, -15);
	public static Location spawnrouge = new Location(world, 12, 85, -15);
	
	
	@SuppressWarnings("unused")
	private int timer=10;
	
	public TaskRejoindPartieEnCours(GMain main, Joueur joueur) {
		this.main = main;
		this.joueur = joueur;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	
	/*@Override
	public void run() {

		if(joueur.getEquipe() == main.Sans_Equipe) {
			
			main.players.add(player);
		
			if(timer==35 || timer ==10 || timer ==5 || timer==4 || timer==3|| timer==2|| timer==1 || timer==0) {
				player.sendMessage("§5[§dSilenixGames§5] §bVous allez rejoindre la partie dans §5" + timer +"§b secondes.");
				if(timer == 0) {
					player.sendMessage("§5[§dSilenixGames§5] §bVous avez rejoind le jeu. Amusez vous bien!");
					
					
					kit par defaut ici
					
					player.getInventory().clear();
					
					main.respawn(player);
					
					
					GGameCycle cycle = new GGameCycle(main);
					cycle.runTaskTimer(main, 0, 20);
					
					cancel();
				}
			
			
			
			}
		timer--;
		}
		
		
	}*/

}