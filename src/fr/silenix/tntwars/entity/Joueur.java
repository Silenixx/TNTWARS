/*    */ package fr.silenix.tntwars.entity;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Joueur
/*    */ {
/*    */   private Player player;
/*    */   private String Nom;
/*    */   private Equipe Equipe;
/*    */   private Kit Kit;
/*    */   private Kit ProchainKit;
/*    */   
/*    */   public Joueur(Player player, String Nom, Equipe equipe, Kit kit1, Kit ProchainKit) {
/* 17 */     this.player = player;
/* 18 */     this.Nom = Nom;
/* 19 */     this.Equipe = equipe;
/* 20 */     this.Kit = kit1;
/* 21 */     this.ProchainKit = ProchainKit;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Equipe getEquipe() {
/* 27 */     return this.Equipe;
/*    */   }
/*    */   public void setNom(String nom) {
/* 30 */     this.Nom = nom;
/*    */   }
/*    */   public String getNom() {
/* 33 */     return this.Nom;
/*    */   }
/*    */   public void setEquipe(Equipe equipe) {
/* 36 */     this.Equipe = equipe;
/*    */   }
/*    */   public Player getPlayer() {
/* 39 */     return this.player;
/*    */   }
/*    */   public void setPlayer(Player player) {
/* 42 */     player = this.player;
/*    */   }
/*    */   public Kit getKit() {
/* 45 */     return this.Kit;
/*    */   }
/*    */   public void setKit(Kit kit) {
/* 48 */     this.Kit = kit;
/*    */   }
/*    */   public Kit getProchainKit() {
/* 51 */     return this.ProchainKit;
/*    */   }
/*    */   public void setProchainKit(Kit prochainkit) {
/* 54 */     this.ProchainKit = prochainkit;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\entity\Joueur.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */