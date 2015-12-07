package org.flamierawieo.x00FA9A.client.audio;

import org.newdawn.slick.openal.OggData;
import org.newdawn.slick.openal.OggDecoder;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;

import static org.flamierawieo.x00FA9A.client.Util.*;
import static org.lwjgl.openal.AL10.*;

public class Sound {

    private int source;
    private int buffer;
    private int state;

    public Sound(String path) throws IOException, UnsupportedAudioFileException {
        OggData oggData = new OggDecoder().getData(new FileInputStream(path));
        al(() -> {
            source = alGenSources();
            buffer = alGenBuffers();
            alBufferData(buffer, oggData.channels == 1 ? AL_FORMAT_MONO16 : AL_FORMAT_STEREO16, oggData.data, oggData.rate);
            alSourcei(source, AL_BUFFER, buffer);
        });
    }

    public void play() {
        al(() -> {
            alSourcePlay(source);
            state = alGetSourcei(source, AL_SOURCE_STATE);
        });
        if(state != AL_PLAYING) {
            System.out.println("nickta zloi");
        }
    }

    public void stop() {
        al(() -> {
            alSourceStop(source);
            state = alGetSourcei(source, AL_SOURCE_STATE);
        });
    }

    // TODO: finalize

}
