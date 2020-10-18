package shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class ShapeTest {
    public static void main(String[] args){
        //思考：PI属性是一个不会再被改动的常量 所以应该用final修饰
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(5,4));
        shapes.add(new Triangle(3,4,5));
        shapes.add(new Circle(3.2));
        shapes.add(new Rectangle(2.5, 6));
        shapes.add(new Triangle(7,8,9));
        shapes.add(new Circle(2));
        double sumPer = 0;
        double sumArea = 0;
        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            sumPer += shape.getPerimeter();
            sumArea += shape.getArea();
        }
        System.out.printf("sum of perimeter: %.2f \n", sumPer);
        System.out.printf("sum of area: %.2f \n", sumArea);
    }
}
