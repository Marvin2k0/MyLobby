package de.marvinleiers.lobbysystem.listener;

import de.marvinleiers.lobbysystem.Main;
import de.marvinleiers.lobbysystem.User;
import de.marvinleiers.lobbysystem.Warp;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener
{
    @EventHandler
    public void onClick(InventoryClickEvent e)
    {
        User u = Main.getInstance().getUser((Player) e.getWhoClicked());

        if (u.inLobby() && u.getPlayer().getOpenInventory() != null)
        {
            u.getPlayer().sendMessage("a");

            if (u.getPlayer().getOpenInventory().getTopInventory().getName().equals(u.getPlayer().getName() + "'s navigator"))
            {
                u.getPlayer().sendMessage("inventar gefunden");

                ItemStack item = e.getCurrentItem();

                if (Main.getInstance().getSpawnManager().getWarp(item.getItemMeta().getDisplayName()) != null)
                {
                    Warp warp = Main.getInstance().getSpawnManager().getWarp(item.getItemMeta().getDisplayName());

                    u.getPlayer().teleport(warp.getLocation());
                }
                else
                {
                    u.getPlayer().sendMessage(Main.getInstance().getPrefix() + "§cFehler! Warp §e" + item.getItemMeta().getDisplayName() + " §cnicht gefunden.");
                }
            }
            else
            {
                u.getPlayer().sendMessage("inventar nicht gefunden.");
            }
        }
    }
}
