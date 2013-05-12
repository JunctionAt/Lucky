package at.junction.Lucky;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class Lucky extends JavaPlugin {
    LuckyListener listener = new LuckyListener(this);
    Configuration config = new Configuration(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(listener, this);
        
        File cfile = new File(getDataFolder(), "config.yml");
        if(!cfile.exists()) {
            getConfig().options().copyDefaults(true);
            saveConfig();
        }
        
        config.load();
    }
}
