package org.flamierawieo.x00FA9A;

import org.newdawn.slick.Image;

public enum Images {

    CURSOR_IMAGE ("res/images/cursor.png", true, 0.6f),
    BASIC_BACKGROUND ("res/images/background.png", false, 1.0f),

    //Start menu
    SINGLEPLAYER_BUTTON ("res/images/views/mainmenu/singleplayer-button.png", false, 0.6f),
    MULTIPLAYER_BUTTON ("res/images/views/mainmenu/multiplayer-button.png", false, 0.6f),
    OPTIONS_BUTTON ("res/images/views/mainmenu/options-button.png", false, 0.6f),
    EXIT_BUTTON ("res/images/views/mainmenu/exit-button.png", false, 0.6f),

    //Song menu
    SONG_LIST_BACKGROUND ("res/images/views/songmenu/songs-background.png", false, 0.45f),
    ACTIVE_SONG_BACKGROUND ("res/images/views/songmenu/active-song-background.png", false, 0.5f),
    SEARCH_BACKGROUND ("res/images/views/songmenu/search-background.png", false, 0.6f),
    SELECT_MODE ("res/images/views/songmenu/select-mode.png", false, 0.6f);

    private final String filename;
    private boolean useCustomSkin;
    private Image defaultImage;
    private Image skinStyle;
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
        return (skinStyle != null);
    }

    /** Set default image, if user doesn't use skins */
    public void setDefaultImage() {
        defaultImage = ImagesLoader.getImage(this.filename).getScaledCopy(scale);
    }

    public Image getImage() {
        setDefaultImage();
        return defaultImage;
    }

}
