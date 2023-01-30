package fr.silenix.tntwars.timer;

import Constante.Constantes;
import Enum.EtatPartie;
import Enum.EtatTNT;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.entity.Tnt;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerAllumage extends BukkitRunnable {
	private GMain main;
	private String couleur;

	public TimerAllumage(GMain main, String couleur) {
		this.main = main;
		this.couleur = couleur;
	}

	public void run() {
		Tnt tnt = this.main.listTnt.stream().filter(t -> t.getEquipe().getCouleur().equals(this.couleur)).findFirst()
				.get();

		if (tnt.getEtat() == EtatTNT.Eteinte) {
			Bukkit.broadcastMessage(
					String.valueOf(Constantes.PluginName) + " Explosion Tnt " + this.couleur + "  §eévitée.");
			tnt.setVie(0);
			tnt.setTimer(30);
			cancel();
		} else if (this.main.isState(EtatPartie.FinJeu)) {
			cancel();
		} else if (tnt.getTimer() == 30 && tnt.getEtat() == EtatTNT.Allume) {
			Bukkit.broadcastMessage(Constante.Constantes.PluginName
					+ "Il reste §630 §esecondes avant l'explosion de la TNT " + this.couleur + ".");
			for (int j = 0; j < this.main.listeJoueurs.size(); j++) {
				Joueur joueur = this.main.listeJoueurs.get(j);
				joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1.0F,
						1.0F);
			}

		} else if (tnt.getTimer() == 25 || tnt.getTimer() == 20 || tnt.getTimer() == 15 || tnt.getTimer() == 10
				|| tnt.getTimer() == 5 || tnt.getTimer() == 3 || tnt.getTimer() == 2) {
			Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Il reste §6" + tnt.getTimer()
					+ " §esecondes avant l'explosion de la TNT " + this.couleur + ".");
		} else if (tnt.getTimer() == 1) {
			Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Il reste §6" + tnt.getTimer()
					+ " §eseconde avant l'explosion de la TNT " + this.couleur + ".");
		} else if (tnt.getTimer() == 0) {
			tnt.setEtat(EtatTNT.Explose);
			this.main.CheckWin();

			Bukkit.getWorld("world").spawnParticle(Particle.EXPLOSION_HUGE,
					this.main.map_en_cours.getLocationTntArray(tnt.getIndex()), 100, 1.0D, 1.0D, 1.0D);

			for (int j = 0; j < this.main.listeJoueurs.size(); j++) {
				Joueur joueur = this.main.listeJoueurs.get(j);
				if (joueur.getEquipe() == tnt.getEquipe()) {
					joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
				}
				joueur.getPlayer().playSound(this.main.map_en_cours.getLocationTntArray(tnt.getIndex()),
						Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 3.0F, 1.0F);
			}
			cancel();
		}
		if (tnt.getTimer() != 0) {
			tnt.setTimer(tnt.getTimer() - 1);
		}
		Bukkit.getWorld("world").spawnParticle(Particle.LAVA,
				this.main.map_en_cours.getLocationTntArray(tnt.getIndex()), 100, 1.0D, 1.0D, 1.0D);
		for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
			Joueur joueur = this.main.listeJoueurs.get(i);
			joueur.getPlayer().playSound(this.main.map_en_cours.getLocationTntArray(tnt.getIndex()),
					Sound.ENTITY_CREEPER_PRIMED, 0.6F, 0.6F);
			if (joueur.getEquipe() == tnt.getEquipe()) {
				joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.BLOCK_BELL_USE, 0.6F, 0.6F);
			}

		}
	}
}
