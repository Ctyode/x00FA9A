package org.flamierawieo.x00FA9A;

import org.flamierawieo.x00FA9A.client.Resources;

public enum Images {

    CURSOR_IMAGE ("res/images/cursor.png"),
    BASIC_BACKGROUND ("res/images/background.png"),

    // Start menu
    MENU_BUTTON ("res/images/menu-buttons.png"),

    // Song menu
    SONG_LIST_BACKGROUND ("res/images/views/songmenu/songs-background.png"),
    ACTIVE_SONG_BACKGROUND ("res/images/views/songmenu/active-song-background.png"),
    SEARCH_BACKGROUND ("res/images/views/songmenu/search-background.png"),
    SELECT_MODE ("res/images/views/songmenu/select-mode.png"),

    // Square mode backgrounds
    BUTTONS_BACKGROUND ("res/images/squaremode/buttons-background.png"),
    COMBO_BACKGROUND ("res/images/squaremode/combo-background.png"),
    HP_BACKGROUND ("res/images/squaremode/hp-background.png"),
    STATS_BACKGROUND ("res/images/squaremode/stats-background.png"),

    // Square mode buttons
    GREEN_BUTTON ("res/images/squaremode/green-button.png");

    private String path;
    private Integer textureID;

    /**
     * Basic image
     * @param path to the image
     */
    Images(String path) {
        this.path = path;
        textureID = null;
    }

    /**
     * @return OpenGL texture ID
     */
    public int getTextureID() {
        if(textureID == null) {
            textureID = Resources.getTexture(path);
        }
        return textureID;
    }

}
