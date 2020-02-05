package com.farnborough.robot;

import java.util.Arrays;

import static com.farnborough.robot.Action.PLACE;
import static com.farnborough.robot.constant.Constant.*;

public class UserAction {

    private Robot robot ;

    public void next(String userInput ){

        this.validateUserInput(userInput);

        if(userInput.contains("PLACE"))
            this.next(PLACE , new Robot(userInput));
        else
            this.next(Action.getByName(userInput) , null);
    }

    private void next(Action action , Robot robot){

        this.validateUserAction(action);

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
                System.out.println(robot);
                break;
            default :
                throw new RuntimeException("Not a valid option"); // We can create our custom exception and throw it
        }
    }

    private void validateUserAction(Action action) {
        if(robot == null && action != PLACE){
            throw new RuntimeException("Robot not initialized....[PLACE the robot first , check ReadMe]"); // We can create our custom exception and throw it
        }
    }

    private void validateUserInput(String userInput){

        if(!userInput.matches(PLACE_PATTERN)
                &&!userInput.matches(LEFT_PATTERN)
                &&!userInput.matches(RIGHT_PATTERN)
                &&!userInput.matches(MOVE_PATTERN)
                &&!userInput.matches(REPORT_PATTERN) ){
//
//  Arrays.asList(PLACE_PATTERN ,LEFT_PATTERN ,RIGHT_PATTERN , MOVE_PATTERN , REPORT_PATTERN  ).stream().noneMatch(e->userInput.matches(e)).


            throw new RuntimeException("Not a valid user input");
        }
    }
}
