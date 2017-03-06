package net.chromaryu.discordgaming.api;

import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.config.LangLoader;

/**
 * Created by midgard on 17/03/06.
 */
public class getLang {
    public static LangLoader getLanguage(String lang) {
        if(!DiscordGaming.languages.containsKey(lang)) {
            return DiscordGaming.languages.get("en_US");
        }
        return DiscordGaming.languages.get(lang);
    }
}
