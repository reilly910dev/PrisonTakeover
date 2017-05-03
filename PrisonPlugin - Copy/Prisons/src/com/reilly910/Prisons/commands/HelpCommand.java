package com.reilly910.Prisons.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import com.reilly910.Prisons.Prisons;

public class HelpCommand {

	public static void Help(CommandSender sender) {

		if (sender.hasPermission("PrisonTakeover.Admin")) {
			AdminHelp(sender);
		}else{
			UserHelp(sender);
		}
	}

	private static void AdminHelp(CommandSender sender) {
		
		sender.sendMessage(Prisons.formatTitle("Prison Takeover Commands - Admin"));
		BasicCommands(sender);
		sender.sendMessage(ChatColor.DARK_PURPLE + "/prison createmine <name>");

	}

	private static void UserHelp(CommandSender sender) {
		
		sender.sendMessage(Prisons.formatTitle("Prison Takeover Commands - User"));
		BasicCommands(sender);

	}
	
	private static void BasicCommands(CommandSender sender){
		sender.sendMessage("");
		
	}

}
