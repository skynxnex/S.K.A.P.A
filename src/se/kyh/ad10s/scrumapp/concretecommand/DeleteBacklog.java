package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DeleteBacklog implements Command {
	int blid;
	
	@Override
	public void execute() {
		System.out.println("ID to DELETE: ");
		blid = UserClient.intAllowed();
		BacklogDAO.deleteBacklogFromDB(blid);
	}

}
