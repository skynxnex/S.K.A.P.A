package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Sprint {
	public int sprintid = 1;
	private Scanner indata = new Scanner(System.in);
	public Calendar startDate = Calendar.getInstance();
	public Calendar endDate = Calendar.getInstance();
	private List<PbItem> list = new ArrayList<PbItem>();
	
	public void newSprint() {
		setStartDate();
		setEndDate();
		this.sprintid = DataAccessObject.makeNewSprint(startDate, endDate);
	}

	public void listAllSprintBacklogItems() {
		list = DataAccessObject.getAllItemsInSprint(this.sprintid);
		int arrayLength = list.size();
		for (int i = 0; i < arrayLength; i++) {
			System.out.println("Index nr " + i);
			System.out.print("\nID: " + list.get(i).dbid);
			System.out.print(" NAME: " + list.get(i).name);
			System.out.println("\nDESCRIPTION:\n " + list.get(i).description);
			System.out.print("\nEST: " + list.get(i).est);
			System.out.print("      PRIO: " + list.get(i).prio);

			System.out.println("\n---");
		}
	}

	private void setStartDate() {
		System.out.println("Input data for start of sprint");
		int year = getYear();
		int month = getMonth();
		int day = getDay(year, month);
		startDate.set(year, month, day);
	}

	private void setEndDate() {
		System.out.println("Input data for end of sprint");
		int year = getYear();
		int month = getMonth();
		int day = getDay(year, month);
		endDate.set(year, month, day);
	}

	private int intAllowed(String input) {
		int userInt = 0;
		try {
			userInt = Integer.parseInt(input);
		} catch (NumberFormatException s) {

			System.out.println("\nExcpecting input to be a number\n input: ");
			intAllowed(receiveInput());
		}
		return userInt;
	}

	private String receiveInput() {
		String string = " ";
		string = indata.nextLine();
		return string;
	}

	private int getYear() {
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

	private int getMonth() {
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

	private int getDay(int year, int month) {
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

	private boolean checkValidYear(int value) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		if (value < year) {
			System.out.println("Year not allowed");
			return false;
		} else {
			return true;
		}
	}

	private boolean checkValidDay(int input, int year, int month) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, input);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		if (input <= days && input > 0) {
			return true;
		} else {
			System.out.println("Day not allowed");
			return false;
		}
	}

	private boolean checkValidMonth(int input) {
		if (input < 12 && input >= 0) {
			return true;
		} else {
			System.out.println("Month not allowed");
			return false;
		}
	}
}
