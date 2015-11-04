package org.flamierawieo.x00FA9A;

import org.newdawn.slick.Image;

public enum Images {


    //StartMenu UI


    SINGLEPLAYER_BUTTON ("singleplayer-button", "svg", false) {
        @Override
        protected Image process_sub(Image img, int w, int h) {
            return img.getScaledCopy(1.0f);
        }
    },

    MULTIPLAYER_BUTTON ("multiplayer-button", "svg", false) {
        @Override
        protected Image process_sub(Image img, int w, int h) {
            return super.process_sub(img, w, h);
        }
    };


    private final String filename;
    private String fileExtension;
    private boolean multipleStyles;


    /**
     * Constructor for basic UI
     * @param filename the name of image
     * @param fileExtension the type of image
     * @param multipleStyles is true if image can be change (e.g when player uses a skin for the beatmap)
     */

    Images(String filename, String fileExtension, boolean multipleStyles) {
        this.filename = filename;
        this.fileExtension = fileExtension;
        this.multipleStyles = multipleStyles;
    }

    protected Image process_sub(Image img, int w, int h) {
        return img;
    }

}
