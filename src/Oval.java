import java.awt.*;

public class Oval extends Figure {


    @Override
    public void draw(Graphics g) {
        g.drawOval(x1, y1, x2 - x1, y2 - y1);
    }
}
