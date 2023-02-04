package es.angelillo15.mast.module.discord.bukkit;

import es.angelillo15.mast.api.ILogger;
import es.angelillo15.mast.api.addons.MAStaffAddon;
import es.angelillo15.mast.module.discord.bukkit.listener.OnStaffChatMessage;
import lombok.Getter;

public class MAStaffDiscord extends MAStaffAddon {
    @Getter
    private static ILogger Plogger;

    @Override
    public void onEnable() {
        super.onEnable();
        Plogger = getLogger();
    }

    public void loadListeners() {
        getMastaffInstance().getServer().getPluginManager().registerEvents(new OnStaffChatMessage(), getMastaffInstance());
    }
}
