package com.farnborough.robot;

public class Robot {

    private Position currentPosition ;
    private Direction currentDirection ;

    public Robot(String text){

        String[] split = text.substring("PLACE".length())
                .trim()
                .split(",");

        int x = Integer.parseInt(split[0].trim());
        int y = Integer.parseInt(split[1].trim());
        this.currentPosition = new Position(x , y);
        this.currentDirection = Direction.getByName(split[1].trim());
    }

    public void move(){

        switch(currentDirection){

            case NORTH: //Increment Y
                currentPosition.nextY(+1);
                return;
            case SOUTH: //Decrement Y
                currentPosition.nextY(-1);
                return;

            case EAST: //Increment X
                currentPosition.nextX(1);
                return;
            case WEST: //Decrement Y
                currentPosition.nextX(-1);
                return;
        }
    }

    public void turnLeft(){
        this.currentDirection.turnLeft();
    }

    public void turnRight(){
        this.currentDirection.turnRight();
    }

    @Override
    public String toString() { // TODO :: Use a StringBuilder Here
        return "Simulator{" +
                "currentPosition=" + currentPosition +
                ", currentDirection=" + currentDirection +
                '}';
    }
}
