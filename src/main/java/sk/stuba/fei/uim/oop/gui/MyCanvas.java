package sk.stuba.fei.uim.oop.gui;

import lombok.Getter;
import sk.stuba.fei.uim.oop.elements.Colors;
import sk.stuba.fei.uim.oop.elements.MyLine;
import sk.stuba.fei.uim.oop.elements.Turtle;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyCanvas extends JPanel {
    private final List<MyLine> lines;
    @Getter
    private final Turtle turtle;
    private Colors rotatingColor;

    public MyCanvas() {
        super();
        this.lines = new ArrayList<>();
        this.turtle = new Turtle(350, 300);
        this.rotatingColor = Colors.FIRST;
        this.setBackground(Color.LIGHT_GRAY.brighter());
    }

    public void addLine(MyLine line) {
        this.lines.add(line);
    }

    public Color getColor() {
        return this.rotatingColor.getColor();
    }

    public Color nextColor() {
        this.rotatingColor = this.rotatingColor.next();
        return this.rotatingColor.getColor();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.lines.forEach(line -> line.draw(g));
        this.turtle.draw(g);
    }
}
