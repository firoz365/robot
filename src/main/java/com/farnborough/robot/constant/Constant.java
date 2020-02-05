package com.farnborough.robot.constant;

public interface Constant {
    static int MIN_X = 0 ;
    static int MAX_X = 4 ;

    static int MIN_Y = 0 ;
    static int MAX_Y = 4 ;

    static String PLACE_PATTERN="PLACE\\s+[0-4]\\s*,\\s*[0-4]\\s*,\\s*(NORTH|SOUTH|EAST|WEST)\\s*";
    static String MOVE_PATTERN="\\s*MOVE\\s*";
    static String LEFT_PATTERN="\\s*LEFT\\s*";
    static String RIGHT_PATTERN="\\s*RIGHT\\s*";
    static String REPORT_PATTERN="\\s*REPORT\\s*";

}
