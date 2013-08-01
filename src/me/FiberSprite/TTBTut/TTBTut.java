package me.FiberSprite.TTBTut;

import java.util.logging.Logger;

import me.FiberSprite.TTBTut.Commands.pinfo;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TTBTut extends JavaPlugin
{
    
    //Finnaly Got GitHub Working
    
    public TTBTut plugin;
    
    public final Logger logger = Logger.getLogger("Minecraft");
    
    @Override
    public void onEnable()
    {
        PluginManager pm = getServer().getPluginManager();
        
        getCommand("pinfo").setExecutor(new pinfo(this));
        
        final PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " Version: " + pdfFile.getVersion() + " Has Been Enabled !");
    }
    
    @Override
    public void onDisable()
    {
        
        final PluginDescriptionFile pdfFile = this.getDescription();
        this.logger.info(pdfFile.getName() + " Version: " + pdfFile.getVersion() + " Has Been Disabled !");
    }
    
    @Override
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label,  final String[] args)
    {
        
        if(!(sender instanceof Player))
        {
            sender.sendMessage(ChatColor.RED + "This command has to be called by a player !");
            return true;    
        }
        
        return false;
    }
}
