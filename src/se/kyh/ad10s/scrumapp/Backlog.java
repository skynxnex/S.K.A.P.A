package se.kyh.ad10s.scrumapp;

// This is the class for a Backlog
// Here you save your PbItem-objekt in an Arraylist,
// that eventually going to be a DB. 
//
import java.util.ArrayList;
import java.util.Scanner;

public class Backlog {
	ArrayList<PbItem> MyPbItems = new ArrayList<PbItem>();
	Backlog backlog;

	// An array that holds PbItemobjekts. Eventually replaced by a DB.

	// method that gets PbItemobjekt from Whiteboard and save it in the
	// arraylist
	// Eventually to a DB.

	public void createBacklog() {
		backlog = new Backlog();
	}

	public void addPbItem() {

		PbItem pbitem = new PbItem();

		System.out.print("\nID: ");
		pbitem.dbid = intAllowed();

		System.out.print("\nEST: ");
		pbitem.est = intAllowed();

		System.out.print("\nPRIO: ");
		pbitem.prio = intAllowed();

		System.out.print("\nNAME: ");
		pbitem.name = receiveInput();

		System.out.print("\nDESCRIPTION: ");
		pbitem.description = receiveInput();

		// Saving item in current opened backlog
		backlog.savePbItem(pbitem);

	}

	public void savePbItem(PbItem pbitem) {
		MyPbItems.add(pbitem);
	}

	public int intAllowed() {
		int userInt = 0;
		// Lets catch all strings that can not be cast to an int here.
		// if NumberFormatException true ask user for a new int input.

		try {

			userInt = Integer.parseInt(receiveInput());

		} catch (NumberFormatException s) {

			System.out.println("\nExcpecting input to be a number\n input: ");
			intAllowed();

		}

		return userInt;
	}

	private String receiveInput() {
		String string = " ";
		Scanner scanner = new Scanner(System.in);
		string = scanner.nextLine();
		return string;
	}

	public void drawAllPbItem() {
		// Gets the length of MyPbItems-array
		int myPbItemSize = backlog.MyPbItems.size();
		// Loops through the whole MyPbItems-array
		for (int i = 0; i < myPbItemSize; i++) {
			// Prints every PbItem data
			System.out.print("\nID: " + backlog.MyPbItems.get(i).dbid);
			System.out.print(" NAME: " + backlog.MyPbItems.get(i).name);
			System.out.println("\nDESCRIPTION:\n "
					+ backlog.MyPbItems.get(i).description);
			System.out.print("\nEST: " + backlog.MyPbItems.get(i).est);
			System.out.print("      PRIO: " + backlog.MyPbItems.get(i).prio);

			System.out.println("\n---");
		}

	}
}
