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
import fr.silenix.tntwars.entity.Tnt;

public class TimerAllumage extends BukkitRunnable{
	
	
	private GMain main;
	private String couleur;
	
	public TimerAllumage(GMain main, String couleur) {
		this.main = main;
		this.couleur = couleur;
	}
		
	
	@Override
	public void run() {
    
    
	    Tnt tnt = main.listTnt.stream()
	      .filter(t->t.getEquipe().getCouleur().equals(couleur))
	      .findFirst()
	      .get();
    
    
		if(tnt.getEtat()==EtatTNT.Eteinte){
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eExplosion Tnt "+ couleur+"  §eévitée.");
			tnt.setVie(0);
			tnt.setTimer(30);
			cancel();
		}
		else if(main.isState(EtatPartie.FinJeu)) {
			cancel();
		} 
		else if (tnt.getTimer()==30 && tnt.getEtat()==EtatTNT.Allume) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §630 §bsecondes avant l'explosion de la TNT "+ couleur +".");
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				joueur.getPlayer().playSound(joueur.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);
			}
		}
		else if (tnt.getTimer()==25 ||tnt.getTimer()==20 || tnt.getTimer()==15 || tnt.getTimer()==10 || tnt.getTimer()==5 ||tnt.getTimer()==3 || tnt.getTimer()==2 ) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6"+ tnt.getTimer() + " §esecondes avant l'explosion de la TNT "+couleur+".");
		}
		else if (tnt.getTimer()==1) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eIl reste §6"+ tnt.getTimer() + " §eseconde avant l'explosion de la TNT "+couleur+".");
		}
		else if (tnt.getTimer()==0) {
			tnt.setEtat(EtatTNT.Explose);
			main.CheckWin();
				
			Bukkit.getWorld("world").spawnParticle(Particle.EXPLOSION_HUGE, main.map_en_cours.getLocationTntArray(tnt.getIndex()),100, 1,1,1 );
			
			for(int i=0; i < main.listeJoueurs.size(); i++) {
				Joueur joueur = main.listeJoueurs.get(i);
				if(joueur.getEquipe()==tnt.getEquipe()) {
					joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
				}
				joueur.getPlayer().playSound(main.map_en_cours.getLocationTntArray(tnt.getIndex()), Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 3F, 1F);
			}
			cancel();
		}
		if (tnt.getTimer()!=0) {
			tnt.setTimer(tnt.getTimer()-1);
		}
		Bukkit.getWorld("world").spawnParticle(Particle.LAVA, main.map_en_cours.getLocationTntArray(tnt.getIndex()),100, 1,1,1 );
		for(int i=0; i < main.listeJoueurs.size(); i++) {
			Joueur joueur = main.listeJoueurs.get(i);
			joueur.getPlayer().playSound(main.map_en_cours.getLocationTntArray(tnt.getIndex()), Sound.ENTITY_CREEPER_PRIMED, 0.6F, 0.6F);
		}
	}
}