package me.sword7.playerplot.plotdeed;

import me.sword7.playerplot.config.Language;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;
import java.util.List;

public class PlotDeed {

    private static String plotDeedLoreID = ChatColor.DARK_GRAY + Language.MISC_PLOT_DEED_LORE.toString();

    private ItemStack itemStack;

    public PlotDeed(int customModelData, String title) {
        this.itemStack = buildItemStack(customModelData, title);
    }

    private ItemStack buildItemStack(int customModelData, String title) {
        ItemStack plotDeed = new ItemStack(Material.PAPER);
        ItemMeta meta = plotDeed.getItemMeta();
        meta.setDisplayName(title);
        List<String> lore = new ArrayList<>();
        lore.add(plotDeedLoreID);
        lore.add(ChatColor.RED + Language.MISC_ONE_USE.toString());
        lore.add(ChatColor.GRAY + "+1 " + Language.ARG_PLOT);
        meta.setLore(lore);
        meta.setCustomModelData(customModelData);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        plotDeed.setItemMeta(meta);
        return plotDeed;
    }

    public ItemStack getItemStack() {
        return itemStack.clone();
    }

    public ItemStack getItemStack(int amount) {
        ItemStack itemStack = this.itemStack.clone();
        itemStack.setAmount(amount);
        return itemStack;
    }

    public static boolean isPlotDeed(ItemStack itemStack) {
        if (hasLoreId(itemStack)) {
            return plotDeedLoreID.equals(getLoreId(itemStack));
        } else {
            return false;
        }
    }

    public static boolean hasLoreId(ItemStack itemStack) {
        return (itemStack != null
                && itemStack.hasItemMeta()
                && itemStack.getItemMeta().hasLore()
                && itemStack.getItemMeta().getLore().size() > 0
                && itemStack.getItemMeta().getLore().get(0) != null);
    }

    public static String getLoreId(ItemStack itemStack) {
        return itemStack.getItemMeta().getLore().get(0);
    }

}
