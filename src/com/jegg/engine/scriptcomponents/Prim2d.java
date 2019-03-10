package com.jegg.engine.scriptcomponents;

import java.awt.*;

public class Prim2d {

    //No point in having these, polygons cant use them
    //public Vec2d[] vecs;
    //private Vec2d[] cachedVecs;
    public int[] xCoords;
    public int[] yCoords;
    public int nPoints;

    public Color color = Color.lightGray;

    public Prim2d(int[] xCoords, int[] yCoords){
        this.xCoords = xCoords.clone();
        this.yCoords = yCoords.clone();
    }
    public Prim2d(Point[] points){
        nPoints = points.length;
        xCoords = new int[nPoints];
        yCoords = new int[nPoints];
        for(int i = 0; i < nPoints; i++){
            xCoords[i] = points[i].x;
            yCoords[i] = points[i].y;
        }
    }
    Prim2d(){

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

    public static class Rect extends Prim2d {

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
