 package Fonctions;
 
 import Constante.Constantes;
 import fr.silenix.tntwars.entity.Kit;
 import java.util.ArrayList;
 import java.util.Arrays;
 import org.bukkit.Material;
 import org.bukkit.enchantments.Enchantment;
 import org.bukkit.inventory.ItemFlag;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 import org.bukkit.inventory.meta.PotionMeta;
 import org.bukkit.potion.PotionEffect;
 import org.bukkit.potion.PotionEffectType;
 

 
 
 public class CreateKit
 {
   public static ArrayList<Kit> CreationKit() {
     ArrayList<Kit> list_kits = new ArrayList<>();


     ItemStack customdiamondsword_guerrier = new ItemStack(Material.DIAMOND_SWORD, 1);
     ItemMeta customDS_guerrier = customdiamondsword_guerrier.getItemMeta();
     customDS_guerrier.setDisplayName("Kit Guerrier");

     customDS_guerrier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);


     customdiamondsword_guerrier.setItemMeta(customDS_guerrier);
 
 

     ItemStack skull_guerrier = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDQyMWE4NGYwZjA5MWU1NzNhYzFhNjNkYWQ3ZTQyOTEyN2EwZTdjNDA0OGM5ZDA2MzQxYjc1Y2U4MGQ0YWU4NCJ9fX0=", 
         Arrays.asList( "test", "test"
            ), "test_autre");



     Kit Guerrier = new Kit(
         "Guerrier", 
         skull_guerrier, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_guerrier, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.DIAMOND_SWORD), 
         Arrays.asList( "§bArmure en fer", "§bEp§e en diamant", "§dCe kit est fait pour les mordues de PVP.", "§dVous ferez partie des combattants majeurs de votre équipe."
            ), "tnt.guerrier");
     list_kits.add(Guerrier);


     ItemStack skull_enderman = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDY4NWUyZTkwNmI0NDY0N2E5Y2RjODA2NmIxMDZiYzUwYTJjOWFiZjk3NGU2OTIzOTkxN2ZkMjFhMTViNDM2OCJ9fX0=", 
         Arrays.asList( "test", "test"
            ), "test_autre");

     ItemStack customdiamondsword_ender = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_ender = customdiamondsword_ender.getItemMeta();
     customDS_ender.setDisplayName("Kit Enderman");
     customDS_ender.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_ender.setItemMeta(customDS_ender);

     Kit Enderman = new Kit(
         "Enderman", 
         skull_enderman, 
         new ItemStack(Material.LEATHER_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_ender, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.ENDER_PEARL, 3), new ItemStack(Material.CHORUS_FRUIT, 10)
             )), null, 
         true, 
         new ItemStack(Material.ENDER_PEARL), 
         Arrays.asList( "§bEp§e en fer", "§btest\",\"§dtest"
            ), "tnt.enderman");
     list_kits.add(Enderman);





     ItemStack skull_creeper = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjZDc3NzQ0NDZiZGRmNzk0MTVhODA5Y2E2MGU0NDU0OTdmODk1NTFjZWIyMTUyMmNkODFkMTY1MTE2Njc4MSJ9fX0=", 
         Arrays.asList( "test", "test"
            ), "test_autre");

     ItemStack customdiamondsword_creeper = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_creeper = customdiamondsword_creeper.getItemMeta();
     customDS_creeper.setDisplayName("Kit Creeper");
     customDS_creeper.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_creeper.setItemMeta(customDS_creeper);

     ItemStack customboot_creeper = new ItemStack(Material.IRON_BOOTS, 1);
     ItemMeta customb_creeper = customboot_creeper.getItemMeta();
     customb_creeper.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
     customboot_creeper.setItemMeta(customb_creeper);

     ItemStack customchest_creeper = new ItemStack(Material.IRON_CHESTPLATE, 1);
     ItemMeta customc_creeper = customchest_creeper.getItemMeta();
     customc_creeper.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
     customchest_creeper.setItemMeta(customc_creeper);

     ItemStack customhelmet_creeper = new ItemStack(Material.IRON_HELMET, 1);
     ItemMeta customh_creeper = customhelmet_creeper.getItemMeta();
     customh_creeper.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
     customhelmet_creeper.setItemMeta(customh_creeper);

     ItemStack customlegging_creeper = new ItemStack(Material.IRON_LEGGINGS, 1);
     ItemMeta customl_creeper = customlegging_creeper.getItemMeta();
     customl_creeper.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
     customlegging_creeper.setItemMeta(customl_creeper);

     Kit Creeper = new Kit(
         "Creeper", 
         skull_creeper, 
         customchest_creeper, 
         customlegging_creeper, 
         customboot_creeper, 
         customdiamondsword_creeper, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.GUNPOWDER), 
         Arrays.asList( "§bArmure en fer protection explosion", "§bEpee en fer", "§dIncarnez un creeper"
            ), "tnt.creeper");
     list_kits.add(Creeper);




     ItemStack skull_oneshot = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjJlMzdjNjM2ZmZjYzA1ZjUxOGFiOTdiZjcxMTFjNmQzY2E5NWM1MzAwYzUyZTU2MGMzZGMzNTYzNzZlZWJkYiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_oneshot = new ItemStack(Material.NETHERITE_SWORD, 1);
     ItemMeta customDS_oneshot = customdiamondsword_oneshot.getItemMeta();
     customDS_oneshot.setDisplayName("Kit OneShot");
     customDS_oneshot.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_oneshot.setItemMeta(customDS_oneshot);

     Kit OneShot = new Kit(
         "OneShot", 
         skull_oneshot, 
         null, 
         null, 
         null, 
         customdiamondsword_oneshot, 
         1, 
         null, 
         null, 
         true, 
         new ItemStack(Material.END_CRYSTAL), 
         Arrays.asList( "§bEpee en netherite\",\"§bPas d'armure", "§dUn coup d'§p§e et il est mort"
           ), "tnt.oneshot");
     list_kits.add(OneShot);




     ItemStack skull_elytra = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWRmZTUxODAxNzYxNjYwZWJmNmRhZTcwZTljYWQ1ODhiMmVmNWU2Y2IyYjMxOTRkMDI4YTQwYWMwZWViY2RmNSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_elytra = new ItemStack(Material.STONE_SWORD, 1);
     ItemMeta customDS_elytra = customdiamondsword_elytra.getItemMeta();
     customDS_elytra.setDisplayName("Kit Elytra");
     customDS_elytra.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_elytra.setItemMeta(customDS_elytra);

     Kit Elytra = new Kit(
         "Elytra", 
         skull_elytra, 
         new ItemStack(Material.ELYTRA), 
         new ItemStack(Material.CHAINMAIL_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_elytra, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.FIREWORK_ROCKET, 1)
             )), null, 
         true, 
         new ItemStack(Material.ELYTRA), 
         Arrays.asList( "§bEpee en pierre\",\"§bUne paire d'élytre et une rocket", "§denvolez vous dans les cieux"
           ), "tnt.elytra");
     list_kits.add(Elytra);






     ItemStack customdiamondsword_Ninja = new ItemStack(Material.NETHERITE_SWORD, 1);
     ItemMeta customDS_Ninja = customdiamondsword_Ninja.getItemMeta();
     customDS_Ninja.setDisplayName("Kit Ninja");
     customDS_Ninja.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
     customdiamondsword_Ninja.setItemMeta(customDS_Ninja);

     ItemStack is_Ninja = new ItemStack(Material.SPLASH_POTION, 5);
     ItemMeta im_Ninja = is_Ninja.getItemMeta();

     PotionMeta pm_Ninja = (PotionMeta)im_Ninja;
     pm_Ninja.setDisplayName("Jump");
     pm_Ninja.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 4), true);
     is_Ninja.setItemMeta((ItemMeta)pm_Ninja);

     ItemStack is2_Ninja = new ItemStack(Material.SPLASH_POTION, 5);
     ItemMeta im2_Ninja = is2_Ninja.getItemMeta();

     PotionMeta pm2 = (PotionMeta)im2_Ninja;
     pm2.setDisplayName("Speed");
     pm2.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 4), true);
     is2_Ninja.setItemMeta((ItemMeta)pm2);

     Kit Ninja = new Kit(
         "Ninja", 
         null, 
         null, 
         null, 
         null, 
         customdiamondsword_Ninja, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(is_Ninja, is2_Ninja, new ItemStack(Material.BLACK_BANNER, 3), new ItemStack(Material.GOLDEN_APPLE, 5)
             )), null, 
         true, 
         new ItemStack(Material.BLACK_BANNER), 
         Arrays.asList( "§btest\",\"btest\",\"dtest"
           ), "tnt.ninja");
     list_kits.add(Ninja);





     ItemStack skull_savior = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmU2MmM4N2Q4MmNjNzNmZDQyMjg4YjI3NGZhODllOGQ2M2EyNWI5NTJiZGZlMGU1ZGRmNGM5OGIxNDM3In19fQ==", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_Savior = new ItemStack(Material.STONE_SWORD, 1);
     ItemMeta customDS_Savior = customdiamondsword_Savior.getItemMeta();
     customDS_Savior.setDisplayName("Kit Savior");
     customDS_Savior.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_Savior.setItemMeta(customDS_Savior);
     
     
     ItemStack customAmethystShard = new ItemStack(Material.AMETHYST_SHARD, 3);
     ItemMeta customBP = customAmethystShard.getItemMeta();
     customBP.setDisplayName("Retour au spawn");
     customAmethystShard.setItemMeta(customBP);
     
     ItemStack customAMETHYST_CLUSTER= new ItemStack(Material.AMETHYST_CLUSTER, 3);
     ItemMeta customAmethyst = customAMETHYST_CLUSTER.getItemMeta();
     customAmethyst.setDisplayName("Camarade au spawn");
     customAMETHYST_CLUSTER.setItemMeta(customAmethyst);

     Kit Savior = new Kit(
         "Savior", 
         skull_savior, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Savior, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(customAmethystShard, customAMETHYST_CLUSTER)
             ), null, 
         true, 
         new ItemStack(Material.AMETHYST_SHARD), 
         Arrays.asList( "§bEpee en pierre", "§bDe quoi retourner au spawn", "§dTéléportation"
           ), "tnt.savior");
     list_kits.add(Savior);





     ItemStack skull_pigrider = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTkyMzdhMDY3MjEyMDEzMmY2MWE2ZGIyZjQ1ZDE3N2Y4YWQ4Y2UxYTlmYWQ5MTMyNzRjNzUyYTUxNGQ4Y2I1NSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customcarrot = new ItemStack(Material.CARROT_ON_A_STICK, 1);
     ItemMeta customCARROTE = customcarrot.getItemMeta();
     customCARROTE.setDisplayName("Kit PigRider");
     customCARROTE.addEnchant(Enchantment.KNOCKBACK, 5, true);
     customCARROTE.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
     customcarrot.setItemMeta(customCARROTE);

     Kit PigRider = new Kit(
         "PigRider", 
         skull_pigrider, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customcarrot, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(customcarrot, customcarrot, customcarrot, customcarrot, customcarrot, new ItemStack(Material.SADDLE, 6), new ItemStack(Material.PIG_SPAWN_EGG, 6)
             )), null, 
         true, 
         new ItemStack(Material.CARROT_ON_A_STICK), 
         Arrays.asList( "§bCanne à pêche carotte\",\"§bUne horde de cochons", "§dDevenez un véritable dresseur"
           ), "tnt.pigrider");
     list_kits.add(PigRider);







     ItemStack skull_chevalier = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGE5NzcxMDliODJmZTE3NTI3YmQ3MTkxYjNiNWVhNTJmZWEzMGJmNTY3ZDEwOTdjYTQ3YTliNmIyY2FhMWRkYSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_chevalier = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_chevalier = customdiamondsword_chevalier.getItemMeta();
     customDS_chevalier.setDisplayName("Kit Chevalier");
     customDS_chevalier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_chevalier.setItemMeta(customDS_chevalier);

     Kit Chevalier = new Kit(
         "Chevalier", 
         skull_chevalier, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_chevalier, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.SADDLE, 1))),
         null, 
         true, 
         new ItemStack(Material.SADDLE), 
         Arrays.asList( "§bUne épée en fer\",\"§bUne armure en fer", "§dUn cheval et vous voilà au moyen-age"
           ), "tnt.chevalier");
     list_kits.add(Chevalier);









     ItemStack skull_pirate = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDVlMzU2YTI3YTczMzFjNGY1Mzg4ZmI5OWY5MzRiOTkwNDc4NzE1MWJjNDk1YjEyMjMyYjM0MGM4OTEzMGRkNiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_pirate = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_pirate = customdiamondsword_pirate.getItemMeta();
     customDS_pirate.setDisplayName("Kit Pirate");
     customDS_pirate.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_pirate.setItemMeta(customDS_pirate);

     ItemStack customhelmet_pirate = new ItemStack(Material.SKELETON_SKULL, 1);
     ItemMeta customHH_pirate = customhelmet_pirate.getItemMeta();
     customHH_pirate.addEnchant(Enchantment.OXYGEN, 3, true);
     customhelmet_pirate.setItemMeta(customHH_pirate);

     Kit Pirate = new Kit(
         "Pirate", 
         skull_pirate, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_pirate, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.PARROT_SPAWN_EGG, 3), new ItemStack(Material.WHEAT_SEEDS, 64), new ItemStack(Material.SPYGLASS), new ItemStack(Material.GOLDEN_APPLE, 2)
             )), null, 
         true, 
         new ItemStack(Material.SPYGLASS), 
         Arrays.asList( "§bUne épée en fer\",\"§bUne armure en fer", "§dL'apnée ca vous connait, ne seriez vous pas Jack Sparrow?"
           ), "tnt.pirate");
     list_kits.add(Pirate);





     ItemStack skull_dogmaster = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzA1MmQ4OTAzZGEyYTNiZGNlNGRiNDYwMDA0OGQ4M2IwNDkxYzFlODU0MGJhZmNhYzVlMzZmNWRlZTY3ZWZmZSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_dog = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_dog = customdiamondsword_dog.getItemMeta();
     customDS_dog.setDisplayName("Kit DogMaster");
     customDS_dog.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_dog.setItemMeta(customDS_dog);

     Kit DogMaster = new Kit(
         "DogMaster", 
         skull_dogmaster, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_dog, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.BONE, 8))),
         null, 
         true, 
         new ItemStack(Material.BONE), 
         Arrays.asList( "§bUne épée en fer\",\"§bUne armure en fer", "§dUne horde de loup, un vrai éleveur"
           ), "tnt.dogmaster");
     list_kits.add(DogMaster);




     ItemStack skull_trident = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRlNTQ0ZjEwNjM1YzJkMzQ4MGNmMDBjNTJiZTFjZWE5NDg0YWQxZTcyODFiNDkzNjU5ZGMzYjlmN2EzOWM2YiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_Trident = new ItemStack(Material.STONE_SWORD, 1);
     ItemMeta customDS_Trident = customdiamondsword_Trident.getItemMeta();
     customDS_Trident.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customDS_Trident.setDisplayName("Kit Trident");
     customdiamondsword_Trident.setItemMeta(customDS_Trident);

     ItemStack customtrident_Trident = new ItemStack(Material.TRIDENT, 1);
     ItemMeta customTTT_Trident = customtrident_Trident.getItemMeta();
     customTTT_Trident.addEnchant(Enchantment.CHANNELING, 1, true);
     customTTT_Trident.addEnchant(Enchantment.LOYALTY, 3, true);
     customtrident_Trident.setItemMeta(customTTT_Trident);

     Kit Trident = new Kit(
         "Trident", 
         skull_trident, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Trident, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(customtrident_Trident
             )), null, 
         true, 
         new ItemStack(Material.TRIDENT), 
         Arrays.asList( "§bUne épée en pierre et un tridant\",\"§bUne armure en fer", "§dQui vois je , Aquaman c'est toi?"
           ), "tnt.trident");
     list_kits.add(Trident);



     ItemStack skull_squid = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTFlNzI0YjE5Yjc5ZDNkOTU0NTQ3ZTRjODllYzRmMzk0ZjM4MDA3ZDcyM2JkNGUyZjgzZWE1MzViZDMyODUzZCJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_squid = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_squid = customdiamondsword_squid.getItemMeta();
     customDS_squid.setDisplayName("Kit Squid");
     customDS_squid.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_squid.setItemMeta(customDS_squid);

     Kit Squid = new Kit(
         "Calamar", 
         skull_squid, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_squid, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.INK_SAC)
             )), null, 
         true, 
         new ItemStack(Material.INK_SAC), 
         Arrays.asList( "§bUne épée en fer\",\"§bUne armure en fer", "§dRendez aveugle vos adversaires"
           ), "tnt.squid");
     list_kits.add(Squid);



     ItemStack skull_barbare = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzhhOTI1NjQ4NDlmZDdmNzJjYTViYmFjNGI5MDBkOTQwZmRlOTZjNTkxMzBmNjU2Mjk5ZTNhYTlmNDgyZDg1In19fQ==", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_barbare = new ItemStack(Material.DIAMOND_AXE, 1);
     ItemMeta customDS_barbare = customdiamondsword_barbare.getItemMeta();
     customDS_barbare.setDisplayName("Kit Barbare");
     customDS_barbare.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_barbare.setItemMeta(customDS_barbare);

     Kit Barbare = new Kit(
         "Barbare", 
         skull_barbare, 
         new ItemStack(Material.CHAINMAIL_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_barbare, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.DIAMOND_AXE), 
         Arrays.asList( "§bUne épée en diamant\",\"§bUne armure en fer et chaine", "§dUne vrai brute, quel carnage!!"
           ), "tnt.barbare");
     list_kits.add(Barbare);



     ItemStack skull_snowman = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzZmZDk3N2I2NmYwMmY5MGIxNjU2MjExNWY3MDIzYWE0Nzk4Mjg5OTE2YjVkYjY1NjJjNDQzODQ4MDc2ZDNlIn19fQ==", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_snow = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_snow = customdiamondsword_snow.getItemMeta();
     customDS_snow.setDisplayName("Kit SnowMan");
     customDS_snow.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
     customdiamondsword_snow.setItemMeta(customDS_snow);

     Kit SnowMan = new Kit(
         "SnowMan", 
         skull_snowman, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_snow, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.SNOWBALL, 64), new ItemStack(Material.SNOWBALL, 64), new ItemStack(Material.SNOWBALL, 64), new ItemStack(Material.SNOWBALL, 64)
             )), null, 
         true, 
         new ItemStack(Material.SNOWBALL), 
         Arrays.asList( "§bUne épée en fer\",\"§bUne armure en fer", "§dRedenvez un enfant et faites une bataille de boule de neige"
           ), "tnt.snowman");
     list_kits.add(SnowMan);




     ItemStack skull_tank = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTVlODYyMzFmNmU2OTBiZWFlOThhMDg3M2FjY2NkYzYwN2FjZDIyYzk2Y2Y0N2NiMzY3NDkyNzBkMWY0YmVlOSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customironsword_tank = new ItemStack(Material.STONE_SWORD, 1);
     ItemMeta customIS_tank = customironsword_tank.getItemMeta();
     customIS_tank.setDisplayName("Kit Tank");
     customIS_tank.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customironsword_tank.setItemMeta(customIS_tank);

     Kit Tank = new Kit(
         "Tank", 
         skull_tank, 
         new ItemStack(Material.DIAMOND_CHESTPLATE), 
         new ItemStack(Material.DIAMOND_LEGGINGS), 
         new ItemStack(Material.DIAMOND_BOOTS), 
         customironsword_tank, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.DIAMOND_CHESTPLATE), 
         Arrays.asList( "§bArmure en diamand", "§bépée en pierre", "§dCe kit n'est pas fait pour la ngociation.", "§dLancez vous dans le combat avec pour écraser vos énemies"
           ), "tnt.tank");
     list_kits.add(Tank);


     ItemStack skull_archer = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjlkNTFhOTYzM2ZmZGNhNzExNjIxNzJhMWE4YTRmMmZkMjI1ZjE0Yjg4ZTMxOWIyYzA2M2NkOGQxMjY3Y2E3MCJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack custombow_archer = new ItemStack(Material.BOW, 1);
     ItemMeta customB_archer = custombow_archer.getItemMeta();
     customB_archer.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
     customB_archer.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
     custombow_archer.setItemMeta(customB_archer);

     ItemStack customstonesword_archer = new ItemStack(Material.STONE_SWORD, 1);
     ItemMeta customSW2_archer = customstonesword_archer.getItemMeta();
     customSW2_archer.setDisplayName("Kit Archer");
     customSW2_archer.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customstonesword_archer.setItemMeta(customSW2_archer);

     Kit Archer = new Kit(
         "Archer", 
         skull_archer, 
         new ItemStack(Material.CHAINMAIL_CHESTPLATE), 
         new ItemStack(Material.CHAINMAIL_CHESTPLATE), 
         new ItemStack(Material.IRON_BOOTS), 
         customstonesword_archer, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(custombow_archer, new ItemStack(Material.ARROW)
             )), null, 
         true, 
         new ItemStack(Material.BOW), 
         Arrays.asList( "§bArc enchant", "§bArmure en maille", "§dLe kit archer est un soutien essentiel pour votre équipe."
           ), "tnt.archer");
     list_kits.add(Archer);




     ItemStack skull_sorcier = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2FmY2NkMTk0ODUyZTUyMmU0Mjc3NjY5YTg0OTFlZjk2M2U3OTE4ZGY4M2JkOWVmMDE2ZGMzZTdmYmJmNDNmNyJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_sorcier = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_sorcier = customdiamondsword_sorcier.getItemMeta();
     customDS_sorcier.setDisplayName("Kit Sorcier");
     customDS_sorcier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_sorcier.setItemMeta(customDS_sorcier);

     ItemStack customblaze_sorcier = new ItemStack(Material.BLAZE_ROD, 1);
     ItemMeta customSSS_sorcier = customblaze_sorcier.getItemMeta();
     customSSS_sorcier.addEnchant(Enchantment.ARROW_INFINITE, 6, true);
     customSSS_sorcier.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
     customblaze_sorcier.setItemMeta(customSSS_sorcier);

     Kit Sorcier = new Kit(
         "Sorcier", 
         skull_sorcier, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_sorcier, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(customblaze_sorcier
             )), null, 
         true, 
         new ItemStack(Material.BLAZE_ROD), 
         Arrays.asList( "§bUne baguette magique\",\"§bUne armure en fer", "§dDevenez un vrai magicien \",\"§dle temps d'une partie"
           ), "tnt.sorcier");
     list_kits.add(Sorcier);





     ItemStack customwoodsword_ghost = new ItemStack(Material.WOODEN_SWORD, 1);
     ItemMeta customWS_ghost = customwoodsword_ghost.getItemMeta();
     customWS_ghost.setDisplayName("Kit Ghost");
     customWS_ghost.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
     customwoodsword_ghost.setItemMeta(customWS_ghost);

     Kit Ghost = new Kit(
         "Fantôme", 
         null, 
         null, 
         null, 
         null, 
         customwoodsword_ghost, 
         Constantes.Vie_Global_Joueur, 
         null,
         null, 
         false, 
         new ItemStack(Material.ENDER_EYE), 
         Arrays.asList( "§bépée en bois", "§bTotalement invisible", "§dLe kit Ghost vous rendra invisivle pour ", "§dinfiltrer les lignes enemies. Soyez discret et assasin."
           ), "tnt.ghost");
     list_kits.add(Ghost);




     ItemStack skull_healer = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjhiM2I0YjM3YjZhMDcxZGUxMzhhZTU0MDQ4MmQ5ODgxMzllMGNlOWFjYmY0OWRjMjFhMThkNmMyZTIwNDY1MSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customwoodsword_healer = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customWS_healer = customwoodsword_healer.getItemMeta();
     customWS_healer.setDisplayName("Kit Healer");
     customWS_healer.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customwoodsword_healer.setItemMeta(customWS_healer);

     Kit Healer = new Kit(
         "Healer", 
         skull_healer, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customwoodsword_healer, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.GLISTERING_MELON_SLICE)
             )), null, 
         true, 
         new ItemStack(Material.GLISTERING_MELON_SLICE), 
         Arrays.asList( "§bÉpée en pierre", "§bArmure maille", "§dLe kit des medecins, utilisez-le ", "§dpour soigner vos compagnons."
           ), "tnt.Healer");
     list_kits.add(Healer);




     ItemStack skull_pyro = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY2NDhhMTQ3NDhhM2IwMGVmNjM5MWY2NjljYTE5YjhhOTFlYzJmMzFmNDNhOTljZGZmOWY3YjUxMTg2OWY2MiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_pyro = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_pyro = customdiamondsword_pyro.getItemMeta();
     customDS_pyro.setDisplayName("Kit Pyro");
     customDS_pyro.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
     customdiamondsword_pyro.setItemMeta(customDS_pyro);
     ItemStack custombow = new ItemStack(Material.BOW, 1);
     ItemMeta custombowW = custombow.getItemMeta();

     custombowW.addEnchant(Enchantment.ARROW_FIRE, 1, true);
     custombowW.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
     custombow.setItemMeta(custombowW);

     Kit Pyro = new Kit(
         "Pyro", 
         skull_pyro, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_pyro, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(custombow, new ItemStack(Material.ARROW))),
         null, 
         true, 
         new ItemStack(Material.FLINT_AND_STEEL), 
         Arrays.asList( "§bEpée en pierre", "§bArmure fer", "§dPour les pyroman du dimanche "
           ), "tnt.pyro");
     list_kits.add(Pyro);




     ItemStack skull_builder = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjUzOTBlM2NjMWYwNzQ0MWU5ZGUxMzk4NDBkMDgyMTdmODYxODU3ZmY5OGY0MjExYzc5ZjNjMGI0ODYwZDgwZSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_builder = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_builder = customdiamondsword_builder.getItemMeta();
     customDS_builder.setDisplayName("Kit Builder");
     customDS_builder.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_builder.setItemMeta(customDS_builder);

     Kit Builder = new Kit(
         "Builder", 
         skull_builder, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_builder, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.SHEARS), 
         Arrays.asList( "§bEpée en fer", "§bArmure fer", "§dCa manque de déco ici! "
           ), "tnt.builder");
     list_kits.add(Builder);





     ItemStack skull_alchimiste = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U3MWE2ZWIzMDNhYjdlNmY3MGVkNTRkZjkxNDZhODBlYWRmMzk2NDE3Y2VlOTQ5NTc3M2ZmYmViZmFkODg3YyJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_alchi = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_alchi = customdiamondsword_alchi.getItemMeta();
     customDS_alchi.setDisplayName("Kit Alchimiste");
     customDS_alchi.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customdiamondsword_alchi.setItemMeta(customDS_alchi);

     ItemStack is = new ItemStack(Material.POTION, 5);
     ItemMeta im = is.getItemMeta();

     PotionMeta pm22 = (PotionMeta)im;
     pm22.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 4), true);
     pm22.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 2), true);
     pm22.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 2), true);
     pm22.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1200, 2), true);
     is.setItemMeta((ItemMeta)pm2);

     Kit Alchimiste = new Kit(
         "Alchimiste", 
         skull_alchimiste, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_alchi, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(is
             )), null, 
         true, 
         new ItemStack(Material.POTION), 
         Arrays.asList( "§bEpee en fer", "§bArmure fer", "§dUn petit élixir, Monseigneur? "
           ), "tnt.alchimiste");
     list_kits.add(Alchimiste);




     ItemStack skull_gandalf = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjcyMTRiZDQ3YjkwODhmNThhYjQyOTc5OGNmNDkyYjA1OTU3MTAxMzNlODkzMjNlZTNmMDQwNzA5OWI0YTUwNSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     ItemStack customdiamondsword_Gandalf = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Gandalf = customdiamondsword_Gandalf.getItemMeta();
     customDS_Gandalf.setDisplayName("Kit Gandalf");
     customDS_Gandalf.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
     customdiamondsword_Gandalf.setItemMeta(customDS_Gandalf);

     ItemStack customblaze_Gandalf = new ItemStack(Material.STICK, 1);
     ItemMeta customSSS_Gandalf = customblaze_Gandalf.getItemMeta();
     customSSS_Gandalf.addEnchant(Enchantment.KNOCKBACK, 10, true);
     customblaze_Gandalf.setItemMeta(customSSS_Gandalf);

     Kit Gandalf = new Kit(
         "Gandalf", 
         skull_gandalf, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Gandalf, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(customblaze_Gandalf
             )), null, 
         true, 
         new ItemStack(Material.STICK), 
         Arrays.asList( "§bUne baguette magique", "§bArmure fer", "§dVOUS NE PASSEREZ PAAAAAAAAAS "
           ), "tnt.gandalf");
     list_kits.add(Gandalf);



     ItemStack customdiamondsword_Shield = new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Shield = customdiamondsword_Shield.getItemMeta();
     customDS_Shield.setDisplayName("Kit Shield");
     customdiamondsword_Shield.setItemMeta(customDS_Shield);

     ItemStack skull_shield = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTQ5NDg2Zjg2NTI0NTgzZTA2YTJjZmNkZjhlZDhlZjdlNzk1OTA1N2ZkMWRlMWVjZTcyZDQxZTI4Nzg4ZGMifX19", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Shield = new Kit(
         "ShieldMan", 
         skull_shield, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Shield, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.SHIELD)
             )), null, 
         true, 
         new ItemStack(Material.SHIELD), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.shield");
     list_kits.add(Shield);





     ItemStack customArbalette = new ItemStack(Material.CROSSBOW, 1);
     ItemMeta customDS_Arbalette = customArbalette.getItemMeta();
     customDS_Arbalette.setDisplayName("Kit Arbalette");
     customDS_Arbalette.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
     customArbalette.setItemMeta(customDS_Arbalette);

     ItemStack skull_arbalette = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDgzMTgzMGE3YmQzYjFhYjA1YmViOThkYzJmOWZjNWVhNTUwYjNjZjY0OWZkOTRkNDgzZGE3Y2QzOWY3YzA2MyJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Arbalette = new Kit(
         "Arbalette", 
         skull_arbalette, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         new ItemStack(Material.IRON_SWORD), 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(customArbalette, new ItemStack(Material.ARROW,64),new ItemStack(Material.ARROW,64))),
         null, 
         true, 
         new ItemStack(Material.CROSSBOW), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.arbalette");
     list_kits.add(Arbalette);


     
     ItemStack customdiamondsword_Ghast= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Ghast = customdiamondsword_Ghast.getItemMeta();
     customDS_Ghast.setDisplayName("Kit Ghast");
     customdiamondsword_Ghast.setItemMeta(customDS_Ghast);


     ItemStack skull_ghast = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWQ3ZTk5ZTJlNDI3Yzk0ZjY2MmU2M2IxM2IyZTM2NzBjZjg5NGUzODc2NDc2YjIzYzgwZmM0MWJmZThhZTQ1YyJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Ghast = new Kit(
         "Ghast", 
         skull_ghast, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Ghast, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.FIRE_CHARGE, 20)
             )), null, 
         true, 
         new ItemStack(Material.FIRE_CHARGE), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.ghast");
     list_kits.add(Ghast);




     ItemStack customdiamondsword_Shulker= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Shulker = customdiamondsword_Shulker.getItemMeta();
     customDS_Shulker.setDisplayName("Kit Shulker");
     customdiamondsword_Shulker.setItemMeta(customDS_Shulker);

     ItemStack skull_shulker = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmUzM2ViZDEyYWU2ZGJmYTIzNDRkZjE2ZGE4ZmM2ZjM1OTdmZjQ4MDE3ZmJlMzgzYWJkMTY2OWNiZjU0NTYyZCJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Shulker = new Kit(
         "Shulker", 
         skull_shulker, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Shulker, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.SHULKER_BOX))),
		null, 
         true, 
         new ItemStack(Material.SHULKER_BOX), 
         Arrays.asList( "bUne épée en Fer\",\"bUne armure en faire\",\"dEt de quoi faire leviter vos ennemies"
           ), "tnt.shulker");
     list_kits.add(Shulker);


     ItemStack customdiamondsword_Spider= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Spider = customdiamondsword_Spider.getItemMeta();
     customDS_Spider.setDisplayName("Kit Spider");
     customdiamondsword_Spider.setItemMeta(customDS_Spider);


     ItemStack skull_spider = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTNjNDIwOGFlODA5ZDE2NmQyZjFlOWMzYjBiNDVjZDI4ODRjMWZiZDJlMTZiMDM4MjY2ZGRjODg5MGIwNjAzZSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Spider = new Kit(
         "Spider", 
         skull_spider, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Spider, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.COBWEB)
             )), null, 
         true, 
         new ItemStack(Material.COBWEB), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.spider");
     list_kits.add(Spider);



     ItemStack customdiamondsword_Wither= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Wither = customdiamondsword_Wither.getItemMeta();
     customDS_Wither.setDisplayName("Kit Wither");
     customdiamondsword_Wither.setItemMeta(customDS_Wither);
     
     ItemStack skull_wither = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E1Nzc1ZWFiYmJmODFmOGE5ZTNmYjE0MGZiN2RjYjBlNjhjNWIyZDAyZTEwYjEwNDM1NjQxMjU0OTRmMWEyZiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Wither = new Kit(
         "Wither", 
         skull_wither, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Wither, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.WITHER_ROSE)
             )), null, 
         true, 
         new ItemStack(Material.WITHER_SKELETON_SKULL), 
         Arrays.asList( "bUne épée et armure en fer\",\"bEffet Whiter\",\"dLes coups d'épée vont lui faire mal!"
           ), "tnt.wither");
     list_kits.add(Wither);






     ItemStack customblaze_PandaMan = new ItemStack(Material.BAMBOO, 1);
     ItemMeta customSSS_PandaMan = customblaze_PandaMan.getItemMeta();
     customSSS_PandaMan.setDisplayName("Kit PandaMan");
     customSSS_PandaMan.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
     customblaze_PandaMan.setItemMeta(customSSS_PandaMan);

     ItemStack skull_panda = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRlOTk5NGQ5NzkyMTJmN2JhOTNmNDFkOWI5YTk3YmI4ODY4ODE0OWU3NmMyMmZiNWNhODNjOTE1OTI5YTFlNiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit PandaMan = new Kit(
         "PandaMan", 
         skull_panda, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customblaze_PandaMan, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.BAMBOO), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.pandaman");
     list_kits.add(PandaMan);


     
     ItemStack customdiamondsword_Poison= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Poison = customdiamondsword_Poison.getItemMeta();
     customDS_Poison.setDisplayName("Kit Poison");
     customdiamondsword_Poison.setItemMeta(customDS_Poison);

     ItemStack skull_poison = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjA1MDNiODFhYzAyMGM2N2MzNzc4N2I0NWM5YTI2MjIzZjliYzI2YmNhMjdmODFhZjMyZjJjZjU1ZTI0NDBiNyJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Poison = new Kit(
         "Poison", 
         skull_poison, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Poison, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.CRIMSON_FUNGUS))),
		null, 
         true, 
         new ItemStack(Material.CRIMSON_FUNGUS), 
         Arrays.asList( "b§test\",\"§btest\",\"§dtest"
           ), "tnt.poison");
     list_kits.add(Poison);





     ItemStack customblaze_Pecheur = new ItemStack(Material.TROPICAL_FISH, 1);
     ItemMeta customSSS_Pecheur = customblaze_Pecheur.getItemMeta();
     customSSS_Pecheur.setDisplayName("Kit Pêcheur");
     customSSS_Pecheur.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
     customblaze_Pecheur.setItemMeta(customSSS_Pecheur);

     ItemStack skull_pecheur = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjkyMzUwYzlmMDk5M2VkNTRkYjJjNzExMzkzNjMyNTY4M2ZmYzIwMTA0YTliNjIyYWE0NTdkMzdlNzA4ZDkzMSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Pecheur = new Kit(
         "Pecheur", 
         skull_pecheur, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customblaze_Pecheur, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.FISHING_ROD), new ItemStack(Material.PUFFERFISH)
             )), null, 
         true, 
         new ItemStack(Material.FISHING_ROD), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.pecheur");
     list_kits.add(Pecheur);




     ItemStack customdiamondsword_Rocketman= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Rocketman = customdiamondsword_Rocketman.getItemMeta();
     customDS_Rocketman.setDisplayName("Kit Rocketman");
     customdiamondsword_Rocketman.setItemMeta(customDS_Rocketman);

     ItemStack skull_rocketman = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBkZGNiN2EwNjFmNTU1Njk2MmQwZWVmZGVhZTQ4OGQwNDZkYjNhYWJjZTYyMTRmNDA0MjRmNTgyYzY1Y2MwNSJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Rocketman = new Kit(
         "Rocketman", 
         skull_rocketman, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Rocketman, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.FIREWORK_ROCKET), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.rocketman");
     list_kits.add(Rocketman);




     ItemStack customdiamondsword_Blaze= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Blaze = customdiamondsword_Blaze.getItemMeta();
     customDS_Blaze.setDisplayName("Kit Blaze");
     customdiamondsword_Blaze.setItemMeta(customDS_Blaze);

     ItemStack skull_blaze = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjIwNjU3ZTI0YjU2ZTFiMmY4ZmMyMTlkYTFkZTc4OGMwYzI0ZjM2Mzg4YjFhNDA5ZDBjZDJkOGRiYTQ0YWEzYiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Blaze = new Kit(
         "Blaze", 
         skull_blaze, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Blaze, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.BLAZE_ROD)
             )), null, 
         true, 
         new ItemStack(Material.BLAZE_ROD), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.blaze");
     list_kits.add(Blaze);




     ItemStack customdiamondsword_Evocateur= new ItemStack(Material.NETHERITE_AXE, 1);
     ItemMeta customDS_Evocateur = customdiamondsword_Evocateur.getItemMeta();
     customDS_Evocateur.setDisplayName("Kit Evocateur");
     customdiamondsword_Evocateur.setItemMeta(customDS_Evocateur);


     ItemStack skull_evocateur = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzJmYjgwYTZiNjgzM2UzMWQ5Y2U4MzEzYTU0Nzc3NjQ1ZjljMWU1NWI4MTA5MThhNzA2ZTdiY2M4ZDM1YTVhMiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Evocateur = new Kit(
         "Evocateur", 
         skull_evocateur, 
         new ItemStack(Material.LEATHER_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Evocateur, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(new ItemStack(Material.NETHER_BRICK)
             )), null, 
         true, 
         new ItemStack(Material.END_ROD), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.evocateur");
     list_kits.add(Evocateur);






     ItemStack custombow_archer2 = new ItemStack(Material.BOW, 1);
     ItemMeta customB_archer2 = custombow_archer2.getItemMeta();
     customB_archer2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
     customB_archer2.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
     custombow_archer2.setItemMeta(customB_archer2);

     ItemStack customstonesword_archer2 = new ItemStack(Material.STONE_SWORD, 1);
     ItemMeta customSW2_archer2 = customstonesword_archer2.getItemMeta();
     customSW2_archer2.setDisplayName("Kit Archer2");
     customSW2_archer2.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
     customstonesword_archer2.setItemMeta(customSW2_archer2);

     ItemStack skull_archer2 = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTdmMTVlMmRkZGE1YzRiNjU0MzUzZmUwMjMwZmFhNGU5NjI1MGZkYzI4MDlhODQ5ZTFmZmQwMjBmYzdlM2ZhMyJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Archer2 = new Kit(
         "Archer 2", 
         skull_archer2, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customstonesword_archer2, 
         Constantes.Vie_Global_Joueur, 
         new ArrayList<ItemStack>(Arrays.asList(custombow_archer2, new ItemStack(Material.ARROW))),
		null, 
         true, 
         new ItemStack(Material.ARROW), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.archer2");
     list_kits.add(Archer2);




     ItemStack customdiamondsword_Tacticien= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Tacticien = customdiamondsword_Tacticien.getItemMeta();
     customDS_Tacticien.setDisplayName("Kit Tacticien");
     customdiamondsword_Tacticien.setItemMeta(customDS_Tacticien);
     ItemStack skull_tacticien = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWE1NTQyOTY1YTIwNWJiNjY0NTY2MzRmNzhmMmY0M2U0NDdlNjY1ZTY1NTAyYjJhNDU3MmI1YWNmZmIzYWM5In19fQ==", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Tacticien = new Kit(
         "Tacticien", 
         skull_tacticien, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Tacticien, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.WHITE_GLAZED_TERRACOTTA), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.tacticien");
     list_kits.add(Tacticien);



     ItemStack customdiamondsword_Teleporteur= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Teleporteur = customdiamondsword_Teleporteur.getItemMeta();
     customDS_Teleporteur.setDisplayName("Kit Teleporteur");
     customdiamondsword_Teleporteur.setItemMeta(customDS_Teleporteur);

     ItemStack skull_teleporteur = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg3YTk1MzZiNmI0NWJmYWU1ZGNjZTYzM2QxODQ3NGNmMjAwZTJmY2U4NDQ3ODI3YWRjMjFjNTZkZDhhMDVmYiJ9fX0=", 
         Arrays.asList( "test", "test"
           ), "test_autre");

     Kit Teleporteur = new Kit(
         "Teleporteur", 
         skull_teleporteur, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Teleporteur, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.CLOCK), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.teleporteur");
     list_kits.add(Teleporteur);

     
     ItemStack customdiamondsword_Spy= new ItemStack(Material.IRON_SWORD, 1);
     ItemMeta customDS_Spy = customdiamondsword_Spy.getItemMeta();
     customDS_Spy.setDisplayName("Kit Spy");
     customdiamondsword_Spy.setItemMeta(customDS_Spy);
     
     ItemStack skull_Spy = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg3YTk1MzZiNmI0NWJmYWU1ZGNjZTYzM2QxODQ3NGNmMjAwZTJmY2U4NDQ3ODI3YWRjMjFjNTZkZDhhMDVmYiJ9fX0=", 
             Arrays.asList( "test", "test"
               ), "test_autre");

     Kit Spy = new Kit(
         "Spy", 
         skull_Spy, 
         new ItemStack(Material.IRON_CHESTPLATE), 
         new ItemStack(Material.IRON_LEGGINGS), 
         new ItemStack(Material.IRON_BOOTS), 
         customdiamondsword_Spy, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.BEACON), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.spy");
     list_kits.add(Spy);

     
     
     
     Kit Hasard = new Kit(
         "Hasard", 
         null, 
         null, 
         null, 
         null, 
         null, 
         Constantes.Vie_Global_Joueur, 
         null, 
         null, 
         true, 
         new ItemStack(Material.HEART_OF_THE_SEA), 
         Arrays.asList( "btest\",\"btest\",\"dtest"
           ), "tnt.hasard");
     list_kits.add(Hasard);




     return list_kits;
				}
			}


