package com.jegg.engine;

import com.jegg.game.GeomTest;

import javax.swing.*;
import java.awt.*;

public class Main implements Runnable {

    public static JFrame window;
    public static GraphicsPanel gPanel;
    private Thread thread;
    public Input input;

    public Main(){
        startThread();
    }

    synchronized void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    public void run(){

        //Instantiate input, add listeners to the window
        input = new Input();
        gPanel.addKeyListener(input);
        gPanel.addMouseListener(input);
        gPanel.addMouseMotionListener(input);
        gPanel.addMouseWheelListener(input);

        //Loop unless interruption on thread
        while (!Thread.currentThread().isInterrupted()) {
            try {
                GeomTest.update();
                gPanel.repaint();

                //Update input last
                input.update();

                //Update some stuff last
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args){

        //Setup desktop window
        window = new JFrame("Game");

        //Instantiate renderer to draw
        gPanel = new GraphicsPanel();
        window.add(gPanel);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setMinimumSize(new Dimension(1200,700));
        window.setMaximumSize(new Dimension(1200,700));
        window.setPreferredSize(new Dimension(1200, 700));
        window.setResizable(false);
        window.setVisible(true);
        window.requestFocus();

        //Instantiate Main class
        new Main();
    }
}
