package Fonctions;




import java.util.ArrayList;
import java.util.Arrays;
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
						Vie_Global_Joueur,
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
		
		
		
		ItemStack customdiamondsword_pirate = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_pirate = customdiamondsword_pirate.getItemMeta();
		customDS_pirate.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_pirate.setItemMeta(customDS_pirate);
		
		ItemStack customhelmet_pirate = new ItemStack(Material.SKELETON_SKULL,1);
		ItemMeta customHH_pirate = customhelmet_pirate.getItemMeta();
		customHH_pirate.addEnchant(Enchantment.OXYGEN, 3, true);
		customhelmet_pirate.setItemMeta(customHH_pirate);
		
		Kit Pirate=new Kit(
						"Pirate",
						customhelmet_pirate ,
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_pirate,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.PARROT_SPAWN_EGG,3),new ItemStack(Material.WHEAT_SEEDS,64),new ItemStack(Material.SPYGLASS),new ItemStack(Material.GOLDEN_APPLE,2))),
						null,
						true);
		list_kits.add(Pirate);
		
		
		
		ItemStack customdiamondsword_dog = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_dog = customdiamondsword_dog.getItemMeta();
		customDS_dog.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_dog.setItemMeta(customDS_dog);
		
		Kit DogMaster=new Kit(
						"DogMaster",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_dog,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.BONE,64),new ItemStack(Material.WOLF_SPAWN_EGG,7))),
						null,
						true);
		list_kits.add(DogMaster);
		
		
		
		
		ItemStack customdiamondsword_Trident = new ItemStack(Material.STONE_SWORD,1);
		ItemMeta customDS_Trident = customdiamondsword_Trident.getItemMeta();
		customDS_Trident.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_Trident.setItemMeta(customDS_Trident);
		
		ItemStack customtrident_Trident = new ItemStack(Material.TRIDENT,1);
		ItemMeta customTTT_Trident = customtrident_Trident.getItemMeta();
		customTTT_Trident.addEnchant(Enchantment.CHANNELING, 1, true);
		customTTT_Trident.addEnchant(Enchantment.LOYALTY, 3, true);
		customtrident_Trident.setItemMeta(customTTT_Trident);
		
		Kit Trident=new Kit(
						"Trident",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_Trident,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(customtrident_Trident)),
						null,
						true);
		list_kits.add(Trident);
		
		
		ItemStack customdiamondsword_squid = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_squid = customdiamondsword_squid.getItemMeta();
		customDS_squid.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_squid.setItemMeta(customDS_squid);
		
		Kit Squid=new Kit(
						"Squid",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_squid,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.INK_SAC))),
						null,
						true);
		list_kits.add(Squid);
		
		
		ItemStack customdiamondsword_barbare = new ItemStack(Material.DIAMOND_AXE,1);
		ItemMeta customDS_barbare = customdiamondsword_barbare.getItemMeta();
		customDS_barbare.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_barbare.setItemMeta(customDS_barbare);
		
		Kit Barbare=new Kit(
						"Barbare",
						new ItemStack(Material.CHAINMAIL_HELMET),
						new ItemStack(Material.CHAINMAIL_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_barbare,
						Vie_Global_Joueur,
						null,
						null,
						true);
		list_kits.add(Barbare);
		
		
		ItemStack customdiamondsword_snow = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_snow = customdiamondsword_snow.getItemMeta();
		customDS_snow.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		customdiamondsword_snow.setItemMeta(customDS_snow);
		
		Kit SnowMan=new Kit(
						"SnowMan",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_snow,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.SNOWBALL,64),new ItemStack(Material.SNOWBALL,64),new ItemStack(Material.SNOWBALL,64),new ItemStack(Material.SNOWBALL,64))),
						null,
						true);
		list_kits.add(SnowMan);
		
		
		ItemStack customironsword_tank = new ItemStack(Material.STONE_SWORD,1);
		ItemMeta customIS_tank = customironsword_tank.getItemMeta();
		customIS_tank.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customironsword_tank.setItemMeta(customIS_tank);
		
		Kit Tank=new Kit(
						"Tank",
						new ItemStack(Material.DIAMOND_HELMET),
						new ItemStack(Material.DIAMOND_CHESTPLATE),
						new ItemStack(Material.DIAMOND_LEGGINGS),
						new ItemStack(Material.DIAMOND_BOOTS),
						customironsword_tank,
						Vie_Global_Joueur,
						null,
						null,
						true);
		list_kits.add(Tank);
		
		
		ItemStack custombow_archer = new ItemStack(Material.BOW,1);
		ItemMeta customB_archer = custombow_archer.getItemMeta();
		customB_archer.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
		customB_archer.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
		custombow_archer.setItemMeta(customB_archer);
		
		ItemStack customstonesword_archer = new ItemStack(Material.STONE_SWORD,1);
		ItemMeta customSW2_archer = customstonesword_archer.getItemMeta();
		customSW2_archer.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customstonesword_archer.setItemMeta(customSW2_archer);
		
		Kit Archer=new Kit(
						"Archer",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customstonesword_archer,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(custombow_archer,new ItemStack(Material.ARROW))),
						null,
						true);
		list_kits.add(Archer);
		
		
		
		ItemStack customdiamondsword_sorcier = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_sorcier = customdiamondsword_sorcier.getItemMeta();
		customDS_sorcier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_sorcier.setItemMeta(customDS_sorcier);
		
		ItemStack customblaze_sorcier = new ItemStack(Material.BLAZE_ROD,1);
		ItemMeta customSSS_sorcier = customblaze_sorcier.getItemMeta();
		customSSS_sorcier.addEnchant(Enchantment.KNOCKBACK, 6, true);
		customblaze_sorcier.setItemMeta(customSSS_sorcier);
		
		Kit Sorcier=new Kit(
						"Sorcier",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_sorcier,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(customblaze_sorcier)),
						null,
						true);
		list_kits.add(Sorcier);
		
		
		ItemStack customwoodsword_ghost = new ItemStack(Material.WOODEN_SWORD,1);
		ItemMeta customWS_ghost = customwoodsword_ghost.getItemMeta();
		customWS_ghost.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		customwoodsword_ghost.setItemMeta(customWS_ghost);
		
		Kit Ghost=new Kit(
						"Ghost",
						null,
						null,
						null,
						null,
						customwoodsword_ghost,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.COOKED_BEEF,64),new ItemStack(Material.COOKED_BEEF,64))),
						null,
						false);
		list_kits.add(Ghost);
		
		
		ItemStack customwoodsword_healer = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customWS_healer = customwoodsword_healer.getItemMeta();
		customWS_healer.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customwoodsword_healer.setItemMeta(customWS_healer);
		
		Kit Healer=new Kit(
						"Healer",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customwoodsword_healer,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.GLISTERING_MELON_SLICE))),
						null,
						true);
		list_kits.add(Healer);
		
		
		ItemStack customdiamondsword_pyro = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_pyro = customdiamondsword_pyro.getItemMeta();
		customDS_pyro.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customDS_pyro.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
		customdiamondsword_pyro.setItemMeta(customDS_pyro);
		
		Kit Pyro=new Kit(
						"Pyro",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_pyro,
						Vie_Global_Joueur,
						new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.FIRE_CHARGE,16),new ItemStack(Material.FLINT_AND_STEEL))),
						null,
						true);
		list_kits.add(Pyro);
		
		
		ItemStack customdiamondsword_builder = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_builder = customdiamondsword_builder.getItemMeta();
		customDS_builder.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_builder.setItemMeta(customDS_builder);
		
		Kit Builder=new Kit(
						"Builder",
						new ItemStack(Material.IRON_HELMET),
						new ItemStack(Material.IRON_CHESTPLATE),
						new ItemStack(Material.IRON_LEGGINGS),
						new ItemStack(Material.IRON_BOOTS),
						customdiamondsword_builder,
						Vie_Global_Joueur,
						null,
						null,
						true);
		list_kits.add(Builder);
		
		
		ItemStack customdiamondsword_alchi = new ItemStack(Material.IRON_SWORD,1);
		ItemMeta customDS_alchi = customdiamondsword_alchi.getItemMeta();
		customDS_alchi.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
		customdiamondsword_alchi.setItemMeta(customDS_alchi);
		
		ItemStack is = new ItemStack(Material.POTION, 5);
		ItemMeta im = is.getItemMeta();
		//if(!(im instanceof PotionMeta)) 
		PotionMeta pm22 = (PotionMeta) im;
		pm22.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 20*60, 4), true);
		pm22.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 20*60, 2), true);
		pm22.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 20*60, 2), true);
		pm22.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20*60, 2), true);
		is.setItemMeta(pm2);
		
		Kit Alchimiste=new Kit(
							"Alchimiste",
							new ItemStack(Material.IRON_HELMET),
							new ItemStack(Material.IRON_CHESTPLATE),
							new ItemStack(Material.IRON_LEGGINGS),
							new ItemStack(Material.IRON_BOOTS),
							customdiamondsword_alchi,
							Vie_Global_Joueur,
							new ArrayList<ItemStack>(Arrays.asList(is)),
							null,
							true);
		list_kits.add(Alchimiste);
		
		
		
		
		
		return list_kits;
		
		
	}
	
	
}
