package es.angelillo15.mast.module.discord.bungee.listener;

import es.angelillo15.mast.api.event.bungee.staff.StaffJoinEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(StaffJoinEvent event){
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
