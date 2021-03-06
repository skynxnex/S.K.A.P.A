package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DrawCurrentBacklogItems implements Command {

	@Override
	public void execute() {
		Backlog bl = new Backlog();
		bl.blid = UserClient.SelectedBacklog;
		ArrayList<PbItem> itemsArray = BacklogDAO.getAllPbItemsFromBacklog(bl);
		UserClient.drawAllItemsInBacklog(itemsArray);

	}

}
