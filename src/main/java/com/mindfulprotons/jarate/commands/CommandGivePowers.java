package com.mindfulprotons.jarate.commands;

import org.bukkit.potion.Potion;
import org.bukkit.entity.Player;
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
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;

public class CommandGivePowers implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	if (sender instanceof Player) {
	    Player player = (Player) sender;
	    // gives player potion with custom potion effect
	    ItemStack powerPotion = new ItemStack(Material.SPLASH_POTION, 1);
	    PotionMeta powerPotionMeta = (PotionMeta) powerPotion.getItemMeta();
	    PotionData powerData = new PotionData(PotionType.WATER, false, false);
	    PotionEffect sonicPowers = new PotionEffect(PotionEffectType.SPEED, 1000, 20);
	    PotionEffect rabbitPowers = new PotionEffect(PotionEffectType.JUMP, 1000, 20);
	    powerPotionMeta.setBasePotionData(powerData);
	    powerPotionMeta.setColor(Color.YELLOW);
	    powerPotionMeta.addCustomEffect(sonicPowers, true);
	    powerPotionMeta.addCustomEffect(rabbitPowers, true);
	    powerPotionMeta.setDisplayName(ChatColor.RESET + "Jarate");
	    powerPotion.setItemMeta(powerPotionMeta);
	    player.getInventory().addItem(powerPotion);
	    player.sendMessage(ChatColor.YELLOW + "fuck you, bitch");
	}
	return true;
    }
}
