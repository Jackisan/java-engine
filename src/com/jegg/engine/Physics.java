package com.jegg.engine;

import java.awt.*;
import java.util.ArrayList;

public class Physics extends Script {

    Rectangle.Float bounds = new Rectangle.Float();

    public ArrayList<GameObject> collidingObjects = new ArrayList<>();

    public boolean trigger;
    public boolean solid;

    public Vec3d velocity = new Vec3d(0,0,0);

    public void start(){
        bounds.x = getPosition().x;
        bounds.y = getPosition().y;
        update();
    }

    public void update(){

        bounds.x = getPosition().x;
        bounds.y = getPosition().y;

        //Movement
        if(solid){
            checkAndMove();
        }

        //If this is a physics body for triggering collision calls
        else if(trigger) {
            //Get all colliding physics
            for (Physics p : Main.getHandler().getPhysics()) {
                //If its not already colliding
                if(p != this && !collidingObjects.contains(p.getGameObject()) && intersects(p)) {
                    //Call collisions
                    collidingObjects.add(p.getGameObject());
                    for (Script s : getGameObject().getScripts()) {
                        s.onCollision(p);
                    }
                }
            }
        }
    }

    public void setBounds(float x, float y, float width, float height){
        bounds.x = x;
        bounds.y = y;
        bounds.width = width;
        bounds.height = height;
    }
    public boolean intersects(Physics physics){
        return bounds.intersects(physics.bounds);
    }
    public boolean intersects(Rectangle rectangle){
        return bounds.intersects(rectangle);
    }

    public void checkAndMove(){
        boolean freeToMove = false;
        Vec3d nextPosition = new Vec3d(getPosition().x + velocity.x, getPosition().y + velocity.y, getPosition().z + velocity.z);
        for(Physics p : Main.getHandler().getPhysics()){
            if(p != this && p.solid && !p.trigger){

            }
        }
    }

}
