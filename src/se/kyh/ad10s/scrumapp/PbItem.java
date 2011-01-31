package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;
import java.util.Calendar;

import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
//This is the class for PbItems that inherits from the superclass Item
//The PbItem holds tasks created from it
//It knows what Backlog it belongs to

public class PbItem extends Item {

	public int BacklogId;
	public int pBItemSprintId;
	public Calendar PbItemDoneDate = Calendar.getInstance();

	public PbItem() {

	}

	public void checkPbItemDone(Task task) {
		if (PbItemDAO.getAllTasksInPbItemDone(task.taskPBItemId)) {
			PbItemDAO.setPbItemToDone(task.taskPBItemId);
		}

	}

	// METHOD som kollar om ett alla tasks kopplat till ett pbitem är done, då
	// sätts
	// den tilll done, return eller skickamed parakmetrar
	// query = get * from tasks where TaskDone = false && TaskPBItemId =

	// om sätt pbitem till done

}
