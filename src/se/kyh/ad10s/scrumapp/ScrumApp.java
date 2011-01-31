package se.kyh.ad10s.scrumapp;


import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.DAOs.TaskDAO;

public class ScrumApp {

	public static void main(String[] args) {
	PbItem pbitem = new PbItem();
	Task task = new Task();
	task = TaskDAO.getTaskFromDB(1);
	pbitem = PbItemDAO.getPbItemFromDB(1);
	pbitem.checkPbItemDone(task);

	}

}
