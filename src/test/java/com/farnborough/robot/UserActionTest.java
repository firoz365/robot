package com.farnborough.robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.farnborough.robot.Direction.EAST;
import static com.farnborough.robot.Direction.NORTH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class UserActionTest {


    @BeforeEach
    public void init(){

    }

    @Test
    public void next(){
        UserAction userAction = new UserAction();
        userAction.next("PLACE 1,1,NORTH");
        userAction.next("MOVE");
        userAction.next("MOVE");

        assertEquals(NORTH ,  userAction.getRobot().getCurrentDirection());
        assertEquals(1 ,  userAction.getRobot().getCurrentPosition().getX());
        assertEquals(3 ,  userAction.getRobot().getCurrentPosition().getY());


        //Right turn from NORTH should change the direction to EAST
        userAction.next("RIGHT");
        assertEquals(EAST ,  userAction.getRobot().getCurrentDirection());

        //2 move in the east should make x 3
        userAction.next("MOVE");
        userAction.next("MOVE");
        assertEquals(3 ,  userAction.getRobot().getCurrentPosition().getX());

        //Report/Sout should print this
        assertTrue("ROBOT [currentPosition=(3,3), currentDirection=EAST]".equals(userAction.getRobot().toString()));

        userAction.next("MOVE");
        userAction.next("MOVE");
        userAction.next("MOVE");
        userAction.next("MOVE");
        userAction.next("MOVE");
        userAction.next("MOVE");
        userAction.next("MOVE");
        assertEquals(4 ,  userAction.getRobot().getCurrentPosition().getX());

        userAction.next("RIGHT");
        userAction.next("RIGHT");

        userAction.next("MOVE");
        userAction.next("MOVE");
        userAction.next("MOVE");
        userAction.next("MOVE");
        assertEquals(0 ,  userAction.getRobot().getCurrentPosition().getX());

        //Verify after 0  , it's not going in - (minus)
        userAction.next("MOVE");
        assertEquals(0 ,  userAction.getRobot().getCurrentPosition().getX());
        assertEquals(3 ,  userAction.getRobot().getCurrentPosition().getY()); //Verify Y

        assertTrue("ROBOT [currentPosition=(0,3), currentDirection=WEST]".equals(userAction.getRobot().toString()));

        //TODO : Same for Y

    }

    //@Ignore  //TODO : Wrire tests to verify exceptions , validations are done properly
    @Test
    public void testTheBoundryConditionsHere(){
        UserAction userAction = new UserAction();
        userAction.next("PLACE 4,4,NORTH");
        userAction.next("MOVE");

        assertEquals(4 ,  userAction.getRobot().getCurrentPosition().getX());
        assertEquals(4 ,  userAction.getRobot().getCurrentPosition().getY());

        userAction.next("RIGHT");
        userAction.next("MOVE");

        assertEquals(4 ,  userAction.getRobot().getCurrentPosition().getX());
        assertEquals(4 ,  userAction.getRobot().getCurrentPosition().getY());

        userAction.next("LEFT");
        userAction.next("LEFT");
        userAction.next("MOVE");
        userAction.next("LEFT");
        userAction.next("MOVE");

        assertEquals(3 ,  userAction.getRobot().getCurrentPosition().getX());
        assertEquals(3 ,  userAction.getRobot().getCurrentPosition().getY());

    }

}
