package shape;

public class Rectangle extends Shape{
    private float length;
    private float wide;

    public Rectangle(float length, float wide) {
        this.length = length;
        this.wide = wide;
    }

    public float getLength() {
        return length;
    }

    public float getWide() {
        return wide;
    }

    public double getPerimeter() {
        return (this.length + this.wide) * 2.0;
    }

    public double getArea() {
        return this.length * this.wide;
    }
}