package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.settings.Settings;
import org.flamierawieo.x00FA9A.client.settings.VideoMode;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.StartMenu;
import org.flamierawieo.x00FA9A.shared.Tickable;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALContext;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.system.MemoryUtil.*;

public class x00FA9AClient implements Runnable, Tickable, Drawable {

    private static x00FA9AClient instance = new x00FA9AClient();

    public static x00FA9AClient getInstance() {
        return instance;
    }

    private ALContext context;
    private long window;
    private ViewManager viewManager;
    private Settings settings;

    public x00FA9AClient() {
        settings = Settings.getInstance();
        if(glfwInit() != GL_TRUE) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
        long primaryMonitor = glfwGetPrimaryMonitor();
        VideoMode videoMode = settings.getVideoMode();
        int initialWindowWidth;
        int initialWindowHeight;
        if(videoMode == null) {
            GLFWVidMode vidMode = glfwGetVideoMode(primaryMonitor);
            videoMode = VideoMode.getAutoDetectedVideoMode(vidMode.width(), vidMode.height());
            initialWindowWidth = videoMode.getWidth();
            initialWindowHeight = videoMode.getHeight();
        } else {
            initialWindowWidth = videoMode.getWidth();
            initialWindowHeight = videoMode.getHeight();
        }
        window = glfwCreateWindow(initialWindowWidth, initialWindowHeight, "Beat Party", primaryMonitor, NULL);
        glfwMakeContextCurrent(window);
        glfwSwapInterval(0);
        glfwShowWindow(window);
        GL.createCapabilities(false);
        context = ALContext.create();
        if(!context.getCapabilities().OpenAL10) {
            throw new IllegalStateException("Failed to create OpenAL context");
        }
        context.makeCurrent();
        alListener3f(AL_POSITION, 0.0f, 0.0f, 0.0f);
        alListener3f(AL_VELOCITY, 0.0f, 0.0f, 0.0f);
        viewManager = new ViewManager(initialWindowWidth, initialWindowHeight, new StartMenu());
        glfwSetWindowSizeCallback(window, viewManager.getGlfwWindowSizeCallback());
        glfwSetKeyCallback(window, viewManager.getGlfwKeyCallback());
        glfwSetCursorPosCallback(window, viewManager.getGlfwCursorPosCallback());
        glfwSetMouseButtonCallback(window, viewManager.getGlfwMouseButtonCallback());
        glfwSetScrollCallback(window, viewManager.getGlfwScrollCallback());
    }

    public ALContext getContext() {
        return context;
    }

    public long getWindow() {
        return window;
    }

    public ViewManager getViewManager() {
        return viewManager;
    }

    public Settings getSettings() {
        return settings;
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
        viewManager.draw();
        glfwSwapBuffers(window);
    }

}