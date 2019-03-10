package com.game;

import com.jegg.engine.*;

import com.jegg.engine.scriptcomponents.Mesh2d;


public class GameStart {

    public void startGame(){
        /*for(int i = 0; i < 1000; i++){
            Sprite sprite = new GameObject(new Vec3d(MathP.randomRange(-500,500), MathP.randomRange(-500,500), 0)).addScript(Sprite.class);
            sprite.setImage("resources/pokeball_sprite.png");
        }
        Sprite sprite = new GameObject(new Vec3d(0,0,0)).addScript(Sprite.class);
        sprite.setImage("resources/diamond_sprite.png");
        sprite.getGameObject().addScript(Player.class);
        sprite.getGameObject().addScript(Camera.class);
        Camera.setMain(sprite.getGameObject().getScript(Camera.class));

        Sprite pokeball = new GameObject(new Vec3d(10,10,0)).addScript(Sprite.class);
        pokeball.setImage("resources/pokeball_sprite.png");

        Sprite physduck = new GameObject(new Vec3d(50,50,0)).addScript(Sprite.class);
        physduck.setImage("resources/physduck_sprite.png");

        Sprite pikachu = new GameObject(new Vec3d(90,90,0)).addScript(Sprite.class);
        pikachu.setImage("resources/pikachu_sprite.png");*/

        Mesh2d mesh = new GameObject().addScript(Mesh2d.class);
        Vec2d[] verts = new Vec2d[6];
        verts[0] = new Vec2d(10,10);
        verts[1] = new Vec2d(20,10);
        verts[2] = new Vec2d(20,20);
        verts[3] = new Vec2d(20,30);
        verts[4] = new Vec2d(20,20);
        verts[5] = new Vec2d(10,20);
        mesh.setVerts(verts);
    }
}
