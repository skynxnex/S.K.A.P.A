package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class ChooseBacklog implements Command {
	ArrayList<Backlog> list = BacklogDAO.getAllBacklogsFromDB();
	int userInputSelectedBacklog;

	@Override
	public void execute() {
		UserClient.drawAllBacklogIdAndName(list);

		int userInputSelectedBacklog = ClientInputs
				.intAllowed("\nEnter backlog id to access: ");

		if (UserClient.compareUserRequsestToBacklogIds(list,
				userInputSelectedBacklog)) {
			UserClient.SelectedBacklog = userInputSelectedBacklog;
			UserClient.userInStartMenu = false;
			UserClient.userInBacklogMenu = true;
		} else {
			System.out.println("Your input did not match an Backlog ID.\n");
		}

	}

}
