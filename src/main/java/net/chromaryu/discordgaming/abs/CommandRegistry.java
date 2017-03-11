package net.chromaryu.discordgaming.abs;

/**
 * Created by midgard on 17/03/09.
 */
import java.util.HashMap;

public class CommandRegistry {

    private static HashMap<String, CommandEntry> registry = new HashMap<>();
    public static void registerCommand(String name, Command command) {
        CommandEntry entry = new CommandEntry(command, name);
        registry.put(name, entry);
    }

    public static void registerAlias(String command, String alias) {
        registry.put(alias, registry.get(command));
    }

    public static CommandEntry getCommand(String name) {
        return registry.get(name);
    }

    public static class CommandEntry {

        public Command command;
        public String name;

        CommandEntry(Command command, String name) {
            this.command = command;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setCommand(Command command) {
            this.command = command;
        }
    }
}