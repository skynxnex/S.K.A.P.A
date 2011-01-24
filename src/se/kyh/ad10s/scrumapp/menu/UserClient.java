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

	// TODO Welcome to startmenu

	// OUTPUTS
	public static void startMenuWelcome() {
		System.out.println(Calendar.getInstance().getTime() + 
				"\nWelcome to startmenu\n" +
				"Input 1 to VIEW backlogs\n" +
				"Input 2 to CREATE NEW backlog\n" +
				"Input 3 to DELETE backlog");

	}

	public static void drawCurrentHashMap() {

		Set currentSet = WhiteboardInvoker.hm.entrySet();
		Iterator i = currentSet.iterator();
		
	    while(i.hasNext()){
	        Map.Entry me = (Map.Entry)i.next();
	        System.out.println(me.getKey());
	      }

	}
	
	public static void drawAllBacklogs(ArrayList<Backlog> list) {
		int numberOfBacklogs = list.size();

		for (int i = 0; i < numberOfBacklogs; i++) {

			System.out.print("\nID: " + list.get(i).blid + "\n");
			System.out.println("\nNAME: " + list.get(i).backlogName + "\n");
			System.out.println("DESCRIPTION: " + list.get(i).backlogDescription + "\n");

		}
		
	}

	// TODO sysos for all menus

	// INPUTS
	
	//Check input against hm
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

	
	//Plain method for getting input
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

	public static void userCreateNewBacklog() {
		String backlogName = userInput();
		String backlogDescription = userInput();
		int CreatedBacklogId = BacklogDAO.createNewBacklog(backlogName, backlogDescription);
		System.out.println("\nCreated backlog with the ID: " + CreatedBacklogId);
		//TODO drawBacklog(CreatedBacklogId);
	}

	private static void drawBacklog(int createdBacklogId) {
		// TODO Auto-generated method stub
		
	}





}
