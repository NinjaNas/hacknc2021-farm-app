package com.hacknc;



import javax.swing.*;

public class GamePanel extends JPanel {
    JFrame menu_ = new JFrame("Main MainMenu");


public interface GamePanel {
    //Returns the game view of the panel
    public JPanel getGamePanel();
}
