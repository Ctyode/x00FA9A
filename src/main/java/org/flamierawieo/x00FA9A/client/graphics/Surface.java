package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Surface {

    private float[] backgroundColor;
    private float[] borderColor;
    private float borderThickness;
    private float radius;

    public Surface(Color backgroundColor, Color borderColor, float borderThickness, float radius) {
        this.backgroundColor = new float[4];
        this.backgroundColor[0] = (float) backgroundColor.getRed() / 255.0f;
        this.backgroundColor[1] = (float) backgroundColor.getGreen() / 255.0f;
        this.backgroundColor[2] = (float) backgroundColor.getBlue() / 255.0f;
        this.backgroundColor[3] = (float) backgroundColor.getAlpha() / 255.0f;
        this.borderColor = new float[4];
        this.borderColor[0] = (float) borderColor.getRed() / 255.0f;
        this.borderColor[1] = (float) borderColor.getGreen() / 255.0f;
        this.borderColor[2] = (float) borderColor.getBlue() / 255.0f;
        this.borderColor[3] = (float) borderColor.getAlpha() / 255.0f;
        this.borderThickness = borderThickness;
        this.radius = radius;
    }

    public void draw(float x, float y, float width, float height) {
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glColor4f(backgroundColor[0], backgroundColor[1], backgroundColor[2], backgroundColor[3]);
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
        }
        if (borderThickness > 0.0f) {
            glColor4f(borderColor[0], borderColor[1], borderColor[2], borderColor[3]);
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
        glDisable(GL_BLEND);
    }

}
