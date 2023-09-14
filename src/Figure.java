import java.awt.*;

public abstract class Figure {
    int x1, y1, x2, y2;
    public Color color;
    public boolean fill;
    String title = "";

    public Figure(Color color) {
        this.color = color;
    }

    public abstract void draw(Graphics g, Color c);
}
