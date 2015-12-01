package org.flamierawieo.x00FA9A.client.views;

import org.flamierawieo.x00FA9A.client.ui.View;
import org.flamierawieo.x00FA9A.client.ui.Widget;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import sun.awt.image.PNGImageDecoder;

import java.io.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class StartMenu extends View {

    private File filePath;
    private GLFWImage imageData;

    public StartMenu() {
        super();
    }

    @Override
    public void onMouseButtonUp(int button, int mods) {
        System.out.printf("onMouseButtonUp(%d, %d);\n", button, mods);
    }

    @Override
    public void onMouseButtonDown(int button, int mods) {
        System.out.printf("onMouseButtonDown(%d, %d);\n", button, mods);
    }

    @Override
    public void onMouseMove(float x, float y) {
        System.out.printf("onMouseMove(%f, %f);\n", x, y);
    }

    @Override
    public void onKeyUp(int key, int scancode, int mods) {
        System.out.printf("onKeyUp(%d, %d, %d);\n", key, scancode, mods);
    }

    @Override
    public void onKeyDown(int key, int scancode, int mods) {
        System.out.printf("onKeyDown(%d, %d, %d);\n", key, scancode, mods);
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
