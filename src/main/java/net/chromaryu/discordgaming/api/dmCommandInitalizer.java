package net.chromaryu.discordgaming.api;

import net.chromaryu.discordgaming.abs.CommandRegistry;
import net.chromaryu.discordgaming.abs.PrivateCommandRegistry;
import net.chromaryu.discordgaming.commands.dm.Dive;
//import net.chromaryu.discordgaming.commands.dm.hash;
import net.chromaryu.discordgaming.commands.dm.Login;
import net.chromaryu.discordgaming.commands.Help;
import net.chromaryu.discordgaming.commands.dm.Register;

/**
 * Created by midgard on 17/03/09.
 */
public class dmCommandInitalizer {
    public static void initCommands() {
        CommandRegistry.registerCommand("dive", new Dive());
        CommandRegistry.registerCommand("help", new Help());
        CommandRegistry.registerCommand("Register", new Register());
        PrivateCommandRegistry.registerCommand("Login", new Login());
        //CommandRegistry.registerCommand("hash",new hash());
    }
}
