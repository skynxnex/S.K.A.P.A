package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;

public class DrawCurrentBacklogItems implements Command {

	@Override
	public void execute() {
		System.out.println("Here comes the list on all the backlogitems in your selected backlog.");
//		ArrayList<Backlog> list = BacklogDAO.getAllBacklogsFromDB();
//		UserClient.drawCurrentBacklogItems(list);

	}

}
