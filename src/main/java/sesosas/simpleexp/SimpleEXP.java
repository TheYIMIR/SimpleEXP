package sesosas.simpleexp;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import sesosas.simpleexp.classes.config.CustomConfig;
import sesosas.simpleexp.commands.sxp_reload;
import sesosas.simpleexp.handlers.GeneralEventHandler;

public final class SimpleEXP extends JavaPlugin {

    public FileConfiguration config = getConfig();

    private static SimpleEXP plugin;

    public static SimpleEXP getPlugin() {
        return plugin;
    }


    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        config.addDefault("Plugin.Use", true);
        config.addDefault("Chat.Prefix", "§f[§cSXP§f] §e");
        config.addDefault("Chat.Events.Use", true);
        config.addDefault("Chat.Events.Message", "Destroyed '{item}'");
        //config.addDefault("bStats.Use", true);
        config.options().copyDefaults(true);
        saveConfig();

        CustomConfig custom = new CustomConfig().setup("items");
        FileConfiguration cfg = custom.get();
        cfg.addDefault(Material.STONE.toString() + ".min", "2");
        cfg.addDefault(Material.STONE.toString() + ".max", "3");
        cfg.addDefault(Material.STONE.toString() + ".chance", "20");
        cfg.options().copyDefaults(true);
        custom.save();

        getServer().getPluginManager().registerEvents(new GeneralEventHandler(), this);
        getCommand("sxp-reload").setExecutor(new sxp_reload());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
