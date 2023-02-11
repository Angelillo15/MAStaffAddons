package es.angelillo15.mast.module.discord.bukkit.listener.staff;

import es.angelillo15.mast.api.event.bukkit.staff.server.StaffJoinEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnStaffJoin implements Listener {
    @EventHandler
    public void onStaffJoin(StaffJoinEvent event){
        DiscordWebhook webhook = new DiscordWebhook(Config.StaffJoin.getWebhookUrl());

        webhook.setUsername(Config.StaffJoin.getWebhookName().replace("{player}",
                event.getPlayer().getName())
        );

        webhook.setAvatarUrl(Config.StaffJoin.getWebhookAvatar().replace("{player}",
                event.getPlayer().getName())
        );

        webhook.setContent(Config.StaffJoin.getWebhookMessage().replace("{player}",
                event.getPlayer().getName())
        );

        new Thread(() -> {
            try {
                webhook.execute();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
