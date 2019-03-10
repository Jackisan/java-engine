package com.jegg.engine.core;

import java.util.ArrayList;

/**
 * An object that is "physically" present in the game.
 * Adding scripts to GameObjects will allow you to add functionality to them
 */
public class GameObject {

    private Vec3d position = new Vec3d(0,0,0);
    public boolean active;

    private ArrayList<Script> scripts = new ArrayList<>();

    public GameObject(Vec3d position){
        this.position.set(position);
        active = true;
    }
    public GameObject(){
        active = true;
    }

    public <T> T addScript(Class<? extends Script> scriptClass){
        T script = null;
        try {
            script = (T)scriptClass.newInstance();
            ((Script)script).gameObject = this;
            ((Script)script).start();
            scripts.add((Script)script);
            Main.getHandler().addScript((Script)script);
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return script;
    }
    public void removeScript(Class<? extends Script> scriptClass){
        for(Script script : scripts){
            if(script.getClass() == scriptClass){
                scripts.remove(script);
                Main.getHandler().removeScript(script);
                return;
            }
        }
    }
    public <T> T getScript(Class<? extends Script> scriptClass){
        for(Script s : scripts){
            if(s.getClass() == scriptClass){
                try{
                    return (T)s;
                } catch(Exception e){
                    e.printStackTrace();
                }

            }
        }
        return null;
    }
    public ArrayList<Script> getScripts(){
        return (ArrayList<Script>) scripts.clone();
    }

    public Vec3d getPosition(){
        return position;
    }
    public Vec2d getPosition2d(){
        return position.toVec2d();
    }

}
