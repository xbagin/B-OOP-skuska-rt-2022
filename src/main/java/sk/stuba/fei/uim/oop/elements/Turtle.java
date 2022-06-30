package sk.stuba.fei.uim.oop.elements;

import lombok.Getter;

import java.awt.*;

public class Turtle implements Drawable {
    @Getter
    private int x;
    @Getter
    private int y;
    private int angle;
    private static final int SHELL_RADIUS = 20;
    private static final int HEAD_RADIUS = 10;
    private static final Color SHELL_COLOR = Color.BLACK;
    private static final Color HEAD_COLOR = Color.PINK;

    public Turtle(int x, int y) {
        this.x = x;
        this.y = y;
        this.angle = 0;
    }

    @Override
    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(Turtle.SHELL_COLOR);
        g.fillOval(
                this.x - Turtle.SHELL_RADIUS,
                this.y - Turtle.SHELL_RADIUS,
                2 * Turtle.SHELL_RADIUS,
                2 * Turtle.SHELL_RADIUS
        );
        g.setColor(Turtle.HEAD_COLOR);
        g.fillOval(
                this.x - Turtle.HEAD_RADIUS - (int) (Turtle.SHELL_RADIUS * Math.sin(this.angle * Math.PI / 180)),
                this.y - Turtle.HEAD_RADIUS - (int) (Turtle.SHELL_RADIUS * Math.cos(this.angle * Math.PI / 180)),
                2 * Turtle.HEAD_RADIUS,
                2 * Turtle.HEAD_RADIUS
        );
        g.setColor(c);
    }

    public void rotate(int angle) {
        this.angle -= angle;
    }

    public void move(int distance) {
        this.x -= distance * Math.sin(this.angle * Math.PI / 180);
        this.y -= distance * Math.cos(this.angle * Math.PI / 180);
    }
}
