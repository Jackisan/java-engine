package com.jegg.engine.input;

import org.lwjgl.glfw.GLFWScrollCallbackI;

public class ScrollInput implements GLFWScrollCallbackI {

    static double scrollX, scrollY;

    @Override
    public void invoke(long window, double xoffset, double yoffset) {
        scrollX = xoffset;
        scrollY = yoffset;
    }

}
