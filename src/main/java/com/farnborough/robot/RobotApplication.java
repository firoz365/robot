package com.farnborough.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RobotApplication {

	static String PLACE_PATTERN="(?i)PLACE\\s+[0-4]\\s*,\\s*[0-4]\\s*,\\s*[ NORTH | SOUTH |EAST|WEST]\\s*";
	static String MOVE_PATTERN="(?i)\\s*MOVE";
	static String LEFT_PATTERN="(?i)\\s*LEFT";
	static String RIGHT_PATTERN="(?i)\\s*RIGHT";
	static String REPORT_PATTERN="(?i)\\s*REPORT";

	public static void main(String[] args) {
		//SpringApplication.run(RobotApplication.class, args);

		boolean isRobotPlaced = false ;
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		while(!exit){
			String text = scanner.nextLine();
			System.out.println(text);

			if(!isRobotPlaced){
				if(!text.matches(PLACE_PATTERN))
					throw new RuntimeException("First command must be place");
				else
					isRobotPlaced = true;

			}


			if(text.equalsIgnoreCase("exit") || text.equalsIgnoreCase("!q"))
				exit = true;
		}
	}

}
