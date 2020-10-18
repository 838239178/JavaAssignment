package rect;

public class Rect {
    protected int width, height;

    public Rect() {
        width = height = 10;
    }

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea(){
        return width*height;
    }

    public int getPerimeter(){
        return 2 * (width+height);
    }
}
