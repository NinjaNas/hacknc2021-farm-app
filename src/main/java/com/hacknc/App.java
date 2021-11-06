package com.hacknc;

import javax.swing.JFrame;
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
        myFrame.setSize(600, 600);
        GamePanel gameView = new GamePanelImpl(9, 16, 200);
        myFrame.add(gameView.getGamePanel());
        myFrame.setVisible(true);
        boolean runtheGame = true;
        while(runtheGame){
            //update game
            //render game
            //System.out.println(Long.toString(FPS.getDeltaTime()));
            //recalculate delta time
            FPS.calcDeltaTime();
        }
    }

}
