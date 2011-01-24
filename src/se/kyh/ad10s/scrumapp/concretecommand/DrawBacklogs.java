package se.kyh.ad10s.scrumapp.concretecommand;

import se.kyh.ad10s.scrumapp.Command;

public class DrawBacklogs implements Command {
	
	public void draw() {
		System.out.println("drawed");
		// TODO Auto-generated method stub
		execute();
	}

	@Override
	public void execute() {
		System.out.println("executed");
		
	}

}
