package net.chromaryu.discordgaming.abs;

/**
 * Created by midgard on 17/03/09.
 */
import net.dv8tion.jda.core.entities.*;

public interface ICommand {

    public abstract void onInvoke(Guild guild, TextChannel channel, Member invoker, Message message, String[] args, boolean isprivate);
    //public abstract void onInvokeinPC(PrivateChannel pc,Member invoker,Message message,String[] args);

}