package com.farnborough.robot;

public class Robot {

    private Position currentPosition ;
    private Direction currentDirection ;

    public Robot(String text){

        try{
            String[] split = text.trim().substring("PLACE".length())
                    .trim()
                    .split(",");

            int x = Integer.parseInt(split[0].trim());
            int y = Integer.parseInt(split[1].trim());
            this.currentPosition = new Position(x , y);
            this.currentDirection = Direction.getByName(split[2].trim());

        }catch(Exception e){
           throw new RuntimeException("PLACE action is not correct!");
        }
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
        this.currentDirection = this.currentDirection.turnLeft();
    }

    public void turnRight(){
        this.currentDirection = this.currentDirection.turnRight();
    }

    @Override
    public String toString() { // TODO :: Use a StringBuilder Here
        return "ROBOT [" +
                "currentPosition=" + currentPosition +
                ", currentDirection=" + currentDirection +
                ']';
    }

    public Position getCurrentPosition() {
        return currentPosition;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }
}
