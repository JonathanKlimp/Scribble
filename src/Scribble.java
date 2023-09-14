import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Scribble extends JFrame implements MouseListener, MouseMotionListener, ActionListener {

    static JMenuBar mb;

    static JMenu x;
    static JMenuItem m1, m2, m3, m4, m5, m6;
    static JCheckBox checkBox;
    static JCheckBox checkBoxText;
    int firstClickedX;
    int firstCLickedY;
    boolean fill = false;
    boolean text = false;
    Figure figure;
    Color color;
    Shapes shape = Shapes.RECTANGLE;
    List<Figure> figures = new ArrayList<>();

    public Scribble() throws HeadlessException {
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
//        if (text) {
            for (Figure f : figures){
                f.draw(g, f.color);
            }
//        } else {
//            g.drawString("TESTING", firstClickedX, firstCLickedY);
//        }
    }

    public static void main(String[] args) {
        Scribble scribble = new Scribble();

        scribble.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton button = new JButton("color");
        button.setPreferredSize(new Dimension(30, 30));
        button.addActionListener(scribble);

        checkBox = new JCheckBox("Fill");
        checkBox.addActionListener(scribble);

        mb = new JMenuBar();
        x = new JMenu("Menu");
        m1 = new JMenuItem("Line");
        m2 = new JMenuItem("Rectangle");
        m3 = new JMenuItem("Triangle");
        m4 = new JMenuItem("Oval");
        m5 = new JMenuItem("Pyramid");
        m6 = new JMenuItem("StringBox");
        m1.addActionListener(scribble);
        m2.addActionListener(scribble);
        m3.addActionListener(scribble);
        m4.addActionListener(scribble);
        m5.addActionListener(scribble);
        m6.addActionListener(scribble);

        x.add(m1);
        x.add(m2);
        x.add(m3);
        x.add(m4);
        x.add(m5);
        x.add(m6);

        mb.add(x);
        scribble.setJMenuBar(mb);
        scribble.add(button, BorderLayout.NORTH);
        scribble.add(checkBox, BorderLayout.SOUTH);
        scribble.setSize(500, 500);
        scribble.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (shape) {
            case RECTANGLE ->  {
                figure = new Rectangle(color);
                figure.fill = fill;
            }
            case LINE -> figure = new Line(color);
            case OVAL -> {
                figure = new Oval(color);
                figure.fill = fill;
            }
            case TRIANGLE -> {
                figure = new Triangle(color);
                figure.fill = fill;
            }
            case PYRAMID -> figure = new Pyramid(color);
            case STRINGBOX -> {
                figure = new StringBox(color);
                figure.title = "hoi ik ben aan het testen";
            }
        }
        if (figure == null) {
            return;
        }
        firstClickedX = e.getX();
        firstCLickedY = e.getY();
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
        figure.x1 = firstClickedX;
        figure.y1 = firstCLickedY;
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
        if (s.equals("Pyramid")) {
            shape = Shapes.PYRAMID;
        }
        if (s.equals("StringBox")) {
            shape = Shapes.STRINGBOX;
        }
        if (s.equals("color")) {
            color = JColorChooser.showDialog(this,
                    "Select a color", Color.WHITE);
        }
        if (s.equals("Fill")) {
            fill = !fill;
        }
    }
}