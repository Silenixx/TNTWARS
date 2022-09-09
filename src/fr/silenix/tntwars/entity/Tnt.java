package fr.silenix.tntwars.entity;

import org.bukkit.Location;

import Enum.EtatTNT;

public class Tnt {
	private Equipe Equipe;
	private int Timer;
	private EtatTNT Etat;
	
	
	
	public Tnt(Equipe Equipe, int Timer, EtatTNT Etat) {
		Equipe = this.Equipe;
		Timer = this.Timer;
		Etat = this.Etat;
	}
	
	
	
	
	
	public Equipe getEquipe() {
		return Equipe;
	}
	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
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
