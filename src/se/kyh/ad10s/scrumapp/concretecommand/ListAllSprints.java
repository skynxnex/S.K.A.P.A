package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.Sprint;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class ListAllSprints implements Command {

	ArrayList<Sprint> sprintlist = SprintDAO
			.getAllSprints(UserClient.SelectedBacklog);

	@Override
	public void execute() {
		UserClient.drawAllSprintsIdAndName(sprintlist);

	}

}
