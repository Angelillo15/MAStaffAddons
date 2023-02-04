package es.angelillo15.mast.module.discord.bungee.listener;

import es.angelillo15.mast.api.chat.api.ChatColor;
import es.angelillo15.mast.api.event.bungee.staffchat.StaffChatTalkEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.common.DiscordWebhook;
import lombok.SneakyThrows;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.IOException;

public class OnStaffChat implements Listener {
    @SneakyThrows
    @EventHandler
    public void onStaffChatTalk(StaffChatTalkEvent event){
        DiscordWebhook webhook = new DiscordWebhook(Config.StaffChat.getWebhookUrl());

        webhook.setUsername(Config.StaffChat.getWebhookName().replace("{player}",
                event.getPlayer().getName())
        );

        webhook.setAvatarUrl(Config.StaffChat.getWebhookAvatar().replace("{player}",
                event.getPlayer().getName())
        );

        webhook.setContent(Config.StaffChat.getWebhookMessage().replace("{player}",
                        event.getPlayer().getName())
                .replace("{message}", ChatColor.stripColor(event.getMessage()))
        );


        new Thread(() -> {
            try {
                webhook.execute();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
