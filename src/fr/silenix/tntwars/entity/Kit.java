package fr.silenix.tntwars.entity;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public class Kit {

	private String Nom;
	private ItemStack Helmet;
	private ItemStack Chestplate;
	private ItemStack Legging;
	private ItemStack Boots;
	private float PointVie;
	private ArrayList<ItemStack> ItemsArray;
	private PotionEffect Potioneffect;
	private boolean IsVisible;
	
	
	
	public Kit(String Nom, ItemStack Helmet, ItemStack Chestplate, ItemStack Legging,ItemStack Boots,float PointVie, ArrayList<ItemStack> ItemsArray, PotionEffect Potioneffect, boolean IsVisible) {
		Nom = this.Nom;
		Helmet = this.Helmet;
		Chestplate = this.Chestplate;
		Legging = this.Legging;
		Boots = this.Boots;
		PointVie = this.PointVie;
		ItemsArray = this.ItemsArray;
		Potioneffect = this.Potioneffect;
		IsVisible = this.IsVisible;
		
	}
	
	
	
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String Nom) {
		Nom = Nom;
	}
	public ItemStack getHelmet() {
		return Helmet;
	}
	public void setHelmet(ItemStack helmet) {
		Helmet = helmet;
	}
	public ItemStack getChestplate() {
		return Chestplate;
	}
	public void setChestplate(ItemStack chestplate) {
		Chestplate = chestplate;
	}
	public ItemStack getLegging() {
		return Legging;
	}
	public void setLegging(ItemStack legging) {
		Legging = legging;
	}
	public ItemStack getBoots() {
		return Boots;
	}
	public void setBoots(ItemStack boots) {
		Boots = boots;
	}
	public float getPointVie() {
		return PointVie;
	}
	public void setPointVie(float pointVie) {
		PointVie = pointVie;
	}
	public ArrayList<ItemStack> getItemsArray() {
		return ItemsArray;
	}
	public void setItemsArray(ArrayList<ItemStack> itemsArray) {
		ItemsArray = itemsArray;
	}
	public PotionEffect getPotioneffect() {
		return Potioneffect;
	}
	public void setPotioneffect(PotionEffect potioneffect) {
		Potioneffect = potioneffect;
	}
	public boolean isIsVisible() {
		return IsVisible;
	}
	public void setIsVisible(boolean isVisible) {
		IsVisible = isVisible;
	}



}
