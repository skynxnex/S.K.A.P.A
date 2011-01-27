package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DrawBacklogs implements Command {


	@Override
	public void execute() {
		ArrayList<Backlog> list = BacklogDAO.getAllBacklogsFromDB();
		UserClient.drawAllBacklogs(list);

	}
}