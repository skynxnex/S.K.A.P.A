package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.Task;
import se.kyh.ad10s.scrumapp.DAOs.TaskDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
/**
 * Executes checkoutTask-method in TaskDAO.java by
 * sending name and taskobject to it.
 */
public class CheckoutTask implements Command {
	

	@Override
	public void execute() {
		Task task = new Task();
		int taskId = ClientInputs.intAllowed("Input TASK ID you want to checkout: ");
		task = TaskDAO.getTaskFromDB(taskId);
		String taskOwnerName = ClientInputs.getInput("Input your name: ");
		TaskDAO.checkoutTask(taskOwnerName, task);

	}

}
