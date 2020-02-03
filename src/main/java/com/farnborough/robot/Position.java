package com.farnborough.robot;

public class Position {

    private Integer x;
    private Integer y;

    @Override
    public String toString() {
        return String.format("(%s,%s)" , x , y);
//        return "Position{" +
//                "x=" + x +
//                ", y=" + y +
//                '}';
    }

    public Position(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

      public void setY(Integer y) {
        this.y = y;
    }
}
