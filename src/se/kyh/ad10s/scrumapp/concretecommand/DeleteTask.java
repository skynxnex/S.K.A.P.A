package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.TaskDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;

public class DeleteTask implements Command {

	@Override
	public void execute() {
		System.out.println("MISSING LIST WITH ALL TASKS IN CURRENT ITEM");
		int taskId = ClientInputs.intAllowed("Input TASK ID to delete: ");
		TaskDAO.deleteTaskFromDB(taskId);

	}

}
