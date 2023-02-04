package es.angelillo15.mast.module.discord;

import es.angelillo15.mast.api.TextUtils;

public class MAStaffDiscordLoader extends MAStaffDiscord {
    @Override
    public void onEnable() {
        super.onEnable();
        getLogger().debug("Loading config...");
        loadConfig();
        Config.setConfig(getConfig().getConfig());
        getLogger().debug("Loading listeners...");
        loadListeners();
        getLogger().info(TextUtils.colorize("&aMAStaff-Discord has been enabled!"));
    }

    @Override
    public void onDisable() {
        super.onDisable();
        getLogger().info("MAStaff-Discord has been disabled!");
    }
}
