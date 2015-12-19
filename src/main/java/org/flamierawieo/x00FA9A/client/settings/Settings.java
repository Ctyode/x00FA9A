package org.flamierawieo.x00FA9A.client.settings;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Settings {

    private static Settings instance = new Settings();

    public static Settings getInstance() {
        return instance;
    }

    public static final String userSettingsJsonPath = "res/user_settings.json";

    private VideoMode videoMode;

    private Settings() {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject userSettingsJson = (JSONObject) jsonParser.parse(new FileReader(userSettingsJsonPath));
            if(userSettingsJson.containsKey("video_mode")) {
                videoMode = VideoMode.getVideoModeById((String) userSettingsJson.get("video_mode"));
            }
        } catch (IOException | ParseException e) {
            // file does not exists or is invalid
            // generatin' new one, m8
            save();
        }
    }

    public VideoMode getVideoMode() {
        return videoMode;
    }

    public void save() {
        try {
            FileWriter fileWriter = new FileWriter(userSettingsJsonPath);
            fileWriter.write(getJson().toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public JSONObject getJson() {
        return new JSONObject() {{
            put("video_mode", videoMode.getId());
        }};
    }

}