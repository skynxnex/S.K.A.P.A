package se.kyh.ad10s.scrumapp;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;

public class BurndownChart {

	int totalSprintEst;
	int totalSprintDays;
	int xNow;
	int yNow;
	int restSprintEst;
	int sprintId;
	Calendar startDate;
	Calendar endDate;

	public BurndownChart(Sprint sprint) {
		this.sprintId = sprint.sprintid;
		getTotalEst();
		this.startDate = sprint.startDate;
		this.endDate = sprint.endDate;
		totalSprintDays = getTotalDays(endDate, startDate);

	}

	// y-streck.hämta den totala sprintest. Genom att lägga ihop alla est från
	// sprintobjekten
	private void getTotalEst() {
		int listLength = 0;
		ArrayList<PbItem> list = new ArrayList<PbItem>();
		list = (ArrayList<PbItem>) SprintDAO.getAllItemsInSprint(sprintId);
		listLength = list.size();
		for (int i = 0; i < listLength; i++) {
			totalSprintEst += list.get(i).est;
		}
	}

	// x-streck.Räkna ut hur många dagar det är i en sprint
	private int getTotalDays(Calendar t1, Calendar t2) {
		{
			int ndays = 0;
			int n;
			if (t1.get(t1.YEAR) < t2.get(t2.YEAR)) {
				ndays += (366 - t1.get(t1.DAY_OF_YEAR));
				for (n = t2.get(t1.YEAR) + 1; n <= t2.get(t2.YEAR) - 1; n++) {
					ndays += 365;
				}
			}
			ndays += t2.get(t2.DAY_OF_YEAR);
			if (t2.get(t2.YEAR) == t1.get(t1.YEAR)) {
				ndays = t1.get(t1.DAY_OF_YEAR) - t2.get(t2.DAY_OF_YEAR);
			}
			return ndays;
		}

	}
	 public int startDateToNow(Calendar f2){     
	    int ndays = 0;
		 Calendar tmpDate1 = Calendar.getInstance(); 
	    Calendar tmpDate2 = Calendar.getInstance(); 
	    Calendar cal = Calendar.getInstance();
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//	    int days_elapsed = 0;     
//
	    tmpDate1.set(format.format(cal.getTimeInMillis())); 
//	     
//	    tmpDate2.set(f2.YEAR, f2.MONTH, f2.DAY_OF_MONTH);             
//	     
//	    days_elapsed = getTotalDays(tmpDate2, tmpDate1); 
//
//	    if (days_elapsed < 1) 
//	      days_elapsed = 0; 
//	       
//	    return days_elapsed; 
//	  }
//	 private Date StrToDate(String f) 
//	  //  Convert a StRING to DATE, 
//	  //  the String format would be 
//	  //  "yyyy-MM-ddd" but not necessary 
//	  { 
//	    Date dFecha = new Date();   
//	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
//	         
//	    try 
//	    { 
//	    dFecha = (Date) format.parse(f); 
//	    } 
//	    catch(ParseException e) 
//	    { 
//	      return dFecha; 
//	    } 
//	     
//	    return dFecha; 
//	  } 
//	   
//	  public double getNo_Days() 
//	  { 
//	      return no_of_days; 
//	  } 
//	}
	// hämta antalet doneitems med ett specifikt donedatum för att kunna sätta
	// yNow
	// yNow.totalSprintEst - doneEst = Var skall nästa slutpunkten ligga (blir
	// startpunkter för nästa streck)
	// xNow. Sista sprintdatum - dagensdatum = antaldagar vi hunnit.

}
