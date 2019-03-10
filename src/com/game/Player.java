package com.game;

import com.jegg.engine.core.GameObject;
import com.jegg.engine.core.Script;
import com.jegg.engine.core.Vec2d;
import com.jegg.engine.input.Input;
import com.jegg.engine.scriptcomponents.Mesh2d;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Player extends Script {

    public static Player instance;
    public float speed = 1;

    public void start(){
        instance = this;
        getGameObject().addScript(ObjectPool.class);

        Mesh2d mesh = getGameObject().addScript(Mesh2d.class);
        Vec2d[] verts = new Vec2d[4];
        verts[0] = new Vec2d(-2,-2);
        verts[1] = new Vec2d(2,-2);
        verts[2] = new Vec2d(2,2);
        verts[3] = new Vec2d(-2,2);
        mesh.setVerts(verts);
        mesh.drawMode = GL11.GL_QUADS;
    }

    public void update(){
        if(Input.isKey(GLFW.GLFW_KEY_W)){
            getPosition().y -= speed;
        }
        else if(Input.isKey(GLFW.GLFW_KEY_S)){
            getPosition().y += speed;
        }
        if(Input.isKey(GLFW.GLFW_KEY_A)){
            getPosition().x -= speed;
        }
        else if(Input.isKey(GLFW.GLFW_KEY_D)){
            getPosition().x += speed;
        }
        if(Input.isKeyUp(GLFW.GLFW_KEY_SPACE)){
            shoot();
        }
    }

    public void shoot(){
        Mesh2d mesh = new GameObject().addScript(Mesh2d.class);
        Vec2d[] verts = new Vec2d[4];
        verts[0] = new Vec2d(-2,-2);
        verts[1] = new Vec2d(2,-2);
        verts[2] = new Vec2d(2,2);
        verts[3] = new Vec2d(-2,2);
        mesh.setVerts(verts);
        mesh.drawMode = GL11.GL_QUADS;
    }

}
