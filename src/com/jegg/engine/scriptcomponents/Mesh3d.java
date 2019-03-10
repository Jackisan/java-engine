package com.jegg.engine.scriptcomponents;

import java.awt.*;

public class Mesh3d {

    public Tri3d[] tris;

    public Mesh3d(Tri3d[] tris){
        this.tris = tris;
    }

    public void draw(Graphics2D g2d){
        for(Tri3d tri : tris){
            g2d.fillPolygon(tri.vecX, tri.vecY, tri.vecsLength);
        }
    }


}
