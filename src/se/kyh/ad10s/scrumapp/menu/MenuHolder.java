package se.kyh.ad10s.scrumapp.menu;

public class MenuHolder {

	public static void startMenu() {
		StartMenu startMenu = new StartMenu();
		BacklogMenu backlogMenu = new BacklogMenu();
		BacklogItemMenu backlogItemMenu = new BacklogItemMenu();
		startMenu.menu();
		backlogMenu.menu();
		backlogItemMenu.menu();
		//TODO While running
	}

}