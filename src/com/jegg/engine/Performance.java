package com.jegg.engine;

public class Performance {

    /**
     * Frames per second, value is updated in the main loop
     */
    public static int fps;

    /**
     * Updates per second, value is updated in the main loop
     */
    public static int ups;

    /**
     * The max number of updates that the main loop should be attempting to reach
     */
    public static double maxUps = 60.0;

    /**
     * 1 divided by the updates per second, value is updated in the main loop
     */
    public static float delta;



}
