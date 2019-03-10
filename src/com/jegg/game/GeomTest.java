package com.jegg.game;

import com.jegg.engine.Input;
import com.jegg.engine.Prim2;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GeomTest {

    public static Prim2 square;
    public static Prim2 poly;

    public static int yPos = 10;
    public static int xPos = 10;

    public static void start(){
        square = new Prim2.Rect(xPos,yPos,10,10);
        square.color = Color.green;
        Point[] points = new Point[4];
        points[0] = new Point(xPos + 20,yPos + 20);
        points[1] = new Point(xPos + 20,yPos + 30);
        points[2] = new Point(xPos + 30,yPos + 30);
        points[3] = new Point(xPos + 30,yPos + 20);
        poly = new Prim2(points);
        poly.color = Color.green;
    }

    public static void update(){
        if(Input.isKey(KeyEvent.VK_S)){
            yPos += 3;
        }
        else if(Input.isKey(KeyEvent.VK_D)){
            xPos += 3;
        }
    }

    public static void render(Graphics2D g2d){
        square.draw(g2d);
        poly.draw(g2d);
    }
}
