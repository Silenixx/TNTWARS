package fr.silenix.tntwars.tasks;

import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;

public class TaskRejoindPartieEnCours extends BukkitRunnable {
	private GMain main;
	private Joueur joueur;
	static World world = Bukkit.getWorld("world");
	private int timer = 10;

	public TaskRejoindPartieEnCours(GMain main, Joueur joueur) {
		this.main = main;
		this.joueur = joueur;
	}

	public void run() {
		if (this.joueur.getEquipe() != this.main.Sans_Equipe) {

			if (this.timer == 35 || this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3
					|| this.timer == 2 || this.timer == 1 || this.timer == 0) {
				this.joueur.getPlayer().sendMessage(Constante.Constantes.PluginName
						+ "Vous allez rejoindre la partie dans §5" + this.timer + "§b secondes.");
				if (this.timer == 0) {
					this.joueur.getPlayer().sendMessage(
							Constante.Constantes.PluginName + "Vous avez rejoind le jeu. Amusez vous bien!");
					if (this.joueur.getKit() == this.main.Sans_Kit) {
						this.joueur.setKit(this.main.list_kits.get(0));
						this.joueur.setProchainKit(this.main.list_kits.get(0));
					}
					this.joueur.getPlayer().getInventory().clear();
					this.main.respawn(this.joueur.getPlayer());
					cancel();
				}
			}
			this.timer--;
		}
	}
}
