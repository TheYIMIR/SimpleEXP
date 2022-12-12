package sesosas.simpleexp.handlers;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import sesosas.simpleexp.SimpleEXP;

import java.io.File;

public class ConfigHandler {
    public static void ReloadConfig(){
        File file = new File(SimpleEXP.getPlugin().getDataFolder().getAbsolutePath() + "/config.yml");
        FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        SimpleEXP.getPlugin().config = cfg;
    }
}
