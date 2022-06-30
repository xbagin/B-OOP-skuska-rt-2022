package sk.stuba.fei.uim.oop.logic;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public abstract class UniversalAdapter implements ActionListener, ItemListener, ChangeListener, KeyListener {
    @Override
    public void actionPerformed(ActionEvent e) { }

    @Override
    public void itemStateChanged(ItemEvent e) { }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void stateChanged(ChangeEvent e) { }
}
