package com.eclipsekingdom.playerplot.admin;

import com.eclipsekingdom.playerplot.plot.Plot;
import com.eclipsekingdom.playerplot.plot.PlotCache;
import com.eclipsekingdom.playerplot.config.Language;
import com.eclipsekingdom.playerplot.config.Permissions;
import com.eclipsekingdom.playerplot.config.Version;
import com.eclipsekingdom.playerplot.util.Scheduler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CommandDelPlot implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (Permissions.canDeletePlots(player)) {
                Plot plot = PlotCache.getPlot(player.getLocation());
                if (plot != null) {
                    DeleteRequests.Request request = DeleteRequests.add(player, plot);
                    UUID requestId = request.getId();
                    if (Version.hasBungeeChat()) {
                        player.spigot().sendMessage(Language.INFO_CONFIRM_DELETE.getWithPlayerConfirmDeny(ChatColor.LIGHT_PURPLE, ChatColor.DARK_PURPLE, plot.getOwnerName(), "/delplotconfirm", "/delplotcancel"));
                    } else {
                        player.sendMessage(Language.INFO_CONFIRM_DELETE_LEGACY.coloredFromPlayer(plot.getOwnerName(), ChatColor.LIGHT_PURPLE, ChatColor.DARK_PURPLE));
                        player.sendMessage(ChatColor.GRAY + Language.INFO_CONFIRM_DELETE_LEGACY_TIP.toString()
                                .replaceAll("\\[confirm\\]", ChatColor.GREEN + "/delplotconfirm" + ChatColor.GRAY)
                                .replaceAll("\\[cancel\\]", ChatColor.RED + "/delplotcancel" + ChatColor.GRAY));
                    }
                    player.sendMessage(ChatColor.GRAY + Language.INFO_REQUEST_DURATION.fromSeconds(25));
                    Scheduler.runLater(() -> {
                        if (DeleteRequests.hasPending(player)) {
                            DeleteRequests.Request currentRequest = DeleteRequests.getPending(player);
                            if (currentRequest.getId().equals(requestId)) {
                                DeleteRequests.remove(player);
                            }
                        }
                    }, 20 * 25);
                } else {
                    player.sendMessage(ChatColor.RED + Language.WARN_NOT_STANDING_IN_PLOT.toString());
                }
            } else {
                player.sendMessage(ChatColor.RED + Language.WARN_NOT_PERMITTED.toString());
            }
        }
        return false;

    }

}
