package com.jegg.engine.physics;

import org.dyn4j.collision.Bounds;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.RaycastResult;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Vector2;

public class Physics {

    private static World world;

    public static World GetWorld(){
        return world;
    }
    public static void SetWorld(World newWorld){
        world = newWorld;
    }
    public static void SetWorldBounds(Bounds bounds){
        world.setBounds(bounds);
    }
    public static boolean Raycast(Vector2 start, Vector2 end, Body body){
        RaycastResult result = new RaycastResult();
        return world.raycast(start, end, body, true, result);
    }
    public static void AddBody(Body body){
        world.addBody(body);
    }
}