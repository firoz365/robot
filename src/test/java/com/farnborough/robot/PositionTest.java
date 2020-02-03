package com.farnborough.robot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PositionTest {

    @Test
    public void toString_withoutIntialization(){
        Position position  = new Position(null,null);
        assertEquals("(null,null)" , position.toString());
    }

    @Test
    public void toString_withXAndY(){
        Position position  = new Position(1,2);
        assertEquals("(1,2)" , position.toString());
    }
}
