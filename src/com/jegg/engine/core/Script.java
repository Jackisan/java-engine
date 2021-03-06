package com.jegg.engine.core;

import com.jegg.engine.physics.PhysicsBody;

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
    public void onCollision(PhysicsBody p){

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
