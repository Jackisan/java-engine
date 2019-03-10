package com.jegg.engine;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Prim2 {

    //No point in having these, polygons cant use them
    //public Vec2[] vecs;
    //private Vec2[] cachedVecs;
    public int[] xCoords;
    public int[] yCoords;
    public int nPoints;

    public Color color = Color.lightGray;

    public Prim2(int[] xCoords, int[] yCoords){
        this.xCoords = xCoords.clone();
        this.yCoords = yCoords.clone();
    }
    public Prim2(Point[] points){
        nPoints = points.length;
        xCoords = new int[nPoints];
        yCoords = new int[nPoints];
        for(int i = 0; i < nPoints; i++){
            xCoords[i] = points[i].x;
            yCoords[i] = points[i].y;
        }
    }
    Prim2(){

    }

    public void rotateDeg(int degs){
        //AffineTransform.getRotateInstance(Math.toRadians(degs), center.x, center.y);

    }
    public void rotateRad(int rads){

    }

    public void draw(Graphics2D g2d){
        g2d.setColor(color);
        g2d.fillPolygon(xCoords, yCoords, xCoords.length);
    }

    public static class Rect extends Prim2{

        public Rect(float x, float y, float width, float height){
            xCoords = new int[4];
            yCoords = new int[4];
            xCoords = new int[]{(int)x, (int)x, (int)x + (int)width, (int)x + (int)width};
            yCoords = new int[]{(int)y, (int)y + (int)height, (int)y + (int)height, (int)y};
        }

        public void draw(Graphics2D g2d){
            g2d.setColor(color);
            g2d.fillPolygon(xCoords, yCoords, xCoords.length);
        }

    }

}
