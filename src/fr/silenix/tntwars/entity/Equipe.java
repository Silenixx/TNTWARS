package fr.silenix.tntwars.entity;

import org.bukkit.inventory.ItemStack;
import org.bukkit.scoreboard.Team;



public class Equipe {

    private String Couleur;
    private Team ScoreBoardTeam;
    private boolean IsAlive;
    private ItemStack laine;


    
    
    
    public Equipe(String Couleur, Team scoreBoardTeam, boolean IsAlive, ItemStack laine) {
    	super();
    	this.Couleur=Couleur;
    	this.ScoreBoardTeam = scoreBoardTeam;
    	this.IsAlive=IsAlive;
    	this.laine=laine;
	}
    
    
	

	public String getCouleur() {
        return Couleur;
    }
 
    public void setCouleur(String couleur) {
        this.Couleur = couleur;
    }

    public Team getScoreBoardTeam() {
        return ScoreBoardTeam;
    }
 
    public void setScoreBoardTeam(Team scoreBoardTeam) {
        this.ScoreBoardTeam = scoreBoardTeam;
    }
    
    

    public boolean getIsAlive() {
        return IsAlive;
    }
 
    public void setIsAlive(boolean isAlive) {
        this.IsAlive = isAlive;
    }
    public ItemStack getLaine() {
        return laine;
    }
 
    public void setLaine(ItemStack laine) {
        this.laine = laine;
    }
    
    



}






