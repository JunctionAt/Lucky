package at.junction.lucky;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class LuckyListener implements Listener {
    Lucky plugin;

    public LuckyListener(Lucky plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player p = (Player)event.getEntity();
        if(p.getKiller() instanceof Player || event.getDeathMessage().contains("in lava") || event.getDeathMessage().contains("drowned")) {
            if(p.getBedSpawnLocation().getChunk() == p.getLocation().getChunk()){
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
        if(plugin.playerDeaths.get(event.getPlayer().getName()) != null && plugin.playerDeaths.get(event.getPlayer().getName()) >= plugin.config.maxDeaths) {
            event.setRespawnLocation(plugin.config.safeSpawn);
            event.getPlayer().sendMessage(ChatColor.RED + "Your bed spawn looks a bit dangerous, as a courtesy, you've been teleported to spawn.");
            plugin.playerDeaths.put(event.getPlayer().getName(), 0);
        }
    }
}
