package es.angelillo15.mast.module.discord.common;

import lombok.Getter;
import lombok.Setter;
import org.simpleyaml.configuration.file.YamlFile;

public class Config {
    @Getter
    @Setter
    private static YamlFile config;

    public static class StaffChat {
        public static boolean isEnabled() {
            return config.getBoolean("StaffChat.enable");
        }
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

    public static class StaffJoin {
        public static boolean isEnabled() {
            return config.getBoolean("StaffJoin.enable");
        }
        public static String getWebhookUrl() {
            return config.getString("StaffJoin.webhook");
        }

        public static String getWebhookName() {
            return config.getString("StaffJoin.name");
        }

        public static String getWebhookAvatar() {
            return config.getString("StaffJoin.avatar");
        }

        public static String getWebhookMessage() {
            return config.getString("StaffJoin.message");
        }
    }

    public static class StaffLeave {
        public static boolean isEnabled() {
            return config.getBoolean("StaffLeave.enable");
        }
        public static String getWebhookUrl() {
            return config.getString("StaffLeave.webhook");
        }

        public static String getWebhookName() {
            return config.getString("StaffLeave.name");
        }

        public static String getWebhookAvatar() {
            return config.getString("StaffLeave.avatar");
        }

        public static String getWebhookMessage() {
            return config.getString("StaffLeave.message");
        }
    }

    public static class StaffSwitch {
        public static boolean isEnabled() {
            return config.getBoolean("StaffSwitch.enable");
        }
        public static String getWebhookUrl() {
            return config.getString("StaffSwitch.webhook");
        }

        public static String getWebhookName() {
            return config.getString("StaffSwitch.name");
        }

        public static String getWebhookAvatar() {
            return config.getString("StaffSwitch.avatar");
        }

        public static String getWebhookMessage() {
            return config.getString("StaffSwitch.message");
        }
    }
}

