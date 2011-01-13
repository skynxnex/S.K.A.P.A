package se.kyh.ad10s.scrumapp;

public class Item {
	int dbid;
	String name;
	String description;
	int est;
	int prio;
	
	public Item(){
		//I en constructor skulle vi kunna skapa en loop
		
		//Loopen räknar från id 0++
		
		//för varje varv går vi in i våran databas och hämtar ut data med det id't
		
		//för varje varv skapar vi ett nytt Item av den.
		
		//tills högsta id är nått.
		
		//Så här ska det självklart inte fungera, men det skulle gå.
		
		//System.out.println("Hej jag är klassen Item, du har kallat på mig.");
	}

}
