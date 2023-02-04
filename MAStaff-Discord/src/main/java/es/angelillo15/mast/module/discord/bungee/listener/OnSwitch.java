package es.angelillo15.mast.module.discord.bungee.listener;

import es.angelillo15.mast.api.event.bungee.staff.StaffSwitchServerEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class OnSwitch implements Listener {
    @EventHandler
    public void onSwitch(StaffSwitchServerEvent event){
        DiscordWebhook webhook = new DiscordWebhook(Config.StaffSwitch.getWebhookUrl());

        webhook.setUsername(Config.StaffSwitch.getWebhookName().replace("{player}",
                event.getPlayer().getName())
        );

        webhook.setAvatarUrl(Config.StaffSwitch.getWebhookAvatar().replace("{player}",
                event.getPlayer().getName())
        );

        webhook.setContent(Config.StaffSwitch.getWebhookMessage().replace("{player}",
                        event.getPlayer().getName())
                .replace("{previous_server}", event.getPreviousServer())
                .replace("{server}", event.getNewServer())
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
