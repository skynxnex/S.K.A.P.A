package se.kyh.ad10s.scrumapp;

import java.util.HashMap;

import se.kyh.ad10s.scrumapp.concretecommand.CreateBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.DrawBacklogs;

//import se.kyh.command.Command;
//import se.kyh.command.WhiteboardAddPbItem;

//INVOKER
public class WhiteboardInvoker {
	public static HashMap<String, Command> hm = new HashMap<String, Command>();

	public static void createStartMenuHashMap() {

		hm.put("1", new DrawBacklogs());
		hm.put("2", new CreateBacklog());
		hm.put("3", new DeleteBacklog());

	}



}