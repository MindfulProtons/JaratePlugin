package com.mindfulprotons.jarate.main;

import org.bukkit.plugin.java.JavaPlugin;
import com.mindfulprotons.jarate.commands.CommandGivePowers;

/**
 * Hello world!
 *
 */
public class PluginMain extends JavaPlugin {
    @Override
    public void onEnable () {
	getLogger().info("You have activated the plugin of Death!");
	this.getCommand("givepowers").setExecutor(new CommandGivePowers());
    }

    @Override
    public void onDisable () {
	getLogger().info("You have deactivated the plugin, fool!");
    }
}
