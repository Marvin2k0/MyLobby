package de.marvinleiers.lobbysystem;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class Warp
{
    private Location loc;
    private ItemStack item;

    public Warp(Location loc, ItemStack item)
    {
        this.loc = loc;
        this.item = item;
    }

    public Location getLocation()
    {
        return this.loc;
    }

    public ItemStack getItem()
    {
        return this.item;
    }
}
