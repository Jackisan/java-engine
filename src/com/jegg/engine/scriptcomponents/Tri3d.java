package com.jegg.engine.scriptcomponents;

import com.jegg.engine.core.Vec3d;

public class Tri3d {

    private Vec3d[] vecs;
    public int vecsLength;
    public int[] vecX;
    public int[] vecY;

    public Tri3d(Vec3d[] vecs){
        this.vecs = vecs;
        vecsLength = vecs.length;
        fillVecX();
        fillVecY();
    }

    public void setVecs(Vec3d[] vecs){
        this.vecs = vecs;
        vecsLength = vecs.length;
        fillVecX();
        fillVecY();
    }

    public int[] fillVecX(){
        vecX = new int[vecs.length];
        for(int i = 0; i < vecs.length; i++){
            vecX[i] = (int)vecs[i].x;
        }
        return vecX;
    }
    public int[] fillVecY(){
        vecY = new int[vecs.length];
        for(int i = 0; i < vecs.length; i++){
            vecY[i] = (int)vecs[i].y;
        }
        return vecY;
    }
}
