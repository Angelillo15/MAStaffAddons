package es.angelillo15.mast.module.discord.bukkit;

import es.angelillo15.mast.api.ILogger;
import es.angelillo15.mast.api.addons.MAStaffAddon;
import es.angelillo15.mast.module.discord.bukkit.listener.freeze.OnPlayerFreeze;
import es.angelillo15.mast.module.discord.bukkit.listener.freeze.OnPlayerUnFreeze;
import es.angelillo15.mast.module.discord.bukkit.listener.staff.*;
import es.angelillo15.mast.module.discord.common.Config;
import lombok.Getter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class MAStaffDiscord extends MAStaffAddon<JavaPlugin> {
    @Getter
    private static ILogger plogger;

    @Override
    public void onEnable() {
        super.onEnable();
        plogger = getLogger();
    }

    public void loadListeners() {
        if (Config.StaffChat.isEnabled()) registerListener(new OnStaffChatMessage());
        if (Config.StaffEnable.isEnabled()) registerListener(new OnStaffModeEnable());
        if (Config.StaffJoin.isEnabled()) registerListener(new OnStaffJoin());
        if (Config.StaffLeave.isEnabled()) registerListener(new OnStaffLeave());
        if (Config.StaffDisable.isEnabled()) registerListener(new OnStaffModeDisable());
        if (Config.Freeze.isEnabled()) registerListener(new OnPlayerFreeze());
        if (Config.Unfreeze.isEnabled()) registerListener(new OnPlayerUnFreeze());
    }

    public void registerListener(Listener listener) {
        getMastaffInstance().getServer().getPluginManager().registerEvents(listener, getMastaffInstance());
    }
}
