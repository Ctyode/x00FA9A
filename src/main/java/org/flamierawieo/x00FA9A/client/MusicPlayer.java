package org.flamierawieo.x00FA9A.client;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.Music;

import java.io.FileInputStream;
import java.io.IOException;

public class MusicPlayer {

    private Music music;

    MusicPlayer() {
        try {
            music = new Music("res/testmusic/05 Canada Was The Largest Eurodance Market Outside Europe.ogg", false);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        music.play();
    }

}
