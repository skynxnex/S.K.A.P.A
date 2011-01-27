package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class CreateBacklogItem implements Command {
	int backlogItemId = UserClient.SelectedBacklog;
	ArrayList<Backlog> list = BacklogDAO.getAllBacklogsFromDB();
	
	String BacklogItemName;
	String BacklogItemDescription;
	int est;
	int prio;
	
	@Override
	public void execute() {
		System.out.print("\nYou are creating an item in ");
		System.out.print(UserClient.SelectedBacklog);
		System.out.print("\n");
		PbItem pbitem = new PbItem();
		
		pbitem.BacklogId = backlogItemId;
		pbitem.name = ClientInputs.getInput("Name: ");
		pbitem.description = ClientInputs.getInput("Description: ");
		pbitem.est = ClientInputs.intAllowed("Est: ");
		pbitem.prio = ClientInputs.intAllowed("Prio: ");
		
		PbItemDAO.sendPBItemToDB(pbitem);

	}

}
