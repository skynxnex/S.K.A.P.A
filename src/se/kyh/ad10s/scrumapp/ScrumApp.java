package se.kyh.ad10s.scrumapp;

import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.DAOs.BacklogDAO;
import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;

public class ScrumApp {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list = SprintDAO.getAllPbItemsFromDBWithNoSprint(2);
		System.out.println(list);
	}

}
