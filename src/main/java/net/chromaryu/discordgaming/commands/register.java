package net.chromaryu.discordgaming.commands;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.chromaryu.discordgaming.config.PlayerInfoLoader;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.User;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by midgard on 17/03/06.
 */
public class register {
    public static void register(User u, Message m) throws IOException {
        File f = new File("char/");
        File charFile = new File("char/"+u.getName()+"#"+u.getDiscriminator()+".json");
        f.mkdir();
        if(!charFile.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(charFile, new PlayerInfoLoader(u));
            u.openPrivateChannel().queue(
                    privateChannel -> {
                        privateChannel.sendMessage("Loading...").queue(
                            loading -> {
                                
                                EmbedBuilder eb = new EmbedBuilder();
                                eb.setColor(new Color(255, 102, 25));
                                eb.addField("Welcome to Dungeon Master!", "Hello. Your character have been made!", true);
                                eb.addField("Password", "Your current password is your current username **" + u.getName() + "**!", true);
                                eb.setTitle("Dungeon Master Notice", null);
                                eb.setFooter("Done in " + m.getCreationTime().until(loading.getCreationTime(), ChronoUnit.MILLIS) + "ms", null);
                                loading.editMessage(eb.build()).queue();
                            });     
                    });
        }
    }
}
       
}

