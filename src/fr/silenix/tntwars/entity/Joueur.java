package fr.silenix.tntwars.entity;

import org.bukkit.entity.Player;

public class Joueur {
	
	private Player player;
	private String Nom;
	private Equipe Equipe;
	private Kit Kit;
	
	
	
	public Joueur(Player Player,String Nom, Equipe Equipe, Kit Kit) {
		super();
		this.player=Player;
		this.Nom=Nom;
		this.Equipe=Equipe;
		this.Kit=Kit;
	}
	
	
	
	public Equipe getEquipe() {
		return Equipe;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getNom() {
		return Nom;
	}
	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player Player) {
		Player = player;
	}
	public Kit getKit() {
		return Kit;
	}
	public void setKit(Kit kit) {
		Kit = kit;
	}
	
	
	
}
