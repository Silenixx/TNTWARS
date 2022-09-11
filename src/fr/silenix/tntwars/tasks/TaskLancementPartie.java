package fr.silenix.tntwars.tasks;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatPartie;
import fr.silenix.tntwars.entity.Joueur;





public class TaskLancementPartie extends BukkitRunnable{
	
	private int timer = 15;
	
	private fr.silenix.tntwars.main main;
	
	static World world = Bukkit.getWorld("world");
	
	
	
	
	public TaskLancementPartie(fr.silenix.tntwars.main main) {
		this.main = main;
	}




	@Override
	public void run() {
		
		
		if(main.listeJoueurs.size()  < 2) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eAnnulation de début de partie par manque de joueur");
			cancel();
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.getJoueur(i);
				joueur.get_the_player().getPlayer().setExp(0);
			}
			main.setState(EtatPartie.AttenteJoueur);
		}
		if(main.isState(EtatPartie.Lancement)) {
			for(Player pls : main.getListePlayer()) {
				pls.setLevel(timer);
			}
			
			if(timer==35 || timer ==10 || timer ==5 || timer==4 || timer==3|| timer==2|| timer==1) {
				Bukkit.broadcastMessage("§6[§eTntWars§6] §eTéléportation vers la carte de jeu dans §6" + timer +"§e secondes.");
				
			}
			
			if(timer == 0) {
				
				//main.value_random.clear();
				
				
				/*Random random = new Random();
				int value_random_en_cours = random.nextInt((main.list_maps.size() - 1) + 1) +1;
				main.map_en_cours = main.list_maps.get(value_random_en_cours-1);*/
				
				
				Bukkit.broadcastMessage("§6[§eTntWars§6] §ePour cette partie la map §6" + main.map_en_cours.getNom()+"§e a été choisie.");
				
				
				
				
			    
				main.efface_laine();
				//Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "killall all");
				
				
				
				for(int i=0; i < main.listeJoueurs.size(); i++) {
					Player player = main.listePlayers.get(i);
					//Location spawn = main.getSpawns().get(i);
					//for(int x =0; x != main.players.size(); x++) {
					
					//}
					
					
						
					player.teleport(main.map_en_cours.getLocationVisite());
						
						//player.setPlayerListName(ChatColor.BLUE + player.getName());
						
						
					}
				
				TaskDebutPartie start = new TaskDebutPartie(main);
				start.runTaskTimer(main, 0, 20);
				main.setState(EtatPartie.Prejeu);
				
				
				/*GGameCycle cycle = new GGameCycle(main);
				cycle.runTaskTimer(main, 0, 20);*/
					
				cancel();
			}
		}

		
		timer--;
		
	}

}
