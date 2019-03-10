package com.jegg.engine;

public class Transform {

    Vec3d position = new Vec3d(0,0,0);
    Vec3d scale = new Vec3d(1,1,1);

    GameObject gameObject;

    Transform(GameObject gameObject){
        this.gameObject = gameObject;
    }
    Transform(GameObject gameObject, Vec3d position){
        this.position.set(position);
        this.gameObject = gameObject;
    }
    Transform(GameObject gameObject, Vec2d position){
        this.position.set(position, true);
        this.gameObject = gameObject;
    }
    Transform(GameObject gameObject, Transform transform){
        if(transform != null) {
            position.set(transform.position);
            scale.set(transform.scale);
        }
        this.gameObject = gameObject;
    }

}
