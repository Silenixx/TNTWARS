package fr.silenix.tntwars.entity;

import java.util.ArrayList;

import org.bukkit.Location;

import Enum.EtatTNT;

public class Map {
	
	public int NbEquipe;
	public String Nom;
	public Location LocationSalleMort;
	public ArrayList<Location> LocationSpawnEquipeArray;
	public ArrayList<Location> LocationTntArray;
	public Location LocationVisite;
	public Location LocationMapBorne1;
	public Location LocationMapBorne2;
	
	
	
	public Map(int NbEquipe, String Nom, Location LocationSalleMort, ArrayList<Location> LocationSpawnEquipeArray, ArrayList<Location> LocationTntArray, Location LocationVisite, Location LocationMapBorne1,Location LocationMapBorne2) {
		NbEquipe = this.NbEquipe;
		Nom = this.Nom;
		LocationSalleMort = this.LocationSalleMort;
		LocationSpawnEquipeArray = this.LocationSpawnEquipeArray;
		LocationTntArray = this.LocationTntArray;
		LocationVisite = this.LocationVisite;
		LocationMapBorne1 = this.LocationMapBorne1;
		LocationMapBorne2 = this.LocationMapBorne2;
	}
	
	
	
	
	
	public int getNbEquipe() {
		return NbEquipe;
	}
	public void setNbEquipe(int nbEquipe) {
		NbEquipe = nbEquipe;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public Location getLocationSalleMort() {
		return LocationSalleMort;
	}
	public void setLocationSalleMort(Location locationSalleMort) {
		LocationSalleMort = locationSalleMort;
	}
	public Location getLocationSpawnEquipeArray(int equipe) {
		return LocationSpawnEquipeArray.get(equipe);
	}
	public void setLocationSpawnEquipeArray(ArrayList<Location> locationSpawnEquipeArray) {
		LocationSpawnEquipeArray = locationSpawnEquipeArray;
	}
	public Location getLocationTntArray(int tnt) {
		return LocationTntArray.get(tnt);
	}
	public void setTntArray(ArrayList<Location> LocationtntArray) {
		LocationTntArray = LocationtntArray;
	}
	public Location getLocationVisite() {
		return LocationVisite;
	}
	public void setLocationVisite(Location locationVisite) {
		LocationVisite = locationVisite;
	}
	public Location getLocationMapBorne1() {
		return LocationMapBorne1;
	}
	public void setLocationMapBorne1(Location locationMapBorne1) {
		LocationMapBorne1 = locationMapBorne1;
	}
	public Location getLocationMapBorne2() {
		return LocationMapBorne2;
	}
	public void setLocationMapBorne2(Location locationMapBorne2) {
		LocationMapBorne2 = locationMapBorne2;
	}

	
	
}
