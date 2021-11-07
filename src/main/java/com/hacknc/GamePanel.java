package com.hacknc;


import java.io.IOException;

import javax.swing.*;

public interface GamePanel {
    //Returns the game view of the panel
    public JPanel getGamePanel();
    //Updates gamestate
    public void update(double deltaTime) throws IOException;
}
