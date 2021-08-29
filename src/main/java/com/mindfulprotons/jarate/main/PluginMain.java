package com.mindfulprotons.jarate.main;

import org.bukkit.plugin.java.JavaPlugin;
import com.mindfulprotons.jarate.commands.CommandGiveJarate;
import com.mindfulprotons.jarate.events.JarateEventHandler;
import org.bukkit.Bukkit;

/**
 * Jarate Plugin Main
 *
 */
public class PluginMain extends JavaPlugin {

    private static PluginMain mainPlugin;
    
    @Override
    public void onEnable () {
	this.getCommand("givejarate").setExecutor(new CommandGiveJarate());
	Bukkit.getPluginManager().registerEvents(new JarateEventHandler(), this);
	mainPlugin = this;
    }

    @Override
    public void onDisable () {
	
    }

    public static PluginMain getInstance()
    {
	return mainPlugin;
    }
}
