package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.Images;
import org.flamierawieo.x00FA9A.client.Sounds;
import org.flamierawieo.x00FA9A.client.audio.Sound;
import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.client.graphics.Sprite;
import org.lwjgl.glfw.*;

import java.util.Stack;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

public class ViewManager {

    private static float mouseRelativePosX;
    private static float mouseRelativePosY;
    private static Cursor cursor;
    private static int windowWidth, windowHeight;
    private static Stack<View> viewStack;
    private static View currentView;
    private static GLFWWindowSizeCallback glfwWindowSizeCallback;
    private static GLFWKeyCallback glfwKeyCallback;
    private static GLFWCursorPosCallback glfwCursorPosCallback;
    private static GLFWMouseButtonCallback glfwMouseButtonCallback;
    private static GLFWScrollCallback glfwScrollCallback;
    private static float aspect;
    private static Sprite gameBackground;

    public static void init(int initialWindowWidth, int initialWindowHeight, View rootView) {
        windowWidth = initialWindowWidth;
        windowHeight = initialWindowHeight;
        aspect = (float)windowWidth / (float)windowHeight;
        viewStack = new Stack<>();
        currentView = rootView;
        viewStack.push(rootView);
        rootView.onViewStarted();
        cursor = new Cursor();
        gameBackground = new Sprite(Images.BASIC_BACKGROUND.getTexture());
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
        glfwScrollCallback = new GLFWScrollCallback() {
            @Override
            public void invoke(long window, double x, double y) {
                currentView.onScroll(x, y);
            }
        };
    }

    public static GLFWWindowSizeCallback getGlfwWindowSizeCallback() {
        return glfwWindowSizeCallback;
    }

    public static GLFWKeyCallback getGlfwKeyCallback() {
        return glfwKeyCallback;
    }

    public static GLFWCursorPosCallback getGlfwCursorPosCallback() {
        return glfwCursorPosCallback;
    }

    public static GLFWMouseButtonCallback getGlfwMouseButtonCallback() {
        return glfwMouseButtonCallback;
    }

    public static GLFWScrollCallback getGlfwScrollCallback() {
        return glfwScrollCallback;
    }

    public static float getAspect() {
        return aspect;
    }

    /**
     * Stops view and pops it from stack
     * @return previous current view
     */
    public static View popView() {
        View prevCurrentView = currentView;
        viewStack.pop();
        currentView = viewStack.peek();
        prevCurrentView.onViewStopped();
        currentView.onViewStarted();
        return prevCurrentView;
    }

    /**
     * Peeks current view
     * @return current view
     */
    public static View peekView() {
        return currentView;
    }

    /**
     * Pushes view to stack and starts it
     * Pauses previous current view
     * @param view view to push and start
     * @return new current view
     */
    public static View pushView(View view) {
        View prevCurrentView = currentView;
        currentView = view;
        viewStack.push(view);
        prevCurrentView.onViewPaused();
        currentView.onViewStarted();
        return currentView;
    }

    public static void draw() {
        glLoadIdentity();
        glViewport(0, 0, windowWidth, windowHeight);
        double offset = (aspect - 1.0) / 2.0;
        glOrtho(-offset, 1.0 + offset, 0.0, 1.0, -1.0, 1.0);
        gameBackground.draw((float) -offset, 0.0f, aspect, 1.0f);
        currentView.draw();
        cursor.draw();
    }

    public static void tick(float delta) {
        currentView.tick(delta);
    }

}
