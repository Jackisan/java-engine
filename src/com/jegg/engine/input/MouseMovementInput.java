package com.jegg.engine.input;

import org.lwjgl.glfw.GLFWCursorPosCallbackI;

public class MouseMovementInput implements GLFWCursorPosCallbackI {

    static double mouseX, mouseY;

    @Override
    public void invoke(long window, double xpos, double ypos) {
        mouseX = xpos;
        mouseY = ypos;
    }
}
