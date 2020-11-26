package shape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

public class ShapeTest {
    public static void main(String[] args){
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(5,4));
        shapes.add(new Triangle(3,4,5));
        shapes.add(new Circle(3.2));
        shapes.add(new Rectangle(2.5, 6));
        shapes.add(new Triangle(7,8,9));
        shapes.add(new Circle(2));
        Shape[] sArray = shapes.toArray(new Shape[0]);
        Arrays.sort(sArray);
        for(Shape s : sArray){
            System.out.println(s.toString());
        }
    }
}
