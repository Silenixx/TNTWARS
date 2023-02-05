package fr.silenix.tntwars.timer;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerImmortality extends BukkitRunnable {
	private int timer = 3;

	private Player player;

	/*private GMain main;*/

	public TimerImmortality(/*GMain main,**/ Player player) {
		/*this.main = main;*/
		this.player = player;
	}

	public void run() {
		if (this.timer == 3) {
			this.player.setInvulnerable(true);
			// this.player.sendMessage(Constante.Constantes.PluginName + "Immortalité
			// pendant 3 §bsecondes");
		}
		if (this.timer == 2) {
			// this.player.sendMessage(Constante.Constantes.PluginName + "Immortalité
			// pendant 2 §bsecondes");
		}
		if (this.timer == 1) {
			// this.player.sendMessage(Constante.Constantes.PluginName + "Immortalité
			// pendant 1 §bseconde");
		}
		if (this.timer == 0) {
			// this.player.sendMessage(Constante.Constantes.PluginName + "Fin
			// d'Immortalité");

			this.player.setInvulnerable(false);
			cancel();
		}

		this.timer--;
	}
}
