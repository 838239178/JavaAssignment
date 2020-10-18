package shape;

import java.util.Objects;

public class Rectangle extends Shape{
    private double length;
    private double wide;

    public Rectangle(double length, double wide) {
        this.length = length;
        this.wide = wide;
    }

    public double getLength() {
        return length;
    }

    public double getWide() {
        return wide;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setWide(double wide) {
        this.wide = wide;
    }

    public double getPerimeter() {
        return (this.length + this.wide) * 2.0;
    }

    public double getArea() {
        return this.length * this.wide;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", wide=" + wide +
                ",perimeter=" + getPerimeter() +
                ",area=" + getArea() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.length, length) == 0 &&
                Double.compare(rectangle.wide, wide) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, wide);
    }
}