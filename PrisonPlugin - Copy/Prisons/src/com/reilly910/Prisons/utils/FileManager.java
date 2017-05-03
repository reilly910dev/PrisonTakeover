package com.reilly910.Prisons.utils;


import java.io.File;
import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.reilly910.Prisons.Prisons;

public class FileManager {

	public static File dataFile = new File(Prisons.getInstance().getDataFolder() + File.separator + "data.yml");
	public static FileConfiguration dataFileCfg = YamlConfiguration.loadConfiguration(dataFile);
	public static File mineFile ;
	public static FileConfiguration mineFileCfg;
	
	public static void loadFiles() {
		
		File schemFolder = new File(Prisons.getInstance().getDataFolder() + File.separator + "schematics");
		if(!schemFolder.exists()) {
			System.out.print("Creating schematic folder...");
			schemFolder.mkdirs();
		}
		
		File mineFolder = new File(Prisons.getInstance().getDataFolder() + File.separator + "mines");
		if(!schemFolder.exists()) {
			System.out.print("Creating mines folder...");
			mineFolder.mkdirs();
		}
		
		if(!dataFile.exists()) {
			try {
				System.out.print("Creating data file...");
				dataFile.createNewFile();				
				dataFileCfg.options().copyDefaults(true);
				dataFileCfg.save(dataFile);
			} catch (IOException e) {
				System.out.print("Error creating data file!");
				e.printStackTrace();
			}
		}	
	}
	
	public static void unloadFiles() {
		
		File dataFile = new File(Prisons.getInstance().getDataFolder() + File.separator + "data.yml");
		FileConfiguration dataFileCfg = YamlConfiguration.loadConfiguration(dataFile);
		try {
			dataFileCfg.save(dataFile);
		} catch (IOException e) {
			System.out.print("Could not save data file!");
			e.printStackTrace();
		}
	}
	
	public static void saveDataFile(Player player) {
		try {
			dataFileCfg.save(dataFile);
		} catch (IOException e) {
			System.out.print("Error creating data file!");
			player.sendMessage(ChatColor.RED + "Error creating data file!");
			e.printStackTrace();
		}		
	}
	
	public static void newMineFile(Player player, String mineNumber){
		
		mineFile = new File(Prisons.getInstance().getDataFolder() + File.separator + mineNumber +".yml");
		mineFileCfg = YamlConfiguration.loadConfiguration(mineFile);
		
		if(!mineFile.exists()) {
			try {
				System.out.print("Creating data file...");
				mineFile.createNewFile();				
				mineFileCfg.options().copyDefaults(true);
				mineFileCfg.save(mineFile);
			} catch (IOException e) {
				System.out.print("Error creating data file!");
				e.printStackTrace();
			}
		}
		
	}
	
	public static void mineFileUpdate(Player player){
		
	}
}
