package sk.stuba.fei.uim.oop.logic;

import lombok.Getter;
import sk.stuba.fei.uim.oop.elements.Colors;
import sk.stuba.fei.uim.oop.elements.MyLine;
import sk.stuba.fei.uim.oop.elements.Turtle;
import sk.stuba.fei.uim.oop.gui.MyCanvas;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class EventHandler extends UniversalAdapter {
    @Getter
    private final JLabel stepAndAngle;
    @Getter
    private final JLabel colorLabel;
    private final MyCanvas canvas;
    private int step;
    private int angle;
    public static final int DEFAULT_STEP = 10;
    public static final int DEFAULT_ANGLE = 45;
    public static final String ACTION_CMD = "Action";
    public static final String COLOR_CMD = "Color";

    public EventHandler(MyCanvas canvas) {
        this.stepAndAngle = new JLabel(DEFAULT_STEP + "; " + DEFAULT_ANGLE + "°", JLabel.CENTER);
        this.stepAndAngle.setFocusable(false);

        this.colorLabel = new JLabel();
        this.colorLabel.setOpaque(true);
        this.colorLabel.setBackground(Colors.FIRST.getColor());
        this.colorLabel.setFocusable(false);

        this.canvas = canvas;
        this.step = DEFAULT_STEP;
        this.angle = DEFAULT_ANGLE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.actionPerformed(e);
        if (this.commandIs(e, EventHandler.ACTION_CMD)) {
            Turtle turtle = this.canvas.getTurtle();
            int x0 = turtle.getX();
            int y0 = turtle.getY();
            turtle.rotate(this.angle);
            turtle.move(this.step);
            this.canvas.addLine(new MyLine(x0, y0, turtle.getX(), turtle.getY(), this.canvas.getColor()));
        }
        if (this.commandIs(e, EventHandler.COLOR_CMD)) {
            this.colorLabel.setBackground(this.canvas.nextColor());
        }
        this.canvas.repaint();
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        super.itemStateChanged(e);
        if (Objects.equals(e.getStateChange(), ItemEvent.SELECTED)) {
            this.angle = (Integer) e.getItem();
            this.stepAndAngle.setText(this.step + "; " + this.angle + "°");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        Turtle turtle = this.canvas.getTurtle();
        int x0 = turtle.getX();
        int y0 = turtle.getY();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                turtle.move(this.step);
                this.canvas.addLine(new MyLine(x0, y0, turtle.getX(), turtle.getY(), this.canvas.getColor()));
                break;
            case KeyEvent.VK_DOWN:
                turtle.move(-this.step);
                this.canvas.addLine(new MyLine(x0, y0, turtle.getX(), turtle.getY(), this.canvas.getColor()));
                break;
            case KeyEvent.VK_LEFT:
                turtle.rotate(-this.angle);
                break;
            case KeyEvent.VK_RIGHT:
                turtle.rotate(this.angle);
                break;
            default:
                return;
        }
        this.canvas.repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        super.stateChanged(e);
        if (e.getSource() instanceof JSlider) {
            JSlider slider = (JSlider) e.getSource();
            if (!slider.getValueIsAdjusting()) {
                this.step = slider.getValue();
                this.stepAndAngle.setText(this.step + "; " + this.angle + "°");
            }
        }
    }

    private boolean commandIs(ActionEvent e, String command) {
        return Objects.equals(e.getActionCommand(), command);
    }
}
