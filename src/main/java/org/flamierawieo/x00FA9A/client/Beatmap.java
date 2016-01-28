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
        for(File f : new File("custom/beatmaps").listFiles()) {
            try {
                Beatmap beatmap = Beatmap.loadFromFile(f);
                beatmapCache.add(beatmap);
            } catch (ParseException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static List<Beatmap> getBeatmapCache() {
        return beatmapCache;
    }

    public static Beatmap loadFromFile(File file) throws IOException, ParseException {
        File infoFile = new File(file, "info.json");
        JSONObject root = (JSONObject) new JSONParser().parse(new FileReader(infoFile));
        String artist = (String) root.get("artist");
        String title = (String) root.get("title");
        String mapper = (String) root.get("mapper");
        Integer songLength = (int) (long) root.get("song_length");
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
        File ogg = new File(file, (String) root.get("ogg"));
        File background = new File(file, (String) root.get("background"));
        if(artist == null) {
            throw new IOException("artist is not specified");
        }
        if(title == null) {
            throw new IOException("title is not specified");
        }
        if(mapper == null) {
            throw new IOException("mapper is not specified");
        }
        if(songLength == null) {
            throw new IOException("length is not specified");
        }
        if(!ogg.exists()) {
            throw new FileNotFoundException(ogg.getPath());
        }
        if(!background.exists()) {
            throw new FileNotFoundException(background.getPath());
        }

        List<List<Double>> squareModeTiming = new ArrayList<>();
        JSONArray array = (JSONArray) ((JSONObject) root.get("mapping")).get("square_mode");
        if(array != null) {
            for(Object o1 : array) {
                if(o1 != null) {
                    List<Double> timing = new ArrayList<>();
                    for (Object o2 : (JSONArray) o1) {
                        if(o2 != null) {
                            timing.add((Double) o2);
                        }
                    }
                    squareModeTiming.add(timing);
                }
            }
        }
        return new Beatmap(artist, title, mapper, songLength, availableDifficulties, ogg, background, squareModeTiming);
    }

    private String artist;
    private String title;
    private String mapper;
    private Integer songLength;
    private byte availableDifficulties;
    private File ogg;
    private File background;
    private List<List<Double>> squareModeTiming;

    public Beatmap(String artist, String title, String mapper, Integer songLength, byte availableDifficulties, File ogg, File background, List<List<Double>> squareModeTiming) {
        this.artist = artist;
        this.title = title;
        this.mapper = mapper;
        this.songLength = songLength;
        this.availableDifficulties = availableDifficulties;
        this.ogg = ogg;
        this.background = background;
        this.squareModeTiming = squareModeTiming;
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

    public Integer getSongLength() {
        return songLength;
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

    public List<List<Double>> getSquareModeTiming() {
        return squareModeTiming;
    }

}
