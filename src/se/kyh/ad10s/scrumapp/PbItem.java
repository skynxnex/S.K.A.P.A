package se.kyh.ad10s.scrumapp;
//This is the class for PbItems that inherits from the superclass Item
//The PbItem holds tasks created from it
//It knows what Backlog it belongs to


import java.util.ArrayList;
import java.util.Scanner;

public class PbItem extends Item{
	
	public PbItem() {
		
	}
	
	//Knows its backlog - Oh but why?
	int BacklogId;
	int SprintId;
	
	//An array that holds Taskobjekts
	//Will eventually be replaced by a DB.
	ArrayList<Task> MyTasks = new ArrayList<Task>();
	
	public void createNewPbItem() {
		System.out.print("NAME: ");
		this.name = backlogScanner();

		System.out.print("\nDESCRIPTION: ");
		this.description = backlogScanner();

		System.out.print("EST: ");
		this.est = intAllowed();

		System.out.print("PRIO: ");
		this.prio = intAllowed();
		
		this.dbid = DataAccessObject.sendPBItemToDB(this.name, this.description, this.est, this.prio);
	}
	
	//Gets Taskobjekts when called
	//Saves it in the arraylist. Eventually to a DB:
	public void saveTask(Task myTask){
		MyTasks.add(myTask);
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
	
	public String backlogScanner() {
		String string = " ";
		Scanner scanner = new Scanner(System.in);
		string = scanner.nextLine();
		return string;
	}

}
