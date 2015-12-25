package org.flamierawieo.x00FA9A.client.settings;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.lwjgl.glfw.GLFWVidMode;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;

public class Settings {

    private static Settings instance = new Settings();

    public static Settings getInstance() {
        return instance;
    }

    public static final String userSettingsJsonPath = "custom/user_settings.json";

    private VideoMode videoMode;

    private Settings() {
        JSONParser jsonParser = new JSONParser();
        try {
            JSONObject userSettingsJson = (JSONObject) jsonParser.parse(new FileReader(userSettingsJsonPath));
            if(userSettingsJson.containsKey("video_mode")) {
                videoMode = VideoMode.getVideoModeById((String) userSettingsJson.get("video_mode"));
            } else {
                // @TODO возможно подход не вписывается в обшую целостность, но по крайней мере работает
                long primaryMonitor = glfwGetPrimaryMonitor();
                GLFWVidMode vidMode = glfwGetVideoMode(primaryMonitor);
                // тут был код детекта ретины, работает только на apple java, поэтому идет нахрен
                String retina = System.getProperty("retina");
                int scale = retina.equals("true") ? 2 : 1;
                videoMode = VideoMode.getAutoDetectedVideoMode(vidMode.width() * scale, vidMode.height() * scale);
                save();
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
        JSONObject jsonObject = new JSONObject();
        if(videoMode != null) {
            jsonObject.put("video_mode", videoMode.getId());
        }
        return jsonObject;
    }

}
