package net.chromaryu.discordgaming.dungeon;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by midgard on 17/03/06.
 */
public class Dungeon {
    private HashMap<String,String> dungeon = new HashMap<>();
    private AtomicInteger c = new AtomicInteger();
    void addRoom(String spec){
        if(spec.equals("RANDOM")) {

        }
        dungeon.put(String.valueOf(c.incrementAndGet()),spec);
    }
}
