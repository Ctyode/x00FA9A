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

    private float mouseRelativePosX;
    private float mouseRelativePosY;
    private Cursor cursor;
    private int windowWidth, windowHeight;
    private Stack<View> viewStack;
    private View currentView;
    private GLFWWindowSizeCallback glfwWindowSizeCallback;
    private GLFWKeyCallback glfwKeyCallback;
    private GLFWCursorPosCallback glfwCursorPosCallback;
    private GLFWMouseButtonCallback glfwMouseButtonCallback;
    private float aspect;

    public ViewManager(int initialWindowWidth, int initialWindowHeight, View rootView) {
        windowWidth = initialWindowWidth;
        windowHeight = initialWindowHeight;
        aspect = (float)windowWidth / (float)windowHeight;
        viewStack = new Stack<>();
        currentView = rootView;
        viewStack.push(rootView);
        cursor = new Cursor();
        glfwWindowSizeCallback = new GLFWWindowSizeCallback() {
            @Override
            public void invoke(long window, int width, int height) {
                windowWidth = width;
                windowHeight = height;
                aspect = (float)windowWidth / (float)windowHeight;
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
                mouseRelativePosX = (float)(x / windowWidth * aspect - (aspect - 1) / 2);
                mouseRelativePosY = (float)((windowHeight - y) / windowHeight);
                cursor.onMouseMove(mouseRelativePosX, mouseRelativePosY);
                currentView.onMouseMove(mouseRelativePosX, mouseRelativePosY);
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

    public float getAspect() {
        return aspect;
    }

    /**
     * Stops view and pops it from stack
     * @return previous current view
     */
    public View popView() {
        View prevCurrentView = currentView;
        viewStack.pop();
        currentView = viewStack.peek();
        prevCurrentView.onViewStopped(this);
        currentView.onViewStarted(this);
        return prevCurrentView;
    }

    /**
     * Peeks current view
     * @return current view
     */
    public View peekView() {
        return currentView;
    }

    /**
     * Pushes view to stack and starts it
     * Pauses previous current view
     * @param view view to push and start
     * @return new current view
     */
    public View pushView(View view) {
        View prevCurrentView = currentView;
        currentView = view;
        viewStack.push(view);
        prevCurrentView.onViewPaused(this);
        currentView.onViewStarted(this);
        return currentView;
    }

    @Override
    public void draw() {
        glLoadIdentity();
        glViewport(0, 0, windowWidth, windowHeight);
        double offset = (aspect - 1.0) / 2.0;
        glOrtho(-offset, 1.0 + offset, 0.0, 1.0, -1.0, 1.0);
        currentView.draw();
        cursor.draw();
    }

    @Override
    public void tick(float delta) {
        currentView.tick(delta);
    }

}
