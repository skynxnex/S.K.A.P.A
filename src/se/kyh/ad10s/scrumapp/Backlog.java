package se.kyh.ad10s.scrumapp;

// This is the class for a Backlog
// Here you save your PbItem-objekt in an Arraylist,
// that eventually going to be a DB. 
//
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Backlog {
	ArrayList<PbItem> MyPbItems = new ArrayList<PbItem>();

	// An array that holds PbItemobjekts. Eventually replaced by a DB.

	// method that gets PbItemobjekt from Whiteboard and save it in the
	// arraylist
	// Eventually to a DB.

	public void backlogMenu() {
		HashMap<String, String> menuMap = new HashMap<String, String>();
		menuMap.put("new", "MyNewString");
		menuMap.put("n", "MyNewString");
		menuMap.put("NEW", "MyNewString");

		menuMap.get("n");
		
		String newBacklogOption = "new";
		String getBacklogOption = "get";
		while (true) {
			System.out.println("BACKLOGMENU: ");
			System.out.println("To create a new backlog input \"new\"");
			System.out.println("To access you existing backlog input \"get\"");
			
			String userInput = backlogScanner();
			
			if (userInput.equals(newBacklogOption)) {
				addPbItem();
			} else if (userInput.equals(getBacklogOption)) {
				drawAllPbItem();
			} else {
				System.out.println("Your input did not match our menu options");
			}
		}
	}

	public void addPbItem() {

		PbItem pbitem = new PbItem();

		System.out.print("\nID: ");
		pbitem.dbid = intAllowed();

		System.out.print("EST: ");
		pbitem.est = intAllowed();

		System.out.print("PRIO: ");
		pbitem.prio = intAllowed();

		System.out.print("NAME: ");
		pbitem.name = backlogScanner();

		System.out.print("\nDESCRIPTION: ");
		pbitem.description = backlogScanner();

		// Saving item in current opened backlog
		savePbItem(pbitem);

	}

	public void savePbItem(PbItem pbitem) {
		MyPbItems.add(pbitem);
	}

	public int intAllowed() {
		int userInt = 0;
		// Lets catch all strings that can not be cast to an int here.
		// if NumberFormatException true ask user for a new int input.

		try {

			userInt = Integer.parseInt(backlogScanner());

		} catch (NumberFormatException s) {

			System.out.println("\nExcpecting input to be a number\n input: ");
			intAllowed();

		}

		return userInt;
	}

	public void drawAllPbItem() {
		// Gets the length of MyPbItems-array
		int myPbItemSize = MyPbItems.size();
		// Loops through the whole MyPbItems-array
		for (int i = 0; i < myPbItemSize; i++) {
			// Prints every PbItem data
			System.out.print("\nID: " + MyPbItems.get(i).dbid);
			System.out.print(" NAME: " + MyPbItems.get(i).name);
			System.out.println("\nDESCRIPTION:\n "
					+ MyPbItems.get(i).description);
			System.out.print("\nEST: " + MyPbItems.get(i).est);
			System.out.print("      PRIO: " + MyPbItems.get(i).prio);

			System.out.println("\n---");
		}

	}

	public String backlogScanner() {
		String string = " ";
		Scanner scanner = new Scanner(System.in);
		string = scanner.nextLine();
		return string;
	}

}
