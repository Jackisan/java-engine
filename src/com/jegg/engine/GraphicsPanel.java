package com.jegg.engine;

import javax.swing.*;
import java.awt.*;

/**
 * The JPanel that gets added to the desktop window to add graphics into the game.
 * All graphics are rendered on a GraphicsPanel
 */
public class GraphicsPanel extends JPanel {

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g.setColor(Color.black);
        g.fillRect(0,0,Window.GetDimension().width, Window.GetDimension().height);
        g.setColor(Color.green);
        g.drawString("FPS: " + Performance.fps, 10,10);
        //Camera.getMain().translate2dPositive(g2d);
        Main.getHandler().render();
        //Camera.getMain().translate2dNegative(g2d);
    }
}