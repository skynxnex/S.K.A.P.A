package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;
import java.util.Calendar;

import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;

public class BurndownChart {

	private int totalSprintEst;
	private int totalSprintDays;
	private int xNow;
	private int yNow;
	private int restSprintEst;
	private int sprintId;
	private Calendar startDate;
	private Calendar endDate;
	private Calendar now;

	public BurndownChart(Sprint sprint) {
		this.sprintId = sprint.sprintid;
		getTotalEst();
		this.startDate = sprint.startDate;
		this.endDate = sprint.endDate;
		totalSprintDays = getTotalDays(endDate, startDate);
		// when all data is collected, drawChart();
	}

	// y-streck.hämta den totala sprintESTt. Genom att lägga ihop alla est från
	// sprintobjekten
	private void getTotalEst() {
		int listLength = 0;
		ArrayList<PbItem> list = new ArrayList<PbItem>();
		list = (ArrayList<PbItem>) SprintDAO.getAllItemsInSprint(sprintId);
		listLength = list.size();
		for (int i = 0; i < listLength; i++) {
			this.totalSprintEst += list.get(i).est;
		}
	}

	// x-streck.Räkna ut hur många dagar det är i en sprint
	private int getTotalDays(Calendar t1, Calendar t2)
	// Calculate the number of days between TWO dates.
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

	private int startDateToNow(Calendar f2) {
		int ndays = 0;
		now.getTime();
		getTotalDays(startDate, now);
		return ndays;
	}

	public void print() {
		System.out.println(totalSprintDays);
		System.out.println(totalSprintEst);
	}
	// hämta antalet doneitems med ett specifikt donedatum för att kunna sätta
	// yNow
	// yNow.totalSprintEst - doneEst = Var skall nästa slutpunkten ligga (blir
	// startpunkter för nästa streck)
	// xNow. Sista sprintdatum - dagensdatum = antaldagar vi hunnit.

}