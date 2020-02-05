package com.farnborough.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RobotApplication {

	public static void main(String[] args) {
		//SpringApplication.run(RobotApplication.class, args);

		System.out.println("Please enter the command here");
		Scanner scanner = new Scanner(System.in);

		boolean exit = false;
		UserAction userAction = new UserAction();

		while(!exit){
			String userInput = scanner.nextLine();

			if(userInput .equalsIgnoreCase("exit")
					|| userInput .equalsIgnoreCase("!q")
					|| userInput .equalsIgnoreCase("quit")){

				exit = true;
			}else{
				userAction.next(userInput );
			}
		}
	}

}
