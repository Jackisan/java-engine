package com.jegg.engine.scriptcomponents;

import com.jegg.engine.core.Script;
import com.jegg.engine.core.Vec2d;
import com.jegg.engine.core.Vec3d;

public class Camera extends Script {

    public Vec3d camPosition = new Vec3d(0,0,0);
    private Vec2d translatedVec2d;
    private static Camera main;
    public boolean orthoView;

    public void update(){
        if(getGameObject() != null){
            camPosition.set(getPosition());
        }
    }

    public static void setMain(Camera camera){
        main = camera;
    }
    public static Camera getMain(){
        if(main != null){
            return main;
        }
        else{
            main = new Camera();
            return main;
        }
    }

    /*public Vec2d translatedVec2d(){
        if(translatedVec2d != null){
            translatedVec2d.set(-camPosition.x + Window.Middle().x, -camPosition.y + Window.Middle().y);
            return translatedVec2d;
        }
        else{
            translatedVec2d = new Vec2d(-camPosition.x + Window.Middle().x, -camPosition.y + Window.Middle().y);
            return translatedVec2d;
        }
    }*/
   /* public void translate2dPositive(Graphics2D g2d){
        g2d.translate(translatedVec2d().x, translatedVec2d().y);
    }
    public void translate2dNegative(Graphics2D g2d){
        g2d.translate(-translatedVec2d().x, -translatedVec2d().y);
    }*/
}
