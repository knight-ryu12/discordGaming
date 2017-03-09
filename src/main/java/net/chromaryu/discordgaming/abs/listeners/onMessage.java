package net.chromaryu.discordgaming.abs.listeners;

import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.api.getLang;
import net.chromaryu.discordgaming.commands.dive;
import net.chromaryu.discordgaming.commands.help;
import net.chromaryu.discordgaming.commands.register;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.MessageFormat;

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
            help.giveHelp(event.getAuthor(),event.getMessage());
            event.getChannel().sendMessage(MessageFormat.format(getLang.getLanguage("en_US").getLanguage().get("dminfo"),event.getAuthor().getAsMention())).queue();
            logger.info("Command Executed help");
            return;
        }
        logger.info("Command Recieved {}",args[1]);
        switch (args[1].toLowerCase()) {
            case "dive":
                dive.dive(event.getAuthor());
                event.getChannel().sendMessage(MessageFormat.format(getLang.getLanguage("en_US").getLanguage().get("dminfo"),event.getAuthor().getAsMention())).queue();
                break;
            case "register":
                try {
                    register.tryRegister(event.getAuthor(), event.getMessage());
                    event.getChannel().sendMessage(MessageFormat.format(getLang.getLanguage("en_US").getLanguage().get("dminfo"),event.getAuthor().getAsMention())).queue();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                help.giveHelp(event.getAuthor(),event.getMessage());
                event.getChannel().sendMessage(MessageFormat.format(getLang.getLanguage("en_US").getLanguage().get("dminfo"),event.getAuthor().getAsMention())).queue();
        }
    }
}
