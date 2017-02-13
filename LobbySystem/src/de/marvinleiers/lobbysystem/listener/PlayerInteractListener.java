package de.marvinleiers.lobbysystem.listener;

import de.marvinleiers.lobbysystem.Main;
import de.marvinleiers.lobbysystem.User;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener
{
    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        User u = Main.getInstance().getUser(e.getPlayer());

        if (e.getItem() != null && e.getItem().hasItemMeta())
        {
            if (e.getItem().getType() == Material.COMPASS)
            {
                if (e.getItem().getItemMeta().getDisplayName().equals("§eNavigator"))
                {
                    e.setCancelled(true);

                    u.getPlayer().openInventory(u.getNavigatorInventory());
                }
            }
        }
    }
}
