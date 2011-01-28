package se.kyh.ad10s.scrumapp.concretecommand;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class DrawOneItemInCurrentBacklog implements Command {

	@Override
	public void execute() {
		Backlog bl = new Backlog();
		bl.blid = UserClient.SelectedBacklog;
		ArrayList<PbItem> itemsArray = BacklogDAO.getAllPbItemsFromBacklog(bl);
		UserClient.drawAllItemsIdAndName(itemsArray);
		int userInputSelectedItemId = ClientInputs.intAllowed("Input the ID of the ITEM that you want to view");
		if (UserClient.compareUserRequsestToItemIds(itemsArray,
				userInputSelectedItemId)){
			int confirmedId = userInputSelectedItemId;
		UserClient.drawOneItem(PbItemDAO.getPbItemFromDB(confirmedId));
		}else {
			System.out.println("Your input did not match an ITEM ID.\n");
		}

	}

}
