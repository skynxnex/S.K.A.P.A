package se.kyh.ad10s.scrumapp;

import java.util.HashMap;

import se.kyh.ad10s.scrumapp.concretecommand.ChooseBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.CreateBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.DrawBacklogs;

//import se.kyh.command.Command;
//import se.kyh.command.WhiteboardAddPbItem;

//INVOKER
public class WhiteboardInvoker {
	public static HashMap<String, Command> hm = new HashMap<String, Command>();

	public static void createStartMenuHashMap() {

		hm.put("VIEW", new DrawBacklogs());
		hm.put("CREATE", new CreateBacklog());
		hm.put("DELETE", new DeleteBacklog());
		hm.put("view", new DrawBacklogs());
		hm.put("create", new CreateBacklog());
		hm.put("delete", new DeleteBacklog());
		hm.put("CHOOSE", new ChooseBacklog());
		hm.put("choose", new ChooseBacklog());

	}



}