package se.kyh.ad10s.scrumapp;



public class ScrumApp {

	public static void main(String[] args) {

		Sprint sprint = new Sprint();
		sprint.sprintid = 1;
		sprint.startDate.set(2011, 9, 20);
		sprint.endDate.set(2011, 11, 15);
		BurndownChart chart = new BurndownChart(sprint);
		
		System.out.println(chart.totalSprintDays);
	}

}
