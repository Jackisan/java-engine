package com.jegg.engine.scriptcomponents;

import com.jegg.engine.core.Script;
import com.jegg.engine.core.Vec2d;
import com.jegg.engine.core.Vec3d;
import org.lwjgl.opengl.GL11;

public class Camera extends Script {

    private static Camera main;

    public void update(){
        //GL11.glTranslatef(getPosition().x, getPosition().y, getPosition().z);
    }

    public static void setMain(Camera camera){
        if(main.getGameObject() != null){
            main = camera;
        }
    }
    public static Camera getMain(){
        return main;
    }
    public void makeOrtho(){

    }
}
