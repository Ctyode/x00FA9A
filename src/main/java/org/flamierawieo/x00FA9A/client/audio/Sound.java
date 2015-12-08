package org.flamierawieo.x00FA9A.client.audio;

import org.gagravarr.ogg.OggFile;
import org.gagravarr.ogg.OggPacket;
import org.gagravarr.ogg.OggPacketReader;
import org.gagravarr.vorbis.VorbisFile;
import org.gagravarr.vorbis.VorbisInfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import static org.lwjgl.openal.AL10.*;

public class Sound {

    private int source;
    private int buffer;

    public Sound(String path) throws IOException {
        source = alGenSources();
        buffer = alGenBuffers();
        OggFile oggFile = new OggFile(new FileInputStream(path));
        OggPacketReader packetReader = oggFile.getPacketReader();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for(OggPacket packet = packetReader.getNextPacket(); packet != null; packet = packetReader.getNextPacket()) {
            byteArrayOutputStream.write(packet.getData());
        }
        VorbisFile vorbisFile = new VorbisFile(new File(path));
        VorbisInfo vorbisInfo = vorbisFile.getInfo();
        alBufferData(buffer, vorbisInfo.getChannels() == 1 ? AL_FORMAT_MONO16 : AL_FORMAT_STEREO16, ByteBuffer.wrap(byteArrayOutputStream.toByteArray()), vorbisInfo.getBlocksize0());
        alSourcef(source, AL_PITCH, 1.0f);
        alSourcef(source, AL_GAIN, 1.0f);
        alSourcei(source, AL_BUFFER, buffer);
    }

    public void play() {
        alSourcePlay(source);
        int alError = alGetError();
        if (alError != AL_NO_ERROR) {
            System.out.println("mda " + alError);
        }

    }

    public void stop() {
        alSourceStop(source);
    }

    public void checkState() {
//        if(alGetSourcei(source, AL_SOURCE_STATE) != AL_PLAYING) {
//            System.out.println("nickta zloi");
//        }
    }

    // TODO: finalize

}
