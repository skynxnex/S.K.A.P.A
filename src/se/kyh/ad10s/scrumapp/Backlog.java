package se.kyh.ad10s.scrumapp;
// This is the class for a Backlog
// Here you save your PbItem-objekt in an Arraylist,
// that eventually going to be a DB. 
//
import java.util.ArrayList;

public class Backlog {
	//An array that holds PbItemobjekts. Eventually replaced by a DB.
	ArrayList<PbItem> MyPbItems = new ArrayList<PbItem>();
	
	
	//method that gets PbItemobjekt from Whiteboard and save it in the arraylist
	// Eventually to a DB.
	public void savePbItem(PbItem pbitem){
		MyPbItems.add(pbitem);
	}
	
	
}
