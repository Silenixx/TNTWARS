 package Fonctions;
 
 import fr.silenix.tntwars.GMain;
 import fr.silenix.tntwars.entity.Map;
 import java.util.ArrayList;
 import java.util.Arrays;
 import org.bukkit.Location;
 
 
 
 
 
 
 public class CreateWorld
 {
   private GMain main;
   
   public CreateWorld(GMain main) {
     this.main = main;
   }
   
   public void CreationWorld() {
     this.main.list_maps.add(
         new Map(
           2, 
           "Sky", 
           new Location(this.main.world, 431.0D, 132.0D, 7.0D), 
           new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 501.0D, 13.0D, 24.0D), new Location(this.main.world, 365.0D, 13.0D, 4.0D)
               })), new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 523.0D, 13.0D, 18.0D), new Location(this.main.world, 341.0D, 13.0D, 10.0D)
               })), new Location(this.main.world, 501.0D, 13.0D, 24.0D), 
           new Location(this.main.world, 221.0D, -66.0D, -114.0D), 
           new Location(this.main.world, 644.0D, 103.0D, 141.0D)));
     this.main.list_maps.add(
         new Map(
           2, 
           "Chateau", 
           new Location(this.main.world, 30.0D, 167.0D, -315.0D), 
           new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 30.0D, 11.0D, -242.0D), new Location(this.main.world, 30.0D, 11.0D, -386.0D)
               })), new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 30.0D, 9.0D, -258.0D), new Location(this.main.world, 30.0D, 9.0D, -372.0D)
               })), new Location(this.main.world, 31.0D, 13.0D, -320.0D), 
           new Location(this.main.world, -55.0D, -21.0D, -442.0D), 
           new Location(this.main.world, 103.0D, 125.0D, -205.0D)));
     this.main.list_maps.add(
         new Map(
           2, 
           "LushCave", 
           new Location(this.main.world, -253.0D, 44.0D, -343.0D), 
           new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, -282.0D, 22.0D, -319.0D), new Location(this.main.world, -274.0D, 23.0D, -227.0D)
               })), new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, -320.0D, 25.0D, -315.0D), new Location(this.main.world, -266.0D, 23.0D, -200.0D)
               })), new Location(this.main.world, -300.0D, 20.0D, -263.0D), 
           new Location(this.main.world, -356.0D, 8.0D, -346.0D), 
           new Location(this.main.world, -184.0D, 102.0D, -185.0D)));
     this.main.list_maps.add(
         new Map(
           2, 
           "Japon", 
           new Location(this.main.world, 443.0D, 216.0D, -558.0D), 
           new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 404.0D, 65.0D, -602.0D), new Location(this.main.world, 410.0D, 64.0D, -514.0D)
               })), new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 434.0D, 76.0D, -642.0D), new Location(this.main.world, 428.0D, 71.0D, -487.0D)
               })), new Location(this.main.world, 439.0D, 60.0D, -558.0D), 
           new Location(this.main.world, 357.0D, 0.0D, -676.0D), 
           new Location(this.main.world, 556.0D, 189.0D, -421.0D)));
   }
 }


