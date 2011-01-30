package src.se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.DAOs.TaskDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;

public class CheckoutTask implements Command {
	
	@Override
	public void execute() {
		int taskId = ClientInputs.intAllowed("Input TASK ID you want to checkout: ");
		task = TaskDAO.getTaskFromDB(int taskId);
		String taskOwnerName = ClitentInputs.getInput("Input your name: ")
		TaskDAO.checkoutTask(taskOwnerName, task);

	}

}
