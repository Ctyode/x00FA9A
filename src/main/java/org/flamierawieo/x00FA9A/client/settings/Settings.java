package org.flamierawieo.x00FA9A.client.settings;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Settings {

    public static final String userSettingsJsonPath = "res/user_settings.json";

    private VideoMode videoMode;

    private static void dumpUserSettings(Settings settings) throws IOException {
        settings.getJson().writeJSONString(new FileWriter(userSettingsJsonPath));
    }

    public static Settings loadUserSettings() {
        Settings userSettings = new Settings(VideoMode.NORMAL_800x600);
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject userSettingsJson = (JSONObject) jsonParser.parse(new FileReader(userSettingsJsonPath));
            if(userSettingsJson.containsKey("video_mode")) {
                userSettings.videoMode = VideoMode.getVideoModeById((String) userSettingsJson.get("video_mode"));
            }
        } catch (IOException | ParseException e) {
            // file does not exists or is invalid
            // generatin' new one, m8
            userSettings.save();
        }
        return userSettings;
    }

    public Settings(VideoMode videoMode) {
        this.videoMode = videoMode;
    }

    public VideoMode getVideoMode() {
        return videoMode;
    }

    public void save() {
        try {
            dumpUserSettings(this);
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
