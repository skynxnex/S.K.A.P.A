package se.kyh.ad10s.scrumapp;


import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.DAOs.TaskDAO;
import se.kyh.ad10s.scrumapp.concretecommand.ChooseBacklog;
import se.kyh.ad10s.scrumapp.menu.StartMenu;
import se.kyh.ad10s.scrumapp.menu.MenuHolder;

public class ScrumApp {

	public static void main(String[] args) {
		MenuHolder menuHolder = new MenuHolder();
		MenuHolder.startMenu();
//	PbItem pbitem = new PbItem();
//	Task task = new Task();
//	task = TaskDAO.getTaskFromDB(1);
//	pbitem = PbItemDAO.getPbItemFromDB(1);
//	pbitem.checkPbItemDone(task);

	}

}
