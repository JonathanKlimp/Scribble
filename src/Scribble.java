import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Scribble extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    static JMenuBar mb;

    static JMenu x;
    static JMenuItem m1, m2, m3, m4;
    int lastClickedX;
    int lastCLickedY;
    Figure figure;
    Color color;
    Shapes shape = Shapes.RECTANGLE;
    List<Figure> figures = new ArrayList<>();

    public Scribble() throws HeadlessException {
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Figure f : figures){
            g.setColor(color);
            f.draw(g);
        }
    }

    public static void main(String[] args) {
        // write your code here
        Scribble scribble = new Scribble();

        scribble.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton button = new JButton("color");
        button.setPreferredSize(new Dimension(30, 30));
        button.addActionListener(scribble);

        mb = new JMenuBar();
        x = new JMenu("Menu");
        m1 = new JMenuItem("Line");
        m2 = new JMenuItem("Rectangle");
        m3 = new JMenuItem("Triangle");
        m4 = new JMenuItem("Oval");
        m1.addActionListener(scribble);
        m2.addActionListener(scribble);
        m3.addActionListener(scribble);
        m4.addActionListener(scribble);

        x.add(m1);
        x.add(m2);
        x.add(m3);
        x.add(m4);

        mb.add(x);
        scribble.setJMenuBar(mb);
        scribble.add(button, BorderLayout.NORTH);
        scribble.setSize(400, 400);
        scribble.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (shape) {
            case RECTANGLE -> figure = new Rectangle();
            case LINE -> figure = new Line();
            case OVAL -> figure = new Oval();
            case TRIANGLE -> figure = new Triangle();
        }
        if (figure == null) {
            return;
        }
        figure.x1 = e.getX();
        figure.y1 = e.getY();
        lastClickedX = e.getX();
        lastCLickedY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (figure == null) {
            return;
        }
        figures.add(figure);
        figure.x2 = e.getX();
        figure.y2 = e.getY();
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        figure.x2 = e.getX();
        figure.y2 = e.getY();
//        figure.x1 = lastClickedX;
//        figure.x2 = lastCLickedY;
        figures.add(figure);
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Oval")) {
            shape = Shapes.OVAL;
        }
        if (s.equals("Rectangle")) {
            shape = Shapes.RECTANGLE;
        }
        if (s.equals("Triangle")) {
            shape = Shapes.TRIANGLE;
        }
        if (s.equals("Line")) {
            shape = Shapes.LINE;
        }
        if (s.equals("color")) {
            Color initialcolor = Color.RED;
            color = JColorChooser.showDialog(this,
                    "Select a color", initialcolor);

        }
    }
}