package fr.silenix.tntwars.entity;

import org.bukkit.Location;

import Enum.EtatTNT;

public class Tnt {
	private Equipe Equipe;
	private Location Location;
	private int Timer;
	private EtatTNT Etat;
	
	
	
	public Equipe getEquipe() {
		return Equipe;
	}
	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}
	public Location getLocation() {
		return Location;
	}
	public void setLocation(Location location) {
		Location = location;
	}
	public int getTimer() {
		return Timer;
	}
	public void setTimer(int timer) {
		Timer = timer;
	}
	public EtatTNT getEtat() {
		return Etat;
	}
	public void setEtat(EtatTNT etat) {
		Etat = etat;
	}
	
	

}
