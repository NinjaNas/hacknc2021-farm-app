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

        Jframe init = new Jframe(new JFrame());
        JFrame myFrame = Jframe.create().getFrame();

        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Big Farm Tycoon!");
        myFrame.setResizable(true);
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(200, 200);
        myFrame.setVisible(true);
        boolean runtheGame = true;
        double elapsed_time = 0.0;

        while(runtheGame){
            for(int i = 0; i < 10; i++){
                System.out.printf(" \n");
            }
            //update game
            //render game
            System.out.printf("%f\n", FPS.getDeltaTime());

            //recalculate delta time
            FPS.calcDeltaTime();
            elapsed_time += FPS.getDeltaTime();
            System.out.printf("%f\n", elapsed_time);
        }
    }


    public static JFrame create(){
        JFrame t = new JFrame();
        return t;
    }

}
