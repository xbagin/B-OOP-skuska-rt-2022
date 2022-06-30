package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.logic.EventHandler;

import javax.swing.*;
import java.awt.*;

public class Imagine extends JFrame {
    public Imagine() throws HeadlessException {
        super("OOP-SK-22-RT");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLayout(new BorderLayout());
        this.setFocusable(true);

        MyCanvas canvas = new MyCanvas();

        EventHandler handler = new EventHandler(canvas);
        this.addKeyListener(handler);

        JPanel bottomMenu = new JPanel(new GridLayout(2, 3));

        MyJComboBox<Integer> angles = new MyJComboBox<>(new Integer[]{0, 5, 10, 45, 90, 180}, EventHandler.DEFAULT_ANGLE, handler);

        MyJSlider step = new MyJSlider(0, 100, 10, EventHandler.DEFAULT_STEP, handler);

        MyJButton actionButton = new MyJButton(EventHandler.ACTION_CMD, handler);

        MyJButton colorButton = new MyJButton(EventHandler.COLOR_CMD, handler);

        bottomMenu.add(angles);
        bottomMenu.add(step);
        bottomMenu.add(actionButton);
        bottomMenu.add(handler.getStepAndAngle());
        bottomMenu.add(colorButton);
        bottomMenu.add(handler.getColorLabel());

        this.add(canvas, BorderLayout.CENTER);
        this.add(bottomMenu, BorderLayout.PAGE_END);

        this.setVisible(true);
    }
}
