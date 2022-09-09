package fr.silenix.tntwars.entity;

import java.util.ArrayList;

import org.bukkit.Location;

import Enum.EtatTNT;

public class Map {
	
	private int NbEquipe;
	private String Nom;
	private Location LocationSalleMort;
	private ArrayList<Location> LocationSpawnEquipeArray;
	private ArrayList<Tnt> TntArray;
	private Location LocationVisite;
	private Location LocationMapBorne1;
	private Location LocationMapBorne2;
	
	
	
	public Map(int NbEquipe, String Nom, Location LocationSalleMort, ArrayList<Location> LocationSpawnEquipeArray, ArrayList<Tnt> TntArray, Location LocationVisite, Location LocationMapBorne1,Location LocationMapBorne2) {
		NbEquipe = this.NbEquipe;
		Nom = this.Nom;
		LocationSalleMort = this.LocationSalleMort;
		LocationSpawnEquipeArray = this.LocationSpawnEquipeArray;
		TntArray = this.TntArray;
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
	public ArrayList<Location> getLocationSpawnEquipeArray() {
		return LocationSpawnEquipeArray;
	}
	public void setLocationSpawnEquipeArray(ArrayList<Location> locationSpawnEquipeArray) {
		LocationSpawnEquipeArray = locationSpawnEquipeArray;
	}
	public ArrayList<Tnt> getTntArray() {
		return TntArray;
	}
	public void setTntArray(ArrayList<Tnt> tntArray) {
		TntArray = tntArray;
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
