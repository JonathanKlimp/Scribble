import java.awt.*;

public class Triangle extends Figure {


    @Override
    public void draw(Graphics g) {
        g.drawPolygon(new int[] {x1, (x1 + x2) / 2, x2}, new int[] {y2,y1, y2}, 3);
    }
}