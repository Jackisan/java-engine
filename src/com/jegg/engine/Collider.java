package com.jegg.engine;

import java.awt.*;

public abstract class Collider extends Script {

    public Rectangle.Float bounds = new Rectangle.Float();

    public static class Box extends Collider{

    }
}
