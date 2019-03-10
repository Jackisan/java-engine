package com.jegg.engine.input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWMouseButtonCallbackI;

public class MouseButtonInput implements GLFWMouseButtonCallbackI {

    static final int NUM_OF_BUTTONS = 8;
    static boolean[] buttonsPressed = new boolean[NUM_OF_BUTTONS];
    static boolean[] buttonsReleased = new boolean[NUM_OF_BUTTONS];

    @Override
    public void invoke(long window, int button, int action, int mods) {
        switch(action){
            case GLFW.GLFW_PRESS : buttonsPressed[button] = true;
            case GLFW.GLFW_RELEASE : buttonsReleased[button] = true;
        }
    }
}
