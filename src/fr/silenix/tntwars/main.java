package fr.silenix.tntwars;

import org.bukkit.Bukkit;

import org.bukkit.Location;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


import fr.silenix.tntwars.entity.Equipe;
import fr.silenix.tntwars.entity.Kit;
import fr.silenix.tntwars.entity.Map;
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
	
	
	
	
	
	//Map chateau = new Map(2,new Location(Bukkit.getWorld("world"),30,167,-315),);
	
	
	

	}
}