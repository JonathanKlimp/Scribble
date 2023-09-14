import java.awt.*;

public class Triangle extends Figure {

    public Triangle(Color color) {
        super(color);
    }

    @Override
    public void draw(Graphics g, Color color) {
        g.setColor(color);
        if (fill) {
            g.fillPolygon(new int[] {x1, (x1 + x2) / 2, x2}, new int[] {y2,y1, y2}, 3);
        } else {
            g.drawPolygon(new int[] {x1, (x1 + x2) / 2, x2}, new int[] {y2,y1, y2}, 3);
        }
    }
}