package at.junction.lucky;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class LuckyListener implements Listener {
    Lucky plugin;
    
    public LuckyListener(Lucky plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            if(event.getEntity().isDead()) {
                Player p = (Player)event.getEntity();
                if(plugin.playerDeaths.get(p.getName()) == null) {
                    plugin.playerDeaths.put(p.getName(), 1);
                } else {
                    plugin.playerDeaths.put(p.getName(), plugin.playerDeaths.get(p.getName()) + 1);
                }
            }
        }
    }
    
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        if(plugin.playerDeaths.get(event.getPlayer().getName()) >= plugin.config.maxDeaths) {
            plugin.getServer().getPlayer(event.getPlayer().getName()).teleport(plugin.config.safeSpawn);
            event.getPlayer().sendMessage(ChatColor.DARK_AQUA + "You've been killed " + plugin.config.maxDeaths + "times. Your spawn has been reset to the server's safe-spawn.");
            plugin.playerDeaths.put(event.getPlayer().getName(), 0);
        }
    }
}
