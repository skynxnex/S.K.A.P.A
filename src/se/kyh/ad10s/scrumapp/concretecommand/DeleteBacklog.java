package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DeleteBacklog implements Command {
	int blid;
	ArrayList<Backlog> list = BacklogDAO.getAllBacklogsFromDB();
	
	@Override
	public void execute() {
		System.out.println("scrumapp:start\\backlog\\delete \n");
		UserClient.drawAllBacklogIdAndName(list);
		blid = ClientInputs.intAllowed("\nEnter backlog id to delete:");
		BacklogDAO.deleteBacklogFromDB(blid);
	}

}
