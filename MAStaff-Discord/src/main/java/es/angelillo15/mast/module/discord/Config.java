package es.angelillo15.mast.module.discord;

import lombok.Getter;
import lombok.Setter;
import org.simpleyaml.configuration.file.YamlFile;

public class Config {
    @Getter
    @Setter
    private static YamlFile config;

    public static class StaffChat {
        public static String getWebhookUrl() {
            return config.getString("StaffChat.webhook");
        }

        public static String getWebhookName() {
            return config.getString("StaffChat.name");
        }

        public static String getWebhookAvatar() {
            return config.getString("StaffChat.avatar");
        }

        public static String getWebhookMessage() {
            return config.getString("StaffChat.message");
        }
    }
}

