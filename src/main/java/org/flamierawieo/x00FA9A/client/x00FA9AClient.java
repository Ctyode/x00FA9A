package org.flamierawieo.x00FA9A.client;

import org.flamierawieo.x00FA9A.client.input.InputDispatcher;
import org.flamierawieo.x00FA9A.client.ui.ViewManager;
import org.flamierawieo.x00FA9A.client.views.MainMenuView;
import org.lwjgl.glfw.GLFWFramebufferSizeCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;
import org.lwjgl.opengl.*;

import java.util.HashSet;
import java.util.Set;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class x00FA9AClient implements Runnable {

    private static x00FA9AClient instance;
    private long window;
    private ViewManager viewManager;
    private InputDispatcher inputDispatcher;
    private GLFWFramebufferSizeCallback glfwFramebufferSizeCallback;
    private GLFWWindowSizeCallback glfwWindowSizeCallback;

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
        window = glfwCreateWindow(800, 600, "x00FA9AClient", NULL, NULL);
        if(window == NULL) {
            throw new IllegalStateException("Failed to create the GLFW window");
        }
        viewManager = new ViewManager(new MainMenuView());
        inputDispatcher = new InputDispatcher(window, viewManager);
        glfwSetMouseButtonCallback(window, inputDispatcher.getGlfwMouseButtonCallback());
        glfwSetKeyCallback(window, inputDispatcher.getGlfwKeyCallback());
        glfwMakeContextCurrent(window);
        glfwSwapInterval(0);
        glfwShowWindow(window);
        GLContext.createFromCurrent();
        glfwFramebufferSizeCallback = new GLFWFramebufferSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                glViewport(0, 0, width, height);
            }
        };
        glfwSetFramebufferSizeCallback(window, glfwFramebufferSizeCallback);
    }

    public ViewManager getViewManager() {
        return viewManager;
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
        viewManager.tick(delta);
    }

    public void draw() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glClearColor(0.90f, 0.90f, 0.60f, 0.0f);
        viewManager.draw();
        glfwSwapBuffers(window);
    }

}
