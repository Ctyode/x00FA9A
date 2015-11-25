package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.userskins.Skin;
import org.newdawn.slick.Input;

public class Options {

    public enum GameOption {
        DISABLE_MOUSE_BUTTONS ("Wild dog", "watching with sixteen eyes", false);
        GameOption(String name, String description, boolean value) {}
    }

    private static Skin skin;
    public static Skin getSkin() {
        return skin;
    }
}
