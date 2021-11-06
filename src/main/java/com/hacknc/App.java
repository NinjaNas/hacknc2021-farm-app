package com.hacknc;

import javax.swing.JFrame;
/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        JFrame myFrame = new JFrame("Game!");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setTitle("Big Farm Tycoon!");
        myFrame.setResizable(false);
        myFrame.setLocationRelativeTo(null);
        myFrame.setSize(500, 500);
        myFrame.setVisible(true);

    }



}
