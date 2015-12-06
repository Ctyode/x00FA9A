package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.StartMenu;
import org.flamierawieo.x00FA9A.shared.Tickable;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALContext;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class x00FA9AClient implements Runnable, Tickable, Drawable {

    private long window;
    private ALContext context;
    private ViewManager viewManager;

    public x00FA9AClient() {
        if(glfwInit() != GL_TRUE) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
        long primaryMonitor = glfwGetPrimaryMonitor();
        GLFWVidMode vidMode = glfwGetVideoMode(primaryMonitor);
        int initialWindowWidth = vidMode.width();
        int initialWindowHeight = vidMode.height();
        window = glfwCreateWindow(initialWindowWidth, initialWindowHeight, "Beat Party", primaryMonitor, NULL);
//        window = glfwCreateWindow(initialWindowWidth, initialWindowHeight, "Beat Party", NULL, NULL);
        if(window == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window");
        }
        glfwMakeContextCurrent(window);
        glfwSwapInterval(0);
        glfwShowWindow(window);
        GL.createCapabilities(false);
        viewManager = new ViewManager(initialWindowWidth, initialWindowHeight, new StartMenu());
        glfwSetWindowSizeCallback(window, viewManager.getGlfwWindowSizeCallback());
        glfwSetKeyCallback(window, viewManager.getGlfwKeyCallback());
        glfwSetCursorPosCallback(window, viewManager.getGlfwCursorPosCallback());
        glfwSetMouseButtonCallback(window, viewManager.getGlfwMouseButtonCallback());
        glfwSetScrollCallback(window, viewManager.getGlfwScrollCallback());
        context = ALContext.create();
        if(!context.getCapabilities().OpenAL10) {
            throw new IllegalStateException("Failed to create OpenAL context");
        }
        context.makeCurrent();
    }

    @Override
    public void run() {
        float lastUpdateTime = (float)glfwGetTime();
        while(glfwWindowShouldClose(window) == GL_FALSE) {
            tick((float)glfwGetTime() - lastUpdateTime);
            draw();
            lastUpdateTime = (float)glfwGetTime();
        }
        glfwDestroyWindow(window);
        glfwTerminate();
        context.destroy();
        ALC.destroy();
    }

    @Override
    public void tick(float delta) {
        glfwPollEvents();
        viewManager.tick(delta);
    }

    @Override
    public void draw() {
        glClear(GL_COLOR_BUFFER_BIT);
        glClearColor(0.0f, 0.98f, 0.60f, 0.0f);
//      glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        viewManager.draw();
        glfwSwapBuffers(window);
    }

}