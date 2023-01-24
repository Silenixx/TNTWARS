/*     */ package fr.silenix.tntwars;
/*     */ 
/*     */ import Constante.Constantes;
/*     */ import Enum.CouleurEquipe;
/*     */ import Enum.EtatPartie;
/*     */ import Enum.EtatTNT;
/*     */ import Fonctions.CreateKit;
/*     */ import fr.silenix.tntwars.entity.Equipe;
/*     */ import fr.silenix.tntwars.entity.Joueur;
/*     */ import fr.silenix.tntwars.entity.Kit;
/*     */ import fr.silenix.tntwars.entity.Map;
/*     */ import fr.silenix.tntwars.entity.Tnt;
/*     */ import fr.silenix.tntwars.listener.DamageListeners;
/*     */ import fr.silenix.tntwars.listener.PlayerListeners;
/*     */ import fr.silenix.tntwars.tasks.TaskLancementPartie;
/*     */ import fr.silenix.tntwars.timer.TimerImmortality;
/*     */ import fr.silenix.tntwars.timer.TimerRedemarrage;
/*     */ import fr.silenix.tntwars.timer.TimerRespawn;
/*     */ import fr.silenix.tntwars.timer.TimerScoreboard;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.GameMode;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.OfflinePlayer;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.inventory.ItemFlag;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.scoreboard.DisplaySlot;
/*     */ import org.bukkit.scoreboard.Objective;
/*     */ import org.bukkit.scoreboard.Score;
/*     */ import org.bukkit.scoreboard.Scoreboard;
/*     */ import org.bukkit.scoreboard.ScoreboardManager;
/*     */ import org.bukkit.scoreboard.Team;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GMain
/*     */   extends JavaPlugin
/*     */ {
/*  53 */   public int Avancement_Max_Global_TNT = 50;
/*     */   
/*     */   public Team RedTeamSC;
/*     */   
/*     */   public Team BlueTeamSC;
/*     */   public Team GreenTeamSC;
/*     */   public Team YellowTeamSC;
/*  60 */   public World world = null;
/*     */ 
/*     */   
/*  63 */   public Equipe Equipe_rouge = new Equipe("Rouge", false, Material.RED_WOOL, Material.RED_GLAZED_TERRACOTTA);
/*  64 */   public Equipe Equipe_bleu = new Equipe("Bleu", false, Material.BLUE_WOOL, Material.BLUE_GLAZED_TERRACOTTA);
/*  65 */   public Equipe Equipe_vert = new Equipe("Vert", false, Material.GREEN_WOOL, Material.GREEN_GLAZED_TERRACOTTA);
/*  66 */   public Equipe Equipe_jaune = new Equipe("Jaune", false, Material.YELLOW_WOOL, Material.YELLOW_GLAZED_TERRACOTTA);
/*  67 */   public Equipe Sans_Equipe = new Equipe("Sans Equipe", true, null, null);
/*     */   
/*  69 */   public Tnt tnt_rouge = new Tnt(this.Equipe_rouge, 0, EtatTNT.Eteinte, 30, 0, null);
/*  70 */   public Tnt tnt_bleu = new Tnt(this.Equipe_bleu, 0, EtatTNT.Eteinte, 30, 1, null);
/*  71 */   public Tnt tnt_vert = new Tnt(this.Equipe_vert, 0, EtatTNT.Eteinte, 30, 2, null);
/*  72 */   public Tnt tnt_jaune = new Tnt(this.Equipe_jaune, 0, EtatTNT.Eteinte, 30, 3, null);
/*     */   
/*  74 */   public Kit Sans_Kit = new Kit("Sans Kit", null, null, null, null, null, Constantes.Vie_Global_Joueur, null, null, true, new ItemStack(Material.ACACIA_BOAT), null, "tnt.sanskit");
/*     */   
/*     */   public ArrayList<Kit> list_kits;
/*  77 */   public ArrayList<Tnt> listTnt = new ArrayList<>();
/*     */   
/*     */   public ScoreboardManager manager;
/*     */   
/*     */   public Scoreboard board;
/*     */   
/*     */   public Team onlineCounter;
/*     */   
/*     */   public Team boardblue;
/*     */   
/*     */   public Team boardred;
/*     */   public int connecter_score;
/*     */   public int cblue;
/*     */   public int cred;
/*     */   public int taille_blue;
/*     */   public int taille_red;
/*     */   public int timeblue;
/*     */   public int timered;
/*     */   public int mort_rouge;
/*     */   public int mort_bleu;
/*     */   public Map map_en_cours;
/*  98 */   public List<Map> list_maps = new ArrayList<>();
/*     */   
/* 100 */   public List<Joueur> listeJoueurs = new ArrayList<>();
/* 101 */   public List<Joueur> listeConnecte = new ArrayList<>();
/*     */ 
/*     */   
/* 104 */   public List<Material> AllowBlockPoserCasser = new ArrayList<>(Arrays.asList(new Material[] { Material.RED_WOOL, 
/* 105 */           Material.BLUE_WOOL, 
/* 106 */           Material.GREEN_WOOL, 
/* 107 */           Material.YELLOW_WOOL, 
/* 108 */           Material.RED_GLAZED_TERRACOTTA, 
/* 109 */           Material.BLUE_GLAZED_TERRACOTTA, 
/* 110 */           Material.GREEN_GLAZED_TERRACOTTA, 
/* 111 */           Material.YELLOW_GLAZED_TERRACOTTA }));
/*     */ 
/*     */   
/* 114 */   public List<Material> ListTacticien = new ArrayList<>(Arrays.asList(new Material[] {
/*     */           
/* 116 */           Material.RED_GLAZED_TERRACOTTA, 
/* 117 */           Material.BLUE_GLAZED_TERRACOTTA, 
/* 118 */           Material.GREEN_GLAZED_TERRACOTTA, 
/* 119 */           Material.YELLOW_GLAZED_TERRACOTTA
/*     */         }));
/* 121 */   public List<Material> ListWool = new ArrayList<>(Arrays.asList(new Material[] {
/*     */           
/* 123 */           Material.RED_WOOL, 
/* 124 */           Material.BLUE_WOOL, 
/* 125 */           Material.GREEN_WOOL, 
/* 126 */           Material.YELLOW_WOOL
/*     */         }));
/*     */ 
/*     */   
/*     */   private EtatPartie Etat;
/*     */ 
/*     */ 
/*     */   
/*     */   public void onEnable() {
/* 135 */     PluginManager pm = getServer().getPluginManager();
/*     */     
/* 137 */     setState(EtatPartie.AttenteJoueur);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 146 */     this.list_kits = CreateKit.CreationKit();
/*     */ 
/*     */     
/* 149 */     SetScoreboard();
/*     */     
/* 151 */     TimerScoreboard cycle = new TimerScoreboard(this);
/* 152 */     cycle.runTaskTimer((Plugin)this, 0L, 20L);
/*     */     
/* 154 */     pm.registerEvents((Listener)new PlayerListeners(this), (Plugin)this);
/* 155 */     pm.registerEvents((Listener)new DamageListeners(this), (Plugin)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void remiseazero() {
/* 160 */     this.tnt_rouge.setEtat(EtatTNT.Eteinte);
/* 161 */     this.tnt_bleu.setEtat(EtatTNT.Eteinte);
/* 162 */     this.tnt_vert.setEtat(EtatTNT.Eteinte);
/* 163 */     this.tnt_jaune.setEtat(EtatTNT.Eteinte);
/*     */     
/* 165 */     this.tnt_bleu.setTimer(30);
/* 166 */     this.tnt_rouge.setTimer(30);
/* 167 */     this.tnt_vert.setTimer(30);
/* 168 */     this.tnt_jaune.setTimer(30);
/*     */     
/* 170 */     this.tnt_bleu.setVie(0);
/* 171 */     this.tnt_rouge.setVie(0);
/* 172 */     this.tnt_jaune.setVie(0);
/* 173 */     this.tnt_vert.setVie(0);
/*     */     
/* 175 */     setState(EtatPartie.AttenteJoueur);
/*     */     
/* 177 */     this.listeJoueurs.clear();
/*     */     int i;
/* 179 */     for (i = 0; i < this.listeConnecte.size(); i++) {
/* 180 */       Joueur joueur_tempo = new Joueur(((Joueur)this.listeConnecte.get(i)).getPlayer(), ((Joueur)this.listeConnecte.get(i)).getPlayer().getName(), this.Sans_Equipe, this.list_kits.get(0), this.list_kits.get(0));
/* 181 */       this.listeJoueurs.add(joueur_tempo);
/*     */     } 
/*     */     
/* 184 */     for (i = 0; i < 5; i++) {
/* 185 */       Collections.shuffle(this.listeJoueurs);
/*     */     }
/*     */ 
/*     */     
/* 189 */     for (i = 0; i < this.listeJoueurs.size(); i++) {
/* 190 */       Joueur joueur = this.listeJoueurs.get(i);
/*     */       
/* 192 */       joueur.getPlayer().setInvisible(false);
/* 193 */       joueur.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), 6.0D, 1.0D, 1.0D));
/* 194 */       joueur.getPlayer().setInvulnerable(false);
/* 195 */       joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
/* 196 */       joueur.getPlayer().getInventory().clear();
/*     */       
/* 198 */       ItemStack customnetherstar = new ItemStack(Material.NETHER_STAR, 1);
/* 199 */       ItemMeta customNS = customnetherstar.getItemMeta();
/* 200 */       customNS.setDisplayName("Selectionneur d'§quipe");
/* 201 */       customNS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
/* 202 */       customNS.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 203 */       customNS.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 204 */       customnetherstar.setItemMeta(customNS);
/* 205 */       joueur.getPlayer().getInventory().setItem(4, customnetherstar);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 210 */     if (isState(EtatPartie.AttenteJoueur) && this.listeJoueurs.size() >= 2 && !isState(EtatPartie.Lancement)) {
/* 211 */       Bukkit.broadcastMessage("§6[§eTntWars§6] §eAssez de monde pour relancer une nouvelle partie.");
/* 212 */       setState(EtatPartie.Lancement);
/* 213 */       TaskLancementPartie start = new TaskLancementPartie(this);
/* 214 */       start.runTaskTimer(this, 0L, 20L);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void efface_block() {
/* 219 */     for (int x = this.map_en_cours.getLocationMapBorne1().getBlockX(); x != this.map_en_cours.getLocationMapBorne2().getBlockX(); x++) {
/* 220 */       for (int y = this.map_en_cours.getLocationMapBorne1().getBlockY(); y != this.map_en_cours.getLocationMapBorne2().getBlockY(); y++) {
/* 221 */         for (int z = this.map_en_cours.getLocationMapBorne1().getBlockZ(); z != this.map_en_cours.getLocationMapBorne2().getBlockZ(); z++) {
/* 222 */           if (this.AllowBlockPoserCasser.contains(((Joueur)this.listeJoueurs.get(0)).getPlayer().getWorld().getBlockAt(x, y, z).getType())) {
/* 223 */             ((Joueur)this.listeJoueurs.get(0)).getPlayer().getWorld().getBlockAt(x, y, z).setType(Material.AIR);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getSize(String couleur) {
/* 232 */     int nombre_joueur = 0;
/* 233 */     for (int i = 0; i < this.listeJoueurs.size(); i++) {
/* 234 */       Joueur joueur = this.listeJoueurs.get(i);
/* 235 */       if (joueur.getEquipe().getCouleur() == couleur) {
/* 236 */         nombre_joueur++;
/*     */       }
/*     */     } 
/*     */     
/* 240 */     return nombre_joueur;
/*     */   }
/*     */ 
/*     */   
/*     */   public void SetScoreboard() {
/* 245 */     this.manager = Bukkit.getScoreboardManager();
/* 246 */     this.board = this.manager.getNewScoreboard();
/*     */ 
/*     */     
/* 249 */     this.RedTeamSC = this.board.registerNewTeam("Equipe Rouge");
/* 250 */     this.BlueTeamSC = this.board.registerNewTeam("Equipe Bleu");
/*     */     
/* 252 */     this.onlineCounter = this.board.registerNewTeam("onlineCounter");
/* 253 */     this.boardblue = this.board.registerNewTeam("boardblue");
/* 254 */     this.boardred = this.board.registerNewTeam("boardred");
/*     */     
/* 256 */     Objective objective = this.board.registerNewObjective("lol", "dummy");
/*     */     
/* 258 */     this.RedTeamSC.setPrefix("§4[§cEquipe Rouge§4]§c ");
/* 259 */     this.BlueTeamSC.setPrefix("§1[§9Equipe Bleu§1]§9 ");
/*     */     
/* 261 */     this.BlueTeamSC.setDisplayName("Equipe Bleu");
/* 262 */     this.RedTeamSC.setDisplayName("Equipe Rouge");
/*     */     
/* 264 */     this.BlueTeamSC.setCanSeeFriendlyInvisibles(true);
/* 265 */     this.BlueTeamSC.setAllowFriendlyFire(false);
/* 266 */     this.RedTeamSC.setCanSeeFriendlyInvisibles(true);
/* 267 */     this.RedTeamSC.setAllowFriendlyFire(false);
/*     */     
/* 269 */     this.connecter_score = Bukkit.getOnlinePlayers().size();
/* 270 */     this.cblue = this.tnt_bleu.getVie() * 2;
/* 271 */     this.cred = this.tnt_rouge.getVie() * 2;
/* 272 */     this.taille_blue = getSize("Bleu");
/* 273 */     this.taille_red = getSize("Rouge");
/* 274 */     this.timeblue = this.tnt_bleu.getTimer();
/* 275 */     this.timered = this.tnt_rouge.getTimer();
/*     */     
/* 277 */     objective.setDisplaySlot(DisplaySlot.SIDEBAR);

				objective.setDisplayName(ChatColor.GOLD + "�6-------- TNT WARS --------");
				
				Score information = objective.getScore(ChatColor.GOLD + "� Informations de la Partie");
				information.setScore(15);
/*     */     
				onlineCounter.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
				onlineCounter.setPrefix("  �eJoueurs connect�s: ");
				
				if (Bukkit.getOnlinePlayers().size() == 0) {
				    onlineCounter.setSuffix(ChatColor.AQUA + "0");
				} else {
				    onlineCounter.setSuffix("" + ChatColor.DARK_RED + Bukkit.getOnlinePlayers().size()+ "  (" + ChatColor.BLUE+taille_blue+ ChatColor.GRAY+"|"+ChatColor.RED+taille_red+ ChatColor.GRAY+")");
				}
				
				objective.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(14);
				
				boardblue.addEntry(ChatColor.WHITE + "" + ChatColor.WHITE);
				boardblue.setPrefix("  �eTNT bleu: ");
				boardblue.setSuffix(""+ ChatColor.BLUE + cblue + ChatColor.BLUE + "%" );
				objective.getScore(ChatColor.WHITE + "" + ChatColor.WHITE).setScore(13);
				
				boardred.addEntry(ChatColor.WHITE + "" + ChatColor.BLACK);
				boardred.setPrefix("  �eTNT rouge: ");
				boardred.setSuffix(""+ ChatColor.RED + cred + ChatColor.RED + "%" );
				objective.getScore(ChatColor.WHITE + "" + ChatColor.BLACK).setScore(12);
/*     */   }
/*     */ 
/*     */   
/*     */   public void AutoAddTeam(int NbEquipe) {
/* 308 */     int nombreJoueur = Bukkit.getOnlinePlayers().size();
/*     */     
/* 310 */     ArrayList<Joueur> joureursSansEquipe = new ArrayList<>();
/*     */     
/* 312 */     for (Joueur joueur : this.listeJoueurs) {
/* 313 */       if (joueur.getEquipe().getCouleur() == "Sans Equipe") {
/* 314 */         joureursSansEquipe.add(joueur);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 323 */     int joueurParEquipe = nombreJoueur / NbEquipe;
/* 324 */     int JoueurRestant = nombreJoueur % NbEquipe;
/*     */     
/* 326 */     if (joureursSansEquipe != null) {
/*     */       int i;
/*     */       
/* 329 */       for (i = 0; i < NbEquipe; i++) {
/*     */         
/* 331 */         if (i == 0) {
/*     */           
/* 333 */           int nombreRouge = 
/* 334 */             (int)this.listeJoueurs.stream().filter(s -> s.getEquipe().getCouleur().equals("Rouge")).count();
/*     */           
/* 336 */           while (nombreRouge < joueurParEquipe) {
/* 337 */             ((Joueur)joureursSansEquipe.get(0)).setEquipe(this.Equipe_rouge);
/* 338 */             deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_rouge);
/* 339 */             ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_rouge);
/* 340 */             joureursSansEquipe.remove(0);
/*     */             
/* 342 */             nombreRouge = 
/* 343 */               (int)this.listeJoueurs.stream().filter(s -> s.getEquipe().getCouleur().equals("Rouge")).count();
/*     */           }
/*     */         
/*     */         }
/* 347 */         else if (i == 1) {
/* 348 */           int nombreBleu = 
/* 349 */             (int)this.listeJoueurs.stream().filter(s -> s.getEquipe().getCouleur().equals("Bleu")).count();
/*     */           
/* 351 */           while (nombreBleu < joueurParEquipe) {
/* 352 */             ((Joueur)joureursSansEquipe.get(0)).setEquipe(this.Equipe_bleu);
/* 353 */             deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_bleu);
/* 354 */             ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_bleu);
/* 355 */             joureursSansEquipe.remove(0);
/*     */             
/* 357 */             nombreBleu = 
/* 358 */               (int)this.listeJoueurs.stream().filter(s -> s.getEquipe().getCouleur().equals("Bleu")).count();
/*     */           }
/*     */         
/* 361 */         } else if (i == 2) {
/* 362 */           int nombreVert = 
/* 363 */             (int)this.listeJoueurs.stream().filter(s -> s.getEquipe().getCouleur().equals("Vert")).count();
/*     */           
/* 365 */           while (nombreVert < joueurParEquipe) {
/* 366 */             ((Joueur)joureursSansEquipe.get(0)).setEquipe(this.Equipe_vert);
/* 367 */             deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_vert);
/* 368 */             ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_vert);
/* 369 */             joureursSansEquipe.remove(0);
/*     */             
/* 371 */             nombreVert = 
/* 372 */               (int)this.listeJoueurs.stream().filter(s -> s.getEquipe().getCouleur().equals("Vert")).count();
/*     */           }
/*     */         
/* 375 */         } else if (i == 3) {
/* 376 */           int nombreJaune = 
/* 377 */             (int)this.listeJoueurs.stream().filter(s -> s.getEquipe().getCouleur().equals("Jaune")).count();
/*     */           
/* 379 */           while (nombreJaune < joueurParEquipe) {
/* 380 */             ((Joueur)joureursSansEquipe.get(0)).setEquipe(this.Equipe_jaune);
/* 381 */             deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_jaune);
/* 382 */             ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_jaune);
/* 383 */             joureursSansEquipe.remove(0);
/* 384 */             nombreJaune = 
/* 385 */               (int)this.listeJoueurs.stream().filter(s -> s.getEquipe().getCouleur().equals("Jaune")).count();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 391 */       for (i = 0; i < JoueurRestant; i++) {
/*     */         
/* 393 */         if (i == 0) {
/* 394 */           ((Joueur)joureursSansEquipe.get(0)).setEquipe(this.Equipe_rouge);
/* 395 */           deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_rouge);
/* 396 */           ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_rouge);
/* 397 */           joureursSansEquipe.remove(0);
/*     */         }
/* 399 */         else if (i == 1) {
/* 400 */           ((Joueur)joureursSansEquipe.get(0)).setEquipe(this.Equipe_bleu);
/* 401 */           deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_bleu);
/* 402 */           ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_bleu);
/* 403 */           joureursSansEquipe.remove(0);
/*     */         }
/* 405 */         else if (i == 2) {
/* 406 */           ((Joueur)joureursSansEquipe.get(0)).setEquipe(this.Equipe_vert);
/* 407 */           deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_vert);
/* 408 */           ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_vert);
/* 409 */           joureursSansEquipe.remove(0);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void GamePlay(Joueur joueur) {
/* 463 */     joueur.setKit(joueur.getProchainKit());
/* 464 */     joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
/* 465 */     joueur.getPlayer().getInventory().clear();
/* 466 */     joueur.getPlayer().getInventory().setBoots(joueur.getKit().getBoots());
/* 467 */     joueur.getPlayer().getInventory().setChestplate(joueur.getKit().getChestplate());
/* 468 */     joueur.getPlayer().getInventory().setHelmet(joueur.getKit().getHelmet());
/* 469 */     joueur.getPlayer().getInventory().setLeggings(joueur.getKit().getLegging());
/* 470 */     joueur.getPlayer().getInventory().setItem(0, joueur.getKit().getMainWeapon());
/* 471 */     joueur.getPlayer().getInventory().setItem(1, new ItemStack(joueur.getEquipe().getLaine(), 64));
/*     */     
/* 473 */     if (joueur.getKit() == this.list_kits.get(21) || joueur.getKit() == this.list_kits.get(37)) {
/*     */       
/* 475 */       if (joueur.getKit() == this.list_kits.get(21)) {
/*     */         
/* 477 */         joueur.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getLaine(), 64) });
/* 478 */         joueur.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getLaine(), 64) });
/* 479 */         joueur.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getLaine(), 64) });
/* 480 */         ItemStack customcisaille = new ItemStack(Material.SHEARS, 1);
/* 481 */         ItemMeta customCCC = customcisaille.getItemMeta();
/* 482 */         customCCC.addEnchant(Enchantment.DIG_SPEED, 10, true);
/* 483 */         customcisaille.setItemMeta(customCCC);
/* 484 */         joueur.getPlayer().getInventory().setItem(2, customcisaille);
/*     */       } 
/* 486 */       if (joueur.getKit() == this.list_kits.get(37))
/*     */       {
/*     */         
/* 489 */         ItemStack customcisaille = new ItemStack(Material.SHEARS, 1);
/* 490 */         ItemMeta customCCC = customcisaille.getItemMeta();
/* 491 */         customCCC.addEnchant(Enchantment.DIG_SPEED, 10, true);
/* 492 */         customcisaille.setItemMeta(customCCC);
/* 493 */         joueur.getPlayer().getInventory().setItem(2, customcisaille);
/* 494 */         joueur.getPlayer().getInventory().setItem(3, new ItemStack(Material.IRON_PICKAXE));
/* 495 */         joueur.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getBlockTactique(), 64) });
/* 496 */         joueur.getPlayer().getInventory().addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getBlockTactique(), 64) });
/*     */       
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 503 */       joueur.getPlayer().getInventory().setItem(2, new ItemStack(Material.SHEARS));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 512 */     ItemStack customblazepowder = new ItemStack(Material.BLAZE_POWDER, 1);
/* 513 */     ItemMeta customBP = customblazepowder.getItemMeta();
/* 514 */     customBP.setDisplayName("Clique droit pour allumer la TNT adverse");
/* 515 */     customBP.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
/* 516 */     customBP.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 517 */     customBP.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 518 */     customblazepowder.setItemMeta(customBP);
/*     */     
/* 520 */     ItemStack customfeather = new ItemStack(Material.FEATHER, 1);
/* 521 */     ItemMeta customFF = customfeather.getItemMeta();
/* 522 */     customFF.setDisplayName("Clique droit pour d§samorcer sa TNT");
/* 523 */     customFF.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
/* 524 */     customFF.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 525 */     customFF.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 526 */     customfeather.setItemMeta(customFF);
/*     */     
/* 528 */     joueur.getPlayer().getInventory().setItem(8, customfeather);
/* 529 */     joueur.getPlayer().getInventory().setItem(7, customblazepowder);
/*     */     
/* 531 */     ItemStack customnetherstar = new ItemStack(Material.NETHER_STAR, 1);
/* 532 */     ItemMeta customNS = customnetherstar.getItemMeta();
/* 533 */     customNS.setDisplayName("Choisir le kit");
/* 534 */     customNS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
/* 535 */     customNS.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 536 */     customNS.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 537 */     customnetherstar.setItemMeta(customNS);
/* 538 */     joueur.getPlayer().getInventory().setItem(6, customnetherstar);
/*     */     
/* 540 */     if (joueur.getKit().getItemsArray() != null) {
/* 541 */       for (int i = 0; i < joueur.getKit().getItemsArray().size(); i++) {
/* 542 */         joueur.getPlayer().getInventory().addItem(new ItemStack[] { joueur.getKit().getItemsArray().get(i) });
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 548 */     sethealth(joueur);
/*     */     
/* 550 */     if (!joueur.getKit().IsVisible()) {
/* 551 */       joueur.getPlayer().setInvisible(true);
/*     */     } else {
/* 553 */       joueur.getPlayer().setInvisible(false);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void SpawnTeleportation(Joueur joueur) {
/* 564 */     if (joueur.getEquipe() == this.Equipe_rouge) {
/* 565 */       joueur.getPlayer().teleport(this.map_en_cours.getLocationSpawnEquipeArray(0));
/*     */     }
/* 567 */     if (joueur.getEquipe() == this.Equipe_bleu) {
/* 568 */       joueur.getPlayer().teleport(this.map_en_cours.getLocationSpawnEquipeArray(1));
/*     */     }
/* 570 */     if (joueur.getEquipe() == this.Equipe_vert) {
/* 571 */       joueur.getPlayer().teleport(this.map_en_cours.getLocationSpawnEquipeArray(2));
/*     */     }
/* 573 */     if (joueur.getEquipe() == this.Equipe_jaune) {
/* 574 */       joueur.getPlayer().teleport(this.map_en_cours.getLocationSpawnEquipeArray(3));
/*     */     }
/*     */   }
/*     */   
/*     */   public void CheckWin() {
/* 579 */     int nombre_de_tnt_explose = 0;
/*     */ 
/*     */ 
/*     */     
/* 583 */     if (this.tnt_rouge.getEtat() == EtatTNT.Explose) {
/* 584 */       nombre_de_tnt_explose++;
/*     */     }
/* 586 */     if (this.tnt_bleu.getEtat() == EtatTNT.Explose) {
/* 587 */       nombre_de_tnt_explose++;
/*     */     }
/* 589 */     if (this.tnt_jaune.getEtat() == EtatTNT.Explose) {
/* 590 */       nombre_de_tnt_explose++;
/*     */     }
/* 592 */     if (this.tnt_vert.getEtat() == EtatTNT.Explose) {
/* 593 */       nombre_de_tnt_explose++;
/*     */     }
/* 595 */     if (nombre_de_tnt_explose == this.map_en_cours.getNbEquipe() - 1) {
/* 596 */       for (int i = 0; i < this.listeJoueurs.size(); i++) {
/* 597 */         Joueur joueur = this.listeJoueurs.get(i);
/* 598 */         joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
/*     */       } 
/* 600 */       setState(EtatPartie.FinJeu);
/* 601 */       TimerRedemarrage cycle = new TimerRedemarrage(this);
/* 602 */       cycle.runTaskTimer((Plugin)this, 0L, 20L);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Equipe RenvoieGagnant() {
/* 608 */     Equipe gagnant = null;
/*     */     
/* 610 */     if (this.tnt_rouge.getEtat() != EtatTNT.Explose) {
/* 611 */       gagnant = this.Equipe_rouge;
/*     */     }
/* 613 */     else if (this.tnt_bleu.getEtat() != EtatTNT.Explose) {
/* 614 */       gagnant = this.Equipe_bleu;
/*     */     }
/* 616 */     else if (this.tnt_vert.getEtat() != EtatTNT.Explose) {
/* 617 */       gagnant = this.Equipe_vert;
/*     */     }
/* 619 */     else if (this.tnt_jaune.getEtat() != EtatTNT.Explose) {
/* 620 */       gagnant = this.Equipe_jaune;
/*     */     } 
/* 622 */     return gagnant;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void eliminate(Player player) {
/* 630 */     Joueur joueur = this.listeJoueurs.stream()
/* 631 */       .filter(p -> player.getName().equals(p.getPlayer().getName()))
/* 632 */       .findAny()
/* 633 */       .orElse(null);
/*     */     
/* 635 */     player.setInvulnerable(true);
/* 636 */     player.setGameMode(GameMode.CREATIVE);
/* 637 */     player.getInventory().clear();
/* 638 */     player.teleport(this.map_en_cours.getLocationSalleMort());
/* 639 */     player.sendMessage("vous etes mort");
/* 640 */     player.setInvisible(true);
/*     */     
/* 642 */     ItemStack customcompasse = new ItemStack(Material.NETHER_STAR, 1);
/* 643 */     ItemMeta customC2 = customcompasse.getItemMeta();
/* 644 */     customC2.setDisplayName("Choisir le kit");
/* 645 */     customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
/* 646 */     customC2.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/* 647 */     customC2.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
/* 648 */     customcompasse.setItemMeta(customC2);
/* 649 */     joueur.getPlayer().getInventory().setItem(4, customcompasse);
/*     */     
/* 651 */     TimerRespawn cycle = new TimerRespawn(this, player);
/* 652 */     cycle.runTaskTimer((Plugin)this, 0L, 20L);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sethealth(Joueur joueur) {
/* 658 */     if (isState(EtatPartie.JeuEnCours)) {
/* 659 */       joueur.getPlayer().setMaxHealth(joueur.getKit().getPointVie());
/* 660 */       joueur.getPlayer().setHealth(joueur.getKit().getPointVie());
/* 661 */       joueur.getPlayer().setFoodLevel(20);
/*     */     } else {
/* 663 */       joueur.getPlayer().setMaxHealth(20.0D);
/* 664 */       joueur.getPlayer().setHealth(20.0D);
/* 665 */       joueur.getPlayer().setFoodLevel(20);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void respawn(Player player) {
/* 670 */     Joueur joueur = this.listeJoueurs.stream()
/* 671 */       .filter(p -> player.getName().equals(p.getPlayer().getName()))
/* 672 */       .findAny()
/* 673 */       .orElse(null);
/*     */     
/* 675 */     player.setGameMode(GameMode.SURVIVAL);
/* 676 */     player.setInvisible(false);
/* 677 */     SpawnTeleportation(joueur);
/* 678 */     Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "effect clear " + joueur.getPlayer().getName());
/*     */     
/* 680 */     TimerImmortality start = new TimerImmortality(this, joueur.getPlayer());
/* 681 */     start.runTaskTimer((Plugin)this, 0L, 20L);
/* 682 */     GamePlay(joueur);
/*     */   }
/*     */ 
/*     */   
/*     */   public void RejoindEquipe(Joueur joueur, Equipe equipe, int NbEquipe) {
/* 687 */     if (joueur.getEquipe() == equipe) {
/* 688 */       joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eVous etes d§ja " + equipe.getCouleur() + ".");
/*     */     }
/*     */     
/* 691 */     if (joueur.getEquipe() != equipe)
/*     */     {
/* 693 */       if (this.listeJoueurs.size() / NbEquipe >= getSize(equipe.getCouleur())) {
/*     */         
/* 695 */         if (this.listeJoueurs.size() == 2 && NbEquipe == 2) {
/* 696 */           if (equipe == this.Equipe_bleu) {
/* 697 */             if (getSize(CouleurEquipe.Bleu.toString()) == 1 && getSize(CouleurEquipe.Jaune.toString()) == 0) {
/* 698 */               joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les " + equipe.getCouleur() + " essayez une autre §quipe ou plus tard.");
/*     */               
/*     */               return;
/*     */             } 
/* 702 */           } else if (getSize(CouleurEquipe.Rouge.toString()) == 1 && getSize(CouleurEquipe.Bleu.toString()) == 0) {
/* 703 */             joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les " + equipe.getCouleur() + " essaie les rouges ou plus tard.");
/*     */ 
/*     */             
/*     */             return;
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/* 711 */         deletejoueurscoreboard(joueur, equipe);
/* 712 */         joueur.setEquipe(equipe);
/* 713 */         ajoutjoueurscoreboard(joueur, equipe);
/*     */ 
/*     */         
/* 716 */         joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eVous avez rejoinds l'équipe " + equipe.getCouleur() + ".");
/*     */       } else {
/* 718 */         joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les " + equipe.getCouleur() + " essayez une autre équipe ou plus tard.");
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SuppressWarnings("deprecation")
public void ajoutjoueurscoreboard(Joueur joueur, Equipe equipe) {
/* 725 */     if (equipe == this.Equipe_bleu) {
/* 726 */       this.BlueTeamSC.addPlayer(joueur.getPlayer());
/*     */     }
/* 728 */     else if (equipe == this.Equipe_rouge) {
/* 729 */       this.RedTeamSC.addPlayer(joueur.getPlayer());
/*     */     }
/* 731 */     else if (equipe == this.Equipe_vert) {
/* 732 */       this.GreenTeamSC.addPlayer(joueur.getPlayer());
/*     */     }
/* 734 */     else if (equipe == this.Equipe_jaune) {
/* 735 */       this.YellowTeamSC.addPlayer(joueur.getPlayer());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @SuppressWarnings("deprecation")
public void deletejoueurscoreboard(Joueur joueur, Equipe equipe) {
/* 742 */     if (equipe == this.Equipe_bleu) {
/* 743 */       this.BlueTeamSC.removePlayer(joueur.getPlayer());
/*     */     }
/* 745 */     else if (equipe == this.Equipe_rouge) {
/* 746 */       this.RedTeamSC.removePlayer(joueur.getPlayer());
/*     */     }
/* 748 */     else if (equipe == this.Equipe_vert) {
/* 749 */       this.GreenTeamSC.removePlayer(joueur.getPlayer());
/*     */     }
/* 751 */     else if (equipe == this.Equipe_jaune) {
/* 752 */       this.YellowTeamSC.removePlayer(joueur.getPlayer());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isState(EtatPartie etatPartie) {
/* 758 */     return (this.Etat == etatPartie);
/*     */   }
/*     */   
/*     */   public void setState(EtatPartie etatPartie) {
/* 762 */     this.Etat = etatPartie;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void PutLocationInTnt(int NBEQUIPE) {
/* 768 */     this.tnt_rouge.setLocation(this.map_en_cours.getLocationTntArray(0));
/* 769 */     this.tnt_bleu.setLocation(this.map_en_cours.getLocationTntArray(1));
/* 770 */     switch (NBEQUIPE) {
/*     */       case 2:
/*     */         return;
/*     */       
/*     */       case 3:
/* 775 */         this.tnt_vert.setLocation(this.map_en_cours.getLocationTntArray(2));
/*     */       
/*     */       case 4:
/* 778 */         this.tnt_jaune.setLocation(this.map_en_cours.getLocationTntArray(3));
/*     */     } 
/*     */     
/* 781 */     System.out.println("erreur alloue location tnt");
/*     */   }
/*     */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\GMain.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */