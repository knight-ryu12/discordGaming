package net.chromaryu.discordgaming.dungeon;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by midgard on 17/03/19.
 */
public class DungeonLevel {
    private SecureRandom sr;
    private long seed;
    DungeonLevel(SecureRandom sr,long seed) {
        this.sr = sr;
        this.seed = seed;
        this.sr.setSeed(seed);
    }
    HashMap<Integer,String> dgl = new HashMap<>();
}
