package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.Sprint;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class AccessSprint implements Command {
	int userInputSelectedSprint;

	ArrayList<Sprint> sprintlist = SprintDAO
			.getAllSprints(UserClient.SelectedBacklog);

	@Override
	public void execute() {
		UserClient.drawAllSprintsIdAndName(sprintlist);

		userInputSelectedSprint = ClientInputs
				.intAllowed("\nEnter sprint id to access: ");

		if (UserClient.compareUserRequsestToSprintIds(sprintlist,
				userInputSelectedSprint)) {
			UserClient.SelectedSprint = userInputSelectedSprint;
			UserClient.userInStartMenu = false;
			UserClient.userInBacklogMenu = false;
			UserClient.userInSprintMenu = true;
		} else {
			System.out.println("Your input did not match an sprint ID.\n");
		}

	}

}
