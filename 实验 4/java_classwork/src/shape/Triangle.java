package shape;

import java.util.Arrays;

public class Triangle extends Shape{
    private double[] side;

    public Triangle(){
        this.side = new double[3];
        this.side[0] = this.side[1] = this.side[2] = 0;
    }

    public Triangle(double s1, double s2, double s3) {
        this();
        this.side[0] = s1;
        this.side[1] = s2;
        this.side[2] = s3;
    }

    public double[] getSide() {
        return side;
    }

    public void setSide(double[] side) {
        this.side = side;
    }

    public double getPerimeter() {
        return this.side[0] + this.side[1] + this.side[2];
    }

    public double getArea() {
        double p = 0.5 * getPerimeter();
        return Math.sqrt(p * (p - this.side[0]) * (p - this.side[1]) * (p - this. side[2]));
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side=" + Arrays.toString(side) +
                ",perimeter=" + getPerimeter() +
                ",area=" + getArea() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(this.side, triangle.side);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(side);
    }
}
