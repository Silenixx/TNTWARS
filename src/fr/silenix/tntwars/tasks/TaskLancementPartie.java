package fr.silenix.tntwars.tasks;




import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.World;

import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatPartie;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;





public class TaskLancementPartie extends BukkitRunnable{
	
	private int timer = 15;
	
	private GMain main;
	
	static World world = Bukkit.getWorld("world");
	
	
	
	
	public TaskLancementPartie(GMain main) {
		this.main = main;
	}




	@Override
	public void run() {
		
		
		if(main.listeJoueurs.size()  < 2) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eAnnulation de début de partie par manque de joueur");
			cancel();
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				joueur.getPlayer().setExp(0);
			}
			main.setState(EtatPartie.AttenteJoueur);
		}
		if(main.isState(EtatPartie.Lancement)) {
			/*for(Player pls : main.getListePlayer()) {
				pls.setLevel(timer);
			}*/
			
			if(timer==35 || timer ==10 || timer ==5 || timer==4 || timer==3|| timer==2|| timer==1) {
				Bukkit.broadcastMessage("§6[§eTntWars§6] §eTéléportation vers la carte de jeu dans §6" + timer +"§e secondes.");
				
			}
			
			if(timer == 0) {
				
				Bukkit.broadcastMessage("vie tnt bleu: "+ main.tnt_bleu.getVie()+"vie tnt rouge: "+ main.tnt_rouge.getVie());
				//main.value_random.clear();
				
				
				Random random = new Random();
				int value_random_en_cours = random.nextInt((main.list_maps.size() - 1) + 1) +1;
				main.map_en_cours = main.list_maps.get(value_random_en_cours-1);
				
				main.map_en_cours = main.list_maps.get(value_random_en_cours);
				
				
				/*main.map_en_cours.NbEquipe = main.list_maps.get(0).NbEquipe;
				main.map_en_cours.LocationSalleMort = main.list_maps.get(0).LocationSalleMort;
				main.map_en_cours.LocationSpawnEquipeArray = main.list_maps.get(0).LocationSpawnEquipeArray;
				main.map_en_cours.LocationVisite = main.list_maps.get(0).LocationVisite;
				main.map_en_cours.LocationMapBorne1 = main.list_maps.get(0).LocationMapBorne1;
				main.map_en_cours.LocationMapBorne2 = main.list_maps.get(0).LocationMapBorne2;
				main.map_en_cours.Nom = main.list_maps.get(0).Nom;
				main.map_en_cours.LocationTntArray = main.list_maps.get(0).LocationTntArray;*/
				
				
				Bukkit.broadcastMessage("§6[§eTntWars§6] §ePour cette partie la map §6" + main.map_en_cours.Nom + "§e a été choisie.");
				
				main.efface_laine();
				
				
				
				
				for(int i=0; i < main.listeJoueurs.size(); i++) {
					Joueur joueur = main.listeJoueurs.get(i);
					//Location spawn = main.getSpawns().get(i);
					//for(int x =0; x != main.players.size(); x++) {
					
					//}
					
					
						
					joueur.getPlayer().teleport(main.map_en_cours.LocationVisite);
						
						//player.setPlayerListName(ChatColor.BLUE + player.getName());
	
				}
				main.setState(EtatPartie.Prejeu);
				TaskDebutPartie start = new TaskDebutPartie(main);
				start.runTaskTimer(main, 0, 20);
				
				
				
				/*GGameCycle cycle = new GGameCycle(main);
				cycle.runTaskTimer(main, 0, 20);*/
					
				cancel();
			}
		}

		
		timer--;
		
	}

}
