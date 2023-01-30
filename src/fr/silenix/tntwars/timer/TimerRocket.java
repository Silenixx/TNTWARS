package fr.silenix.tntwars.timer;

import java.util.Random;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Player;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.scheduler.BukkitRunnable;

import fr.silenix.tntwars.GMain;

public class TimerRocket extends BukkitRunnable {
	private GMain main;
	private int timer = 2;

	private Player player;

	public TimerRocket(GMain main, Player player) {
		this.main = main;

		this.player = player;
	}

	public void run() {

		if (this.timer == 0) {
			player.getInventory().addItem(new ItemStack(Material.HEART_OF_THE_SEA));
			ItemStack loadedCrossbow = new ItemStack(Material.CROSSBOW, 1);
			CrossbowMeta meta = (CrossbowMeta) loadedCrossbow.getItemMeta();

			ItemStack rocket = new ItemStack(Material.FIREWORK_ROCKET);
			FireworkMeta metarocket = (FireworkMeta) rocket.getItemMeta();
			metarocket.setPower(4);

			Random chance = new Random();
			Type type = Type.BALL_LARGE;
			if (chance.nextInt(100) < 50) {
				type = Type.BALL;
			}

			FireworkEffect effect = FireworkEffect.builder().with(type)
					.withColor(Color.fromRGB(chance.nextInt(255), chance.nextInt(255), chance.nextInt(255)))
					.flicker(chance.nextBoolean()).trail(chance.nextBoolean()).build();
			metarocket.addEffect(effect);

			rocket.setItemMeta(metarocket);

			meta.addChargedProjectile(new ItemStack(rocket));

			loadedCrossbow.setItemMeta(meta);
			player.getInventory().remove(Material.CROSSBOW);
			player.getInventory().addItem(loadedCrossbow);

			cancel();
		}

		this.timer--;
	}

}
