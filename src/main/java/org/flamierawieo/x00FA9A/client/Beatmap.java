package org.flamierawieo.x00FA9A.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Beatmap {

    private static List<Beatmap> beatmapCache = new ArrayList<>();

    static {
        try {
            JSONObject root = (JSONObject) new JSONParser().parse(new FileReader("custom/song_cache.json"));
            int fileListHash = 0;
            for(File f : new File("custom/beatmaps").listFiles()) {
                fileListHash ^= f.hashCode();
            }
            if(((Long) root.get("file_list_hash")).intValue() == fileListHash) {
                JSONArray cache = (JSONArray) root.get("cache");
                for (Object o : cache) {
                    JSONObject cacheItem = (JSONObject) o;
                    beatmapCache.add(new Beatmap((String) cacheItem.get("artist"), (String) cacheItem.get("title"), (String) cacheItem.get("mapper"), (byte) 0b00000000, null, null));
                }
            } else {
                updateBeatmapCache();
            }
        } catch(FileNotFoundException e) {
            updateBeatmapCache();
        } catch(IOException | ParseException e) {
            e.printStackTrace();
            updateBeatmapCache();
        }
    }

    public static List<Beatmap> getBeatmapCache() {
        return beatmapCache;
    }

    public static void updateBeatmapCache() {
        JSONObject root = new JSONObject();
        int fileListHash = 0;
        File[] fileList = new File("custom/beatmaps").listFiles();
        for(File f : fileList) {
            fileListHash ^= f.hashCode();
        }
        root.put("file_list_hash", fileListHash);
        JSONArray cache = new JSONArray();
        for(File f : fileList) {
            try {
                cache.add(Beatmap.loadFromFile(f).toCacheJSONObject());
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
        root.put("cache", cache);
        try {
            Writer fileWriter = new FileWriter("custom/song_cache.json");
            root.writeJSONString(fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch(IOException ioException) {
            throw new RuntimeException(ioException);
        }
    }

    public static Beatmap loadFromFile(File file) throws IOException, ParseException {
        File infoFile = file.listFiles(pathname -> "info.json".equals(pathname.getName()))[0];
        JSONObject root = (JSONObject) new JSONParser().parse(new FileReader(infoFile));
        String artist = (String) root.get("artist");
        String title = (String) root.get("title");
        String mapper = (String) root.get("mapper");
        byte availableDifficulties = 0b00000000;
        for(Object difficulty : (JSONArray) root.get("available_difficulties")) {
            switch(((Long) difficulty).intValue()) {
                case(1): availableDifficulties |= 0b00000001; break;
                case(2): availableDifficulties |= 0b00000010; break;
                case(3): availableDifficulties |= 0b00000100; break;
                case(4): availableDifficulties |= 0b00001000; break;
                case(5): availableDifficulties |= 0b00010000; break;
                case(6): availableDifficulties |= 0b00100000; break;
                case(7): availableDifficulties |= 0b01000000; break;
            }
        }
        File ogg = new File((String) root.get("ogg"));
        File background = new File((String) root.get("background"));
        return new Beatmap(artist, title, mapper, availableDifficulties, ogg, background);
    }

    private String artist;
    private String title;
    private String mapper;
    private byte availableDifficulties;
    private File ogg;
    private File background;

    private Beatmap(String artist, String title, String mapper, byte availableDifficulties, File ogg, File background) {
        this.artist = artist;
        this.title = title;
        this.mapper = mapper;
        this.availableDifficulties = availableDifficulties;
        this.ogg = ogg;
        this.background = background;
    }

    public JSONObject toCacheJSONObject() {
        return new JSONObject() {{
            put("artist", artist);
            put("title", title);
            put("mapper", mapper);
            put("availableDifficulties", new JSONArray() {{
                if((availableDifficulties & 0b00000001) != 0) {
                    add(1);
                }
                if((availableDifficulties & 0b00000010) != 0) {
                    add(2);
                }
                if((availableDifficulties & 0b00000100) != 0) {
                    add(3);
                }
                if((availableDifficulties & 0b00001000) != 0) {
                    add(4);
                }
                if((availableDifficulties & 0b00010000) != 0) {
                    add(5);
                }
                if((availableDifficulties & 0b00100000) != 0) {
                    add(6);
                }
                if((availableDifficulties & 0b01000000) != 0) {
                    add(7);
                }
            }});
        }};
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getMapper() {
        return mapper;
    }

    public byte getAvailableDifficulties() {
        return availableDifficulties;
    }

    public File getOgg() {
        return ogg;
    }

    public File getBackground() {
        return background;
    }

}
