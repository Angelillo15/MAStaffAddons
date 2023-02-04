package es.angelillo15.mast.module.discord.bukkit.listener;

import es.angelillo15.mast.api.event.bukkit.staff.StaffChatTalkEvent;
import es.angelillo15.mast.module.discord.common.Config;
import es.angelillo15.mast.module.discord.bukkit.MAStaffDiscord;
import es.angelillo15.mast.module.discord.bukkit.utils.DiscordWebhook;
import lombok.SneakyThrows;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnStaffChatMessage implements Listener {
    public OnStaffChatMessage() {
        MAStaffDiscord.getPlogger().debug("OnStaffChatMessage listener loaded!");
    }

    @SneakyThrows
    @EventHandler
    public void onStaffChat(StaffChatTalkEvent event) {
        MAStaffDiscord.getPlogger().debug("StaffChat event triggered!");
        DiscordWebhook webhook = new DiscordWebhook(Config.StaffChat.getWebhookUrl());

        webhook.setUsername(Config.StaffChat.getWebhookName().replace("{player}",
                event.getSender().getName())
        );

        webhook.setAvatarUrl(Config.StaffChat.getWebhookAvatar().replace("{player}",
                event.getSender().getName())
        );

        webhook.setContent(Config.StaffChat.getWebhookMessage().replace("{player}",
                event.getSender().getName())
                .replace("{message}", ChatColor.stripColor(event.getMessage()))
        );

        webhook.execute();
    }
}
