package org.flamierawieo.x00FA9A.client.audio;

import static org.lwjgl.openal.AL10.*;

public class Sound {

    private int source;
    private int buffer;

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

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        alDeleteSources(source);
    }
}
