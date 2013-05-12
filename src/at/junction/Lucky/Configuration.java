package at.junction.Lucky;

import org.bukkit.configuration.file.FileConfiguration;

public class Configuration {
    Lucky plugin;
    
    int maxDeaths; 
    
    public Configuration(Lucky plugin) {
        this.plugin = plugin;
    }
    
    public void load() {
        FileConfiguration config = plugin.getConfig();
        
        maxDeaths = config.getInt("max-deaths", 3);
    }
}
