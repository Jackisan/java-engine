package com.game;

import com.jegg.engine.core.GameObject;
import com.jegg.engine.core.MathP;
import com.jegg.engine.core.Vec2d;
import com.jegg.engine.core.Vec3d;
import com.jegg.engine.scriptcomponents.Mesh2d;
import org.lwjgl.opengl.GL11;

public class CubeSpawner {

    public static long lastTime = System.currentTimeMillis();
    public static long elapsedTime;

    public static void update(){

        long now = System.currentTimeMillis();
        elapsedTime += now - lastTime;

        //System.out.println(elapsedTime);

        if(elapsedTime > 1000) {

            Mesh2d mesh = new GameObject(new Vec3d(0, 0, 0)).addScript(Mesh2d.class);
            mesh.drawMode = GL11.GL_QUADS;
            Vec2d[] verts = new Vec2d[4];

            //Cache randomOffset
            Vec2d random = new Vec2d(MathP.randomRange(-100,100), MathP.randomRange(-100,100));
            verts[0] = new Vec2d(Player.instance.getPosition().x + random.x, Player.instance.getPosition().y + random.y);
            verts[1] = new Vec2d(verts[0].x + MathP.randomRange(-5,5), verts[0].y);
            verts[2] = new Vec2d(verts[1].x + MathP.randomRange(-5,5), verts[1].y + MathP.randomRange(-5,5));
            verts[3] = new Vec2d(verts[2].x, verts[2].y + MathP.randomRange(-5,5));
            mesh.setVerts(verts);
            elapsedTime = 0;
        }
        lastTime = now;
    }
}
