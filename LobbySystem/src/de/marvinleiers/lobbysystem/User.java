package de.marvinleiers.lobbysystem;

import de.marvinleiers.lobbysystem.manage.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class User
{
    private FileConfiguration inventoryConfig;

    private Player p;

    public User(Player p)
    {
        this.p = p;

        this.inventoryConfig = Main.getInstance().getInventoryManager().createFile(this.getPlayer().getName());
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

        if (!this.inventoryConfig.isSet("inventory"))
        {
            // [0] [1] [2] [3] [4] [5] [6] [7] [8]

            this.inventoryConfig.set("inventory.navigator", 5);
            this.inventoryConfig.set("inventory.hideShow", 1);
            this.inventoryConfig.set("inventory.shop", 8);

            Main.getInstance().getInventoryManager().save(this.inventoryConfig);
        }

        return inv;
    }

    public boolean inLobby()
    {
        return this.getPlayer().getLocation().getWorld().getName() == Main.getInstance().getConfig().getString("spawn.world");
    }
}
