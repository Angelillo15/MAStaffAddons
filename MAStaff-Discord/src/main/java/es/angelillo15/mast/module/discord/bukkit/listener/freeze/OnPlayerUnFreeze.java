package es.angelillo15.mast.module.discord.bukkit.listener.freeze;

import es.angelillo15.mast.api.event.bukkit.freeze.UnFreezePlayerEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnPlayerUnFreeze implements Listener {
    @EventHandler
    public void onPlayerUnfreeze(UnFreezePlayerEvent event) {
        DiscordWebhook webhook = new DiscordWebhook(Config.Unfreeze.getWebhookUrl());

        webhook.setUsername(Config.Unfreeze.getWebhookName().replace("{player}",
                event.getFreezerPlayer().getName())
                .replace("{target}", event.getFrozenPlayer().getName())
        );

        webhook.setAvatarUrl(Config.Unfreeze.getWebhookAvatar().replace("{player}",
                event.getFreezerPlayer().getName())
                .replace("{target}", event.getFrozenPlayer().getName())
        );

        webhook.setContent(Config.Unfreeze.getWebhookMessage().replace("{player}",
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
