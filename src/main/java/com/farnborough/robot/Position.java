package com.farnborough.robot;

import com.farnborough.robot.constant.Constant;

import static com.farnborough.robot.constant.Constant.*;

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

    public Integer getY() {
        return y;
    }

    public void nextX(int movePosition) {
        int newX = this.getX() + movePosition;
        this.x = (newX > Constant.MAX_X || newX < Constant.MIN_X) ? this.getX() : newX ;
    }

    public void nextY(int movePosition) {
        int newY = this.y + movePosition;
        this.y = (newY > Constant.MAX_Y || newY < Constant.MIN_Y) ? this.getY() : newY ;
    }

}
