package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class EndProgram implements Command {

	@Override
	public void execute() {
		UserClient.isRunningProgram = false;
		UserClient.userInStartMenu = false;
	}

}
