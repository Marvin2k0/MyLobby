package de.marvinleiers.lobbysystem.manage;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

import de.marvinleiers.lobbysystem.Main;

public class SpawnManager
{
    private FileConfiguration config = Main.getInstance().getConfig();
    
    public SpawnManager() { }
    
    public boolean exists()
    {
	return this.config.isSet("spawn");
    }
    
    public void setSpawn(Location loc)
    {
	this.config.set("spawn.world", loc.getWorld());
	this.config.set("spawn.x", loc.getX());
	this.config.set("spawn.y", loc.getY());
	this.config.set("spawn.z", loc.getZ());
	this.config.set("spawn.yaw", loc.getYaw());
	this.config.set("spawn.pitch", loc.getPitch());
	
	Main.getInstance().saveConfig();
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
}
