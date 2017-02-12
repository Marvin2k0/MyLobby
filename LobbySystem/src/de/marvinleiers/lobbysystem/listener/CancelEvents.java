package de.marvinleiers.lobbysystem.listener;

import de.marvinleiers.lobbysystem.Main;
import de.marvinleiers.lobbysystem.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

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

                return;
            }
        }
    }
}
