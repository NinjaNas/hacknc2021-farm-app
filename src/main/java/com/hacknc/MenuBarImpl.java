package com.hacknc;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.JButton;
import java.awt.CardLayout;

public class MenuBarImpl implements MenuBar, ActionListener{

    JPanel menuBar;
    JButton fert;
    JButton till;
    JButton moneyButton;
    JButton menu;
    MenuButton[] menuButtons;
    public static boolean tillEnabled = false;
    public static int money = 1000;
    public static boolean fertEnabled = false;
    public static double fertIncrease = 20;
    public static int fertCost = 10;
    private CardLayout cl;
    private JPanel card;

    public MenuBarImpl(CardLayout _cl, JPanel _card) {
        cl = _cl;
        card = _card;
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
        till = new JButton("Till");
        till.addActionListener(this);
        till.setActionCommand("Set_Till");
        menuBar.add(till);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));
        fert = new JButton("Fertilizer");
        fert.addActionListener(this);
        fert.setActionCommand("Set_Fert");
        menuBar.add(fert);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));
        moneyButton = new JButton("Coins :" + Integer.toString(money));
        moneyButton.setEnabled(false);
        menuBar.add(moneyButton);
        menuBar.add(Box.createRigidArea(new Dimension(10,0)));
        menu = new JButton("Menu");
        menu.setActionCommand("Menu");
        menu.addActionListener(this);
        menuBar.add(menu);
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
                fertEnabled = false;
                till.setBackground(UIManager.getColor("control"));
                fert.setBackground(UIManager.getColor("control"));
            }else
            {
                tillEnabled = true;
                fertEnabled = false;
                till.setBackground(new Color(0,204,0));
                fert.setBackground(UIManager.getColor("control"));
            }
        }else if("Menu".equals(e.getActionCommand()))
        {
            WindowManager.running = false;
            cl.next(card);
        }else if("Set_Fert".equals(e.getActionCommand()))
        {
            if(fertEnabled)
            {
                fertEnabled = false;
                tillEnabled = false;
                till.setBackground(UIManager.getColor("control"));
                fert.setBackground(UIManager.getColor("control"));
            }else
            {
                fertEnabled = true;
                tillEnabled = false;
                till.setBackground(UIManager.getColor("control"));
                fert.setBackground(new Color(0,204,0));
            }
        }
    }


    @Override
    public void update() {
        // TODO Auto-generated method stub
        moneyButton.setText("Coins :" + Integer.toString(money));
    }
    
}
