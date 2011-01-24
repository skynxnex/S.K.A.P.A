package se.kyh.ad10s.scrumapp.menu;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import se.kyh.ad10s.scrumapp.WhiteboardInvoker;

public class UserClient {
	public static boolean userInStartMenu = true;

	// TODO Welcome to startmenu

	// OUTPUTS
	public static void startMenuWelcome() {
		System.out.println(Calendar.getInstance() + "\nWelcome to startmenu");

	}

	public static void drawCurrentHashMap() {

		Set currentSet = WhiteboardInvoker.hm.entrySet();
		Iterator i = currentSet.iterator();
		
	    while(i.hasNext()){
	        Map.Entry me = (Map.Entry)i.next();
	        System.out.println(me.getKey() + " runs the method " + me.getValue() );
	      }

	}

	// TODO sysos for all menus

	// INPUTS

	public static String userInput() {
		String string = " ";
		Scanner scanner = new Scanner(System.in);
		string = scanner.nextLine();
		return string;
	}

	// TODO Functions for asking for specific input

	// Lets catch all strings that can not be cast to an int here.
	// if NumberFormatException true ask user for a new int input.

	public int intAllowed() {
		int userInt = 0;

		try {

			userInt = Integer.parseInt(userInput());

		} catch (NumberFormatException s) {

			System.out.println("\nExcpecting number! ");
			intAllowed();

		}

		return userInt;
	}

}
