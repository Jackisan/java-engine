package com.jegg.engine;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Mesh2d extends Script {

    private Vec2d[] verts;

    public void setVerts(Vec2d[] verts){
        this.verts = verts.clone();
    }

    public Vec2d[] getVerts(){
        return verts;
    }

    private void assemblePoly(){
        for(int i = 0; i < verts.length; i++){

        }
    }

    public void rotate(int degs){

    }

    public void render(){
        glColor3f(1f, 1f, 1f);
        glBegin(GL_POLYGON);
        {
            for(Vec2d vec : verts){
                glVertex2f(vec.x, vec.y);
            }
        }
        glEnd();
    }

    public static class Rect{

        int x, y, width, height;

        Rect(int x, int y, int width, int height){
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }
    }

}