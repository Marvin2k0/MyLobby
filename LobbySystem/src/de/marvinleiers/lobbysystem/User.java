package de.marvinleiers.lobbysystem;

import de.marvinleiers.lobbysystem.manage.ItemCreator;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        this.getPlayer().getInventory().setItem(4, ItemCreator.createItem("§eNavigator", Material.COMPASS));
    }

    public Inventory getNavigatorInventory()
    {
        Inventory inv = Bukkit.createInventory(null, 36, this.getPlayer().getName() + "'s navigator");

        int i = 0;

        if (!this.inventoryConfig.isSet("inventory"))
        {
            // [0] [1] [2] [3] [4] [5] [6] [7] [8]

            this.inventoryConfig.set("inventory.navigator", 4);
            this.inventoryConfig.set("inventory.hideShow", 0);
            this.inventoryConfig.set("inventory.shop", 8);

            Main.getInstance().getInventoryManager().save(this.inventoryConfig);
        }

        for(String str : Main.getInstance().getSpawnManager().getWarps())
        {
            String name = str;

            Warp warp = Main.getInstance().getSpawnManager().getWarp(name);

            ItemStack item = warp.getItem();
            ItemMeta meta = item.getItemMeta();

            meta.setDisplayName("§9" + name);
            item.setItemMeta(meta);

            inv.setItem(i, item);

            i++;

            if (i > 35)
            {
                this.getPlayer().sendMessage(Main.getInstance().getPrefix() + "§cZu viele Warps, nur §e36 §cerlaubt!");

                break;
            }
        }

        return inv;
    }

    public boolean inLobby()
    {
        return this.getPlayer().getLocation().getWorld().getName() == Main.getInstance().getConfig().getString("spawn.world");
    }
}
