package org.flamierawieo.x00FA9A.client.ui;

import org.flamierawieo.x00FA9A.client.graphics.Drawable;
import org.flamierawieo.x00FA9A.shared.Tickable;
import org.lwjgl.glfw.GLFWCursorPosCallback;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.util.Stack;

import static org.lwjgl.glfw.GLFW.*;

public class ViewManager implements Tickable, Drawable {

    private int windowWidth, windowHeight;
    private Stack<View> viewStack;
    private View currentView;
    private GLFWKeyCallback glfwKeyCallback;
    private GLFWCursorPosCallback glfwCursorPosCallback;
    private GLFWMouseButtonCallback glfwMouseButtonCallback;
    private double aspect;

    public ViewManager(View rootView) {
        viewStack = new Stack<>();
        currentView = rootView;
        viewStack.push(rootView);
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

    public void setWindowSize(int w, int h) {
        windowWidth = w;
        windowHeight = h;
        aspect = (double)windowWidth / (double)windowHeight;
    }

    public void draw() {
        currentView.draw();
    }

    public void tick(double delta) {
        currentView.tick(delta);
    }

}
