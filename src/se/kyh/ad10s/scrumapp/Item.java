package se.kyh.ad10s.scrumapp;
//This is the superclass of PbItem and Task
//It is a abstract class that holds the common members
//
public class Item {
	int dbid;
	String name;
	String description;
	int est;
	int prio;
	
	//a constructor to see if its connected 
	public Item(){
		//System.out.println("Hej jag �r klassen Item, du har kallat p� mig.");
	}

}
