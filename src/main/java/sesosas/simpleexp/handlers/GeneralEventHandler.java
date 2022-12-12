package sesosas.simpleexp.handlers;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import sesosas.simpleexp.SimpleEXP;
import sesosas.simpleexp.classes.Mathematics;
import sesosas.simpleexp.classes.config.CustomConfig;
import sun.java2d.pipe.SpanShapeRenderer;

public class GeneralEventHandler implements Listener {
    @EventHandler
    public void onPickUpItem(BlockBreakEvent event){
            Player player = event.getPlayer();
            Block block = event.getBlock();
            Material material = block.getType();
            FileConfiguration cfg = new CustomConfig().get("items");
            try{
                if(cfg.get(material.name().toUpperCase()) != null){
                    Integer min = Integer.parseInt(cfg.get(material.name() + ".min").toString());
                    Integer max = Integer.parseInt(cfg.get(material.name() + ".max").toString());
                    Integer chance = Integer.parseInt(cfg.get(material.name() + ".chance").toString());
                    if(chance >= 1){
                        if(chance > 100) chance = 100;
                        if(Mathematics.getRandomNumber(0, 100) <= chance){
                            event.setExpToDrop(Mathematics.getRandomNumber(min, max));
                        }
                    }
                }
            }
            catch (Exception e){
            }
        if(!SimpleEXP.getPlugin().config.getBoolean("Chat.Events.Use")) return;
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(SimpleEXP.getPlugin().config.getString("Chat.Events.Message").replace("{item}", material.name())));
    }
}
