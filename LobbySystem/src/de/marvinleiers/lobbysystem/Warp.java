package de.marvinleiers.lobbysystem;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class Warp
{
    private String name;
    private Location loc;
    private ItemStack item;

    public Warp(String name, Location loc, ItemStack item)
    {
        this.name = name;
        this.loc = loc;
        this.item = item;
    }

    public String getName()
    {
        return this.name;
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
