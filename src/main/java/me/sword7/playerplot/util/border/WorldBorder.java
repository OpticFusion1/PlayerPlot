package me.sword7.playerplot.util.border;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class WorldBorder {

    public void show(Player player, World world, double x, double z, double size) {
        org.bukkit.WorldBorder worldBorder = Bukkit.createWorldBorder();
        worldBorder.setCenter(x, z);
        worldBorder.setSize(size);
        worldBorder.setDamageAmount(0);
        worldBorder.setWarningDistance(0);
        player.setWorldBorder(worldBorder);
    }

    public void hide(Player player, World world) {
        player.setWorldBorder(null);
    }
}
