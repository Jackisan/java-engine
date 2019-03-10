package com.jegg.engine;

public class Tri {

    private Vec3[] vecs;
    public int vecsLength;
    public int[] vecX;
    public int[] vecY;

    public Tri(Vec3[] vecs){
        this.vecs = vecs;
        vecsLength = vecs.length;
        fillVecX();
        fillVecY();
    }

    public void setVecs(Vec3[] vecs){
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
