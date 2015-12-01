package org.flamierawieo.x00FA9A;

public enum Images {

    CURSOR_IMAGE ("res/images/cursor.png", true, 0.6f),
    BASIC_BACKGROUND ("res/images/background.png", false, 0.8f),

    //Start menu
    SINGLEPLAYER_BUTTON ("res/images/views/mainmenu/singleplayer-button.png", false, 0.6f),
    MULTIPLAYER_BUTTON ("res/images/views/mainmenu/multiplayer-button.png", false, 0.6f),
    OPTIONS_BUTTON ("res/images/views/mainmenu/options-button.png", false, 0.6f),
    EXIT_BUTTON ("res/images/views/mainmenu/exit-button.png", false, 0.6f),

    //Song menu
    SONG_LIST_BACKGROUND ("res/images/views/songmenu/songs-background.png", false, 0.45f),
    ACTIVE_SONG_BACKGROUND ("res/images/views/songmenu/active-song-background.png", false, 0.5f),
    SEARCH_BACKGROUND ("res/images/views/songmenu/search-background.png", false, 0.6f),
    SELECT_MODE ("res/images/views/songmenu/select-mode.png", false, 0.6f),

    //Square mode backgrounds
    BUTTONS_BACKGROUND ("res/images/squaremode/buttons-background.png", false, 0.45f),
    COMBO_BACKGROUND ("res/images/squaremode/combo-background.png", false, 0.45f),
    HP_BACKGROUND ("res/images/squaremode/hp-background.png", false, 0.45f),
    STATS_BACKGROUND ("res/images/squaremode/stats-background.png", false, 0.45f),

    //Square mode buttons
    GREEN_BUTTON ("res/images/squaremode/green-button.png", false, 0.45f);

    private final String filename;
    private boolean useCustomSkin;
    private Object defaultImage;
    private Object skinStyle;
    private float scale;

    /**
     * Constructor for basic UI
     * @param filename the name of image
     * @param useCustomSkin is true if image can be change (e.g when player uses a skin for the beatmap)
     */

    Images(String filename, boolean useCustomSkin, float scale) {
        this.filename = filename;
        this.useCustomSkin = useCustomSkin;
        this.scale = scale;
    }

    public boolean hasMultipleStyles() {
        return skinStyle != null;
    }

    /** Set default image, if user doesn't use skins */
    public void setDefaultImage() {
        // defaultImage = ImagesLoader.getImage(this.filename).getScaledCopy(scale);
        defaultImage = null; // what the fuck
    }

    public Object getImage() {
        setDefaultImage();
        return defaultImage;
    }

}
