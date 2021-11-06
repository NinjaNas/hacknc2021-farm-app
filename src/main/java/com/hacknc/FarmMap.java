package com.hacknc;

import javax.swing.JPanel;

public interface FarmMap {
    //Updates the farmMap based on deltaTime
    public void update(long deltaTime);
    //Returns the panel that is the map.
    public JPanel getMap();
}
