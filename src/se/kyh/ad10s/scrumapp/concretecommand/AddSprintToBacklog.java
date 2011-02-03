package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.Calendar;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.Sprint;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class AddSprintToBacklog implements Command {

	@Override
	public void execute() {
		
		Sprint sprint = new Sprint();
		sprint.newSprint();
		

	}

	public static void makeNewSprint(Calendar startDate, Calendar endDate) {
		int blid = UserClient.SelectedBacklog;
		Sprint sprint = new Sprint();
		sprint.startDate = startDate;
		sprint.endDate = endDate;
		SprintDAO.makeNewSprint(sprint, blid);
	}

}
