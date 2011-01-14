package se.kyh.ad10s.scrumapp;
//Scrumapplication.java 
//Created by:
//Pontus Alm, Andreas Engström, Konrad Persson, Sebastian Kellgren, Anneli Halld'n
//Under projektname: S.K.A.P.A
//
//This is where the application starts running
//It creates a new Whiteboard and keeps it running
public class StartClass {


	public static void main(String[] args) {
		WhiteBoard whiteboard = new WhiteBoard();

		while (true) {

			whiteboard.addPbItem();

		}

	}

}
