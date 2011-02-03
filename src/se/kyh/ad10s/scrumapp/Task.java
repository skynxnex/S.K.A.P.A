package se.kyh.ad10s.scrumapp;

import java.util.Calendar;

public class Task extends Item{
	
	public int taskPBItemId;
	public String taskCheckoutName;
	public Calendar taskCheckoutDate = Calendar.getInstance();
	public boolean taskdone;
	
	public static int TaskPBItemId;
	//Constructor that gets a PbItemid when a Taskobjekt is created in a Sprint. 
	//Will probably be written as a element in the ()
	public Task(){
		
	}

}