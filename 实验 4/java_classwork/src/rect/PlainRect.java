package rect;

public class PlainRect extends Rect{
    private int startX, startY;

    public PlainRect() {
        super(0,0);
        this.startX = 0;
        this.startY = 0;
    }

    public PlainRect(int width, int height, int startX, int startY) {
        super(width, height);
        this.startX = startX;
        this.startY = startY;
    }

    public boolean isInside(double x, double y){
        return x>=startX && x<=startX+width &&
                y>=startY && y<=startY+height;
    }

}
