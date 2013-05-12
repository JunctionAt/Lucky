package at.junction.lucky;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class LuckyListener implements Listener {
    Lucky plugin;

    public LuckyListener(Lucky plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if(event.getEntity() instanceof Player && event.getEntity().getKiller() instanceof Player) {
            Player p = (Player)event.getEntity();
            if(plugin.playerDeaths.get(p.getName()) == null) {
                plugin.playerDeaths.put(p.getName(), 1);
            } else {
                plugin.playerDeaths.put(p.getName(), plugin.playerDeaths.get(p.getName()) + 1);
            }
            p.sendMessage(plugin.playerDeaths.get(p.getName()).toString());
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if(plugin.playerDeaths.get(event.getPlayer().getName()) != null && plugin.playerDeaths.get(event.getPlayer().getName()) >= plugin.config.maxDeaths) {
            event.setRespawnLocation(plugin.config.safeSpawn);
            event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "You've been killed " + plugin.config.maxDeaths + " times. You've been teleported elsewhere.");
            plugin.playerDeaths.put(event.getPlayer().getName(), 0);
        }
    }
}
