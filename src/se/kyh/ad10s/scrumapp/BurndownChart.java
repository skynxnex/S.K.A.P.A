package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;
import java.util.Calendar;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;

public class BurndownChart {

	private int totalSprintEst;
	private int totalSprintDays;
	private double yNow;
	private int restSprintEst;
	private int sprintId;
	private Calendar startDate;
	private Calendar endDate;
	private Calendar now = Calendar.getInstance();
	private int startDaysToNow;
	private ArrayList<PbItem> list = new ArrayList<PbItem>();

	public void DrawBurndownChart(Sprint sprint) {
		this.sprintId = sprint.sprintid;
		this.startDate = sprint.startDate;
		this.endDate = sprint.endDate;
		this.list = (ArrayList<PbItem>) SprintDAO.getAllItemsInSprint(sprintId);
		getObjectValues();
		drawChart();
	}

	private void drawChart() {
		XYDataset dataset = setSeries();
		JFreeChart chart = ChartFactory.createXYLineChart("Burndown Chart",
				"Day", "EST", dataset, PlotOrientation.VERTICAL, true, true,
				false);
		ChartFrame frame1 = new ChartFrame("S.K.A.P.A. Sprint: " + sprintId,
				chart);
		frame1.setVisible(true);
		frame1.setSize(600, 600);
	}

	private XYSeries setEstimatedBurndownSeries() {
		XYSeries total = new XYSeries("Estimated Burndown");
		double yMinus = (double) totalSprintEst / (double) totalSprintDays;
		yNow = totalSprintEst;
		total.add(0, yNow);
		for (int i = 1; i <= totalSprintDays; i++) {
			yNow -= yMinus;
			total.add(i, yNow);
		}
		return total;
	}

	private XYSeries setRealBurndownSeries() {
		XYSeries pb = new XYSeries("Real Burndown");
		if (startDaysToNow > totalSprintDays) {
			startDaysToNow = totalSprintDays;
		}
		int listlength = list.size();
		int listyear, listmonth, listday;
		int pbyear, pbmonth, pbday;
		Calendar thisdate = startDate;
		for (int i = 0; i < startDaysToNow; i++) {
			pbyear = thisdate.get(Calendar.YEAR);
			pbmonth = thisdate.get(Calendar.MONTH);
			pbday = thisdate.get(Calendar.DAY_OF_MONTH);
			for (int a = 0; a < listlength; a++) {
				listyear = list.get(a).PbItemDoneDate.get(Calendar.YEAR);
				listmonth = list.get(a).PbItemDoneDate.get(Calendar.MONTH);
				listday = list.get(a).PbItemDoneDate.get(Calendar.DAY_OF_MONTH);
				if (listyear == pbyear && listmonth == pbmonth
						&& listday == pbday) {
					restSprintEst -= list.get(a).est;
				}
			}
			pb.add(i, restSprintEst);
			thisdate.add(Calendar.DAY_OF_MONTH, 1);
		}
		return pb;
	}

	private XYDataset setSeries() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(setEstimatedBurndownSeries());
		dataset.addSeries(setRealBurndownSeries());
		return dataset;
	}

	private void getObjectValues() {
		restSprintEst = getTotalEst();
		totalSprintEst = getTotalEst();
		now.getTime();
		totalSprintDays = getTotalDays(endDate, startDate);
		startDaysToNow = getTotalDays(now, startDate);
	}

	private int getTotalEst() {
		int listLength = 0;
		int totalEST = 0;
		listLength = list.size();
		for (int i = 0; i < listLength; i++) {
			totalEST += list.get(i).est;
		}
		return totalEST;
	}

	private int getTotalDays(Calendar t1, Calendar t2) {
		int n, ndays = 0;
		if (t1.get(Calendar.YEAR) < t2.get(Calendar.YEAR)) {
			ndays += (366 - t1.get(Calendar.DAY_OF_YEAR));
			for (n = t2.get(Calendar.YEAR) + 1; n <= t2.get(Calendar.YEAR) - 1; n++) {
				ndays += 365;
			}
		}
		ndays += t2.get(Calendar.DAY_OF_YEAR);
		if (t2.get(Calendar.YEAR) == t1.get(Calendar.YEAR)) {
			ndays = t1.get(Calendar.DAY_OF_YEAR) - t2.get(Calendar.DAY_OF_YEAR);
		}
		return ndays;
	}
}