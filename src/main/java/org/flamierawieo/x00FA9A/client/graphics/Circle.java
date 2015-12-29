package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

import static java.lang.Math.*;
import static org.lwjgl.opengl.GL11.*;

public class Circle {

    private static float tau = (float) PI * 2.0f;

    public static void fillCircle(float x, float y, float radius, float segmentStart, float segmentEnd, int detalization, Color fillColor) {
        float segment;
        float segmentX;
        float segmentY;
        float segmentSize = 1.0f / (float) detalization;
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        glEnable(GL_POLYGON_SMOOTH);
        glBegin(GL_POLYGON);
        glColor4f(fillColor.getRed() / 255.0f,
                  fillColor.getGreen() / 255.0f,
                  fillColor.getBlue() / 255.0f,
                  fillColor.getAlpha() / 255.0f);
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
        glDisable(GL_POLYGON_SMOOTH);
        glDisable(GL_BLEND);
    }

    public static void strokeCircle(float x, float y, float radius, float segmentStart, float segmentEnd, int detalization, Color strokeColor, float borderThickness) {
        float segment;
        float segmentX;
        float segmentY;
        float segmentSize = 1.0f / (float) detalization;
        glEnable(GL_BLEND);
        glEnable(GL_LINE_SMOOTH);
        glColor4f(strokeColor.getRed() / 255.0f,
                  strokeColor.getGreen() / 255.0f,
                  strokeColor.getBlue() / 255.0f,
                  strokeColor.getAlpha() / 255.0f);
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

