package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.ui.View;
import static org.lwjgl.opengl.GL11.*;

public class MainMenuView extends View {

    /**
     * just for demo lol
     */

    @Override
    public void onKeyPress(int key, int scancode, int mods) {
        System.out.printf("Key press event: %d %d %d\n", key, scancode, mods);
    }

    @Override
    public void draw() {
        glLineWidth(2.5f);
        glColor3f(1.0f, 0.0f, 0.0f);
        glBegin(GL_LINES);
            glVertex3f(0.0f, 0.0f, 0.0f);
            glVertex3f(0.5f, 0.0f, 0.0f);
        glEnd();
    }

}
