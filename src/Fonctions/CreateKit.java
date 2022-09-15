package Fonctions;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Kit;

public class CreateKit {
	
	
	
	



	public static /*ArrayList<Kit>*/ void CreationKit(GMain main) {
		
		//ArrayList<Kit> main.list_kits = new ArrayList<Kit>();
		//int main.Vie_Global_Joueur = 40;
		Kit Sans_Kit = new Kit("Sans Kit",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Sans_Kit);
		Kit Guerrier = new Kit(
						"Guerrier",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						new ItemStack(Material.IRON_SWORD),
						20,
						null,
						null,
						true);
		main.list_kits.add(Guerrier);
		Kit Endermen = new Kit("Endermen",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Endermen);
		Kit Kamikaze=new Kit("Kamikaze",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Kamikaze);
		Kit OneShot=new Kit("OneShot",null,null,null,null,null,1,null,null,true);
		main.list_kits.add(OneShot);
		Kit Elytra=new Kit("Elytra",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Elytra);
		Kit Ninja=new Kit("Ninja",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Ninja);
		Kit Savior=new Kit("Savior",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Savior);
		Kit PigRider=new Kit("PigRider",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(PigRider);
		Kit Chevalier=new Kit("Chevalier",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Chevalier);
		Kit Pirate=new Kit("Pirate",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Pirate);
		Kit DogMaster=new Kit("DogMaster",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(DogMaster);
		Kit Trident=new Kit("Trident",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Trident);
		Kit Squid=new Kit("Squid",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Squid);
		Kit Barbare=new Kit("Barbare",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Barbare);
		Kit SnowMan=new Kit("SnowMan",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(SnowMan);
		Kit Tank=new Kit("Tank",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Tank);
		Kit Archer=new Kit("Archer",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Archer);
		Kit Sorcier=new Kit("Sorcier",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Sorcier);
		Kit Ghost=new Kit("Ghost",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Ghost);
		Kit Healer=new Kit("Healer",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Healer);
		Kit Pyro=new Kit("Pyro",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Pyro);
		Kit Builder=new Kit("Builder",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Builder);
		Kit Alchimiste=new Kit("Alchimiste",null,null,null,null,null,main.Vie_Global_Joueur,null,null,true);
		main.list_kits.add(Alchimiste);
		
		//return main.list_kits;
		
		
	}
	
	
}
