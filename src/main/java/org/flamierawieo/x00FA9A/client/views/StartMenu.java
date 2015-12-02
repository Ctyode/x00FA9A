package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.ui.View;
import static org.lwjgl.opengl.GL11.*;

public class StartMenu extends View {

    public StartMenu() {
        super();
    }

    @Override
    public void draw() {
        glBegin(GL_TRIANGLES);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex2f(0.0f, 0.0f);
        glVertex2f(0.0f, 1.0f);
        glVertex2f(1.0f, 1.0f);
        glEnd();
    }

}
