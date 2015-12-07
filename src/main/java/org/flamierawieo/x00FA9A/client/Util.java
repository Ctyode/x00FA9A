package org.flamierawieo.x00FA9A.client;

import org.lwjgl.openal.OpenALException;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.*;

public final class Util {

    public static void checkForOpenALErrors() {
        int alError = alGetError();
        OpenALException e = null;
        if(alError != AL_NO_ERROR) {
            if(alError == AL_INVALID_NAME) {
                e = new OpenALException("AL_INVALID_NAME");
            } else if(alError == AL_INVALID_ENUM) {
                e = new OpenALException("AL_INVALID_ENUM");
            } else if(alError == AL_INVALID_VALUE) {
                e = new OpenALException("AL_INVALID_VALUE");
            } else if(alError == AL_INVALID_OPERATION) {
                e = new OpenALException("AL_INVALID_OPERATION");
            } else if(alError == AL_OUT_OF_MEMORY) {
                e = new OpenALException("AL_OUT_OF_MEMORY");
            }
        }
        if(e != null) {
            throw e;
        }
    }

    public static void checkForOpenALCErrors(long device) {
        int alcError = alcGetError(device);
        OpenALException e = null;
        if(alcError != ALC_NO_ERROR) {
            if(alcError == ALC_INVALID_DEVICE) {
                e = new OpenALException("ALC_INVALID_DEVICE");
            } else if(alcError == ALC_INVALID_CONTEXT) {
                e = new OpenALException("ALC_INVALID_CONTEXT");
            } else if(alcError == ALC_INVALID_ENUM) {
                e = new OpenALException("ALC_INVALID_ENUM");
            } else if(alcError == ALC_INVALID_VALUE) {
                e = new OpenALException("ALC_INVALID_VALUE");
            } else if(alcError == ALC_OUT_OF_MEMORY) {
                e = new OpenALException("ALC_OUT_OF_MEMORY");
            }
        }
        if(e != null) {
            throw e;
        }
    }

    public static void al(Runnable r) {
        r.run();
        checkForOpenALErrors();
    }

    public static void alc(long device, Runnable r) {
        r.run();
        checkForOpenALCErrors(device);
    }

}
