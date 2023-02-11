package es.angelillo15.mast.module.discord.bukkit.listener.staff;

import es.angelillo15.mast.api.event.bukkit.staff.server.StaffLeaveEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnStaffLeave implements Listener {
    @EventHandler
    public void onStaffLeave(StaffLeaveEvent event) {
        DiscordWebhook webhook = new DiscordWebhook(Config.StaffLeave.getWebhookUrl());

        webhook.setUsername(Config.StaffLeave.getWebhookName().replace("{player}",
                event.getPlayer().getName())
        );

        webhook.setAvatarUrl(Config.StaffLeave.getWebhookAvatar().replace("{player}",
                event.getPlayer().getName())
        );

        webhook.setContent(Config.StaffLeave.getWebhookMessage().replace("{player}",
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
