package de.marvinleiers.lobbysystem;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.marvinleiers.lobbysystem.listener.JoinEventListener;
import de.marvinleiers.lobbysystem.listener.PlayerInteractListener;
import de.marvinleiers.lobbysystem.manage.SpawnManager;

public class Main extends JavaPlugin
{
    private HashMap<Player, User> player = new HashMap<Player, User>();
    
    private static Main instance;
    
    private SpawnManager spawnManager;
    
    private String prefix;

    @Override
    public void onEnable()
    {
	instance = this;
	
	this.spawnManager = new SpawnManager();
	this.prefix = "�7[�9Lobby�7] ";

	this.registerEvents();
    }

    private void registerEvents()
    {
	Listener[] listeners = 
	    {
		new JoinEventListener(),
		new PlayerInteractListener()
	    };

	for (Listener listener : listeners)
	{
	    this.getServer().getPluginManager().registerEvents(listener, this);
	}
    }
    
    public User registerUser(Player p)
    {
	if (!this.player.containsKey(p))
	{
	    this.player.put(p, new User(p));
	}
	
	return this.player.get(p);
    }

    public static Main getInstance()
    {
	return instance;
    }
    
    public SpawnManager getSpawnManager()
    {
	return this.spawnManager;
    }
    
    public User getUser(Player player)
    {
	return this.player.get(player);
    }
    
    public String getPrefix()
    {
	return this.prefix;
    }
}
