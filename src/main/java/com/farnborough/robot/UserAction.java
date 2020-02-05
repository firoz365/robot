package com.farnborough.robot;

import static com.farnborough.robot.Action.PLACE;

public class UserAction {

    private Robot robot ;

    public void next(String userInput ){
        if(userInput.contains("PLACE"))
            this.next(PLACE , new Robot(userInput));
        else
            this.next(Action.getByName(userInput) , null);
    }

    public void next(Action action , Robot robot){

        this.validate(action);

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

    private void validate(Action action) {
        if(robot == null && action != PLACE){
            throw new RuntimeException("Robot not initialized....[PLACE the robot first , check ReadMe]"); // We can create our custom exception and throw it
        }
    }
}
