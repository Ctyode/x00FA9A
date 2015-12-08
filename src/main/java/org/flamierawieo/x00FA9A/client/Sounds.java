package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.audio.Sound;

public enum Sounds {

    CANADA ("res/testmusic/05 Canada Was The Largest Eurodance Market Outside Europe.ogg");

    private String path;
    private Sound sound;

    Sounds(String path) {
        this.path = path;
    }

    public Sound getSound() {
        if(sound == null) {
            sound = Resources.getSound(path);
        }
        return sound;
    }

}
