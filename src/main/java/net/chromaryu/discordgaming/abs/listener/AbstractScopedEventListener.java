package net.chromaryu.discordgaming.abs.listener;

import net.chromaryu.discordgaming.DiscordGaming;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.util.HashMap;
import java.util.regex.Pattern;
/**
 * Created by midgard on 17/03/09.
 */
public abstract class AbstractScopedEventListener extends ListenerAdapter {

    public final int scope;
    static final Pattern COMMAND_NAME_PREFIX = Pattern.compile("(\\w+)");
    private final HashMap<String, UserListener> userListener = new HashMap<>();

    public static int messagesReceived = 0;

    AbstractScopedEventListener(int scope) {
        this.scope = scope;
    }

    @Override
    public void onReady(ReadyEvent event) {
        //FredBoat.onInit(event);
        DiscordGaming.onInit(event);
    }

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        UserListener listener = userListener.get(event.getAuthor().getId());
        if (listener != null) {
            try{
                listener.onGuildMessageReceived(event);
            } catch(Exception ex){
                //TextUtils.handleException(ex, event.getChannel(), event.getMember());
            }
        }
    }

    public void putListener(String id, UserListener listener) {
        userListener.put(id, listener);
    }

    public void removeListener(String id) {
        userListener.remove(id);
    }
}
