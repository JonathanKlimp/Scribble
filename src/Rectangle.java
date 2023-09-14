import java.awt.*;

public class Rectangle extends Figure{

    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public void draw(Graphics g, Color color) {
        g.setColor(color);
        if (x1 > x2) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }
        if (y1 > y2) {
            int temp = y1;
            y1 = y2;
            y2 = temp;
        }
        if (fill) {
            g.fillRect(x1, y1, x2-x1, y2-y1);
        } else {
            g.drawRect(x1, y1, x2-x1, y2-y1);
        }
    }
}
