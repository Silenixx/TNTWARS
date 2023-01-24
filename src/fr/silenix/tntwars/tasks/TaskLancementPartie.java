 package fr.silenix.tntwars.tasks;
 import Enum.EtatPartie;
 import fr.silenix.tntwars.GMain;
 import fr.silenix.tntwars.entity.Joueur;
 import java.util.Arrays;
 import java.util.Random;
 import org.bukkit.Bukkit;
 import org.bukkit.Material;
import org.bukkit.World;
 import org.bukkit.command.CommandSender;
 import org.bukkit.enchantments.Enchantment;
 import org.bukkit.inventory.ItemFlag;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
 
public class TaskLancementPartie extends BukkitRunnable {
   private int timer = 15;
   private GMain main;
   static World world = Bukkit.getWorld("world");
   
   public TaskLancementPartie(GMain main) {
     this.main = main;
   }
 
   
   public void run() {
     if (this.main.listeJoueurs.size() < 2) {
       Bukkit.broadcastMessage("§6[§eTntWars§6] §eAnnulation de début de partie par manque de joueur");
       cancel();
       for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
         Joueur joueur = this.main.listeJoueurs.get(i);
         joueur.getPlayer().setExp(0.0F);
       } 
       this.main.setState(EtatPartie.AttenteJoueur);
     }
     else if (this.main.isState(EtatPartie.Lancement)) {
       for (Joueur pls : this.main.listeJoueurs) {
         pls.getPlayer().setLevel(this.timer);
       }
       
       if (this.timer == 35 || this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2 || this.timer == 1) {
         Bukkit.broadcastMessage("§6[§eTntWars§6] §eTéléportation vers la carte de jeu dans §6" + this.timer + "§e secondes.");
       
       }
       else if (this.timer == 0) {
         Random random = new Random();
         int value_random_en_cours = random.nextInt(this.main.list_maps.size() - 1 + 1) + 1;
         this.main.map_en_cours = this.main.list_maps.get(value_random_en_cours - 1);
         Bukkit.broadcastMessage("§6[§eTntWars§6] §ePour cette partie la map §6" + this.main.map_en_cours.Nom + "§e a été choisie.");
         
         this.main.PutLocationInTnt(this.main.map_en_cours.getNbEquipe());
         
         this.main.listTnt.add(this.main.tnt_rouge);
         this.main.listTnt.add(this.main.tnt_bleu);
         this.main.listTnt.add(this.main.tnt_vert);
         this.main.listTnt.add(this.main.tnt_jaune);
         
         this.main.efface_block();
         
         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "killall parrot world");
         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "killall pig world");
         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "killall horse world");
         Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "killall wolf world");
         
         for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
           Joueur joueur = this.main.listeJoueurs.get(i);
           joueur.getPlayer().teleport(this.main.map_en_cours.LocationVisite);
           
           ItemStack customcompasse = new ItemStack(Material.COMPASS, 1);
           ItemMeta customC2 = customcompasse.getItemMeta();
           customC2.setDisplayName("Selectionneur d'§quipe");
           customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
           customC2.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
           customC2.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
           customcompasse.setItemMeta(customC2);
           joueur.getPlayer().getInventory().setItem(8, customcompasse);
         } 
         this.main.setState(EtatPartie.Prejeu);
         TaskDebutPartie start = new TaskDebutPartie(this.main);
         start.runTaskTimer((Plugin)this.main, 0L, 20L);
         cancel();
       } 
     } 
     this.timer--;
   }
 }


