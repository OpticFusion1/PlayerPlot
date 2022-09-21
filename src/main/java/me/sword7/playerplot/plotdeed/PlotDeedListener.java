package me.sword7.playerplot.plotdeed;

import me.sword7.playerplot.PlayerPlot;
import me.sword7.playerplot.config.PluginConfig;
import me.sword7.playerplot.user.UserCache;
import me.sword7.playerplot.user.UserData;
import me.sword7.playerplot.util.PermInfo;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

import static me.sword7.playerplot.config.Language.WARN_PLOT_MAX;
import org.bukkit.Sound;

public class PlotDeedListener implements Listener {

    public PlotDeedListener() {
        Plugin plugin = PlayerPlot.getPlugin();
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR) {
            ItemStack itemStack = e.getItem();
            if (PlotDeed.isPlotDeed(itemStack)) {
                e.setCancelled(true);
                Player player = e.getPlayer();
                UUID playerID = player.getUniqueId();
                if (UserCache.hasData(playerID)) {
                    UserData userData = UserCache.getData(playerID);
                    PermInfo permInfo = UserCache.getPerms(playerID);
                    int availablePlots = PluginConfig.getStartingPlotNum() + userData.getUnlockedPlots() + permInfo.getPlotBonus();
                    if ((availablePlots < permInfo.getPlotMax())) {
                        userData.unlockPlot();
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "+1 plot");
                        player.playSound(player.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 2f, 1f);
                        itemStack.setAmount(itemStack.getAmount() - 1);
                    } else {
                        player.sendMessage(ChatColor.RED + WARN_PLOT_MAX.toString());
                    }
                }
            }
        }
    }

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        for (ItemStack itemStack : e.getInventory()) {
            if (PlotDeed.isPlotDeed(itemStack)) {
                e.setCancelled(true);
                return;
            }
        }
    }

    @EventHandler
    public void onPrepareCraft(PrepareItemCraftEvent e) {
        for (ItemStack itemStack : e.getInventory()) {
            if (PlotDeed.isPlotDeed(itemStack)) {
                e.getInventory().setItem(0, new ItemStack(Material.AIR, 1));
                return;
            }
        }
    }

}
