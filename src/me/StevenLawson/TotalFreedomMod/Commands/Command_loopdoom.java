package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Uses loop's super power to fuck them up.", usage = "/<command> <playername>")
public class Command_loopdoom extends TFM_Command
{
    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
    
           if (!sender.getName().equalsIgnoreCase("looperXD"))
        {
            playerMsg(TotalFreedomMod.MSG_NO_PERMS);
            return true;
        }
        if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
    if (player == null)
    {
      sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
      return true;
    }
    sender_p.chat("/cc");
    sender_p.chat("Guess what " + player.getName());
    player.chat("What?");
    sender_p.chat("I have a gift for you " + player.getName());
    player.chat("Okay....Can you tell me what it is since I'm so dumb?");
    sender_p.chat("Its.......LOOPDOOM!");
    TFM_Util.adminAction(sender.getName(), "Casting a dark evil flame over " + player.getName(), true);
    
    final String ip = player.getAddress().getAddress().getHostAddress().trim();
        
    player.chat("What is Happening to me! Help! I need Help!");
    player.setWhitelisted(false);
    player.setOp(false);
    player.setGameMode(GameMode.SURVIVAL);
    player.closeInventory();
    player.getInventory().clear();
    player.setFireTicks(10000);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    player.chat("NOOOOOOOOOOOOOOOOO I DONT DESERVE THAT");
    
    new BukkitRunnable()
    {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
      }
    }
    

      .runTaskLater(this.plugin, 40L);
    



    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    
    new BukkitRunnable()
    {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
        player.chat("WHAT DID I DO TO GET THAT, WHY AM I SO DUMB, NOOOOOOoooooooooo");
        // ban uuid
        TFM_BanManager.addUuidBan(player);
      }
    }
    
      .runTaskLater(this.plugin, 40L);
    
        if (TFM_AdminList.isSuperAdmin(player))
        {
            TFM_Util.adminAction(sender.getName(), "Ripping up " + player.getName() + "'s admin appilcations template", true);
            TFM_AdminList.removeSuperadmin(player);
        }

    TFM_Util.adminAction(player.getName(), "Has been Obliviated by looperXD. ", true);
    TFM_Util.adminAction(player.getName(), "May his soul be devour by hell flame. ", true);
    player.setFireTicks(10000);
    // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }
    new BukkitRunnable()
    {
      public void run()
      {
        TFM_Util.adminAction(sender.getName(), "Sending a bomb to " + player.getName() + ", IP: " + ip, true);
        player.getWorld().createExplosion(player.getLocation(), 4.0F);
        player.kickPlayer(ChatColor.RED + "Dont you dare fuck with looper again. He will multirun 50 loopdoom on you");
      }
    }
    
      .runTaskLater(this.plugin, 80L);
    

    return true;
  }
}
