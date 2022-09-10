package fr.silenix.tntwars;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import Enum.EtatPartie;
import Enum.EtatTNT;

import fr.silenix.tntwars.entity.Equipe;
import fr.silenix.tntwars.entity.Joueur;
import fr.silenix.tntwars.entity.Kit;
import fr.silenix.tntwars.entity.Map;
import fr.silenix.tntwars.entity.Tnt;
import fr.silenix.tntwars.listener.DamageListeners;
import fr.silenix.tntwars.listener.PlayerListeners;




public class main extends JavaPlugin{
	
	
	public Location spawn_general = new Location(Bukkit.getWorld("world"),6,1,1);
	
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
	
	
	
	
	
	
	public Map map_en_cours;
	
	
	
	
	
	
	
	public List<Joueur> listeJoueurs = new ArrayList<>();
	
	
	public List<Map> list_maps = new ArrayList<>();
	
	
	
	
	
	
	
	
	
	
	private EtatPartie EtatPartie;

	public boolean isState (EtatPartie EtatPartie) {
		return this.EtatPartie == EtatPartie;
	}
	
	public void setState(EtatPartie EtatPartie) {
		this.EtatPartie = EtatPartie;
	}
	
	
	
	
	public List<Joueur> getJoueur(){
		return listeJoueurs;
		
	}
	
	
	
	
	
	public void onEnable() {
	PluginManager pm = getServer().getPluginManager();
	
	
	

	
	
	pm.registerEvents(new PlayerListeners(this) , this);
	pm.registerEvents(new DamageListeners(), this);
	
	
	
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
	
	
	public void efface_laine() {
		
		
		for (int x = map_en_cours.getLocationMapBorne1().getBlockX();x!=map_en_cours.getLocationMapBorne2().getBlockX(); x++) {
			for (int y=map_en_cours.getLocationMapBorne1().getBlockY();y!=map_en_cours.getLocationMapBorne2().getBlockY(); y++) {
				for (int z=map_en_cours.getLocationMapBorne1().getBlockZ();z!=map_en_cours.getLocationMapBorne2().getBlockZ(); z++) {
					/*if(!(world.getBlockAt(x, y, z).getType() == Material.BLUE_WOOL) && !(world.getBlockAt(x, y, z).getType() == Material.RED_WOOL)) {
						
					}*/
					if (Bukkit.getWorld("world").getBlockAt(x, y, z).getType() == Material.BLUE_WOOL || Bukkit.getWorld("world").getBlockAt(x, y, z).getType() == Material.RED_WOOL) {
							
						Bukkit.getWorld("world").getBlockAt(x, y, z).setType(Material.AIR);
					}
			                
				}
			}
		}
		
		
	}
	
	
	public int getSize(Equipe Equipe) {
		int nombre_joueur = 0;
	    for(int i=0; i < listeJoueurs.size(); i++) {
			Joueur joueur = listeJoueurs.get(i);
			if (joueur.getEquipe() == Equipe ) {
				nombre_joueur = nombre_joueur+1;
			} 
				
	    }
	    return nombre_joueur; 
	}
	
	public void AutoAddTeam(int NbEquipe) {
		
		
		for(int i=0; i < listeJoueurs.size(); i++) {
			Joueur joueur = getJoueur().get(i);
			
			if(joueur.getEquipe()!= Sans_Equipe) {
					return;
			}
			switch(NbEquipe) {
				case 1:
				
				
				if(getSize(Equipe_bleu) < getSize(Equipe_rouge)) {
		
					joueur.setEquipe(Equipe_bleu);

					return;
				}
				
				
				if(getSize(Equipe_bleu) > getSize(Equipe_rouge)) {
		
					joueur.setEquipe(Equipe_rouge);
					return;
				}
				
				if(getSize(Equipe_bleu) == getSize(Equipe_rouge)) {
		
					joueur.setEquipe(Equipe_bleu);
					return;
				}
				
				
			}
			
		}
		


	}

	public void SpawnTeleportation() {
		// TODO Auto-generated method stub
		
	}
	

	
}