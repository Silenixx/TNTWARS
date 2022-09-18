package fr.silenix.tntwars.tasks;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import Enum.EtatPartie;
import Fonctions.IndexKit;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;

public class TaskDebutPartie extends BukkitRunnable{
	private int timer = 20;
	private GMain main;
	
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
		else if(main.isState(EtatPartie.Prejeu)) {
			for(Joueur pls : main.listeJoueurs) {
				pls.getPlayer().setLevel(timer);
			}
			if(timer==45 || timer ==30 || timer ==20 || timer ==10 || timer ==5 || timer==4 || timer==3|| timer==2|| timer==1) {
				Bukkit.broadcastMessage("§6[§eTntWars§6] §eLancement de la partie dans §6" + timer +"§e secondes.");
			}
			else if(timer == 0) {
				Bukkit.broadcastMessage("§6[§eTntWars§6] §eLancement de la partie! Que la meilleure équipe gagne!");
				main.setState(EtatPartie.JeuEnCours);
				main.AutoAddTeam(main.map_en_cours.getNbEquipe());
				for(int i=0; i < main.listeJoueurs.size(); i++) {
					Joueur joueur = main.listeJoueurs.get(i);
					main.SpawnTeleportation(joueur);
					joueur.getPlayer().getInventory().clear();
					if(joueur.getProchainKit()==main.list_kits.get(IndexKit.Sans_Kit)) {
						joueur.setProchainKit(main.list_kits.get(IndexKit.Guerrier));
					}
					main.GamePlay(joueur);
				}
				main.CheckWin();
				cancel();
			}
		}
		timer--;
	}
}