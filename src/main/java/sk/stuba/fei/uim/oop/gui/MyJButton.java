package sk.stuba.fei.uim.oop.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MyJButton extends JButton {
    public MyJButton(String text, ActionListener listener) {
        super(text);
        this.addActionListener(listener);
        this.setFocusable(false);
    }
}
