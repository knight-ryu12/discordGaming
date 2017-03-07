package net.chromaryu.discordgaming.config;

import java.util.HashMap;

/**
 * Created by midgard on 17/03/06.
 */
public class LangLoader {
    private HashMap<String,String> langs = new HashMap<>();

    public HashMap<String, String> getLanguage() {
        return langs;
    }

    public void setLanguage(HashMap<String, String> language) {
        this.langs = language;
    }
}
