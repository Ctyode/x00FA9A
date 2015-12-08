package org.flamierawieo.x00FA9A.client.audio;

import static org.flamierawieo.x00FA9A.client.Util.*;
import static org.lwjgl.openal.AL10.*;

public class Sound {

    private int source;
    private int buffer;

    public Sound(int buffer) {
        this.buffer = buffer;
        al(() -> {
            source = alGenSources();
            alSourcei(source, AL_BUFFER, buffer);
        });
    }

    public void play() {
        al(() -> alSourcePlay(source));
    }

    public void stop() {
        al(() -> alSourceStop(source));
    }

    // TODO: finalize

}
