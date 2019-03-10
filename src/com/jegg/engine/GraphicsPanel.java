package com.jegg.engine;

import com.jegg.game.GeomTest;

import javax.swing.*;
import java.awt.*;

public class GraphicsPanel extends JPanel {

    public static Graphics2D g2d;

    public Dimension getPreferredSize() {
        return Main.window.getPreferredSize();
    }

    public void paintComponent(Graphics g){
        g2d = (Graphics2D)g;
        g.setColor(Color.black);
        g.fillRect(0,0,1200,700);

        GeomTest.start();
        GeomTest.render(g2d);
    }
}
