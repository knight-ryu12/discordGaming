package net.chromaryu.discordgaming.commands;

import net.chromaryu.discordgaming.abs.Command;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;

import java.awt.*;
import java.time.temporal.ChronoUnit;

/**
 * Created by midgard on 17/03/05.
 */
public class help extends Command {
    @Override
    public void onInvoke(Guild guild, TextChannel channel, Member invoker, Message message, String[] args, boolean ip) {
        invoker.getUser().openPrivateChannel().queue(
                pc -> {
                    pc.sendMessage("Loading").queue(
                            privateChannel -> {
                                EmbedBuilder eb = new EmbedBuilder();
                                eb.addField("dive", "(WIP) dive to dungeon", true);
                                eb.addField("register", "(WIP) register your account to bot", true);
                                eb.addField("help", "this Embed.", true);
                                eb.setColor(new Color(255, 135, 24));
                                eb.setTitle("Dungeon Master help menu", null);
                                eb.addField("if you can help me...", "", false);
                                eb.setFooter("Done in " + message.getCreationTime().until(privateChannel.getCreationTime(), ChronoUnit.MILLIS) + "ms", null);
                                privateChannel.editMessage(eb.build()).queue();
                                });
        });
    }
}
    /*public static void giveHelp(User u, Message m) {
        u.openPrivateChannel().queue(pc -> {
            pc.sendMessage("Loading").queue(
                privateChannel -> {
                    EmbedBuilder eb = new EmbedBuilder();
                    eb.addField("dive","(WIP) dive to dungeon",true);
                    eb.addField("register","(WIP) register your account to bot",true);
                    eb.addField("help","this Embed.",true);
                    eb.setColor(new Color(255, 135, 24));
                    eb.setTitle("Dungeon Master help menu",null);
                    eb.addField("if you can help me...","",false);
                    eb.setFooter("Done in " + m.getCreationTime().until(privateChannel.getCreationTime(), ChronoUnit.MILLIS) + "ms", null);
                    privateChannel.editMessage(eb.build()).queue();

                }
            );
        });
    }*/

