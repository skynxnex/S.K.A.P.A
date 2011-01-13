package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;

public class Backlog {
	
	//skapa en array som kan ta emot PbItemsobjekt
	ArrayList<PbItem> MyPbItems = new ArrayList<PbItem>();
	
	
	//method som kan hämta ett PbItemobjekt.
	// som lägg detta objekt i arrayen. 
//	För tillfället från StartClass
	public void savePbItem(PbItem o){
		MyPbItems.add(o);
	}
	
	

	
	
	

}
