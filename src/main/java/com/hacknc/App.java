package com.hacknc;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) {

        JFrame myFrame = new JFrame();
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Big Farm Tycoon!");
        myFrame.setResizable(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(200, 200);
        myFrame.setVisible(true);
        boolean runtheGame = true;
        while(runtheGame){
            //update game
            //render game
            System.out.println(Long.toString(FPS.getDeltaTime()));
            //recalculate delta time
            FPS.calcDeltaTime();
        }
    }

}
