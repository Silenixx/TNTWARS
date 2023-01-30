package Command;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.silenix.tntwars.GMain;

public class CommandEliminate implements CommandExecutor {

	private GMain main;

	public CommandEliminate(GMain main) {
		this.main = main;
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player_sender = (Player) sender;

		if (sender instanceof Player) {
			if (label.equalsIgnoreCase("eliminate")) {

				Player player_cible = Bukkit.getOnlinePlayers().stream().filter(p -> p.getName().equals(args[0]))
						.findFirst().get();

				player_sender.sendMessage(args[0]);

				main.eliminate(player_cible);

			}
		}

		return false;
	}

}