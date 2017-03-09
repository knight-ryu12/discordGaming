package net.chromaryu.discordgaming.commands;

import net.chromaryu.discordgaming.abs.Command;
import net.dv8tion.jda.core.entities.*;

/**
 * Created by midgard on 17/03/05.
 */
public class dive extends Command {
    @Override
    public void onInvoke(Guild guild, TextChannel channel, Member invoker, Message message, String[] args) {
        invoker.getUser().openPrivateChannel().queue(
                privateChannel -> {
                    // Opening
                    privateChannel.sendMessage("You dived to Dungeon").queue();
                }
        );
    }
    /*public static void dive(User u) {
        u.openPrivateChannel().queue(
                privateChannel -> {
                    // Opening
                    privateChannel.sendMessage("You dived to Dungeon").queue();
                }
        );
    }*/

}
