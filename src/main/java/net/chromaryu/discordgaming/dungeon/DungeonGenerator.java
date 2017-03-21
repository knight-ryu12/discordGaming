package net.chromaryu.discordgaming.dungeon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 * Created by midgard on 17/03/06.
 */
public class DungeonGenerator extends Thread {
    private SecureRandom sr = null;
    private long seed;
    private int depth;
    public DungeonGenerator(SecureRandom sr,long seed,int depth){
        this.sr = sr;
        this.sr.setSeed(seed);
        this.seed = seed;
        this.depth = depth;
    }

    private Logger l = LoggerFactory.getLogger(DungeonGenerator.class);
    @Override
    public void run() {
        ArrayList<Dungeon> dl = new ArrayList<>();
        l.info("Dungeon Generate started. TID:"+this.getId());
        l.info("Seed is:"+this.seed);
        for(int i =0;i<=this.depth;i++) {
            l.info("Loop:"+i);

        }

        // Write something here
    }
}
