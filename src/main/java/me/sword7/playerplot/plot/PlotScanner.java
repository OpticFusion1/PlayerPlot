package me.sword7.playerplot.plot;

import me.sword7.playerplot.PlayerPlot;
import me.sword7.playerplot.util.Scheduler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import me.sword7.playerplot.util.border.Border;

public class PlotScanner implements Listener {

    private static Map<UUID, UUID> playerToScanner = new HashMap<>();

    public PlotScanner() {
        Plugin plugin = PlayerPlot.getPlugin();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPunch(PlayerInteractEvent e) {
        Action action = e.getAction();
        if (action == Action.LEFT_CLICK_BLOCK || action == Action.LEFT_CLICK_AIR) {
            Player player = e.getPlayer();
            UUID playerId = player.getUniqueId();
            if (Border.hasBorder(playerId) && playerToScanner.containsKey(playerId)) {
                UUID bId = playerToScanner.get(playerId);
                Border.hide(player, bId);
            }
        }
    }

    public static void showPlot(Player player, Plot plot, int durationSec) {
        if (plot.contains(player.getLocation())) {
            UUID playerID = player.getUniqueId();
            final UUID bId = Border.showPlot(player, plot);
            playerToScanner.put(playerID, bId);
            Scheduler.runLater(() -> {
                Border.hide(player, bId);
            }, 20 * durationSec);
        }
    }

}
