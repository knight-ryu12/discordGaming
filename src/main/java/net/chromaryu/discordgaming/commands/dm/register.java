package net.chromaryu.discordgaming.commands.dm;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.abs.Command;
import net.chromaryu.discordgaming.config.Player;
import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.temporal.ChronoUnit;

/**
 * Created by midgard on 17/03/06.
 */
public class register extends Command {
    @Override
    public void onInvoke(Guild guild, TextChannel channel, Member invoker, Message message, String[] args) {
        User u = invoker.getUser();
        File f = new File("char/");
        Player player;
        File charFile = new File("char/"+u.getName()+"#"+u.getDiscriminator()+".json");
        if(!charFile.exists()) {
            try {
                SecureRandom random = SecureRandom.getInstance("NativePRNGBlocking"); // Ready PRNG/TRNG /dev/urandom
                random.setSeed(u.getName().getBytes()); // Seeding their username ^^
                //byte[] randchar = new byte[8];
                String rand = RandomStringUtils.random(8,0,0,true,true,null,random);
                player = new Player(u,rand);
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.enable(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY);
                objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                objectMapper.writeValue(charFile, player);

            u.openPrivateChannel().queue(
                    privateChannel -> privateChannel.sendMessage("Loading...").queue(
                            loading -> {

                                EmbedBuilder eb = new EmbedBuilder();
                                eb.setColor(new Color(255, 102, 25));
                                eb.addField("Welcome to Dungeon Master!", "Hello. Your character has been created!", true);
                                eb.addField("Password", "Your current password is **" + rand + "**! Remember to change them to strong password!", true);
                                eb.setTitle("Dungeon Master Notice", null);
                                eb.setFooter("Done in " + message.getCreationTime().until(loading.getCreationTime(), ChronoUnit.MILLIS) + "ms", null);
                                loading.editMessage(eb.build()).queue();
                            }));

        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        }
    }
    /*public static void tryRegister(User u, Message m) throws IOException {
        File f = new File("char/");
        File charFile = new File("char/"+u.getName()+"#"+u.getDiscriminator()+".json");
        f.mkdir();
        if(!charFile.exists()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(charFile, new Player(u));
            u.openPrivateChannel().queue(
                    privateChannel -> privateChannel.sendMessage("Loading...").queue(
                        loading -> {

                            EmbedBuilder eb = new EmbedBuilder();
                            eb.setColor(new Color(255, 102, 25));
                            eb.addField("Welcome to Dungeon Master!", "Hello. Your character has been created!", true);
                            eb.addField("Password", "Your current password is your current username **" + u.getName() + "**!", true);
                            eb.setTitle("Dungeon Master Notice", null);
                            eb.setFooter("Done in " + m.getCreationTime().until(loading.getCreationTime(), ChronoUnit.MILLIS) + "ms", null);
                            loading.editMessage(eb.build()).queue();
                        }));
        }
    }*/
}
       


