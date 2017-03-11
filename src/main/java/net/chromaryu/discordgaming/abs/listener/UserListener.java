package net.chromaryu.discordgaming.abs.listener;

import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

/**
 * Created by midgard on 17/03/09.
 */

public abstract class UserListener {

    public abstract void onGuildMessageReceived(GuildMessageReceivedEvent event);

}
