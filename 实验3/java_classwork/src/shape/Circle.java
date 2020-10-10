package shape;

public class Circle extends Shape {
    private float radius;

    public float getRadius() {
        return radius;
    }

    public Circle(float radius) {
        this.radius = radius;
    }

    public double getPerimeter(){
        return Math.PI * 2 * this.radius;
    }

    public double getArea(){
        return Math.PI * this.radius * this.radius;
    }
}
