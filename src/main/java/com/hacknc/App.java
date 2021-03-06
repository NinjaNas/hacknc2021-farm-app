package com.hacknc;


import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;

public class App extends JFrame {
    public static void main(String[] args) throws IOException {
        JFrame myFrame = Frame.create();
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myFrame.setTitle("Big Farm Tycoon!");
        myFrame.setResizable(true);
        myFrame.setSize(600, 600);
        GamePanel gameView = new GamePanelImpl(9, 16);
        myFrame.add(gameView.getGamePanel());
        myFrame.setBackground(new Color(102, 51, 0));
//        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        myFrame.setUndecorated(true);
        myFrame.setVisible(true);
        FPS.setStart((System.nanoTime() * 0.000000001));
        ImageIO.setUseCache(false);
        Soil.init();
        SeedImpl.init();
        int frames = 0;
        double time_elapsed = 0;
        while (true) {
            double deltaTime = FPS.newFrame(System.nanoTime() * 0.000000001);
            time_elapsed += deltaTime;
            frames += 1;
            System.out.println(frames / time_elapsed);
            gameView.update(deltaTime);
        }
    }
}
