package draw;

import javafx.geometry.Point2D;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;


public class DrawLineComponent extends JComponent {

    private final ArrayList<Point2D[]> lines;

    private final HashMap<Point2D[], Color> colors;

    private class MouseListenerInner extends MouseAdapter {
        private Point prePos;
        private Point2D[] current;
        private int draggedPointIndex;

        public MouseListenerInner() {
            current = null;
            prePos = new Point(0, 0);
            draggedPointIndex = -1;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (current == null) return;

            if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
                int offset = (int) (e.getX() - prePos.getX());
                addOffsetX(current, offset);
                prePos = e.getPoint();
            } else if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
                if (draggedPointIndex != -1) {
                    current[draggedPointIndex] = new Point2D(e.getX(), e.getY());
                    //TODO：改变拖拽点周围的点使曲线的点分布均匀
                }
            }
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            AtomicReference<Integer> index = new AtomicReference<>(-1);
            Point2D mouse = new Point2D(e.getX(), e.getY());
            prePos.setLocation(mouse.getX(), mouse.getY());

            //线性查找匹配的点----误差距离为5以内
            lines.forEach(points -> {
                for (int i = 0; i < points.length; i++) {
                    if (points[i].distance(mouse) <= 5) {
                        current = points;
                        index.set(i);
                        break;
                    }
                }
            });

            if (index.get() >= 0)
                draggedPointIndex = index.get();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            draggedPointIndex = -1;
            current = null;
        }
    }

    private void addOffsetX(Point2D[] points, int offset){
        for(int i = 0; i<points.length; i++){
            points[i] = points[i].add(offset,0);
        }
    }

    public void addLine(Point2D[] points, Color color) {
        lines.add(points);
        colors.put(points, color);
    }

    public DrawLineComponent(Point2D[] points, Color color) {
        this.colors = new HashMap<>();
        this.lines = new ArrayList<>();

        this.lines.add(points);
        this.colors.put(points, color);

        MouseListenerInner inner = new MouseListenerInner();
        addMouseMotionListener(inner);
        addMouseListener(inner);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        lines.forEach(points -> {
            g2d.setColor(colors.get(points));
            for (int i = 1; i < points.length; i++) {
                g2d.drawLine(
                        (int) (points[i - 1].getX()),
                        (int) (points[i - 1].getY()),
                        (int) (points[i].getX()),
                        (int) (points[i].getY())
                );
            }
        });
    }
}
