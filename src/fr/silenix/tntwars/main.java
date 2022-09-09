package fr.silenix.tntwars;

import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Enum.EtatTNT;
import fr.silenix.tntwars.entity.Equipe;
import fr.silenix.tntwars.entity.Kit;
import fr.silenix.tntwars.entity.Map;
import fr.silenix.tntwars.entity.Tnt;
import fr.silenix.tntwars.listener.DamageListeners;
import fr.silenix.tntwars.listener.PlayerListeners;




public class main extends JavaPlugin{
	

	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvents(new PlayerListeners() , this);
	pm.registerEvents(new DamageListeners(), this);
	
	

	Equipe Equipe_rouge = new Equipe("Rouge",false);
	Equipe Equipe_bleu = new Equipe("Bleu",false);
	Equipe Equipe_vert = new Equipe("Vert",false);
	Equipe Equipe_jaune = new Equipe("Jaune",false);
	Equipe Sans_Equipe = new Equipe("Rouge",true);
	
	Tnt tnt_rouge = new Tnt(Equipe_rouge, 60, EtatTNT.Allume);
	
	
	
	
	
	
	Map chateau = new Map(
			2,
			"chateau",
			new Location(Bukkit.getWorld("world"),30,167,-315),
			<(new Location(Bukkit.getWorld("world"),30,11,-242), new Location(Bukkit.getWorld("world"),30,11,-386))>,
			<(,new Location(Bukkit.getWorld("world"),30,9,-371))>,
			new Location(Bukkit.getWorld("world"),30,167,-315),
			new Location(Bukkit.getWorld("world"),30,167,-315),
			new Location(Bukkit.getWorld("world"),30,167,-315)
			);
	
	
	

	}
}