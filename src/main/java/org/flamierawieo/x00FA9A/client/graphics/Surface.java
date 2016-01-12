package org.flamierawieo.x00FA9A.client.graphics;

import org.flamierawieo.x00FA9A.client.ui.widget.ButtonDrawable;

import java.awt.*;

import static org.flamierawieo.x00FA9A.client.graphics.Graphics.*;

public class Surface implements ButtonDrawable {

    private Color backgroundColor;
    private Color borderColor;
    private float borderThickness;
    private float radius;

    public Surface(Color backgroundColor, Color borderColor, float borderThickness, float radius) {
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.borderThickness = borderThickness;
        this.radius = radius;
    }

    @Override
    public void draw(float x, float y, float width, float height) {
        strokeLine(x + radius, y, x + width - radius, y, borderThickness, borderColor);
        strokeLine(x + width, y + radius, x + width, y + height - radius, borderThickness, borderColor);
        strokeLine(x + radius, y + height, x + width - radius, y + height, borderThickness, borderColor);
        strokeLine(x, y + radius, x, y + height - radius, borderThickness, borderColor);
        strokeCircle(x + radius, y + height - radius, radius, 0.25f, 0.5f, 32, borderColor, borderThickness);
        strokeCircle(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 32, borderColor, borderThickness);
        strokeCircle(x + width - radius, y + radius, radius, 0.75f, 1.0f, 32, borderColor, borderThickness);
        strokeCircle(x + radius, y + radius, radius, 0.5f, 0.75f, 32, borderColor, borderThickness);
        fillRect(x, y + radius, width, height - (radius * 2), backgroundColor);
        fillRect(x + radius, y, width - (radius * 2), height, backgroundColor);
        fillCircle(x + radius, y + height - radius, radius, 0.25f, 0.5f, 16, backgroundColor);
        fillCircle(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 16, backgroundColor);
        fillCircle(x + width - radius, y + radius, radius, 0.75f, 1.0f, 16, backgroundColor);
        fillCircle(x + radius, y + radius, radius, 0.5f, 0.75f, 16, backgroundColor);
    }

}
