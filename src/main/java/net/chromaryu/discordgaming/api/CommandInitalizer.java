package net.chromaryu.discordgaming.api;

import net.chromaryu.discordgaming.abs.CommandRegistry;
import net.chromaryu.discordgaming.commands.dive;
import net.chromaryu.discordgaming.commands.help;
import net.chromaryu.discordgaming.commands.register;

/**
 * Created by midgard on 17/03/09.
 */
public class CommandInitalizer {
    public static void initCommands() {
        CommandRegistry.registerCommand("dive",new dive());
        CommandRegistry.registerCommand("help",new help());
        CommandRegistry.registerCommand("register",new register());
    }
}
