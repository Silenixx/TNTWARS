package fr.silenix.tntwars.timer;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import Enum.EtatTNT;
import fr.silenix.tntwars.GMain;

public class TimerScoreboard extends BukkitRunnable{


	private GMain main;
	

	
	
	
	
	public TimerScoreboard(GMain main) {
		this.main = main;
	}
	
	

	

	@Override
	public void run() {
		
		
		if (main.listeConnecte.size()!=0) {
			main.connecter_score = Bukkit.getOnlinePlayers().size();
			main.cblue = main.tnt_bleu.getVie() *2;
			main.cred = main.tnt_rouge.getVie() *2;
			main.timeblue = main.timer_blue;
			main.timered = main.timer_red;
			
			
			main.taille_blue = main.getSize("Bleu");
			main.taille_red = main.getSize("Rouge");
			
			
			
			
			
			
			if (Bukkit.getOnlinePlayers().size() == 0) {
	            main.onlineCounter.setSuffix(ChatColor.AQUA + "0");
	        } else {
	        	main.onlineCounter.setSuffix("" + ChatColor.GRAY+ main.connecter_score + "  (" + ChatColor.BLUE+main.taille_blue+ ChatColor.GRAY+"|"+ChatColor.RED+main.taille_red+ ChatColor.GRAY+")");
	        }
			
			
			
			if (main.tnt_rouge.getEtat()==EtatTNT.Eteinte) {
				main.boardred.setSuffix(""+ ChatColor.RED + main.cred + ChatColor.RED + "%" );
			}
			if(main.tnt_rouge.getEtat()==EtatTNT.Allume) {
				main.boardred.setSuffix(""+ ChatColor.RED + main.cred + ChatColor.RED + "%    " + ChatColor.RED + main.timered + ChatColor.RED + "s" );
			}
			
			
			
			if (main.tnt_bleu.getEtat()==EtatTNT.Eteinte) {
				main.boardblue.setSuffix(""+ ChatColor.BLUE + main.cblue + ChatColor.BLUE + "%" );
			}
			if(main.tnt_bleu.getEtat()==EtatTNT.Allume) {
				main.boardblue.setSuffix(""+ ChatColor.BLUE + main.cblue + ChatColor.BLUE + "%    " + ChatColor.BLUE + main.timeblue + ChatColor.BLUE + "s" );
			}
		}
		
		
		
	}
}