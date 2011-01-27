package se.kyh.ad10s.scrumapp;

import java.util.HashMap;

import se.kyh.ad10s.scrumapp.concretecommand.ChooseBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.CreateBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.CreateBacklogItem;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.DrawBacklogs;
import se.kyh.ad10s.scrumapp.concretecommand.DrawCurrentBacklogItems;

//import se.kyh.command.Command;
//import se.kyh.command.WhiteboardAddPbItem;

//INVOKER
public class WhiteboardInvoker {
	public static HashMap<String, Command> hm = new HashMap<String, Command>();

	public static void createStartMenuHashMap() {
		hm.clear();
		hm.put("VIEW", new DrawBacklogs());
		hm.put("CREATE", new CreateBacklog());
		hm.put("DELETE", new DeleteBacklog());
		hm.put("CHOOSE", new ChooseBacklog());
		hm.put("view", new DrawBacklogs());
		hm.put("create", new CreateBacklog());
		hm.put("delete", new DeleteBacklog());
		hm.put("choose", new ChooseBacklog());
		hm.put("View", new DrawBacklogs());
		hm.put("Create", new CreateBacklog());
		hm.put("Delete", new DeleteBacklog());
		hm.put("Choose", new ChooseBacklog());
		hm.put("1", new DrawBacklogs());
		hm.put("2", new CreateBacklog());
		hm.put("3", new DeleteBacklog());
		hm.put("4", new ChooseBacklog());

	}

	public static void createBacklogMenuHashMap() {
		hm.clear();
		hm.put("VIEW", new DrawCurrentBacklogItems());
		hm.put("CREATE", new CreateBacklogItem());
		hm.put("create", new CreateBacklogItem());
		hm.put("view", new DrawCurrentBacklogItems());
		hm.put("Create", new CreateBacklogItem());
		hm.put("View", new DrawCurrentBacklogItems());
		hm.put("1", new CreateBacklogItem());
		hm.put("2", new DrawCurrentBacklogItems());
	}



}