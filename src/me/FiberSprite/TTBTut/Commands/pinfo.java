package me.FiberSprite.TTBTut.Commands;

import me.FiberSprite.TTBTut.TTBTut;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class pinfo implements CommandExecutor
{
    
    private TTBTut plugin;
    
    public pinfo(TTBTut instance)
    {
        this.plugin = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        
        Player player = (Player) sender;
        
        if(label.equalsIgnoreCase("pinfo"))
        {
            if(player.hasPermission("tut.pinfo"))
            {
                if(args.length == 0)
                {
                    player.sendMessage(ChatColor.DARK_RED + "Usage: /pinfo <Username>");
                }else
                    if(args.length == 1)
                    {
                        Player tplayer = player.getServer().getPlayer(args[0]);
                        
                        player.sendMessage(ChatColor.YELLOW + "Username: " + tplayer.getDisplayName());
                        player.sendMessage(ChatColor.YELLOW + "Ip: " + tplayer.getAddress());
                        player.sendMessage(ChatColor.YELLOW + "Gamemode: " + tplayer.getGameMode());
                        player.sendMessage(ChatColor.YELLOW + "Is Flying: " + tplayer.isFlying());
                        player.sendMessage(ChatColor.YELLOW 
                                +  "Health: " + tplayer.getHealthScale()
                                + " | Food: " + tplayer.getFoodLevel());
                        player.sendMessage(ChatColor.YELLOW 
                                + "X: " + tplayer.getLocation().getBlockX()
                                + " Y: " + tplayer.getLocation().getBlockY()
                                + " Z: " + tplayer.getLocation().getBlockZ());
                        player.sendMessage(ChatColor.YELLOW
                                + "Pitch: " + (int)tplayer.getLocation().getPitch()
                                + " Yaw: " + (int)tplayer.getLocation().getYaw());
                        player.sendMessage(ChatColor.YELLOW + "Direction Facing: " + getDirection(tplayer));
                        player.sendMessage(ChatColor.YELLOW + "Is Online: " + tplayer.isOnline());
                        player.sendMessage(ChatColor.YELLOW + "Is Op: " + tplayer.isOp());
                        player.sendMessage(ChatColor.YELLOW + "Whitlisted: " + tplayer.isWhitelisted());
                        player.sendMessage(ChatColor.YELLOW 
                                + "Level: " + tplayer.getLevel()
                                + " (Exp: " + (int)tplayer.getExp() + ")");
                        
                        
                    }
            }
        }
        
        
        return false;
    }
    
    public String getDirection(Player player)
    {
        int degress = (Math.round(player.getLocation().getYaw()) + 270) % 360;
        if (degress <= 22) return "North";
        if (degress <= 67) return "Northeast";
        if (degress <= 112) return "East";
        if (degress <= 157) return "Southeast";
        if (degress <= 202) return "South";
        if (degress <= 247) return "Southwest";
        if (degress <= 292) return "West";
        if (degress <= 337) return "Northwest";
        if (degress <= 359) return "North";
        return null;
    }

}
