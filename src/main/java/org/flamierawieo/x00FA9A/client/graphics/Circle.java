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
        float segmentSize = 1.0f / (float) detalization;
        float segmentX = x + (float) sin(segmentStart * tau);
        float segmentY = y + (float) cos(segmentStart * tau);
        glEnable(GL_BLEND);
        glEnable(GL_LINE_SMOOTH);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glColor4f(borderColor[0], borderColor[1], borderColor[2], borderColor[3]);
        glLineWidth(borderThickness);
        glBegin(GL_LINE_LOOP);
        float segment;
        for (segment = segmentStart; segment < segmentEnd; segment += segmentSize) {
            glVertex2f(segmentX * radius, segmentY * radius);
            segmentX = x + (float) sin(segment * tau);
            segmentY = y + (float) cos(segment * tau);
            glVertex2f(segmentX * radius, segmentY * radius);
        }
        segment = segmentEnd;
        glVertex2f(segmentX * radius, segmentY * radius);
        segmentX = x + (float) sin(segment * tau);
        segmentY = y + (float) cos(segment * tau);
        glVertex2f(segmentX * radius, segmentY * radius);
        glEnd();
        glDisable(GL_LINE_SMOOTH);
        glDisable(GL_BLEND);
    }

}
