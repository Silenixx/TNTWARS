 package fr.silenix.tntwars.entity;
 
 import org.bukkit.entity.Player;
 
 
 
 
 public class Joueur
 {
   private Player player;
   private String Nom;
   private Equipe Equipe;
   private Kit Kit;
   private Kit ProchainKit;
   private int Money;
   
   public Joueur(Player player, String Nom, Equipe equipe, Kit kit1, Kit ProchainKit, int money) {
     this.player = player;
     this.Nom = Nom;
     this.Equipe = equipe;
     this.Kit = kit1;
     this.ProchainKit = ProchainKit;
     this.Money = money;
   }
 
 
   
   public int getMoney() {
	return Money;
   }
   public void setMoney(int money) {
	Money = money;
   }
   public Equipe getEquipe() {
     return this.Equipe;
   }
   public void setNom(String nom) {
     this.Nom = nom;
   }
   public String getNom() {
     return this.Nom;
   }
   public void setEquipe(Equipe equipe) {
     this.Equipe = equipe;
   }
   public Player getPlayer() {
     return this.player;
   }
   public void setPlayer(Player player) {
     player = this.player;
   }
   public Kit getKit() {
     return this.Kit;
   }
   public void setKit(Kit kit) {
     this.Kit = kit;
   }
   public Kit getProchainKit() {
     return this.ProchainKit;
   }
   public void setProchainKit(Kit prochainkit) {
     this.ProchainKit = prochainkit;
   }
 }


