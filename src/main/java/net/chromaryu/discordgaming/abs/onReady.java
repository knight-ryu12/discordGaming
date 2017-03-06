package net.chromaryu.discordgaming.abs;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by midgard on 17/03/06.
 */
public class onReady extends ListenerAdapter{
    Logger logger = LoggerFactory.getLogger(onReady.class);
    @Override
    public void onReady(ReadyEvent event) {
        logger.info("Ready! RespNo:{}",event.getResponseNumber());
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        logger.info("Guild Joined:{}",event.getGuild().getName());
    }
}
