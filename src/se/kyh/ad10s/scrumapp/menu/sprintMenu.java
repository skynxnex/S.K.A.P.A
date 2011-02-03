package se.kyh.ad10s.scrumapp.menu;

import se.kyh.ad10s.scrumapp.WhiteboardInvoker;

public class sprintMenu {

	public static void menu() {
		while (UserClient.userInSprintMenu) {
			UserClient.sprintMenuWelcome();
			WhiteboardInvoker.createSprintMenuHashMap();
			UserClient.executeUserInput();
		}
	}
}
