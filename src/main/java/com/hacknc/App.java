package com.hacknc;

import javax.swing.*;

public class App extends JFrame
{
    public static void main( String[] args ) {
        JFrame myFrame = Frame.create();
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myFrame.setTitle("Big Farm Tycoon!");
        myFrame.setResizable(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(200, 200);
        myFrame.setVisible(true);
        MainMenu.create();
        double elapsed_time = 0.0;
        while(true){
            if(MainMenu.create().getStart()) {
                for (int i = 0; i < 10; i++) {
                    System.out.printf(" \n");
                }
                //update game
                //render game
                System.out.println(Long.toString(FPS.getDeltaTime()));

                //recalculate delta time
                FPS.calcDeltaTime();
                elapsed_time += FPS.getDeltaTime();
                System.out.printf("%f\n", elapsed_time);
            }
        }
    }
}
