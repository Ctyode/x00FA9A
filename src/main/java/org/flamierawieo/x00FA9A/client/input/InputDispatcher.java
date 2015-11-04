package org.flamierawieo.x00FA9A.client.input;

import org.flamierawieo.x00FA9A.shared.Tickable;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.nio.ByteBuffer;
import java.util.Stack;

import static org.lwjgl.glfw.GLFW.*;

public class InputDispatcher implements Tickable {

    private long glfwWindow;
    private GLFWKeyCallback glfwKeyCallback;
    private GLFWMouseButtonCallback glfwMouseButtonCallback;
    private int lastXCursorPosition;
    private int lastYCursorPosition;
    private Stack<InputListener> inputListenerStack;

    public InputDispatcher(long glfwWindow) {
        this.glfwWindow = glfwWindow;
        glfwKeyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if(action == GLFW_PRESS) {
                    if(!inputListenerStack.empty()) {
                        inputListenerStack.peek().onKeyPress(key, scancode, mods);
                    }
                } else if (action == GLFW_RELEASE) {
                    if(!inputListenerStack.empty()) {
                        inputListenerStack.peek().onKeyRelease(key, scancode, mods);
                    }
                }
            }
        };
        glfwMouseButtonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                if(action == GLFW_PRESS) {
                    inputListenerStack.forEach((l -> l.onMouseButtonPress(button, mods, lastXCursorPosition, lastYCursorPosition)));
                } else if (action == GLFW_RELEASE) {
                    inputListenerStack.forEach((l -> l.onMouseButtonRelease(button, mods, lastXCursorPosition, lastYCursorPosition)));
                }
            }
        };
        inputListenerStack = new Stack<>();
    }

    public GLFWKeyCallback getGlfwKeyCallback() {
        return glfwKeyCallback;
    }

    public GLFWMouseButtonCallback getGlfwMouseButtonCallback() {
        return glfwMouseButtonCallback;
    }

    @Override
    public void tick(double delta) {
        glfwPollEvents();
        ByteBuffer cursorXPositionByteBuffer = ByteBuffer.allocate(4);
        ByteBuffer cursorYPositionByteBuffer = ByteBuffer.allocate(4);
        glfwGetCursorPos(glfwWindow, cursorXPositionByteBuffer, cursorYPositionByteBuffer);
        int newXCursorPosition = cursorXPositionByteBuffer.getInt();
        int newYCursorPosition = cursorYPositionByteBuffer.getInt();
        if(newXCursorPosition != lastXCursorPosition || newYCursorPosition != lastYCursorPosition) {
            if(!inputListenerStack.empty()) {
                inputListenerStack.peek().onMouseMove(newXCursorPosition, newYCursorPosition, lastXCursorPosition - newXCursorPosition, lastYCursorPosition - newYCursorPosition);
            }
        }
        lastXCursorPosition = newXCursorPosition;
        lastYCursorPosition = newYCursorPosition;
    }

}
