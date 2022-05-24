package com.core.polo;

import com.core.polo.Eventos.JoinClass;
import com.core.polo.Eventos.QuitEvent;
import com.core.polo.Manager.DiscordManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage("§aCore-basic cargado.");
        eventos();

        DiscordManager.sendStartWebhook();
    }

    @Override
    public void onDisable() {
        DiscordManager.sendStoppingWebhook();

    }

    public void eventos(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new JoinClass(), this);
        pm.registerEvents(new QuitEvent(), this);
    }
}
