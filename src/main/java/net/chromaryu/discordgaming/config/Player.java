package net.chromaryu.discordgaming.config;

import net.dv8tion.jda.core.entities.User;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.bouncycastle.crypto.digests.SHA3Digest;
import org.bouncycastle.jcajce.provider.digest.SHA3;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

/**
 * Created by midgard on 17/03/06.
 */
public class Player {
    public Player(User u,String password) {
        this.name = u.getName();
            this.password = DigestUtils.sha512Hex(password);
            //this.password = Hex.encodeHexString(md.digest());//
            this.userdisc = u.getDiscriminator();
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
