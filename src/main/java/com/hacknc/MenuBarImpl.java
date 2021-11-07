package com.hacknc;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.JButton;


public class MenuBarImpl implements MenuBar, ActionListener{

    JPanel menuBar;
    JButton till;
    MenuButton[] menuButtons;
    public static boolean tillEnabled;

    public MenuBarImpl() {
        menuBar = new JPanel();
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));
        menuButtons = new MenuButton[Seed.Type.values().length];
        int i = 0;
        for (Seed.Type enumType : Seed.Type.values()) {
            MenuButton newMenuButton = new MenuButtonImpl(enumType.toString(), enumType);
            menuBar.add(newMenuButton.getButton());
            menuButtons[i] = newMenuButton;
            i++;
        }
        //Add Till Button
        till = new JButton("Till_Inactive");
        till.addActionListener(this);
        till.setActionCommand("Set_Till");
        menuBar.add(till);
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
        }
    }

}
