package se.kyh.ad10s.scrumapp;

import java.util.HashMap;

import se.kyh.ad10s.scrumapp.concretecommand.AccessSprint;
import se.kyh.ad10s.scrumapp.concretecommand.AddItemToSprint;
import se.kyh.ad10s.scrumapp.concretecommand.AddSprintToBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.CheckoutTask;
import se.kyh.ad10s.scrumapp.concretecommand.ChooseBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.ChooseBacklogItem;
import se.kyh.ad10s.scrumapp.concretecommand.CreateBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.CreateBacklogItem;
import se.kyh.ad10s.scrumapp.concretecommand.CreateNewTask;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteBacklogItem;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteSprint;
import se.kyh.ad10s.scrumapp.concretecommand.DeleteTask;
import se.kyh.ad10s.scrumapp.concretecommand.DrawAllTasksForPbItem;
import se.kyh.ad10s.scrumapp.concretecommand.DrawBacklogs;
import se.kyh.ad10s.scrumapp.concretecommand.DrawBurnDownChart;
import se.kyh.ad10s.scrumapp.concretecommand.DrawCurrentBacklogItems;
import se.kyh.ad10s.scrumapp.concretecommand.DrawOneItemInCurrentBacklog;
import se.kyh.ad10s.scrumapp.concretecommand.EndProgram;
import se.kyh.ad10s.scrumapp.concretecommand.ListAllSprints;
import se.kyh.ad10s.scrumapp.concretecommand.ListItemsWithoutSprint;
import se.kyh.ad10s.scrumapp.concretecommand.RemoveItemFromSprint;
import se.kyh.ad10s.scrumapp.concretecommand.SetTaskToDone;
import se.kyh.ad10s.scrumapp.concretecommand.toBacklogMenu;
import se.kyh.ad10s.scrumapp.concretecommand.toStartMenu;

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
		hm.put("BACKLOG", new ChooseBacklog());
		hm.put("EXIT", new EndProgram());
		// Alternative inputs
		hm.put("view", new DrawBacklogs());
		hm.put("create", new CreateBacklog());
		hm.put("delete", new DeleteBacklog());
		hm.put("backlog", new ChooseBacklog());
		hm.put("exit", new EndProgram());

		hm.put("View", new DrawBacklogs());
		hm.put("Create", new CreateBacklog());
		hm.put("Delete", new DeleteBacklog());
		hm.put("Backlog", new ChooseBacklog());
		hm.put("Exit", new EndProgram());

		hm.put("1", new DrawBacklogs());
		hm.put("2", new CreateBacklog());
		hm.put("3", new DeleteBacklog());
		hm.put("4", new ChooseBacklog());
		hm.put("5", new EndProgram());

	}

	public static void createBacklogMenuHashMap() {
		hm.clear();
		hm.put("VIEWALL", new DrawCurrentBacklogItems());
		hm.put("VIEW", new DrawOneItemInCurrentBacklog());
		hm.put("CREATE", new CreateBacklogItem());
		hm.put("DELETE", new DeleteBacklogItem());
		hm.put("ITEM", new ChooseBacklogItem());
		hm.put("REMOVE", new DeleteSprint());
		hm.put("ADD", new AddSprintToBacklog());
		hm.put("LIST", new ListAllSprints());
		hm.put("SPRINT", new AccessSprint());
		hm.put("BACK", new toStartMenu());
//		Alternative inputs
		hm.put("viewall", new DrawCurrentBacklogItems());
		hm.put("view", new DrawOneItemInCurrentBacklog());
		hm.put("create", new CreateBacklogItem());
		hm.put("delete", new DeleteBacklogItem());
		hm.put("item", new ChooseBacklogItem());
		hm.put("remove", new DeleteSprint());
		hm.put("add", new AddSprintToBacklog());
		hm.put("list", new ListAllSprints());
		hm.put("sprint", new AccessSprint());
		hm.put("back", new toStartMenu());

		hm.put("Viewall", new DrawCurrentBacklogItems());
		hm.put("View", new DrawOneItemInCurrentBacklog());
		hm.put("Create", new CreateBacklogItem());
		hm.put("Delete", new DeleteBacklogItem());
		hm.put("Item", new ChooseBacklogItem());
		hm.put("Remove", new DeleteSprint());
		hm.put("Add", new AddSprintToBacklog());
		hm.put("List", new ListAllSprints());
		hm.put("Sprint", new AccessSprint());
		hm.put("Back", new toStartMenu());

		hm.put("1", new DrawCurrentBacklogItems());
		hm.put("2", new DrawOneItemInCurrentBacklog());
		hm.put("3", new CreateBacklogItem());
		hm.put("4", new DeleteBacklogItem());
		hm.put("5", new ChooseBacklogItem());
		hm.put("6", new AddSprintToBacklog());
		hm.put("7", new DeleteSprint());
		hm.put("8", new ListAllSprints());
		hm.put("9", new AccessSprint());
		hm.put("10", new toStartMenu());
	}
//nli added checkouttask and SetTaskToDone
	public static void createBacklogItemMenuHashMap() {
		hm.clear();
		hm.put("VIEWALL", new DrawAllTasksForPbItem());
		hm.put("CREATE", new CreateNewTask());
		hm.put("DELETE", new DeleteTask());
		hm.put("CHECKOUT", new CheckoutTask());
		hm.put("DONE", new SetTaskToDone());
		hm.put("BACK", new toBacklogMenu());
		
		hm.put("viewall", new DrawAllTasksForPbItem());
		hm.put("create", new CreateNewTask());
		hm.put("delete", new DeleteTask());
		hm.put("checkout", new CheckoutTask());
		hm.put("done", new SetTaskToDone());
		hm.put("back", new toBacklogMenu());
		
		hm.put("Viewall", new DrawAllTasksForPbItem());
		hm.put("Create", new CreateNewTask());
		hm.put("Delete", new DeleteTask());
		hm.put("Checkout", new CheckoutTask());
		hm.put("Done", new SetTaskToDone());
		hm.put("Back", new toBacklogMenu());
		
		hm.put("1", new DrawAllTasksForPbItem());
		hm.put("2", new CreateNewTask());
		hm.put("3", new DeleteTask());
		hm.put("4", new CheckoutTask());
		hm.put("5", new SetTaskToDone());
		hm.put("6", new toBacklogMenu());
	}

	public static void createSprintMenuHashMap() {
		hm.clear();
		hm.put("ADD", new AddItemToSprint());
		hm.put("REMOVE", new RemoveItemFromSprint());
		hm.put("LIST", new ListItemsWithoutSprint());
		hm.put("BRNDWN", new DrawBurnDownChart());
		hm.put("BACK", new toBacklogMenu());
		
		hm.put("add", new AddItemToSprint());
		hm.put("remove", new RemoveItemFromSprint());
		hm.put("list", new ListItemsWithoutSprint());
		hm.put("back", new toBacklogMenu());
		
		hm.put("Add", new AddItemToSprint());
		hm.put("Remove", new RemoveItemFromSprint());
		hm.put("List", new ListItemsWithoutSprint());
		hm.put("Back", new toBacklogMenu());
		
		hm.put("1", new AddItemToSprint());
		hm.put("2", new RemoveItemFromSprint());
		hm.put("3", new ListItemsWithoutSprint());
		hm.put("4", new toBacklogMenu());
	}

}