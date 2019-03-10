package com.jegg.engine.input;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;

public class KeyboardInput implements GLFWKeyCallbackI {

    static final int NUM_OF_KEYS = 65536;
    static boolean[] keysPressed = new boolean[NUM_OF_KEYS];
    static boolean[] keysReleased = new boolean[NUM_OF_KEYS];

    @Override
    public void invoke(long window, int key, int scancode, int action, int mods) {
        switch(action){
            case GLFW.GLFW_PRESS : keysPressed[key] = true;
            case GLFW.GLFW_RELEASE : keysReleased[key] = true;
        }
    }
}
