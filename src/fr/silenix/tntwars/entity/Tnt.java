package fr.silenix.tntwars.entity;




import Enum.EtatTNT;

public class Tnt {
	private Equipe Equipe;
	private int Vie;
	private EtatTNT Etat;
	
	
	
	public Tnt(Equipe Equipe, int Vie, EtatTNT Etat) {
		super();
		this.Equipe=Equipe;
		this.Vie=Vie;
		this.Etat=Etat;
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
