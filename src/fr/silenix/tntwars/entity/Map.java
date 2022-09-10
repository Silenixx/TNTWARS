package fr.silenix.tntwars.entity;

import java.util.ArrayList;

import org.bukkit.Location;

import Enum.EtatTNT;

public class Map {
	
	private int NbEquipe;
	private String Nom;
	private Location LocationSalleMort;
	private ArrayList<Location> LocationSpawnEquipeArray;
	private ArrayList<Location> LocationTntArray;
	private Location LocationVisite;
	private Location LocationMapBorne1;
	private Location LocationMapBorne2;
	
	
	
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
