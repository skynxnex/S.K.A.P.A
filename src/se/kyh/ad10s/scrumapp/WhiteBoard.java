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

		System.out.println("----------------8<-------------[ PBI creator v0.1 ]------------------");
		System.out.print("\nPlease input an ID(int): ");

		pbitem.dbid = intAllowed();
		
		System.out.print("\nPlease input an EST(int): ");
		
		pbitem.est = intAllowed();
		
		System.out.print("\nPlease input a PRIO(int): ");
		
		pbitem.prio = intAllowed();
		
		System.out.print("\nPlease input a NAME(string): ");
		
		pbitem.name = receiveInput();
		
		System.out.print("\nPlease input a DESCRIPTION(string). ");
		
		pbitem.description = receiveInput();
		
		backlog.savePbItem(pbitem);

	}

	public void drawAllPbItem() {
		int myPbItemSize = backlog.MyPbItems.size();
		for (int i = 0; i < myPbItemSize; i++) {

			// System.out.println(backlog.MyPbItems.get(i));
			System.out.println("---");
			System.out.println("\nID: " +backlog.MyPbItems.get(i).dbid);
			System.out.println("\nNAME: " +backlog.MyPbItems.get(i).name);
			System.out.println("DESCRIPTION: " +backlog.MyPbItems.get(i).description);
			System.out.print("\nEST: " +backlog.MyPbItems.get(i).est);
			System.out.print("      PRIO: " +backlog.MyPbItems.get(i).prio);

			System.out.println("\n---");
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
