package com.jegg.engine.core;

import java.lang.reflect.Method;

import com.jegg.engine.input.KeyboardInput;
import com.jegg.engine.input.MouseButtonInput;
import com.jegg.engine.input.MouseMovementInput;
import com.jegg.engine.input.ScrollInput;
import com.jegg.engine.physics.Physics;

import org.dyn4j.dynamics.World;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * The main application where the game is started and the loop is run
 */
public class Main {

    private boolean running = true;

    private static Handler handler;

    private Main(){
        run();
    }

    private void stop(){
        // Free the window callbacks and destroy the window
        glfwFreeCallbacks(Window.getWindow());
        glfwDestroyWindow(Window.getWindow());

        // Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void run(){

        // Setup an error callback. The default implementation
        // will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        //Instantiate Window
        new Window();

        //Set up input classes
        glfwSetMouseButtonCallback(Window.getWindow(), new MouseButtonInput());
        glfwSetCursorPosCallback(Window.getWindow(), new MouseMovementInput());
        glfwSetKeyCallback(Window.getWindow(), new KeyboardInput());
        glfwSetScrollCallback(Window.getWindow(), new ScrollInput());

        //Instantiate the Handler
        handler = new Handler();

        //Set up dyn4j physics world
        Physics.SetWorld(new World());

        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.
        GL.createCapabilities();

        // Set the clear color
        glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

        //OpenGL setup
        glViewport(0,0,1200,700);
        //glMatrixMode(GL_PROJECTION);
        glLoadIdentity(); // Resets any previous projection matrices
        //glFrustum( -1.0, 1.0, -1.0, 1.0, 1.0, 102.0 );
        glMatrixMode(GL_MODELVIEW);
        //glLoadIdentity();
        //glClearColor(0.0f, 0.0f, 0.0f, 1.0f); // Set background color to black and opaque
        //glClearDepth(1.0f);                   // Set background depth to farthest
        //glEnable(GL_DEPTH_TEST);   // Enable depth testing for z-culling
        //glDepthFunc(GL_LEQUAL);    // Set the type of depth-test
        //glShadeModel(GL_SMOOTH);   // Enable smooth shading
        //glHint(GL_PERSPECTIVE_CORRECTION_HINT, GL_NICEST);  // Nice perspective corrections

        //Find start script in game project path and run it
        Main.LoadStartScript();

        //GAME LOOP SETUP

        //Number of frames in a second
        int frames = 0;
        //Reference for equating elapsed time
        long lastTime = System.nanoTime();
        //Set the max number of updates per second
        Performance.maxUps = 60.0;
        //Nanoseconds per update
        double ns = 1000000000 / Performance.maxUps;
        //Time since last update
        double delta = 0;
        //Number of updates in a second
        int updates = 0;
        long timer = System.currentTimeMillis();

        //GAME LOOP
        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                Performance.deltaTime = delta;
                handler.update();
                Physics.GetWorld().update(delta);
                //Count another update
                updates++;
                //Reset delta
                delta--;
            }

            if(glfwWindowShouldClose(Window.getWindow())){
                running = false;
            }

            //Do engine processes
            handler.render();
            handler.processLimbo();

            //Count another frame
            frames++;

            //If it's been a second, reset counters and add a second to the timer
            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                Performance.fps = frames;
                Performance.ups = updates;
                frames = 0;
                updates = 0;
            }
        }
        //If you leave the loop (i.e. running is false) stop the game
        stop();
    }

    public static void main(String[] args){
        //Instantiate Main class
        new Main();
    }

    public static Handler getHandler(){
        return handler;
    }
    private static void LoadStartScript(){
        try {
            Class cls = Class.forName("com.game.GameStart");
            Object instance = cls.newInstance();
            Method method = instance.getClass().getMethod("startGame");
            method.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
