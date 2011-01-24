package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import se.kyh.ad10s.scrumapp.DbManager;
import se.kyh.ad10s.scrumapp.Task;

import com.mysql.jdbc.Statement;

public class TaskDAO {
	/**
	 *  Creates a new Task in DB 
	 *  arg: Task object
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
			s.setInt(5, task.taskPBItemId);
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
	 *  Removes a task from Database 
	 *  Arg: taskId
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
	
	/**
	 * 
	 * Gets a task from the database
	 * Returns a taskobject
	 */
	public static Task getTaskFromDB(int id) {
		Task task = new Task();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT * FROM `Tasks` WHERE TaskId ="
							+ id + "");
			while (rs.next()) {
				task.dbid = rs.getInt("TaskId");
				task.name = rs.getString("TaskName");
				task.description = rs.getString("TaskDescription");
				task.est = rs.getInt("TaskEST");
				task.prio = rs.getInt("TaskPrio");
				task.taskPBItemId = rs.getInt("TaskPBItemId");
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return task;
	}
}
