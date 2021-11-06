package com.hacknc;

import javax.swing.*;

    public class Jframe {

        private JFrame a;
        private static Jframe e;

        public Jframe(JFrame a){
            this.a = a;
        }

    public JFrame getFrame(){
            return this.a;
    }
    public static Jframe create(){
        if (e == null){
            e = new Jframe(new JFrame());
        }
        return e;
    }

}
