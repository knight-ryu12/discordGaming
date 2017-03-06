package net.chromaryu.discordgaming.config;

import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by midgard on 17/03/06.
 */
public class PlayerInfoLoader {
    public PlayerInfoLoader(String name) {
        this.name = name;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            this.password = Hex.encodeHexString(md.digest(name.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    private String name,password;

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
