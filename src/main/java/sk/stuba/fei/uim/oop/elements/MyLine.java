package sk.stuba.fei.uim.oop.elements;

import lombok.AllArgsConstructor;

import java.awt.*;

@AllArgsConstructor
public class MyLine implements Drawable {
    private final int x1;
    private final int y1;
    private final int x2;
    private final int y2;
    private final Color color;

    @Override
    public void draw(Graphics g) {
        Color c = g.getColor();
        g.setColor(this.color);
        g.drawLine(this.x1, this.y1, this.x2, this.y2);
        g.setColor(c);
    }
}
