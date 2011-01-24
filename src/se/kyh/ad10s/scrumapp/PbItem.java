package se.kyh.ad10s.scrumapp;
//This is the class for PbItems that inherits from the superclass Item
//The PbItem holds tasks created from it
//It knows what Backlog it belongs to


import java.util.ArrayList;

public class PbItem extends Item{
	
	//Knows its backlog - Oh but why?
	int BacklogId;
	public int SprintId;
	
	//An array that holds Taskobjekts
	//Will eventually be replaced by a DB.
	ArrayList<Task> MyTasks = new ArrayList<Task>();

	
	
	//Gets Taskobjekts when called
	//Saves it in the arraylist. Eventually to a DB:
	public void saveTask(Task myTask){
		MyTasks.add(myTask);
	}

}
