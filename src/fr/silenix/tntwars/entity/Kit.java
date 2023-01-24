 package fr.silenix.tntwars.entity;
 
 import java.util.ArrayList;

 import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

 
 
 
 
 
 public class Kit
 {
   private String Nom;
   private ItemStack Helmet;
   private ItemStack Chestplate;
   private ItemStack Legging;
   private ItemStack Boots;
   private ItemStack MainWeapon;
   private int PointVie;
   private ArrayList<ItemStack> ItemsArray;
   private PotionEffect Potioneffect;
   private boolean IsVisible;
   private ItemStack ItemSelection;
   private List<String> Description;
   private String DroitAcces;
   
   public Kit(String Nom, ItemStack Helmet, ItemStack Chestplate, ItemStack Legging, ItemStack Boots, ItemStack MainWeapon, int PointVie, ArrayList<ItemStack> ItemsArray, PotionEffect Potioneffect, boolean IsVisible, ItemStack ItemSelection, List<String> description, String DroitAcces) {
     this.Nom = Nom;
     this.Helmet = Helmet;
     this.Chestplate = Chestplate;
     this.Legging = Legging;
     this.Boots = Boots;
     this.MainWeapon = MainWeapon;
     this.PointVie = PointVie;
     this.ItemsArray = ItemsArray;
     this.Potioneffect = Potioneffect;
     this.IsVisible = IsVisible;
     this.ItemSelection = ItemSelection;
     this.Description = description;
     this.DroitAcces = DroitAcces;
   }
 
 
 
   
   public String getDroitAcces() {
     return this.DroitAcces;
   }
   public void setDroitAcces(String droitAcces) {
     this.DroitAcces = droitAcces;
   }
   public String getNom() {
     return this.Nom;
   }
   public void setNom(String nom) {
     this.Nom = nom;
   }
   public ItemStack getHelmet() {
     return this.Helmet;
   }
   public void setHelmet(ItemStack helmet) {
     this.Helmet = helmet;
   }
   public ItemStack getChestplate() {
     return this.Chestplate;
   }
   public void setChestplate(ItemStack chestplate) {
     this.Chestplate = chestplate;
   }
   public ItemStack getLegging() {
     return this.Legging;
   }
   public void setLegging(ItemStack legging) {
     this.Legging = legging;
   }
   public ItemStack getMainWeapon() {
     return this.MainWeapon;
   }
   public void setMainWeapon(ItemStack mainweapon) {
     this.MainWeapon = mainweapon;
   }
   public ItemStack getBoots() {
     return this.Boots;
   }
   public void setBoots(ItemStack boots) {
     this.Boots = boots;
   }
   public float getPointVie() {
     return this.PointVie;
   }
   public void setPointVie(int pointVie) {
     this.PointVie = pointVie;
   }
   public ArrayList<ItemStack> getItemsArray() {
     return this.ItemsArray;
   }
   public void setItemsArray(ArrayList<ItemStack> itemsArray) {
     this.ItemsArray = itemsArray;
   }
   public PotionEffect getPotioneffect() {
     return this.Potioneffect;
   }
   public void setPotioneffect(PotionEffect potioneffect) {
     this.Potioneffect = potioneffect;
   }
   public boolean IsVisible() {
     return this.IsVisible;
   }
   public void setIsVisible(boolean isVisible) {
     this.IsVisible = isVisible;
   }
   public ItemStack getItemSelection() {
     return this.ItemSelection;
   }
   public void setItemSelection(ItemStack Selection) {
     this.ItemSelection = Selection;
   }
   
   public List<String> getDescription() {
     return this.Description;
   }
   public void setDescription(List<String> description) {
     this.Description = description;
   }
 }


