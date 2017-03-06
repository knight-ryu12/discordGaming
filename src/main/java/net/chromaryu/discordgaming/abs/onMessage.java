package net.chromaryu.discordgaming.abs;

import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.commands.dive;
import net.chromaryu.discordgaming.commands.help;
import net.chromaryu.discordgaming.commands.register;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.io.IOException;

/**
 * Created by midgard on 17/03/05.
 */
public class onMessage extends ListenerAdapter {
    private String[] args;
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContent().startsWith(DiscordGaming.COMMAND_PREFIX)) {
            args = event.getMessage().getContent().split(" ");
        } else return;
        if(args.length < 2) {
            help.giveHelp(event.getAuthor());
            return;
        }
        switch (args[1].toLowerCase()) {
            case "help":
                help.giveHelp(event.getAuthor());
                break;
            case "dive":
                dive.dive(event.getAuthor());
                break;
            case "register":
                try {
                    register.register(event.getAuthor());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                help.giveHelp(event.getAuthor());
        }
    }
}
