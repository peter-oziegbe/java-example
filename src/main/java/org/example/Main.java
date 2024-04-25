package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    Object object;
    JLabel jLabel = new JLabel();
    JButton jButton = new JButton();

    Main(){
        setLayout(new BorderLayout());
        setSize(400, 400);
        add(jLabel, BorderLayout.SOUTH);
        add(jButton);
        jButton.addActionListener(new InnerClass(jLabel));
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}


class InnerClass implements ActionListener {

    private JLabel jLabel;

    public InnerClass(JLabel jLabel){
        this.jLabel = jLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        jLabel.setText("Button Clicked");
    }
}