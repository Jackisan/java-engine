package com.jegg.game;

import com.jegg.engine.*;

import java.awt.event.KeyEvent;

public class Player extends Script{

    public static Player instance;
    public float speed = 3;

    public void start(){
        instance = this;
        getGameObject().addScript(ObjectPool.class);
    }

    public void update(){
        if(Input.isKey(KeyEvent.VK_W)){
            getGameObject().getPosition().y -= speed;
        }
        else if(Input.isKey(KeyEvent.VK_S)){
            getGameObject().getPosition().y += speed;
        }
        if(Input.isKey(KeyEvent.VK_A)){
            getGameObject().getPosition().x -= speed;
        }
        else if(Input.isKey(KeyEvent.VK_D)){
            getGameObject().getPosition().x += speed;
        }
        if(Input.isKeyUp(KeyEvent.VK_SPACE)){

        }
    }

}
