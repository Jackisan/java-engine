package com.jegg.engine;

import java.awt.*;

public class Vec3d {

    public float x, y, z;
    private Vec2d vec2;

    public Vec3d(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3d(Vec3d vec3){
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
    }

    public void set(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void set(Vec3d vec3){
        this.x = vec3.x;
        this.y = vec3.y;
        this.z = vec3.z;
    }

    public void set(Vec2d vec2, boolean zeroOutZ){
        this.x = vec2.x;
        this.y = vec2.y;
        if(zeroOutZ){
            z = 0;
        }
    }

    public void set(Point point, boolean zeroOutZ){
        x = point.x;
        y = point.y;
        if(zeroOutZ){
            z = 0;
        }
    }

    public void add(Vec3d vec3){
        this.x += vec3.x;
        this.y += vec3.y;
        this.z += vec3.z;
    }

    public void sub(Vec3d vec3){
        this.x -= vec3.x;
        this.y -= vec3.y;
        this.z -= vec3.z;
    }

    public Vec2d toVec2d(){
        if(vec2 != null){
            vec2.set(x,y);
            return vec2;
        }
        else{
            vec2 = new Vec2d(x,y);
            return vec2;
        }
    }

    public Point toPoint(){
        if(vec2 != null){
            vec2.set(x,y);
            return vec2.toPoint();
        }
        else{
            vec2 = new Vec2d(x,y);
            return vec2.toPoint();
        }
    }

    public static float Distance(Vec3d v1, Vec3d v2){
        return (float)Math.sqrt(Math.pow(v2.x - v1.x, 2) + Math.pow(v2.y - v1.y, 2) + Math.pow(v2.z - v1.z, 2));
    }
}
