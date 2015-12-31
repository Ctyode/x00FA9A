package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

import static org.flamierawieo.x00FA9A.client.graphics.Graphics.*;

public class Surface {

    private Color backgroundColor;
    private Color borderColor;
    private float borderThickness;

    public Surface(Color backgroundColor, Color borderColor, float borderThickness) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
    }

    public void draw(float x, float y, float width, float height, float radius) {
        strokeRect(x, y + radius, width, height - (radius * 2), borderThickness, borderColor);
        strokeRect(x + radius, y, width - (radius * 2), height, borderThickness, borderColor);
        strokeCircle(x + radius, y + height - radius, radius, 0.25f, 0.5f, 32, borderColor, borderThickness);
        strokeCircle(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 32, borderColor, borderThickness);
        strokeCircle(x + width - radius, y + radius, radius, 0.75f, 1.0f, 32, borderColor, borderThickness);
        strokeCircle(x + radius, y + radius, radius, 0.5f, 0.75f, 32, borderColor, borderThickness);
        fillRect(x, y + radius, width, height - (radius * 2), backgroundColor);
        fillRect(x + radius, y, width - (radius * 2), height, backgroundColor);
        fillCircle(x + radius, y + height - radius, radius, 0.25f, 0.5f, 32, backgroundColor);
        fillCircle(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 32, backgroundColor);
        fillCircle(x + width - radius, y + radius, radius, 0.75f, 1.0f, 32, backgroundColor);
        fillCircle(x + radius, y + radius, radius, 0.5f, 0.75f, 32, backgroundColor);
    }

}
