package de.marvinleiers.lobbysystem.listener;

import de.marvinleiers.lobbysystem.Main;
import de.marvinleiers.lobbysystem.User;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinEventListener implements Listener
{
    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
        User u = Main.getInstance().registerUser(e.getPlayer());

        u.getPlayer().setGameMode(GameMode.ADVENTURE);

        u.toSpawn();
        u.giveItems();
    }
}
