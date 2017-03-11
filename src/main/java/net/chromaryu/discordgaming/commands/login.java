package net.chromaryu.discordgaming.commands;

import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.config.Player;

/**
 * Created by midgard on 17/03/06.
 */
public class Login {
    public static void trylogin(Player player) {
        if(!DiscordGaming.logined.containsKey(player.getUserdisc())) {
            DiscordGaming.logined.putIfAbsent(player.getUserdisc(), player);
            //Login succeeded

            return;
        }
        //Nope.
    }
}