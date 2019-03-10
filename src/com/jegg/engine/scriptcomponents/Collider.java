package com.jegg.engine.scriptcomponents;

import com.jegg.engine.core.Script;

import java.awt.*;

public abstract class Collider extends Script {

    public Rectangle.Float bounds = new Rectangle.Float();

    public static class Box extends Collider{

    }
}
