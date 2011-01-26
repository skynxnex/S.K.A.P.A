package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class ChooseBacklog implements Command {
	int choosenBacklog;
	ArrayList<Backlog> list = BacklogDAO.getAllBacklogsFromDB();
	@Override
	public void execute() {
		UserClient.drawAllBacklogIdAndName(list);
		choosenBacklog = UserClient.intAllowed("Enter backlog id to access");
		UserClient.userInStartMenu = false;
		UserClient.userInBacklogMenu = true;
		
	}

}
