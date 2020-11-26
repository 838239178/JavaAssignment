package draw;


import javafx.geometry.Point2D;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;


public class DrawLineTestFrame extends JFrame {
    private final int SCALE;

    public DrawLineTestFrame() {
        this.setLayout(new BorderLayout());
        this.setSize(420, 420);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        SCALE = getWidth() / 2;

        //使用sin的图形初始化
        DrawLineComponent lineComponent = new DrawLineComponent(getFunctionPoints(x -> {
            double dx = (Math.PI / SCALE) * x;
            return Math.sin(dx) * SCALE + SCALE;
        }, getWidth(), false), Color.black);

        //添加cos图形
        lineComponent.addLine(getFunctionPoints(x -> {
            double dx = (Math.PI / SCALE) * x;
            return Math.cos(dx) * SCALE + SCALE;
        }, getWidth(), false), Color.red);

        //添加x,y轴图形
        lineComponent.addLine(getFunctionPoints(x -> getHeight() / 2.0, getWidth(), false), Color.blue);
        lineComponent.addLine(getFunctionPoints(y -> getHeight() / 2.0, getHeight(), true), Color.blue);

        this.add(BorderLayout.CENTER, lineComponent);
    }

    /**
     * 得到一个函数的点集
     *
     * @param function 函数
     * @param size     点的数量
     * @param reverse  是否反转X、Y轴
     * @return point2D类型的点集
     */
    private Point2D[] getFunctionPoints(Function<Integer, Double> function, int size, boolean reverse) {
        Point2D[] points = new Point2D[size];
        for (int i = 0; i < points.length; i++) {
            double x = i;
            double y = function.apply(i);
            if (reverse) {
                points[i] = new Point2D(y, x);
            } else {
                points[i] = new Point2D(x, y);
            }
        }
        return points;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new DrawLineTestFrame().setVisible(true));
    }
}
