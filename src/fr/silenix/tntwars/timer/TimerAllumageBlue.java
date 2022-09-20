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


public class TimerAllumageBlue extends BukkitRunnable{
	
	
	private GMain main;
	
	
	
	
	
	public TimerAllumageBlue(GMain main) {
		this.main = main;
	}
	
	
	@Override
	public void run() {
		if(main.tnt_bleu.getEtat()==EtatTNT.Eteinte){
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eExplosion §98bleue  §eévitée.");
			main.timer_blue= 30;
			cancel();
		}
		else if(main.isState(EtatPartie.FinJeu)) {
			cancel();
		} 
		else if (main.timer_blue==30 && main.tnt_bleu.getEtat()==EtatTNT.Allume) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §630 §bsecondes avant l'explosion de la TNT §9bleu§e.");
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);
			}
		}
		else if (main.timer_blue==25 ||main.timer_blue==20 || main.timer_blue==15 || main.timer_blue==10 || main.timer_blue==5 || main.timer_blue==3 || main.timer_blue==2 ) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6"+ main.timer_blue + " §esecondes avant l'explosion de la TNT §9bleu§e.");
		}
		else if (main.timer_blue==1) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6"+ main.timer_blue + " §eseconde avant l'explosion de la TNT §9bleu§e.");
		}
		else if (main.timer_blue==0) {
			main.tnt_bleu.setEtat(EtatTNT.Explose);
			main.CheckWin();
				
			Bukkit.getWorld("world").spawnParticle(Particle.EXPLOSION_HUGE, main.map_en_cours.getLocationTntArray(1),100, 1,1,1 );
			
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				if(joueur.getEquipe()==main.Equipe_bleu) {
					joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
				}
				joueur.getPlayer().playSound(main.map_en_cours.getLocationTntArray(1), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 3F, 1F);
			}
			cancel();
		}
		if (main.timer_blue!=0) {
			main.timer_blue--;
		}
		Bukkit.getWorld("world").spawnParticle(Particle.LAVA, main.map_en_cours.getLocationTntArray(0),100, 1,1,1 );
		for(int i=0; i < main.listeJoueurs.size(); i++) {
			Joueur joueur = main.listeJoueurs.get(i);
			joueur.getPlayer().playSound(main.map_en_cours.getLocationTntArray(1), Sound.ENTITY_CREEPER_PRIMED, 0.6F, 0.6F);
		}
	}
}
