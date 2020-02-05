package com.farnborough.robot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PositionTest {

    Position position  = null ;

    @BeforeEach
    void init(){
        position = new Position(0,0);
    }

    @Test
    public void toString_withoutIntialization(){
        Position nullPosition  = new Position(null,null);
        assertEquals("(null,null)" , nullPosition  .toString()); //Tets toString is not throwing NullPointerException
    }

    @Test
    public void toString_withXAndY(){
        Position newPosition  = new Position(1,2);
        assertEquals("(1,2)" , newPosition.toString());
    }

    //Test boundary condition (x should not be less than 0 and more than 5)
    @Test
    void nextX_boundaryCondition(){
        position.nextX(-1);
        position.nextX(-1);
        assertEquals(0 , position.getX());

        position.nextX(1);
        assertEquals(1 , position.getX());

        position.nextX(1);
        position.nextX(1);
        assertEquals(3 , position.getX());

        position.nextX(1);
        assertEquals(4 , position.getX());

        position.nextX(1);
        assertEquals(4 , position.getX());

        position.nextX(1);
        position.nextX(1);
        assertEquals(4 , position.getX());
    }


    //@Ignore("Exactly similar test as Y // TODO :: I am leaving it for now")
    @Test
    void nextY_boundryCondition(){

    }
}
