package draw;

import javafx.geometry.Point2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public class DrawPicture extends JComponent {
    private final ArrayList<Point2D[]> linesPoints;
    private ArrayList<Point2D> current;
    private final HashMap<Point2D[], Color> colors;
    private Color color;

    DrawPicture() {
        colors = new HashMap<>();
        linesPoints = new ArrayList<>();
        MouseListenerInner inner = new MouseListenerInner();
        addMouseListener(inner);
        addMouseMotionListener(inner);
        color = Color.BLACK;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void savePoints(String url) {
        System.out.println("on saving");
        new Thread(()->{
            try {
                PrintWriter fWrite = new PrintWriter(new File(url));
                linesPoints.forEach((points) -> {
                    fWrite.println("line: " + linesPoints.indexOf(points) + ", color: " + colors.get(points));
                    for (Point2D p2d : points) {
                        fWrite.println(p2d.toString());
                    }
                });
                fWrite.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }, "on saving points thread").start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        linesPoints.forEach((points) -> drawLine(points, g2d));
        if (current != null) drawLine(current.toArray(new Point2D[0]), g2d);
    }

    private void drawLine(Point2D[] points, Graphics2D g2d) {

        for (int i = 1; i < points.length; i++) {
            if (colors.containsKey(points)) {
                g2d.setColor(colors.get(points));
            } else {
                g2d.setColor(color);
            }
            g2d.drawLine(
                    (int) points[i - 1].getX(),
                    (int) points[i - 1].getY(),
                    (int) points[i].getX(),
                    (int) points[i].getY()
            );
        }
    }

    private class MouseListenerInner extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            current = new ArrayList<>();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Point2D[] p2d = current.toArray(new Point2D[0]);
            linesPoints.add(p2d);
            colors.put(p2d, color);
            current = null;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            Point2D p = new Point2D(e.getX(), e.getY());
            if (current != null) current.add(p);
            repaint();
        }
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            JFrame frame = new JFrame();
            DrawPicture drawPicture = new DrawPicture();
            JButton colorChooser = new JButton("选择画笔颜色");

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    drawPicture.savePoints("data//points.txt");
                }
            });

            colorChooser.addActionListener(e -> drawPicture.setColor(JColorChooser.showDialog(frame, "画笔颜色", Color.black)));

            frame.add(BorderLayout.SOUTH, colorChooser);

            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.add(BorderLayout.CENTER, drawPicture);
            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
