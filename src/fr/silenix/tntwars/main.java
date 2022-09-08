package fr.silenix.tntwars;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.silenix.tntwars.listener.DamageListeners;
import fr.silenix.tntwars.listener.PlayerListeners;




public class main extends JavaPlugin{
	
	
	
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	pm.registerEvents(new PlayerListeners(this) , this);
	pm.registerEvents(new DamageListeners(this), this);
	
	}
}