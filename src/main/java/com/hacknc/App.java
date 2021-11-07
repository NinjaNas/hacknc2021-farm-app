package com.hacknc;

import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;

public class App extends JFrame {
    public static int preferedWidth;
    public static int preferedHeight;

    public static void main(String[] args) throws IOException {
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        preferedHeight = height/9;
        preferedWidth = width/16;
        JFrame myFrame = Frame.create();
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myFrame.setTitle("Big Farm Tycoon!");
        myFrame.setResizable(true);
        myFrame.setSize(600, 600);
        //GamePanel gameView = new GamePanelImpl(9, 16);
        WindowManager manager = new WindowManager(9,16);
        myFrame.add(manager.getWindow());
        myFrame.setBackground(new Color(102, 51, 0));
//        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        myFrame.setUndecorated(true);
        myFrame.setVisible(true);
        FPS.setStart((System.nanoTime() * 0.000000001));
        ImageIO.setUseCache(false);
        Soil.init(preferedWidth,preferedHeight);
        SeedImpl.init(preferedWidth,preferedHeight);
        int frames = 0;
        double time_elapsed = 0;
        while (true) {
            double deltaTime = FPS.newFrame(System.nanoTime() * 0.000000001);
            avgFPS = (avgFPS + 1/deltaTime)/2;
            System.out.println(avgFPS);
            if(WindowManager.running)
            {
                manager.update(deltaTime);
            }
        }
    }
}
