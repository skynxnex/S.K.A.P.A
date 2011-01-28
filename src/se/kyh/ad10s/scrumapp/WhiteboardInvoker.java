package se.kyh.ad10s.scrumapp;

import java.util.HashMap;

import se.kyh.ad10s.scrumapp.concretecommand.ChooseBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.ChooseBacklogItem;
import se.kyh.ad10s.scrumapp.concretecommand.CreateBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.CreateBacklogItem;
import se.kyh.ad10s.scrumapp.concretecommand.CreateNewTask;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteBacklogItem;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteTask;
import se.kyh.ad10s.scrumapp.concretecommand.DrawBacklogs;
import se.kyh.ad10s.scrumapp.concretecommand.DrawCurrentBacklogItems;
import se.kyh.ad10s.scrumapp.concretecommand.DrawOneItemInCurrentBacklog;

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
		// Alternative inputs
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
		hm.put("VIEWALL", new DrawCurrentBacklogItems());
		hm.put("VIEW", new DrawOneItemInCurrentBacklog());
		hm.put("CREATE", new CreateBacklogItem());
		hm.put("DELETE", new DeleteBacklogItem());
		hm.put("CHOOSE", new ChooseBacklogItem());
//		Alternative inputs
		hm.put("viewall", new DrawCurrentBacklogItems());
		hm.put("view", new DrawOneItemInCurrentBacklog());
		hm.put("create", new CreateBacklogItem());
		hm.put("delete", new DeleteBacklogItem());
		hm.put("choose", new ChooseBacklogItem());

		hm.put("Viewall", new DrawCurrentBacklogItems());
		hm.put("View", new DrawOneItemInCurrentBacklog());
		hm.put("Create", new CreateBacklogItem());
		hm.put("Delete", new DeleteBacklogItem());
		hm.put("Choose", new ChooseBacklogItem());

		hm.put("1", new DrawCurrentBacklogItems());
		hm.put("2", new DrawOneItemInCurrentBacklog());
		hm.put("3", new CreateBacklogItem());
		hm.put("4", new DeleteBacklogItem());
		hm.put("5", new ChooseBacklogItem());
	}

	public static void createBacklogItemMenuHashMap() {
		hm.clear();
//		hm.put("ADD", new AddItemToSprint());
//		hm.put("REMOVE", new RemoveItemFromSprint());
		hm.put("CREATE", new CreateNewTask());
		hm.put("DELETE", new DeleteTask());
		
		hm.put("create", new CreateNewTask());
		hm.put("delete", new DeleteTask());
		hm.put("Create", new CreateNewTask());
		hm.put("Delete", new DeleteTask());
		hm.put("3", new CreateNewTask());
		hm.put("4", new DeleteTask());
	}

}