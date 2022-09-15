package Fonctions;




import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import fr.silenix.tntwars.entity.Kit;

public class CreateKit {
	




	public static ArrayList<Kit> CreationKit() {
		
		ArrayList<Kit> list_kits = new ArrayList<Kit>();
		int Vie_Global_Joueur = 40;
		Kit Sans_Kit = new Kit("Sans Kit",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Sans_Kit);
		
		
		
		
		
		ItemStack customdiamondsword_guerrier = new ItemStack(Material.DIAMOND_SWORD,1);
		ItemMeta customDS_guerrier = customdiamondsword_guerrier.getItemMeta();
		//customB.setDisplayName("Rejoindre l'équipe bleu");
		customDS_guerrier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		//customWTB.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		//customB.setLore(Arrays.asList("premiere ligne","deuxieme","troisieme"));
		customdiamondsword_guerrier.setItemMeta(customDS_guerrier);
		Kit Guerrier = new Kit(
						"Guerrier",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_guerrier,
						20,
						null,
						null,
						true);
		list_kits.add(Guerrier);
		
		
		
		
		ItemStack customdiamondsword_ender = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_ender = customdiamondsword_ender.getItemMeta();
		customDS_ender.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_ender.setItemMeta(customDS_ender);
		
		Kit Endermen = new Kit(
						"Endermen",
						new ItemStack(Material.LEATHER_HELMET),
						new ItemStack(Material.LEATHER_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_ender,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.ENDER_PEARL,3),new ItemStack(Material.CHORUS_FRUIT,10))),
						null,
						true);
		list_kits.add(Endermen);
		
		
		
		
		
		
		ItemStack customdiamondsword_kami = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_kami = customdiamondsword_kami.getItemMeta();
		customDS_kami.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_kami.setItemMeta(customDS_kami);
		
		ItemStack customboot_kami = new ItemStack(Material.IRON_BOOTS,1);
		ItemMeta customb_kami = customboot_kami.getItemMeta();
		customb_kami.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
		customboot_kami.setItemMeta(customb_kami);
		
		ItemStack customchest_kami = new ItemStack(Material.IRON_CHESTPLATE,1);
		ItemMeta customc_kami = customchest_kami.getItemMeta();
		customc_kami.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
		customchest_kami.setItemMeta(customc_kami);
		
		ItemStack customhelmet_kami = new ItemStack(Material.IRON_HELMET,1);
		ItemMeta customh_kami = customhelmet_kami.getItemMeta();
		customh_kami.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
		customhelmet_kami.setItemMeta(customh_kami);
		
		ItemStack customlegging_kami = new ItemStack(Material.IRON_LEGGINGS,1);
		ItemMeta customl_kami = customlegging_kami.getItemMeta();
		customl_kami.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
		customlegging_kami.setItemMeta(customl_kami);
		
		Kit Kamikaze=new Kit(
						"Kamikaze",
						customhelmet_kami,
						customchest_kami,
						customlegging_kami,
						customboot_kami,
						customdiamondsword_kami,
						Vie_Global_Joueur,
						null,
						null,
						true);
		list_kits.add(Kamikaze);
		
		
		ItemStack customdiamondsword_oneshot = new ItemStack(Material.NETHERITE_SWORD,1);
		ItemMeta customDS_oneshot = customdiamondsword_oneshot.getItemMeta();
		customDS_oneshot.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_oneshot.setItemMeta(customDS_oneshot);
		
		Kit OneShot=new Kit(
					"OneShot",
					new ItemStack(Material.TURTLE_HELMET),
					null,
					null,
					null,
					customdiamondsword_oneshot,
					1,
					null,
					null,
					true);
		list_kits.add(OneShot);
		
		
		
		
		ItemStack customdiamondsword_elytra = new ItemStack(Material.STONE_SWORD,1);
		ItemMeta customDS_elytra = customdiamondsword_elytra.getItemMeta();
		customDS_elytra.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_elytra.setItemMeta(customDS_elytra);
		
		Kit Elytra=new Kit(
					"Elytra",
					new ItemStack(Material.CHAINMAIL_HELMET),
					new ItemStack(Material.ELYTRA),
					new ItemStack(Material.CHAINMAIL_LEGGINGS),
					new ItemStack(Material.IRON_BOOTS),
					customdiamondsword_elytra,
					Vie_Global_Joueur,
					new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.FIREWORK_ROCKET,1))),
					null,
					true);
		list_kits.add(Elytra);
		
		
		
		
		ItemStack customdiamondsword_Ninja = new ItemStack(Material.NETHERITE_SWORD,1);
		ItemMeta customDS_Ninja = customdiamondsword_Ninja.getItemMeta();
		customDS_Ninja.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
		customdiamondsword_Ninja.setItemMeta(customDS_Ninja);
		
		ItemStack is_Ninja = new ItemStack(Material.SPLASH_POTION, 5);
		ItemMeta im_Ninja = is_Ninja.getItemMeta();
		//if(!(im_Ninja instanceof PotionMeta)){ return; } // debug error here?
		PotionMeta pm_Ninja = (PotionMeta) im_Ninja;
		pm_Ninja.setDisplayName("Jump");
		pm_Ninja.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 20*60, 4), true);
		is_Ninja.setItemMeta(pm_Ninja);
		
		ItemStack is2_Ninja = new ItemStack(Material.SPLASH_POTION, 5);
		ItemMeta im2_Ninja = is2_Ninja.getItemMeta();
		//if(!(im2_Ninja instanceof PotionMeta)){ return; } // debug error here?
		PotionMeta pm2 = (PotionMeta) im2_Ninja;
		pm2.setDisplayName("Speed");
		pm2.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 20*60, 4), true);
		is2_Ninja.setItemMeta(pm2);
		
		Kit Ninja=new Kit(
					"Ninja",
					null,
					null,
					null,
					null,
					customdiamondsword_Ninja,
					Vie_Global_Joueur,
					new ArrayList<ItemStack>(Arrays.asList(is_Ninja,is2_Ninja,new ItemStack(Material.BLACK_BANNER,3),new ItemStack(Material.GOLDEN_APPLE,5))),
					null,
					true);
		list_kits.add(Ninja);
		
		
		
		
		
		ItemStack customdiamondsword_Savior = new ItemStack(Material.STONE_SWORD,1);
		ItemMeta customDS_Savior = customdiamondsword_Savior.getItemMeta();
		customDS_Savior.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_Savior.setItemMeta(customDS_Savior);
		
		Kit Savior=new Kit(
					"Savior",
					new ItemStack(Material.IRON_HELMET),
					new ItemStack(Material.IRON_CHESTPLATE),
					new ItemStack(Material.IRON_LEGGINGS),
					new ItemStack(Material.IRON_BOOTS),
					customdiamondsword_Savior,
					Vie_Global_Joueur,
					new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.AMETHYST_SHARD,3),new ItemStack(Material.AMETHYST_CLUSTER,3))),
					null,
					true);
		list_kits.add(Savior);
		
		
		
		ItemStack customcarrot = new ItemStack(Material.CARROT_ON_A_STICK,1);
		ItemMeta customCARROTE = customcarrot.getItemMeta();
		customCARROTE.addEnchant(Enchantment.KNOCKBACK, 5, true);
		customCARROTE.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		customcarrot.setItemMeta(customCARROTE);
		
		Kit PigRider=new Kit(
						"PigRider",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customcarrot,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(customcarrot,customcarrot,customcarrot,customcarrot,customcarrot,new ItemStack(Material.SADDLE,6),new ItemStack(Material.PIG_SPAWN_EGG,6))),
						null,
						true);
		list_kits.add(PigRider);
		
		
		
		ItemStack customdiamondsword_chevalier = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_chevalier = customdiamondsword_chevalier.getItemMeta();
		customDS_chevalier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_chevalier.setItemMeta(customDS_chevalier);
		
		Kit Chevalier=new Kit(
						"Chevalier",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_chevalier,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.HORSE_SPAWN_EGG,1),new ItemStack(Material.SADDLE,1),new ItemStack(Material.WHEAT,64),new ItemStack(Material.WHEAT,64))),
						null,
						true);
		list_kits.add(Chevalier);
		
		
		
		
		
		Kit Pirate=new Kit("Pirate",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Pirate);
		Kit DogMaster=new Kit("DogMaster",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(DogMaster);
		Kit Trident=new Kit("Trident",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Trident);
		Kit Squid=new Kit("Squid",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Squid);
		Kit Barbare=new Kit("Barbare",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Barbare);
		Kit SnowMan=new Kit("SnowMan",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(SnowMan);
		Kit Tank=new Kit("Tank",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Tank);
		Kit Archer=new Kit("Archer",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Archer);
		Kit Sorcier=new Kit("Sorcier",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Sorcier);
		Kit Ghost=new Kit("Ghost",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Ghost);
		Kit Healer=new Kit("Healer",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Healer);
		Kit Pyro=new Kit("Pyro",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Pyro);
		Kit Builder=new Kit("Builder",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Builder);
		Kit Alchimiste=new Kit("Alchimiste",null,null,null,null,null,Vie_Global_Joueur,null,null,true);
		list_kits.add(Alchimiste);
		
		return list_kits;
		
		
	}
	
	
}
