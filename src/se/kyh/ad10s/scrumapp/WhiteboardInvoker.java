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
	
	public WhiteboardInvoker(){
//		hm.put("ADD PBI", new WhiteboardAddPbItem());
		
//A way to create more keys to a value without initiating them more than once		
//		MenuItem mi = new WhiteboardExecuteAddPbItem()
//		hm.put("Actual menu item for ADD PbItem", mi);
//		hm.put("Spelled wrong option", mi);
//		hm.put("short command option", mi);

		
//		descriptive text
//		shortinput
//		descriptive text2
//		shortinput2
//		
	}
	
	public static void createStartMenuHashMap() {
		DrawBacklogs drawBacklogs = new DrawBacklogs();
		CreateBacklog createBacklog = new CreateBacklog();
		DeleteBacklog deleteBacklog = new DeleteBacklog();
		
//		hm.put("1", drawBacklogs());
//		hm.put("Choose existing backlog", drawBacklogs());
//		hm.put("CHOOSE", drawBacklogs());
//		
//		hm.put("2", createBacklog());
//		hm.put("Create a new backlog", createBacklog());
//		hm.put("CREATE", createBacklog());
//		
//		hm.put("3", deleteBacklog());
//		hm.put("Delete backlog", deleteBacklog());
//		hm.put("DELETE", deleteBacklog());
		
		
		
	}

	
	
	public void executeCommand(String s){
		Command c = getCommand(s);
		if (c == null){
			return;
		}
		c.execute();
	}
	
	public Command getCommand(String strCommand)
	{
		return hm.get(strCommand);
	}






	
	

}