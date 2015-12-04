package org.flamierawieo.x00FA9A.client;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public enum Fonts {

    ROBOTO_LIGHT ("res/fonts/Roboto/Roboto-Light.ttf"),
    ROBOTO_REGULAR ("res/fonts/Roboto/Roboto-Regular.ttf");

    private Font font;

    Fonts(String path) {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    public Font getFont() {
        return font;
    }

}
