package com.hacknc;

import javax.swing.JPanel;
import java.io.IOException;

public interface FarmMap {
    //Updates the farmMap based on deltaTime
    public void update(double deltaTime) throws IOException;

    //Returns the panel that is the map.
    public JPanel getMap();
}
