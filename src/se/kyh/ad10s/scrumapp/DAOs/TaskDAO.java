package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import se.kyh.ad10s.scrumapp.DbManager;
import se.kyh.ad10s.scrumapp.Task;

import com.mysql.jdbc.Statement;

public class TaskDAO {

	/**
	 * Sends a taskobjcet to database
	 * 
	 * @param task
	 * @return task
	 */
	public static Task sendTaskToDB(Task task) {
		int taskId = 0;
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"INSERT INTO Tasks (	TaskName, " + "TaskDescription, "
							+ "TaskEST," + "TaskPrio," + "TaskPBItemId) "
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
		task.dbid = taskId;
		return task;
	}

	/**
	 * Removes a task from Database
	 * 
	 * @param taskId
	 */

	public static void deleteTaskFromDB(int taskId) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"DELETE FROM Tasks WHERE TaskId =" + taskId + "");
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Gets a task from the database
	 * 
	 * @return taskobject
	 */
	public static Task getTaskFromDB(int id) {
		Task task = new Task();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT * FROM `Tasks` WHERE TaskId =" + id
							+ "");
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

	/**
	 * Set the taskOwnerName and the checkOutDate for the task in database
	 * @param Taskowner name - String, Taskobject
	 * 
	 */
	public static void checkoutTask(String taskOwnerName, Task task) {

		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE `Tasks` SET TaskCheckoutName = ?, TaskCheckoutDate = NOW() WHERE TaskId ="
							+ task.dbid + "");
			s.setString(1, taskOwnerName);
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Set the Task as done
	 * @param Task objekt
	 */
	
	public static void setTaskToDone(Task task){
		
		try{
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE `Tasks` SET TaskDone = True WHERE TaskId=" + task.dbid + "");
			s.executeUpdate();
			s.close();
		
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
