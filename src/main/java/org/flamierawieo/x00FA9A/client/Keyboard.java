package org.flamierawieo.x00FA9A.client;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Keyboard {

    public static Keyboard loadFromFile(File file) throws IOException, ParseException {
        File keysFile = new File(file, "keys.json");
        JSONObject root = (JSONObject) new JSONParser().parse(new FileReader(keysFile));

        List<List<Integer>> keysSettings = new ArrayList<>();
        JSONArray array = (JSONArray) ((JSONObject) root.get("mode")).get("square_mode");
        if(array != null) {
            for(Object o1 : array) {
                if(o1 != null) {
                    List<Integer> keys = new ArrayList<>();
                    for (Object o2 : (JSONArray) o1) {
                        if(o2 != null) {
                            keys.add((Integer) o2);
                        }
                    }
                    keysSettings.add(keys);
                }
            }
        }
        return new Keyboard(keysSettings);
    }

    private List<List<Integer>> keysSettings;

    public Keyboard(List<List<Integer>> keysSettings) {
        this.keysSettings = keysSettings;
    }

    public List<List<Integer>> getKeysSettings() {
        return keysSettings;
    }

}
