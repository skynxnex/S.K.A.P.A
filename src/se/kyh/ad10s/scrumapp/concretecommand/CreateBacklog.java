package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;

public class CreateBacklog implements Command {
	String backlogName;
	String backlogDescription;

	@Override
	public void execute() {
		backlogName = ClientInputs.getInput("backlog name:");
		backlogDescription = ClientInputs.getInput("Backlog Description:");
		Backlog bl = new Backlog();
		bl.backlogName = backlogName;
		bl.backlogDescription = backlogDescription;
		bl = BacklogDAO.createNewBacklog(bl);
		System.out.println("\nCreated backlog with id " + bl.blid + "\n");
//		UserClient.userCreateNewBacklogObject();
//		backlogObject backlogObject = UserClient.userCreateNewBacklogObject();
//		int CreatedBacklogId = BacklogDAO.createNewBacklog(backlogName, backlogDescription);
	}

}
