package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DeleteBacklogItem implements Command {

	@Override
	public void execute() {
		//SHOULD MAYBE BE AN OWN CLASS
		Backlog bl = new Backlog();
		bl.blid = UserClient.SelectedBacklog;
		ArrayList<PbItem> itemsArray = BacklogDAO.getAllPbItemsFromBacklog(bl);
		UserClient.drawAllItemsIdAndName(itemsArray);
		//END OF OWN CLASS MAYBE AN SHOULD
		
		int pbId = ClientInputs.intAllowed("\nEnter backlog id to delete:");
		PbItemDAO.deletePbItemFromDB(pbId);
	}

}
