package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;

public class RemoveItemFromSprint implements Command {

	@Override
	public void execute() {
		System.out.println("LISTNING SAKNAS");
		int id = ClientInputs.intAllowed("input ITEM id to DELETE from SPRINT");
		SprintDAO.removeItemFromSprintBacklog(id);
	}

}
