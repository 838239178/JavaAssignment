package shape;

import org.jetbrains.annotations.NotNull;

public abstract class Shape implements Comparable<Shape> {
    public final static double PI = Math.PI;

    public abstract double getPerimeter();
    public abstract double getArea();

    @Override
    public final int compareTo(@NotNull Shape o) {
        return Double.compare(this.getArea(), o.getArea());
    }
}
