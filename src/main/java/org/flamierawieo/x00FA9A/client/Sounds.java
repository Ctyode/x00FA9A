package org.flamierawieo.x00FA9A.client;

public enum Sounds {

    CANADA ("res/testmusic/05 Canada Was The Largest Eurodance Market Outside Europe.ogg");

    private String path;
    private Integer sound;

    Sounds(String path) {
        this.path = path;
    }

    public Integer getSound() {
        if(sound == null) {
            sound = Resources.getSound(path);
        }
        return sound;
    }

}
