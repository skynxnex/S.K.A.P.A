package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class ChooseBacklogItem implements Command {

	@Override
	public void execute() {
		Backlog bl = new Backlog();
		bl.blid = UserClient.SelectedBacklog;
		ArrayList<PbItem> itemsArray = BacklogDAO.getAllPbItemsFromBacklog(bl);
		UserClient.drawAllItemsIdAndName(itemsArray);
		
		int userInputSelectedItemId = ClientInputs.intAllowed("\nEnter ITEM ID to access: ");
		if (UserClient.compareUserRequsestToItemIds(itemsArray,
				userInputSelectedItemId)){
			UserClient.SelectedBacklogItem = userInputSelectedItemId;
			UserClient.userInStartMenu = false;
			UserClient.userInBacklogMenu = false;
			UserClient.userInBacklogItemMenu = true;
		}else {
			System.out.println("Your input did not match an ITEM ID.\n");
		}

	}

}
