package net.chromaryu.discordgaming.abs.listener;

import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.abs.Command;
import net.chromaryu.discordgaming.abs.CommandManager;
import net.chromaryu.discordgaming.abs.CommandRegistry;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.ReconnectedEvent;
import net.dv8tion.jda.core.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceJoinEvent;
import net.dv8tion.jda.core.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.core.events.message.MessageDeleteEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.regex.Matcher;

public class EventListener extends AbstractScopedEventListener {

    private static final Logger log = LoggerFactory.getLogger(EventListener.class);

    public static HashMap<String, Message> messagesToDeleteIfIdDeleted = new HashMap<>();
    private User lastUserToReceiveHelp;

    public EventListener(int scope) {
        super(scope);
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getPrivateChannel() != null) {
            log.info("PRIVATE" + " \t " + event.getAuthor().getName() + " \t " + event.getMessage().getRawContent());
            return;
        }

        if (event.getAuthor().equals(event.getJDA().getSelfUser())) {
            log.info(event.getGuild().getName() + " \t " + event.getAuthor().getName() + " \t " + event.getMessage().getRawContent());
            return;
        }

        if (event.getMessage().getContent().length() < DiscordGaming.cl.getCommandPrefix().length()) {
            return;
        }

        if (event.getMessage().getContent().substring(0, DiscordGaming.cl.getCommandPrefix().length()).equals(DiscordGaming.cl.getCommandPrefix())) {
            Command invoked = null;
            log.info(event.getGuild().getName() + " \t " + event.getAuthor().getName() + " \t " + event.getMessage().getRawContent());
            Matcher matcher = COMMAND_NAME_PREFIX.matcher(event.getMessage().getContent());

            if(matcher.find()) {
                String cmdName = matcher.group();
                CommandRegistry.CommandEntry entry = CommandRegistry.getCommand(cmdName);
                if(entry != null) {
                    invoked = entry.command;
                } else {
                    log.info("Unknown command:", cmdName);
                }
            }

            if (invoked == null) {
                return;
            }

            CommandManager.prefixCalled(invoked, event.getGuild(), event.getTextChannel(), event.getMember(), event.getMessage());
        } else if (event.getMessage().getRawContent().startsWith("<@" + event.getJDA().getSelfUser().getId() + ">")) {
            log.info(event.getGuild().getName() + " \t " + event.getAuthor().getName() + " \t " + event.getMessage().getRawContent());
            CommandManager.commandsExecuted++;
            //TalkCommand.talk(event.getMember(), event.getTextChannel(), event.getMessage().getRawContent().substring(event.getJDA().getSelfUser().getAsMention().length() + 1));
        }
    }

    @Override
    public void onMessageDelete(MessageDeleteEvent event) {
        if (messagesToDeleteIfIdDeleted.containsKey(event.getMessageId())) {
            Message msg = messagesToDeleteIfIdDeleted.remove(event.getMessageId());
            if (msg.getJDA() == event.getJDA()) {
                msg.delete().queue();
            }
        }
    }

    @Override
    public void onReady(ReadyEvent event) {
        super.onReady(event);
        //event.getJDA().getPresence().setGame(Game.of("Say " + Config.CONFIG.getPrefix() + "help"));
    }

    /* music related */


}