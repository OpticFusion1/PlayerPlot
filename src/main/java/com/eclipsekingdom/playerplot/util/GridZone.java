package com.eclipsekingdom.playerplot.util;

import com.eclipsekingdom.playerplot.config.PluginConfig;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;

public class GridZone {

    private static int gridGroupAmount = PluginConfig.getPlotUnitSideLength() * 16;
    private int x;
    private int z;

    public GridZone(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public static final GridZone fromLocation(Location location) {
        return GridZone.from(location.getBlockX(), location.getBlockZ());
    }

    public static final GridZone fromPlotPoint(PlotPoint plotPoint) {
        return GridZone.from(plotPoint.getX(), plotPoint.getZ());
    }

    public static final GridZone from(int blockX, int blockZ) {

        int offsetX = blockX < 0 ? -1 : 0;
        int x = (blockX / gridGroupAmount) + offsetX;

        int offsetZ = blockZ < 0 ? -1 : 0;
        int z = (blockZ / gridGroupAmount) + offsetZ;

        return new GridZone(x, z);
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof GridZone) {
            GridZone gridZone = (GridZone) o;
            return (this.x == gridZone.x && this.z == gridZone.z);
        } else {
            return super.equals(o);
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).append(x).append(z).toHashCode();
    }

}
