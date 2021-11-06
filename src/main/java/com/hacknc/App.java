package com.hacknc;

import javax.swing.JFrame;
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
        myFrame.setResizable(false);
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(500, 500);
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
