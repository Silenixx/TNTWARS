/*     */ package fr.silenix.tntwars.entity;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Kit
/*     */ {
/*     */   private String Nom;
/*     */   private ItemStack Helmet;
/*     */   private ItemStack Chestplate;
/*     */   private ItemStack Legging;
/*     */   private ItemStack Boots;
/*     */   private ItemStack MainWeapon;
/*     */   private int PointVie;
/*     */   private ArrayList<ItemStack> ItemsArray;
/*     */   private PotionEffect Potioneffect;
/*     */   private boolean IsVisible;
/*     */   private ItemStack ItemSelection;
/*     */   private List<String> Description;
/*     */   private String DroitAcces;
/*     */   
/*     */   public Kit(String Nom, ItemStack Helmet, ItemStack Chestplate, ItemStack Legging, ItemStack Boots, ItemStack MainWeapon, int PointVie, ArrayList<ItemStack> ItemsArray, PotionEffect Potioneffect, boolean IsVisible, ItemStack ItemSelection, List<String> description, String DroitAcces) {
/*  29 */     this.Nom = Nom;
/*  30 */     this.Helmet = Helmet;
/*  31 */     this.Chestplate = Chestplate;
/*  32 */     this.Legging = Legging;
/*  33 */     this.Boots = Boots;
/*  34 */     this.MainWeapon = MainWeapon;
/*  35 */     this.PointVie = PointVie;
/*  36 */     this.ItemsArray = ItemsArray;
/*  37 */     this.Potioneffect = Potioneffect;
/*  38 */     this.IsVisible = IsVisible;
/*  39 */     this.ItemSelection = ItemSelection;
/*  40 */     this.Description = description;
/*  41 */     this.DroitAcces = DroitAcces;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDroitAcces() {
/*  48 */     return this.DroitAcces;
/*     */   }
/*     */   public void setDroitAcces(String droitAcces) {
/*  51 */     this.DroitAcces = droitAcces;
/*     */   }
/*     */   public String getNom() {
/*  54 */     return this.Nom;
/*     */   }
/*     */   public void setNom(String nom) {
/*  57 */     this.Nom = nom;
/*     */   }
/*     */   public ItemStack getHelmet() {
/*  60 */     return this.Helmet;
/*     */   }
/*     */   public void setHelmet(ItemStack helmet) {
/*  63 */     this.Helmet = helmet;
/*     */   }
/*     */   public ItemStack getChestplate() {
/*  66 */     return this.Chestplate;
/*     */   }
/*     */   public void setChestplate(ItemStack chestplate) {
/*  69 */     this.Chestplate = chestplate;
/*     */   }
/*     */   public ItemStack getLegging() {
/*  72 */     return this.Legging;
/*     */   }
/*     */   public void setLegging(ItemStack legging) {
/*  75 */     this.Legging = legging;
/*     */   }
/*     */   public ItemStack getMainWeapon() {
/*  78 */     return this.MainWeapon;
/*     */   }
/*     */   public void setMainWeapon(ItemStack mainweapon) {
/*  81 */     this.MainWeapon = mainweapon;
/*     */   }
/*     */   public ItemStack getBoots() {
/*  84 */     return this.Boots;
/*     */   }
/*     */   public void setBoots(ItemStack boots) {
/*  87 */     this.Boots = boots;
/*     */   }
/*     */   public float getPointVie() {
/*  90 */     return this.PointVie;
/*     */   }
/*     */   public void setPointVie(int pointVie) {
/*  93 */     this.PointVie = pointVie;
/*     */   }
/*     */   public ArrayList<ItemStack> getItemsArray() {
/*  96 */     return this.ItemsArray;
/*     */   }
/*     */   public void setItemsArray(ArrayList<ItemStack> itemsArray) {
/*  99 */     this.ItemsArray = itemsArray;
/*     */   }
/*     */   public PotionEffect getPotioneffect() {
/* 102 */     return this.Potioneffect;
/*     */   }
/*     */   public void setPotioneffect(PotionEffect potioneffect) {
/* 105 */     this.Potioneffect = potioneffect;
/*     */   }
/*     */   public boolean IsVisible() {
/* 108 */     return this.IsVisible;
/*     */   }
/*     */   public void setIsVisible(boolean isVisible) {
/* 111 */     this.IsVisible = isVisible;
/*     */   }
/*     */   public ItemStack getItemSelection() {
/* 114 */     return this.ItemSelection;
/*     */   }
/*     */   public void setItemSelection(ItemStack Selection) {
/* 117 */     this.ItemSelection = Selection;
/*     */   }
/*     */   
/*     */   public List<String> getDescription() {
/* 121 */     return this.Description;
/*     */   }
/*     */   public void setDescription(List<String> description) {
/* 124 */     this.Description = description;
/*     */   }
/*     */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\fr\silenix\tntwars\entity\Kit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */