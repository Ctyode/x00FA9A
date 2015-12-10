package org.flamierawieo.x00FA9A.client.ui.widgets;

import org.flamierawieo.x00FA9A.client.ui.Widget;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class SongList extends Widget {

    public SongList(float x, float y, float width, float height, float originX, float originY) {
        super(x, y, width, height, originX, originY);

        JSONParser parser = new JSONParser();
        try {
            JSONObject root = (JSONObject) parser.parse(new FileReader("res/json/song_cache.json"));
            String uuid = (String) root.get("cache_uuid");
            System.out.println(uuid);
            JSONArray songs = (JSONArray) root.get("songs");
            songs.forEach(s -> {
                JSONObject song = (JSONObject) s;
                System.out.println(song.get("artist") + " " + song.get("title") + " " + song.get("author"));
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public SongList(float x, float y, float width, float height) {
        this(x, y, width, height, 0.0f, 0.0f);
    }

    @Override
    public void draw() {
        }

}
