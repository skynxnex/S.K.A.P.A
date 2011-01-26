package se.kyh.ad10s.scrumapp.menu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.WhiteboardInvoker;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;

public class UserClient {
	public static boolean userInStartMenu = true;
	public static boolean userInBacklogMenu;

	// OUTPUTS
	public static void startMenuWelcome() {
		System.out.println( // Calendar.getInstance().getTime()
				"scrumapp:start\\ \n"
						+ "VIEW          lets you view backlogs \n"
						+ "CREATE        creates a new backlog \n"
						+ "DELETE        delete a backlog");

	}

	public static void drawCurrentHashMap() {

		Set currentSet = WhiteboardInvoker.hm.entrySet();
		Iterator i = currentSet.iterator();

		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			System.out.println(me.getKey());
		}

	}

	public static void drawAllBacklogIdAndName(ArrayList<Backlog> list) {
		int numberOfBacklogs = list.size();

		for (int i = 0; i < numberOfBacklogs; i++) {

			System.out.print("[" + list.get(i).blid + ", "
					+ list.get(i).backlogName + "] ");

		}

	}

	public static void drawAllBacklogs(ArrayList<Backlog> list) {
		int numberOfBacklogs = list.size();

		for (int i = 0; i < numberOfBacklogs; i++) {
			System.out.println(" | ");

			System.out.print(" | ID: " + list.get(i).blid);
			System.out.println("\n | NAME: " + list.get(i).backlogName);
			System.out.println(" | DESCRIPTION: "
					+ list.get(i).backlogDescription + "\n | \n");
		}

	}

	// TODO sysos for all menus

	// INPUTS

	// Check input against hm
	public static void executeUserInput() {
		String s = userInput();
		executeCommand(s);
	}

	public static void executeCommand(String s) {
		Command c = getCommand(s);
		if (c == null) {
			return;
		}
		c.execute();
	}

	public static Command getCommand(String strCommand) {
		return WhiteboardInvoker.hm.get(strCommand);
	}

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

	// TODO Functions for asking for specific input

	// Lets catch all strings that can not be cast to an int here.
	// if NumberFormatException true ask user for a new int input.

	public static int intAllowed(String string) {
		int userInt = 0;

		try {

			userInt = Integer.parseInt(getInput(string));

		} catch (NumberFormatException s) {

			System.out.println("\nExcpecting number! ");
			intAllowed(string);

		}

		return userInt;
	}

}
