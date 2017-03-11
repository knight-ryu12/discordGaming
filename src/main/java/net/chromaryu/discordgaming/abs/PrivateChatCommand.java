package net.chromaryu.discordgaming.abs;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.PrivateChannel;
import net.dv8tion.jda.core.entities.User;

import java.util.ArrayList;

/**
 * Created by midgard on 17/03/11.
 */
public abstract class PrivateChatCommand implements IPrivateChatCommand {
    public void onInvoke(JDA jda, PrivateChannel pc, User user, Message message, ArrayList<String> args ) {
        String[] newA = new String[args.size()];
        int i = 0;
        for (String str : args) {
            newA[i] = str;
            i++;
        }
        onInvoke(pc,message,user,newA);
    }

}
