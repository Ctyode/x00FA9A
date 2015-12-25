package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.settings.Settings;
import org.flamierawieo.x00FA9A.client.settings.VideoMode;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.StartMenu;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALContext;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.openal.AL10.AL_POSITION;
import static org.lwjgl.openal.AL10.AL_VELOCITY;
import static org.lwjgl.openal.AL10.alListener3f;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.system.MemoryUtil.*;

public class x00FA9AClient {

    private static long window;
    private static ALContext context;

    public static void init() {
        if(glfwInit() != GL_TRUE) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);
        long primaryMonitor = glfwGetPrimaryMonitor();
        VideoMode videoMode = Settings.getInstance().getVideoMode();
        int initialWindowWidth;
        int initialWindowHeight;
        if(videoMode == null) {
            int scale = "true".equals(System.getProperty("retina")) ? 2 : 1;
            GLFWVidMode vidMode = glfwGetVideoMode(primaryMonitor);
            videoMode = VideoMode.getAutoDetectedVideoMode(vidMode.width() * scale, vidMode.height() * scale);
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
        ViewManager.init(initialWindowWidth, initialWindowHeight, new StartMenu());
        glfwSetKeyCallback(window, ViewManager.getGlfwKeyCallback());
        glfwSetCursorPosCallback(window, ViewManager.getGlfwCursorPosCallback());
        glfwSetMouseButtonCallback(window, ViewManager.getGlfwMouseButtonCallback());
        glfwSetScrollCallback(window, ViewManager.getGlfwScrollCallback());
    }

    public static void run() {
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

    public static void tick(float delta) {
        glfwPollEvents();
        ViewManager.tick(delta);
    }

    public static void draw() {
        glClear(GL_COLOR_BUFFER_BIT);
        glClearColor(0.0f, 0.98f, 0.60f, 0.0f);
        ViewManager.draw();
        glfwSwapBuffers(window);
    }

}
