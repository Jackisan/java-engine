package com.jegg.engine.scriptcomponents;

import com.jegg.engine.core.Script;

import javax.swing.*;
import java.awt.*;

public class Sprite extends Script {

    private Image image;

    /**
     * @param imagePath Example path is "resources/images/logo.png"
     */
    public void setImage(String imagePath){
        image = new ImageIcon(getClass().getClassLoader().getResource(imagePath)).getImage();
    }

    public void render(Graphics2D g2d){
        g2d.drawImage(image, (int)getGameObject().getPosition().x, (int)getGameObject().getPosition().y, null);
    }
}
