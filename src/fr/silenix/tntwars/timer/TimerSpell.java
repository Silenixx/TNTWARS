package fr.silenix.tntwars.timer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class TimerSpell extends BukkitRunnable {
	//private GMain main;
	//private int timer = 10;
	private Snowball snowball;
	private Player player;

	public TimerSpell(/*GMain main,*/ Snowball snowball, Player player) {
		//this.main = main;
		this.snowball = snowball;
		this.player = player;
	}

	public void run() {

		// s.getWorld().playEffect(s.getLocation(), Effect.HEART, 10);
		// player.sendMessage("" +
		// snowball.getLocation().distance(player.getLocation()));

		Bukkit.getWorld("world").spawnParticle(Particle.GLOW_SQUID_INK, snowball.getLocation(), 20, 0.05D, 0.05D,
				0.05D);
		Bukkit.getWorld("world").spawnParticle(Particle.GLOW_SQUID_INK, snowball.getLocation(), 20, 0.05D, 0.05D,
				0.05D);
		Bukkit.getWorld("world").spawnParticle(Particle.GLOW_SQUID_INK, snowball.getLocation(), 20, 0.05D, 0.05D,
				0.05D);

		if (snowball.isOnGround() || snowball.isDead() || snowball.isInWater()
				|| snowball.getLocation().distance(player.getLocation()) > 80) {
			snowball.remove();
			player.getInventory().addItem(new ItemStack(Material.HEART_OF_THE_SEA));
			cancel();
		}

	}
}
