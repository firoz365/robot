package com.farnborough.robot;

import java.util.Arrays;

import static com.farnborough.robot.Action.PLACE;
import static com.farnborough.robot.constant.Constant.*;

public class UserAction {

    private Robot robot ;

    public void next(String userInput ){

        if(!this.validateUserInput(userInput))
            return;

        if(userInput.contains("PLACE"))
            this.next(PLACE , new Robot(userInput));
        else
            this.next(Action.getByName(userInput) , null);
    }

    private void next(Action action , Robot robot){

        if(!this.validateUserAction(action))
            return;

        switch(action){
            case PLACE:
                this.robot = robot ;
                break;
            case MOVE :
                this.robot.move();
                break;
            case LEFT :
                this.robot.turnLeft();
                break;
            case RIGHT :
                this.robot.turnRight();
                break;
            case REPORT:
                System.out.println("REPORT : ");
                System.out.println(this.robot);
                break;
            default :
                throw new RuntimeException("Not a valid option"); // We can create our custom exception and throw it
        }
    }

    private boolean validateUserAction(Action action) {
        if(robot == null && action != PLACE){
            //throw new RuntimeException("Robot not initialized....[PLACE the robot first , check ReadMe]"); // We can create our custom exception and throw it
            System.out.println("Place the robot first");
            return false;
        }
        return true;
    }

    private boolean validateUserInput(String userInput){

        boolean isValid = Arrays.asList(PLACE_REGEX, LEFT_REGEX, RIGHT_REGEX, MOVE_REGEX, REPORT_REGEX)
                .stream()
                .anyMatch(e -> userInput.matches(e));

        if(isValid)
            return true ;

        System.out.println("Not a valid option");
        return false;
    }
}


/*
if(userInput.matches(PLACE_REGEX)
                || userInput.matches(LEFT_REGEX)
                || userInput.matches(RIGHT_REGEX)
                || userInput.matches(MOVE_REGEX)
                || userInput.matches(REPORT_REGEX)){

 */
