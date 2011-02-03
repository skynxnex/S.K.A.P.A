package se.kyh.ad10s.scrumapp.menu;

import java.util.Scanner;

public class ClientInputs {
	
	// method for getting input and also output a message
	public static String getInput(String string) {
		System.out.println(string);
		String temp = userInput();
		return temp;
	}

	// Plain method for getting input
	public static String userInput() {
		String string = " ";
		Scanner scanner = new Scanner(System.in);
		string = scanner.nextLine();
		return string;
	}

	// Lets catch all strings that can not be cast to an int here.
	// if NumberFormatException true ask user for a new int input.

	public static int intAllowed(String string) {
		int userInt = 0;

		try {

			userInt = Integer.parseInt(getInput(string));

		} catch (NumberFormatException s) {

			System.out.println("Excpecting number! ");
			intAllowed(string);

		}

		return userInt;
	}

}


