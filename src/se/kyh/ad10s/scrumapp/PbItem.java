package se.kyh.ad10s.scrumapp;

import java.util.Calendar;
//This is the class for PbItems that inherits from the superclass Item
//The PbItem holds tasks created from it
//It knows what Backlog it belongs to



public class PbItem extends Item{
	
	public int BacklogId;
	public int pBItemSprintId;
	public Calendar PbItemDoneDate = Calendar.getInstance();
	public PbItem() {
		
	}	
}
