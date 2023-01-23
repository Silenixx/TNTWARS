/*    */ package fr.silenix.tntwars.entity;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.bukkit.Location;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Map
/*    */ {
/*    */   public int NbEquipe;
/*    */   public String Nom;
/*    */   public Location LocationSalleMort;
/*    */   public ArrayList<Location> LocationSpawnEquipeArray;
/*    */   public ArrayList<Location> LocationTntArray;
/*    */   public Location LocationVisite;
/*    */   public Location LocationMapBorne1;
/*    */   public Location LocationMapBorne2;
/*    */   
/*    */   public Map(int NbEquipe, String Nom, Location LocationSalleMort, ArrayList<Location> LocationSpawnEquipeArray, ArrayList<Location> LocationTntArray, Location LocationVisite, Location LocationMapBorne1, Location LocationMapBorne2) {
/* 22 */     this.NbEquipe = NbEquipe;
/* 23 */     this.Nom = Nom;
/* 24 */     this.LocationSalleMort = LocationSalleMort;
/* 25 */     this.LocationSpawnEquipeArray = LocationSpawnEquipeArray;
/* 26 */     this.LocationTntArray = LocationTntArray;
/* 27 */     this.LocationVisite = LocationVisite;
/* 28 */     this.LocationMapBorne1 = LocationMapBorne1;
/* 29 */     this.LocationMapBorne2 = LocationMapBorne2;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getNbEquipe() {
/* 37 */     return this.NbEquipe;
/*    */   }
/*    */   public void setNbEquipe(int nbEquipe) {
/* 40 */     this.NbEquipe = nbEquipe;
/*    */   }
/*    */   public String getNom() {
/* 43 */     return this.Nom;
/*    */   }
/*    */   public void setNom(String nom) {
/* 46 */     this.Nom = nom;
/*    */   }
/*    */   public Location getLocationSalleMort() {
/* 49 */     return this.LocationSalleMort;
/*    */   }
/*    */   public void setLocationSalleMort(Location locationSalleMort) {
/* 52 */     this.LocationSalleMort = locationSalleMort;
/*    */   }
/*    */   public Location getLocationSpawnEquipeArray(int equipe) {
/* 55 */     return this.LocationSpawnEquipeArray.get(equipe);
/*    */   }
/*    */   public void setLocationSpawnEquipeArray(ArrayList<Location> locationSpawnEquipeArray) {
/* 58 */     this.LocationSpawnEquipeArray = locationSpawnEquipeArray;
/*    */   }
/*    */   public Location getLocationTntArray(int tnt) {
/* 61 */     return this.LocationTntArray.get(tnt);
/*    */   }
/*    */   public void setTntArray(ArrayList<Location> LocationtntArray) {
/* 64 */     this.LocationTntArray = LocationtntArray;
/*    */   }
/*    */   public Location getLocationVisite() {
/* 67 */     return this.LocationVisite;
/*    */   }
/*    */   public void setLocationVisite(Location locationVisite) {
/* 70 */     this.LocationVisite = locationVisite;
/*    */   }
/*    */   public Location getLocationMapBorne1() {
/* 73 */     return this.LocationMapBorne1;
/*    */   }
/*    */   public void setLocationMapBorne1(Location locationMapBorne1) {
/* 76 */     this.LocationMapBorne1 = locationMapBorne1;
/*    */   }
/*    */   public Location getLocationMapBorne2() {
/* 79 */     return this.LocationMapBorne2;
/*    */   }
/*    */   public void setLocationMapBorne2(Location locationMapBorne2) {
/* 82 */     this.LocationMapBorne2 = locationMapBorne2;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\entity\Map.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */