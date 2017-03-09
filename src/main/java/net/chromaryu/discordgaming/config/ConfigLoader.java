package net.chromaryu.discordgaming.config;

/**
 * Created by midgard on 17/03/05.
 */
public class ConfigLoader {
    private String token;
    private String commandPrefix;

    public String getCommandPrefix() {
        return commandPrefix;
    }

    public void setCommandPrefix(String commandPrefix) {
        this.commandPrefix = commandPrefix;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
