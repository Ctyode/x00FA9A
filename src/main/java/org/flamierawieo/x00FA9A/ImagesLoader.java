package org.flamierawieo.x00FA9A;

import org.newdawn.slick.Image;

import java.io.FileInputStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ImagesLoader {

    private static boolean loaded;
    private static Map<String, Image> cachedImages;

    static {
        cachedImages = new HashMap<>();
    }

    public static Image getImage(String path) {
        if(!cachedImages.containsKey(path)) {
            try {
                cachedImages.put(path, new Image(new FileInputStream(path), path, false));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cachedImages.get(path);
    }

    public static void whatDoesNicktaelSaid() {
        Logger.getLogger("Nickta").log(Level.WARNING, "THIS DANK CODE IS 2COOL4U"); // MAJESTIC GLORIOUS
    }

}
