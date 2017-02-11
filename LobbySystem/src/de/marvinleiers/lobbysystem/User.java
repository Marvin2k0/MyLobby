package de.marvinleiers.lobbysystem;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import de.marvinleiers.lobbysystem.manage.ItemCreator;

public class User
{
    private Player p;
    
    public User(Player p)
    {
	this.p = p;
    }
    
    public Player getPlayer()
    {
	return this.p;
    }
    
    public void toSpawn()
    {
	Location spawn = Main.getInstance().getSpawnManager().getSpawn();
	
	if (spawn != null)
	{
	    this.getPlayer().teleport(spawn);
	}
    }
    
    public void giveItems()
    {
	this.getPlayer().getInventory().setItem(4, ItemCreator.createItem("žeNavigator", Material.COMPASS));
    }
    
    public Inventory getNavigatorInventory()
    {
	Inventory inv = Bukkit.createInventory(null, 9);
	
	return inv;
    }
}
