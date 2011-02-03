package se.kyh.ad10s.scrumapp.menu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.Sprint;
import se.kyh.ad10s.scrumapp.Task;
import se.kyh.ad10s.scrumapp.WhiteboardInvoker;

public class UserClient {
	
	public static boolean isRunningProgram = true;
	
	public static boolean userInStartMenu = true;
	public static boolean userInBacklogMenu;
	public static boolean userInBacklogItemMenu;
	public static boolean userInSprintMenu;

	public static int SelectedBacklog;
	public static String SelectedBacklogName;
	public static int SelectedBacklogItem;
	public static String SelectedBacklogItemName;
	public static int SelectedSprint;
	public static String SelectedSprintName;
	
	

	// OUTPUTS
	public static void startMenuWelcome() {
		System.out.println( // Calendar.getInstance().getTime()
				"scrumapp:backlogs\\ \n"
						+ "VIEW          lets you view backlogs \n"
						+ "CREATE        creates a new backlog \n"
						+ "DELETE        delete a backlog \n"
						+ "BACKLOG       choose a backlog to tamper \n" 
						+ "EXIT          exit program");

	}

	public static void backlogMenuWelcome() {
		System.out.print("scrumapp:backlogs\\backlog\\");
		System.out.print(SelectedBacklogName);
		System.out.print("\n");
		System.out.println("VIEWALL       view all items in current backlog");
		System.out.println("VIEW          view an item by item id");
		System.out.println("CREATE        creates a new backlog item");
		System.out.println("DELETE        delete an item");
		System.out.println("ITEM        choose an item for sprint and create tasks");
		System.out.println("---SPRINTOPTIONS---");
		System.out.println("ADD           add a new sprint to this backlog");
		System.out.println("REMOVE        remove a sprint from this backlog");
		System.out.println("LIST          list all availible SPRINTS in this backlog");

		System.out.println("SPRINT        access sprintmenu");
		System.out
				.println("BACK          exit this backlog and enter mainmenu \n");

	}

	public static void backlogItemMenuWelcome() {
		System.out.print("scrumapp:backlogs\\backlog\\");
		System.out.print(SelectedBacklogName);
		System.out.print("\\");
		System.out.print(SelectedBacklogItemName);
		System.out.print("\n");
		System.out.println("VIEWALL    view all TASKS in this ITEM");
		System.out.println("ADD        add an ITEM to SPRINT");
		System.out.println("REMOVE     remove an ITEM from SPRINT");
		System.out.println("CREATE     create a new task");
		System.out.println("DELETE     delete a task");
		System.out.println("CHECKOUT   checkout a task to work on");			
		System.out.println("DONE       set a Task to DONE");
		System.out.println("BACK       exit this ITEM and return to BACKLOG");

	}
	
	public static void sprintMenuWelcome() {
		System.out.print("scrumapp:backlogs\\backlog\\");
		System.out.print(SelectedBacklogName);
		System.out.print("\\");
		System.out.println(SelectedSprintName);
		System.out.println("ADD        add item to this sprint");   
		System.out.println("REMOVE     remove an item from this sprint");
		System.out.println("LIST       list all items with no sprint");
		System.out.println("BACK       exit this sprint and return to BACKLOG");
		
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

	public static boolean compareUserRequsestToSprintIds(
			ArrayList<Sprint> sprintlist, int userInputSelectedSprint) {
		int numberOfSprintsInBacklog = sprintlist.size();
		for (int i = 0; i < numberOfSprintsInBacklog; i++) {
			if (userInputSelectedSprint == sprintlist.get(i).sprintid) {
				SelectedSprintName = 
					new SimpleDateFormat("yyyy MM dd").format(sprintlist.get(i).startDate.getTime()) 
					+ " - " 
					+ new SimpleDateFormat("yyyy MM dd").format(sprintlist.get(i).endDate.getTime());
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
					+ "\n | EST: " + itemsArray.get(i).est + "\n | PRIO: "
					+ itemsArray.get(i).prio + "\n | SPRINT ID: "
					+ itemsArray.get(i).pBItemSprintId + "\n | BACKLOG ID: "
					+ itemsArray.get(i).BacklogId + "\n | \n");

		}
	}

	public static void drawOneItem(PbItem pbItemFromDB) {
		System.out.println(" | ");

		System.out.println(" | ITEM ID: " + pbItemFromDB.dbid + "\n | NAME: "
				+ pbItemFromDB.name + "\n | DESCRIPTION: "
				+ pbItemFromDB.description + "\n | EST: " + pbItemFromDB.est
				+ "\n | PRIO: " + pbItemFromDB.prio + "\n | SPRINT ID: "
				+ pbItemFromDB.pBItemSprintId + "\n | BACKLOG ID: "
				+ pbItemFromDB.BacklogId + "\n | \n");
	}

	public static void drawAllItemsIdAndName(ArrayList<PbItem> itemsArray) {
		int numberOfItemsInBacklog = itemsArray.size();

		for (int i = 0; i < numberOfItemsInBacklog; i++) {

			System.out.print("[" + itemsArray.get(i).dbid + ", "
					+ itemsArray.get(i).name + "] ");

		}

	}

	public static void drawAllSprintsIdAndName(ArrayList<Sprint> sprintlist) {
		int numberOfSprintsInArray = sprintlist.size();

		for (int i = 0; i < numberOfSprintsInArray; i++) {
			System.out.print("["
					+ sprintlist.get(i).sprintid
					+ ", "
					+ new SimpleDateFormat("yyyy MM dd").format(sprintlist
							.get(i).startDate.getTime())
					+ " - "
					+ new SimpleDateFormat("yyyy MM dd").format(sprintlist
							.get(i).endDate.getTime()) + "] ");

		}
		System.out.print("\n");
	}
	
	public static void drawAllTasksForPbItem(ArrayList<Task> list) {
		int numberOfTasks = list.size();

		for (int i = 0; i < numberOfTasks; i++) {
			System.out.println(" | ");

			System.out.print(" | TASKID: " + list.get(i).dbid);
			System.out.println("\n | TASKNAME: " + list.get(i).name);
			System.out.println(" | DESCRIPTION: "
					+ list.get(i).description);
			System.out.print(" | EST: " + list.get(i).est);
			System.out.print(" | PRIO: " + list.get(i).prio);
			System.out.print(" | PBITEMID: " + list.get(i).taskPBItemId + "\n");
			if (list.get(i).taskCheckoutName != null) {
				System.out.print(" | CHECKEDOUT BY: " + list.get(i).taskCheckoutName);
			} else {
				
			}
			
			System.out.print(" | CHECKOUTDATE: " +
					new SimpleDateFormat("yyyy MM dd").format(list.get(i).taskCheckoutDate.getTime()));
			
			if (list.get(i).taskdone != false) {
				System.out.print(" | DONE: " + list.get(i).taskdone + "\n | \n \n");
			} else {
				System.out.print("\n | \n\n");
			}
			
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
