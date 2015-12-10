package org.flamierawieo.x00FA9A.client.settings;

import java.util.HashMap;
import java.util.Map;

public class VideoMode {

    public static final VideoMode NORMAL_800x600 = new VideoMode("normal_800x600", false, 800, 600);
    public static final VideoMode NORMAL_1024x768 = new VideoMode("normal_1024x768", false, 1024, 768);
    public static final VideoMode NORMAL_1152x864 = new VideoMode("normal_1152x864", false, 1152, 864);
    public static final VideoMode NORMAL_1280x960 = new VideoMode("normal_1280x960", false, 1280, 960);
    public static final VideoMode NORMAL_1400x1050 = new VideoMode("normal_1400x1050", false, 1400, 1050);
    public static final VideoMode NORMAL_1600x1200 = new VideoMode("normal_1600x1200", false, 1600, 1200);
    public static final VideoMode NORMAL_1280x1024 = new VideoMode("normal_1280x1024", false, 1280, 1024);
    public static final VideoMode WINDSCREEN_1280x720 = new VideoMode("windscreen_1280x720", true, 1280, 720);
    public static final VideoMode WINDSCREEN_1280x768 = new VideoMode("windscreen_1280x768", true, 1280, 768);
    public static final VideoMode WINDSCREEN_1360x768 = new VideoMode("windscreen_1360x768", true, 1360, 768);
    public static final VideoMode WINDSCREEN_1366x768 = new VideoMode("windscreen_1366x768", true, 1366, 768);
    public static final VideoMode WINDSCREEN_1440x900 = new VideoMode("windscreen_1440x900", true, 1440, 900);
    public static final VideoMode WINDSCREEN_1600x900 = new VideoMode("windscreen_1600x900", true, 1600, 900);
    public static final VideoMode WINDSCREEN_1920x1080 = new VideoMode("windscreen_1920x1080", true, 1920, 1080);
    public static final VideoMode WINDSCREEN_2048x1152 = new VideoMode("windscreen_2048x1152", true, 2048, 1152);
    public static final VideoMode WINDSCREEN_2560x1440 = new VideoMode("windscreen_2560x1440", true, 2560, 1440);
    public static final VideoMode WINDSCREEN_1680x1050 = new VideoMode("windscreen_1680x1050", true, 1680, 1050);
    public static final VideoMode WINDSCREEN_1280x800 = new VideoMode("windscreen_1280x800", true, 1280, 800);
    public static final VideoMode WINDSCREEN_1920x1200 = new VideoMode("windscreen_1920x1200", true, 1920, 1200);
    public static final VideoMode WINDSCREEN_1024x600 = new VideoMode("windscreen_1024x600", true, 1024, 600);
    public static final VideoMode WINDSCREEN_2560x1600 = new VideoMode("windscreen_2560x1600", true, 2560, 1600);

    private static Map<String, VideoMode> availableVideoModes = new HashMap<>();

    private String videoModeId;
    private boolean windscreen;
    private int width;
    private int height;

    VideoMode(String videoModeId, boolean windscreen, int width, int height) {
        this.videoModeId = videoModeId;
        this.windscreen = windscreen;
        this.width = width;
        this.height = height;
        availableVideoModes.put(this.videoModeId, this);
    }

    public String getVideoModeId() {
        return videoModeId;
    }

    public boolean isWindscreen() {
        return windscreen;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static VideoMode getVideoModeById(String id) {
        return availableVideoModes.getOrDefault(id, NORMAL_800x600);
    }

}
