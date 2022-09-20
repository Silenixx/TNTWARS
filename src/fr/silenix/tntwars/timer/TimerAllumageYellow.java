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

public class TimerAllumageYellow extends BukkitRunnable{
	
	
	private GMain main;
	
	
	
	
	
	public TimerAllumageYellow(GMain main) {
		this.main = main;
	}
	
	
	
	
	@Override
	public void run() {
		if(main.tnt_jaune.getEtat()==EtatTNT.Eteinte){
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eExplosion §98jaunee  §eévitée.");
			main.timer_yellow= 30;
			cancel();
		}
		else if(main.isState(EtatPartie.FinJeu)) {
			cancel();
		} 
		else if (main.timer_yellow==30 && main.tnt_jaune.getEtat()==EtatTNT.Allume) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §630 §bsecondes avant l'explosion de la TNT §9jaune§e.");
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);
			}
		}
		else if (main.timer_yellow==25 ||main.timer_yellow==20 || main.timer_yellow==15 || main.timer_yellow==10 || main.timer_yellow==5 || main.timer_yellow==3 || main.timer_yellow==2 ) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6"+ main.timer_yellow + " §esecondes avant l'explosion de la TNT §9jaune§e.");
		}
		else if (main.timer_yellow==1) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6"+ main.timer_yellow + " §eseconde avant l'explosion de la TNT §9jaune§e.");
		}
		else if (main.timer_yellow==0) {
			main.tnt_jaune.setEtat(EtatTNT.Explose);
			main.CheckWin();
				
			Bukkit.getWorld("world").spawnParticle(Particle.EXPLOSION_HUGE, main.map_en_cours.getLocationTntArray(3),100, 1,1,1 );
			
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				if(joueur.getEquipe()==main.Equipe_jaune) {
					joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
				}
				joueur.getPlayer().playSound(main.map_en_cours.getLocationTntArray(3), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 3F, 1F);
			}
			cancel();
		}
		if (main.timer_yellow!=0) {
			main.timer_yellow--;
		}
		Bukkit.getWorld("world").spawnParticle(Particle.LAVA, main.map_en_cours.getLocationTntArray(3),100, 1,1,1 );
		for(int i=0; i < main.listeJoueurs.size(); i++) {
			Joueur joueur = main.listeJoueurs.get(i);
			joueur.getPlayer().playSound(main.map_en_cours.getLocationTntArray(3), Sound.ENTITY_CREEPER_PRIMED, 0.6F, 0.6F);
		}
	}
}
