package net.chromaryu.discordgaming.commands.dm;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.chromaryu.discordgaming.DiscordGaming;
import net.chromaryu.discordgaming.abs.Command;
import net.chromaryu.discordgaming.abs.PrivateChatCommand;
import net.chromaryu.discordgaming.config.Player;
import net.dv8tion.jda.core.entities.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;

/**
 * Created by midgard on 17/03/06.
 */
public class login extends PrivateChatCommand {

    @Override
    public void onInvoke(PrivateChannel pc, Message m, User u, String[] args) {
        if(args.length < 1) {
            return;
        }
        pc.sendMessage("Loading...").queue(
                loading -> {
                    Player p = null;
                    String password = args[1];
                    assert password != null;
                    String hash = DigestUtils.sha512Hex(password);
                    ObjectMapper objectMapper = new ObjectMapper();
                    try {
                        p = objectMapper.readValue(new File("char/" + u.getName() + "#" + u.getDiscriminator() + ".json"), Player.class);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    assert p != null;
                    if (p.getPassword().equals(hash)) {
                        DiscordGaming.logined.put(u.getName() + "#" + u.getDiscriminator(), p);
                        loading.editMessage("Loaded!").queue();
                        return;
                    }
                    loading.editMessage("Failed...").queue();
                });
    }
}
