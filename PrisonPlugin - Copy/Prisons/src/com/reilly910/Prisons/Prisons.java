package com.reilly910.Prisons;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.reilly910.Prisons.commands.PrisonCommand;
import com.reilly910.Prisons.events.PlayerJoin;
import com.reilly910.Prisons.utils.FileManager;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;

public class Prisons extends JavaPlugin {
	
	public static String currentTime = "Morning";
	public static Prisons instance;
	
	public void onEnable(){
		instance = this;
		FileManager.loadFiles();
		registerEvents();
		registerCommands();
	}
	
	public void onDisable(){
		FileManager.unloadFiles();
	}
	
	public void registerEvents(){
		
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new PlayerJoin(), this);
		
	}
	
	public void registerCommands(){
		
		getCommand("prison").setExecutor(new PrisonCommand());
		
		
	}
	
	public static String getTimeZone(){
		return currentTime;
	}
	
	public static void setTimeZone(String newTime){
		currentTime = newTime;
	}
	
	public static WorldEditPlugin getWorldEdit() {
		Plugin plugin = Bukkit.getServer().getPluginManager()
				.getPlugin("WorldEdit");

		if (plugin == null || !(plugin instanceof WorldEditPlugin)) {
			return null;
		}
		return (WorldEditPlugin) plugin;
	}
	
	public static String formatTitle(String title) {
		 
        String line = ChatColor.DARK_GRAY + "[" + ChatColor.DARK_GRAY + ChatColor.STRIKETHROUGH + "---------------------------------------------------------------" + ChatColor.RESET + ChatColor.RESET + ChatColor.DARK_GRAY + "]";
        int pivot = line.length() / 2;
        String center = ChatColor.RESET + "[ " + ChatColor.AQUA + ChatColor.BOLD + title + ChatColor.RESET + ChatColor.WHITE + " ]";
        String out = line.substring(0, Math.max(0, (pivot - center.length() / 2)));
        out += center + ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + line.substring(pivot + center.length() / 2);
        return out;
    }
	
	public static Prisons getInstance(){
		return instance;
	}
	
	  

}
