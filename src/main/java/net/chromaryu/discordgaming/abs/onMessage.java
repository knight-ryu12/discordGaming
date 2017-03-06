package net.chromaryu.discordgaming.abs;

import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.commands.dive;
import net.chromaryu.discordgaming.commands.help;
import net.chromaryu.discordgaming.commands.register;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by midgard on 17/03/05.
 */
public class onMessage extends ListenerAdapter {
    private String[] args;
    Logger logger = LoggerFactory.getLogger(onMessage.class);

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getMessage().getContent().startsWith(DiscordGaming.COMMAND_PREFIX)) {
            args = event.getMessage().getContent().split(" ",2);

        } else return;
        if(args.length < 2) {
            help.giveHelp(event.getAuthor());
            logger.info("");
            return;
        }
        logger.info("Command Recieved {}",args[1]);
        switch (args[1].toLowerCase()) {
            case "help":
                help.giveHelp(event.getAuthor());
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + " **Check DM for info!**").queue();
                break;
            case "dive":
                dive.dive(event.getAuthor());
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + " **Check DM for info!**").queue();
                break;
            case "register":
                try {
                    register.register(event.getAuthor());
                    event.getChannel().sendMessage(event.getAuthor().getAsMention() + " **Check DM for info!**").queue();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                help.giveHelp(event.getAuthor());
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + " **Check DM for info!**").queue();
        }
    }
}
