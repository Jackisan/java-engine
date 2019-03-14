package com.game;

import com.jegg.engine.core.GameObject;
import com.jegg.engine.core.Script;
import com.jegg.engine.core.Vec2d;
import com.jegg.engine.core.Vec3d;
import com.jegg.engine.input.Input;
import com.jegg.engine.physics.PhysicsBody;
import com.jegg.engine.scriptcomponents.Camera;
import com.jegg.engine.scriptcomponents.Mesh2d;
import org.dyn4j.dynamics.Force;
import org.dyn4j.geometry.Polygon;
import org.dyn4j.geometry.Vector2;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;

public class Player extends Script {

    public static Player instance;
    public float speed = 3;
    public Vec2d lastPosition = new Vec2d(0,0);
    public float lastTime = System.currentTimeMillis();
    public float elapsedDistance;
    public float elapsedTime;

    public void start(){
        instance = this;
        getGameObject().addScript(ObjectPool.class);
        getGameObject().addScript(Camera.class);

        Mesh2d mesh = getGameObject().addScript(Mesh2d.class);
        Vec2d[] verts = new Vec2d[4];
        verts[0] = new Vec2d(-2,-2);
        verts[1] = new Vec2d(2,-2);
        verts[2] = new Vec2d(2,2);
        verts[3] = new Vec2d(-2,2);
        mesh.setVerts(verts);
        mesh.drawMode = GL11.GL_QUADS;

        PhysicsBody physics = getGameObject().addScript(PhysicsBody.class);
        physics.body.addFixture(new Polygon(verts[0].toPhysVec(), verts[1].toPhysVec(), verts[2].toPhysVec(), verts[3].toPhysVec()));
        physics.body.setLinearVelocity(10,10);
    }

    public void update(){

        CubeSpawner.update();

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

        elapsedTime += System.currentTimeMillis() - lastTime;
        elapsedDistance += Vec2d.Distance(getPosition().toVec2d(), lastPosition);

        /*if(elapsedTime > 10000 || elapsedDistance > 30){
            elapsedTime = 0;
            elapsedDistance = 0;
            Mesh2d mesh = new GameObject(getPosition()).addScript(Mesh2d.class);
            mesh.drawMode = GL11.GL_QUADS;
            Vec2d[] verts = new Vec2d[4];
            verts[0] = new Vec2d(-2,-2);
            verts[1] = new Vec2d(2,-2);
            verts[2] = new Vec2d(2,2);
            verts[3] = new Vec2d(-2,2);
            mesh.setVerts(verts);
        }*/

        lastTime = System.currentTimeMillis();
        lastPosition.set(getPosition());
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
