package com.farnborough.robot;

import com.farnborough.robot.exception.NotAValidDirectionException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.farnborough.robot.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DirectionTest {

	/**
	 * Verify there are exactly four direction values
	 */
	@Test()
	void directionByValue() {
		Direction[] values = Direction.values();
		assertEquals(4 , values.length);
	}

	/**
	 * Test we are able to find correct direction enum using the value
	 */
	@Test
	void findDirectionByValue(){
		Direction direction ;

		direction = Direction.getByValue((byte) 0);
		assertEquals(NORTH , direction);

		direction = Direction.getByValue((byte) 1);
		assertEquals(EAST, direction);

		direction = Direction.getByValue((byte) 2);
		assertEquals(Direction.SOUTH , direction);

		direction = Direction.getByValue((byte) 3);
		assertEquals(WEST, direction);
	}


	/**
	 *Test Direction.findDirectionByValue throws expected exception with correct message
	 */
	@Test
	void findDirectionByValue_Exception() {

		RuntimeException  runtimeException =  assertThrows(NotAValidDirectionException.class , ()->{
			Direction.getByValue((byte)5);
		});

		String expectedMessage = "Not a valid direction";
		String actualMessage = runtimeException.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}

	@Test
	void turnLeft(){

		Direction direction = NORTH ;

		direction = direction.turnLeft();
		assertEquals(WEST ,  direction);

		direction = direction.turnLeft();
		assertEquals(SOUTH , direction);

		direction = direction.turnLeft();
		assertEquals(EAST ,  direction);

		direction = direction.turnLeft();
		assertEquals(NORTH , direction);
	}

	@Test
	void turnRight(){

		Direction direction = NORTH ;

		direction = direction.turnRight();
		assertEquals(EAST ,  direction);

		direction = direction.turnRight();
		assertEquals(SOUTH , direction);

		direction = direction.turnRight();
		assertEquals(WEST ,  direction);

		direction = direction.turnRight();
		assertEquals(NORTH , direction);
	}

	@Test
	void max(){
		Direction max = Direction.max();
		assertEquals(3 , max.getValue());
	}

	@Test
	void min(){
		Direction min = Direction.min();
		assertEquals(0 , min.getValue());
	}
}
