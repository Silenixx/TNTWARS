package fr.silenix.tntwars.tasks;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatPartie;
import fr.silenix.tntwars.entity.Joueur;

public class TaskDebutPartie extends BukkitRunnable{

	private int timer = 45;
	
	private fr.silenix.tntwars.main main;
	
	static World world = Bukkit.getWorld("world");

	

	

	
	
	
	
	public TaskDebutPartie(fr.silenix.tntwars.main main) {
		this.main = main;
	}



	@Override
	public void run() {
		
		
		if(main.getJoueur().size()  < 2) {
			Bukkit.broadcastMessage("�6[�eTntWars�6] �eAnnulation de d�but de partie par manque de joueur");
			cancel();
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.getJoueur().get(i);
				joueur.get_the_player().teleport(main.spawn_general);
				joueur.get_the_player().setExp(0);
			}
			main.setState(EtatPartie.AttenteJoueur);
			
		}
		if(main.isState(EtatPartie.AttenteJoueur)) {
			for(Joueur pls : main.getJoueur()) {
				pls.get_the_player().setLevel(timer);
			}
			
			if(timer==45 || timer ==30 || timer ==20 || timer ==10 || timer ==5 || timer==4 || timer==3|| timer==2|| timer==1) {
				Bukkit.broadcastMessage("�6[�eTntWars�6] �eLancement de la partie dans �6" + timer +"�e secondes.");
				
			}
			
			if(timer == 0) {
				Bukkit.broadcastMessage("�6[�eTntWars�6] �eLancement de la partie! Que la meilleure �quipe gagne!");
				main.setState(EtatPartie.JeuEnCours);
				
				
				
				
				
			    
				
				
				main.AutoAddTeam(main.map_en_cours.getNbEquipe());
				
				for(int i=0; i < main.listeJoueurs.size(); i++) {
					Joueur joueur = main.getJoueur().get(i);
					
					
					main.SpawnTeleportation(joueur);
					
					
					
					
					joueur.get_the_player().getInventory().clear();
					
					
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
