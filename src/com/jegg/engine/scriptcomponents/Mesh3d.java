package com.jegg.engine.scriptcomponents;

import com.jegg.engine.core.Script;
import com.jegg.engine.core.Vec3d;

import static org.lwjgl.opengl.GL11.*;

public class Mesh3d extends Script {

    private Vec3d[] verts;
    public int drawMode = GL_POLYGON;
    public float[] color = new float[3];

    public void setVerts(Vec3d[] verts) {
        this.verts = verts.clone();
    }

    public Vec3d[] getVerts() {
        return verts;
    }

    public void rotate(int degs) {

    }

    public void render() {
        glColor3f(1f, 1f, 1f);
        glBegin(GL_POLYGON);
        {
            for (Vec3d vec : verts) {
                glVertex3f(getPosition().x + vec.x, getPosition().y + vec.y, getPosition().z + vec.z);
            }
        }
        glEnd();
    }

}

