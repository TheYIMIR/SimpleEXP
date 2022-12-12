package sesosas.simpleexp.classes.config;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import sesosas.simpleexp.SimpleEXP;

import java.io.File;
import java.io.IOException;

public class CustomConfig {
    private File file;
    private FileConfiguration customFile;

    public CustomConfig setup(Player player){
        this.file = new File(Bukkit.getServer().getPluginManager().getPlugin(SimpleEXP.getPlugin().getName()).getDataFolder(), "users/"+player.getUniqueId()+".yml");
        if (!this.file.exists()){
            try{
                this.file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        this.customFile = YamlConfiguration.loadConfiguration(this.file);
        return this;
    }

    public CustomConfig setup(String path){
        this.file = new File(Bukkit.getServer().getPluginManager().getPlugin(SimpleEXP.getPlugin().getName()).getDataFolder(), path + ".yml");
        if (!this.file.exists()){
            try{
                this.file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        this.customFile = YamlConfiguration.loadConfiguration(this.file);
        return this;
    }

    public FileConfiguration get(String path){
        this.file = new File(Bukkit.getServer().getPluginManager().getPlugin(SimpleEXP.getPlugin().getName()).getDataFolder(), path + ".yml");
        if (!this.file.exists()){
            try{
                this.file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        this.customFile = YamlConfiguration.loadConfiguration(this.file);
        return this.customFile;
    }

    public FileConfiguration get(Player player){
        this.file = new File(Bukkit.getServer().getPluginManager().getPlugin(SimpleEXP.getPlugin().getName()).getDataFolder(), "users/"+player.getUniqueId()+".yml");
        if (!this.file.exists()){
            try{
                this.file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        this.customFile = YamlConfiguration.loadConfiguration(this.file);
        return this.customFile;
    }

    public FileConfiguration get(){
        return this.customFile;
    }

    public FileConfiguration save(Player player){
        this.file = new File(Bukkit.getServer().getPluginManager().getPlugin(SimpleEXP.getPlugin().getName()).getDataFolder(), "users/"+player.getUniqueId()+".yml");
        if (!this.file.exists()){
            try{
                this.file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        try{
            this.customFile.save(this.file);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
        return this.customFile;
    }

    public FileConfiguration save(String path){
        this.file = new File(Bukkit.getServer().getPluginManager().getPlugin(SimpleEXP.getPlugin().getName()).getDataFolder(), path + ".yml");
        if (!this.file.exists()){
            try{
                this.file.createNewFile();
            }catch (IOException e){
                //owww
            }
        }
        try{
            this.customFile.save(this.file);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
        return this.customFile;
    }

    public void save(){
        try{
            this.customFile.save(this.file);
        }catch (IOException e){
            System.out.println("Couldn't save file");
        }
    }

    public void reload(){
        this.customFile = YamlConfiguration.loadConfiguration(this.file);
    }
}