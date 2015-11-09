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

    public static void whatDoesNicktaelSaid() {
        Logger.getLogger("Nickta").log(Level.WARNING, "THIS DANK CODE IS 2COOL4U"); // MAJESTIC GLORIOUS
    }


//    private static List<String> getPathsFor(String path) throws IOException {
//        File file = new File(path);
//        List<String> paths;
//        if(file.isDirectory()) {
//            File[] files = file.listFiles();
//            if(files != null) {
//                for (File listedFile : files) {
//                    getPathsFor(listedFile);
//                }
//            }
//        } else {
//            return file.getCanonicalPath();
//        }
//        return null; // TODO
//    }

//    private static void loadImages(String path) {
//        File file = new File(path);
//        if(file.isDirectory()) {
//            File[] listedFiles = file.listFiles();
//            if(listedFiles != null) {
//                for(File listedFile : listedFiles) {
//                    loadImages(listedFile.getAbsolutePath());
//                }
//            }
//        } else {
//            // cachedImages.put(path, new Image());
//            // TODO
//        }
//    }
//
//    public static void loadImages() {
//        loadImages("resources"); // TODO: root resources path
//    }
//
//    public static Image getImage(String path) {
//        return cachedImages.get(path);
//    }
//
//    @Deprecated
//    public static Map<String, Image> getImages(Predicate<String> predicate) {
//        Map<String, Image> images = new HashMap<String, Image>();
//        cachedImages.keySet().stream().filter(predicate).forEach(path -> images.put(path, cachedImages.get(path)));
//        return images;
//    }
//
//    ^ ^ ^ ^ ^
//    | | | | |
//    cute code by Nickta :3


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

}
