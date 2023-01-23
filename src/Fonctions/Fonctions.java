/*     */ package Fonctions;
/*     */ 
/*     */ import fr.silenix.tntwars.GMain;
/*     */ import fr.silenix.tntwars.entity.Joueur;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Fonctions
/*     */ {
/*     */   public static boolean stillPlayer(GMain main, String couleurEquipe) {
/*  18 */     boolean IsPresenceJoueur = false;
/*     */     
/*  20 */     for (Joueur joueur : main.listeJoueurs) {
/*  21 */       if (joueur.getEquipe().getCouleur() == couleurEquipe) {
/*  22 */         IsPresenceJoueur = true;
/*     */       }
/*     */     } 
/*  25 */     return IsPresenceJoueur;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double getDirectionVue(Player player) {
/*  81 */     double rotation = (player.getLocation().getYaw() - 180.0F);
/*  82 */     double retour = 0.0D;
/*  83 */     if (rotation < 0.0D) {
/*  84 */       rotation += 360.0D;
/*     */     }
/*  86 */     player.sendMessage(Double.toString(rotation));
/*  87 */     if (0.0D <= rotation && rotation < 22.5D) {
/*  88 */       player.sendMessage("North");
/*  89 */       retour = rotation;
/*     */     } 
/*  91 */     if (22.5D <= rotation && rotation < 67.5D) {
/*  92 */       player.sendMessage("NorthEast");
/*  93 */       retour = rotation;
/*     */     } 
/*  95 */     if (67.5D <= rotation && rotation < 112.5D) {
/*  96 */       player.sendMessage("East");
/*  97 */       retour = rotation;
/*     */     } 
/*  99 */     if (112.5D <= rotation && rotation < 157.5D) {
/* 100 */       player.sendMessage("SouthEast");
/* 101 */       retour = rotation;
/*     */     } 
/* 103 */     if (157.5D <= rotation && rotation < 202.5D) {
/* 104 */       player.sendMessage("South");
/* 105 */       retour = rotation;
/*     */     } 
/* 107 */     if (202.5D <= rotation && rotation < 247.5D) {
/* 108 */       player.sendMessage("SouthWest");
/* 109 */       retour = rotation;
/*     */     } 
/* 111 */     if (247.5D <= rotation && rotation < 292.5D) {
/* 112 */       player.sendMessage("West");
/* 113 */       retour = rotation;
/*     */     } 
/* 115 */     if (292.5D <= rotation && rotation < 337.5D) {
/* 116 */       player.sendMessage("NorthWest");
/* 117 */       retour = rotation;
/*     */     } 
/* 119 */     if (337.5D <= rotation && rotation <= 360.0D) {
/* 120 */       player.sendMessage("North");
/* 121 */       retour = rotation;
/*     */     } 
/* 123 */     return retour;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\Fonctions\Fonctions.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */