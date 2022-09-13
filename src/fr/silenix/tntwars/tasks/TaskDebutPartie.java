package fr.silenix.tntwars.tasks;

import org.bukkit.Bukkit;

import org.bukkit.World;

import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatPartie;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;

public class TaskDebutPartie extends BukkitRunnable{

	private int timer = 45;
	
	private GMain main;
	
	static World world = Bukkit.getWorld("world");

	

	

	
	
	
	
	public TaskDebutPartie(GMain main) {
		this.main = main;
	}



	@Override
	public void run() {
		
		
		if(main.listeJoueurs.size() < 2) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eAnnulation de début de partie par manque de joueur");
			cancel();
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				joueur.getPlayer().teleport(main.spawn_general);
				joueur.getPlayer().setExp(0);
			}
			main.setState(EtatPartie.AttenteJoueur);
			
		}
		if(main.isState(EtatPartie.Prejeu)) {
			/*for(Player pls : main.listeJoueurs) {
				pls.setLevel(timer);
			}*/
			
			if(timer==45 || timer ==30 || timer ==20 || timer ==10 || timer ==5 || timer==4 || timer==3|| timer==2|| timer==1) {
				Bukkit.broadcastMessage("§6[§eTntWars§6] §eLancement de la partie dans §6" + timer +"§e secondes.");
				
			}
			
			if(timer == 0) {
				Bukkit.broadcastMessage("§6[§eTntWars§6] §eLancement de la partie! Que la meilleure équipe gagne!");
				main.setState(EtatPartie.JeuEnCours);
				
				
				
				
				
			    
				
				
				main.AutoAddTeam(main.map_en_cours.getNbEquipe());
				
				for(int i=0; i < main.listeJoueurs.size(); i++) {
					Joueur joueur = main.listeJoueurs.get(i);
					
					/*Joueur joueur = main.listeJoueurs.stream()
							  .filter(p -> player.getName().equals(p.getNom()))
							  .findAny()
							  .orElse(null);*/
					
					
					main.SpawnTeleportation(joueur);
					
					
					
					
					joueur.getPlayer().getInventory().clear();
					
					
					if(joueur.getKit()==main.Sans_Kit) {
						
						joueur.setKit(main.Guerrier);
					}
					
					
					
					main.GamePlay(joueur);
					
					
					
					
				}
				
				
				
				main.CheckWin();
					
					
				
					
					
					
					
				
				
				/*GGameCycle cycle = new GGameCycle(main);
				cycle.runTaskTimer(main, 0, 20);*/
					
				cancel();
			}
		}
		
		
		timer--;
		
	}




	

}
