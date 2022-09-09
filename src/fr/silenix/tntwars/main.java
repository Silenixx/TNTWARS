package fr.silenix.tntwars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
	
	public Equipe Equipe_rouge = new Equipe("Rouge",false);
	public Equipe Equipe_bleu = new Equipe("Bleu",false);
	public Equipe Equipe_vert = new Equipe("Vert",false);
	public Equipe Equipe_jaune = new Equipe("Jaune",false);
	public Equipe Sans_Equipe = new Equipe("Sans Equipe",true);
	
	public Tnt tnt_rouge = new Tnt(Equipe_rouge, 60, EtatTNT.Allume);
	public Tnt tnt_bleu = new Tnt(Equipe_rouge, 60, EtatTNT.Allume);
	public Tnt tnt_vert = new Tnt(Equipe_rouge, 60, EtatTNT.Allume);
	public Tnt tnt_jaune = new Tnt(Equipe_rouge, 60, EtatTNT.Allume);
	
	public Kit Sans_Kit = new Kit("Sans Kit",null,null,null,null,10,null,null,true);
	
	
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	
	
	

	
	
	pm.registerEvents(new PlayerListeners(this) , this);
	pm.registerEvents(new DamageListeners(), this);
	
	List<Map> list_maps = new ArrayList<>();
	
	list_maps.add(
		new Map(
				2,
				"chateau",
				new Location(Bukkit.getWorld("world"),30,167,-315),
				new ArrayList<Location>(Arrays.asList(new Location(Bukkit.getWorld("world"),30,11,-242), new Location(Bukkit.getWorld("world"),30,11,-386))),
				new ArrayList<Location>(Arrays.asList(new Location(Bukkit.getWorld("world"),30,9,-371), new Location(Bukkit.getWorld("world"),30,9,-257))),
				new Location(Bukkit.getWorld("world"),30,167,-315),
				new Location(Bukkit.getWorld("world"),30,167,-315),
				new Location(Bukkit.getWorld("world"),30,167,-315)
				)
		
		
		
		);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	}
}