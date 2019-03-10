package com.jegg.engine;

import java.awt.*;

/**
 * An object designed to add functionality to GameObjects.
 * Scripts are the main way to create actions and features for a game
 */
public abstract class Script {

    GameObject gameObject;
    private boolean active = true;
    boolean destroyed;

    public void start(){
    }
    public void update(){
    }
    public void render(){
    }
    public void onCollision(Physics p){

    }

    public GameObject getGameObject(){
        return gameObject;
    }

    public Vec3d getPosition(){
        return gameObject.getPosition();
    }

    public void setActive(boolean active){
        this.active = active;
    }
    public boolean getActive(){
        return active;
    }

}
