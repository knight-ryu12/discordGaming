package net.chromaryu.discordgaming.commands;

import net.dv8tion.jda.core.entities.User;

/**
 * Created by midgard on 17/03/05.
 */
public class help {
    public static void giveHelp(User u) {
        u.openPrivateChannel().queue(pc -> {
            pc.sendMessage("Just help text!").queue();
        });
    }

}
