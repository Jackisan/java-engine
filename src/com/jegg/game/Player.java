package com.jegg.game;

import com.jegg.engine.*;
import com.jegg.engine.input.Input;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Player extends Script{

    public static Player instance;
    public float speed = 3;

    public void start(){
        instance = this;
        getGameObject().addScript(ObjectPool.class);
    }

    public void update(){
        if(Input.isKey(GLFW.GLFW_KEY_W)){
            getGameObject().getPosition().y -= speed;
        }
        else if(Input.isKey(GLFW.GLFW_KEY_S)){
            getGameObject().getPosition().y += speed;
        }
        if(Input.isKey(GLFW.GLFW_KEY_A)){
            getGameObject().getPosition().x -= speed;
        }
        else if(Input.isKey(GLFW.GLFW_KEY_D)){
            getGameObject().getPosition().x += speed;
        }
        if(Input.isKeyUp(GLFW.GLFW_KEY_SPACE)){
            shoot();
        }
    }

    public void shoot(){
        Mesh2d mesh = new GameObject().addScript(Mesh2d.class);
        Vec2d[] verts = new Vec2d[4];
        verts[0] = new Vec2d();
        mesh.setVerts(verts);
        mesh.drawMode = GL11.GL_QUADS;
    }

}
