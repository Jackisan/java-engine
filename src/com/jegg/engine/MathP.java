package com.jegg.engine;

import java.util.concurrent.ThreadLocalRandom;

public class MathP {

    public static int randomRange(int min, int max){
        return ThreadLocalRandom.current().nextInt(min,max);
    }
}
