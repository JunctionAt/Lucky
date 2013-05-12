package at.junction.lucky;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
    Lucky plugin;
    
    int maxDeaths;
    Location safeSpawn;
    
    public Configuration(Lucky plugin) {
        this.plugin = plugin;
    }
    
    public void load() {
        FileConfiguration config = plugin.getConfig();
        
        maxDeaths = config.getInt("max-deaths", 3);
        safeSpawn = new Location(plugin.getServer().getWorld(config.getString("safespawn.world")), config.getDouble("safespawn.x"), config.getDouble("safespawn.y"), config.getDouble("safespawn.z"));
    }
}
