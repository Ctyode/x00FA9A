package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

import static org.lwjgl.opengl.GL11.*;

public class Cursor implements Tickable, Drawable, MouseInputListener {

    private float mouseX;
    private float mouseY;

    @Override
    public void onMouseMove(float x, float y) {
        mouseX = x;
        mouseY = y;
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {

    }

    @Override
    public void onMouseButtonUp(int button, int mods) {

    }

    @Override
    public void draw() {
        glPushMatrix();
        glTranslatef(mouseX, mouseY, 0.0f);
        glBegin(GL_TRIANGLES);
        glColor3f(0.0f, 1.0f, 0.0f);
        glVertex2f(0.0f, 0.0f);
        glVertex2f(0.1f, 0.0f);
        glVertex2f(0.1f, 0.1f);
        glEnd();
        glPopMatrix();
    }

    @Override
    public void tick(float delta) {

    }

}
