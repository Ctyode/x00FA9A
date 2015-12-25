package org.flamierawieo.x00FA9A.client.settings;

public enum VideoMode {

    NORMAL_800x600 ("normal_800x600", false, 800, 600),
    NORMAL_1024x768 ("normal_1024x768", false, 1024, 768),
    NORMAL_1152x864 ("normal_1152x864", false, 1152, 864),
    NORMAL_1280x960 ("normal_1280x960", false, 1280, 960),
    NORMAL_1280x1024 ("normal_1280x1024", false, 1280, 1024),
    NORMAL_1400x1050 ("normal_1400x1050", false, 1400, 1050),
    NORMAL_1600x1200 ("normal_1600x1200", false, 1600, 1200),
    WINDSCREEN_1024x600 ("windscreen_1024x600", true, 1024, 600),
    WINDSCREEN_1280x720 ("windscreen_1280x720", true, 1280, 720),
    WINDSCREEN_1280x768 ("windscreen_1280x768", true, 1280, 768),
    WINDSCREEN_1280x800 ("windscreen_1280x800", true, 1280, 800),
    WINDSCREEN_1360x768 ("windscreen_1360x768", true, 1360, 768),
    WINDSCREEN_1366x768 ("windscreen_1366x768", true, 1366, 768),
    WINDSCREEN_1440x900 ("windscreen_1440x900", true, 1440, 900),
    WINDSCREEN_1600x900 ("windscreen_1600x900", true, 1600, 900),
    WINDSCREEN_1680x1050 ("windscreen_1680x1050", true, 1680, 1050),
    WINDSCREEN_1920x1080 ("windscreen_1920x1080", true, 1920, 1080),
    WINDSCREEN_1920x1200 ("windscreen_1920x1200", true, 1920, 1200),
    WINDSCREEN_2048x1152 ("windscreen_2048x1152", true, 2048, 1152),
    WINDSCREEN_2560x1440 ("windscreen_2560x1440", true, 2560, 1440),
    WINDSCREEN_2560x1600 ("windscreen_2560x1600", true, 2560, 1600),
    WINDSCREEN_2880x1800 ("windscreen_2880x1800", true, 2880, 1800);

    private String id;
    private boolean windscreen;
    private int width;
    private int height;

    VideoMode(String id, boolean windscreen, int width, int height) {
        this.id = id;
        this.windscreen = windscreen;
        this.width = width;
        this.height = height;

    }

    public String getId() {
        return id;
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

    public static VideoMode getAutoDetectedVideoMode(int width, int height) {
        if(width < 1024) {
            return NORMAL_800x600;
        } else if(width < 1152) {
            if(height < 768) {
                return WINDSCREEN_1024x600;
            } else if(height == 768) {
                return NORMAL_1024x768;
            }
        } else if(width < 1280) {
            return NORMAL_1152x864;
        } else if(width < 1360) {
            if(height < 768) {
                return WINDSCREEN_1280x720;
            } else if(height >= 768 && height < 800) {
                return WINDSCREEN_1280x768;
            } else if(height == 800) {
                return WINDSCREEN_1280x800;
            }
        } else if(width < 1366) {
            return WINDSCREEN_1360x768;
        } else if(width < 1400) {
            return WINDSCREEN_1366x768;
        } else if(width < 1440) {
            return NORMAL_1400x1050;
        } else if(width < 1600) {
            return WINDSCREEN_1440x900;
        } else if(width < 1680) {
            if(height < 1200) {
                return WINDSCREEN_1600x900;
            } else if(height == 1200) {
                return NORMAL_1600x1200;
            }
        } else if(width < 1920) {
            return WINDSCREEN_1680x1050;
        } else if(width < 2048) {
            if(height < 1200) {
                return WINDSCREEN_1920x1080;
            } else if(height == 1200) {
                return WINDSCREEN_1920x1200;
            }
        } else if(width < 2560) {
            return WINDSCREEN_2048x1152;
        } else if(width < 2880) {
            if(height < 1600) {
                return WINDSCREEN_2560x1440;
            } else if(height == 1600) {
                return WINDSCREEN_2560x1600;
            }
        } else if(width == 2880) {
            return WINDSCREEN_2880x1800;
        } else {
            return NORMAL_800x600;
        }

        return NORMAL_800x600;

    }

    public static VideoMode getVideoModeById(String id) {
        switch (id) {
            case "normal_800x600":       return NORMAL_800x600;
            case "normal_1024x768":      return NORMAL_1024x768;
            case "normal_1152x864":      return NORMAL_1152x864;
            case "normal_1280x960":      return NORMAL_1280x960;
            case "normal_1280x1024":     return NORMAL_1280x1024;
            case "normal_1400x1050":     return NORMAL_1400x1050;
            case "normal_1600x1200":     return NORMAL_1600x1200;
            case "windscreen_1024x600":  return WINDSCREEN_1024x600;
            case "windscreen_1280x720":  return WINDSCREEN_1280x720;
            case "windscreen_1280x768":  return WINDSCREEN_1280x768;
            case "windscreen_1280x800":  return WINDSCREEN_1280x800;
            case "windscreen_1360x768":  return WINDSCREEN_1360x768;
            case "windscreen_1366x768":  return WINDSCREEN_1366x768;
            case "windscreen_1440x900":  return WINDSCREEN_1440x900;
            case "windscreen_1600x900":  return WINDSCREEN_1600x900;
            case "windscreen_1680x1050": return WINDSCREEN_1680x1050;
            case "windscreen_1920x1080": return WINDSCREEN_1920x1080;
            case "windscreen_1920x1200": return WINDSCREEN_1920x1200;
            case "windscreen_2048x1152": return WINDSCREEN_2048x1152;
            case "windscreen_2560x1440": return WINDSCREEN_2560x1440;
            case "windscreen_2560x1600": return WINDSCREEN_2560x1600;
            case "windscreen_2880x1800": return WINDSCREEN_2880x1800;
            default: return NORMAL_800x600;
        }

    }

}