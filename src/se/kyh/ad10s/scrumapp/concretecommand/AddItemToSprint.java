package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class AddItemToSprint implements Command {

	@Override
	public void execute() {
//		Backlog bl = new Backlog();
//		bl.blid = UserClient.SelectedBacklog;
		int blid = UserClient.SelectedBacklog;
		ArrayList<PbItem> itemsArray = SprintDAO.getAllPbItemsFromDBWithNoSprint(blid);
		UserClient.drawAllItemsIdAndName(itemsArray);
		
		int userInputSelectedItemId = ClientInputs
				.intAllowed("\nEnter ITEM ID to ADD to SPRINT: ");
		
		if (UserClient.compareUserRequsestToItemIds(itemsArray,
				userInputSelectedItemId)) {
			PbItem pbitem = PbItemDAO.getPbItemFromDB(userInputSelectedItemId);
			int sprintid = UserClient.SelectedSprint;
			SprintDAO.addItemToSprintBacklog(pbitem, sprintid);
		} else {
			System.out.println("Your input did not match an ITEM ID.\n");
		}

	}

}
