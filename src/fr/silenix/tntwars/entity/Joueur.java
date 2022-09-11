package fr.silenix.tntwars.entity;


import org.bukkit.entity.Player;

public class Joueur {
	
	public Player player;
	public String Nom;
	public Equipe Equipe;
	public Kit Kit;
	
	
	
	public Joueur(Player Player,String Nom, Equipe Equipe, Kit Kit) {
		Player = this.player;
		Nom = this.Nom;
		Equipe = this.Equipe;
		Kit = this.Kit;
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
	public Player get_the_player() {
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
