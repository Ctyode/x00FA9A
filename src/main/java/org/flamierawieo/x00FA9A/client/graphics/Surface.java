package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

import static org.flamierawieo.x00FA9A.client.graphics.Graphics.*;
import static org.lwjgl.opengl.GL11.*;

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
        glColor4f(backgroundColor.getRed() / 255.0f,
                  backgroundColor.getGreen() / 255.0f,
                  backgroundColor.getBlue() / 255.0f,
                  backgroundColor.getAlpha() / 255.0f);
        glBegin(GL_POLYGON);
        glVertex2f(x + radius, y + radius);
        glVertex2f(x + width - radius, y + radius);
        glVertex2f(x + width - radius, y + height - radius);
        glVertex2f(x + radius, y + height - radius);
        glEnd();
        if(radius > 0.0f) {
            glBegin(GL_POLYGON);
            glVertex2f(x + radius, y);
            glVertex2f(x + width - radius, y);
            glVertex2f(x + width - radius, y + radius);
            glVertex2f(x + radius, y + radius);
            glEnd();
            glBegin(GL_POLYGON);
            glVertex2f(x + width - radius, y + radius);
            glVertex2f(x + width, y + radius);
            glVertex2f(x + width, y + height - radius);
            glVertex2f(x + width - radius, y + height - radius);
            glEnd();
            glBegin(GL_POLYGON);
            glVertex2f(x + radius, y + height - radius);
            glVertex2f(x + width - radius, y + height - radius);
            glVertex2f(x + width - radius, y + height);
            glVertex2f(x + radius, y + height);
            glEnd();
            glBegin(GL_POLYGON);
            glVertex2f(x, y + radius);
            glVertex2f(x + radius, y + radius);
            glVertex2f(x + radius, y + height - radius);
            glVertex2f(x, y + height - radius);
            glEnd();
            fillCircle(x + radius, y + radius, radius, 0.5f, 0.75f, 32, backgroundColor);
            fillCircle(x + width - radius, y + radius, radius, 0.75f, 1.0f, 32, backgroundColor);
            fillCircle(x + radius, y + height - radius, radius, 0.25f, 0.5f, 32, backgroundColor);
            fillCircle(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 32, backgroundColor);
        }
        if (borderThickness > 0.0f) {
            glEnable(GL_BLEND);
            glColor4f(borderColor.getRed() / 255.0f,
                      borderColor.getGreen() / 255.0f,
                      borderColor.getBlue() / 255.0f,
                      borderColor.getAlpha() / 255.0f);
            glLineWidth(borderThickness);
            glBegin(GL_LINES);
            glVertex2f(x + radius, y);
            glVertex2f(x + width - radius, y);
            glEnd();
            glBegin(GL_LINES);
            glVertex2f(x + width, y + radius);
            glVertex2f(x + width, y + height - radius);
            glEnd();
            glBegin(GL_LINES);
            glVertex2f(x + radius, y + height);
            glVertex2f(x + width - radius, y + height);
            glEnd();
            glBegin(GL_LINES);
            glVertex2f(x, y + radius);
            glVertex2f(x, y + height - radius);
            glEnd();
        }
        if(radius > 0.0f && borderThickness > 0.0f) {
            strokeCircle(x + radius, y + radius, radius, 0.5f, 0.75f, 32, borderColor, borderThickness);
            strokeCircle(x + width - radius, y + radius, radius, 0.75f, 1.0f, 32, borderColor, borderThickness);
            strokeCircle(x + radius, y + height - radius, radius, 0.25f, 0.5f, 32, borderColor, borderThickness);
            strokeCircle(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 32, borderColor, borderThickness);
        }
    }

}
