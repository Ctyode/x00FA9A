package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.StartMenu;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class x00FA9AClient implements Runnable {

    private long window;
    private ViewManager viewManager;

    public x00FA9AClient() {
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
        viewManager = new ViewManager(new StartMenu());
        glfwSetKeyCallback(window, viewManager.getGlfwKeyCallback());
        glfwSetCursorPosCallback(window, viewManager.getGlfwCursorPosCallback());
        glfwSetMouseButtonCallback(window, viewManager.getGlfwMouseButtonCallback());
    }

    @Override
    public void run() {
        GL.createCapabilities(false);
        double lastUpdateTime = glfwGetTime();
        while(glfwWindowShouldClose(window) == GL_FALSE) {
            tick(glfwGetTime() - lastUpdateTime);
            draw();
            lastUpdateTime = glfwGetTime();
        }
        glfwDestroyWindow(window);
        glfwTerminate();
    }

    public void tick(double delta) {
        glfwPollEvents();
        viewManager.tick(delta);
    }

    public void draw() {
        glClear(GL_COLOR_BUFFER_BIT);
        glClearColor(0.0f, 0.98f, 0.60f, 0.0f);
        viewManager.draw();
        glfwSwapBuffers(window);
    }

}