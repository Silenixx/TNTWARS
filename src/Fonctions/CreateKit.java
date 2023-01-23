/*      */ package Fonctions;
/*      */ 
/*      */ import Constante.Constantes;
/*      */ import fr.silenix.tntwars.entity.Kit;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.enchantments.Enchantment;
/*      */ import org.bukkit.inventory.ItemFlag;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.meta.ItemMeta;
/*      */ import org.bukkit.inventory.meta.PotionMeta;
/*      */ import org.bukkit.potion.PotionEffect;
/*      */ import org.bukkit.potion.PotionEffectType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CreateKit
/*      */ {
/*      */   public static ArrayList<Kit> CreationKit() {
/*   36 */     ArrayList<Kit> list_kits = new ArrayList<>();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   43 */     ItemStack customdiamondsword_guerrier = new ItemStack(Material.DIAMOND_SWORD, 1);
/*   44 */     ItemMeta customDS_guerrier = customdiamondsword_guerrier.getItemMeta();
/*      */     
/*   46 */     customDS_guerrier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*      */ 
/*      */     
/*   49 */     customdiamondsword_guerrier.setItemMeta(customDS_guerrier);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   74 */     ItemStack skull_guerrier = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDQyMWE4NGYwZjA5MWU1NzNhYzFhNjNkYWQ3ZTQyOTEyN2EwZTdjNDA0OGM5ZDA2MzQxYjc1Y2U4MGQ0YWU4NCJ9fX0=", 
/*   75 */         Arrays.asList(new String[] { "test", "test"
/*   76 */           }, ), "test_autre");
/*      */ 
/*      */ 
/*      */     
/*   80 */     Kit Guerrier = new Kit(
/*   81 */         "Guerrier", 
/*   82 */         skull_guerrier, 
/*   83 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*   84 */         new ItemStack(Material.IRON_LEGGINGS), 
/*   85 */         new ItemStack(Material.IRON_BOOTS), 
/*   86 */         customdiamondsword_guerrier, 
/*   87 */         Constantes.Vie_Global_Joueur, 
/*   88 */         null, 
/*   89 */         null, 
/*   90 */         true, 
/*   91 */         new ItemStack(Material.DIAMOND_SWORD), 
/*   92 */         Arrays.asList(new String[] { "§bArmure en fer", "§bEp§e en diamant", "§dCe kit est fait pour les mordues de PVP.", "§dVous ferez partie des combattants majeurs de votre équipe."
/*   93 */           }, ), "tnt.guerrier");
/*   94 */     list_kits.add(Guerrier);
/*      */ 
/*      */     
/*   97 */     ItemStack skull_enderman = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDY4NWUyZTkwNmI0NDY0N2E5Y2RjODA2NmIxMDZiYzUwYTJjOWFiZjk3NGU2OTIzOTkxN2ZkMjFhMTViNDM2OCJ9fX0=", 
/*   98 */         Arrays.asList(new String[] { "test", "test"
/*   99 */           }, ), "test_autre");
/*      */     
/*  101 */     ItemStack customdiamondsword_ender = new ItemStack(Material.IRON_SWORD, 1);
/*  102 */     ItemMeta customDS_ender = customdiamondsword_ender.getItemMeta();
/*  103 */     customDS_ender.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  104 */     customdiamondsword_ender.setItemMeta(customDS_ender);
/*      */     
/*  106 */     Kit Enderman = new Kit(
/*  107 */         "Enderman", 
/*  108 */         skull_enderman, 
/*  109 */         new ItemStack(Material.LEATHER_CHESTPLATE), 
/*  110 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  111 */         new ItemStack(Material.IRON_BOOTS), 
/*  112 */         customdiamondsword_ender, 
/*  113 */         Constantes.Vie_Global_Joueur, 
/*  114 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.ENDER_PEARL, 3), new ItemStack(Material.CHORUS_FRUIT, 10)
/*  115 */             })), null, 
/*  116 */         true, 
/*  117 */         new ItemStack(Material.ENDER_PEARL), 
/*  118 */         Arrays.asList(new String[] { "§bEp§e en fer", "§btest\",\"§dtest"
/*  119 */           }, ), "tnt.enderman");
/*  120 */     list_kits.add(Enderman);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  126 */     ItemStack skull_creeper = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjZDc3NzQ0NDZiZGRmNzk0MTVhODA5Y2E2MGU0NDU0OTdmODk1NTFjZWIyMTUyMmNkODFkMTY1MTE2Njc4MSJ9fX0=", 
/*  127 */         Arrays.asList(new String[] { "test", "test"
/*  128 */           }, ), "test_autre");
/*      */     
/*  130 */     ItemStack customdiamondsword_creeper = new ItemStack(Material.IRON_SWORD, 1);
/*  131 */     ItemMeta customDS_creeper = customdiamondsword_creeper.getItemMeta();
/*  132 */     customDS_creeper.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  133 */     customdiamondsword_creeper.setItemMeta(customDS_creeper);
/*      */     
/*  135 */     ItemStack customboot_creeper = new ItemStack(Material.IRON_BOOTS, 1);
/*  136 */     ItemMeta customb_creeper = customboot_creeper.getItemMeta();
/*  137 */     customb_creeper.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
/*  138 */     customboot_creeper.setItemMeta(customb_creeper);
/*      */     
/*  140 */     ItemStack customchest_creeper = new ItemStack(Material.IRON_CHESTPLATE, 1);
/*  141 */     ItemMeta customc_creeper = customchest_creeper.getItemMeta();
/*  142 */     customc_creeper.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
/*  143 */     customchest_creeper.setItemMeta(customc_creeper);
/*      */     
/*  145 */     ItemStack customhelmet_creeper = new ItemStack(Material.IRON_HELMET, 1);
/*  146 */     ItemMeta customh_creeper = customhelmet_creeper.getItemMeta();
/*  147 */     customh_creeper.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
/*  148 */     customhelmet_creeper.setItemMeta(customh_creeper);
/*      */     
/*  150 */     ItemStack customlegging_creeper = new ItemStack(Material.IRON_LEGGINGS, 1);
/*  151 */     ItemMeta customl_creeper = customlegging_creeper.getItemMeta();
/*  152 */     customl_creeper.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 100, true);
/*  153 */     customlegging_creeper.setItemMeta(customl_creeper);
/*      */     
/*  155 */     Kit Creeper = new Kit(
/*  156 */         "Creeper", 
/*  157 */         skull_creeper, 
/*  158 */         customchest_creeper, 
/*  159 */         customlegging_creeper, 
/*  160 */         customboot_creeper, 
/*  161 */         customdiamondsword_creeper, 
/*  162 */         Constantes.Vie_Global_Joueur, 
/*  163 */         null, 
/*  164 */         null, 
/*  165 */         true, 
/*  166 */         new ItemStack(Material.GUNPOWDER), 
/*  167 */         Arrays.asList(new String[] { "§bArmure en fer protection explosion", "§bEpee en fer", "§dIncarnez un creeper"
/*  168 */           }, ), "tnt.creeper");
/*  169 */     list_kits.add(Creeper);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  174 */     ItemStack skull_oneshot = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjJlMzdjNjM2ZmZjYzA1ZjUxOGFiOTdiZjcxMTFjNmQzY2E5NWM1MzAwYzUyZTU2MGMzZGMzNTYzNzZlZWJkYiJ9fX0=", 
/*  175 */         Arrays.asList(new String[] { "test", "test"
/*  176 */           }, ), "test_autre");
/*      */     
/*  178 */     ItemStack customdiamondsword_oneshot = new ItemStack(Material.NETHERITE_SWORD, 1);
/*  179 */     ItemMeta customDS_oneshot = customdiamondsword_oneshot.getItemMeta();
/*  180 */     customDS_oneshot.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  181 */     customdiamondsword_oneshot.setItemMeta(customDS_oneshot);
/*      */     
/*  183 */     Kit OneShot = new Kit(
/*  184 */         "OneShot", 
/*  185 */         skull_oneshot, 
/*  186 */         null, 
/*  187 */         null, 
/*  188 */         null, 
/*  189 */         customdiamondsword_oneshot, 
/*  190 */         1, 
/*  191 */         null, 
/*  192 */         null, 
/*  193 */         true, 
/*  194 */         new ItemStack(Material.END_CRYSTAL), 
/*  195 */         Arrays.asList(new String[] { "§bEpee en netherite\",\"§bPas d'armure", "§dUn coup d'§p§e et il est mort"
/*  196 */           }, ), "tnt.oneshot");
/*  197 */     list_kits.add(OneShot);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  202 */     ItemStack skull_elytra = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWRmZTUxODAxNzYxNjYwZWJmNmRhZTcwZTljYWQ1ODhiMmVmNWU2Y2IyYjMxOTRkMDI4YTQwYWMwZWViY2RmNSJ9fX0=", 
/*  203 */         Arrays.asList(new String[] { "test", "test"
/*  204 */           }, ), "test_autre");
/*      */     
/*  206 */     ItemStack customdiamondsword_elytra = new ItemStack(Material.STONE_SWORD, 1);
/*  207 */     ItemMeta customDS_elytra = customdiamondsword_elytra.getItemMeta();
/*  208 */     customDS_elytra.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  209 */     customdiamondsword_elytra.setItemMeta(customDS_elytra);
/*      */     
/*  211 */     Kit Elytra = new Kit(
/*  212 */         "Elytra", 
/*  213 */         skull_elytra, 
/*  214 */         new ItemStack(Material.ELYTRA), 
/*  215 */         new ItemStack(Material.CHAINMAIL_LEGGINGS), 
/*  216 */         new ItemStack(Material.IRON_BOOTS), 
/*  217 */         customdiamondsword_elytra, 
/*  218 */         Constantes.Vie_Global_Joueur, 
/*  219 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.FIREWORK_ROCKET, 1)
/*  220 */             })), null, 
/*  221 */         true, 
/*  222 */         new ItemStack(Material.ELYTRA), 
/*  223 */         Arrays.asList(new String[] { "§bEpee en pierre\",\"§bUne paire d'élytre et une rocket", "§denvolez vous dans les cieux"
/*  224 */           }, ), "tnt.elytra");
/*  225 */     list_kits.add(Elytra);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  232 */     ItemStack customdiamondsword_Ninja = new ItemStack(Material.NETHERITE_SWORD, 1);
/*  233 */     ItemMeta customDS_Ninja = customdiamondsword_Ninja.getItemMeta();
/*  234 */     customDS_Ninja.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
/*  235 */     customdiamondsword_Ninja.setItemMeta(customDS_Ninja);
/*      */     
/*  237 */     ItemStack is_Ninja = new ItemStack(Material.SPLASH_POTION, 5);
/*  238 */     ItemMeta im_Ninja = is_Ninja.getItemMeta();
/*      */     
/*  240 */     PotionMeta pm_Ninja = (PotionMeta)im_Ninja;
/*  241 */     pm_Ninja.setDisplayName("Jump");
/*  242 */     pm_Ninja.addCustomEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 4), true);
/*  243 */     is_Ninja.setItemMeta((ItemMeta)pm_Ninja);
/*      */     
/*  245 */     ItemStack is2_Ninja = new ItemStack(Material.SPLASH_POTION, 5);
/*  246 */     ItemMeta im2_Ninja = is2_Ninja.getItemMeta();
/*      */     
/*  248 */     PotionMeta pm2 = (PotionMeta)im2_Ninja;
/*  249 */     pm2.setDisplayName("Speed");
/*  250 */     pm2.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 4), true);
/*  251 */     is2_Ninja.setItemMeta((ItemMeta)pm2);
/*      */     
/*  253 */     Kit Ninja = new Kit(
/*  254 */         "Ninja", 
/*  255 */         null, 
/*  256 */         null, 
/*  257 */         null, 
/*  258 */         null, 
/*  259 */         customdiamondsword_Ninja, 
/*  260 */         Constantes.Vie_Global_Joueur, 
/*  261 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { is_Ninja, is2_Ninja, new ItemStack(Material.BLACK_BANNER, 3), new ItemStack(Material.GOLDEN_APPLE, 5)
/*  262 */             })), null, 
/*  263 */         true, 
/*  264 */         new ItemStack(Material.BLACK_BANNER), 
/*  265 */         Arrays.asList(new String[] { "§btest\",\"btest\",\"dtest"
/*  266 */           }, ), "tnt.ninja");
/*  267 */     list_kits.add(Ninja);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  273 */     ItemStack skull_savior = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmU2MmM4N2Q4MmNjNzNmZDQyMjg4YjI3NGZhODllOGQ2M2EyNWI5NTJiZGZlMGU1ZGRmNGM5OGIxNDM3In19fQ==", 
/*  274 */         Arrays.asList(new String[] { "test", "test"
/*  275 */           }, ), "test_autre");
/*      */     
/*  277 */     ItemStack customdiamondsword_Savior = new ItemStack(Material.STONE_SWORD, 1);
/*  278 */     ItemMeta customDS_Savior = customdiamondsword_Savior.getItemMeta();
/*  279 */     customDS_Savior.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  280 */     customdiamondsword_Savior.setItemMeta(customDS_Savior);
/*      */     
/*  282 */     Kit Savior = new Kit(
/*  283 */         "Savior", 
/*  284 */         skull_savior, 
/*  285 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  286 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  287 */         new ItemStack(Material.IRON_BOOTS), 
/*  288 */         customdiamondsword_Savior, 
/*  289 */         Constantes.Vie_Global_Joueur, 
/*  290 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.AMETHYST_SHARD, 3), new ItemStack(Material.AMETHYST_CLUSTER, 3)
/*  291 */             })), null, 
/*  292 */         true, 
/*  293 */         new ItemStack(Material.AMETHYST_SHARD), 
/*  294 */         Arrays.asList(new String[] { "§bEpee en pierre", "§bDe quoi soigner", "§dMerci toubib"
/*  295 */           }, ), "tnt.savior");
/*  296 */     list_kits.add(Savior);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  302 */     ItemStack skull_pigrider = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTkyMzdhMDY3MjEyMDEzMmY2MWE2ZGIyZjQ1ZDE3N2Y4YWQ4Y2UxYTlmYWQ5MTMyNzRjNzUyYTUxNGQ4Y2I1NSJ9fX0=", 
/*  303 */         Arrays.asList(new String[] { "test", "test"
/*  304 */           }, ), "test_autre");
/*      */     
/*  306 */     ItemStack customcarrot = new ItemStack(Material.CARROT_ON_A_STICK, 1);
/*  307 */     ItemMeta customCARROTE = customcarrot.getItemMeta();
/*  308 */     customCARROTE.addEnchant(Enchantment.KNOCKBACK, 5, true);
/*  309 */     customCARROTE.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
/*  310 */     customcarrot.setItemMeta(customCARROTE);
/*      */     
/*  312 */     Kit PigRider = new Kit(
/*  313 */         "PigRider", 
/*  314 */         skull_pigrider, 
/*  315 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  316 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  317 */         new ItemStack(Material.IRON_BOOTS), 
/*  318 */         customcarrot, 
/*  319 */         Constantes.Vie_Global_Joueur, 
/*  320 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { customcarrot, customcarrot, customcarrot, customcarrot, customcarrot, new ItemStack(Material.SADDLE, 6), new ItemStack(Material.PIG_SPAWN_EGG, 6)
/*  321 */             })), null, 
/*  322 */         true, 
/*  323 */         new ItemStack(Material.CARROT_ON_A_STICK), 
/*  324 */         Arrays.asList(new String[] { "§bCanne § p§che carotte\",\"§bUne horde de cochons", "§dDevenez un v§ritable dresseur"
/*  325 */           }, ), "tnt.pigrider");
/*  326 */     list_kits.add(PigRider);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  334 */     ItemStack skull_chevalier = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGE5NzcxMDliODJmZTE3NTI3YmQ3MTkxYjNiNWVhNTJmZWEzMGJmNTY3ZDEwOTdjYTQ3YTliNmIyY2FhMWRkYSJ9fX0=", 
/*  335 */         Arrays.asList(new String[] { "test", "test"
/*  336 */           }, ), "test_autre");
/*      */     
/*  338 */     ItemStack customdiamondsword_chevalier = new ItemStack(Material.IRON_SWORD, 1);
/*  339 */     ItemMeta customDS_chevalier = customdiamondsword_chevalier.getItemMeta();
/*  340 */     customDS_chevalier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  341 */     customdiamondsword_chevalier.setItemMeta(customDS_chevalier);
/*      */     
/*  343 */     Kit Chevalier = new Kit(
/*  344 */         "Chevalier", 
/*  345 */         skull_chevalier, 
/*  346 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  347 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  348 */         new ItemStack(Material.IRON_BOOTS), 
/*  349 */         customdiamondsword_chevalier, 
/*  350 */         Constantes.Vie_Global_Joueur, 
/*  351 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.HORSE_SPAWN_EGG, 1), new ItemStack(Material.SADDLE, 1), new ItemStack(Material.WHEAT, 64), new ItemStack(Material.WHEAT, 64)
/*  352 */             })), null, 
/*  353 */         true, 
/*  354 */         new ItemStack(Material.SADDLE), 
/*  355 */         Arrays.asList(new String[] { "§bUne §p§e en fer\",\"§bUne armure en fer", "§dUn cheval et vous voila au moyen-age"
/*  356 */           }, ), "tnt.chevalier");
/*  357 */     list_kits.add(Chevalier);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  367 */     ItemStack skull_pirate = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNDVlMzU2YTI3YTczMzFjNGY1Mzg4ZmI5OWY5MzRiOTkwNDc4NzE1MWJjNDk1YjEyMjMyYjM0MGM4OTEzMGRkNiJ9fX0=", 
/*  368 */         Arrays.asList(new String[] { "test", "test"
/*  369 */           }, ), "test_autre");
/*      */     
/*  371 */     ItemStack customdiamondsword_pirate = new ItemStack(Material.IRON_SWORD, 1);
/*  372 */     ItemMeta customDS_pirate = customdiamondsword_pirate.getItemMeta();
/*  373 */     customDS_pirate.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  374 */     customdiamondsword_pirate.setItemMeta(customDS_pirate);
/*      */     
/*  376 */     ItemStack customhelmet_pirate = new ItemStack(Material.SKELETON_SKULL, 1);
/*  377 */     ItemMeta customHH_pirate = customhelmet_pirate.getItemMeta();
/*  378 */     customHH_pirate.addEnchant(Enchantment.OXYGEN, 3, true);
/*  379 */     customhelmet_pirate.setItemMeta(customHH_pirate);
/*      */     
/*  381 */     Kit Pirate = new Kit(
/*  382 */         "Pirate", 
/*  383 */         skull_pirate, 
/*  384 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  385 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  386 */         new ItemStack(Material.IRON_BOOTS), 
/*  387 */         customdiamondsword_pirate, 
/*  388 */         Constantes.Vie_Global_Joueur, 
/*  389 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.PARROT_SPAWN_EGG, 3), new ItemStack(Material.WHEAT_SEEDS, 64), new ItemStack(Material.SPYGLASS), new ItemStack(Material.GOLDEN_APPLE, 2)
/*  390 */             })), null, 
/*  391 */         true, 
/*  392 */         new ItemStack(Material.SPYGLASS), 
/*  393 */         Arrays.asList(new String[] { "§bUne §p§e en fer\",\"§bUne armure en fer", "§dL'apn§e ca vous connait, ne seriez vous pas Jack Sparrow?"
/*  394 */           }, ), "tnt.pirate");
/*  395 */     list_kits.add(Pirate);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  401 */     ItemStack skull_dogmaster = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzA1MmQ4OTAzZGEyYTNiZGNlNGRiNDYwMDA0OGQ4M2IwNDkxYzFlODU0MGJhZmNhYzVlMzZmNWRlZTY3ZWZmZSJ9fX0=", 
/*  402 */         Arrays.asList(new String[] { "test", "test"
/*  403 */           }, ), "test_autre");
/*      */     
/*  405 */     ItemStack customdiamondsword_dog = new ItemStack(Material.IRON_SWORD, 1);
/*  406 */     ItemMeta customDS_dog = customdiamondsword_dog.getItemMeta();
/*  407 */     customDS_dog.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  408 */     customdiamondsword_dog.setItemMeta(customDS_dog);
/*      */     
/*  410 */     Kit DogMaster = new Kit(
/*  411 */         "DogMaster", 
/*  412 */         skull_dogmaster, 
/*  413 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  414 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  415 */         new ItemStack(Material.IRON_BOOTS), 
/*  416 */         customdiamondsword_dog, 
/*  417 */         Constantes.Vie_Global_Joueur, 
/*  418 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.BONE, 64), new ItemStack(Material.WOLF_SPAWN_EGG, 7)
/*  419 */             })), null, 
/*  420 */         true, 
/*  421 */         new ItemStack(Material.BONE), 
/*  422 */         Arrays.asList(new String[] { "§bUne §p§e en fer\",\"§bUne armure en fer", "§dUne horde de loup, un vrai §l§veur"
/*  423 */           }, ), "tnt.dogmaster");
/*  424 */     list_kits.add(DogMaster);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  429 */     ItemStack skull_trident = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRlNTQ0ZjEwNjM1YzJkMzQ4MGNmMDBjNTJiZTFjZWE5NDg0YWQxZTcyODFiNDkzNjU5ZGMzYjlmN2EzOWM2YiJ9fX0=", 
/*  430 */         Arrays.asList(new String[] { "test", "test"
/*  431 */           }, ), "test_autre");
/*      */     
/*  433 */     ItemStack customdiamondsword_Trident = new ItemStack(Material.STONE_SWORD, 1);
/*  434 */     ItemMeta customDS_Trident = customdiamondsword_Trident.getItemMeta();
/*  435 */     customDS_Trident.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  436 */     customdiamondsword_Trident.setItemMeta(customDS_Trident);
/*      */     
/*  438 */     ItemStack customtrident_Trident = new ItemStack(Material.TRIDENT, 1);
/*  439 */     ItemMeta customTTT_Trident = customtrident_Trident.getItemMeta();
/*  440 */     customTTT_Trident.addEnchant(Enchantment.CHANNELING, 1, true);
/*  441 */     customTTT_Trident.addEnchant(Enchantment.LOYALTY, 3, true);
/*  442 */     customtrident_Trident.setItemMeta(customTTT_Trident);
/*      */     
/*  444 */     Kit Trident = new Kit(
/*  445 */         "Trident", 
/*  446 */         skull_trident, 
/*  447 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  448 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  449 */         new ItemStack(Material.IRON_BOOTS), 
/*  450 */         customdiamondsword_Trident, 
/*  451 */         Constantes.Vie_Global_Joueur, 
/*  452 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { customtrident_Trident
/*  453 */             }, )), null, 
/*  454 */         true, 
/*  455 */         new ItemStack(Material.TRIDENT), 
/*  456 */         Arrays.asList(new String[] { "§bUne §p§e en pierre et un tridant\",\"§bUne armure en fer", "§dQui vois je , Aquaman c'est toi?"
/*  457 */           }, ), "tnt.trident");
/*  458 */     list_kits.add(Trident);
/*      */ 
/*      */ 
/*      */     
/*  462 */     ItemStack skull_squid = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTFlNzI0YjE5Yjc5ZDNkOTU0NTQ3ZTRjODllYzRmMzk0ZjM4MDA3ZDcyM2JkNGUyZjgzZWE1MzViZDMyODUzZCJ9fX0=", 
/*  463 */         Arrays.asList(new String[] { "test", "test"
/*  464 */           }, ), "test_autre");
/*      */     
/*  466 */     ItemStack customdiamondsword_squid = new ItemStack(Material.IRON_SWORD, 1);
/*  467 */     ItemMeta customDS_squid = customdiamondsword_squid.getItemMeta();
/*  468 */     customDS_squid.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  469 */     customdiamondsword_squid.setItemMeta(customDS_squid);
/*      */     
/*  471 */     Kit Squid = new Kit(
/*  472 */         "Calamar", 
/*  473 */         skull_squid, 
/*  474 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  475 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  476 */         new ItemStack(Material.IRON_BOOTS), 
/*  477 */         customdiamondsword_squid, 
/*  478 */         Constantes.Vie_Global_Joueur, 
/*  479 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.INK_SAC)
/*  480 */             }, )), null, 
/*  481 */         true, 
/*  482 */         new ItemStack(Material.INK_SAC), 
/*  483 */         Arrays.asList(new String[] { "§bUne §p§e en fer\",\"§bUne armure en fer", "§dRendez aveugle vos adversaires"
/*  484 */           }, ), "tnt.squid");
/*  485 */     list_kits.add(Squid);
/*      */ 
/*      */ 
/*      */     
/*  489 */     ItemStack skull_barbare = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzhhOTI1NjQ4NDlmZDdmNzJjYTViYmFjNGI5MDBkOTQwZmRlOTZjNTkxMzBmNjU2Mjk5ZTNhYTlmNDgyZDg1In19fQ==", 
/*  490 */         Arrays.asList(new String[] { "test", "test"
/*  491 */           }, ), "test_autre");
/*      */     
/*  493 */     ItemStack customdiamondsword_barbare = new ItemStack(Material.DIAMOND_AXE, 1);
/*  494 */     ItemMeta customDS_barbare = customdiamondsword_barbare.getItemMeta();
/*  495 */     customDS_barbare.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  496 */     customdiamondsword_barbare.setItemMeta(customDS_barbare);
/*      */     
/*  498 */     Kit Barbare = new Kit(
/*  499 */         "Barbare", 
/*  500 */         skull_barbare, 
/*  501 */         new ItemStack(Material.CHAINMAIL_CHESTPLATE), 
/*  502 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  503 */         new ItemStack(Material.IRON_BOOTS), 
/*  504 */         customdiamondsword_barbare, 
/*  505 */         Constantes.Vie_Global_Joueur, 
/*  506 */         null, 
/*  507 */         null, 
/*  508 */         true, 
/*  509 */         new ItemStack(Material.DIAMOND_AXE), 
/*  510 */         Arrays.asList(new String[] { "§bUne §p§e en diamant\",\"§bUne armure en fer et chaine", "§dUne vrai brute, quel carnage!!"
/*  511 */           }, ), "tnt.barbare");
/*  512 */     list_kits.add(Barbare);
/*      */ 
/*      */ 
/*      */     
/*  516 */     ItemStack skull_snowman = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzZmZDk3N2I2NmYwMmY5MGIxNjU2MjExNWY3MDIzYWE0Nzk4Mjg5OTE2YjVkYjY1NjJjNDQzODQ4MDc2ZDNlIn19fQ==", 
/*  517 */         Arrays.asList(new String[] { "test", "test"
/*  518 */           }, ), "test_autre");
/*      */     
/*  520 */     ItemStack customdiamondsword_snow = new ItemStack(Material.IRON_SWORD, 1);
/*  521 */     ItemMeta customDS_snow = customdiamondsword_snow.getItemMeta();
/*  522 */     customDS_snow.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
/*  523 */     customdiamondsword_snow.setItemMeta(customDS_snow);
/*      */     
/*  525 */     Kit SnowMan = new Kit(
/*  526 */         "SnowMan", 
/*  527 */         skull_snowman, 
/*  528 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  529 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  530 */         new ItemStack(Material.IRON_BOOTS), 
/*  531 */         customdiamondsword_snow, 
/*  532 */         Constantes.Vie_Global_Joueur, 
/*  533 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.SNOWBALL, 64), new ItemStack(Material.SNOWBALL, 64), new ItemStack(Material.SNOWBALL, 64), new ItemStack(Material.SNOWBALL, 64)
/*  534 */             })), null, 
/*  535 */         true, 
/*  536 */         new ItemStack(Material.SNOWBALL), 
/*  537 */         Arrays.asList(new String[] { "§bUne §p§e en fer\",\"§bUne armure en fer", "§dRedenvez un enfant et faites une bataille de boule de neige"
/*  538 */           }, ), "tnt.snowman");
/*  539 */     list_kits.add(SnowMan);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  544 */     ItemStack skull_tank = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTVlODYyMzFmNmU2OTBiZWFlOThhMDg3M2FjY2NkYzYwN2FjZDIyYzk2Y2Y0N2NiMzY3NDkyNzBkMWY0YmVlOSJ9fX0=", 
/*  545 */         Arrays.asList(new String[] { "test", "test"
/*  546 */           }, ), "test_autre");
/*      */     
/*  548 */     ItemStack customironsword_tank = new ItemStack(Material.STONE_SWORD, 1);
/*  549 */     ItemMeta customIS_tank = customironsword_tank.getItemMeta();
/*  550 */     customIS_tank.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  551 */     customironsword_tank.setItemMeta(customIS_tank);
/*      */     
/*  553 */     Kit Tank = new Kit(
/*  554 */         "Tank", 
/*  555 */         skull_tank, 
/*  556 */         new ItemStack(Material.DIAMOND_CHESTPLATE), 
/*  557 */         new ItemStack(Material.DIAMOND_LEGGINGS), 
/*  558 */         new ItemStack(Material.DIAMOND_BOOTS), 
/*  559 */         customironsword_tank, 
/*  560 */         Constantes.Vie_Global_Joueur, 
/*  561 */         null, 
/*  562 */         null, 
/*  563 */         true, 
/*  564 */         new ItemStack(Material.DIAMOND_CHESTPLATE), 
/*  565 */         Arrays.asList(new String[] { "§bArmure en diamand", "§bEpe en pierre", "§dCe kit n'est pas fait pour la ngociation.", "§dLancez vous dans le combat avec pour craser vos enemeies"
/*  566 */           }, ), "tnt.tank");
/*  567 */     list_kits.add(Tank);
/*      */ 
/*      */     
/*  570 */     ItemStack skull_archer = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjlkNTFhOTYzM2ZmZGNhNzExNjIxNzJhMWE4YTRmMmZkMjI1ZjE0Yjg4ZTMxOWIyYzA2M2NkOGQxMjY3Y2E3MCJ9fX0=", 
/*  571 */         Arrays.asList(new String[] { "test", "test"
/*  572 */           }, ), "test_autre");
/*      */     
/*  574 */     ItemStack custombow_archer = new ItemStack(Material.BOW, 1);
/*  575 */     ItemMeta customB_archer = custombow_archer.getItemMeta();
/*  576 */     customB_archer.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
/*  577 */     customB_archer.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
/*  578 */     custombow_archer.setItemMeta(customB_archer);
/*      */     
/*  580 */     ItemStack customstonesword_archer = new ItemStack(Material.STONE_SWORD, 1);
/*  581 */     ItemMeta customSW2_archer = customstonesword_archer.getItemMeta();
/*  582 */     customSW2_archer.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  583 */     customstonesword_archer.setItemMeta(customSW2_archer);
/*      */     
/*  585 */     Kit Archer = new Kit(
/*  586 */         "Archer", 
/*  587 */         skull_archer, 
/*  588 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  589 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  590 */         new ItemStack(Material.IRON_BOOTS), 
/*  591 */         customstonesword_archer, 
/*  592 */         Constantes.Vie_Global_Joueur, 
/*  593 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { custombow_archer, new ItemStack(Material.ARROW)
/*  594 */             }, )), null, 
/*  595 */         true, 
/*  596 */         new ItemStack(Material.BOW), 
/*  597 */         Arrays.asList(new String[] { "§bArc enchant", "§bArmure en maille", "§dLe kit archer est un soutien essentiel pour votre §quipe."
/*  598 */           }, ), "tnt.archer");
/*  599 */     list_kits.add(Archer);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  604 */     ItemStack skull_sorcier = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2FmY2NkMTk0ODUyZTUyMmU0Mjc3NjY5YTg0OTFlZjk2M2U3OTE4ZGY4M2JkOWVmMDE2ZGMzZTdmYmJmNDNmNyJ9fX0=", 
/*  605 */         Arrays.asList(new String[] { "test", "test"
/*  606 */           }, ), "test_autre");
/*      */     
/*  608 */     ItemStack customdiamondsword_sorcier = new ItemStack(Material.IRON_SWORD, 1);
/*  609 */     ItemMeta customDS_sorcier = customdiamondsword_sorcier.getItemMeta();
/*  610 */     customDS_sorcier.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  611 */     customdiamondsword_sorcier.setItemMeta(customDS_sorcier);
/*      */     
/*  613 */     ItemStack customblaze_sorcier = new ItemStack(Material.BLAZE_ROD, 1);
/*  614 */     ItemMeta customSSS_sorcier = customblaze_sorcier.getItemMeta();
/*  615 */     customSSS_sorcier.addEnchant(Enchantment.ARROW_INFINITE, 6, true);
/*  616 */     customSSS_sorcier.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
/*  617 */     customblaze_sorcier.setItemMeta(customSSS_sorcier);
/*      */     
/*  619 */     Kit Sorcier = new Kit(
/*  620 */         "Sorcier", 
/*  621 */         skull_sorcier, 
/*  622 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  623 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  624 */         new ItemStack(Material.IRON_BOOTS), 
/*  625 */         customdiamondsword_sorcier, 
/*  626 */         Constantes.Vie_Global_Joueur, 
/*  627 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { customblaze_sorcier
/*  628 */             }, )), null, 
/*  629 */         true, 
/*  630 */         new ItemStack(Material.BLAZE_ROD), 
/*  631 */         Arrays.asList(new String[] { "§bUne baguette magiue\",\"§bUne armure en fer", "§dDevenez un vrai magicien \",\"§dle temps d'une partie"
/*  632 */           }, ), "tnt.sorcier");
/*  633 */     list_kits.add(Sorcier);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  639 */     ItemStack customwoodsword_ghost = new ItemStack(Material.WOODEN_SWORD, 1);
/*  640 */     ItemMeta customWS_ghost = customwoodsword_ghost.getItemMeta();
/*  641 */     customWS_ghost.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
/*  642 */     customwoodsword_ghost.setItemMeta(customWS_ghost);
/*      */     
/*  644 */     Kit Ghost = new Kit(
/*  645 */         "Fantôme", 
/*  646 */         null, 
/*  647 */         null, 
/*  648 */         null, 
/*  649 */         null, 
/*  650 */         customwoodsword_ghost, 
/*  651 */         Constantes.Vie_Global_Joueur, 
/*  652 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.COOKED_BEEF, 64), new ItemStack(Material.COOKED_BEEF, 64)
/*  653 */             })), null, 
/*  654 */         false, 
/*  655 */         new ItemStack(Material.ENDER_EYE), 
/*  656 */         Arrays.asList(new String[] { "§bEpe en bois", "§bTotalement invisible", "§dLe kit Ghost vous rendra invisivle pour ", "§dinfiltrer les lignes enemies. Soyez discret et assasin."
/*  657 */           }, ), "tnt.ghost");
/*  658 */     list_kits.add(Ghost);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  663 */     ItemStack skull_healer = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjhiM2I0YjM3YjZhMDcxZGUxMzhhZTU0MDQ4MmQ5ODgxMzllMGNlOWFjYmY0OWRjMjFhMThkNmMyZTIwNDY1MSJ9fX0=", 
/*  664 */         Arrays.asList(new String[] { "test", "test"
/*  665 */           }, ), "test_autre");
/*      */     
/*  667 */     ItemStack customwoodsword_healer = new ItemStack(Material.IRON_SWORD, 1);
/*  668 */     ItemMeta customWS_healer = customwoodsword_healer.getItemMeta();
/*  669 */     customWS_healer.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  670 */     customwoodsword_healer.setItemMeta(customWS_healer);
/*      */     
/*  672 */     Kit Healer = new Kit(
/*  673 */         "Healer", 
/*  674 */         skull_healer, 
/*  675 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  676 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  677 */         new ItemStack(Material.IRON_BOOTS), 
/*  678 */         customwoodsword_healer, 
/*  679 */         Constantes.Vie_Global_Joueur, 
/*  680 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.GLISTERING_MELON_SLICE)
/*  681 */             }, )), null, 
/*  682 */         true, 
/*  683 */         new ItemStack(Material.GLISTERING_MELON_SLICE), 
/*  684 */         Arrays.asList(new String[] { "§bÉpée en pierre", "§bArmure maille", "§dLe kit des medecins, utilisez-le ", "§dpour soigner vos compagnons."
/*  685 */           }, ), "tnt.Healer");
/*  686 */     list_kits.add(Healer);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  691 */     ItemStack skull_pyro = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODY2NDhhMTQ3NDhhM2IwMGVmNjM5MWY2NjljYTE5YjhhOTFlYzJmMzFmNDNhOTljZGZmOWY3YjUxMTg2OWY2MiJ9fX0=", 
/*  692 */         Arrays.asList(new String[] { "test", "test"
/*  693 */           }, ), "test_autre");
/*      */     
/*  695 */     ItemStack customdiamondsword_pyro = new ItemStack(Material.IRON_SWORD, 1);
/*  696 */     ItemMeta customDS_pyro = customdiamondsword_pyro.getItemMeta();
/*      */     
/*  698 */     customDS_pyro.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
/*  699 */     customdiamondsword_pyro.setItemMeta(customDS_pyro);
/*  700 */     ItemStack custombow = new ItemStack(Material.BOW, 1);
/*  701 */     ItemMeta custombowW = custombow.getItemMeta();
/*      */     
/*  703 */     custombowW.addEnchant(Enchantment.ARROW_FIRE, 1, true);
/*  704 */     custombow.setItemMeta(custombowW);
/*      */     
/*  706 */     Kit Pyro = new Kit(
/*  707 */         "Pyro", 
/*  708 */         skull_pyro, 
/*  709 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  710 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  711 */         new ItemStack(Material.IRON_BOOTS), 
/*  712 */         customdiamondsword_pyro, 
/*  713 */         Constantes.Vie_Global_Joueur, 
/*  714 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { custombow
/*  715 */             }, )), null, 
/*  716 */         true, 
/*  717 */         new ItemStack(Material.FLINT_AND_STEEL), 
/*  718 */         Arrays.asList(new String[] { "§bEpee en pierre", "§bArmure fer", "§dPour les pyroman du dimanche "
/*  719 */           }, ), "tnt.pyro");
/*  720 */     list_kits.add(Pyro);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  725 */     ItemStack skull_builder = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjUzOTBlM2NjMWYwNzQ0MWU5ZGUxMzk4NDBkMDgyMTdmODYxODU3ZmY5OGY0MjExYzc5ZjNjMGI0ODYwZDgwZSJ9fX0=", 
/*  726 */         Arrays.asList(new String[] { "test", "test"
/*  727 */           }, ), "test_autre");
/*      */     
/*  729 */     ItemStack customdiamondsword_builder = new ItemStack(Material.IRON_SWORD, 1);
/*  730 */     ItemMeta customDS_builder = customdiamondsword_builder.getItemMeta();
/*  731 */     customDS_builder.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  732 */     customdiamondsword_builder.setItemMeta(customDS_builder);
/*      */     
/*  734 */     Kit Builder = new Kit(
/*  735 */         "Builder", 
/*  736 */         skull_builder, 
/*  737 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  738 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  739 */         new ItemStack(Material.IRON_BOOTS), 
/*  740 */         customdiamondsword_builder, 
/*  741 */         Constantes.Vie_Global_Joueur, 
/*  742 */         null, 
/*  743 */         null, 
/*  744 */         true, 
/*  745 */         new ItemStack(Material.SHEARS), 
/*  746 */         Arrays.asList(new String[] { "§bEpee en fer", "§bArmure fer", "§dCa manque de d§co ici! "
/*  747 */           }, ), "tnt.builder");
/*  748 */     list_kits.add(Builder);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  754 */     ItemStack skull_alchimiste = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2U3MWE2ZWIzMDNhYjdlNmY3MGVkNTRkZjkxNDZhODBlYWRmMzk2NDE3Y2VlOTQ5NTc3M2ZmYmViZmFkODg3YyJ9fX0=", 
/*  755 */         Arrays.asList(new String[] { "test", "test"
/*  756 */           }, ), "test_autre");
/*      */     
/*  758 */     ItemStack customdiamondsword_alchi = new ItemStack(Material.IRON_SWORD, 1);
/*  759 */     ItemMeta customDS_alchi = customdiamondsword_alchi.getItemMeta();
/*  760 */     customDS_alchi.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/*  761 */     customdiamondsword_alchi.setItemMeta(customDS_alchi);
/*      */     
/*  763 */     ItemStack is = new ItemStack(Material.POTION, 5);
/*  764 */     ItemMeta im = is.getItemMeta();
/*      */     
/*  766 */     PotionMeta pm22 = (PotionMeta)im;
/*  767 */     pm22.addCustomEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 4), true);
/*  768 */     pm22.addCustomEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 2), true);
/*  769 */     pm22.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1200, 2), true);
/*  770 */     pm22.addCustomEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1200, 2), true);
/*  771 */     is.setItemMeta((ItemMeta)pm2);
/*      */     
/*  773 */     Kit Alchimiste = new Kit(
/*  774 */         "Alchimiste", 
/*  775 */         skull_alchimiste, 
/*  776 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  777 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  778 */         new ItemStack(Material.IRON_BOOTS), 
/*  779 */         customdiamondsword_alchi, 
/*  780 */         Constantes.Vie_Global_Joueur, 
/*  781 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { is
/*  782 */             }, )), null, 
/*  783 */         true, 
/*  784 */         new ItemStack(Material.POTION), 
/*  785 */         Arrays.asList(new String[] { "§bEpee en fer", "§bArmure fer", "§dUn petit §lixir, Monseigneur? "
/*  786 */           }, ), "tnt.alchimiste");
/*  787 */     list_kits.add(Alchimiste);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  792 */     ItemStack skull_gandalf = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjcyMTRiZDQ3YjkwODhmNThhYjQyOTc5OGNmNDkyYjA1OTU3MTAxMzNlODkzMjNlZTNmMDQwNzA5OWI0YTUwNSJ9fX0=", 
/*  793 */         Arrays.asList(new String[] { "test", "test"
/*  794 */           }, ), "test_autre");
/*      */     
/*  796 */     ItemStack customdiamondsword_Gandalf = new ItemStack(Material.IRON_SWORD, 1);
/*  797 */     ItemMeta customDS_Gandalf = customdiamondsword_Gandalf.getItemMeta();
/*  798 */     customDS_Gandalf.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
/*  799 */     customdiamondsword_Gandalf.setItemMeta(customDS_Gandalf);
/*      */     
/*  801 */     ItemStack customblaze_Gandalf = new ItemStack(Material.STICK, 1);
/*  802 */     ItemMeta customSSS_Gandalf = customblaze_Gandalf.getItemMeta();
/*  803 */     customSSS_Gandalf.addEnchant(Enchantment.KNOCKBACK, 10, true);
/*  804 */     customblaze_Gandalf.setItemMeta(customSSS_Gandalf);
/*      */     
/*  806 */     Kit Gandalf = new Kit(
/*  807 */         "Gandalf", 
/*  808 */         skull_gandalf, 
/*  809 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  810 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  811 */         new ItemStack(Material.IRON_BOOTS), 
/*  812 */         customdiamondsword_Gandalf, 
/*  813 */         Constantes.Vie_Global_Joueur, 
/*  814 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { customblaze_Gandalf
/*  815 */             }, )), null, 
/*  816 */         true, 
/*  817 */         new ItemStack(Material.STICK), 
/*  818 */         Arrays.asList(new String[] { "§bUne baguette magique", "§bArmure fer", "§dVOUS NE PASSEREZ PAAAAAAAAAS "
/*  819 */           }, ), "tnt.gandalf");
/*  820 */     list_kits.add(Gandalf);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  825 */     ItemStack skull_shield = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTQ5NDg2Zjg2NTI0NTgzZTA2YTJjZmNkZjhlZDhlZjdlNzk1OTA1N2ZkMWRlMWVjZTcyZDQxZTI4Nzg4ZGMifX19", 
/*  826 */         Arrays.asList(new String[] { "test", "test"
/*  827 */           }, ), "test_autre");
/*      */     
/*  829 */     Kit Shield = new Kit(
/*  830 */         "ShieldMan", 
/*  831 */         skull_shield, 
/*  832 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  833 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  834 */         new ItemStack(Material.IRON_BOOTS), 
/*  835 */         new ItemStack(Material.IRON_SWORD), 
/*  836 */         Constantes.Vie_Global_Joueur, 
/*  837 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.SHIELD)
/*  838 */             }, )), null, 
/*  839 */         true, 
/*  840 */         new ItemStack(Material.SHIELD), 
/*  841 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/*  842 */           }, ), "tnt.shield");
/*  843 */     list_kits.add(Shield);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  849 */     ItemStack customArbalette = new ItemStack(Material.CROSSBOW, 1);
/*  850 */     ItemMeta customDS_Arbalette = customArbalette.getItemMeta();
/*  851 */     customDS_Arbalette.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
/*  852 */     customArbalette.setItemMeta(customDS_Arbalette);
/*      */     
/*  854 */     ItemStack skull_arbalette = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDgzMTgzMGE3YmQzYjFhYjA1YmViOThkYzJmOWZjNWVhNTUwYjNjZjY0OWZkOTRkNDgzZGE3Y2QzOWY3YzA2MyJ9fX0=", 
/*  855 */         Arrays.asList(new String[] { "test", "test"
/*  856 */           }, ), "test_autre");
/*      */     
/*  858 */     Kit Arbalette = new Kit(
/*  859 */         "Arbalette", 
/*  860 */         skull_arbalette, 
/*  861 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  862 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  863 */         new ItemStack(Material.IRON_BOOTS), 
/*  864 */         new ItemStack(Material.IRON_SWORD), 
/*  865 */         Constantes.Vie_Global_Joueur, 
/*  866 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { customArbalette, new ItemStack(Material.ARROW)
/*  867 */             }, )), null, 
/*  868 */         true, 
/*  869 */         new ItemStack(Material.CROSSBOW), 
/*  870 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/*  871 */           }, ), "tnt.arbalette");
/*  872 */     list_kits.add(Arbalette);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  877 */     ItemStack skull_ghast = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWQ3ZTk5ZTJlNDI3Yzk0ZjY2MmU2M2IxM2IyZTM2NzBjZjg5NGUzODc2NDc2YjIzYzgwZmM0MWJmZThhZTQ1YyJ9fX0=", 
/*  878 */         Arrays.asList(new String[] { "test", "test"
/*  879 */           }, ), "test_autre");
/*      */     
/*  881 */     Kit Ghast = new Kit(
/*  882 */         "Ghast", 
/*  883 */         skull_ghast, 
/*  884 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  885 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  886 */         new ItemStack(Material.IRON_BOOTS), 
/*  887 */         new ItemStack(Material.IRON_SWORD), 
/*  888 */         Constantes.Vie_Global_Joueur, 
/*  889 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.FIRE_CHARGE, 20)
/*  890 */             })), null, 
/*  891 */         true, 
/*  892 */         new ItemStack(Material.FIRE_CHARGE), 
/*  893 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/*  894 */           }, ), "tnt.ghast");
/*  895 */     list_kits.add(Ghast);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  901 */     ItemStack skull_shulker = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmUzM2ViZDEyYWU2ZGJmYTIzNDRkZjE2ZGE4ZmM2ZjM1OTdmZjQ4MDE3ZmJlMzgzYWJkMTY2OWNiZjU0NTYyZCJ9fX0=", 
/*  902 */         Arrays.asList(new String[] { "test", "test"
/*  903 */           }, ), "test_autre");
/*      */     
/*  905 */     Kit Shulker = new Kit(
/*  906 */         "Shulker", 
/*  907 */         skull_shulker, 
/*  908 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  909 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  910 */         new ItemStack(Material.IRON_BOOTS), 
/*  911 */         new ItemStack(Material.IRON_SWORD), 
/*  912 */         Constantes.Vie_Global_Joueur, 
/*  913 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.SHULKER_BOX)
/*  914 */             }, )), null, 
/*  915 */         true, 
/*  916 */         new ItemStack(Material.SHULKER_BOX), 
/*  917 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/*  918 */           }, ), "tnt.shulker");
/*  919 */     list_kits.add(Shulker);
/*      */ 
/*      */ 
/*      */     
/*  923 */     ItemStack skull_spider = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOTNjNDIwOGFlODA5ZDE2NmQyZjFlOWMzYjBiNDVjZDI4ODRjMWZiZDJlMTZiMDM4MjY2ZGRjODg5MGIwNjAzZSJ9fX0=", 
/*  924 */         Arrays.asList(new String[] { "test", "test"
/*  925 */           }, ), "test_autre");
/*      */     
/*  927 */     Kit Spider = new Kit(
/*  928 */         "Spider", 
/*  929 */         skull_spider, 
/*  930 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  931 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  932 */         new ItemStack(Material.IRON_BOOTS), 
/*  933 */         new ItemStack(Material.IRON_SWORD), 
/*  934 */         Constantes.Vie_Global_Joueur, 
/*  935 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.COBWEB)
/*  936 */             }, )), null, 
/*  937 */         true, 
/*  938 */         new ItemStack(Material.COBWEB), 
/*  939 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/*  940 */           }, ), "tnt.spider");
/*  941 */     list_kits.add(Spider);
/*      */ 
/*      */ 
/*      */     
/*  945 */     ItemStack skull_wither = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvM2E1Nzc1ZWFiYmJmODFmOGE5ZTNmYjE0MGZiN2RjYjBlNjhjNWIyZDAyZTEwYjEwNDM1NjQxMjU0OTRmMWEyZiJ9fX0=", 
/*  946 */         Arrays.asList(new String[] { "test", "test"
/*  947 */           }, ), "test_autre");
/*      */     
/*  949 */     Kit Wither = new Kit(
/*  950 */         "Wither", 
/*  951 */         skull_wither, 
/*  952 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  953 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  954 */         new ItemStack(Material.IRON_BOOTS), 
/*  955 */         new ItemStack(Material.IRON_SWORD), 
/*  956 */         Constantes.Vie_Global_Joueur, 
/*  957 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.WITHER_ROSE)
/*  958 */             }, )), null, 
/*  959 */         true, 
/*  960 */         new ItemStack(Material.WITHER_SKELETON_SKULL), 
/*  961 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/*  962 */           }, ), "tnt.wither");
/*  963 */     list_kits.add(Wither);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  970 */     ItemStack customblaze_PandaMan = new ItemStack(Material.BAMBOO, 1);
/*  971 */     ItemMeta customSSS_PandaMan = customblaze_PandaMan.getItemMeta();
/*  972 */     customSSS_PandaMan.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
/*  973 */     customblaze_PandaMan.setItemMeta(customSSS_PandaMan);
/*      */     
/*  975 */     ItemStack skull_panda = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzRlOTk5NGQ5NzkyMTJmN2JhOTNmNDFkOWI5YTk3YmI4ODY4ODE0OWU3NmMyMmZiNWNhODNjOTE1OTI5YTFlNiJ9fX0=", 
/*  976 */         Arrays.asList(new String[] { "test", "test"
/*  977 */           }, ), "test_autre");
/*      */     
/*  979 */     Kit PandaMan = new Kit(
/*  980 */         "PandaMan", 
/*  981 */         skull_panda, 
/*  982 */         new ItemStack(Material.IRON_CHESTPLATE), 
/*  983 */         new ItemStack(Material.IRON_LEGGINGS), 
/*  984 */         new ItemStack(Material.IRON_BOOTS), 
/*  985 */         customblaze_PandaMan, 
/*  986 */         Constantes.Vie_Global_Joueur, 
/*  987 */         null, 
/*  988 */         null, 
/*  989 */         true, 
/*  990 */         new ItemStack(Material.BAMBOO), 
/*  991 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/*  992 */           }, ), "tnt.pandaman");
/*  993 */     list_kits.add(PandaMan);
/*      */ 
/*      */ 
/*      */     
/*  997 */     ItemStack skull_poison = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjA1MDNiODFhYzAyMGM2N2MzNzc4N2I0NWM5YTI2MjIzZjliYzI2YmNhMjdmODFhZjMyZjJjZjU1ZTI0NDBiNyJ9fX0=", 
/*  998 */         Arrays.asList(new String[] { "test", "test"
/*  999 */           }, ), "test_autre");
/*      */     
/* 1001 */     Kit Poison = new Kit(
/* 1002 */         "Poison", 
/* 1003 */         skull_poison, 
/* 1004 */         new ItemStack(Material.IRON_CHESTPLATE), 
/* 1005 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1006 */         new ItemStack(Material.IRON_BOOTS), 
/* 1007 */         new ItemStack(Material.IRON_SWORD), 
/* 1008 */         Constantes.Vie_Global_Joueur, 
/* 1009 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.CRIMSON_FUNGUS)
/* 1010 */             }, )), null, 
/* 1011 */         true, 
/* 1012 */         new ItemStack(Material.CRIMSON_FUNGUS), 
/* 1013 */         Arrays.asList(new String[] { "b§test\",\"§btest\",\"§dtest"
/* 1014 */           }, ), "tnt.poison");
/* 1015 */     list_kits.add(Poison);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1021 */     ItemStack customblaze_Pecheur = new ItemStack(Material.TROPICAL_FISH, 1);
/* 1022 */     ItemMeta customSSS_Pecheur = customblaze_Pecheur.getItemMeta();
/* 1023 */     customSSS_Pecheur.addEnchant(Enchantment.DAMAGE_ALL, 6, true);
/* 1024 */     customblaze_Pecheur.setItemMeta(customSSS_Pecheur);
/*      */     
/* 1026 */     ItemStack skull_pecheur = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjkyMzUwYzlmMDk5M2VkNTRkYjJjNzExMzkzNjMyNTY4M2ZmYzIwMTA0YTliNjIyYWE0NTdkMzdlNzA4ZDkzMSJ9fX0=", 
/* 1027 */         Arrays.asList(new String[] { "test", "test"
/* 1028 */           }, ), "test_autre");
/*      */     
/* 1030 */     Kit Pecheur = new Kit(
/* 1031 */         "Pecheur", 
/* 1032 */         skull_pecheur, 
/* 1033 */         new ItemStack(Material.IRON_CHESTPLATE), 
/* 1034 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1035 */         new ItemStack(Material.IRON_BOOTS), 
/* 1036 */         customblaze_Pecheur, 
/* 1037 */         Constantes.Vie_Global_Joueur, 
/* 1038 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.FISHING_ROD), new ItemStack(Material.PUFFERFISH)
/* 1039 */             }, )), null, 
/* 1040 */         true, 
/* 1041 */         new ItemStack(Material.FISHING_ROD), 
/* 1042 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1043 */           }, ), "tnt.pecheur");
/* 1044 */     list_kits.add(Pecheur);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1051 */     ItemStack skull_rocketman = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjBkZGNiN2EwNjFmNTU1Njk2MmQwZWVmZGVhZTQ4OGQwNDZkYjNhYWJjZTYyMTRmNDA0MjRmNTgyYzY1Y2MwNSJ9fX0=", 
/* 1052 */         Arrays.asList(new String[] { "test", "test"
/* 1053 */           }, ), "test_autre");
/*      */     
/* 1055 */     Kit Rocketman = new Kit(
/* 1056 */         "Rocketman", 
/* 1057 */         skull_rocketman, 
/* 1058 */         new ItemStack(Material.IRON_CHESTPLATE), 
/* 1059 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1060 */         new ItemStack(Material.IRON_BOOTS), 
/* 1061 */         new ItemStack(Material.IRON_SWORD), 
/* 1062 */         Constantes.Vie_Global_Joueur, 
/* 1063 */         null, 
/* 1064 */         null, 
/* 1065 */         true, 
/* 1066 */         new ItemStack(Material.FIREWORK_ROCKET), 
/* 1067 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1068 */           }, ), "tnt.rocketman");
/* 1069 */     list_kits.add(Rocketman);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1074 */     ItemStack skull_blaze = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjIwNjU3ZTI0YjU2ZTFiMmY4ZmMyMTlkYTFkZTc4OGMwYzI0ZjM2Mzg4YjFhNDA5ZDBjZDJkOGRiYTQ0YWEzYiJ9fX0=", 
/* 1075 */         Arrays.asList(new String[] { "test", "test"
/* 1076 */           }, ), "test_autre");
/*      */     
/* 1078 */     Kit Blaze = new Kit(
/* 1079 */         "Blaze", 
/* 1080 */         skull_blaze, 
/* 1081 */         new ItemStack(Material.IRON_CHESTPLATE), 
/* 1082 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1083 */         new ItemStack(Material.IRON_BOOTS), 
/* 1084 */         new ItemStack(Material.IRON_SWORD), 
/* 1085 */         Constantes.Vie_Global_Joueur, 
/* 1086 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.BLAZE_ROD)
/* 1087 */             }, )), null, 
/* 1088 */         true, 
/* 1089 */         new ItemStack(Material.BLAZE_ROD), 
/* 1090 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1091 */           }, ), "tnt.blaze");
/* 1092 */     list_kits.add(Blaze);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1098 */     ItemStack skull_evocateur = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzJmYjgwYTZiNjgzM2UzMWQ5Y2U4MzEzYTU0Nzc3NjQ1ZjljMWU1NWI4MTA5MThhNzA2ZTdiY2M4ZDM1YTVhMiJ9fX0=", 
/* 1099 */         Arrays.asList(new String[] { "test", "test"
/* 1100 */           }, ), "test_autre");
/*      */     
/* 1102 */     Kit Evocateur = new Kit(
/* 1103 */         "Evocateur", 
/* 1104 */         skull_evocateur, 
/* 1105 */         new ItemStack(Material.LEATHER_CHESTPLATE), 
/* 1106 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1107 */         new ItemStack(Material.IRON_BOOTS), 
/* 1108 */         new ItemStack(Material.NETHERITE_AXE), 
/* 1109 */         Constantes.Vie_Global_Joueur, 
/* 1110 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { new ItemStack(Material.NETHER_BRICK)
/* 1111 */             }, )), null, 
/* 1112 */         true, 
/* 1113 */         new ItemStack(Material.END_ROD), 
/* 1114 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1115 */           }, ), "tnt.evocateur");
/* 1116 */     list_kits.add(Evocateur);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1123 */     ItemStack custombow_archer2 = new ItemStack(Material.BOW, 1);
/* 1124 */     ItemMeta customB_archer2 = custombow_archer2.getItemMeta();
/* 1125 */     customB_archer2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
/* 1126 */     customB_archer2.addEnchant(Enchantment.ARROW_KNOCKBACK, 2, true);
/* 1127 */     custombow_archer2.setItemMeta(customB_archer2);
/*      */     
/* 1129 */     ItemStack customstonesword_archer2 = new ItemStack(Material.STONE_SWORD, 1);
/* 1130 */     ItemMeta customSW2_archer2 = customstonesword_archer2.getItemMeta();
/* 1131 */     customSW2_archer2.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
/* 1132 */     customstonesword_archer2.setItemMeta(customSW2_archer2);
/*      */     
/* 1134 */     ItemStack skull_archer2 = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTdmMTVlMmRkZGE1YzRiNjU0MzUzZmUwMjMwZmFhNGU5NjI1MGZkYzI4MDlhODQ5ZTFmZmQwMjBmYzdlM2ZhMyJ9fX0=", 
/* 1135 */         Arrays.asList(new String[] { "test", "test"
/* 1136 */           }, ), "test_autre");
/*      */     
/* 1138 */     Kit Archer2 = new Kit(
/* 1139 */         "Archer 2", 
/* 1140 */         skull_archer2, 
/* 1141 */         new ItemStack(Material.IRON_CHESTPLATE), 
/* 1142 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1143 */         new ItemStack(Material.IRON_BOOTS), 
/* 1144 */         customstonesword_archer2, 
/* 1145 */         Constantes.Vie_Global_Joueur, 
/* 1146 */         new ArrayList(Arrays.asList((Object[])new ItemStack[] { custombow_archer2, new ItemStack(Material.ARROW)
/* 1147 */             }, )), null, 
/* 1148 */         true, 
/* 1149 */         new ItemStack(Material.ARROW), 
/* 1150 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1151 */           }, ), "tnt.archer2");
/* 1152 */     list_kits.add(Archer2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1158 */     ItemStack skull_tacticien = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWE1NTQyOTY1YTIwNWJiNjY0NTY2MzRmNzhmMmY0M2U0NDdlNjY1ZTY1NTAyYjJhNDU3MmI1YWNmZmIzYWM5In19fQ==", 
/* 1159 */         Arrays.asList(new String[] { "test", "test"
/* 1160 */           }, ), "test_autre");
/*      */     
/* 1162 */     Kit Tacticien = new Kit(
/* 1163 */         "Tacticien", 
/* 1164 */         skull_tacticien, 
/* 1165 */         new ItemStack(Material.IRON_CHESTPLATE), 
/* 1166 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1167 */         new ItemStack(Material.IRON_BOOTS), 
/* 1168 */         new ItemStack(Material.IRON_SWORD), 
/* 1169 */         Constantes.Vie_Global_Joueur, 
/* 1170 */         null, 
/* 1171 */         null, 
/* 1172 */         true, 
/* 1173 */         new ItemStack(Material.WHITE_GLAZED_TERRACOTTA), 
/* 1174 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1175 */           }, ), "tnt.tacticien");
/* 1176 */     list_kits.add(Tacticien);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1182 */     ItemStack skull_teleporteur = PlayerHead.customPlayerHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZjg3YTk1MzZiNmI0NWJmYWU1ZGNjZTYzM2QxODQ3NGNmMjAwZTJmY2U4NDQ3ODI3YWRjMjFjNTZkZDhhMDVmYiJ9fX0=", 
/* 1183 */         Arrays.asList(new String[] { "test", "test"
/* 1184 */           }, ), "test_autre");
/*      */     
/* 1186 */     Kit Teleporteur = new Kit(
/* 1187 */         "Teleporteur", 
/* 1188 */         skull_teleporteur, 
/* 1189 */         new ItemStack(Material.IRON_CHESTPLATE), 
/* 1190 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1191 */         new ItemStack(Material.IRON_BOOTS), 
/* 1192 */         new ItemStack(Material.IRON_SWORD), 
/* 1193 */         Constantes.Vie_Global_Joueur, 
/* 1194 */         null, 
/* 1195 */         null, 
/* 1196 */         true, 
/* 1197 */         new ItemStack(Material.CLOCK), 
/* 1198 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1199 */           }, ), "tnt.teleporteur");
/* 1200 */     list_kits.add(Teleporteur);
/*      */ 
/*      */ 
/*      */     
/* 1204 */     Kit Spy = new Kit(
/* 1205 */         "Spy", 
/* 1206 */         new ItemStack(Material.IRON_HELMET), 
/* 1207 */         new ItemStack(Material.IRON_CHESTPLATE), 
/* 1208 */         new ItemStack(Material.IRON_LEGGINGS), 
/* 1209 */         new ItemStack(Material.IRON_BOOTS), 
/* 1210 */         new ItemStack(Material.IRON_SWORD), 
/* 1211 */         Constantes.Vie_Global_Joueur, 
/* 1212 */         null, 
/* 1213 */         null, 
/* 1214 */         true, 
/* 1215 */         new ItemStack(Material.BEACON), 
/* 1216 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1217 */           }, ), "tnt.spy");
/* 1218 */     list_kits.add(Spy);
/*      */ 
/*      */     
/* 1221 */     Kit Hasard = new Kit(
/* 1222 */         "Hasard", 
/* 1223 */         null, 
/* 1224 */         null, 
/* 1225 */         null, 
/* 1226 */         null, 
/* 1227 */         null, 
/* 1228 */         Constantes.Vie_Global_Joueur, 
/* 1229 */         null, 
/* 1230 */         null, 
/* 1231 */         true, 
/* 1232 */         new ItemStack(Material.HEART_OF_THE_SEA), 
/* 1233 */         Arrays.asList(new String[] { "btest\",\"btest\",\"dtest"
/* 1234 */           }, ), "tnt.hasard");
/* 1235 */     list_kits.add(Hasard);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1240 */     return list_kits;
/*      */   }
/*      */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\Fonctions\CreateKit.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */