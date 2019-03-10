package com.jegg.engine;

import java.awt.*;

public abstract class Standalone {

    private boolean destroyOnUse;
    boolean destroyed;

    public abstract void singleExecute();

    public abstract void loopExecute();

    public abstract void render();

    public void setDestroyOnUse(boolean state){
        destroyOnUse = state;
    }
}
