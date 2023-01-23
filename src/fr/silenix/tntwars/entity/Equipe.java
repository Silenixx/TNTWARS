/*    */ package fr.silenix.tntwars.entity;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Equipe
/*    */ {
/*    */   private String Couleur;
/*    */   private boolean IsAlive;
/*    */   private Material laine;
/*    */   private Material BlockTactique;
/*    */   
/*    */   public Equipe(String Couleur, boolean IsAlive, Material laine, Material BlockTactique) {
/* 17 */     this.Couleur = Couleur;
/* 18 */     this.IsAlive = IsAlive;
/* 19 */     this.laine = laine;
/* 20 */     this.BlockTactique = BlockTactique;
/*    */   }
/*    */   
/*    */   public String getCouleur() {
/* 24 */     return this.Couleur;
/*    */   }
/*    */   public void setCouleur(String couleur) {
/* 27 */     this.Couleur = couleur;
/*    */   }
/*    */   public boolean getIsAlive() {
/* 30 */     return this.IsAlive;
/*    */   }
/*    */   public void setIsAlive(boolean isAlive) {
/* 33 */     this.IsAlive = isAlive;
/*    */   }
/*    */   public Material getLaine() {
/* 36 */     return this.laine;
/*    */   }
/*    */   public void setLaine(Material laine) {
/* 39 */     this.laine = laine;
/*    */   }
/*    */   public Material getBlockTactique() {
/* 42 */     return this.BlockTactique;
/*    */   }
/*    */   public void setBlockTactique(Material BlockTactique) {
/* 45 */     this.BlockTactique = BlockTactique;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\entity\Equipe.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */