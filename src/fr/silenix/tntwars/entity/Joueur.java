package fr.silenix.tntwars.entity;

import org.bukkit.entity.Player;

public class Joueur {

	private Equipe Equipe;
	private Player Player;
	private Kit Kit;
	
	
	
	
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
