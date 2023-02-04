package es.angelillo15.mast.module.discord.bungee;

import es.angelillo15.mast.api.addons.bungee.MAStaffBungeeAddon;
import es.angelillo15.mast.api.chat.api.ChatColor;
import es.angelillo15.mast.module.discord.bungee.listener.OnStaffChat;
import es.angelillo15.mast.module.discord.common.Config;

public class MAStaffDiscord extends MAStaffBungeeAddon {
    @Override
    public void onEnable() {
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "MAStaff-Discord has been enabled!"));
        loadConfig();
        Config.setConfig(getConfig().getConfig());
        loadListeners();
    }

    public void loadListeners() {
        getMastaffInstance().getProxy().getPluginManager().registerListener(getMastaffInstance(), new OnStaffChat());
    }
    @Override
    public void onDisable() {

    }
}
