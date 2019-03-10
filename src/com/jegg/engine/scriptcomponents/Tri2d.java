package com.jegg.engine.scriptcomponents;

import com.jegg.engine.core.Vec2d;

public class Tri2d {

    private Vec2d[] vecs = new Vec2d[3];

    public Tri2d(Vec2d vec1, Vec2d vec2, Vec2d vec3){
        vecs[0] = new Vec2d(0,0);
        vecs[0].set(vec1);
        vecs[1] = new Vec2d(0,0);
        vecs[1].set(vec2);
        vecs[2] = new Vec2d(0,0);
        vecs[2].set(vec3);
    }

    public void setVecs(Vec2d vec1, Vec2d vec2, Vec2d vec3){
        vecs[0].set(vec1);
        vecs[1].set(vec2);
        vecs[2].set(vec3);
    }

    public Vec2d[] getVecs(){
        return vecs.clone();
    }

}
