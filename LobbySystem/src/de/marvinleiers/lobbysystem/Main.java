package de.marvinleiers.lobbysystem;

import de.marvinleiers.lobbysystem.listener.CancelEvents;
import de.marvinleiers.lobbysystem.listener.JoinEventListener;
import de.marvinleiers.lobbysystem.listener.PlayerInteractListener;
import de.marvinleiers.lobbysystem.manage.SpawnManager;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin
{
    private static Main instance;
    private HashMap<Player, User> player = new HashMap<Player, User>();
    private SpawnManager spawnManager;

    private String prefix;

    public static Main getInstance()
    {
        return instance;
    }

    @Override
    public void onEnable()
    {
        instance = this;

        this.spawnManager = new SpawnManager();
        this.prefix = "�7[�bLobby�7] ";

        this.registerEvents();
    }

    private void registerEvents()
    {
        Listener[] listeners =
                {
                        new JoinEventListener(),
                        new PlayerInteractListener(),
                        new CancelEvents()
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
