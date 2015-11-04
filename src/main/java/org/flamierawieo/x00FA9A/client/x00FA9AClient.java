package org.flamierawieo.x00FA9A.client;

import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;


public class x00FA9AClient implements Runnable {

    private GLFWKeyCallback keyCallback;
    private long window;

    public x00FA9AClient() {
        if(glfwInit() != GL_TRUE) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

        window = glfwCreateWindow(800, 600, "x00FA9AClient", NULL, NULL);
        if(window == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window");
        }
        glfwMakeContextCurrent(window);
        glfwSwapInterval(0);
        glfwShowWindow(window);
        GLContext.createFromCurrent();
    }

    @Override
    public void run() {
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
        glfwSwapBuffers(window);
    }

}
