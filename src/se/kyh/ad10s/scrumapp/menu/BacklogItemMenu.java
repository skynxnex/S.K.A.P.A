package se.kyh.ad10s.scrumapp.menu;

import se.kyh.ad10s.scrumapp.WhiteboardInvoker;

public class BacklogItemMenu {

	public void menu() {
		while (UserClient.userInBacklogItemMenu) {
			UserClient.backlogItemMenuWelcome();
			WhiteboardInvoker.createBacklogItemMenuHashMap();
			UserClient.executeUserInput();
		}

	}

}
