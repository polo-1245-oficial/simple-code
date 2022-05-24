package com.core.polo.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitEvent implements Listener {
    public void onquit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("§f[§c-]§f " + p.getDisplayName());
    }
}
