package org.flamierawieo.x00FA9A.client;

import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.opengl.GL;

import java.nio.ByteBuffer;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class x00FA9AClient implements Runnable {

    private static x00FA9AClient instance;
    private long window;

    public static x00FA9AClient getInstance() {
        if(instance == null) {
            instance = new x00FA9AClient();
        }
        return instance;
    }

    private x00FA9AClient() {
        if(glfwInit() != GL_TRUE) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
        window = glfwCreateWindow(800, 600, "Beat Party", NULL, NULL);
        if(window == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window");
        }
        glfwMakeContextCurrent(window);
        glfwSwapInterval(0);
        glfwShowWindow(window);

        glfwSetCursorPosCallback(window, new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double xpos, double ypos) {
                System.out.println(xpos + " " + ypos);
            }
        });
    }

    @Override
    public void run() {
        GL.createCapabilities(false);
        long lastUpdateTime = System.currentTimeMillis();
        while(glfwWindowShouldClose(window) == GL_FALSE) {
            tick(System.currentTimeMillis() - lastUpdateTime / 1000);
            draw();
            lastUpdateTime = System.currentTimeMillis();
        }
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public void tick(double delta) {
        glfwPollEvents();
    }

    public void draw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(0.0f, 0.98f, 0.60f, 0.0f);
        glBegin(GL_TRIANGLES);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex2f(0.0f, 0.0f);
        glVertex2f(0.0f, 1.0f);
        glVertex2f(1.0f, 1.0f);
        glEnd();
        glfwSwapBuffers(window);
    }

}