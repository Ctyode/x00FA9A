package org.flamierawieo.x00FA9A;

import org.flamierawieo.x00FA9A.client.Resources;

public enum Images {

    CURSOR_IMAGE ("res/images/cursor.png"),
    BASIC_BACKGROUND ("res/images/background.png"),

    // Start menu
    MENU_BUTTON ("res/images/startmenu/menu-buttons.png"),

    //Settings menu
    SETTINGS_BACKGROUND ("res/images/settingsmenu/settings-background.png"),
    SETTINGS_LINE ("res/images/settingsmenu/settings-line.png"),

    // Song menu
    SONG_LIST_BACKGROUND ("res/images/songmenu/songs-background.png"),
    ACTIVE_SONG_BACKGROUND ("res/images/songmenu/active-song-background.png"),
    SEARCH_BACKGROUND ("res/images/songmenu/search-background.png"),
    SELECT_MODE ("res/images/songmenu/select-mode.png"),
    LIST_LINE ("res/images/songmenu/line-song-list.png"),

    // Square mode backgrounds
    BUTTONS_BACKGROUND ("res/images/squaremode/buttons-background.png"),
    COMBO_BACKGROUND ("res/images/squaremode/combo-background.png"),
    HP_BACKGROUND ("res/images/squaremode/hp-background.png"),
    STATS_BACKGROUND ("res/images/squaremode/stats-background.png"),

    // Square mode buttons
    GREEN_BUTTON ("res/images/squaremode/green-button.png");

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

}
