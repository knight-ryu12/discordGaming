package net.chromaryu.discordgaming.commands.dm;

import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.abs.Command;
import net.chromaryu.discordgaming.abs.PrivateChatCommand;
import net.chromaryu.discordgaming.config.Player;
import net.dv8tion.jda.core.entities.*;

/**
 * Created by midgard on 17/03/06.
 */
public class login extends PrivateChatCommand {

    @Override
    public void onInvoke(PrivateChannel pc, Message m, User u, String[] args) {
        pc.sendMessage("test!").queue();
    }
}
