package net.chromaryu.discordgaming.commands;

import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.config.Player;

/**
 * Created by midgard on 17/03/06.
 */
public class login {
    public static void trylogin(Player player) {
        if(!DiscordGaming.logined.containsKey(player.getUser())) {
            DiscordGaming.logined.putIfAbsent(player.getUser(), player);
            //Login succeeded

            return;
        }
        //Nope.
    }
}
