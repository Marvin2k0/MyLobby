package de.marvinleiers.lobbysystem.manage;

import de.marvinleiers.lobbysystem.Main;
import de.marvinleiers.lobbysystem.Warp;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.Set;

public class SpawnManager
{
    private FileConfiguration config = Main.getInstance().getConfig();

    public SpawnManager()
    {
    }

    public boolean exists()
    {
        return this.config.isSet("spawn");
    }

    public Location getSpawn()
    {
        if (!this.exists())
        {
            return null;
        }

        Location spawn;

        spawn = new Location(Bukkit.getWorld(this.config.getString("spawn.world")), this.config.getDouble("spawn.x"), this.config.getDouble("spawn.y"), this.config.getDouble("spawn.z"));
        spawn.setYaw((float) this.config.getDouble("spawn.yaw"));
        spawn.setPitch((float) this.config.getDouble("spawn.pitch"));

        return spawn;
    }

    public void setSpawn(Location loc)
    {
        this.config.set("spawn.world", loc.getWorld().getName());
        this.config.set("spawn.x", loc.getX());
        this.config.set("spawn.y", loc.getY());
        this.config.set("spawn.z", loc.getZ());
        this.config.set("spawn.yaw", loc.getYaw());
        this.config.set("spawn.pitch", loc.getPitch());

        Main.getInstance().saveConfig();
    }

    public void setWarp(Location loc, String name, Material item)
    {
        this.config.set("warps." + name + ".world", loc.getWorld().getName());
        this.config.set("warps." + name + ".x", loc.getX());
        this.config.set("warps." + name + ".y", loc.getY());
        this.config.set("warps." + name + ".z", loc.getZ());
        this.config.set("warps." + name + ".yaw", loc.getYaw());
        this.config.set("warps." + name + ".pitch", loc.getPitch());
        this.config.set("warps." + name + ".item", item.name());

        Main.getInstance().saveConfig();
    }

    public Warp getWarp(String name)
    {
        if (!this.config.isSet("warps." + name))
        {
            return null;
        }

        Location location = new Location(Bukkit.getWorld(this.config.getString("warps." + name + ".world")), this.config.getDouble("warps." + name + ".x"), this.config.getDouble("warps." + name + ".y"), this.config.getDouble("warps." + name + ".z"));
        location.setYaw((float) this.config.getDouble("warps." + name + ".yaw"));
        location.setPitch((float) this.config.getDouble("warps." + name + ".pitch"));

        ItemStack item = new ItemStack(Material.getMaterial(this.config.getString("warps." + name + ".item")));

        return new Warp(name, location, item);
    }

    public Set<String> getWarps()
    {
        return this.config.getConfigurationSection("warps").getKeys(false);
    }
}
