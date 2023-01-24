 package fr.silenix.tntwars.entity;
 
 import org.bukkit.Material;
 
 
 
 
 
 public class Equipe
 {
   private String Couleur;
   private boolean IsAlive;
   private Material laine;
   private Material BlockTactique;
   
   public Equipe(String Couleur, boolean IsAlive, Material laine, Material BlockTactique) {
     this.Couleur = Couleur;
     this.IsAlive = IsAlive;
     this.laine = laine;
     this.BlockTactique = BlockTactique;
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
 }


