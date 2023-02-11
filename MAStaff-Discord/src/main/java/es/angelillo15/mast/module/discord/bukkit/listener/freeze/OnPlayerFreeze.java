package es.angelillo15.mast.module.discord.bukkit.listener.freeze;

import es.angelillo15.mast.api.event.bukkit.freeze.FreezePlayerEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerFreeze implements Listener {
    @EventHandler
    public void onPlayerFreeze(FreezePlayerEvent event) {
        DiscordWebhook webhook = new DiscordWebhook(Config.Freeze.getWebhookUrl());

        webhook.setUsername(Config.Freeze.getWebhookName().replace("{player}",
                event.getFreezerPlayer().getName())
                .replace("{target}", event.getFrozenPlayer().getName())
        );

        webhook.setAvatarUrl(Config.Freeze.getWebhookAvatar().replace("{player}",
                event.getFreezerPlayer().getName())
                .replace("{target}", event.getFrozenPlayer().getName())
        );

        webhook.setContent(Config.Freeze.getWebhookMessage().replace("{player}",
                event.getFreezerPlayer().getName())
                .replace("{target}", event.getFrozenPlayer().getName())
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
