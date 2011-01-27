package se.kyh.ad10s.scrumapp.menu;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.WhiteboardInvoker;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;

public class UserClient {
	public static boolean userInStartMenu = true;
	public static boolean userInBacklogMenu;
	public static int SelectedBacklog;
	public static String SelectedBacklogName;
	

	// OUTPUTS
	public static void startMenuWelcome() {
		System.out.println( // Calendar.getInstance().getTime()
				"scrumapp:backlogs\\ \n"
						+ "VIEW          lets you view backlogs \n"
						+ "CREATE        creates a new backlog \n"
						+ "DELETE        delete a backlog \n"
						+ "CHOOSE        choose a backlog to tamper");

	}

	public static void backlogMenuWelcome() {
		ArrayList<Backlog> list = BacklogDAO.getAllBacklogsFromDB();
		System.out.print("scrumapp:backlogs\\backlog\\");
		drawBacklogName(list, SelectedBacklog);
		System.out.print("\n");
		System.out.println("VIEWALL       view all items in current backlog");
		System.out.println("VIEW          view an item by item id");
		System.out.println("CREATE        creates a new backlog item");
		System.out.println("DELETE        delete an item");
		System.out.println("CHOOSE        choose an item for sprint and create tasks");
		System.out.println("EXIT          exit this backlog and enter mainmenu \n");
		
	}

	public static boolean compareUserRequsestToBacklogIds(
			ArrayList<Backlog> list, int userRequestedBacklogId) {
		int numberOfBacklogs = list.size();

		for (int i = 0; i < numberOfBacklogs; i++) {
			if (userRequestedBacklogId == list.get(i).blid) {
				return true;
			}

		}
		return false;
	}

	/**
	 * 
	 * @param backlogItemId
	 * @param list
	 * @param backlogid
	 */
	public static void drawBacklogName(ArrayList<Backlog> list,
			int backlogItemId) {
		int numberOfBacklogs = list.size();

		for (int i = 0; i < numberOfBacklogs; i++) {
			if (backlogItemId == list.get(i).blid) {
				System.out.print(list.get(i).backlogName);
			}

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

	public static void drawCurrentBacklogItems(ArrayList<Backlog> list) {
		int numberOfBacklogs = list.size();

		for (int i = 0; i < numberOfBacklogs; i++) {
			System.out.println(" | ");

			System.out.print(" | ID: " + list.get(i).blid);
			System.out.println("\n | NAME: " + list.get(i).backlogName);
			System.out.println(" | DESCRIPTION: "
					+ list.get(i).backlogDescription + "\n | \n");
		}

	}

	// INPUTS

	// Check input against hashmap
	public static void executeUserInput() {
		String s = ClientInputs.userInput();
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

}
