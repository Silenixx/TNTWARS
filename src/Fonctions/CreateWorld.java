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
		main.list_maps.add(
				new Map(
						2, 
						"LushCave", 
						new Location(main.world, -253, 44, -343),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -282, 22, -319),new Location(main.world, -274, 23, -227))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -320, 25, -315), new Location(main.world, -266, 23, -200))),
						new Location(main.world, -300, 20, -263),
						new Location(main.world, -356, 8, -346),
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
						new Location(main.world, -3, 161, 326),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 98, 45, 341),new Location(main.world, -100, 45, 324))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 38, 40, 342),new Location(main.world, -41, 40, 323))),
						new Location(main.world, 98, 45, 341), 
						new Location(main.world, -206, 4, 231),
						new Location(main.world, 203, 170, 434)));
		main.list_maps.add(
				new Map(
						2, 
						"Zen", 
						new Location(main.world, -601, 177, 296),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -513, 107, 300),new Location(main.world, -678, 107, 284))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -582, 111, 321),new Location(main.world, -609, 111, 263))),
						new Location(main.world, -580, 101, 279), 
						new Location(main.world, -749, 80, 236),
						new Location(main.world, -441, 206, 349)));
		main.list_maps.add(
				new Map(
						2, 
						"Tower", 
						new Location(main.world, -494, 226, 3),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -480, 71, 25),new Location(main.world, -509, 71, -15))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -494, 99, 62),new Location(main.world, -494, 99 , -56))),
						new Location(main.world, -494, 67, 4), 
						new Location(main.world, -577, -11, -129),
						new Location(main.world, -419, 196, 120)));
		main.list_maps.add(
				new Map(
						2, 
						"Lego", 
						new Location(main.world, -26, 225, -626),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 12, 72, -673),new Location(main.world, -72, 72, -584))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 13, 90, -673),new Location(main.world, -73, 90 , -585))),
						new Location(main.world, -33, 71, -635), 
						new Location(main.world, -81, 70, -680),
						new Location(main.world, 20, 141, -578)));
		main.list_maps.add(
				new Map(
						2, 
						"NewSchool", 
						new Location(main.world, -276, 134, -620),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -320, 66, -576),new Location(main.world, -232, 66, -664))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -300, 63, -596),new Location(main.world, -252, 63 , -644))),
						new Location(main.world, -252, 63, -596), 
						new Location(main.world, -324, 38, -670),
						new Location(main.world, -225, 104, -572)));
		main.list_maps.add(
				new Map(
						2, 
						"Pirate", 
						new Location(main.world, 33, 176, -961),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 56, 70, -906),new Location(main.world, 10, 70, -1016))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 31, 61, -925),new Location(main.world, 35, 61 , -997))),
						new Location(main.world, 33, 64, -961), 
						new Location(main.world, -26, 33, -1050),
						new Location(main.world, 91, 121, -873)));
		main.list_maps.add(
				new Map(
						2, 
						"Ruines", 
						new Location(main.world, 145, 200, -1409),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 145, 81, -1311),new Location(main.world, 145, 81, -1507))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, 145, 74, -1384),new Location(main.world, 145, 74 , -1434))),
						new Location(main.world, 145, 86, -1474), 
						new Location(main.world, 6, 32, -1561),
						new Location(main.world, 280, 153, -1255 )));
		main.list_maps.add(
				new Map(
						2, 
						"Texas", 
						new Location(main.world, -518, 255, -464),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -479, 106, -420),new Location(main.world, -478, 106, -511))),
						new ArrayList<Location>(Arrays.asList(new Location(main.world, -562, 106, -420),new Location(main.world, -560, 106 , -511))),
						new Location(main.world, -529, 106, -422), 
						new Location(main.world, -576, 82, -517),
						new Location(main.world, -475, 172, -416)));
		
		
		
		
		
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
