package de.marvinleiers.lobbysystem.listener;

import de.marvinleiers.lobbysystem.Main;
import de.marvinleiers.lobbysystem.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class CancelEvents implements Listener
{
    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e)
    {
        if (e.getEntity() instanceof Player)
        {
            User u = Main.getInstance().getUser((Player) e.getEntity());

            if (u.inLobby())
            {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e)
    {
        if (e.getEntity() instanceof Player)
        {
            User u = Main.getInstance().getUser((Player) e.getEntity());

            if (u.inLobby())
            {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e)
    {
        User u = Main.getInstance().getUser(e.getPlayer());

        if (u.inLobby())
        {
            e.setCancelled(true);
        }
    }
}
