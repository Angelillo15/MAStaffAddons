package es.angelillo15.mast.module.discord.bungee.listener;

import es.angelillo15.mast.api.event.bungee.staff.StaffLeaveEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class OnLeave implements Listener {
    @EventHandler
    public void onLeave(StaffLeaveEvent event){
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
