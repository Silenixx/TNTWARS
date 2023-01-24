 package fr.silenix.tntwars.tasks;
 
 import Enum.EtatPartie;
 import fr.silenix.tntwars.GMain;
 import fr.silenix.tntwars.entity.Joueur;
 import org.bukkit.Bukkit;
 import org.bukkit.Location;
 import org.bukkit.scheduler.BukkitRunnable;
 
 public class TaskDebutPartie extends BukkitRunnable {
   private int timer = 20;
   private GMain main;
   
   public TaskDebutPartie(GMain main) {
     this.main = main;
   }
 
   
   public void run() {
     if (this.main.listeJoueurs.size() < 2) {
       Bukkit.broadcastMessage("§6[§eTntWars§6] §eAnnulation de début de partie par manque de joueur");
       cancel();
       for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
         Joueur joueur = this.main.listeJoueurs.get(i);
         joueur.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), 6.0D, 1.0D, 1.0D));
         joueur.getPlayer().setExp(0.0F);
       } 
       this.main.setState(EtatPartie.AttenteJoueur);
     }
     else if (this.main.isState(EtatPartie.Prejeu)) {
       for (Joueur pls : this.main.listeJoueurs) {
         pls.getPlayer().setLevel(this.timer);
       }
       if (this.timer == 45 || this.timer == 30 || this.timer == 20 || this.timer == 10 || this.timer == 5 || this.timer == 4 || this.timer == 3 || this.timer == 2 || this.timer == 1) {
         Bukkit.broadcastMessage("§6[§eTntWars§6] §eLancement de la partie dans §6" + this.timer + "§e secondes.");
       }
       else if (this.timer == 0) {
         Bukkit.broadcastMessage("§6[§eTntWars§6] §eLancement de la partie! Que la meilleure équipe gagne!");
         this.main.setState(EtatPartie.JeuEnCours);
         this.main.AutoAddTeam(this.main.map_en_cours.getNbEquipe());
         for (int i = 0; i < this.main.listeJoueurs.size(); i++) {
           Joueur joueur = this.main.listeJoueurs.get(i);
           this.main.SpawnTeleportation(joueur);
           joueur.getPlayer().getInventory().clear();
           if (joueur.getProchainKit() == this.main.Sans_Kit) {
             joueur.setProchainKit(this.main.list_kits.get(0));
           }
           this.main.GamePlay(joueur);
         } 
         this.main.CheckWin();
         cancel();
       } 
     } 
     this.timer--;
   }
 }


