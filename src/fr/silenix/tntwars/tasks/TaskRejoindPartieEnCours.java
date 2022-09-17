package fr.silenix.tntwars.tasks;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;
import Fonctions.IndexKit;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;

public class TaskRejoindPartieEnCours extends BukkitRunnable{
	private GMain main;
	private Joueur joueur;
	static World world = Bukkit.getWorld("world");
	private int timer=10;
	
	public TaskRejoindPartieEnCours(GMain main, Joueur joueur) {
		this.main = main;
		this.joueur = joueur;
	}

	
	@Override
	public void run() {

		if(joueur.getEquipe() != main.Sans_Equipe) {
		
			if(timer==35 || timer ==10 || timer ==5 || timer==4 || timer==3|| timer==2|| timer==1 || timer==0) {
				joueur.getPlayer().sendMessage("§5[§dSilenixGames§5] §bVous allez rejoindre la partie dans §5" + timer +"§b secondes.");
				if(timer == 0) {
					joueur.getPlayer().sendMessage("§5[§dSilenixGames§5] §bVous avez rejoind le jeu. Amusez vous bien!");
					if(joueur.getKit()==main.list_kits.get(IndexKit.Sans_Kit)) {
						joueur.setKit(main.list_kits.get(IndexKit.Guerrier));
					}
					joueur.getPlayer().getInventory().clear();
					main.respawn(joueur.getPlayer());
					cancel();
				}
			}
		timer--;
		}
	}	

}