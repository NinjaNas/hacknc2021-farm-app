package com.hacknc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Soil{
    private final static ImageIcon[] _img = new ImageIcon[4];

    public static void init() throws IOException {
        _img[0] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland_moist.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[1] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[2] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/ground/grass.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
        _img[3] = new ImageIcon(ImageIO.read(new File("src/main/java/com/hacknc/images/ground/dirt.png")).getScaledInstance(App.preferedWidth, App.preferedHeight, Image.SCALE_SMOOTH));
    }

    public static ImageIcon getSoilIcon(boolean isTilled, double fertVal) {
        // TODO Auto-generated method stub
        if(isTilled)
        {
            if(fertVal > 50)
            {
                return _img[0];
            }else
            {
                return _img[1];
            }
            
        }else
        {
            if(fertVal > 50)
            {
                return _img[2];
            }else
            {
                return _img[3];
            }
        }
    }
    
}
