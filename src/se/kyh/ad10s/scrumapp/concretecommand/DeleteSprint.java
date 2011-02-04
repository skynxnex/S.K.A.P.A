package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.Sprint;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DeleteSprint implements Command {
	int userInputSelectedSprint;
	ArrayList<Sprint> sprintlist = SprintDAO
	.getAllSprints(UserClient.SelectedBacklog);
	@Override
	public void execute() {
		
		UserClient.drawAllSprintsIdAndName(sprintlist);

		userInputSelectedSprint = ClientInputs
				.intAllowed("\nEnter SPRINT ID to DELETE: ");

		if (UserClient.compareUserRequsestToSprintIds(sprintlist,
				userInputSelectedSprint)) {
			int sprintId = userInputSelectedSprint;
			SprintDAO.deleteSprintFromDB(sprintId);
		} else {
			System.out.println("Your input did not match an sprint ID.\n");
		}

	

	}

}
