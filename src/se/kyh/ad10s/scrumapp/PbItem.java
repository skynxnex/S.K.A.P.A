package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;

public class PbItem extends Item{
	
	//Knows its backlog - Oh but why?
	int BacklogId;
	
	//I PbItem kan du också hålla Tasks i en array
	ArrayList<Task> MyTasks = new ArrayList<Task>();
	
	//Tasksobjekt hämtas när ett nytt PbItem skapas i Whiteboard
	//Lägg in Task-objekt i arrayen MyTasks
	public void saveTask(Task myTask){
		MyTasks.add(myTask);
	}

}
