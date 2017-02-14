package de.marvinleiers.lobbysystem.commands;

import de.marvinleiers.lobbysystem.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandWarp implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player p = (Player) sender;

            if (args.length != 1)
            {
                p.sendMessage(Main.getInstance().getPrefix() + "§c/setwarp <name>");

                return true;
            }

            Main.getInstance().getSpawnManager().setWarp(p.getLocation(), args[0]);

            p.sendMessage(Main.getInstance().getPrefix() + "§e" + args[0] + " §awurde gesetzt.");

            return true;
        }
        else
        {
            sender.sendMessage(Main.getInstance().getPrefix() + "§cNur fuer Spieler!");

            return true;
        }
    }
}
