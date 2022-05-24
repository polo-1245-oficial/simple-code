package com.core.polo.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinClass implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent e){
        Player p = e.getPlayer();
        e.setJoinMessage("§f[§a+§f]§f " + p.getDisplayName());
    }
}
