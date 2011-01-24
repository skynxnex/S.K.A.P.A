package se.kyh.ad10s.scrumapp;

// This is the class for a Backlog
// Here you save your PbItem-objekt in an Arraylist,
// that eventually going to be a DB. 
//
import java.util.ArrayList;
import java.util.Scanner;

public class Backlog {
	public String backlogName;
	ArrayList<PbItem> MyPbItems = new ArrayList<PbItem>();
	public int blid;
	public String backlogDescription;

	// An array that holds PbItemobjekts. Eventually replaced by a DB.

	// method that gets PbItemobjekt from Whiteboard and save it in the
	// arraylist
	// Eventually to a DB.
	
	public Backlog() {
		// get name from user
		// get description from user
		// save bl to db
		// load same bl from db
		
	}

	public void backlogMenu() {
//		HashMap<String, String> menuMap = new HashMap<String, String>();
//		menuMap.put("new", "MyNewString");
//		menuMap.put("n", "MyNewString");
//		menuMap.put("NEW", "MyNewString");
//
//		menuMap.get("n");
		
		String newBacklogOption = "new";
		String getBacklogOption = "get";
		String doneBacklogOption = "done";
		
		boolean exit = false;
		
		while (exit == false) {
			System.out.println("BACKLOGMENU: ");
			System.out.println("To create a new backlog input \"new\"");
			System.out.println("To access you existing backlog input \"get\"");
			System.out.println("To save your backlog in progress and go back to WHITEBOARDMENU inpu \"done\"");
			
			String userInput = backlogScanner();
			
			if (userInput.equals(newBacklogOption)) {
				addPbItem();
			} else if (userInput.equals(getBacklogOption)) {
				drawAllPbItem();
			} else if (userInput.equals(doneBacklogOption)){
				addBacklogToMyBacklogs(MyPbItems);
				exit = true;
			} else {
				System.out.println("Your input did not match our menu options");
			}
		}
	}

	private void addBacklogToMyBacklogs(Object o) {
		
	}

	public void addPbItem() {

		PbItem pbitem = new PbItem();
		
		System.out.print("NAME: ");
		pbitem.name = backlogScanner();

		System.out.print("\nDESCRIPTION: ");
		pbitem.description = backlogScanner();

		System.out.print("EST: ");
		pbitem.est = intAllowed();

		System.out.print("PRIO: ");
		pbitem.prio = intAllowed();

		

		// Saving item in current opened backlog
		sendPBItemToDB(pbitem);

	}

	public void sendPBItemToDB(PbItem pbitem) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
										"INSERT INTO PBItems (	PBItemName, " +
																"PBItemDescription, " +
																"PBItemEST," +
																"PBItemPrio," +
																"PBItemBacklogId) " +
										"VALUES (?, ?, ?, ?, ?)"
											);
			s.setString(1, pbitem.name);
			s.setString(2, pbitem.description);
			s.setInt(3, pbitem.est);
			s.setInt(4, pbitem.prio);
			
			
			s.executeUpdate();
			
			s.close();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public void drawPbItem(PbItem pbitem) {
		
		
		
			System.out.print("\nID: " + pbitem.dbid);
			System.out.print(" NAME: " + pbitem.name);
			System.out.println("\nDESCRIPTION:\n "
					+ pbitem.description);
			System.out.print("\nEST: " + pbitem.est);
			System.out.print("      PRIO: " + pbitem.prio);

			System.out.println("\n---");	
	}

	public String backlogScanner() {
		String string = " ";
		Scanner scanner = new Scanner(System.in);
		string = scanner.nextLine();
		return string;
	}

}

//}
