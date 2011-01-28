package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.Task;
import se.kyh.ad10s.scrumapp.DAOs.TaskDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;
import se.kyh.ad10s.scrumapp.menu.UserClient;

public class CreateNewTask implements Command {

	@Override
	public void execute() {
		Task task = new Task();
		task.name = ClientInputs.getInput("NAME: ");
		task.description = ClientInputs.getInput("DESCRIPTION: ");
		task.est = ClientInputs.intAllowed("EST: ");
		task.prio = ClientInputs.intAllowed("PRIO: ");
		task.taskPBItemId = UserClient.SelectedBacklogItem;
		TaskDAO.sendTaskToDB(task);

	}

}
