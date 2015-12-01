package org.flamierawieo.x00FA9A.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Resources {

    private static Map<String, Texture> textures = new HashMap<>();

    public static Texture getTexture(String path) {
        if(!textures.containsKey(path)) {
            try {
                textures.put(path, Texture.loadTextureFromPNG(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return textures.get(path); // TODO: optimize
    }

}
