package fr.silenix.tntwars.entity;

import Enum.EtatTNT;
import org.bukkit.Location;

public class Tnt {
	private Equipe Equipe;
	private int Vie;
	private EtatTNT Etat;
	private int Timer;
	private int Index;
	private Location location;

	public Tnt(Equipe equipe, int Vie, EtatTNT Etat, int Timer, int Index, Location location) {
		this.Equipe = equipe;
		this.Vie = Vie;
		this.Etat = Etat;
		this.Timer = Timer;
		this.Index = Index;
		this.location = location;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Equipe getEquipe() {
		return this.Equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.Equipe = equipe;
	}

	public int getVie() {
		return this.Vie;
	}

	public void setVie(int vie) {
		this.Vie = vie;
	}

	public EtatTNT getEtat() {
		return this.Etat;
	}

	public void setEtat(EtatTNT etat) {
		this.Etat = etat;
	}

	public int getTimer() {
		return this.Timer;
	}

	public void setTimer(int timer) {
		this.Timer = timer;
	}

	public int getIndex() {
		return this.Index;
	}

	public void setIndex(int index) {
		this.Index = index;
	}
}
