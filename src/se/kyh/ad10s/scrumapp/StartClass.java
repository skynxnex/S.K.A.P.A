package se.kyh.ad10s.scrumapp;

import java.util.Scanner;

public class StartClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
//		 I den här klassen,
//		skapar vi en while-loop
//		innuti denna while-llop
//		får vi möjligheten att skapa
//		nya backlog-items
//		backlog-items
//		sorteras i en backlog
//		så i våran backlog-class
//		måste vi ha en ???
		
		Backlog backlog = new Backlog();
		
		while (true) {
			Scanner keyboard = new Scanner(System.in);
			
			PbItem pbitem = new PbItem();
			
			System.out.println("\nLets create a new pbi.");
			System.out.print("\nFORMAT: id prio est");
			
			pbitem.dbid = keyboard.nextInt();
			pbitem.prio = keyboard.nextInt();
			pbitem.est = keyboard.nextInt();
			
			System.out.println("\nNu skulle det vara bra med ett namn");
			
			pbitem.name = keyboard.next();
			
			System.out.println("\nOm du skulle vilja beskriva itemet");
			
			pbitem.description = keyboard.next();
			
			System.out.println("Du har skapat ett PbItem\n" +
					"\nNAME: "+pbitem.name +
					"\nID: "+pbitem.dbid +
					"\nPRIO: "+pbitem.prio +
					"\nEST: "+pbitem.est + 
					"\nDESC: " +pbitem.description);
			
			System.out.println("OBJEKT ID: "+pbitem);
			
			bac
			
			
		}
		//new nav-class
		//frågar vad vi vill göra
		//skickar våra inputs
		//till passande platser
		
		
	}

}
