package se.kyh.ad10s.scrumapp.menu;

import se.kyh.ad10s.scrumapp.WhiteboardInvoker;

public class BacklogMenu {
	public void menu() {
		while (UserClient.userInBacklogMenu) {
			UserClient.backlogMenuWelcome();
			WhiteboardInvoker.createBacklogMenuHashMap();
			UserClient.executeUserInput();
			
		}
	}
}
