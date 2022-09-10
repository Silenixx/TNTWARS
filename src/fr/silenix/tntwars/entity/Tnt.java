package fr.silenix.tntwars.entity;

import org.bukkit.Location;

import Enum.EtatTNT;

public class Tnt {
	private Equipe Equipe;
	private int Vie;
	private EtatTNT Etat;
	
	
	
	public Tnt(Equipe Equipe, int Vie, EtatTNT Etat) {
		Equipe = this.Equipe;
		Vie = this.Vie;
		Etat = this.Etat;
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
	
	

}
