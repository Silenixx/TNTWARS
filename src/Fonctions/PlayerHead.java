/*    */ package Fonctions;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlayerHead
/*    */ {
/*    */   public static ItemStack customPlayerHead(String skin, List<String> lore, String name) {
/* 19 */     if (lore == null)
/* 20 */       lore = new ArrayList<>(); 
/* 21 */     ItemStack head = new ItemStack(Material.PLAYER_HEAD);
/*    */     
/* 23 */     head = Bukkit.getUnsafe().modifyItemStack(head, "{display:{Name:\"{\\\"text\\\":\\\"Pumpkin Bowl\\\"}\"},SkullOwner:{Id:[I;1201296705,1414024019,-1385893868,1321399054],Properties:{textures:[{Value:\"" + skin + "\"}]}}}");
/*    */ 
/*    */ 
/*    */     
/* 27 */     ItemMeta meta = head.getItemMeta();
/* 28 */     meta.setDisplayName(name);
/* 29 */     meta.setLore(lore);
/* 30 */     head.setItemMeta(meta);
/* 31 */     return head;
/*    */   }
/*    */ }


/* Location:              C:\Users\Lukas\Desktop\plugin export\tntwars.jar!\Fonctions\PlayerHead.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */