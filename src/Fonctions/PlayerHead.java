 package Fonctions;
 
 import java.util.ArrayList;
 import java.util.List;
 import org.bukkit.Bukkit;
 import org.bukkit.Material;
 import org.bukkit.inventory.ItemStack;
 import org.bukkit.inventory.meta.ItemMeta;
 
 
 
 
 
 
 
 public class PlayerHead
 {
   public static ItemStack customPlayerHead(String skin, List<String> lore, String name) {
     if (lore == null)
       lore = new ArrayList<>(); 
     ItemStack head = new ItemStack(Material.PLAYER_HEAD);
     
     head = Bukkit.getUnsafe().modifyItemStack(head, "{display:{Name:\"{\\\"text\\\":\\\"Pumpkin Bowl\\\"}\"},SkullOwner:{Id:[I;1201296705,1414024019,-1385893868,1321399054],Properties:{textures:[{Value:\"" + skin + "\"}]}}}");
 
 
     
     ItemMeta meta = head.getItemMeta();
     meta.setDisplayName(name);
     meta.setLore(lore);
     head.setItemMeta(meta);
     return head;
   }
 }

