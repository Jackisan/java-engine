package com.jegg.engine.core;

import com.jegg.engine.input.Input;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.opengl.GL11.*;

public class Handler {

    private ArrayList<Object> objects = new ArrayList<>();
    private ArrayList<Object> limbo = new ArrayList<>();

    Handler(){

    }

    void update(){

        glfwPollEvents();

        for(Object obj : objects){
            if(obj instanceof Script && ((Script)obj).getActive()){
                ((Script)obj).update();
            }
            else if(obj instanceof Standalone){
                ((Standalone)obj).loopExecute();
            }
            else{
                limbo.add(obj);
            }
        }
        Input.update();
    }

    void render(){

        //if 3d
        glClearDepth( 1.0 );
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer
        GL11.glLoadIdentity();
        //if 2d
        //glClear(GL_COLOR_BUFFER_BIT);

        GL11.glTranslatef(0f,0.0f,-7f);
        GL11.glRotatef(45f,0.0f,1.0f,0.0f);
        GL11.glColor3f(0.5f,0.5f,1.0f);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glColor3f(1.0f,1.0f,0.0f);
        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
        GL11.glColor3f(1.0f,0.5f,0.0f);
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
        GL11.glColor3f(1.0f,0.0f,0.0f);
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
        GL11.glColor3f(1.0f,1.0f,0.0f);
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
        GL11.glColor3f(0.0f,0.0f,1.0f);
        GL11.glVertex3f(-1.0f, 1.0f, 1.0f);
        GL11.glVertex3f(-1.0f, 1.0f,-1.0f);
        GL11.glVertex3f(-1.0f,-1.0f,-1.0f);
        GL11.glVertex3f(-1.0f,-1.0f, 1.0f);
        GL11.glColor3f(1.0f,0.0f,1.0f);
        GL11.glVertex3f( 1.0f, 1.0f,-1.0f);
        GL11.glVertex3f( 1.0f, 1.0f, 1.0f);
        GL11.glVertex3f( 1.0f,-1.0f, 1.0f);
        GL11.glVertex3f( 1.0f,-1.0f,-1.0f);
        GL11.glEnd();

        for(Object obj : objects){
            if(obj instanceof Script && !((Script)obj).destroyed){
                ((Script)obj).render();
            }
            else if(obj instanceof Standalone && !((Standalone)obj).destroyed){
                ((Standalone)obj).render();
            }
        }
        glfwSwapBuffers(Window.getWindow());
    }

    void addScript(Script s){
        limbo.add(s);
    }

    void removeScript(Script s){
        limbo.add(s);
        s.destroyed = true;
    }

    void addStandalone(Standalone s){
        limbo.add(s);
    }

    void removeStandalone(Standalone s){
        limbo.add(s);
        s.destroyed = true;
    }

    void processLimbo(){
        for(Object obj : limbo){

            if(obj instanceof Script){
                if(((Script) obj).destroyed){
                    objects.remove(obj);
                }
                else{
                    objects.add(obj);
                }
            }
            else if(obj instanceof Standalone){
                if(((Standalone)obj).destroyed){
                    objects.remove(obj);
                }
                else{
                    objects.add(obj);
                }
            }
            //if its something else
            else{
                objects.remove(obj);
            }
        }
        limbo.clear();
    }

}