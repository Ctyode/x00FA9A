package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.shared.Tickable;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWWindowSizeCallback;

import java.util.Stack;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class ViewManager implements Tickable, Drawable {

    private int windowWidth, windowHeight;
    private Stack<View> viewStack;
    private View currentView;
    private GLFWWindowSizeCallback glfwWindowSizeCallback;
    private GLFWKeyCallback glfwKeyCallback;
    private GLFWCursorPosCallback glfwCursorPosCallback;
    private GLFWMouseButtonCallback glfwMouseButtonCallback;
    private double aspect;

    public ViewManager(int initialWindowWidth, int initialWindowHeight, View rootView) {
        windowWidth = initialWindowWidth;
        windowHeight = initialWindowHeight;
        aspect = (double)windowWidth / (double)windowHeight;
        viewStack = new Stack<>();
        currentView = rootView;
        viewStack.push(rootView);
        glfwWindowSizeCallback = new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                windowWidth = width;
                windowHeight = height;
                aspect = (double)windowWidth / (double)windowHeight;
            }
        };
        glfwKeyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if(action == GLFW_PRESS) {
                    currentView.onKeyDown(key, scancode, mods);
                } else if(action == GLFW_RELEASE) {
                    currentView.onKeyUp(key, scancode, mods);
                }
            }
        };
        glfwCursorPosCallback = new GLFWCursorPosCallback() {
            @Override
            public void invoke(long window, double x, double y) {
                currentView.onMouseMove(x / windowWidth * aspect - (aspect - 1) / 2, (windowHeight - y) / windowHeight);
            }
        };
        glfwMouseButtonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                if(action == GLFW_PRESS) {
                    currentView.onMouseButtonDown(button, mods);
                } else if(action == GLFW_RELEASE) {
                    currentView.onMouseButtonUp(button, mods);
                }
            }
        };
    }

    public GLFWWindowSizeCallback getGlfwWindowSizeCallback() {
        return glfwWindowSizeCallback;
    }

    public GLFWKeyCallback getGlfwKeyCallback() {
        return glfwKeyCallback;
    }

    public GLFWCursorPosCallback getGlfwCursorPosCallback() {
        return glfwCursorPosCallback;
    }

    public GLFWMouseButtonCallback getGlfwMouseButtonCallback() {
        return glfwMouseButtonCallback;
    }

    public View popView() {
        View lastCurrentView = currentView;
        viewStack.pop();
        currentView = viewStack.peek();
        return lastCurrentView;
    }

    public View peekView() {
        return currentView;
    }

    public View pushView(View view) {
        currentView = view;
        viewStack.push(view);
        return currentView;
    }

    public void draw() {
        glLoadIdentity();
        glViewport(0, 0, windowWidth, windowHeight);
        double offset = (aspect - 1.0) / 2.0;
        glOrtho(-offset, 1.0 + offset, 0.0, 1.0, -1.0, 1.0);
        currentView.draw();
    }

    public void tick(double delta) {
        currentView.tick(delta);
    }

}
