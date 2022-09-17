package fr.silenix.tntwars.entity;
import org.bukkit.inventory.ItemStack;

public class Equipe {

    private String Couleur;
    /*private Team ScoreBoardTeam;*/
    private boolean IsAlive;
    private ItemStack laine;

    public Equipe(String Couleur, boolean IsAlive, ItemStack laine) {
    	super();
    	this.Couleur=Couleur;
    	this.IsAlive=IsAlive;
    	this.laine=laine;
	}
    
	public String getCouleur() {
        return Couleur;
    }
    public void setCouleur(String couleur) {
        this.Couleur = couleur;
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