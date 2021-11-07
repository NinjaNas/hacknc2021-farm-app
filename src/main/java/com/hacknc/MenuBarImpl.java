package com.hacknc;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JButton;


public class MenuBarImpl implements MenuBar, ActionListener{

    JPanel menuBar;
    JButton till;
    JButton moneyButton;
    JButton exit;
    MenuButton[] menuButtons;
    public static boolean tillEnabled;
    public static int money = 1000;

    public MenuBarImpl() {
        menuBar = new JPanel();
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));
        menuButtons = new MenuButton[Seed.Type.values().length];
        int i = 0;
        for (Seed.Type enumType : Seed.Type.values()) {
            MenuButton newMenuButton = new MenuButtonImpl(enumType.toString(), enumType);
            menuBar.add(newMenuButton.getButton());
            menuBar.add(Box.createRigidArea(new Dimension(10,0)));
            menuButtons[i] = newMenuButton;
            i++;
        }
        //Add Till Button
        till = new JButton("Till_Inactive");
        till.addActionListener(this);
        till.setActionCommand("Set_Till");
        menuBar.add(till);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));
        moneyButton = new JButton("Coins :" + Integer.toString(money));
        moneyButton.setEnabled(false);
        menuBar.add(moneyButton);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));
        exit = new JButton("Exit Game");
        exit.setActionCommand("Quit");
        exit.addActionListener(this);
        menuBar.add(exit);
        menuBar.setBackground(new Color(51, 51, 51));
    }


    @Override
    public JPanel getMenuBar() {
        // TODO Auto-generated method stub
        return menuBar;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if("Set_Till".equals(e.getActionCommand()))
        {
            if(tillEnabled)
            {
                tillEnabled = false;
                till.setText("Till_Inactive");
            }else
            {
                tillEnabled = true;
                till.setText("Till_Active");
            }
        }else if("Quit".equals(e.getActionCommand()))
        {
            System.exit(0);
        }
    }


    @Override
    public void update() {
        // TODO Auto-generated method stub
        moneyButton.setText("Coins :" + Integer.toString(money));
    }
    
}
