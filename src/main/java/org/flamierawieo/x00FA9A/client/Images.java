package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.Resources;

import java.util.logging.Level;
import java.util.logging.Logger;

public enum Images {

    CURSOR_IMAGE ("res/images/cursor.png"),
    BASIC_BACKGROUND ("res/images/background.png"),

    // Start menu and player widget
    MENU_BUTTON ("res/images/startmenu/menu-buttons.png"),
    PLAY ("res/images/playerwidget/play.png"),
    PAUSE ("res/images/playerwidget/pause.png"),

    //Settings menu
    SETTINGS_BACKGROUND ("res/images/settingsmenu/settings-background.png"),
    SETTINGS_LINE ("res/images/settingsmenu/settings-line.png"),

    // Song menu
    SONG_LIST_BACKGROUND ("res/images/songmenu/song-list-background.png"),
    ACTIVE_SONG_BACKGROUND ("res/images/songmenu/active-song-background.png"),
    SEARCH_BACKGROUND ("res/images/songmenu/search-background.png"),
    SELECT_MODE ("res/images/songmenu/logo-background.png"),
    BOTTOM_PANEL ("res/images/songmenu/bottom-panel-background.png"),
    MAP_HEADER ("res/images/songmenu/map-header-background.png"),
    // circles
    SELECTED_DIFFICULTY ("res/images/songmenu/selected-difficulty-mark.png"),
    AVAILABLE_DIFFICULTY ("res/images/songmenu/available-difficulty-mark.png"),
    UNAVAILABLE_DIFFICULTY ("res/images/songmenu/unavailable-difficulty-mark.png"),

    // Square mode backgrounds
    BUTTONS_BACKGROUND ("res/images/squaremode/buttons-background.png"),
    COMBO_BACKGROUND ("res/images/squaremode/combo-background.png"),
    HP_BACKGROUND ("res/images/squaremode/hp-background.png"),
    STATS_BACKGROUND ("res/images/squaremode/stats-background.png"),

    // Square mode buttons
    GREEN_BUTTON ("res/images/squaremode/green-button.png"),
    PINK_BUTTON ("res/images/squaremode/pink-button.png");

    private String path;
    private Integer texture;

    /**
     * Basic image
     * @param path to the image
     */
    Images(String path) {
        this.path = path;
        texture = null;
    }

    /**
     * @return OpenGL texture
     */
    public int getTexture() {
        if(texture == null) {
            texture = Resources.getTexture(path);
        }
        return texture;
    }

    public static void whatDoesNicktaelSaid() {
        Logger.getLogger("Nickta").log(Level.WARNING, "THIS DANK CODE IS 2COOL4U"); // MAJESTIC GLORIOUS
    }

}
