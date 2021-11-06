package com.hacknc;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class GamePanelImpl implements GamePanel{
    private JPanel gamePanel;
    private FarmMap farmMap;
    private MenuBar menuBar;

    public GamePanelImpl(int n, int m, int tileSize)
    {
        farmMap = new FarmMapImpl(n, m, tileSize);
        menuBar = new MenuBarImpl();
        gamePanel = new JPanel();
        gamePanel.setLayout(new BoxLayout(gamePanel, BoxLayout.Y_AXIS));
        gamePanel.add(farmMap.getMap());
        gamePanel.add(menuBar.getMenuBar());
    }
    @Override
    public JPanel getGamePanel() {
        // TODO Auto-generated method stub
        return gamePanel;
    }
    
}
