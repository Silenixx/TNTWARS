package fr.silenix.tntwars.entity;

import java.util.ArrayList;
import org.bukkit.Location;

public class Map {
	public int NbEquipe;
	public String Nom;
	public Location LocationSalleMort;
	public ArrayList<Location> LocationSpawnEquipeArray;
	public ArrayList<Location> LocationTntArray;
	public Location LocationVisite;
	public Location LocationMapBorne1;
	public Location LocationMapBorne2;

	public Map(int NbEquipe, String Nom, Location LocationSalleMort, ArrayList<Location> LocationSpawnEquipeArray,
			ArrayList<Location> LocationTntArray, Location LocationVisite, Location LocationMapBorne1,
			Location LocationMapBorne2) {
		this.NbEquipe = NbEquipe;
		this.Nom = Nom;
		this.LocationSalleMort = LocationSalleMort;
		this.LocationSpawnEquipeArray = LocationSpawnEquipeArray;
		this.LocationTntArray = LocationTntArray;
		this.LocationVisite = LocationVisite;
		this.LocationMapBorne1 = LocationMapBorne1;
		this.LocationMapBorne2 = LocationMapBorne2;
	}

	public int getNbEquipe() {
		return this.NbEquipe;
	}

	public void setNbEquipe(int nbEquipe) {
		this.NbEquipe = nbEquipe;
	}

	public String getNom() {
		return this.Nom;
	}

	public void setNom(String nom) {
		this.Nom = nom;
	}

	public Location getLocationSalleMort() {
		return this.LocationSalleMort;
	}

	public void setLocationSalleMort(Location locationSalleMort) {
		this.LocationSalleMort = locationSalleMort;
	}

	public Location getLocationSpawnEquipeArray(int equipe) {
		return this.LocationSpawnEquipeArray.get(equipe);
	}

	public void setLocationSpawnEquipeArray(ArrayList<Location> locationSpawnEquipeArray) {
		this.LocationSpawnEquipeArray = locationSpawnEquipeArray;
	}

	public Location getLocationTntArray(int tnt) {
		return this.LocationTntArray.get(tnt);
	}

	public ArrayList<Location> getLocationTntArray2() {
		return this.LocationTntArray;
	}

	public void setTntArray(ArrayList<Location> LocationtntArray) {
		this.LocationTntArray = LocationtntArray;
	}

	public Location getLocationVisite() {
		return this.LocationVisite;
	}

	public void setLocationVisite(Location locationVisite) {
		this.LocationVisite = locationVisite;
	}

	public Location getLocationMapBorne1() {
		return this.LocationMapBorne1;
	}

	public void setLocationMapBorne1(Location locationMapBorne1) {
		this.LocationMapBorne1 = locationMapBorne1;
	}

	public Location getLocationMapBorne2() {
		return this.LocationMapBorne2;
	}

	public void setLocationMapBorne2(Location locationMapBorne2) {
		this.LocationMapBorne2 = locationMapBorne2;
	}
}
