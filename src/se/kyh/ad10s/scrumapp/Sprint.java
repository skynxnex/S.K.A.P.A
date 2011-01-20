package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.Date;

public class Sprint {
	static Scanner indata = new Scanner(System.in);
	static Calendar startDate = Calendar.getInstance();
	static Calendar endDate = Calendar.getInstance();
	static ArrayList<PbItem> SprintBacklog = new ArrayList<PbItem>();

	public static void main(String[] args) {
		Backlog bl = new Backlog();
		bl.addPbItem();
	}

	// Lägg till Items i sprintBL
	public static void addItemToSprintBacklog(PbItem pbitem) {
		SprintBacklog.add(pbitem);
		// Lägga till tillhörighet i databas
	}

	// Lista alla items i sprintbl
	public static void listAllSprintBacklogItems() {
		// Gets the length of MyPbItems-array
		int arrayLength = SprintBacklog.size();
		// Loops through the whole MyPbItems-array
		for (int i = 0; i < arrayLength; i++) {
			// Prints every PbItem data
			System.out.println("Index nr " + i);
			System.out.print("\nID: " + SprintBacklog.get(i).dbid);
			System.out.print(" NAME: " + SprintBacklog.get(i).name);
			System.out.println("\nDESCRIPTION:\n "
					+ SprintBacklog.get(i).description);
			System.out.print("\nEST: " + SprintBacklog.get(i).est);
			System.out.print("      PRIO: " + SprintBacklog.get(i).prio);

			System.out.println("\n---");
		}
	}

	// ta bort items i sprintbl
	public static void removeItemFromSprintBacklog(int index) {
		SprintBacklog.remove(index);
		// ta bort tillhörighet i databas
	}

	public static void setStartDate() {
		System.out.println("Input data for start of sprint");
		int year = getYear();
		int month = getMonth();
		int day = getDay(year, month);
		startDate.set(year, month, day);
	}

	public static void setEndDate() {
		System.out.println("Input data for end of sprint");
		int year = getYear();
		int month = getMonth();
		int day = getDay(year, month);
		endDate.set(year, month, day);
	}

	public static int intAllowed(String input) {
		int userInt = 0;
		// Lets catch all strings that can not be cast to an int here.
		// if NumberFormatException true ask user for a new int input.

		try {
			userInt = Integer.parseInt(input);
		} catch (NumberFormatException s) {

			System.out.println("\nExcpecting input to be a number\n input: ");
			intAllowed(receiveInput());
		}
		return userInt;
	}

	private static String receiveInput() {
		String string = " ";
		string = indata.nextLine();
		return string;
	}

	private static int getYear() {
		boolean test = false;
		int input = 0;
		System.out.println("Input year: ");
		while (!test) {
			input = intAllowed(receiveInput());
			if (checkValidYear(input)) {
				test = true;
			}
		}
		return input;
	}

	private static int getMonth() {
		boolean test = false;
		int input = 0;
		System.out.println("Input month: ");
		while (!test) {
			input = intAllowed(receiveInput());
			if (checkValidMonth(input)) {
				test = true;
			}
		}
		return input;
	}

	private static int getDay(int year, int month) {
		boolean test = false;
		int input = 0;
		System.out.println("Input day: ");
		while (!test) {
			input = intAllowed(receiveInput());
			if (checkValidDay(input, year, month)) {
				test = true;
			}
		}
		return input;
	}

	private static boolean checkValidYear(int value) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		if (value < year) {
			System.out.println("Felaktigt årtal");
			return false;
		} else {
			return true;
		}
	}

	private static boolean checkValidDay(int input, int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, input);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (input <= days && input > 0) {
			return true;
		} else {
			System.out.println("Felaktigt dag");
			return false;
		}
	}

	private static boolean checkValidMonth(int input) {
		if (input < 12 && input >= 0) {
			return true;
		} else {
			System.out.println("Felaktigt månad");
			return false;
		}
	}
}
