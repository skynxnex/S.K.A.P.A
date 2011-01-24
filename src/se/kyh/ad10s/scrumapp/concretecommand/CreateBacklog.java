package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class CreateBacklog implements Command {
	String backlogName;
	String backlogDescription;

	@Override
	public void execute() {
//		backlogObject backlogObject = UserClient.userCreateNewBacklogObject();
//		int CreatedBacklogId = BacklogDAO.createNewBacklog(backlogName, backlogDescription);
	}

}
