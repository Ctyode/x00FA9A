package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.input.MouseInputListener;
import org.flamierawieo.x00FA9A.shared.Tickable;

import static org.lwjgl.opengl.GL11.*;

public class Cursor implements Tickable, Drawable, MouseInputListener {

    private float mouseX, mouseY;

    @Override
    public void draw() {
        glBegin(GL_TRIANGLES);
        glColor3f(0.0f, 1.0f, 0.0f);
        glVertex2f(mouseX + 0.0f, mouseY + 0.0f);
        glVertex2f(mouseX + 0.1f, mouseY + 0.0f);
        glVertex2f(mouseX + 0.1f, mouseY + 0.1f);
        glEnd();
    }

    @Override
    public void tick(double delta) {

    }

    @Override
    public void onMouseMove(double x, double y) {
        mouseX = (float)x;
        mouseY = (float)y;
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {

    }

    @Override
    public void onMouseButtonUp(int button, int mods) {

    }
}
