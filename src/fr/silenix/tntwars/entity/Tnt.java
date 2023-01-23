/*    */ package fr.silenix.tntwars.entity;
/*    */ 
/*    */ import Enum.EtatTNT;
/*    */ import org.bukkit.Location;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Tnt
/*    */ {
/*    */   private Equipe Equipe;
/*    */   private int Vie;
/*    */   private EtatTNT Etat;
/*    */   private int Timer;
/*    */   private int Index;
/*    */   private Location location;
/*    */   
/*    */   public Tnt(Equipe equipe, int Vie, EtatTNT Etat, int Timer, int Index, Location location) {
/* 19 */     this.Equipe = equipe;
/* 20 */     this.Vie = Vie;
/* 21 */     this.Etat = Etat;
/* 22 */     this.Timer = Timer;
/* 23 */     this.Index = Index;
/* 24 */     this.location = location;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Location getLocation() {
/* 32 */     return this.location;
/*    */   }
/*    */   public void setLocation(Location location) {
/* 35 */     this.location = location;
/*    */   }
/*    */   public Equipe getEquipe() {
/* 38 */     return this.Equipe;
/*    */   }
/*    */   public void setEquipe(Equipe equipe) {
/* 41 */     this.Equipe = equipe;
/*    */   }
/*    */   public int getVie() {
/* 44 */     return this.Vie;
/*    */   }
/*    */   public void setVie(int vie) {
/* 47 */     this.Vie = vie;
/*    */   }
/*    */   public EtatTNT getEtat() {
/* 50 */     return this.Etat;
/*    */   }
/*    */   public void setEtat(EtatTNT etat) {
/* 53 */     this.Etat = etat;
/*    */   }
/*    */   public int getTimer() {
/* 56 */     return this.Timer;
/*    */   }
/*    */   public void setTimer(int timer) {
/* 59 */     this.Timer = timer;
/*    */   }
/*    */   public int getIndex() {
/* 62 */     return this.Index;
/*    */   }
/*    */   public void setIndex(int index) {
/* 65 */     this.Index = index;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\entity\Tnt.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */