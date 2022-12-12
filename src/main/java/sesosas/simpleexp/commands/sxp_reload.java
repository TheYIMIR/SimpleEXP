package sesosas.simpleexp.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import sesosas.simpleexp.SimpleEXP;
import sesosas.simpleexp.handlers.ConfigHandler;

public class sxp_reload implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player) sender).getPlayer();
            ConfigHandler.ReloadConfig();
            String Prefix = SimpleEXP.getPlugin().config.getString("Chat.Prefix");
            player.sendMessage(Prefix+"Config has been successfully reloaded!");
        }
        else{
            ConfigHandler.ReloadConfig();
            System.out.println("Config has been successfully reloaded!");
        }
        return false;
    }
}
