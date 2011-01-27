package se.kyh.ad10s.scrumapp.menu;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.WhiteboardInvoker;

public class UserClient {
	public static boolean userInStartMenu = true;
	public static boolean userInBacklogMenu;
	public static boolean userInBacklogItemMenu;
	
	public static int SelectedBacklog;
	public static String SelectedBacklogName;
	public static int SelectedBacklogItem;
	public static String SelectedBacklogItemName;


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
		System.out.print("scrumapp:backlogs\\backlog\\");
		System.out.print(SelectedBacklogName);
		System.out.print("\n");
		System.out.println("VIEWALL       view all items in current backlog");
		System.out.println("VIEW          view an item by item id");
		System.out.println("CREATE        creates a new backlog item");
		System.out.println("DELETE        delete an item");
		System.out
				.println("CHOOSE        choose an item for sprint and create tasks");
		System.out
				.println("BACK          exit this backlog and enter mainmenu \n");

	}
	
	public static void backlogItemMenuWelcome() {
		System.out.print("scrumapp:backlogs\\backlog\\");
		System.out.print(SelectedBacklogName);
		System.out.print("\\");
		System.out.print(SelectedBacklogItemName);
		System.out.print("\n");
		System.out.println("ADD        add an ITEM to SPRINT");
		System.out.println("REMOVE     remove an ITEM from SPRINT");
		System.out.println("CREATE     create a new task");
		System.out.println("DELETE     delete a task");
		System.out.println("BACK       exit this ITEM and return to BACKLOG");
		
	}

	public static boolean compareUserRequsestToBacklogIds(
			ArrayList<Backlog> list, int userRequestedBacklogId) {
		int numberOfBacklogs = list.size();

		for (int i = 0; i < numberOfBacklogs; i++) {
			if (userRequestedBacklogId == list.get(i).blid) {
				SelectedBacklogName = list.get(i).backlogName;
				return true;
			}

		}
		return false;
	}
	
	public static boolean compareUserRequsestToItemIds(
			ArrayList<PbItem> itemsArray, int userInputSelectedItemId) {
		int numberOfItemsInBacklog = itemsArray.size();
		
		for (int i = 0; i < numberOfItemsInBacklog; i++) {
			if (userInputSelectedItemId == itemsArray.get(i).dbid) {
				SelectedBacklogItemName = itemsArray.get(i).name;
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
				SelectedBacklogName = list.get(i).backlogName;
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

	public static void drawAllItemsInBacklog(ArrayList<PbItem> itemsArray) {
		int numberOfItemsInBacklog = itemsArray.size();

		for (int i = 0; i < numberOfItemsInBacklog; i++) {
			System.out.println(" | ");

			System.out.println(" | ITEM ID: " + itemsArray.get(i).dbid
					+ "\n | NAME: " + itemsArray.get(i).name
					+ "\n | DESCRIPTION: " + itemsArray.get(i).description
					+ "\n | EST: " + itemsArray.get(i).est 
					+ "\n | PRIO: " + itemsArray.get(i).prio 
					+ "\n | SPRINT ID: " + itemsArray.get(i).pBItemSprintId
					+ "\n | BACKLOG ID: " + itemsArray.get(i).BacklogId + "\n | \n");
			
		}
	}

	public static void drawOneItem(PbItem pbItemFromDB) {
		System.out.println(" | ");

		System.out.println(" | ITEM ID: " + pbItemFromDB.dbid
				+ "\n | NAME: " + pbItemFromDB.name
				+ "\n | DESCRIPTION: " + pbItemFromDB.description
				+ "\n | EST: " + pbItemFromDB.est 
				+ "\n | PRIO: " + pbItemFromDB.prio 
				+ "\n | SPRINT ID: " + pbItemFromDB.pBItemSprintId
				+ "\n | BACKLOG ID: " + pbItemFromDB.BacklogId + "\n | \n");
	}
	
	public static void drawAllItemsIdAndName(ArrayList<PbItem> itemsArray) {
		int numberOfItemsInBacklog = itemsArray.size();

		for (int i = 0; i < numberOfItemsInBacklog; i++) {
		
			System.out.print("[" + itemsArray.get(i).dbid + ", "
					+ itemsArray.get(i).name + "] ");
			
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
