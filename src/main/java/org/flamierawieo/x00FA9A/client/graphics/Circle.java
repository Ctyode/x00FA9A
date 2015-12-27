package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

import static java.lang.Math.*;
import static org.lwjgl.opengl.GL11.*;

public class Circle {

    private static float tau = (float) PI * 2.0f;

    private float[] backgroundColor;
    private float[] borderColor;
    private float borderThickness;

    public Circle(Color backgroundColor, Color borderColor, float borderThickness) {
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
    }

    public void draw(float x, float y, float radius, float segmentStart, float segmentEnd, int detalization) {
        float segment;
        float segmentX;
        float segmentY;
        float segmentSize = 1.0f / (float) detalization;
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glBegin(GL_POLYGON);
        glColor4f(backgroundColor[0], backgroundColor[1], backgroundColor[2], backgroundColor[3]);
        if(segmentStart != 0.0f || segmentEnd != 1.0f) {
            glVertex2f(x, y);
        }
        segmentX = x + (float) cos(segmentStart * tau) * radius;
        segmentY = y + (float) sin(segmentStart * tau) * radius;
        for (segment = segmentStart + segmentSize; segment < segmentEnd; segment += segmentSize) {
            glVertex2f(segmentX, segmentY);
            segmentX = x + (float) cos(segment * tau) * radius;
            segmentY = y + (float) sin(segment * tau) * radius;
            glVertex2f(segmentX, segmentY);
        }
        glVertex2f(segmentX, segmentY);
        segmentX = x + (float) cos(segmentEnd * tau) * radius;
        segmentY = y + (float) sin(segmentEnd * tau) * radius;
        glVertex2f(segmentX, segmentY);
        glEnd();
        glEnable(GL_LINE_SMOOTH);
        glColor4f(borderColor[0], borderColor[1], borderColor[2], borderColor[3]);
        glLineWidth(borderThickness);
        segmentX = x + (float) cos(segmentStart * tau) * radius;
        segmentY = y + (float) sin(segmentStart * tau) * radius;
        for (segment = segmentStart + segmentSize; segment < segmentEnd; segment += segmentSize) {
            glBegin(GL_LINES);
            glVertex2f(segmentX, segmentY);
            segmentX = x + (float) cos(segment * tau) * radius;
            segmentY = y + (float) sin(segment * tau) * radius;
            glVertex2f(segmentX, segmentY);
            glEnd();
        }
        glBegin(GL_LINES);
        glVertex2f(segmentX, segmentY);
        segmentX = x + (float) cos(segmentEnd * tau) * radius;
        segmentY = y + (float) sin(segmentEnd * tau) * radius;
        glVertex2f(segmentX, segmentY);
        glEnd();
        glDisable(GL_LINE_SMOOTH);
        glDisable(GL_BLEND);
    }

}

