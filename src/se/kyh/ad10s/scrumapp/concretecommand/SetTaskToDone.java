package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.Task;
import se.kyh.ad10s.scrumapp.DAOs.TaskDAO;
import se.kyh.ad10s.scrumapp.menu.ClientInputs;

public class SetTaskToDone implements Command {

	@Override
	public void execute() {
		Task task = new Task();
		int taskId = ClientInputs.intAllowed("Input TASK ID you want to set as DONE: ");
		task = TaskDAO.getTaskFromDB(taskId);
		TaskDAO.setTaskToDone(task);
		PbItem pbitem = new PbItem();
		pbitem.checkPbItemDone(task);
		//leave me alone git
	}

}
