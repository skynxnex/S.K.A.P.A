package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import se.kyh.ad10s.scrumapp.DbManager;
import se.kyh.ad10s.scrumapp.Task;

public class TaskDAO {
	/**
	 *  Creates a new Task in DB, arg: Task object
	 * 
	 */
	public static int sendTaskToDB(Task task) {
		int taskId = 0;
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"INSERT INTO Tasks (	TaskName, "
							+ "TaskDescription, " + "TaskEST,"
							+ "TaskPrio," + "TaskPBItemId) "
							+ "VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			s.setString(1, task.name);
			s.setString(2, task.description);
			s.setInt(3, task.est);
			s.setInt(4, task.prio);
			s.setInt(5, task.TaskPBItemId);
			s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			rs.first();
			taskId = rs.getInt(1);
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return taskId;
	}
		
	/**
	 *  Removes task from DB, arg: taskId
	 */
	
	public static void deleteTaskFromDB(int taskId){
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"DELETE FROM Tasks WHERE TaskId ="+taskId+"");
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}
