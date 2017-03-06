package net.chromaryu.discordgaming.config;

import net.dv8tion.jda.core.entities.User;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by midgard on 17/03/06.
 */
public class Player {
    public Player(User u) {
        this.name = u.getName();
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            this.password = Hex.encodeHexString(md.digest(u.getName().getBytes()));
            this.userdisc = u.getDiscriminator();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private String name,password,userdisc;
    public String getUser() {
        return this.getName()+"#"+this.getUserdisc();
    }

    public String getUserdisc() {
        return userdisc;
    }

    public void setUserdisc(String userdisc) {
        this.userdisc = userdisc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
