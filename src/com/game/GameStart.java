package com.game;

import com.jegg.engine.core.GameObject;

public class GameStart {

    public void startGame(){
        Player player = new GameObject().addScript(Player.class);
    }
}
