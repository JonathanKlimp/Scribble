import java.awt.*;

public class Line extends Figure {

    public Line(Color color) {
        super(color);
    }

    @Override
    public void draw(Graphics g, Color color) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
    }
}
