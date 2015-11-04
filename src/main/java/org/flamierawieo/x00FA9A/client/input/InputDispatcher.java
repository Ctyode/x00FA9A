package org.flamierawieo.x00FA9A.client.input;

import org.flamierawieo.x00FA9A.shared.Tickable;
import org.lwjgl.glfw.GLFWKeyCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;

import java.nio.ByteBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class InputDispatcher implements Tickable {

    private long glfwWindow;
    private GLFWKeyCallback glfwKeyCallback;
    private GLFWMouseButtonCallback glfwMouseButtonCallback;
    private int lastXCursorPosition;
    private int lastYCursorPosition;
    private InputListener inputListener;

    /**
     * Constructs a new InputDispatcher
     * @param glfwWindow GLFW Window ID to dispatch events
     * @param initialInputListener initial input listener
     */
    public InputDispatcher(long glfwWindow, InputListener initialInputListener) {
        this.glfwWindow = glfwWindow;
        inputListener = initialInputListener;
        glfwKeyCallback = new GLFWKeyCallback() {
            @Override
            public void invoke(long window, int key, int scancode, int action, int mods) {
                if (action == GLFW_PRESS) {
                    if (inputListener != null) {
                        inputListener.onKeyPress(key, scancode, mods);
                    }
                } else if (action == GLFW_RELEASE) {
                    if (inputListener != null) {
                        inputListener.onKeyRelease(key, scancode, mods);
                    }
                }
            }
        };
        glfwMouseButtonCallback = new GLFWMouseButtonCallback() {
            @Override
            public void invoke(long window, int button, int action, int mods) {
                if (action == GLFW_PRESS) {
                    if (inputListener != null) {
                        inputListener.onMouseButtonPress(button, mods, lastXCursorPosition, lastYCursorPosition);
                    }
                } else if (action == GLFW_RELEASE) {
                    if (inputListener != null) {
                        inputListener.onMouseButtonRelease(button, mods, lastXCursorPosition, lastYCursorPosition);
                    }
                }
            }
        };
    }

    /**
     * @return GLFW key callback for this input dispatcher
     */
    public GLFWKeyCallback getGlfwKeyCallback() {
        return glfwKeyCallback;
    }

    /**
     * @return GLFW mouse button callback for this input dispatcher
     */
    public GLFWMouseButtonCallback getGlfwMouseButtonCallback() {
        return glfwMouseButtonCallback;
    }

    /**
     * @return input listener for this input dispatcher
     */
    public InputListener getInputListener() {
        return inputListener;
    }

    /**
     * Sets new input listener for this input dispatcher
     * @param inputListener new input listener
     */
    public void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }

    @Override
    public void tick(double delta) {
        glfwPollEvents();
        ByteBuffer cursorXPositionByteBuffer = ByteBuffer.allocate(4);
        ByteBuffer cursorYPositionByteBuffer = ByteBuffer.allocate(4);
        glfwGetCursorPos(glfwWindow, cursorXPositionByteBuffer, cursorYPositionByteBuffer);
        int newXCursorPosition = cursorXPositionByteBuffer.getInt();
        int newYCursorPosition = cursorYPositionByteBuffer.getInt();
        if (newXCursorPosition != lastXCursorPosition || newYCursorPosition != lastYCursorPosition) {
            if (inputListener != null) {
                inputListener.onMouseMove(newXCursorPosition, newYCursorPosition, lastXCursorPosition - newXCursorPosition, lastYCursorPosition - newYCursorPosition);
            }
        }
        lastXCursorPosition = newXCursorPosition;
        lastYCursorPosition = newYCursorPosition;
    }

}
