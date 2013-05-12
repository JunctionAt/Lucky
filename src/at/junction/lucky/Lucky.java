package at.junction.lucky;

import java.io.File;
import java.util.HashMap;

import org.bukkit.plugin.java.JavaPlugin;

public class Lucky extends JavaPlugin {
    LuckyListener listener = new LuckyListener(this);
    Configuration config = new Configuration(this);
    public HashMap<String, Integer> playerDeaths = new HashMap<>();

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
