package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class ListItemsWithoutSprint implements Command {

	@Override
	public void execute() {
		ArrayList<PbItem> list = new ArrayList<PbItem>();
		int blid = UserClient.SelectedBacklog;
		list = SprintDAO.getAllPbItemsFromDBWithNoSprint(blid);
		for (PbItem pbItem : list) {
			System.out.println("[" + pbItem.dbid + ", " + pbItem.name + "]\n");
		}
	}

}
