package net.chromaryu.discordgaming.commands.dm;

import net.chromaryu.discordgaming.abs.Command;
import net.dv8tion.jda.core.entities.*;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by midgard on 17/03/05.
 */
public class dive extends Command {
    @Override
    public void onInvoke(Guild guild, TextChannel channel, Member invoker, Message message, String[] args, boolean ip) {
        invoker.getUser().openPrivateChannel().queue(
                loading -> {
                    loading.sendMessage("Loading...").queue(
                            privchan -> {
                                SecureRandom random = null;
                                try {

                                    random = SecureRandom.getInstance("NativePRNGNonBlocking");
                                    random.setSeed(invoker.getUser().getName().getBytes());
                                } catch (NoSuchAlgorithmException e) {
                                    e.printStackTrace();
                                }
                                assert random != null;
                                privchan.editMessage("You dived to dungeon dungeonID:"+random.nextLong()).queue();
                            }
                    );
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
