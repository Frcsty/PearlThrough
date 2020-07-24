package rip.skyland.pearls;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import rip.skyland.pearls.commands.PearlCommand;
import rip.skyland.pearls.listener.EnderpearlListener;

import java.util.Objects;

public final class PearlPlugin extends JavaPlugin {

    private static PearlPlugin instance;

    public static PearlPlugin getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;

        // setup configuration
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

        // load listeners
        Bukkit.getPluginManager().registerEvents(new EnderpearlListener(), this);

        // load commands
        Objects.requireNonNull(this.getCommand("pearl")).setExecutor(new PearlCommand());
    }
}