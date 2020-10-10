package shape;

public class Triangle extends Shape{
    private float[] side;

    public Triangle(){
        this.side = new float[3];
        this.side[0] = this.side[1] = this.side[2] = 0;
    }

    public Triangle(float s1, float s2, float s3) {
        this();
        this.side[0] = s1;
        this.side[1] = s2;
        this.side[2] = s3;
    }

    public double getPerimeter() {
        return this.side[0] + this.side[1] + this.side[2];
    }

    public double getArea() {
        double p = 0.5 * getPerimeter();
        return Math.sqrt(p * (p - this.side[0]) * (p - this.side[1]) * (p - this. side[2]));
    }
}
