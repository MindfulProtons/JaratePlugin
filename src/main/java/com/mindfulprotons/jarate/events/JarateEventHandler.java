package com.mindfulprotons.jarate.events;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.event.entity.PotionSplashEvent;
import org.bukkit.potion.PotionEffectType;
import com.mindfulprotons.jarate.commands.CommandGiveJarate;
import com.mindfulprotons.jarate.main.PluginMain;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.ChatColor;
import java.util.List;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.entity.Player;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.player.PlayerInteractEvent;

public class JarateEventHandler implements Listener {
    
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
	
	if (e.getEntity().hasMetadata("Jarate")) {
		e.setDamage(e.getDamage() * 1.35);
	    }
    }

    @EventHandler
    public void onPotionSplash(PotionSplashEvent e) {
	ItemStack unknownPotionStack = e.getPotion().getItem();
	ItemStack jarateStack = CommandGiveJarate.getJarateItemStack();
	if (unknownPotionStack.getLore() != null && unknownPotionStack.getLore().get(0).equals(jarateStack.getLore().get(0)))
	    {
		for (LivingEntity ent : e.getAffectedEntities())
		    {
			e.setIntensity(ent, 0.0);
			if (!ent.hasMetadata("Jarate"))
			    {
				if (ent instanceof Player)
				    {
					Player p = (Player) ent;
					p.sendMessage(ChatColor.YELLOW + "You have been sprayed with Jarate! You will be more vulnerable to damage for the next 30 seconds.");
				    }
				ent.setMetadata("Jarate", new FixedMetadataValue(PluginMain.getInstance(), "true"));
				Bukkit.getScheduler().runTaskLater(PluginMain.getInstance(), new Runnable() {
					@Override
					public void run() {
					    if (ent instanceof Player)
						{
						    Player p = (Player) ent;
						    p.sendMessage(ChatColor.YELLOW + "The Jarate has worn off. Thank goodness!");
						}
					    ent.removeMetadata("Jarate", PluginMain.getInstance());
					}
				    }, 600);
			    }
		    }
	    }
    }
}
