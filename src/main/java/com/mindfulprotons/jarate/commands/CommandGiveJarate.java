package com.mindfulprotons.jarate.commands;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import java.util.List;

public class CommandGiveJarate implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if (sender instanceof Player) {
	    Player player = (Player) sender;
	    // gives player potion with custom potion effect
	    ItemStack powerPotion = getJarateItemStack();

	    // gives it to the player, with a message
	    player.getInventory().addItem(powerPotion);
	    player.sendMessage(ChatColor.YELLOW + "Given jarate.");
	}
	return true;
    }

    public static ItemStack getJarateItemStack () {
	ItemStack powerPotion = new ItemStack(Material.SPLASH_POTION, 1);
	PotionMeta powerPotionMeta = (PotionMeta) powerPotion.getItemMeta();
	PotionData powerData = new PotionData(PotionType.SPEED, false, false);
	    
	// sets up the potion meta
	powerPotionMeta.setBasePotionData(powerData);
	powerPotionMeta.setColor(Color.YELLOW);
	powerPotionMeta.setDisplayName(ChatColor.RESET + "Jarate");
	powerPotionMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
	powerPotionMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

	// sets up lore list.
	ArrayList<String> loreList = new ArrayList<>();
	loreList.add(ChatColor.ITALIC + "Is this?! " + ChatColor.BOLD + "MON DIEU!");
	loreList.add("");
	loreList.add(ChatColor.DARK_PURPLE + "When Applied:");
	loreList.add(ChatColor.DARK_RED + "+35% Damage Vulnerability");
	powerPotionMeta.setLore(loreList);
	powerPotion.setItemMeta(powerPotionMeta);
	return powerPotion;
    }
    
}
