package sk.stuba.fei.uim.oop.gui;

import javax.swing.*;
import javax.swing.event.ChangeListener;

public class MyJSlider extends JSlider {
    public MyJSlider(int min, int max, int step, int value, ChangeListener listener) {
        super(JSlider.HORIZONTAL, min, max, value);
        this.addChangeListener(listener);
        this.setPaintLabels(true);
        this.setMajorTickSpacing(step);
        this.setMinorTickSpacing(step);
        this.setSnapToTicks(true);
        this.setFocusable(false);
    }
}
