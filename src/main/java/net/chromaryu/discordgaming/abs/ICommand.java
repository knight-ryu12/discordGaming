package net.chromaryu.discordgaming.abs;

/**
 * Created by midgard on 17/03/09.
 */
import net.dv8tion.jda.core.entities.Guild;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.TextChannel;

public interface ICommand {

    public abstract void onInvoke(Guild guild, TextChannel channel, Member invoker, Message message, String[] args);

}