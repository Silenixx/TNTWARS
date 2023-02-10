package fr.silenix.tntwars;

import Constante.Constantes;
import Enum.EtatPartie;
import Enum.EtatTNT;
import Fonctions.CreateKit;
import Fonctions.Fonctions;
import Fonctions.IndexKit;
import fr.silenix.tntwars.Bdd.DataBaseManager;
import fr.silenix.tntwars.entity.Equipe;
import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.entity.Kit;
import fr.silenix.tntwars.entity.Map;
import fr.silenix.tntwars.entity.Tnt;
import fr.silenix.tntwars.listener.DamageListeners;
import fr.silenix.tntwars.listener.PlayerListeners;
import fr.silenix.tntwars.tasks.TaskLancementPartie;
import fr.silenix.tntwars.timer.TimerImmortality;
import fr.silenix.tntwars.timer.TimerRedemarrage;
import fr.silenix.tntwars.timer.TimerRespawn;
import fr.silenix.tntwars.timer.TimerScoreboard;
import fr.silenix.tntwars.timer.TimerVictoire;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import Command.CommandEliminate;

public class GMain extends JavaPlugin {

	public boolean isfirstJoueur = true;
	public DataBaseManager dataBaseManager;
	public int Avancement_Max_Global_TNT = 50;

	public Team RedTeamSC;

	public Team BlueTeamSC;
	public Team GreenTeamSC;
	public Team YellowTeamSC;
	public World world = null;

	public Equipe Equipe_rouge = new Equipe("Rouge", false, Material.RED_WOOL, Material.RED_GLAZED_TERRACOTTA,
			Color.RED, ChatColor.RED);
	public Equipe Equipe_bleu = new Equipe("Bleu", false, Material.BLUE_WOOL, Material.BLUE_GLAZED_TERRACOTTA,
			Color.BLUE, ChatColor.BLUE);
	public Equipe Equipe_vert = new Equipe("Vert", false, Material.GREEN_WOOL, Material.GREEN_GLAZED_TERRACOTTA,
			Color.GREEN, ChatColor.GREEN);
	public Equipe Equipe_jaune = new Equipe("Jaune", false, Material.YELLOW_WOOL, Material.YELLOW_GLAZED_TERRACOTTA,
			Color.YELLOW, ChatColor.YELLOW);
	public Equipe Sans_Equipe = new Equipe("Sans Equipe", true, null, null, null, null);

	public Tnt tnt_rouge = new Tnt(this.Equipe_rouge, 0, EtatTNT.Eteinte, 30, 0, null);
	public Tnt tnt_bleu = new Tnt(this.Equipe_bleu, 0, EtatTNT.Eteinte, 30, 1, null);
	public Tnt tnt_vert = new Tnt(this.Equipe_vert, 0, EtatTNT.Eteinte, 30, 2, null);
	public Tnt tnt_jaune = new Tnt(this.Equipe_jaune, 0, EtatTNT.Eteinte, 30, 3, null);

	public Kit Sans_Kit = new Kit("Sans Kit", null, null, null, null, null, Constantes.Vie_Global_Joueur, null, null,
			true, new ItemStack(Material.ACACIA_BOAT), null, "tnt.sanskit");

	public ArrayList<Kit> list_kits;
	public ArrayList<String> list_messages_morts;
	public ArrayList<Tnt> listTnt = new ArrayList<>();

	public ScoreboardManager manager;

	public Scoreboard board;

	public Team onlineCounter;

	public Team boardblue;

	public Team boardred;
	public int connecter_score;
	public int cblue;
	public int cred;
	public int taille_blue;
	public int taille_red;
	public int timeblue;
	public int timered;
	public int mort_rouge;
	public int mort_bleu;
	public Map map_en_cours;
	public List<Map> list_maps = new ArrayList<>();

	public List<Joueur> listeJoueurs = new ArrayList<>();
	public List<Joueur> listeConnecte = new ArrayList<>();

	public List<Material> AllowBlockPoserCasser = new ArrayList<>(Arrays.asList(new Material[] { 
			Material.RED_WOOL,
			Material.BLUE_WOOL, 
			Material.GREEN_WOOL, 
			Material.YELLOW_WOOL, 
			Material.RED_GLAZED_TERRACOTTA,
			Material.BLUE_GLAZED_TERRACOTTA, 
			Material.GREEN_GLAZED_TERRACOTTA, 
			Material.YELLOW_GLAZED_TERRACOTTA 
			}));
	public List<String> list_efface = new ArrayList<>(Arrays.asList(new String[] { 
			"minecraft:red_wool",
			"minecraft:blue_wool", 
			"minecraft:green_wool", 
			"minecraft:yellow_wool", 
			"minecraft:red_glazed_terracotta",
			"minecraft:blue_glazed_terracotta", 
			"minecraft:green_glazed_terracotta", 
			"minecraft:yellow_glazed_terracotta" 
			}));
	public List<String> list_joueur_casser_poser = new ArrayList<>(Arrays.asList(new String[] { 
			"Silenix",
			"Elkomedien", 

			}));

	public List<Material> ListTacticien = new ArrayList<>(Arrays.asList(new Material[] {

			Material.RED_GLAZED_TERRACOTTA, Material.BLUE_GLAZED_TERRACOTTA, Material.GREEN_GLAZED_TERRACOTTA,
			Material.YELLOW_GLAZED_TERRACOTTA }));
	public List<Material> ListWool = new ArrayList<>(Arrays.asList(new Material[] {

			Material.RED_WOOL, Material.BLUE_WOOL, Material.GREEN_WOOL, Material.YELLOW_WOOL }));

	private EtatPartie Etat;

	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();

		setState(EtatPartie.AttenteJoueur);

		getCommand("eliminate").setExecutor(new CommandEliminate(this));

		this.dataBaseManager = new DataBaseManager();

		list_kits = CreateKit.CreationKit();

		SetScoreboard();

		TimerScoreboard cycle = new TimerScoreboard(this);
		cycle.runTaskTimer((Plugin) this, 0L, 20L);
		
		TimerVictoire cycleVictoire = new TimerVictoire(this);
		cycleVictoire.runTaskTimer((Plugin) this, 0L, 20L);

		pm.registerEvents((Listener) new PlayerListeners(this), (Plugin) this);
		pm.registerEvents((Listener) new DamageListeners(this), (Plugin) this);
	}

	public void remiseazero() {
		Bukkit.broadcastMessage(Constante.Constantes.PluginName + "Redemmarage du mode de jeu fait");
		this.tnt_rouge.setEtat(EtatTNT.Eteinte);
		this.tnt_bleu.setEtat(EtatTNT.Eteinte);
		this.tnt_vert.setEtat(EtatTNT.Eteinte);
		this.tnt_jaune.setEtat(EtatTNT.Eteinte);

		this.tnt_bleu.setTimer(30);
		this.tnt_rouge.setTimer(30);
		this.tnt_vert.setTimer(30);
		this.tnt_jaune.setTimer(30);

		this.tnt_bleu.setVie(0);
		this.tnt_rouge.setVie(0);
		this.tnt_jaune.setVie(0);
		this.tnt_vert.setVie(0);

		setState(EtatPartie.AttenteJoueur);

		for (Joueur joueur : listeJoueurs) {
			deletejoueurscoreboard(joueur, joueur.getEquipe());
			joueur.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), -828.0D, 76.0D, -321.0D, -90, 0));
			
		}

		this.listeJoueurs.clear();
		int i;
		/*for (i = 0; i < this.listeConnecte.size(); i++) {
			Joueur joueur_tempo = new Joueur(((Joueur) this.listeConnecte.get(i)).getPlayer(),
					((Joueur) this.listeConnecte.get(i)).getPlayer().getName(), this.Sans_Equipe, this.list_kits.get(0),
					this.list_kits.get(0), 0);
			this.listeJoueurs.add(joueur_tempo);
		}*/

		/*for (i = 0; i < 5; i++) {
			Collections.shuffle(this.listeJoueurs);
		}*/

		for (i = 0; i < this.listeConnecte.size(); i++) {
			Joueur joueur = this.listeConnecte.get(i);

			joueur.getPlayer().setInvisible(false);
			//joueur.getPlayer().teleport(new Location(joueur.getPlayer().getWorld(), 6.0D, 1.0D, 1.0D));
			joueur.getPlayer().setInvulnerable(false);
			joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
			joueur.getPlayer().getInventory().clear();

			ItemStack customnWHITE_BANNER = new ItemStack(Material.WHITE_BANNER, 1);
			ItemMeta customWB = customnWHITE_BANNER.getItemMeta();
			customWB.setDisplayName("Rejoindre la partie");
			customWB.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
			customWB.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
			customWB.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
			customnWHITE_BANNER.setItemMeta(customWB);
			joueur.getPlayer().getInventory().setItem(0, customnWHITE_BANNER);
			
			
		}

		/*if (isState(EtatPartie.AttenteJoueur) && this.listeJoueurs.size() >= 2 && !isState(EtatPartie.Lancement)) {
			Bukkit.broadcastMessage(
					Constante.Constantes.PluginName + "Assez de monde pour relancer une nouvelle partie.");
			setState(EtatPartie.Lancement);
			TaskLancementPartie start = new TaskLancementPartie(this);
			start.runTaskTimer(this, 0L, 20L);
		}*/
	}

	public void efface_block() {
		for (int x = this.map_en_cours.getLocationMapBorne1().getBlockX(); x != this.map_en_cours.getLocationMapBorne2()
				.getBlockX(); x++) {
			for (int y = this.map_en_cours.getLocationMapBorne1().getBlockY(); y != this.map_en_cours
					.getLocationMapBorne2().getBlockY(); y++) {
				for (int z = this.map_en_cours.getLocationMapBorne1().getBlockZ(); z != this.map_en_cours
						.getLocationMapBorne2().getBlockZ(); z++) {
					if (this.AllowBlockPoserCasser.contains(
							((Joueur) this.listeJoueurs.get(0)).getPlayer().getWorld().getBlockAt(x, y, z).getType())) {
						((Joueur) this.listeJoueurs.get(0)).getPlayer().getWorld().getBlockAt(x, y, z)
								.setType(Material.AIR);
					}
				}
			}
		}
		/*for(int i=0 ; i < list_efface.size(); i++) {
			getServer().dispatchCommand(getServer().getConsoleSender(),
				"fill " 
				+ map_en_cours.getLocationMapBorne1().getBlockX() + " " + map_en_cours.getLocationMapBorne1().getBlockY() + " " + map_en_cours.getLocationMapBorne1().getBlockZ()
				+ " " + map_en_cours.getLocationMapBorne2().getBlockX() + " " + map_en_cours.getLocationMapBorne2().getBlockY() + " " + map_en_cours.getLocationMapBorne2().getBlockZ()
				+ " " + "air replace " + list_efface.get(i)
				);
		}*/

		
	}

	public int getSize(String couleur) {
		int nombre_joueur = 0;
		for (int i = 0; i < this.listeConnecte.size(); i++) {
			Joueur joueur = this.listeConnecte.get(i);
			if (joueur.getEquipe().getCouleur() == couleur) {
				nombre_joueur++;
			}
		}

		return nombre_joueur;
	}

	public void SetScoreboard() {
		this.manager = Bukkit.getScoreboardManager();
		this.board = this.manager.getNewScoreboard();

		this.RedTeamSC = this.board.registerNewTeam("Equipe Rouge");
		this.BlueTeamSC = this.board.registerNewTeam("Equipe Bleu");

		this.onlineCounter = this.board.registerNewTeam("onlineCounter");
		this.boardblue = this.board.registerNewTeam("boardblue");
		this.boardred = this.board.registerNewTeam("boardred");

		@SuppressWarnings("deprecation")
		Objective objective = this.board.registerNewObjective("lol", "dummy");

		this.RedTeamSC.setPrefix("§4[§cÉquipe Rouge§4]§c ");
		this.BlueTeamSC.setPrefix("§1[§9Équipe Bleu§1]§9 ");

		this.BlueTeamSC.setDisplayName("Equipe Bleu");
		this.RedTeamSC.setDisplayName("Equipe Rouge");

		this.BlueTeamSC.setCanSeeFriendlyInvisibles(true);
		this.BlueTeamSC.setAllowFriendlyFire(false);
		this.RedTeamSC.setCanSeeFriendlyInvisibles(true);
		this.RedTeamSC.setAllowFriendlyFire(false);

		this.connecter_score = Bukkit.getOnlinePlayers().size();
		this.cblue = this.tnt_bleu.getVie() * 2;
		this.cred = this.tnt_rouge.getVie() * 2;
		this.taille_blue = getSize("Bleu");
		this.taille_red = getSize("Rouge");
		this.timeblue = this.tnt_bleu.getTimer();
		this.timered = this.tnt_rouge.getTimer();

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);

		objective.setDisplayName(ChatColor.GOLD + "§6-------- TNT WARS --------");

		Score information = objective.getScore(ChatColor.GOLD + "§6 Informations de la Partie");
		information.setScore(15);

		onlineCounter.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
		onlineCounter.setPrefix("  §eJoueurs connectés: ");

		if (Bukkit.getOnlinePlayers().size() == 0) {
			onlineCounter.setSuffix(ChatColor.AQUA + "0");
		} else {
			onlineCounter.setSuffix("" + ChatColor.DARK_RED + Bukkit.getOnlinePlayers().size() + "  (" + ChatColor.BLUE
					+ taille_blue + ChatColor.GRAY + "|" + ChatColor.RED + taille_red + ChatColor.GRAY + ")");
		}

		objective.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(14);

		boardblue.addEntry(ChatColor.WHITE + "" + ChatColor.WHITE);
		boardblue.setPrefix("  §eTNT bleu: ");
		boardblue.setSuffix("" + ChatColor.BLUE + cblue + ChatColor.BLUE + "%");
		objective.getScore(ChatColor.WHITE + "" + ChatColor.WHITE).setScore(13);

		boardred.addEntry(ChatColor.WHITE + "" + ChatColor.BLACK);
		boardred.setPrefix("  §eTNT rouge: ");
		boardred.setSuffix("" + ChatColor.RED + cred + ChatColor.RED + "%");
		objective.getScore(ChatColor.WHITE + "" + ChatColor.BLACK).setScore(12);
	}

	public void AutoAddTeam(int NbEquipe) {
		//int nombreJoueurserveur = Bukkit.getOnlinePlayers().size();
		
		int nombreJoueur = listeJoueurs.size();
		
		ArrayList<Joueur> joureursSansEquipe = new ArrayList<>();

		for (Joueur joueur : this.listeJoueurs) {
			if (joueur.getEquipe().getCouleur() == "Sans Equipe") {
				joureursSansEquipe.add(joueur);
			}
		}

		int joueurParEquipe = nombreJoueur / NbEquipe;
		int JoueurRestant = nombreJoueur % NbEquipe;

		if (joureursSansEquipe != null) {
			int i;

			for (i = 0; i < NbEquipe; i++) {

				if (i == 0) {

					int nombreRouge = (int) this.listeJoueurs.stream()
							.filter(s -> s.getEquipe().getCouleur().equals("Rouge")).count();

					while (nombreRouge < joueurParEquipe) {
						((Joueur) joureursSansEquipe.get(0)).setEquipe(this.Equipe_rouge);
						deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_rouge);
						ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_rouge);
						joureursSansEquipe.remove(0);

						nombreRouge = (int) this.listeJoueurs.stream()
								.filter(s -> s.getEquipe().getCouleur().equals("Rouge")).count();
					}

				} else if (i == 1) {
					int nombreBleu = (int) this.listeJoueurs.stream()
							.filter(s -> s.getEquipe().getCouleur().equals("Bleu")).count();

					while (nombreBleu < joueurParEquipe) {
						((Joueur) joureursSansEquipe.get(0)).setEquipe(this.Equipe_bleu);
						deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_bleu);
						ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_bleu);
						joureursSansEquipe.remove(0);

						nombreBleu = (int) this.listeJoueurs.stream()
								.filter(s -> s.getEquipe().getCouleur().equals("Bleu")).count();
					}

				} else if (i == 2) {
					int nombreVert = (int) this.listeJoueurs.stream()
							.filter(s -> s.getEquipe().getCouleur().equals("Vert")).count();

					while (nombreVert < joueurParEquipe) {
						((Joueur) joureursSansEquipe.get(0)).setEquipe(this.Equipe_vert);
						deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_vert);
						ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_vert);
						joureursSansEquipe.remove(0);

						nombreVert = (int) this.listeJoueurs.stream()
								.filter(s -> s.getEquipe().getCouleur().equals("Vert")).count();
					}

				} else if (i == 3) {
					int nombreJaune = (int) this.listeJoueurs.stream()
							.filter(s -> s.getEquipe().getCouleur().equals("Jaune")).count();

					while (nombreJaune < joueurParEquipe) {
						((Joueur) joureursSansEquipe.get(0)).setEquipe(this.Equipe_jaune);
						deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_jaune);
						ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_jaune);
						joureursSansEquipe.remove(0);
						nombreJaune = (int) this.listeJoueurs.stream()
								.filter(s -> s.getEquipe().getCouleur().equals("Jaune")).count();
					}
				}
			}

			for (i = 0; i < JoueurRestant; i++) {

				if (i == 0) {
					((Joueur) joureursSansEquipe.get(0)).setEquipe(this.Equipe_rouge);
					deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_rouge);
					ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_rouge);
					joureursSansEquipe.remove(0);
				} else if (i == 1) {
					((Joueur) joureursSansEquipe.get(0)).setEquipe(this.Equipe_bleu);
					deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_bleu);
					ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_bleu);
					joureursSansEquipe.remove(0);
				} else if (i == 2) {
					((Joueur) joureursSansEquipe.get(0)).setEquipe(this.Equipe_vert);
					deletejoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_vert);
					ajoutjoueurscoreboard(joureursSansEquipe.get(0), this.Equipe_vert);
					joureursSansEquipe.remove(0);
				}
			}
		}
	}

	public void GamePlay(Joueur joueur) {
		joueur.setKit(joueur.getProchainKit());
		joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
		joueur.getPlayer().setFlying(false);
		joueur.getPlayer().setAllowFlight(false);
		joueur.getPlayer().getInventory().clear();

		if (joueur.getKit() == this.list_kits.get(IndexKit.Hasard)) {
			Random random_kit = new Random();
			int value_random_kit = random_kit.nextInt(39 + 0) + 0;
			joueur.setKit(list_kits.get(value_random_kit));

		}

		joueur.getPlayer().getInventory().setBoots(joueur.getKit().getBoots());
		joueur.getPlayer().getInventory().setChestplate(joueur.getKit().getChestplate());
		joueur.getPlayer().getInventory().setHelmet(joueur.getKit().getHelmet());
		joueur.getPlayer().getInventory().setLeggings(joueur.getKit().getLegging());
		joueur.getPlayer().getInventory().setItem(0, joueur.getKit().getMainWeapon());
		joueur.getPlayer().getInventory().setItem(1, new ItemStack(joueur.getEquipe().getLaine(), 64));

		if (joueur.getKit() == this.list_kits.get(21) || joueur.getKit() == this.list_kits.get(37)) {

			if (joueur.getKit() == this.list_kits.get(21)) {

				joueur.getPlayer().getInventory()
						.addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getLaine(), 64) });
				joueur.getPlayer().getInventory()
						.addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getLaine(), 64) });
				joueur.getPlayer().getInventory()
						.addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getLaine(), 64) });
				ItemStack customcisaille = new ItemStack(Material.SHEARS, 1);
				ItemMeta customCCC = customcisaille.getItemMeta();
				customCCC.addEnchant(Enchantment.DIG_SPEED, 10, true);
				customcisaille.setItemMeta(customCCC);
				joueur.getPlayer().getInventory().setItem(2, customcisaille);
			}
			if (joueur.getKit() == this.list_kits.get(37)) {

				ItemStack customcisaille = new ItemStack(Material.SHEARS, 1);
				ItemMeta customCCC = customcisaille.getItemMeta();
				customCCC.addEnchant(Enchantment.DIG_SPEED, 10, true);
				customcisaille.setItemMeta(customCCC);
				joueur.getPlayer().getInventory().setItem(2, customcisaille);
				joueur.getPlayer().getInventory().setItem(3, new ItemStack(Material.IRON_PICKAXE));
				joueur.getPlayer().getInventory()
						.addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getBlockTactique(), 64) });
				joueur.getPlayer().getInventory()
						.addItem(new ItemStack[] { new ItemStack(joueur.getEquipe().getBlockTactique(), 64) });

			}

		} else {

			joueur.getPlayer().getInventory().setItem(2, new ItemStack(Material.SHEARS));
		}

		ItemStack customblazepowder = new ItemStack(Material.BLAZE_POWDER, 1);
		ItemMeta customBP = customblazepowder.getItemMeta();
		customBP.setDisplayName("Clique droit pour allumer la TNT adverse");
		customBP.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		customBP.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		customBP.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
		customblazepowder.setItemMeta(customBP);

		ItemStack customfeather = new ItemStack(Material.FEATHER, 1);
		ItemMeta customFF = customfeather.getItemMeta();
		customFF.setDisplayName("Clique droit pour d§samorcer sa TNT");
		customFF.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		customFF.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		customFF.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
		customfeather.setItemMeta(customFF);

		joueur.getPlayer().getInventory().setItem(8, customfeather);
		joueur.getPlayer().getInventory().setItem(7, customblazepowder);

		ItemStack customnetherstar = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta customNS = customnetherstar.getItemMeta();
		customNS.setDisplayName("Choisir le kit");
		customNS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
		customNS.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		customNS.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
		customnetherstar.setItemMeta(customNS);
		joueur.getPlayer().getInventory().setItem(6, customnetherstar);

		if (joueur.getKit().getItemsArray() != null) {
			for (int i = 0; i < joueur.getKit().getItemsArray().size(); i++) {
				joueur.getPlayer().getInventory().addItem(new ItemStack[] { joueur.getKit().getItemsArray().get(i) });
			}
		}

		sethealth(joueur,joueur.getKit());

		if (joueur.getKit() == this.list_kits.get(IndexKit.Pyro)) {
			Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
					"effect give " + joueur.getPlayer().getName() + " minecraft:fire_resistance 9999");
		}

		if (joueur.getKit() == this.list_kits.get(IndexKit.Pirate)) {
			Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
					"effect give " + joueur.getPlayer().getName() + " minecraft:water_breathing 9999");
			Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
					"effect give " + joueur.getPlayer().getName() + " minecraft:dolphins_grace 9999");
		}

		if (!joueur.getKit().IsVisible()) {
			joueur.getPlayer().setInvisible(true);
		} else {
			joueur.getPlayer().setInvisible(false);
		}
	}

	public void SpawnTeleportation(Joueur joueur) {
		if (joueur.getEquipe() == this.Equipe_rouge) {
			joueur.getPlayer().teleport(this.map_en_cours.getLocationSpawnEquipeArray(0));
		}
		if (joueur.getEquipe() == this.Equipe_bleu) {
			joueur.getPlayer().teleport(this.map_en_cours.getLocationSpawnEquipeArray(1));
		}
		if (joueur.getEquipe() == this.Equipe_vert) {
			joueur.getPlayer().teleport(this.map_en_cours.getLocationSpawnEquipeArray(2));
		}
		if (joueur.getEquipe() == this.Equipe_jaune) {
			joueur.getPlayer().teleport(this.map_en_cours.getLocationSpawnEquipeArray(3));
		}
	}

	public void CheckWin() {
		if (isState(EtatPartie.JeuEnCours)) {
			int nombre_de_tnt_explose = 0;
			
			if (this.tnt_rouge.getEtat() == EtatTNT.Explose) {
				nombre_de_tnt_explose++;
			}
			if (this.tnt_bleu.getEtat() == EtatTNT.Explose) {
				nombre_de_tnt_explose++;
			}
			if (this.tnt_jaune.getEtat() == EtatTNT.Explose) {
				nombre_de_tnt_explose++;
			}
			if (this.tnt_vert.getEtat() == EtatTNT.Explose) {
				nombre_de_tnt_explose++;
			}
			if (nombre_de_tnt_explose == this.map_en_cours.getNbEquipe() - 1) {
				for (int i = 0; i < this.listeJoueurs.size(); i++) {
					Joueur joueur = this.listeJoueurs.get(i);
					joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
				}
				setState(EtatPartie.FinJeu);
				TimerRedemarrage cycle = new TimerRedemarrage(this);
				cycle.runTaskTimer((Plugin) this, 0L, 20L);
			}
			
			
			
			
		}
		
	}
	

	public Equipe RenvoieGagnant() {
		Equipe gagnant = null;

		if (this.tnt_rouge.getEtat() != EtatTNT.Explose) {
			gagnant = this.Equipe_rouge;
		} else if (this.tnt_bleu.getEtat() != EtatTNT.Explose) {
			gagnant = this.Equipe_bleu;
		} else if (this.tnt_vert.getEtat() != EtatTNT.Explose) {
			gagnant = this.Equipe_vert;
		} else if (this.tnt_jaune.getEtat() != EtatTNT.Explose) {
			gagnant = this.Equipe_jaune;
		}
		return gagnant;
	}

	public void eliminate(Player player) {
		Joueur joueur = this.listeJoueurs.stream().filter(p -> player.getName().equals(p.getPlayer().getName()))
				.findAny().orElse(null);

		
		
		DeleteAnimals(joueur);

		player.setInvulnerable(true);
		player.setGameMode(GameMode.CREATIVE);
		player.getInventory().clear();
		player.teleport(this.map_en_cours.getLocationSalleMort());
		//player.sendMessage("vous etes mort");
		player.setInvisible(true);

		ItemStack customcompasse = new ItemStack(Material.NETHER_STAR, 1);
		ItemMeta customC2 = customcompasse.getItemMeta();
		customC2.setDisplayName("Choisir le kit");
		customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
		customC2.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
		customC2.setLore(Arrays.asList(new String[] { "premiere ligne", "deuxieme", "troisieme" }));
		customcompasse.setItemMeta(customC2);
		joueur.getPlayer().getInventory().setItem(4, customcompasse);

		TimerRespawn cycle = new TimerRespawn(this, player);
		cycle.runTaskTimer((Plugin) this, 0L, 20L);
	}

	@SuppressWarnings("deprecation")
	public void sethealth(Joueur joueur, Kit kit) {
		if (isState(EtatPartie.JeuEnCours)) {
			joueur.getPlayer().setMaxHealth(kit.getPointVie());
			joueur.getPlayer().setHealth(kit.getPointVie());
			joueur.getPlayer().setFoodLevel(20);
		} else {
			joueur.getPlayer().setMaxHealth(20.0D);
			joueur.getPlayer().setHealth(20.0D);
			joueur.getPlayer().setFoodLevel(20);
		}
		removeEffet(joueur.getPlayer());
	}

	public void removeEffet(Player player) {
		Joueur joueur = this.listeJoueurs.stream().filter(p -> player.getName().equals(p.getPlayer().getName()))
				.findAny().orElse(null);

		if (player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) {
			Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
					"effect clear " + joueur.getPlayer().getName());
		}

		if (player.hasPotionEffect(PotionEffectType.WATER_BREATHING)) {
			Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
					"effect clear " + joueur.getPlayer().getName());
		}
		if (player.hasPotionEffect(PotionEffectType.DOLPHINS_GRACE)) {
			Bukkit.dispatchCommand((CommandSender) Bukkit.getConsoleSender(),
					"effect clear " + joueur.getPlayer().getName());
		}
	}

	public void respawn(Player player) {
		Joueur joueur = this.listeJoueurs.stream().filter(p -> player.getName().equals(p.getPlayer().getName()))
				.findAny().orElse(null);

		player.setGameMode(GameMode.SURVIVAL);
		player.setInvisible(false);
		
		if(joueur != null) {
			SpawnTeleportation(joueur);
			removeEffet(player);
			TimerImmortality start = new TimerImmortality(/*this,*/ joueur.getPlayer());
			start.runTaskTimer((Plugin) this, 0L, 20L);
			GamePlay(joueur);
		}
		
	}

	public static int getSmallest(int[] a, int total) {
		int temp;
		for (int i = 0; i < total; i++) {
			for (int j = i + 1; j < total; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a[0];
	}

	public void RejoindEquipe(Joueur joueur, Equipe equipe, int NbEquipe) {
		/*
		 * if (joueur.getEquipe() == equipe) {
		 * joueur.getPlayer().sendMessage(Constante.Constantes.PluginName +
		 * "Vous etes déjà " + equipe.getCouleur() + "."); }
		 * 
		 * if (joueur.getEquipe() != equipe) { if (this.listeJoueurs.size() / NbEquipe
		 * >= getSize(equipe.getCouleur())) { if (this.listeJoueurs.size() == 2 &&
		 * NbEquipe == 2) { if (equipe == this.Equipe_bleu) { if
		 * (getSize(CouleurEquipe.Bleu.toString()) == 1 &&
		 * getSize(CouleurEquipe.Jaune.toString()) == 0) {
		 * joueur.getPlayer().sendMessage(Constante.Constantes.PluginName +
		 * "Trop de monde chez les " + equipe.getCouleur() +
		 * " essayez une autre équipe ou plus tard.");
		 * 
		 * return; } } else if (getSize(CouleurEquipe.Rouge.toString()) == 1 &&
		 * getSize(CouleurEquipe.Bleu.toString()) == 0) {
		 * joueur.getPlayer().sendMessage(Constante.Constantes.PluginName +
		 * "Trop de monde chez les " + equipe.getCouleur() +
		 * " essaie les rouges ou plus tard.");
		 * 
		 * 
		 * return; } }
		 * 
		 * 
		 * deletejoueurscoreboard(joueur, equipe); joueur.setEquipe(equipe);
		 * ajoutjoueurscoreboard(joueur, equipe);
		 * 
		 * 
		 * joueur.getPlayer().sendMessage(Constante.Constantes.PluginName +
		 * "Vous avez rejoind l'équipe " + equipe.getCouleur() + "."); } else {
		 * joueur.getPlayer().sendMessage(Constante.Constantes.PluginName +
		 * "Trop de monde chez les " + equipe.getCouleur() +
		 * " essayez une autre équipe ou plus tard."); } }
		 */

		//int nombreJoueur = listeJoueurs.size();

		int nbr_rouge = 0;
		int nbr_bleu = 0;
		int nbr_vert = 0;
		int nbr_jaune = 0;

		for (Joueur joueurtri : this.listeJoueurs) {
			if (joueurtri.getEquipe().getCouleur() == "Rouge") {
				nbr_rouge++;
			} else if (joueurtri.getEquipe().getCouleur() == "Bleu") {
				nbr_bleu++;
			} else if (joueurtri.getEquipe().getCouleur() == "Vert" && NbEquipe > 2) {
				nbr_vert++;
			} else if (joueurtri.getEquipe().getCouleur() == "Jaune" && NbEquipe > 3) {
				nbr_jaune++;
			}
		}

		/*
		 * int joueurParEquipe = nombreJoueur / NbEquipe; int JoueurRestant =
		 * nombreJoueur % NbEquipe;
		 */

		switch (NbEquipe) {

		case 2:
			int tab_case2[] = { nbr_rouge, nbr_bleu };
			int lowest_case2 = getSmallest(tab_case2, 2);

			if (lowest_case2 == nbr_rouge && equipe == Equipe_rouge) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else if (lowest_case2 == nbr_bleu && equipe == Equipe_bleu) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else {
				joueur.getPlayer().sendMessage(Constante.Constantes.PluginName + "Trop de monde chez les "
						+ equipe.getCouleur() + " essayez une autre équipe ou plus tard.");
			}
			break;

		case 3:

			int tab_case3[] = { nbr_rouge, nbr_bleu, nbr_vert };
			int lowest_case3 = getSmallest(tab_case3, 3);

			if (lowest_case3 == nbr_rouge && equipe == Equipe_rouge) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else if (lowest_case3 == nbr_bleu && equipe == Equipe_bleu) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else if (lowest_case3 == nbr_vert && equipe == Equipe_vert) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else {
				joueur.getPlayer().sendMessage(Constante.Constantes.PluginName + "Trop de monde chez les "
						+ equipe.getCouleur() + " essayez une autre équipe ou plus tard.");
			}

			break;

		case 4:
			int tab_case4[] = { nbr_rouge, nbr_bleu, nbr_vert, nbr_jaune };
			int lowest_case4 = getSmallest(tab_case4, 3);

			if (lowest_case4 == nbr_rouge && equipe == Equipe_rouge) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else if (lowest_case4 == nbr_bleu && equipe == Equipe_bleu) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else if (lowest_case4 == nbr_vert && equipe == Equipe_vert) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else if (lowest_case4 == nbr_jaune && equipe == Equipe_jaune) {
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				joueur.getPlayer().sendMessage(
						Constante.Constantes.PluginName + "Vous avez rejoint l'équipe " + equipe.getCouleur() + ".");
			} else {
				joueur.getPlayer().sendMessage(Constante.Constantes.PluginName + "Trop de monde chez les "
						+ equipe.getCouleur() + " essayez une autre équipe ou plus tard.");
			}

			break;
		default:
			System.out.println("Choix incorrect");
			break;
		}

	}

	@SuppressWarnings("deprecation")
	public void ajoutjoueurscoreboard(Joueur joueur, Equipe equipe) {
		if (equipe == this.Equipe_bleu) {
			this.BlueTeamSC.addPlayer(joueur.getPlayer());
		} else if (equipe == this.Equipe_rouge) {
			this.RedTeamSC.addPlayer(joueur.getPlayer());
		} else if (equipe == this.Equipe_vert) {
			this.GreenTeamSC.addPlayer(joueur.getPlayer());
		} else if (equipe == this.Equipe_jaune) {
			this.YellowTeamSC.addPlayer(joueur.getPlayer());
		}
	}
	
	public void DeleteAnimals(Joueur joueur) {
		if (joueur.getKit() == list_kits.get(IndexKit.DogMaster) || joueur.getKit() == list_kits.get(IndexKit.Pirate)) {
			for (Entity entity : joueur.getPlayer().getWorld().getEntities()) {

				if (entity instanceof Wolf) {
					Wolf wolf = (Wolf) entity;
					if (wolf.getOwner() != null) {
						if (wolf.getOwner().getName() == joueur.getPlayer().getName()) {
							wolf.remove();
						}
					}
					

				}
				if (entity instanceof Parrot) {
					Parrot parrot = (Parrot) entity;
					if (parrot.getOwner() != null) {
						if (parrot.getOwner().getName() == joueur.getPlayer().getName()) {
							parrot.remove();
						}
					}
					

				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void deletejoueurscoreboard(Joueur joueur, Equipe equipe) {
		if (equipe == this.Equipe_bleu) {
			this.BlueTeamSC.removePlayer(joueur.getPlayer());
		} else if (equipe == this.Equipe_rouge) {
			this.RedTeamSC.removePlayer(joueur.getPlayer());
		} else if (equipe == this.Equipe_vert) {
			this.GreenTeamSC.removePlayer(joueur.getPlayer());
		} else if (equipe == this.Equipe_jaune) {
			this.YellowTeamSC.removePlayer(joueur.getPlayer());
		}
	}

	public boolean isState(EtatPartie etatPartie) {
		return (this.Etat == etatPartie);
	}

	public void setState(EtatPartie etatPartie) {
		this.Etat = etatPartie;
	}

	public void PutLocationInTnt(int NBEQUIPE) {
		this.tnt_rouge.setLocation(this.map_en_cours.getLocationTntArray(0));
		this.tnt_bleu.setLocation(this.map_en_cours.getLocationTntArray(1));
		switch (NBEQUIPE) {
		case 2:
			return;

		case 3:
			this.tnt_vert.setLocation(this.map_en_cours.getLocationTntArray(2));

		case 4:
			this.tnt_jaune.setLocation(this.map_en_cours.getLocationTntArray(3));
		}

		System.out.println("erreur alloue location tnt");
	}
}
