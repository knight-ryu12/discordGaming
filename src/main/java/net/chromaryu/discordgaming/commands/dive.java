package net.chromaryu.discordgaming.commands;

import net.dv8tion.jda.core.entities.User;

/**
 * Created by midgard on 17/03/05.
 */
public class dive {
    public static void dive(User u) {
        u.openPrivateChannel().queue(
                privateChannel -> {
                    // Opening
                    privateChannel.sendMessage("You dived to Dungeon").queue();
                }
        );
    }
}
