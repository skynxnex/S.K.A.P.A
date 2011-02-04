package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class toBacklogMenu implements Command {

	@Override
	public void execute() {
		UserClient.userInBacklogMenu = true;
		UserClient.userInBacklogItemMenu = false;
		UserClient.userInSprintMenu = false;
	}

}
