package de.marvinleiers.lobbysystem.manage;

import de.marvinleiers.lobbysystem.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class InventoryManager
{
    public FileConfiguration createFile(String name)
    {
        File file = new File(Main.getInstance().getDataFolder(), name + ".yml");
        FileConfiguration config = new YamlConfiguration().loadConfiguration(file);

        config.set("name", name);

        return config;
    }

    public void save(FileConfiguration config)
    {
        try
        {
            config.save(new File(Main.getInstance().getDataFolder(), config.getString("name") + ".yml"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
