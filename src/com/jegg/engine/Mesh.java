package com.jegg.engine;

import java.awt.*;

public class Mesh {

    public Tri[] tris;

    public Mesh(Tri[] tris){
        this.tris = tris;
    }

    public void draw(Graphics2D g2d){
        for(Tri tri : tris){
            g2d.fillPolygon(tri.vecX, tri.vecY, tri.vecsLength);
        }
    }


}
