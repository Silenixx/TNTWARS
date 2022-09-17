package fr.silenix.tntwars.timer;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatPartie;
import Enum.EtatTNT;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;

public class TimerAllumageRed extends BukkitRunnable{
	
	
	private GMain main;
	
	public TimerAllumageRed(GMain main) {
		this.main = main;
	}
		
	
	@Override
	public void run() {
		if(main.tnt_rouge.getEtat()==EtatTNT.Eteinte){
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eExplosion §98rougee  §eévitée.");
			main.timer_red= 30;
			cancel();
		}
		else if(main.isState(EtatPartie.FinJeu)) {
			cancel();
		} 
		else if (main.timer_red==30 && main.tnt_rouge.getEtat()==EtatTNT.Allume) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §630 §bsecondes avant l'explosion de la TNT §9rouge§e.");
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);
			}
		}
		else if (main.timer_red==25 ||main.timer_red==20 || main.timer_red==15 || main.timer_red==10 || main.timer_red==5 || main.timer_red==3 || main.timer_red==2 ) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6"+ main.timer_red + " §esecondes avant l'explosion de la TNT §9rouge§e.");
		}
		else if (main.timer_red==1) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6"+ main.timer_red + " §eseconde avant l'explosion de la TNT §9rouge§e.");
		}
		else if (main.timer_red==0) {
			main.tnt_rouge.setEtat(EtatTNT.Explose);
			main.CheckWin();
				
			Bukkit.getWorld("world").spawnParticle(Particle.EXPLOSION_HUGE, main.map_en_cours.getLocationTntArray(0),100, 1,1,1 );
			
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				if(joueur.getEquipe()==main.Equipe_rouge) {
					joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
				}
				joueur.getPlayer().playSound(main.map_en_cours.getLocationTntArray(0), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 3F, 1F);
			}
			cancel();
		}
		if (main.timer_red!=0) {
			main.timer_red--;
		}
		Bukkit.getWorld("world").spawnParticle(Particle.LAVA, main.map_en_cours.getLocationTntArray(0),100, 1,1,1 );
		for(int i=0; i < main.listeJoueurs.size(); i++) {
			Joueur joueur = main.listeJoueurs.get(i);
			joueur.getPlayer().playSound(main.map_en_cours.getLocationTntArray(0), Sound.ENTITY_CREEPER_PRIMED, 0.6F, 0.6F);
		}
	}
}
