package se.kyh.ad10s.scrumapp;


public class StartClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WhiteBoard whiteboard = new WhiteBoard();

		while (true) {

			whiteboard.addPbItem();
			
			whiteboard.drawAllPbItem();

		}

	}

	// new nav-class
	// fr�gar vad vi vill g�ra
	// skickar v�ra inputs
	// till passande platser

}
