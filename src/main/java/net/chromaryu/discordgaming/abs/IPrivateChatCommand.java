package net.chromaryu.discordgaming.abs;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;

/**
 * Created by midgard on 17/03/11.
 */
public interface IPrivateChatCommand {
    public abstract void onInvoke(PrivateChannel pc, Message m, User u, String[] args);
}
