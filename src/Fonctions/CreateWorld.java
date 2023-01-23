/*    */ package Fonctions;
/*    */ 
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import fr.silenix.tntwars.entity.Map;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Location;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CreateWorld
/*    */ {
/*    */   private GMain main;
/*    */   
/*    */   public CreateWorld(GMain main) {
/* 19 */     this.main = main;
/*    */   }
/*    */   
/*    */   public void CreationWorld() {
/* 23 */     this.main.list_maps.add(
/* 24 */         new Map(
/* 25 */           2, 
/* 26 */           "Sky", 
/* 27 */           new Location(this.main.world, 431.0D, 132.0D, 7.0D), 
/* 28 */           new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 501.0D, 13.0D, 24.0D), new Location(this.main.world, 365.0D, 13.0D, 4.0D)
/* 29 */               })), new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 523.0D, 13.0D, 18.0D), new Location(this.main.world, 341.0D, 13.0D, 10.0D)
/* 30 */               })), new Location(this.main.world, 501.0D, 13.0D, 24.0D), 
/* 31 */           new Location(this.main.world, 221.0D, -66.0D, -114.0D), 
/* 32 */           new Location(this.main.world, 644.0D, 103.0D, 141.0D)));
/* 33 */     this.main.list_maps.add(
/* 34 */         new Map(
/* 35 */           2, 
/* 36 */           "Chateau", 
/* 37 */           new Location(this.main.world, 30.0D, 167.0D, -315.0D), 
/* 38 */           new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 30.0D, 11.0D, -242.0D), new Location(this.main.world, 30.0D, 11.0D, -386.0D)
/* 39 */               })), new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 30.0D, 9.0D, -258.0D), new Location(this.main.world, 30.0D, 9.0D, -372.0D)
/* 40 */               })), new Location(this.main.world, 31.0D, 13.0D, -320.0D), 
/* 41 */           new Location(this.main.world, -55.0D, -21.0D, -442.0D), 
/* 42 */           new Location(this.main.world, 103.0D, 125.0D, -205.0D)));
/* 43 */     this.main.list_maps.add(
/* 44 */         new Map(
/* 45 */           2, 
/* 46 */           "LushCave", 
/* 47 */           new Location(this.main.world, -253.0D, 44.0D, -343.0D), 
/* 48 */           new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, -282.0D, 22.0D, -319.0D), new Location(this.main.world, -274.0D, 23.0D, -227.0D)
/* 49 */               })), new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, -320.0D, 25.0D, -315.0D), new Location(this.main.world, -266.0D, 23.0D, -200.0D)
/* 50 */               })), new Location(this.main.world, -300.0D, 20.0D, -263.0D), 
/* 51 */           new Location(this.main.world, -356.0D, 8.0D, -346.0D), 
/* 52 */           new Location(this.main.world, -184.0D, 102.0D, -185.0D)));
/* 53 */     this.main.list_maps.add(
/* 54 */         new Map(
/* 55 */           2, 
/* 56 */           "Japon", 
/* 57 */           new Location(this.main.world, 443.0D, 216.0D, -558.0D), 
/* 58 */           new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 404.0D, 65.0D, -602.0D), new Location(this.main.world, 410.0D, 64.0D, -514.0D)
/* 59 */               })), new ArrayList(Arrays.asList((Object[])new Location[] { new Location(this.main.world, 434.0D, 76.0D, -642.0D), new Location(this.main.world, 428.0D, 71.0D, -487.0D)
/* 60 */               })), new Location(this.main.world, 439.0D, 60.0D, -558.0D), 
/* 61 */           new Location(this.main.world, 357.0D, 0.0D, -676.0D), 
/* 62 */           new Location(this.main.world, 556.0D, 189.0D, -421.0D)));
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\Fonctions\CreateWorld.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */