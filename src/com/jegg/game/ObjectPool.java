package com.jegg.game;

import com.jegg.engine.GameObject;
import com.jegg.engine.Script;
import com.jegg.engine.scriptcomponents.Sprite;

import java.util.ArrayList;

public class ObjectPool extends Script {

    public ArrayList<GameObject> bullets_using = new ArrayList<>();
    public ArrayList<GameObject> bullets_free = new ArrayList<>();

    public void start(){
        for(int i = 0; i < 50; i++){
            bullets_free.add(new GameObject());
            Sprite sprite = bullets_free.get(i).addScript(Sprite.class);
            sprite.setImage("resources/laser_sprite.png");
        }
    }

    public GameObject getBullet(){
        GameObject bullet = bullets_free.get(0);
        bullets_free.remove(bullet);
        bullets_using.add(bullet);
        return bullet;
    }
}
