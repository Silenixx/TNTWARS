 package Fonctions;
 
 import fr.silenix.tntwars.GMain;
 import fr.silenix.tntwars.entity.Joueur;
 import org.bukkit.entity.Player;
 
 
 
 
 
 
 
 
 
 public class Fonctions
 {
   public static boolean stillPlayer(GMain main, String couleurEquipe) {
     boolean IsPresenceJoueur = false;
     
     for (Joueur joueur : main.listeJoueurs) {
       if (joueur.getEquipe().getCouleur() == couleurEquipe) {
         IsPresenceJoueur = true;
       }
     } 
     return IsPresenceJoueur;
   }
 
 
 

 
   
   public static double getDirectionVue(Player player) {
     double rotation = (player.getLocation().getYaw() - 180.0F);
     double retour = 0.0D;
     if (rotation < 0.0D) {
       rotation += 360.0D;
     }
     //player.sendMessage(Double.toString(rotation));
     if (0.0D <= rotation && rotation < 22.5D) {
       //player.sendMessage("North");
       retour = rotation;
     } 
     if (22.5D <= rotation && rotation < 67.5D) {
       //player.sendMessage("NorthEast");
       retour = rotation;
     } 
     if (67.5D <= rotation && rotation < 112.5D) {
       //player.sendMessage("East");
       retour = rotation;
     } 
     if (112.5D <= rotation && rotation < 157.5D) {
       //player.sendMessage("SouthEast");
       retour = rotation;
     } 
     if (157.5D <= rotation && rotation < 202.5D) {
       //player.sendMessage("South");
       retour = rotation;
     } 
     if (202.5D <= rotation && rotation < 247.5D) {
       //player.sendMessage("SouthWest");
       retour = rotation;
     } 
     if (247.5D <= rotation && rotation < 292.5D) {
       //player.sendMessage("West");
       retour = rotation;
     } 
     if (292.5D <= rotation && rotation < 337.5D) {
       //player.sendMessage("NorthWest");
       retour = rotation;
     } 
     if (337.5D <= rotation && rotation <= 360.0D) {
       //player.sendMessage("North");
       retour = rotation;
     } 
     return retour;
   }
 }


