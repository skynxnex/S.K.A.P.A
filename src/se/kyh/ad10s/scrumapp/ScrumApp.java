package se.kyh.ad10s.scrumapp;


import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;

public class ScrumApp {

	public static void main(String[] args) {

		Sprint sprint = SprintDAO.getSprintFromDB(1);
		BurndownChart brc = new BurndownChart(sprint);
		//brc.print();
	}
}
