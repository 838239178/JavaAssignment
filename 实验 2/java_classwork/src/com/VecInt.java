package com;

import com.sun.javafx.geom.Vec2f;

public class VecInt {
    private int x;
    private int y;

    VecInt(int initX, int initY){
        y = initY;
        x = initX;
    }

    VecInt(VecInt v){
        y = v.y;
        x = v.x;
    }

    public static VecInt subVec(VecInt v1, VecInt v2){
        return new VecInt(v1.x+v2.x, v1.y+v2.y);
    }

    public void sub(VecInt v){
        x += v.x;
        y += v.y;
    }

    public void sub(int subX, int subY){
        x += subX;
        y += subY;
    }

    public void set(int setX, int setY){
        x = setX;
        y = setY;
    }

    public void set(VecInt v){
        x = v.x;
        y = v.y;
    }

    public void setX(int n){
        x = n;
    }

    public void setY(int n){
        y = n;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
