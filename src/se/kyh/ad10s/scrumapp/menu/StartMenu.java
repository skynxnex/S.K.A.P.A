package se.kyh.ad10s.scrumapp.menu;

import se.kyh.ad10s.scrumapp.WhiteboardInvoker;

public class StartMenu {

	public void menu() {
		
		while (UserClient.userInStartMenu) {
			UserClient.startMenuWelcome();
			//List menuoptions (static or dynamic) from startmenuhashmap or from static list
			WhiteboardInvoker.createStartMenuHashMap();
			UserClient.drawCurrentHashMap();
			UserClient.userInput();
		}
		
	}

}
