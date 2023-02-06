package fr.silenix.tntwars.timer;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatPartie;
import Enum.EtatTNT;
import Fonctions.Fonctions;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.entity.Tnt;

public class TimerVictoire extends BukkitRunnable {

	private GMain main;

	public TimerVictoire(GMain main) {
		this.main = main;
	}

	public void run() {
		if (main.isState(EtatPartie.JeuEnCours)) {
			
			
		

			for (Location location : main.map_en_cours.getLocationTntArray2()) {
				if (location.getBlock().getType() != Material.TNT) {
					location.getBlock().setType(Material.TNT);
				}
			}
			
			
		}

	}
	
}
