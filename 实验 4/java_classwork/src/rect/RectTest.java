package rect;

import java.util.Scanner;

public class RectTest {
    public static void main(String[] args) {
        //思考：设计一个抽象公共父类 把isInside方法作为该类的成员
        PlainRect rect = new PlainRect(10,10,0,0);
        System.out.println("perimeter=" + rect.getPerimeter() + ", area=" + rect.getArea());
        double x,y;
        Scanner in = new Scanner(System.in);
        System.out.println("input x,y:");
        x = in.nextDouble();
        y = in.nextDouble();
        System.out.println(rect.isInside(x,y));
    }
}
