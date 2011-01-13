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
	// frågar vad vi vill göra
	// skickar våra inputs
	// till passande platser

}
