package net.chromaryu.discordgaming.api;

import net.chromaryu.discordgaming.abs.CommandRegistry;
import net.chromaryu.discordgaming.abs.PrivateCommandRegistry;
import net.chromaryu.discordgaming.commands.dm.dive;
//import net.chromaryu.discordgaming.commands.dm.hash;
import net.chromaryu.discordgaming.commands.dm.login;
import net.chromaryu.discordgaming.commands.help;
import net.chromaryu.discordgaming.commands.dm.register;

/**
 * Created by midgard on 17/03/09.
 */
public class dmCommandInitalizer {
    public static void initCommands() {
        CommandRegistry.registerCommand("dive",new dive());
        CommandRegistry.registerCommand("help",new help());
        CommandRegistry.registerCommand("register",new register());
        PrivateCommandRegistry.registerCommand("login",new login());
        //CommandRegistry.registerCommand("hash",new hash());
    }
}
