package org.flamierawieo.x00FA9A.client.graphics;

import java.awt.*;

import static java.lang.Math.*;
import static org.lwjgl.opengl.GL11.*;

public class Graphics {

    private static float tau = (float) PI * 2.0f;

    public void strokeLine(float x0, float y0, float x1, float y1, float strokeWidth, Color strokeColor) {
        glPushMatrix();
        glColor4f(strokeColor.getRed() / 255.0f,
                  strokeColor.getGreen() / 255.0f,
                  strokeColor.getBlue() / 255.0f,
                  strokeColor.getAlpha() / 255.0f);
        glLineWidth(strokeWidth);
        glBegin(GL_LINES);
        glVertex2f(x0, y0);
        glVertex2f(x1, y1);
        glEnd();
        glPopMatrix();
    }

    public void fillRect(float x, float y, float width, float height, Color fillColor) {
        glPushMatrix();
        glTranslatef(x, y, 0.0f);
        glColor4f(fillColor.getRed() / 255.0f,
                  fillColor.getGreen() / 255.0f,
                  fillColor.getBlue() / 255.0f,
                  fillColor.getAlpha() / 255.0f);
        glBegin(GL_POLYGON);
        glVertex2f(0.0f, 0.0f);
        glVertex2f(width, 0.0f);
        glVertex2f(width, height);
        glVertex2f(0.0f, height);
        glEnd();
        glPopMatrix();
    }

    public void strokeRect(float x, float y, float width, float height, float strokeWidth, Color strokeColor) {
        strokeLine(x, y, x + width, y, strokeWidth, strokeColor);
        strokeLine(x + width, y, x + width, y + height, strokeWidth, strokeColor);
        strokeLine(x + width, y + height, x, y + height, strokeWidth, strokeColor);
        strokeLine(x, y, x + width, y, strokeWidth, strokeColor);
    }

    public void fillShape(float x, float y, Vertex[] shape, Color fillColor) {
        glPushMatrix();
        glTranslatef(x, y, 0.0f);
        glColor4f(fillColor.getRed() / 255.0f,
                  fillColor.getGreen() / 255.0f,
                  fillColor.getBlue() / 255.0f,
                  fillColor.getAlpha() / 255.0f);
        glBegin(GL_POLYGON);
        for(Vertex v : shape) {
            glVertex2f(v.x, v.y);
        }
        glEnd();
        glPopMatrix();
    }

    public void strokeShape(float x, float y, Vertex[] shape, float strokeWidth, Color strokeColor) {
        glPushMatrix();
        glTranslatef(x, y, 0.0f);
        glColor4f(strokeColor.getRed() / 255.0f,
                  strokeColor.getGreen() / 255.0f,
                  strokeColor.getBlue() / 255.0f,
                  strokeColor.getAlpha() / 255.0f);
        glLineWidth(strokeWidth);
        for(Vertex v : shape) {
        glBegin(GL_LINES);
            glVertex2f(v.x, v.y);
        }
        glEnd();
        glPopMatrix();
    }

    public static void fillCircle(float x, float y, float radius, float segmentStart, float segmentEnd, int detalization, Color fillColor) {
        float segment;
        float segmentX;
        float segmentY;
        float segmentSize = 1.0f / (float) detalization;
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
    }

    public static void strokeCircle(float x, float y, float radius, float segmentStart, float segmentEnd, int detalization, Color strokeColor, float borderThickness) {
        float segment;
        float segmentX;
        float segmentY;
        float segmentSize = 1.0f / (float) detalization;
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
    }

}
