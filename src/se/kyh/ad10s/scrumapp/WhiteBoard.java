package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;
import java.util.Scanner;

// This is the "Whiteboard".
//Scrumapplication.java 
//Created by:
//Pontus Alm, Andreas Engstr�m, Konrad Persson, Sebastian Kellgren, Anneli Halld'n
//Under projektname: S.K.A.P.A
//
//This is where the application starts running
//It creates a new Whiteboard and keeps it running

// You communicate thru a scanner what you want to see.
// In this class you can create or chose a backlog with PbItems and
// a Sprint in witch you can chose your PbItems and create Tasks from them 

public class WhiteBoard {
	ArrayList<Backlog> MyBacklogs = new ArrayList<Backlog>();

	public void whiteBoardMenu() {
		
		System.out.println("WHITEBOARDMENU:");
		System.out.println(" - To access backlog-menu, input: \"backlog\" ");
//		System.out.println(" - To access a previous created backlog");
		String BacklogMenuOption = "backlog";
//		String SprintMenuOption = "sprint";
		
		
		String userInput = whiteBoardScanner();
		
		if (userInput.equals(BacklogMenuOption)) {
			Backlog backlog = new Backlog();
			saveBacklog(backlog);
			backlog.backlogMenu();
//		} else if(userInput.equals(SprintMenuOption)){
//			Sprint sprint = new Sprint();
//			sprint.sprintMenu();
		} else {
			System.out.println("Your input did not match any of our menu options.");
		}

//		addBacklogToMyBacklogs(backlog);
		
		whiteBoardMenu();
	}

//	private void addBacklogToMyBacklogs(Object o) {
//		MyBacklogs.add(Object o);
//	}

	public String whiteBoardScanner() {
		String string = " ";
		Scanner scanner = new Scanner(System.in);
		string = scanner.nextLine();
		return string;
	}
	
	public void saveBacklog(Backlog backlog) {
		MyBacklogs.add(backlog);
	}
}

// // a method to list all existing sprints
// public void listSprints(){
// Sprint presentSprint = new Sprint;
// }

