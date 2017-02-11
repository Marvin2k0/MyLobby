package de.marvinleiers.lobbysystem.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.marvinleiers.lobbysystem.Main;

public class CommandSpawn implements CommandExecutor
{
    private FileConfiguration config = Main.getInstance().getConfig();
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
      if (sender instanceof Player)
      {
        final Player p = (Player) sender;
        
        if (cmd.getName().equalsIgnoreCase("setspawn"))
        {
          Main.getInstance().getSpawnManager().setSpawn(p.getLocation());

          p.sendMessage("§aSpawn wurde gesetzt!");

          return true;
        }
        else if (cmd.getName().equalsIgnoreCase("spawn"))
        {
          if (this.config.isSet("spawn"))
          {
            Location spawn = Main.getInstance().getSpawnManager().getSpawn();

            p.teleport(spawn);

            return true;
          }
          else
          {
            p.sendMessage("§cDu musst zuerst einen Spawn mit §e/setspawn §csetzen!");
            
            return true;
          }
        }
        
        return true;
      }
      else
      {
        sender.sendMessage("§cNur fuer Spieler");

        return true;
      }
    }
}
