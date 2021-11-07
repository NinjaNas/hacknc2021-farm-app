package com.hacknc;


import java.io.IOException;
import java.awt.Color;
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
        myFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        myFrame.setUndecorated(true);
        myFrame.setVisible(true);
        FPS.setStart((System.nanoTime() * 0.000000001));
        while (true) {
            double deltaTime = FPS.newFrame(System.nanoTime() * 0.000000001);
            gameView.update(deltaTime);
        }
    }
}
