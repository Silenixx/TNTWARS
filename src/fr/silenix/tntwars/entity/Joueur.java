package fr.silenix.tntwars.entity;


import org.bukkit.entity.Player;

public class Joueur {
	
	private Player Player;
	private Equipe Equipe;
	private Kit Kit;
	
	
	
	public Joueur(Player Player, Equipe Equipe, Kit Kit) {
		Player = this.Player;
		Equipe = this.Equipe;
		Kit = this.Kit;
	}
	
	
	
	public Equipe getEquipe() {
		return Equipe;
	}
	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
	}
	public Player getPlayer() {
		return Player;
	}
	public void setPlayer(Player player) {
		Player = player;
	}
	public Kit getKit() {
		return Kit;
	}
	public void setKit(Kit kit) {
		Kit = kit;
	}
	
	
	
}
