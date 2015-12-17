package org.flamierawieo.x00FA9A.client;

import java.awt.*;

public enum Colors {

    WHITE (new Color(0xFFFFFF)),
    LIGHT_GRAY (new Color(0xEEEEEE)),
    GRAY (new Color(0x797979)),
    MEDIUM_GRAY (new Color(0x555555)),
    DARK_GRAY (new Color(0x2F2F2F)),
    BLACK (new Color(0x000000));

    private Color color;

    Colors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

}
