package com.hacknc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Soil{
    private final static BufferedImage[] _img = new BufferedImage[4];

    public static void init() throws IOException {
        _img[0] = ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland_moist.png"));
        _img[1] = ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png"));
        _img[2] = ImageIO.read(new File("src/main/java/com/hacknc/images/ground/grass.png"));
        _img[3] = ImageIO.read(new File("src/main/java/com/hacknc/images/ground/dirt.png"));
    }

    public static BufferedImage getSoilIcon(boolean isTilled, double fertVal) {
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
