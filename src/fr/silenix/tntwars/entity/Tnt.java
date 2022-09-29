package fr.silenix.tntwars.entity;

import Enum.EtatTNT;

public class Tnt {
	private Equipe Equipe;
	private int Vie;
	private EtatTNT Etat;
	private int Timer;
	private int Index;
	
	
	
	public Tnt(Equipe Equipe, int Vie, EtatTNT Etat, int Timer, int Index) {
		super();
		this.Equipe=Equipe;
		this.Vie=Vie;
		this.Etat=Etat;
		this.Timer = Timer;
		this.Index = Index;
	}
	
	
	
	
	
	public Equipe getEquipe() {
		return Equipe;
	}
	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}
	public int getVie() {
		return Vie;
	}
	public void setVie(int vie) {
		Vie = vie;
	}
	public EtatTNT getEtat() {
		return Etat;
	}
	public void setEtat(EtatTNT etat) {
		Etat = etat;
	}
	public int getTimer() {
		return Timer;
	}
	public void setTimer(int timer) {
		Timer = timer;
	}
	public int getIndex() {
		return Index;
	}
	public void setIndex(int index) {
		Index = index;
	}
	
	

}
