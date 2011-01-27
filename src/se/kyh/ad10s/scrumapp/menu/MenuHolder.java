package se.kyh.ad10s.scrumapp.menu;

public class MenuHolder {

	public static void startMenu() {
		StartMenu startMenu = new StartMenu();
		BacklogMenu backlogMenu = new BacklogMenu();
		startMenu.menu();
		backlogMenu.menu();
		//TODO While running
	}

}
