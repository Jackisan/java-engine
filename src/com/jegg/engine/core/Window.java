package com.jegg.engine.core;

import javax.swing.*;
import java.awt.*;

import static org.lwjgl.glfw.GLFW.*; // allows us to create windows
import static org.lwjgl.opengl.GL11.*; // gives us access to things like "GL_TRUE" which we'll need
import static org.lwjgl.system.MemoryUtil.*; // allows us to use 'NULL' in our code, note this is slightly different from java's 'null'

import org.lwjgl.glfw.GLFWVidMode; // again used for primary monitor stuff.

/**
 * Class for the desktop window
 */
public class Window {

    private static JFrame frame;
    private static long window;
    //Need to initialize this now so that anything initialized before this has reference dimension
    private static Dimension dimension = new Dimension(1200,700);
    private static Vec2d middle;

    Window(){

        if(!glfwInit()){
            // Throw an error.
            System.err.println("GLFW initialization failed!");
        }

        //Configure the default dimension the window will use;
        dimension = new Dimension(1200, 700);

        //Hide it until created
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        //Make the window resizeable
        glfwWindowHint(GLFW_RESIZABLE, GL_TRUE);

        //Make a window
        window = glfwCreateWindow(dimension.width, dimension.height, "Game", NULL, NULL);

        //Print error if window couldn't be made
        if(window == NULL){
            // Throw an Error
            System.err.println("Could not create our Window!");
        }

        // creates a bytebuffer object 'vidmode' which then queries
        // to see what the primary monitor is.
        GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
        // Sets the initial position of our game window.
        glfwSetWindowPos(window, 100, 100);
        // Sets the context of GLFW, this is vital for our program to work.
        glfwMakeContextCurrent(window);
        // finally shows our created window in all it's glory.
        glfwShowWindow(window);

        //SWING
        /*
        //Setup desktop window
        frame = new JFrame("Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setMinimumSize(new Dimension(1200,700));
        frame.setMaximumSize(Toolkit.getDefaultToolkit().getScreenSize());
        frame.setPreferredSize(dimension);
        frame.setResizable(false);

        //Set the preferred size of the gPanel to be the size of the window
        Main.getGPanel().setPreferredSize(dimension);
        frame.add(Main.getGPanel());

        //Make frame appear
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.requestFocus();
        */
    }

    public static JFrame GetFrame(){
        return frame;
    }
    public static long getWindow(){
        return window;
    }
    public static void SetDimension(Dimension dimension){
        dimension.setSize(dimension);
    }
    public static Dimension GetDimension(){
        return dimension;
    }
}
