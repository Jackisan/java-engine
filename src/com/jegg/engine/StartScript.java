package com.jegg.engine;

import com.jegg.game.Player;

public class StartScript {

    void start(){
        Sprite sprite = new GameObject(new Vec3d(0,0,0)).addScript(Sprite.class);
        sprite.setImage("resources/diamond_sprite.png");
        sprite.gameObject.addScript(Player.class);
        sprite.gameObject.addScript(Camera.class);
        Camera.setMain(sprite.gameObject.getScript(Camera.class));

        Sprite pokeball = new GameObject(new Vec3d(10,10,0)).addScript(Sprite.class);
        pokeball.setImage("resources/pokeball_sprite.png");

        Sprite physduck = new GameObject(new Vec3d(50,50,0)).addScript(Sprite.class);
        physduck.setImage("resources/physduck_sprite.png");

        Sprite pikachu = new GameObject(new Vec3d(90,90,0)).addScript(Sprite.class);
        pikachu.setImage("resources/pikachu_sprite.png");
    }
}
