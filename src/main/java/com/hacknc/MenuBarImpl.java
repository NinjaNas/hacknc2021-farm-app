package com.hacknc;

import javax.swing.BoxLayout;
import javax.swing.JPanel;


public class MenuBarImpl implements MenuBar {

    JPanel menuBar;
    MenuButton[] menuButtons;

    public MenuBarImpl() {
        menuBar = new JPanel();
        menuBar.setLayout(new BoxLayout(menuBar, BoxLayout.X_AXIS));
        menuButtons = new MenuButton[Seed.Type.values().length];
        int i = 0;
        for (Seed.Type enumType : Seed.Type.values()) {
            System.out.println(enumType.toString());
            MenuButton newMenuButton = new MenuButtonImpl(enumType.toString(), enumType);
            menuBar.add(newMenuButton.getButton());
            menuButtons[i] = newMenuButton;
            i++;
        }
    }


    @Override
    public JPanel getMenuBar() {
        // TODO Auto-generated method stub
        return menuBar;
    }

}
