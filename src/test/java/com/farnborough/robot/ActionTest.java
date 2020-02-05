package com.farnborough.robot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ActionTest {

    @Test
    public void getByName(){
        assertEquals(Action.PLACE , Action.getByName("PLACE"));
    }

    @Test
    public void getByName_Exception(){
        RuntimeException runtimeException = assertThrows(RuntimeException.class, () -> {
            Action.getByName("SOME_INVALID_ACTION");
        });

        assertEquals("No action found for action SOME_INVALID_ACTION",runtimeException.getMessage());
    }
}
