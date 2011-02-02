package se.kyh.ad10s.scrumapp;


import se.kyh.ad10s.scrumapp.DAOs.PbItemDAO;
import se.kyh.ad10s.scrumapp.DAOs.SprintDAO;
import se.kyh.ad10s.scrumapp.DAOs.TaskDAO;
import se.kyh.ad10s.scrumapp.concretecommand.ChooseBacklog;
import se.kyh.ad10s.scrumapp.menu.StartMenu;

public class ScrumApp {

	public static void main(String[] args) {
	StartMenu menu = new StartMenu();
	menu.menu();

	}

}
