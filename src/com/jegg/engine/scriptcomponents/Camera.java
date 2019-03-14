package com.jegg.engine.scriptcomponents;

import com.jegg.engine.core.Script;
import com.jegg.engine.core.Vec2d;
import com.jegg.engine.core.Vec3d;
import org.lwjgl.opengl.GL11;

public class Camera extends Script {

    public Vec3d camPosition = new Vec3d(0,0,0);
    private Vec2d translatedVec2d;
    private static Camera main;
    public boolean orthoView;

    public void update(){
        if(getGameObject() != null){
            camPosition.set(getPosition());
        }
        GL11.glTranslatef(getPosition().x, getPosition().y, getPosition().z);
    }

    public static void setMain(Camera camera){
        if(main.getGameObject() != null){
            main = camera;
        }
    }
    public static Camera getMain(){
        return main;
    }
}
