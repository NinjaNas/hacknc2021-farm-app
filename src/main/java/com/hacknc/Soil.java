package com.hacknc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Soil{

    public static BufferedImage getSoilIcon(boolean isTilled, double fertVal) throws IOException {
        // TODO Auto-generated method stub
        if(isTilled)
        {
            if(fertVal > 50)
            {
                return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland_moist.png"));
            }else
            {
                return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/farmland.png"));
            }
            
        }else
        {
            if(fertVal > 50)
            {
                return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/grass.png"));
            }else
            {
                return ImageIO.read(new File("src/main/java/com/hacknc/images/ground/dirt.png"));
            }
        }
    }
    
}
