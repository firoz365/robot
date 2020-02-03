package com.farnborough.robot;

import static com.farnborough.robot.Constant.*;

public class Simulator {

    private Position currentPosition ;
    private Direction currentDirection ;

    public void nextMove(){

        switch(currentDirection){

            case NORTH: //Increment Y
                currentPosition.setY(getNext_Y());
                return;
            case SOUTH: //Decrement Y
                currentPosition.setY(getPrevious_Y());
                return;

            case EAST: //Increment X
                currentPosition.setX(getNext_X());
                return;
            case WEST: //Decrement Y
                currentPosition.setX(getPrevious_X());
                return;
        }
    }


    private int getNext_X() {
        return currentPosition.getX() < MAX_X ? currentPosition.getX() + 1 : currentPosition.getX();
    }

    private int getPrevious_X() {
        return currentPosition.getX() > MIN_X ? currentPosition.getX() - 1 : currentPosition.getY() ;
    }

    private int getNext_Y() {
        return currentPosition.getY() < MAX_Y ? currentPosition.getY() + 1 : currentPosition.getY();
    }

    private int getPrevious_Y() {
        return currentPosition.getY() > MIN_Y ? currentPosition.getY() - 1 : currentPosition.getY() ;
    }

    @Override
    public String toString() { // TODO :: Use a StringBuilder Here
        return "Simulator{" +
                "currentPosition=" + currentPosition +
                ", currentDirection=" + currentDirection +
                '}';
    }
}
