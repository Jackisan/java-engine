package com.jegg.engine.input;

public class Input {

    public static boolean isKey(int keyCode){
        if(KeyboardInput.keysPressed[keyCode] || KeyboardInput.keysReleased[keyCode]){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isKeyUp(int keyCode){
        return KeyboardInput.keysReleased[keyCode];
    }
    public static boolean isKeyDown(int keyCode){
        return KeyboardInput.keysPressed[keyCode];
    }
    public static boolean isButton(int buttonCode){
        if(MouseButtonInput.buttonsPressed[buttonCode] || MouseButtonInput.buttonsReleased[buttonCode]){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean isButtonUp(int buttonCode){
        return MouseButtonInput.buttonsReleased[buttonCode];
    }
    public static boolean isButtonDown(int buttonCode){
        return MouseButtonInput.buttonsPressed[buttonCode];
    }
    public static double getMouseX(){
        return MouseMovementInput.mouseX;
    }
    public static double getMouseY(){
        return MouseMovementInput.mouseY;
    }
    public static double getScrollX(){
        return ScrollInput.scrollX;
    }
    public static double getScrollY(){
        return ScrollInput.scrollY;
    }

}
