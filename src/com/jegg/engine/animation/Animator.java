package com.jegg.engine.animation;

import com.jegg.engine.core.Script;

import java.util.HashMap;

public class Animator extends Script {

    public HashMap<String, Boolean> bools = new HashMap<String, Boolean>();

    public void addBool(String name, Boolean bool){
        bools.put(name, bool);
    }
    public void removeBool(String name, Boolean bool){
        bools.put(name, bool);
    }

    public void setBool(String name, Boolean bool){

    }

}
