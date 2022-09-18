package fr.silenix.tntwars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import Enum.CouleurEquipe;
import Enum.EtatPartie;
import Enum.EtatTNT;
import Fonctions.CreateKit;
import Fonctions.IndexKit;
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




public class GMain extends JavaPlugin{
	
	
	//public int Timer_Global_TNT = 30;
	public int Avancement_Max_Global_TNT = 50;
	public int Vie_Global_Joueur = 40;
	
	public Team RedTeamSC ;
	public Team BlueTeamSC ;
	public Team GreenTeamSC ;
	public Team YellowTeamSC ;
	
	World world = Bukkit.getWorld("world");
	public Location spawn_general = new Location(world,6,1,1);
	
	public Equipe Equipe_rouge = new Equipe("Rouge",false,new ItemStack(Material.RED_WOOL,64));
	public Equipe Equipe_bleu = new Equipe("Bleu",false,new ItemStack(Material.BLUE_WOOL,64));
	public Equipe Equipe_vert = new Equipe("Vert",false,new ItemStack(Material.GREEN_WOOL,64));
	public Equipe Equipe_jaune = new Equipe("Jaune",false,new ItemStack(Material.YELLOW_WOOL,64));
	public Equipe Sans_Equipe = new Equipe("Sans Equipe",true,null);
	
	public Tnt tnt_rouge = new Tnt(Equipe_rouge, 0, EtatTNT.Eteinte);
	public Tnt tnt_bleu = new Tnt(Equipe_bleu, 0, EtatTNT.Eteinte);
	public Tnt tnt_vert = new Tnt(Equipe_vert, 0, EtatTNT.Eteinte);
	public Tnt tnt_jaune = new Tnt(Equipe_jaune, 0, EtatTNT.Eteinte);
	
	public ArrayList<Kit> list_kits;
	
	public ScoreboardManager manager ;
	public Scoreboard board ;
    
	public Team onlineCounter ;
	public Team boardblue;
	public Team boardred ;
	
	public int timer_blue;
	public int timer_red;
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
	
	private EtatPartie Etat;

	@Override
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	
	setState(EtatPartie.AttenteJoueur);

	list_maps.add( 
			new Map(
			2,
			"Sky",
			new Location(world,431,132,7),
			new ArrayList<Location>(Arrays.asList(new Location(world,501,13,24), new Location(world,365,13,4))),
			new ArrayList<Location>(Arrays.asList(new Location(world,523,13,18), new Location(world,341,8,10))),
			new Location(world,501,13,24),
			new Location(world,221,-66,-114),
			new Location(world,644,103,141)));
	list_maps.add( 		
			new Map(
			2,
			"Chateau",
			new Location(world,30,167,-315),
			new ArrayList<Location>(Arrays.asList(new Location(world,30,11,-242), new Location(world,30,11,-386))),
			new ArrayList<Location>(Arrays.asList(new Location(world,30,9,-257), new Location(world,30,9,-371))),
			new Location(world,31,13,-320),
			new Location(world,-55,-21,-442),
			new Location(world,103,125,-205)));
	list_maps.add( 		
			new Map(
			2,
			"LushCave",
			new Location(world,-253,44,-343),
			new ArrayList<Location>(Arrays.asList(new Location(world,-282,22,-319), new Location(world,-274,23,-227))),
			new ArrayList<Location>(Arrays.asList(new Location(world,-319,25,-314), new Location(world,-265,23,-199))),
			new Location(world,-300,20,-263),
			new Location(world,-356,8,-346),
			new Location(world,-184,102,-185)));
	list_maps.add( 		
			new Map(
			2,
			"Japon",
			new Location(world,443,216,-558),
			new ArrayList<Location>(Arrays.asList(new Location(world,404,65,-602), new Location(world,410,64,-514))),
			new ArrayList<Location>(Arrays.asList(new Location(world,434,76,-641), new Location(world,428,72,-486))),
			new Location(world,439,60,-558),
			new Location(world,357,0,-676),
			new Location(world,556,189,-421)));
			
	
	timer_blue=30;
	timer_red=30;
	
	list_kits = CreateKit.CreationKit();
	SetScoreboard();
	
	TimerScoreboard cycle = new TimerScoreboard(this);
	cycle.runTaskTimer(this, 0, 20);
	
	pm.registerEvents(new PlayerListeners(this) , this);
	pm.registerEvents(new DamageListeners(this), this);
	}
	
	public void efface_laine() {
		for (int x = map_en_cours.getLocationMapBorne1().getBlockX();x!=map_en_cours.getLocationMapBorne2().getBlockX(); x++) {
			for (int y=map_en_cours.getLocationMapBorne1().getBlockY();y!=map_en_cours.getLocationMapBorne2().getBlockY(); y++) {
				for (int z=map_en_cours.getLocationMapBorne1().getBlockZ();z!=map_en_cours.getLocationMapBorne2().getBlockZ(); z++) {
					if (world.getBlockAt(x, y, z).getType() == Material.BLUE_WOOL || world.getBlockAt(x, y, z).getType() == Material.RED_WOOL) {
						world.getBlockAt(x, y, z).setType(Material.AIR);
					}      
				}
			}
		}
	}
	
	
	public int getSize(String couleur) {
		int nombre_joueur = 0;
	    for(int i=0; i < listeJoueurs.size(); i++) {
			Joueur joueur = listeJoueurs.get(i);
			if (joueur.getEquipe().getCouleur() == couleur ) {
				nombre_joueur ++;
			} 
				
	    }
	    return nombre_joueur; 
	}
	
	@SuppressWarnings("deprecation")
	public void SetScoreboard(){
		manager = Bukkit.getScoreboardManager();
		board = manager.getNewScoreboard();
	    
		
		RedTeamSC = board.registerNewTeam("Equipe Rouge");
	    BlueTeamSC = board.registerNewTeam("Equipe Bleu");
	    
	    onlineCounter = board.registerNewTeam("onlineCounter");
	    boardblue = board.registerNewTeam("boardblue");
	    boardred = board.registerNewTeam("boardred");
		
	    Objective objective = board.registerNewObjective("lol", "dummy"); 
		
		RedTeamSC.setPrefix("§4[§cEquipe Rouge§4]§c ");
		BlueTeamSC.setPrefix("§1[§9Equipe Bleu§1]§9 ");

        BlueTeamSC.setDisplayName("Equipe Bleu");
        RedTeamSC.setDisplayName("Equipe Rouge");
        
        BlueTeamSC.setCanSeeFriendlyInvisibles(true);
        BlueTeamSC.setAllowFriendlyFire(false);
        RedTeamSC.setCanSeeFriendlyInvisibles(true);
        RedTeamSC.setAllowFriendlyFire(false);
		
		connecter_score = Bukkit.getOnlinePlayers().size();
		cblue = tnt_bleu.getVie() *2;
		cred = tnt_rouge.getVie() *2;
		taille_blue = getSize("Bleu");
		taille_red = getSize("Rouge");
		timeblue = timer_blue;
		timered = timer_red;

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        
		objective.setDisplayName(ChatColor.GOLD + "§6-------- TNT WARS --------");
		
		Score information = objective.getScore(ChatColor.GOLD + "» Informations de la Partie");
		information.setScore(15);
		
		onlineCounter.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);
		onlineCounter.setPrefix("  §eJoueurs connectés: ");
		
		if (Bukkit.getOnlinePlayers().size() == 0) {
            onlineCounter.setSuffix(ChatColor.AQUA + "0");
        } else {
            onlineCounter.setSuffix("" + ChatColor.DARK_RED + Bukkit.getOnlinePlayers().size()+ "  (" + ChatColor.BLUE+taille_blue+ ChatColor.GRAY+"|"+ChatColor.RED+taille_red+ ChatColor.GRAY+")");
        }
		
		objective.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(14);
		
		boardblue.addEntry(ChatColor.WHITE + "" + ChatColor.WHITE);
		boardblue.setPrefix("  §eTNT bleu: ");
		boardblue.setSuffix(""+ ChatColor.BLUE + cblue + ChatColor.BLUE + "%" );
		objective.getScore(ChatColor.WHITE + "" + ChatColor.WHITE).setScore(13);
		
		boardred.addEntry(ChatColor.WHITE + "" + ChatColor.BLACK);
		boardred.setPrefix("  §eTNT rouge: ");
		boardred.setSuffix(""+ ChatColor.RED + cred + ChatColor.RED + "%" );
		objective.getScore(ChatColor.WHITE + "" + ChatColor.BLACK).setScore(12);
	}
	
	@SuppressWarnings("deprecation")
	public void AutoAddTeam(int NbEquipe) {
		
		ArrayList<Joueur> liste_joueur_filtre = (ArrayList<Joueur>) listeJoueurs.stream(). //get a stream of all animals 
		        filter((s) -> s.getEquipe().getCouleur().equals("Sans Equipe")). //Filter for dogs and find the first one
				collect(Collectors.toList());
		
		for(int i=0; i < liste_joueur_filtre.size(); i++) {
			Joueur joueur = liste_joueur_filtre.get(i);
			
			switch(NbEquipe) {
				case 2:
					if(getSize(CouleurEquipe.Bleu.toString()) < getSize(CouleurEquipe.Rouge.toString())) {
						if(joueur.getEquipe()!=Sans_Equipe) {
							RedTeamSC.removePlayer(joueur.getPlayer());
						}
						joueur.setEquipe(Equipe_bleu);
						BlueTeamSC.addPlayer(joueur.getPlayer());
					}
					else if(getSize(CouleurEquipe.Bleu.toString()) > getSize(CouleurEquipe.Rouge.toString())) {
						if(joueur.getEquipe()!=Sans_Equipe) {
							BlueTeamSC.removePlayer(joueur.getPlayer());
						}
						joueur.setEquipe(Equipe_rouge);
						RedTeamSC.addPlayer(joueur.getPlayer());
					}
					else if(getSize(CouleurEquipe.Bleu.toString()) == getSize(CouleurEquipe.Rouge.toString())) {
						if(joueur.getEquipe()!=Sans_Equipe) {
							RedTeamSC.removePlayer(joueur.getPlayer());
						}
						joueur.setEquipe(Equipe_bleu);
						BlueTeamSC.addPlayer(joueur.getPlayer());
					}
					break;
				default:
					break;
			}
		}
	}
	
	public void GamePlay(Joueur joueur) {
		joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
		joueur.getPlayer().getInventory().clear();
		joueur.getPlayer().getInventory().setBoots(joueur.getKit().getBoots());
		joueur.getPlayer().getInventory().setChestplate(joueur.getKit().getChestplate());
		joueur.getPlayer().getInventory().setHelmet(joueur.getKit().getHelmet());
		joueur.getPlayer().getInventory().setLeggings(joueur.getKit().getLegging());
		joueur.getPlayer().getInventory().setItem(0, joueur.getKit().getMainWeapon());
		joueur.getPlayer().getInventory().setItem(1, joueur.getEquipe().getLaine());
		if (joueur.getKit()!=list_kits.get(IndexKit.Builder)) {
			joueur.getPlayer().getInventory().setItem(2, new ItemStack(Material.SHEARS));
		}else {
			joueur.getPlayer().getInventory().addItem(joueur.getEquipe().getLaine());
			joueur.getPlayer().getInventory().addItem(joueur.getEquipe().getLaine());
			joueur.getPlayer().getInventory().addItem(joueur.getEquipe().getLaine());
			ItemStack customcisaille = new ItemStack(Material.SHEARS,1);
			ItemMeta customCCC = customcisaille.getItemMeta();
			customCCC.addEnchant(Enchantment.DIG_SPEED, 10, true);
			customcisaille.setItemMeta(customCCC);
			joueur.getPlayer().getInventory().setItem(2,customcisaille);
		}
			
		if(joueur.getKit().getItemsArray()!=null) {
			for (int i=0;i<joueur.getKit().getItemsArray().size();i++) {
				joueur.getPlayer().getInventory().addItem(joueur.getKit().getItemsArray().get(i));
			}
		}
			
		ItemStack customblazepowder = new ItemStack(Material.BLAZE_POWDER,1);
		ItemMeta customBP = customblazepowder.getItemMeta();
		customBP.setDisplayName("Clique droit pour allumer la TNT adverse");
		customBP.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		customBP.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		customBP.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
		customblazepowder.setItemMeta(customBP);
			
		ItemStack customfeather = new ItemStack(Material.FEATHER,1);
		ItemMeta customFF = customfeather.getItemMeta();
		customFF.setDisplayName("Clique droit pour désamorcer sa TNT");
		customFF.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		customFF.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		customFF.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
		customfeather.setItemMeta(customFF);
		
		joueur.getPlayer().getInventory().setItem(8, customfeather);
		joueur.getPlayer().getInventory().setItem(7, customblazepowder);
			
		sethealth(joueur);
			
		if(joueur.getKit().IsVisible()==false) {
			joueur.getPlayer().setInvisible(true);
		}else {
			joueur.getPlayer().setInvisible(false);
		}
			
		TimerImmortality start = new TimerImmortality( joueur.getPlayer());
		start.runTaskTimer(this, 0, 20);
	}
	

	public void SpawnTeleportation(Joueur joueur) {
		if(joueur.getEquipe()==Equipe_rouge) {
			joueur.getPlayer().teleport(map_en_cours.getLocationSpawnEquipeArray(0));
		}
		if(joueur.getEquipe()==Equipe_bleu) {
			joueur.getPlayer().teleport(map_en_cours.getLocationSpawnEquipeArray(1));
		}
		if(joueur.getEquipe()==Equipe_vert) {
			joueur.getPlayer().teleport(map_en_cours.getLocationSpawnEquipeArray(2));
		}
		if(joueur.getEquipe()==Equipe_jaune) {
			joueur.getPlayer().teleport(map_en_cours.getLocationSpawnEquipeArray(3));
		}
	}

	public void CheckWin() {
		int nombre_de_tnt_explose=0;

		if(tnt_rouge.getEtat()== EtatTNT.Explose) {
			nombre_de_tnt_explose++;
			}
		if(tnt_bleu.getEtat()== EtatTNT.Explose) {
			nombre_de_tnt_explose++;
			}
		if(tnt_jaune.getEtat()== EtatTNT.Explose) {
			nombre_de_tnt_explose++;
			}
		if(tnt_vert.getEtat()== EtatTNT.Explose) {
			nombre_de_tnt_explose++;
			}
		if(nombre_de_tnt_explose == map_en_cours.getNbEquipe()-1) {
			for(int i=0; i < listeJoueurs.size(); i++) {
				Joueur joueur = listeJoueurs.get(i);
				joueur.getPlayer().setGameMode(GameMode.SPECTATOR);
			}
			setState(EtatPartie.FinJeu);
			TimerRedemarrage cycle = new TimerRedemarrage(this);
			cycle.runTaskTimer(this, 0, 20);
		}
	}
	
	public Equipe RenvoieGagnant() {
		Equipe gagnant = null;	
		if(tnt_rouge.getEtat()!= EtatTNT.Explose) {
			gagnant = Equipe_bleu;
		}
		else if(tnt_bleu.getEtat()!= EtatTNT.Explose) {
			gagnant = Equipe_rouge;
		}
		else if(tnt_vert.getEtat()!= EtatTNT.Explose) {
			gagnant = Equipe_vert;
		}
		else if(tnt_jaune.getEtat()!= EtatTNT.Explose ) {
			gagnant = Equipe_jaune;
		}
		return gagnant;	
	}
	


	public void remiseazero() {
		tnt_rouge.setEtat(EtatTNT.Eteinte);
		tnt_bleu.setEtat(EtatTNT.Eteinte);
		tnt_vert.setEtat(EtatTNT.Eteinte);
		tnt_jaune.setEtat(EtatTNT.Eteinte);
		
		timer_blue=30;
		timer_red=30;
		
		tnt_bleu.setVie(0);
		tnt_rouge.setVie(0);
		tnt_jaune.setVie(0);
		tnt_vert.setVie(0);
		
		setState(EtatPartie.AttenteJoueur);
		
		listeJoueurs.clear();
		
		for(int i=0; i<listeConnecte.size();i++) {
	         Joueur joueur_tempo = new Joueur(listeConnecte.get(i).getPlayer(),listeConnecte.get(i).getPlayer().getName(),Sans_Equipe,list_kits.get(0));
	         listeJoueurs.add(joueur_tempo);
	    }
		
		for(int i =0; i<5;i++){
	         Collections.shuffle(listeJoueurs);
	         //System.out.println(arlist);
	        }
		
		for(int i=0; i<listeJoueurs.size();i++) {
			Joueur joueur = listeJoueurs.get(i) ;

			joueur.getPlayer().setInvisible(false);
			joueur.getPlayer().teleport(spawn_general);
			joueur.getPlayer().setInvulnerable(false);
			joueur.getPlayer().setGameMode(GameMode.SURVIVAL);
			joueur.getPlayer().getInventory().clear();
			
			ItemStack customnetherstar = new ItemStack(Material.NETHER_STAR,1);
			ItemMeta customNS = customnetherstar.getItemMeta();
			customNS.setDisplayName("Selectionneur d'équipe");
			customNS.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
			customNS.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			customNS.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
			customnetherstar.setItemMeta(customNS);
			joueur.getPlayer().getInventory().setItem(4,customnetherstar);
			
			ItemStack customcompasse = new ItemStack(Material.COMPASS,1);
			ItemMeta customC2 = customcompasse.getItemMeta();
			customC2.setDisplayName("Choisir le kit");
			customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
			customC2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			customC2.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
			customcompasse.setItemMeta(customC2);
			joueur.getPlayer().getInventory().setItem(8,customcompasse);			
		}
		
		
		if(isState(EtatPartie.AttenteJoueur)  && listeJoueurs.size()  >= 2 && !isState(EtatPartie.Lancement)) {
			Bukkit.broadcastMessage("§6[§eTntWars§6] §eAssez de monde pour relancer une nouvelle partie.");
			setState(EtatPartie.Lancement);
			TaskLancementPartie start = new TaskLancementPartie(this);
			start.runTaskTimer(this, 0, 20);
		}
	}

	public void eliminate(Player player) {
		Joueur joueur = (listeJoueurs.stream()
				  .filter(p -> player.getName().equals(p.getPlayer().getName()))
				  .findAny()
				  .orElse(null));

		player.setInvulnerable(true);
		player.setGameMode(GameMode.CREATIVE);//ne pas changer c'est obligatoire
		player.getInventory().clear();
		player.teleport(map_en_cours.getLocationSalleMort());
		player.sendMessage("vous etes mort");
		player.setInvisible(true);
		
		ItemStack customcompasse = new ItemStack(Material.COMPASS,1);
		ItemMeta customC2 = customcompasse.getItemMeta();
		customC2.setDisplayName("Choisir le kit");
		customC2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 200, true);
		customC2.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		customC2.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
		customcompasse.setItemMeta(customC2);
		joueur.getPlayer().getInventory().setItem(4,customcompasse);
		
		TimerRespawn cycle = new TimerRespawn(this, player);
		cycle.runTaskTimer(this, 0, 20);
	}
		
	
	@SuppressWarnings("deprecation")
	public void sethealth(Joueur joueur) {
		if(isState(EtatPartie.JeuEnCours)) {
			joueur.getPlayer().setMaxHealth(joueur.getKit().getPointVie());
			joueur.getPlayer().setHealth(joueur.getKit().getPointVie());
			joueur.getPlayer().setFoodLevel(20);
		}else {
			joueur.getPlayer().setMaxHealth(20);
			joueur.getPlayer().setHealth(20);
			joueur.getPlayer().setFoodLevel(20);
		}
	}

	public void respawn(Player player) {
			Joueur joueur = (listeJoueurs.stream()
					  .filter(p -> player.getName().equals(p.getPlayer().getName()))
					  .findAny()
					  .orElse(null));
			
			player.setGameMode(GameMode.SURVIVAL);
			player.setInvisible(false);
			SpawnTeleportation(joueur);
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "effect clear "+ joueur.getPlayer().getName());
			GamePlay(joueur);
		}

	public void RejoindEquipe(Joueur joueur, Equipe equipe, int NbEquipe) {
		
		if(joueur.getEquipe()==equipe) {
			joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eVous etes déja "+equipe.getCouleur()+".");
		}
		
		if(joueur.getEquipe()!=equipe) {
			
			if( listeJoueurs.size() /NbEquipe >= getSize(equipe.getCouleur())) {
				
				if(listeJoueurs.size()==2 && NbEquipe==2) {
					if(equipe == Equipe_bleu) {
						if(getSize(CouleurEquipe.Bleu.toString())==1 && getSize(CouleurEquipe.Jaune.toString())==0) {
							joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les "+equipe.getCouleur()+" essayez une autre équipe ou plus tard.");
							return;
						}
					}else {
						if(getSize(CouleurEquipe.Rouge.toString())==1 && getSize(CouleurEquipe.Bleu.toString())==0) {
							joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les "+equipe.getCouleur()+" essaie les rouges ou plus tard.");
							return;
						}
					}
					
				}  
				
				
				deletejoueurscoreboard(joueur, equipe);
				joueur.setEquipe(equipe);
				ajoutjoueurscoreboard(joueur, equipe);
				
				
				joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eVous avez rejoinds l'équipe "+equipe.getCouleur()+".");
			} else {
				joueur.getPlayer().sendMessage("§6[§eTntWars§6] §eTrop de monde chez les "+equipe.getCouleur()+" essayez une autre équipe ou plus tard.");
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void ajoutjoueurscoreboard(Joueur joueur, Equipe equipe) {
		if(equipe == Equipe_bleu) {
			BlueTeamSC.addPlayer(joueur.getPlayer());
		}
		else if(equipe == Equipe_rouge){
			RedTeamSC.addPlayer(joueur.getPlayer());
		}
		else if(equipe == Equipe_vert){
			GreenTeamSC.addPlayer(joueur.getPlayer());
		}
		else if(equipe == Equipe_jaune){
			YellowTeamSC.addPlayer(joueur.getPlayer());
		}
		
	}

	@SuppressWarnings("deprecation")
	public void deletejoueurscoreboard(Joueur joueur, Equipe equipe) {
		if(equipe == Equipe_bleu) {
			BlueTeamSC.removePlayer(joueur.getPlayer());
		}
		else if(equipe == Equipe_rouge){
			RedTeamSC.removePlayer(joueur.getPlayer());
		}
		else if(equipe == Equipe_vert){
			GreenTeamSC.removePlayer(joueur.getPlayer());
		}
		else if(equipe == Equipe_jaune){
			YellowTeamSC.removePlayer(joueur.getPlayer());
		}
		
	}

	public boolean isState (EtatPartie EtatPartie) {
		return this.Etat == EtatPartie;
	}
	
	public void setState(EtatPartie EtatPartie) {
		this.Etat = EtatPartie;
	}
}