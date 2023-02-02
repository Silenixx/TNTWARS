package fr.silenix.tntwars.timer;

import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Equipe;
import fr.silenix.tntwars.entity.Joueur;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Wolf;
import org.bukkit.scheduler.BukkitRunnable;

import Fonctions.IndexKit;

public class TimerRedemarrage extends BukkitRunnable {
	private GMain main;
	private int timer = 30;

	public TimerRedemarrage(GMain main) {
		this.main = main;
	}

	public void run() {
		if (this.timer == 30) {
			Equipe gagnant = this.main.RenvoieGagnant();

			Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Victoire de la team: " + gagnant.getCouleur());
			Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Redemmarage du mode de jeu dans §6" + this.timer
					+ " §esecondes.");
		}
		for ( Joueur joueur : main.listeJoueurs) {
			if (joueur.getKit() == main.list_kits.get(IndexKit.DogMaster)) {
				for (Entity entity : joueur.getPlayer().getWorld().getEntities()) {
					if (entity instanceof Wolf) {
						Wolf wolf = (Wolf) entity;
						if (wolf.getOwner() != null) {
							if (wolf.getOwner().getName() == joueur.getPlayer().getName()) {
								wolf.setTarget(joueur.getPlayer());
	
							}
						}
	
					}
				}
			}
			if (joueur.getKit() == main.list_kits.get(IndexKit.Pirate)) {
				for (Entity entity : joueur.getPlayer().getWorld().getEntities()) {
					if (entity instanceof Parrot) {
						Parrot parrot = (Parrot) entity;
						if (parrot.getOwner() != null) {
							if (parrot.getOwner().getName() == joueur.getPlayer().getName()) {
								parrot.setTarget(joueur.getPlayer());
	
							}
						}
	
					}
				}
			}
		}
		

		

		if (this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2) {
			Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Redemmarage du mode de jeu dans §6" + this.timer
					+ " §esecondes.");
		}

		if (this.timer == 1) {
			Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Redemmarage du mode de jeu dans §61 §eseconde.");
		}
		if (this.timer == 0) {
			Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Redemmarage du mode de jeu.");
			this.main.remiseazero();
			cancel();
		}

		this.timer--;
	}
}
