package me.sword7.playerplot.plot;

import me.sword7.playerplot.config.Language;
import me.sword7.playerplot.config.Permissions;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandToPlot implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (Permissions.canTeleport(sender)) {
                if (args.length > 0) {
                    Plot targetPlot = PlotCache.getPlayerPlot(player.getUniqueId(), args[0]);
                    if (targetPlot != null) {
                        Location targetLoc = targetPlot.getSpawn();
                        if (targetLoc != null) {
                            new PlotBeam(player, targetLoc);
                        } else {
                            player.sendMessage(Language.WARN_PLOT_NOT_FOUND.coloredFromPlot(args[0], ChatColor.RED, ChatColor.DARK_RED));
                        }
                    } else {
                        player.sendMessage(Language.WARN_PLOT_NOT_FOUND.coloredFromPlot(args[0], ChatColor.RED, ChatColor.DARK_RED));
                    }
                } else {
                    player.sendMessage(ChatColor.RED + Language.MISC_FORMAT.fromFormat("/toplot [" + Language.ARG_PLOT + "]"));
                }
            } else {
                player.sendMessage(ChatColor.RED + Language.WARN_NOT_PERMITTED.toString());
            }
        }
        return false;
    }

}
