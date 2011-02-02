package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;


import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.Task;
import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DrawAllTasksForPbItem implements Command{

	@Override
	public void execute() {
		PbItem pbItem = new PbItem();
		pbItem.dbid = UserClient.SelectedBacklogItem;
		ArrayList<Task> list = PbItemDAO.drawAllTasksForPbItem(pbItem);
		UserClient.drawAllTasksForPbItem(list);

		
	}
	

}
