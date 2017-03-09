package net.chromaryu.discordgaming.api;

import net.chromaryu.discordgaming.abs.CommandRegistry;
import net.chromaryu.discordgaming.commands.dm.dive;
//import net.chromaryu.discordgaming.commands.dm.hash;
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
        //CommandRegistry.registerCommand("hash",new hash());
    }
}
