package es.angelillo15.mast.module.discord.bukkit.listener.staff;

import es.angelillo15.mast.api.event.bukkit.staff.StaffDisableEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnStaffModeDisable implements Listener {
    @EventHandler
    public void onStaffModeDisable(StaffDisableEvent event) {
        DiscordWebhook webhook = new DiscordWebhook(Config.StaffDisable.getWebhookUrl());

        webhook.setUsername(Config.StaffDisable.getWebhookName().replace("{player}",
                event.getStaffPlayer().getPlayer().getName())
        );

        webhook.setAvatarUrl(Config.StaffDisable.getWebhookAvatar().replace("{player}",
                event.getStaffPlayer().getPlayer().getName())
        );

        webhook.setContent(Config.StaffDisable.getWebhookMessage().replace("{player}",
                event.getStaffPlayer().getPlayer().getName())
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
