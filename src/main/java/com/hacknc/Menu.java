package com.hacknc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener{

    public void FirstWindow(){


        JPanel menu_ = new JPanel();
        JButton button = new JButton("Start game button");
        menu_.add(button);
        button.addActionListener(this);
        button.setActionCommand("");
        Jframe.create().getFrame().add(button);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean runtheGame = true;

    }
}
