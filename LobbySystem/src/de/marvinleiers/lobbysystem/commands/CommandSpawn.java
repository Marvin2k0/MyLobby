package de.marvinleiers.lobbysystem.commands;

import org.bukkit.Bukkit;
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
          final Location loc = p.getLocation();

          this.config.set("spawn.world", loc.getWorld().getName());
          this.config.set("spawn.x", loc.getX());
          this.config.set("spawn.y", loc.getY());
          this.config.set("spawn.z", loc.getZ());
          this.config.set("spawn.yaw", loc.getYaw());
          this.config.set("spawn.pitch", loc.getPitch());

          Main.getInstance().saveConfig();

          p.sendMessage("§aSpawn wurde gesetzt!");

          return true;
        }
        else if (cmd.getName().equalsIgnoreCase("spawn"))
        {
          if (this.config.isSet("spawn"))
          {
            Location spawn = new Location(Bukkit.getWorld(this.config.getString("spawn.world")), this.config.getDouble("spawn.x"), this.config.getDouble("spawn.y"), this.config.getDouble("spawn.z"));
            spawn.setYaw((float) this.config.getDouble("spawn.yaw"));
            spawn.setPitch((float) this.config.getDouble("spawn.pitch"));

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
