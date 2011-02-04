package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.BurndownChart;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.Sprint;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DrawBurnDownChart implements Command {

	@Override
	public void execute() {
		BurndownChart brndwnchart = new BurndownChart();
		int sprintid = UserClient.SelectedSprint;
		Sprint sprint = SprintDAO.getSprintFromDB(sprintid);
		brndwnchart.DrawBurndownChart(sprint);
	}

}
