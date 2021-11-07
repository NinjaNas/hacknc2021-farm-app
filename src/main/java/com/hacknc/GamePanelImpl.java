package com.hacknc;

import java.awt.Color;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GamePanelImpl implements GamePanel {
    private JPanel gamePanel;
    private FarmMap farmMap;
    private MenuBar menuBar;

    public GamePanelImpl(int n, int m) {
        farmMap = new FarmMapImpl(n, m);
        menuBar = new MenuBarImpl();
        gamePanel = new JPanel();
        gamePanel.setBackground(new Color(102, 102, 102));
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        gamePanel.add(farmMap.getMap());
        gamePanel.add(menuBar.getMenuBar());
    }

    @Override
    public JPanel getGamePanel() {
        // TODO Auto-generated method stub
        return gamePanel;
    }

    @Override
    public void update(double deltaTime) throws IOException {
        // TODO Auto-generated method stub
        farmMap.update(deltaTime);
        menuBar.update();
    }

}
