package org.flamierawieo.x00FA9A.client;

import java.util.HashMap;
import java.util.Map;

public class Resources {

    private static Map<String, Texture> textures = new HashMap<>();

    public static Texture getTexture(String path) {
        if(!textures.containsKey(path)) {
            textures.put(path, Texture.loadTextureFromPNG(path));
        }
        return textures.get(path); // TODO: optimize
    }

}
