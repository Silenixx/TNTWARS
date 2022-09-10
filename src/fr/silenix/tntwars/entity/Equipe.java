package fr.silenix.tntwars.entity;

//import org.bukkit.scoreboard.Team;

public class Equipe {

    private String Couleur;
    //private Team ScoreBoardTeam;
    private boolean IsAlive;


    
    
    
    public Equipe(String Couleur, boolean IsAlive) {
		Couleur = this.Couleur;
		IsAlive = this.IsAlive;
	}
    
    
	

	public String getCouleur() {
        return Couleur;
    }
 
    public void setCouleur(String couleur) {
        this.Couleur = couleur;
    }

    /*public Team getScoreBoardTeam() {
        return ScoreBoardTeam;
    }
 
    public void setScoreBoardTeam(Team scoreBoardTeam) {
        this.ScoreBoardTeam = scoreBoardTeam;
    }*/

    public boolean getIsAlive() {
        return IsAlive;
    }
 
    public void setIsAlive(boolean isAlive) {
        this.IsAlive = isAlive;
    }
    
    



}






