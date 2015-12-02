package org.flamierawieo.x00FA9A.client;

import de.matthiasmann.twl.utils.PNGDecoder;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;

public class Resources {

    private static Map<String, Integer> textures = new HashMap<>();
    private static Integer missingTextureTextureID;

    private static int loadTextureFromPNG(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        PNGDecoder decoder = new PNGDecoder(inputStream);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * decoder.getWidth() * decoder.getHeight());
        decoder.decode(byteBuffer, decoder.getWidth() * 4, PNGDecoder.Format.RGBA);
        byteBuffer.flip();
        inputStream.close();
        int textureID = glGenTextures();
        glBindTexture(GL_TEXTURE_2D, textureID);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, decoder.getWidth(), decoder.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, byteBuffer);
        glDisable(GL_TEXTURE_2D);
        return textureID;
    }

    public static int getTexture(String path) {
        if(missingTextureTextureID == null) {
            try {
                missingTextureTextureID = loadTextureFromPNG("res/images/missing_texture.png");
            } catch(IOException e) {
                throw new RuntimeException("Can not load missing texture texture");
            }
        }
        Integer textureID = textures.get(path);
        if(textureID == null) {
            try {
                textures.put(path, textureID = loadTextureFromPNG(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(textureID == null) {
            return missingTextureTextureID;
        } else {
            return textureID;
        }
    }

}
