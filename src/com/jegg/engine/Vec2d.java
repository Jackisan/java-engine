package com.jegg.engine;

import java.awt.*;

public class Vec2d {

    public float x, y;
    private Point point;
    private Vec3d vec3d;

    public Vec2d(float x, float y){
        this.x = x;
        this.y = y;
    }

    public Vec2d(Vec2d vec2){
        this.x = vec2.x;
        this.y = vec2.y;
    }

    public void set(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void set(Vec2d vec2){
        this.x = vec2.x;
        this.y = vec2.y;
    }

    public void set(Vec3d vec3){
        x = vec3.x;
        y = vec3.y;
    }

    public void set(Point point){
        x = point.x;
        y = point.y;
    }

    public void add(Vec2d vec2){
        this.x += vec2.x;
        this.y += vec2.y;
    }

    public void sub(Vec2d vec2){
        this.x -= vec2.x;
        this.y -= vec2.y;
    }

    public Vec3d toVec3d(){
        if(vec3d != null){
            vec3d.set(x,y,0);
            return vec3d;
        }
        else{
            vec3d = new Vec3d(x,y,0);
            return vec3d;
        }
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

    public static float Distance(Vec2d v1, Vec2d v2){
        return (float)Math.sqrt(Math.pow(v2.x - v1.x, 2) + Math.pow(v2.y - v1.y, 2));
    }
}
