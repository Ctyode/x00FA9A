package org.flamierawieo.x00FA9A.client.audio;

import org.newdawn.slick.openal.OggData;
import org.newdawn.slick.openal.OggDecoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.lwjgl.openal.AL10.*;

public class Sound {

    private int source;
    private int buffer;

    public static Sound loadFromOggFile(File file) throws IOException {
        OggData oggData = new OggDecoder().getData(new FileInputStream(file));
        int buffer = alGenBuffers();
        alBufferData(buffer, oggData.channels == 1 ? AL_FORMAT_MONO16 : AL_FORMAT_STEREO16, oggData.data, oggData.rate);
        return new Sound(buffer);
    }

    public Sound(int buffer) {
        this.buffer = buffer;
        source = alGenSources();
        alSourcei(source, AL_BUFFER, buffer);
    }

    public void play() {
        alSourcePlay(source);
    }

    public void stop() {
        alSourceStop(source);
    }

    public int getSource() {
        return source;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        alDeleteSources(source);
    }
}
