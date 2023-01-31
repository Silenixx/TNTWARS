package Fonctions;

import fr.silenix.tntwars.GMain;
import fr.silenix.tntwars.entity.Map;
import java.util.ArrayList;
import java.util.Arrays;
import org.bukkit.Location;

public class CreateWorld {
	private GMain main;

	public CreateWorld(GMain main) {
		this.main = main;
	}

	public void Creationworld() {
		main.list_maps.add(new Map(2, "Sky", new Location(main.world, 431, 132, 7),
				new ArrayList<Location>(
						Arrays.asList(new Location(main.world, 501, 13, 24), new Location(main.world, 365, 13, 4))),
				new ArrayList<Location>(
						Arrays.asList(new Location(main.world, 523, 13, 18), new Location(main.world, 341, 13, 10))),
				new Location(main.world, 501, 13, 24), new Location(main.world, 221, -66, -114),
				new Location(main.world, 644, 103, 141)));
		main.list_maps.add(new Map(2, "Chateau", new Location(main.world, 30, 167, -315),
				new ArrayList<Location>(
						Arrays.asList(new Location(main.world, 30, 11, -242), new Location(main.world, 30, 11, -386))),
				new ArrayList<Location>(
						Arrays.asList(new Location(main.world, 30, 9, -258), new Location(main.world, 30, 9, -372))),
				new Location(main.world, 31, 13, -320), new Location(main.world, -55, -21, -442),
				new Location(main.world, 103, 125, -205)));
		main.list_maps.add(new Map(2, "LushCave", new Location(main.world, -253, 44, -343),
				new ArrayList<Location>(Arrays.asList(new Location(main.world, -282, 22, -319),
						new Location(main.world, -274, 23, -227))),
				new ArrayList<Location>(Arrays.asList(new Location(main.world, -320, 25, -315),
						new Location(main.world, -266, 23, -200))),
				new Location(main.world, -300, 20, -263), new Location(main.world, -356, 8, -346),
				new Location(main.world, -184, 102, -185)));
		main.list_maps.add(
				new Map(
						2, 
						"Japon", 
						new Location(main.world, 443, 216, -558),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 404, 65, -602),new Location(main.world, 410, 64, -514))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 434, 76, -642),new Location(main.world, 428, 71, -487))),
						new Location(main.world, 439, 60, -558), 
						new Location(main.world, 357, 0, -676),
						new Location(main.world, 556, 189, -421)));
		main.list_maps.add(
				new Map(
						2, 
						"Flower", 
						new Location(main.world, -2, 160, -326),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 98, 45, 341),new Location(main.world, -100, 45, 324))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 38, 40, 342),new Location(main.world, -41, 40, 323))),
						new Location(main.world, 98, 45, 341), 
						new Location(main.world, -206, 4, 231),
						new Location(main.world, 203, 170, 434)));
		main.list_maps.add(
				new Map(
						2, 
						"Zen", 
						new Location(main.world, -601, 176, 296),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -513, 107, 300),new Location(main.world, -678, 107, 284))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -582, 111, 321),new Location(main.world, -609, 111, 263))),
						new Location(main.world, -580, 101, 279), 
						new Location(main.world, -749, 80, 236),
						new Location(main.world, -441, 206, 349)));
		main.list_maps.add(
				new Map(
						2, 
						"Tower", 
						new Location(main.world, -494, 225, 3),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -480, 71, 25),new Location(main.world, -509, 71, -15))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -494, 99, 62),new Location(main.world, -494, 99 , -56))),
						new Location(main.world, -494, 67, 4), 
						new Location(main.world, -577, -22, -120),
						new Location(main.world, -419, 196, -129)));
		
		
		
		
		
		/*this.NbEquipe = NbEquipe;
		this.Nom = Nom;
		this.LocationSalleMort = LocationSalleMort;
		this.LocationSpawnEquipeArray = LocationSpawnEquipeArray;
		this.LocationTntArray = LocationTntArray;
		this.LocationVisite = LocationVisite;
		this.LocationMapBorne1 = LocationMapBorne1;
		this.LocationMapBorne2 = LocationMapBorne2;*/
		
		
		
		
	}
}
