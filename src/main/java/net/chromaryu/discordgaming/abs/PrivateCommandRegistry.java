package net.chromaryu.discordgaming.abs;

import java.util.HashMap;

/**
 * Created by midgard on 17/03/11.
 */
public class PrivateCommandRegistry {
    private static HashMap<String, PrivateCommandRegistry.CommandEntry> registry = new HashMap<>();
    public static void registerCommand(String name, PrivateChatCommand command) {
        PrivateCommandRegistry.CommandEntry entry = new PrivateCommandRegistry.CommandEntry(command, name);
        registry.put(name, entry);
    }

    public static void registerAlias(String command, String alias) {
        registry.put(alias, registry.get(command));
    }

    public static PrivateCommandRegistry.CommandEntry getCommand(String name) {
        return registry.get(name);
    }

    public static class CommandEntry {

        public PrivateChatCommand command;
        public String name;

        CommandEntry(PrivateChatCommand command, String name) {
            this.command = command;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setCommand(PrivateChatCommand command) {
            this.command = command;
        }
    }
}
