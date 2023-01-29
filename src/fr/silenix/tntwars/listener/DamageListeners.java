 package fr.silenix.tntwars.listener;
 
 import Enum.EtatPartie;
 import Fonctions.Fonctions;
import Fonctions.IndexKit;
import fr.silenix.tntwars.GMain;
 import fr.silenix.tntwars.entity.Joueur;
 import java.util.ArrayList;
 import java.util.List;
 import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
 import org.bukkit.entity.Arrow;
 import org.bukkit.entity.Entity;
 import org.bukkit.entity.Fireball;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
 import org.bukkit.entity.Snowball;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
 import org.bukkit.event.Listener;
 import org.bukkit.event.entity.EntityDamageByEntityEvent;
 import org.bukkit.event.entity.EntityDamageEvent;
 import org.bukkit.event.entity.EntityExplodeEvent;
 import org.bukkit.event.player.PlayerMoveEvent;
 import org.bukkit.inventory.ItemStack;
 
 
 
 
public class DamageListeners implements Listener
 {
   private GMain main;
   
   public DamageListeners(GMain main) {
     this.main = main;
   }
 
   
   @EventHandler
   public void onDamage(EntityDamageEvent event) {
     Entity victim = event.getEntity();
 
 
 
 
     
     if (!this.main.isState(EtatPartie.JeuEnCours)) {
       event.setCancelled(true);
       
       return;
     } 
     
     if (event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) || event.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) {
       Player player = (Player)victim;
       Joueur joueur = this.main.listeJoueurs.stream()
         .filter(p -> player.getName().equals(p.getPlayer().getName()))
         .findAny()
         .orElse(null);
       if (joueur.getKit() == this.main.list_kits.get(2)) {
         event.setCancelled(true);
         event.setDamage(0.0D);
         
         return;
       } 
     } 
     
     if (event.getCause() == EntityDamageEvent.DamageCause.VOID) {
       Player player = (Player)victim;
       event.setDamage(0.0D);
       
     } 
 
     
     if (victim instanceof Player) {
       Player player = (Player)victim;
       if (player.getHealth() <= event.getDamage()) {
 
 
         
         event.setDamage(0.0D);
         this.main.eliminate(player);
       } 
     } 
 
     
     if (victim instanceof org.bukkit.block.data.type.Fire) {
       Player player = (Player)victim;
       if (player.getHealth() <= event.getDamage()) {
    	   Joueur joueur = this.main.listeJoueurs.stream()
    		         .filter(p -> player.getName().equals(p.getPlayer().getName()))
    		         .findAny()
    		         .orElse(null);
 
         
         event.setDamage(0.0D);
         //TODO message à retirer
         Bukkit.broadcastMessage(joueur.getEquipe().getChatColor() + player.getName() + ChatColor.GRAY + " est mort brulé(e).");
         main.eliminate(player);
       } 
     } 
   }
 
 
 
 
 
 
 
   
   @EventHandler
   public void onEntityExplode(EntityExplodeEvent event) {
     List<Block> blocksToUndo = new ArrayList<>();
     for (Block block : event.blockList()) {
       if (block.getType() != Material.BLUE_WOOL && block.getType() != Material.RED_WOOL) {
         blocksToUndo.add(block);
       }
     } 
     
     event.blockList().removeAll(blocksToUndo);
   }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
   
   @EventHandler
   public void onTouch(PlayerMoveEvent e) {
     Player pl = e.getPlayer();
     
     Material m = e.getPlayer().getLocation().getBlock().getType();
     
     Joueur joueur = this.main.listeJoueurs.stream()
       .filter(p -> pl.getName().equals(p.getPlayer().getName()))
       .findAny()
       .orElse(null);
     
     if (m == Material.WATER && 
       joueur.getKit() == this.main.list_kits.get(1)) {
       this.main.eliminate(pl);
       pl.sendMessage(joueur.getEquipe().getChatColor() +"un enderman ne peut pas nager ");
     } 
   }
 
 
 
 
 
 
   
   @EventHandler
   public void onPpv(EntityDamageByEntityEvent event) {
     Entity victim = event.getEntity();
 
     
     if (!this.main.isState(EtatPartie.JeuEnCours)) {
       event.setCancelled(true);
       
       return;
     } 
     
     
     /*if (victim instanceof Wolf) {
    	 
    	 Player damager = (Player) event.getDamager();
    	 
    	 ((Wolf) victim).setTarget(damager);
     }*/
     
     
     
     
     
     
     
     if (victim instanceof Player) {
       Player players = (Player)victim;
       Joueur joueur_victime = this.main.listeJoueurs.stream()
         .filter(p -> players.getName().equals(p.getPlayer().getName()))
         .findAny()
         .orElse(null);
 
       
       Entity damager = event.getDamager();
 
 
       
       
       if (damager instanceof Arrow) {
         Arrow arrow = (Arrow)damager;
         if (arrow.getShooter() instanceof Player) {
           Player killer_arrow = (Player)arrow.getShooter();
           
           Joueur joueur_killer = this.main.listeJoueurs.stream()
             .filter(p -> killer_arrow.getName().equals(p.getPlayer().getName()))
             .findAny()
             .orElse(null);
           
           if (joueur_killer.getEquipe() == joueur_victime.getEquipe()) {
             event.setDamage(0.0D);
             event.setCancelled(true);
             return;
           } 
           if (joueur_victime.getKit() == this.main.list_kits.get(1)) {
             event.setDamage(0.0D);
             event.setCancelled(true);
 
             
             return;
           } 
         } 
       } 
 
       
       if (damager instanceof Fireball) {
         Fireball fireball = (Fireball)damager;
         if (fireball.getShooter() instanceof Player) {
           Player killer_fireball = (Player)fireball.getShooter();
           
           Joueur joueur_killer = this.main.listeJoueurs.stream()
             .filter(p -> killer_fireball.getName().equals(p.getPlayer().getName()))
             .findAny()
             .orElse(null);
 
           
           if (joueur_killer.getEquipe() == joueur_victime.getEquipe()) {
             event.setDamage(0.0D);
            
             event.setCancelled(true);
 
 
 
 
             
             return;
           } 
         } 
       }
       
       
       if (damager instanceof Firework) {
    	   Firework firework = (Firework)damager;
           if (firework.getShooter() instanceof Player) {
             Player killer_fireball = (Player)firework.getShooter();
             
             Joueur joueur_killer = this.main.listeJoueurs.stream()
               .filter(p -> killer_fireball.getName().equals(p.getPlayer().getName()))
               .findAny()
               .orElse(null);
   
             
             if (joueur_killer.getEquipe() == joueur_victime.getEquipe()) {
               event.setDamage(0.0D);
               event.setCancelled(true);
   
               return;
             }
             if (joueur_killer.getEquipe() != joueur_victime.getEquipe()) {
                 event.setDamage(11D);
                 
     
                 if (joueur_victime.getPlayer().getHealth() <= event.getDamage()) {
    	             event.setDamage(0.0D);
    	             event.setCancelled(true);
    	             Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
    	             this.main.eliminate(joueur_victime.getPlayer());
    	           }
            } 
           } 
         } 
 
 
 
       
       if (damager instanceof Snowball) {
         Snowball snowball = (Snowball)damager;
         if (snowball.getShooter() instanceof Player) {
           Player killer_snowball = (Player)snowball.getShooter();
           
           Joueur joueur_killer = this.main.listeJoueurs.stream()
             .filter(p -> killer_snowball.getName().equals(p.getPlayer().getName()))
             .findAny()
             .orElse(null);
 
           
           if (joueur_killer.getEquipe() == joueur_victime.getEquipe()) {
             event.setDamage(0.0D);
             event.setCancelled(true);
             
             return;
           } 
           
           if(joueur_killer.getKit() == main.list_kits.get(IndexKit.SnowMan)) {
        	   event.setDamage(8.0D);
	           if (joueur_victime.getPlayer().getHealth() <= event.getDamage()) {
	             event.setDamage(0.0D);
	             event.setCancelled(true);
	             Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
	             this.main.eliminate(joueur_victime.getPlayer());
	           } 
           }
           
           if(joueur_killer.getKit() == main.list_kits.get(IndexKit.Sorcier)) {
        	   event.setDamage(12.0D);
	           if (joueur_victime.getPlayer().getHealth() <= event.getDamage()) {
	             event.setDamage(0.0D);
	             event.setCancelled(true);
	             Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
	             this.main.eliminate(joueur_victime.getPlayer());
	           } 
           }
           
           
           
           
         } 
       } 
 
 
 
 
 
 
 
 
 
       
       if (damager instanceof Player) {
         
         Joueur joueur_killer = this.main.listeJoueurs.stream()
           .filter(p -> damager.getName().equals(p.getPlayer().getName()))
           .findAny()
           .orElse(null);
         
         if (joueur_killer.getKit() == this.main.list_kits.get(IndexKit.OneShot)) {
           Bukkit.broadcastMessage("Le OneShot " + joueur_killer.getEquipe().getChatColor() + damager.getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() +players.getName());
           //damager.sendMessage(joueur_killer.getEquipe().getChatColor() + "Tu viens de tuer " + players.getName());
           event.setDamage(0.0D);
           this.main.eliminate(players);
         } 
         
         if (joueur_victime.getKit() == this.main.list_kits.get(IndexKit.DogMaster)) {
             
        	 
				for(Entity entity : joueur_killer.getPlayer().getWorld().getEntities()) {
					if(entity instanceof Wolf) {
						Wolf wolf = (Wolf) entity;
						if(wolf.getOwner() != null) {
							if(wolf.getOwner().getName() == joueur_victime.getPlayer().getName()) {
								wolf.setTarget(joueur_killer.getPlayer());
								
							}
						}
						
					
					}
				}
				if (joueur_victime.getPlayer().getHealth() <= event.getDamage()) {
		             event.setDamage(0.0D);
		             event.setCancelled(true);
		             Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
		             this.main.eliminate(joueur_victime.getPlayer());
		          } 
 				
  
 				
           }
 
         
         if (joueur_killer.getKit() == this.main.list_kits.get(39)) {
 
           
           double vue_victim = Fonctions.getDirectionVue(joueur_victime.getPlayer());
           double vue_killer = Fonctions.getDirectionVue(joueur_killer.getPlayer());
 
           
           if (vue_victim > 315.0D || vue_victim < 45.0D) {
 
 
             
             if (vue_victim > 315.0D) {
               
               if (vue_killer >= 0.0D && vue_killer <= 45.0D) {
                 double diff = 360.0D - vue_victim + vue_killer;
                 vue_victim -= 180.0D;
                 vue_killer = vue_victim + diff;
               }
               else {
                 
                 vue_victim -= 180.0D;
                 vue_killer -= 180.0D;
               } 
 
 
               
               if (vue_victim > vue_killer && vue_killer > vue_victim - 45.0D) {
                 event.setDamage(0.0D);
                 joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par l'assassin " + joueur_victime.getEquipe().getChatColor() + joueur_killer.getPlayer());
                 Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
                 this.main.eliminate(players);
               } 
               if (vue_victim < vue_killer && vue_killer < vue_victim + 45.0D) {
                 event.setDamage(0.0D);
                 joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par l'assassin "+joueur_victime.getEquipe().getChatColor()+joueur_killer.getPlayer());
                 Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
                 this.main.eliminate(players);
               } 
             } 
 
 
 
 
 
 
             
             if (vue_victim < 45.0D)
             {
               if (vue_killer >= 315.0D && vue_killer <= 360.0D) {
                 double diff = vue_victim + 360.0D - vue_killer;
                 vue_victim += 180.0D;
                 vue_killer = vue_victim - diff;
               }
               else {
                 
                 vue_victim += 180.0D;
                 vue_killer += 180.0D;
               } 
 
 
 
               
               if (vue_victim > vue_killer && vue_killer > vue_victim - 45.0D) {
                 event.setDamage(0.0D);
                 joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par l'assassin "+joueur_victime.getEquipe().getChatColor()+joueur_killer.getPlayer());
                 Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
                 this.main.eliminate(players);
               } 
               if (vue_victim < vue_killer && vue_killer < vue_victim + 45.0D) {
                 event.setDamage(0.0D);
                 joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par l'assassin "+joueur_victime.getEquipe().getChatColor()+joueur_killer.getPlayer());
                 Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
                 this.main.eliminate(players);
               
               }
 
             
             }
           
           }
           else {
             
             if (vue_victim > vue_killer && vue_killer > vue_victim - 45.0D) {
               event.setDamage(0.0D);
               joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par l'assassin "+joueur_victime.getEquipe().getChatColor()+joueur_killer.getPlayer());
               Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
               this.main.eliminate(players);
             } 
             if (vue_victim < vue_killer && vue_killer < vue_victim + 45.0D) {
               event.setDamage(0.0D);
               joueur_victime.getPlayer().sendMessage("Vous avez été assasiné par l'assassin "+joueur_victime.getEquipe().getChatColor()+joueur_killer.getPlayer());
               Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + joueur_killer.getPlayer().getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
               this.main.eliminate(players);
             } 
           } 
         } 
       } 
 


 
 
       
       if (players.getHealth() <= event.getDamage())
       {
         if (damager instanceof Player) {
           Player killer_parjoueur = (Player)damager;
           Joueur joueur_killer = this.main.listeJoueurs.stream()
             .filter(p -> killer_parjoueur.getName().equals(p.getPlayer().getName()))
             .findAny()
             .orElse(null);
 
 
 
 
 
 
           
           Bukkit.broadcastMessage(joueur_killer.getEquipe().getChatColor() + killer_parjoueur.getName() + ChatColor.WHITE + " vient de tuer " + joueur_victime.getEquipe().getChatColor() + players.getDisplayName());
           //killer_parjoueur.sendMessage(joueur_killer.getEquipe().getChatColor() +"Tu viens de tuer " + players.getName());
           
           if (joueur_killer.getKit() == this.main.list_kits.get(IndexKit.Elytra)) {
        	   joueur_killer.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.FIREWORK_ROCKET) });
           }
           if (joueur_killer.getKit() == this.main.list_kits.get(IndexKit.Enderman)) {
        	   joueur_killer.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL) });
           }
           if (joueur_killer.getKit() == this.main.list_kits.get(IndexKit.Ninja)) {
        	   joueur_killer.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.BLACK_BANNER) });
           }
           
           if (joueur_killer.getKit() == this.main.list_kits.get(IndexKit.Creeper)) {
        	   joueur_killer.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(Material.GUNPOWDER) });
             }
 
           
           event.setDamage(0.0D);
           this.main.eliminate(players);
         } 
       }
     } 
   }
 }


