package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class toStartMenu implements Command {

	@Override
	public void execute() {

		UserClient.userInStartMenu = true;
		UserClient.userInBacklogMenu = false;

	}

}
