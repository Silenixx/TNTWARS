package fr.silenix.tntwars.listener;

import java.util.ArrayList;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import Enum.EtatPartie;
import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Joueur;

public class DamageListeners implements Listener{
	
	private GMain main;
	
	

	public DamageListeners(GMain main) {
		this.main = main;
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		
		Entity victim = event.getEntity();
		
		
		
		
		
		if(!main.isState(EtatPartie.JeuEnCours)) {
			event.setCancelled(true);
			return;
		}
		
		
		if(event.getCause().equals(DamageCause.ENTITY_EXPLOSION) || event.getCause().equals(DamageCause.BLOCK_EXPLOSION)){
			Player player = (Player)victim;
			Joueur joueur = (main.listeJoueurs.stream()
					  .filter(p -> player.getName().equals(p.getPlayer().getName()))
					  .findAny()
					  .orElse(null));
			if(joueur.getKit()==main.Kamikaze) {
				event.setCancelled(true);
				event.setDamage(0);
				return;
			}
        }
		
		
		
		if (victim instanceof Player) {
			Player player = (Player)victim;
			if (player.getHealth() <= event.getDamage()) {
				
				
				
				event.setDamage(0);
				player.teleport(main.map_en_cours.getLocationSalleMort());
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
    
    
    /*@EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        List<Block> blocksToUndo = new ArrayList<>();
        for (Block block : event.blockList()) {
            if (block.getType() == Material.GRASS_BLOCK) {
                blocksToUndo.add(block);
            }
        }
        event.blockList().removeAll(blocksToUndo);
    }*/
    
	
	
	@EventHandler
	public void onTouch(PlayerMoveEvent e) {

        final Player pl = e.getPlayer();
        final Material m = e.getPlayer().getLocation().getBlock().getType();
        
        final Joueur joueur = (main.listeJoueurs.stream()
				  .filter(p -> pl.getName().equals(p.getPlayer().getName()))
				  .findAny()
				  .orElse(null));

        //pl.sendMessage("debug 0");

        if (/*m == Material.LEGACY_STATIONARY_WATER ||*/ m == Material.WATER) {
        	if(joueur.getKit()== main.Endermen) {
        		pl.setHealth(0);
        		pl.sendMessage("un enderman ne peut pas nager ");
        	}
            //pl.sendMessage("debug 1");

            /*if (pl.getWorld().equals("TestS")) {*/
            
            

            //    }
        }
    }
	
	
	
	@EventHandler
	public void onPpv(EntityDamageByEntityEvent event) {
		Entity victim = event.getEntity();
		
		
		if(!main.isState(EtatPartie.JeuEnCours)) {
			event.setCancelled(true);
			return;
		}
		
		
		if (victim instanceof Player) {
			Player players = (Player)victim;
			Joueur joueur_victime = (main.listeJoueurs.stream()
					  .filter(p -> players.getName().equals(p.getPlayer().getName()))
					  .findAny()
					  .orElse(null));
			
			
			Entity damager = event.getDamager();
			Joueur joueur_damager = (main.listeJoueurs.stream()
					  .filter(p -> damager.getName().equals(p.getPlayer().getName()))
					  .findAny()
					  .orElse(null));
			
			Player killer = null;
			
			
			
			
			
			
			
			if(damager instanceof Arrow) {
				Arrow arrow = (Arrow)damager;
				if(arrow.getShooter() instanceof Player) {
					Player killer_arrow = (Player) arrow.getShooter();
					
					Joueur joueur_killer = (main.listeJoueurs.stream()
							  .filter(p -> killer_arrow.getName().equals(p.getPlayer().getName()))
							  .findAny()
							  .orElse(null));
					
					if(joueur_killer.getEquipe()==main.Equipe_bleu && joueur_victime.getEquipe()==main.Equipe_bleu) {
						event.setDamage(0);
						event.setCancelled(true);
						return;
						}
					if(joueur_killer.getEquipe()==main.Equipe_rouge && joueur_victime.getEquipe()==main.Equipe_rouge) {
						event.setDamage(0);
						event.setCancelled(true);
						return;
					}
					if(joueur_victime.getKit()==main.Endermen) {
						event.setDamage(0);
						event.setCancelled(true);
						return;
					}
				
				
				}
			}
			
			
			if(damager instanceof Fireball) {
				Fireball fireball = (Fireball)damager;
				if(fireball.getShooter() instanceof Player) {
					Player killer_fireball = (Player) fireball.getShooter();
					
					Joueur joueur_killer = (main.listeJoueurs.stream()
							  .filter(p -> killer_fireball.getName().equals(p.getPlayer().getName()))
							  .findAny()
							  .orElse(null));
					
					
					if(joueur_killer.getEquipe()==main.Equipe_bleu && joueur_victime.getEquipe()==main.Equipe_bleu) {
						event.setDamage(0);
						event.setCancelled(true);
						return;
						}
					if(joueur_killer.getEquipe()==main.Equipe_rouge && joueur_victime.getEquipe()==main.Equipe_rouge) {
						event.setDamage(0);
						event.setCancelled(true);
						return;
					}
					/*if(main.kit_pyro.contains(players)) {
						event.setDamage(0);
						event.setCancelled(true);
						return;
					}*/
				
				
				}
			}
			
			
			
			
			if(joueur_damager.getKit()==main.OneShot) {
				Bukkit.broadcastMessage(damager.getName()+" vient de tuer "+ players.getDisplayName());
				damager.sendMessage("Tu viens de tuer " + players.getName());
				event.setDamage(0);
				main.eliminate(players);
			}
			
			
			/*if(main.getPlayerBlue().contains(damager) && main.getPlayerBlue().contains(players)) {
				event.setDamage(0);
				event.setCancelled(true);
				if(((HumanEntity) damager).getInventory().getItemInMainHand().getType() == Material.AMETHYST_CLUSTER) {
					((HumanEntity) damager).getInventory().getItemInMainHand().setAmount(((HumanEntity) damager).getInventory().getItemInMainHand().getAmount() - 1);
		            
					if(main.value_random.get(0) == 1) {
						players.teleport(GMain.spawnbleu1);
					}
					if(main.value_random.get(0) == 2) {
						players.teleport(GMain.spawnbleu2);
					}
					if(main.value_random.get(0) == 3) {
						players.teleport(GMain.spawnbleu3);
					}
					
				}
				return;
			}
			
			if(main.getPlayerRed().contains(damager) && main.getPlayerRed().contains(players)) {
				event.setDamage(0);
				event.setCancelled(true);
				if(((HumanEntity) damager).getInventory().getItemInMainHand().getType() == Material.AMETHYST_CLUSTER) {
					
					((HumanEntity) damager).getInventory().getItemInMainHand().setAmount(((HumanEntity) damager).getInventory().getItemInMainHand().getAmount() - 1);
		            
					if(main.value_random.get(0) == 1) {
						players.teleport(GMain.spawnrouge1);
					}
					if(main.value_random.get(0) == 2) {
						players.teleport(GMain.spawnrouge2);
					}
					if(main.value_random.get(0) == 3) {
						players.teleport(GMain.spawnrouge3);
					}
					
				}
				return;
			}*/
			
			
			
			
			
			
			
			
			
			
			/*if(main.getPlayerBlue().contains(damager) && main.getPlayerBlue().contains(players)) {
					event.setDamage(0);
					event.setCancelled(true);
					if(((HumanEntity) damager).getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {
						if(!main.kit_oneshot.contains(players)){
							if(players.getHealth()>37.0) {
								players.setHealth(40.0);
		            		}else {
		            			players.setHealth(players.getHealth() + 2.0);
		            		}
						}
						
					}
					return;
			}
			
			if(main.getPlayerRed().contains(damager) && main.getPlayerRed().contains(players)) {
					event.setDamage(0);
					event.setCancelled(true);
					if(((HumanEntity) damager).getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {
						if(!main.kit_oneshot.contains(players)){
							if(players.getHealth()>37.0) {
								players.setHealth(40.0);
		            		}else {
		            			players.setHealth(players.getHealth() + 2.0);
		            		}
						}
					}
					
					return;
			}*/
			
			
			
		
			
			
			
			
			if (players.getHealth() <= event.getDamage()) {
				
				if(damager instanceof Player) {
					Player killer_parjoueur = (Player)damager;
					Joueur joueur_killer = (main.listeJoueurs.stream()
							  .filter(p -> killer_parjoueur.getName().equals(p.getPlayer().getName()))
							  .findAny()
							  .orElse(null));

				
				
				
				
				
				
					Bukkit.broadcastMessage(killer.getDisplayName()+" vient de tuer "+ players.getDisplayName());
					killer.sendMessage("Tu viens de tuer " + players.getName());
					
					if(joueur_killer.getKit()==main.Elytra) {
						killer.getInventory().addItem(new ItemStack(Material.FIREWORK_ROCKET));
					}
					if(joueur_killer.getKit()==main.Endermen) {
						killer.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
					}
					if(joueur_killer.getKit()==main.Ninja) {
						killer.getInventory().addItem(new ItemStack(Material.BLACK_BANNER));
					}
					
					event.setDamage(0);
					main.eliminate(players);
				}
			}
		}
	}
	
}
