package com.reilly910.Prisons.commands.admin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.reilly910.Prisons.Prisons;
import com.reilly910.Prisons.utils.FileManager;
import com.sk89q.worldedit.bukkit.selections.Selection;

public class CreateMine {

	public static void NewMine(CommandSender sender, String[] args) {

		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to create a mine");
			return;
		}
		
		Player player = (Player) sender;
		
		if(!(args.length == 2)){
			player.sendMessage(ChatColor.RED + "Incorrect Usage - /prison createmine <Name>");
			return;
		}
		
		//Get Players Region Selection
		Selection region = Prisons.getWorldEdit().getSelection(player);

		if (region == null) {
			player.sendMessage(ChatColor.RED + "Please make a selection!");
			return;
		}
		
		//Save The Co-Ordinates of The Mine
		
		FileManager.dataFileCfg.createSection(args[1]);
		FileManager.dataFileCfg.getConfigurationSection(args[1]).set("MinX", region.getMinimumPoint().getX());
		FileManager.dataFileCfg.getConfigurationSection(args[1]).set("MinY", region.getMinimumPoint().getY());
		FileManager.dataFileCfg.getConfigurationSection(args[1]).set("MinZ", region.getMinimumPoint().getZ());
		FileManager.dataFileCfg.getConfigurationSection(args[1]).set("MaxX", region.getMaximumPoint().getX());
		FileManager.dataFileCfg.getConfigurationSection(args[1]).set("MaxY", region.getMaximumPoint().getY());
		FileManager.dataFileCfg.getConfigurationSection(args[1]).set("MaxZ", region.getMaximumPoint().getZ());
		
		Bukkit.getServer().broadcastMessage("Mine Created");
		FileManager.saveDataFile(player);
		
		//Set the New Mine To Stone
		for(double i = region.getMinimumPoint().getX(); i <= region.getMaximumPoint().getX();i ++){
			for(double y = region.getMinimumPoint().getY(); y <= region.getMaximumPoint().getY();y ++){
				for(double z = region.getMinimumPoint().getZ(); z <= region.getMaximumPoint().getZ();z ++){
					Location l = new Location(region.getWorld(),i,y,z);
					l.getBlock().setType(Material.STONE);
					
					
				}
			}
			
		}
		

	}
	
	
	

}
