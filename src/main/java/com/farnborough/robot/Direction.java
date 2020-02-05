package com.farnborough.robot;

import com.farnborough.robot.exception.NotAValidDirectionException;

import java.util.Arrays;

enum Direction {

    NORTH( (byte) 0 , "NORTH"),
    EAST(  (byte) 1 , "EAST"),
    SOUTH( (byte) 2 , "SOUTH"),
    WEST(  (byte) 3 , "WEST") ;

    private byte value ;
    private String name ;

    Direction(byte value , String name){
        this.value = value;
        this.name = name ;
    }

    public byte getValue() {
        return value;
    }

    public static Direction getByValue(byte in){
        return Arrays.stream(Direction.values())
                .filter(e->e.value==in)
                .findFirst()
                .orElseThrow(()-> new NotAValidDirectionException("Not a valid direction"));
    }

    public static Direction getByName(String in){
        return Arrays.stream(Direction.values())
                .filter(e->e.name.equalsIgnoreCase(in))
                .findFirst()
                .orElseThrow(()-> new NotAValidDirectionException("Not a valid direction"));
    }
    /**
     * Turns the direction of robot to right
     * @return
     */
    public Direction turnRight(){
        int nextDirection = (this.value + 1) % Direction.values().length;
        return Direction.getByValue((byte)nextDirection);
    }

    /**
     * Turns the direction of robot to left. Left turn from NORTH (value -> 1) should take to WEST (value -> 4)
     * @return
     */
    public Direction turnLeft(){
        return this.value == Direction.min().value ? Direction.max() : Direction.getByValue((byte)(this.value-1));
    }

    /**
     * Returns the enum with min value. We can directly return NORTH .
     * But if more enum options are added then this method will determine the min without changing any logic here
     * @return
     */
    public static Direction min(){
        return Direction.getByValue(
                (byte)Arrays.stream(Direction.values())
                        .mapToInt(Direction::getValue)
                        .min()
                        .getAsInt()

        );
    }

    /**
     * Returns the enum with max value, We can directly return SOUTH .
     * But if more enum options are added then this method will determine the max without changing any logic here
     * @return
     */
    public static Direction max(){
        return Direction.getByValue(
                (byte)Arrays.stream(Direction.values())
                        .mapToInt(Direction::getValue)
                        .max()
                        .getAsInt()
        );
    }
}
