package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Surface extends AbstractShape {

    public Surface(Color backgroundColor, Color borderColor, float borderThickness) {
        super(backgroundColor, borderColor, borderThickness);
    }

    public void draw(float x, float y, float width, float height, float radius) {
        Circle circle = new Circle(backgroundColor, borderColor, borderThickness);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
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
            circle.draw(x + radius, y + radius, radius, 0.5f, 0.75f, 16);
            circle.draw(x + width - radius, y + radius, radius, 0.75f, 1.0f, 16);
            circle.draw(x + radius, y + height - radius, radius, 0.25f, 0.5f, 16);
            circle.draw(x + width - radius, y + height - radius, radius, 0.0f, 0.25f, 16);
        }
        if (borderThickness > 0.0f) {
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
        glDisable(GL_BLEND);
    }

}
