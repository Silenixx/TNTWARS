package fr.silenix.tntwars.tasks;

import Enum.EtatPartie;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskDebutPartie extends BukkitRunnable {
	private int timer = 30;
	private GMain main;

	public TaskDebutPartie(GMain main) {
		this.main = main;
	}

	public void run() {
		if (main.listeJoueurs.size() < 2) {
			Bukkit.broadcastMessage(
					Constante.Constantes.PluginName + "Annulation de début de partie par manque de joueur");
			cancel();
			for (int i = 0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				joueur.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), 6.0D, 1.0D, 1.0D));
				joueur.getPlayer().setExp(0.0F);
				joueur.getPlayer().setFlying(false);
				joueur.getPlayer().setAllowFlight(false);
				
			}
			main.setState(EtatPartie.AttenteJoueur);
		} else if (main.isState(EtatPartie.Prejeu)) {
			for (Joueur pls : main.listeJoueurs) {
				pls.getPlayer().setLevel(this.timer);
			}
			if (this.timer == 45 || this.timer == 30 || this.timer == 20 || this.timer == 10 || this.timer == 5
					|| this.timer == 4 || this.timer == 3 || this.timer == 2 || this.timer == 1) {
				Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Lancement de la partie dans §6" + this.timer
						+ "§e secondes.");
				if (this.timer == 30) {
					Bukkit.broadcastMessage(Constante.Constantes.PluginName + Constante.Constantes.PluginRules);
				}
			} else if (this.timer == 0) {
				Bukkit.broadcastMessage(
						Constante.Constantes.PluginName + "Lancement de la partie! Que la meilleure équipe gagne!");
				main.setState(EtatPartie.JeuEnCours);
				main.AutoAddTeam(main.map_en_cours.getNbEquipe());
				for (int i = 0; i < main.listeJoueurs.size(); i++) {
					Joueur joueur = main.listeJoueurs.get(i);
					main.SpawnTeleportation(joueur);
					joueur.getPlayer().getInventory().clear();
					if (joueur.getProchainKit() == main.Sans_Kit) {
						joueur.setProchainKit(main.list_kits.get(0));
					}
					main.GamePlay(joueur);
				}
				//main.CheckWin();
				cancel();
			}
		}
		this.timer--;
	}
}
