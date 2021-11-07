package com.hacknc;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class WindowManager {
    private CardLayout cl;
    private JPanel windowManager;
    private GamePanel gamePanel;
    private MainMenu mainMenu;
    private OptionsMenu optionMenu;
    public static boolean running;

    public WindowManager(int n,int m)
    {
        cl = new CardLayout();
        windowManager = new JPanel();
        windowManager.setLayout(cl);
        gamePanel = new GamePanelImpl(n,m,cl,windowManager);
        mainMenu = new MainMenu(cl, windowManager);
        optionMenu = new OptionsMenu(cl, windowManager);
        running = false;
        windowManager.add(mainMenu.getMainMenu());
        windowManager.add(gamePanel.getGamePanel());
        windowManager.add(optionMenu.getOptionsMenu());
    }

    public JPanel getWindow()
    {
        return windowManager;
    }

    public void update(double deltaTime) throws IOException
    {
        gamePanel.update(deltaTime);
    }
}
