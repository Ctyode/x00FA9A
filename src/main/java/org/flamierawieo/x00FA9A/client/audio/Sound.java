package org.flamierawieo.x00FA9A.client.audio;


import org.gagravarr.vorbis.VorbisAudioData;
import org.gagravarr.vorbis.VorbisFile;
import org.gagravarr.vorbis.VorbisInfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.flamierawieo.x00FA9A.client.Util.*;
import static org.lwjgl.openal.AL10.*;

public class Sound {

    private int source;
    private int buffer;
    private int state;

    public Sound(String path) throws IOException {
        VorbisFile vorbisFile = new VorbisFile(new File(path));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for(VorbisAudioData packet = vorbisFile.getNextAudioPacket(); packet != null; packet = vorbisFile.getNextAudioPacket()) {
            byteArrayOutputStream.write(packet.getData());
        }
        ByteBuffer data = ByteBuffer.wrap(byteArrayOutputStream.toByteArray());
        data.flip();
        VorbisInfo vorbisInfo = vorbisFile.getInfo();
        al(() -> {
            source = alGenSources();
            buffer = alGenBuffers();
            alBufferData(buffer, vorbisInfo.getChannels() == 1 ? AL_FORMAT_MONO16 : AL_FORMAT_STEREO16, data, (int) vorbisInfo.getRate());
            alSourcei(source, AL_BUFFER, buffer);
            alSourcef(source, AL_REFERENCE_DISTANCE, 1.0f);
            alSourcef(source, AL_MAX_DISTANCE, 1000.0f);
            alSourcef(source, AL_ROLLOFF_FACTOR, 1.0f);
            alSourcef(source, AL_PITCH, 1.0f);
            alSourcef(source, AL_GAIN, 1.0f);
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
