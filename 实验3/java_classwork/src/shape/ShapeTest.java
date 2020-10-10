package shape;

import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args){
        //思考解答：可以设计一个抽象父类Shape 把不同的对象都放在Shape[]内用循环求解 (感觉用接口更规范？更好一点？)
        Shape[] shapes = new Shape[6];
        shapes[0] = new Rectangle(5,4);
        shapes[1] = new Triangle(3,4,5);
        shapes[2] = new Circle(3.2f);
        shapes[3] = new Rectangle(2.5f, 6);
        shapes[4] = new Triangle(7,8,9);
        shapes[5] = new Circle(2);
        double sumPer = 0;
        double sumArea = 0;
        for (Shape shape : shapes) {
            sumPer += shape.getPerimeter();
            sumArea += shape.getArea();
        }
        System.out.printf("sum of perimeter: %.2f \n", sumPer);
        System.out.printf("sum of area: %.2f \n", sumArea);
    }
}
