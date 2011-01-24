package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DrawBacklogs implements Command {

	public void draw() {
		System.out.println("drawed");
		// TODO Auto-generated method stub
	}

	@Override
	public void execute() {
		ArrayList<Backlog> list = BacklogDAO.getAllBacklogsFromDB();
		UserClient.drawBacklog(list);


	}
}