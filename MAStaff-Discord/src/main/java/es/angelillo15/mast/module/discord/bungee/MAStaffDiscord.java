package es.angelillo15.mast.module.discord.bungee;

import es.angelillo15.mast.api.addons.bungee.MAStaffBungeeAddon;
import es.angelillo15.mast.api.chat.api.ChatColor;
import es.angelillo15.mast.module.discord.bungee.listener.OnJoin;
import es.angelillo15.mast.module.discord.bungee.listener.OnLeave;
import es.angelillo15.mast.module.discord.bungee.listener.OnStaffChat;
import es.angelillo15.mast.module.discord.bungee.listener.OnSwitch;
import es.angelillo15.mast.module.discord.common.Config;
import net.md_5.bungee.api.plugin.Listener;

public class MAStaffDiscord extends MAStaffBungeeAddon {
    @Override
    public void onEnable() {
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "MAStaff-Discord has been enabled!"));
        loadConfig();
        Config.setConfig(getConfig().getConfig());
        loadListeners();
    }

    public void loadListeners() {
        if(Config.StaffChat.isEnabled()) registerListener(new OnStaffChat());
        if(Config.StaffSwitch.isEnabled()) registerListener(new OnSwitch());
        if(Config.StaffJoin.isEnabled()) registerListener(new OnJoin());
        if(Config.StaffLeave.isEnabled()) registerListener(new OnLeave());
    }

    public void registerListener(Listener listener) {
        getMastaffInstance().getProxy().getPluginManager().registerListener(getMastaffInstance(), listener);
    }
    @Override
    public void onDisable() {

    }
}
