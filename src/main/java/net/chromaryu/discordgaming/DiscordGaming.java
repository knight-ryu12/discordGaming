package net.chromaryu.discordgaming;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.chromaryu.discordgaming.abs.listener.EventListener;
import net.chromaryu.discordgaming.api.dmCommandInitalizer;
import net.chromaryu.discordgaming.config.ConfigLoader;
import net.chromaryu.discordgaming.config.LangLoader;
import net.chromaryu.discordgaming.config.Player;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import org.yaml.snakeyaml.Yaml;

import javax.security.auth.login.LoginException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by midgard on 17/03/05.
 */
public class DiscordGaming {
    // Static thing
    //public static String COMMAND_PREFIX = ".dm";
    public static HashMap<String,Player> logined = new HashMap<>();
    static Yaml y = new Yaml();
    static AtomicInteger num = new AtomicInteger(0);
    static EventListener el;
    public static ConfigLoader cl;
    public static HashMap<String, LangLoader> languages = new HashMap<>();
    static ClassLoader classloader = Thread.currentThread().getContextClassLoader();

    public static void main(String[] args) throws LoginException, InterruptedException, RateLimitedException, FileNotFoundException {
        ObjectMapper objectMapper = new ObjectMapper();
        cl = y.loadAs(new FileInputStream(new File("config.yml")), ConfigLoader.class);
        //ConfigLoader configLoader = null;
        try {
            //configLoader = objectMapper.readValue(new File("cred.json"),ConfigLoader.class);
            //en_JS only because... yeah I gonna update later on.
            languages.put("en_US", objectMapper.readValue(classloader.getResource("i18n/en_US.json"), LangLoader.class));

        } catch (IOException e) {
            e.printStackTrace();
        }
        //el = new EventListener(0x111);
        /*JDA jda = new JDABuilder(AccountType.BOT).setToken(cl.getToken())
                .addListener(new onMessage(),new onReady())
                .setGame(Game.of(".dm help"))
                .setAudioEnabled(false)
                .setStatus(OnlineStatus.ONLINE)
                .setIdle(false)
                .buildBlocking();
        */
        JDABuilder builder = new JDABuilder(AccountType.BOT)
                .addListener(new EventListener(0x111))
                .setAudioEnabled(false)
                .setGame(Game.of(".dm help"))
                .setIdle(false)
                .setToken(cl.getToken())
                .setStatus(OnlineStatus.ONLINE);
        JDA jda = builder.buildAsync();
    }
    public static void onInit(ReadyEvent event) {
        int ready = num.incrementAndGet();
        dmCommandInitalizer.initCommands();
    }
}