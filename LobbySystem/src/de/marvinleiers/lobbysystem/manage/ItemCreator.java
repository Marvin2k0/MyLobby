package de.marvinleiers.lobbysystem.manage;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemCreator
{
    public static ItemStack createItem(String name, Material type)
    {
        ItemStack item = new ItemStack(type);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return item;
    }
}
