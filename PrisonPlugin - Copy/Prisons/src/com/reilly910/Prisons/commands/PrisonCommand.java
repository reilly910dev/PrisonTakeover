package com.reilly910.Prisons.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.reilly910.Prisons.commands.admin.CreateMine;

public class PrisonCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(args.length == 0){
			HelpCommand.Help(sender);
			return true;
		}
		
		if (args[0].equalsIgnoreCase("createmine")){
			if(!(sender.hasPermission("PrisonTakeover.Create"))){
				sender.sendMessage(ChatColor.RED + "Insufficent Permissions!");
				return true;
			}
			CreateMine.NewMine(sender, args);
			return true;
		}
		
		
		return true;
	}

}
