package es.angelillo15.mast.module.discord.bukkit.listener.staff;

import es.angelillo15.mast.api.event.bukkit.staff.StaffEnableEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnStaffModeEnable implements Listener {
    @EventHandler
    public void onStaffModeEnable(StaffEnableEvent event){
        DiscordWebhook webhook = new DiscordWebhook(Config.StaffEnable.getWebhookUrl());

        webhook.setUsername(Config.StaffEnable.getWebhookName().replace("{player}",
                event.getStaffPlayer().getPlayer().getName())
        );

        webhook.setAvatarUrl(Config.StaffEnable.getWebhookAvatar().replace("{player}",
                event.getStaffPlayer().getPlayer().getName())
        );

        webhook.setContent(Config.StaffEnable.getWebhookMessage().replace("{player}",
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
