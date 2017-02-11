package de.marvinleiers.lobbysystem.commands;

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
	    
	    return true;
	}
	else
	{
	    sender.sendMessage("§cNur fuer Spieler!");
	    
	    return true;
	}
    }
}
