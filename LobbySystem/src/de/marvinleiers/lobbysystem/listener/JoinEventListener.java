package de.marvinleiers.lobbysystem.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.marvinleiers.lobbysystem.Main;
import de.marvinleiers.lobbysystem.User;

public class JoinEventListener implements Listener
{
    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
	User u = Main.getInstance().registerUser(e.getPlayer());	
	
	u.toSpawn();
	u.giveItems();
    }
}
