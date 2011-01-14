package se.kyh.ad10s.scrumapp;
// This is the "Whiteboard".
// You communicate thru a scanner what you want to see.
// In this class you can create or chose a backlog with PbItems and
// a Sprint in witch you can chose your PbItems and create Tasks from them 

import java.util.Scanner;

public class WhiteBoard {
	Backlog backlog;

	public WhiteBoard() {
		backlog = new Backlog();
	}

	public void addPbItem() {

		PbItem pbitem = new PbItem();

		System.out
				.println("\nYou are on your way to create a brand new Product Backlog Item.");
		System.out.print("\nPlease input an ID(int): ");

		pbitem.dbid = intAllowed();

		System.out.println(pbitem.dbid);
		// pbitem.prio = keyboard.nextInt();
		// pbitem.est = keyboard.nextInt();
		//
		// System.out.println("\nNu skulle det vara bra med ett namn");
		//
		// pbitem.name = keyboard.next();
		//
		// System.out.println("\nOm du skulle vilja beskriva itemet");
		//
		// pbitem.description = keyboard.next();

		// System.out.println("Du har skapat ett PbItem\n" +
		// "\nNAME: "+pbitem.name +
		// "\nID: "+pbitem.dbid +
		// "\nPRIO: "+pbitem.prio +
		// "\nEST: "+pbitem.est +
		// "\nDESC: " +pbitem.description);
		//
		// System.out.println("OBJEKT ID: "+pbitem);

		// här sparar vi det som vi precis har frågat efter
		backlog.savePbItem(pbitem);

	}

	public void drawAllPbItem() {
		int myPbItemSize = backlog.MyPbItems.size();
		for (int i = 0; i < myPbItemSize; i++) {

			// System.out.println(backlog.MyPbItems.get(i));
			System.out.println(backlog.MyPbItems.get(i).dbid);
		}

	}

	public int intAllowed() {
		int userInt = Integer.parseInt(receiveInput());
		//Lets catch all strings that can not be cast to an int here.
		// if NumberFormatException true ask user for a new int input.
		return userInt;

	}

	private String receiveInput() {
		String string = " ";
		Scanner scanner = new Scanner(System.in);
		string = scanner.nextLine();
		return string;
	}

}
