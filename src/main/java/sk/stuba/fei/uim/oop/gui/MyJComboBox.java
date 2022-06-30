package sk.stuba.fei.uim.oop.gui;

import javax.swing.*;
import java.awt.event.ItemListener;
import java.util.List;

public class MyJComboBox<E> extends JComboBox<E> {
    public MyJComboBox(E[] values, E startValue, ItemListener listener) {
        super(values);
        this.addItemListener(listener);
        if (List.of(values).contains(startValue)) {
            this.setSelectedItem(startValue);
        }
        this.setFocusable(false);
    }
}
