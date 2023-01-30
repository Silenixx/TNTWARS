package fr.silenix.tntwars.entity;

import org.bukkit.Color;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class Equipe {
	private String Couleur;
	private boolean IsAlive;
	private Material laine;
	private Material BlockTactique;
	private Color Color;
	private ChatColor ChatColor;

	public Equipe(String Couleur, boolean IsAlive, Material laine, Material BlockTactique, Color Color,
			ChatColor chatcolor) {
		this.Couleur = Couleur;
		this.IsAlive = IsAlive;
		this.laine = laine;
		this.BlockTactique = BlockTactique;
		this.Color = Color;
		this.ChatColor = chatcolor;
	}

	public String getCouleur() {
		return this.Couleur;
	}

	public void setCouleur(String couleur) {
		this.Couleur = couleur;
	}

	public boolean getIsAlive() {
		return this.IsAlive;
	}

	public void setIsAlive(boolean isAlive) {
		this.IsAlive = isAlive;
	}

	public Material getLaine() {
		return this.laine;
	}

	public void setLaine(Material laine) {
		this.laine = laine;
	}

	public Material getBlockTactique() {
		return this.BlockTactique;
	}

	public void setBlockTactique(Material BlockTactique) {
		this.BlockTactique = BlockTactique;
	}

	public Color getColor() {
		return this.Color;
	}

	public void setColor(Color Color) {
		this.Color = Color;
	}

	public ChatColor getChatColor() {
		return ChatColor;
	}

	public void setChatColor(ChatColor chatColor) {
		ChatColor = chatColor;
	}

}
