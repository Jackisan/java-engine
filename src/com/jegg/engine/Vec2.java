package com.jegg.engine;

import java.awt.*;

public class Vec2 {

    public float x, y;
    private Point point;

    public Vec2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vec2(Vec2 vec2){
        this.x = vec2.x;
        this.y = vec2.y;
    }

    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void set(Vec2 vec2){
        this.x = vec2.x;
        this.y = vec2.y;
    }

    public void add(Vec2 vec2){
        this.x += vec2.x;
        this.y += vec2.y;
    }

    public void sub(Vec2 vec2){
        this.x -= vec2.x;
        this.y -= vec2.y;
    }

    public Point toPoint(){
        if(point != null){
            point.x = (int)x;
            point.y = (int)y;
            return point;
        }
        else{
            point = new Point((int)x, (int)y);
            return point;
        }
    }

    public static float Distance(Vec2 v1, Vec2 v2){
        return (float)Math.sqrt(Math.pow(v2.x - v1.x, 2) + Math.pow(v2.y - v1.y, 2));
    }
}
