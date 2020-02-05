package com.farnborough.robot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RobotApplication {

	public static void main(String[] args) {
		SpringApplication.run(RobotApplication.class, args);

		System.out.println();
		System.out.println();

		System.out.println("  ____     ___    ____     ___    _____               ____    _                    _       ____    _          _     __   __  ___   _   _    ____ ");
		System.out.println(" |  _ \\   / _ \\  | __ )   / _ \\  |_   _|             / ___|  | |_    __ _   _ __  | |_    |  _ \\  | |        / \\    \\ \\ / / |_ _| | \\ | |  / ___|");
		System.out.println(" | |_) | | | | | |  _ \\  | | | |   | |      _____    \\___ \\  | __|  / _` | | '__| | __|   | |_) | | |       / _ \\    \\ V /   | |  |  \\| | | |  _ ");
		System.out.println(" |  _ <  | |_| | | |_) | | |_| |   | |     |_____|    ___) | | |_  | (_| | | |    | |_    |  __/  | |___   / ___ \\    | |    | |  | |\\  | | |_| |");
		System.out.println(" |_| \\_\\  \\___/  |____/   \\___/    |_|               |____/   \\__|  \\__,_| |_|     \\__|   |_|     |_____| /_/   \\_\\   |_|   |___| |_| \\_|  \\____|");

		System.out.println();
		System.out.println();
		System.out.println("Please enter the command ...");

		boolean exit = false;
		UserAction userAction = new UserAction();

		Scanner scanner = new Scanner(System.in);

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
