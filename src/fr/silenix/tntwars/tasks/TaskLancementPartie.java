/*    */ package fr.silenix.tntwars.tasks;
/*    */ import Enum.EtatPartie;
/*    */ import fr.silenix.tntwars.GMain;
/*    */ import fr.silenix.tntwars.entity.Joueur;
/*    */ import java.util.Arrays;
/*    */ import java.util.Random;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
import org.bukkit.World;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.enchantments.Enchantment;
/*    */ import org.bukkit.inventory.ItemFlag;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
/*    */ 
/*    */ public class TaskLancementPartie extends BukkitRunnable {
/* 17 */   private int timer = 15;
/*    */   private GMain main;
/* 19 */   static World world = Bukkit.getWorld("world");
/*    */   
/*    */   public TaskLancementPartie(GMain main) {
/* 22 */     this.main = main;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 27 */     if (this.main.listeJoueurs.size() < 2) {
/* 28 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eAnnulation de début de partie par manque de joueur");
/* 29 */       cancel();
/* 30 */       for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
/* 31 */         Joueur joueur = this.main.listeJoueurs.get(i);
/* 32 */         joueur.getPlayer().setExp(0.0F);
/*    */       } 
/* 34 */       this.main.setState(EtatPartie.AttenteJoueur);
/*    */     }
/* 36 */     else if (this.main.isState(EtatPartie.Lancement)) {
/* 37 */       for (Joueur pls : this.main.listeJoueurs) {
/* 38 */         pls.getPlayer().setLevel(this.timer);
/*    */       }
/*    */       
/* 41 */       if (this.timer == 35 || this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2 || this.timer == 1) {
/* 42 */         Bukkit.broadcastMessage("§6[§eTntWars§6] §eTéléportation vers la carte de jeu dans §6" + this.timer + "§e secondes.");
/*    */       
/*    */       }
/* 45 */       else if (this.timer == 0) {
/* 46 */         Random random = new Random();
/* 47 */         int value_random_en_cours = random.nextInt(this.main.list_maps.size() - 1 + 1) + 1;
/* 48 */         this.main.map_en_cours = this.main.list_maps.get(value_random_en_cours - 1);
/* 49 */         Bukkit.broadcastMessage("§6[§eTntWars§6] §ePour cette partie la map §6" + this.main.map_en_cours.Nom + "§e a été choisie.");
/*    */         
/* 51 */         this.main.PutLocationInTnt(this.main.map_en_cours.getNbEquipe());
/*    */         
/* 53 */         this.main.listTnt.add(this.main.tnt_rouge);
/* 54 */         this.main.listTnt.add(this.main.tnt_bleu);
/* 55 */         this.main.listTnt.add(this.main.tnt_vert);
/* 56 */         this.main.listTnt.add(this.main.tnt_jaune);
/*    */         
/* 58 */         this.main.efface_block();
/*    */         
/* 60 */         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "killall parrot world");
/* 61 */         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "killall pig world");
/* 62 */         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "killall horse world");
/* 63 */         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "killall wolf world");
/*    */         
/* 65 */         for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
/* 66 */           Joueur joueur = this.main.listeJoueurs.get(i);
/* 67 */           joueur.getPlayer().teleport(this.main.map_en_cours.LocationVisite);
/*    */           
/* 69 */           ItemStack customcompasse = new ItemStack(Material.COMPASS, 1);
/* 70 */           ItemMeta customC2 = customcompasse.getItemMeta();
/* 71 */           customC2.setDisplayName("Selectionneur d'§quipe");
/* 72 */           customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
/* 73 */           customC2.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 74 */           customC2.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 75 */           customcompasse.setItemMeta(customC2);
/* 76 */           joueur.getPlayer().getInventory().setItem(8, customcompasse);
/*    */         } 
/* 78 */         this.main.setState(EtatPartie.Prejeu);
/* 79 */         TaskDebutPartie start = new TaskDebutPartie(this.main);
/* 80 */         start.runTaskTimer((Plugin)this.main, 0L, 20L);
/* 81 */         cancel();
/*    */       } 
/*    */     } 
/* 84 */     this.timer--;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\tasks\TaskLancementPartie.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */