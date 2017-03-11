package net.chromaryu.discordgaming.commands;

import net.chromaryu.discordgaming.abs.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;

import java.awt.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by midgard on 17/03/05.
 */
public class Help extends Command {
    @Override
    public void onInvoke(Guild guild, TextChannel channel, Member invoker, Message message, String[] args, boolean ip) {
        invoker.getUser().openPrivateChannel().queue( pc ->
                pc.sendMessage("Loading").queue(
                        privateChannel -> {
                            privateChannel.editMessage(new EmbedBuilder()
                                    .setTitle("Dungeon Master Help!", "")
                                    .addField("!!dive", "-Dives to a dungeon.", true)
                                    .addField("!!Register", "-Registers your account.", true)
                                    .addField("!!Help", "-Shows this Help message.", true)
                                    .addField("", "Help is always needed!", true)
                                    .setFooter("Done in: " + message.getCreationTime().until(privateChannel.getCreationTime(), ChronoUnit.MILLIS) + "ms", "")
                                    .setColor(new Color(255, 135, 24))
                                    .build()).queue();
                        }
                )
        );
    }
}
    /*public static void giveHelp(User u, Message m) {
        u.openPrivateChannel().queue(pc -> {
            pc.sendMessage("Loading").queue(
                privateChannel -> {
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.addField("Dive","(WIP) Dive to dungeon",true);
                    eb.addField("Register","(WIP) Register your account to bot",true);
                    eb.addField("Help","this Embed.",true);
                    eb.setColor(new Color(255, 135, 24));
                    eb.setTitle("Dungeon Master Help menu",null);
                    eb.addField("if you can Help me...","",false);
                    eb.setFooter("Done in " + m.getCreationTime().until(privateChannel.getCreationTime(), ChronoUnit.MILLIS) + "ms", null);
                    privateChannel.editMessage(eb.build()).queue();

                }
            );
        });
    }*/

