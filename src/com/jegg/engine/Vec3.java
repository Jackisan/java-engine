package com.jegg.engine;

import java.awt.*;

public class Vec3 {

    public float x, y, z;
    private Vec2 vec2;

    public Vec3(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(Vec3 vec3){
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
    }

    public void set(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(Vec3 vec3){
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
    }

    public void add(Vec3 vec3){
        this.x += vec3.x;
        this.y += vec3.y;
        this.z += vec3.z;
    }

    public void sub(Vec3 vec3){
        this.x -= vec3.x;
        this.y -= vec3.y;
        this.z -= vec3.z;
    }

    public Vec2 toVec2(){
        if(vec2 != null){
            vec2.set(x,y);
            return vec2;
        }
        else{
            vec2 = new Vec2(x,y);
            return vec2;
        }
    }

    public Point to2DPoint(){
        if(vec2 != null){
            vec2.set(x,y);
            return vec2.toPoint();
        }
        else{
            vec2 = new Vec2(x,y);
            return vec2.toPoint();
        }
    }

    public static float Distance(Vec3 v1, Vec3 v2){
        return (float)Math.sqrt(Math.pow(v2.x - v1.x, 2) + Math.pow(v2.y - v1.y, 2) + Math.pow(v2.z - v1.z, 2));
    }
}
