package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.DbManager;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.Task;

import com.mysql.jdbc.Statement;

public class PbItemDAO {
	
	/**
	 * Send PbItem to database
	 * 
	 * @param pbitem object
	 * @return pbitem object
	 */
	public static PbItem sendPBItemToDB(PbItem pbitem) {
		int blid = 0;
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"INSERT INTO PBItems (	PBItemName, "
							+ "PBItemDescription, " + "PBItemEST,"
							+ "PBItemPrio," + "PBItemBacklogId) "
							+ "VALUES (?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			s.setString(1, pbitem.name);
			s.setString(2, pbitem.description);
			s.setInt(3, pbitem.est);
			s.setInt(4, pbitem.prio);
			s.setInt(5, pbitem.BacklogId);
			s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			rs.first();
			blid = rs.getInt(1);
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		pbitem.dbid = blid;
		return pbitem;
	}

	/**
	 * Gets a PbItem from database
	 * @param PbItem id
	 * @return PbItem object
	 */
	public static PbItem getPbItemFromDB(int id) {
		PbItem pbitem = new PbItem();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT * FROM `PBItems` WHERE PBItemId ="
							+ id + "");
			while (rs.next()) {
				pbitem.dbid = rs.getInt("PBItemId");
				pbitem.name = rs.getString("PBItemName");
				pbitem.description = rs.getString("PBItemDescription");
				pbitem.est = rs.getInt("PBItemEST");
				pbitem.prio = rs.getInt("PBItemPrio");
				pbitem.pBItemSprintId = rs.getInt("PBItemSprintId");
				pbitem.BacklogId = rs.getInt("PBItemBacklogId");
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pbitem;
	}

	/**
	 * Deletes PbItem from database
	 * @param pbId
	 */
	public static void deletePbItemFromDB(int pbId) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"DELETE FROM PBItems WHERE PBItemId =" + pbId + "");
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Adds task to PbItem
	 * @param task object
	 * @param Pbitem id
	 */
	public static void addTaskToPbItem(Task task, int Pbitemid) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE Tasks SET TaskPBItemId = ? WHERE TaskId=?");
			s.setInt(1, Pbitemid);
			s.setInt(2, task.dbid);
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Removes task from PbItem
	 * @param task object
	 */
	public static void removeTaskFromPbItem(Task task) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE Tasks SET TaskPBItemId = ? WHERE TaskId=?");
			s.setNull(1, Types.NULL);
			s.setInt(2, task.dbid);
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setPbItemToDone(int taskPBItemId) {
		try{
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE `pbitems` SET PBItemDoneDate = NOW() WHERE PBItemId=" + taskPBItemId+"");
			s.executeUpdate();
			s.close();
		
		}catch (Exception e){
			e.printStackTrace();
		}
		
	}

	public static boolean getAllTasksInPbItemDone(int taskPBItemId) {
		boolean returnvalue = false;
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT `TaskId` FROM `Tasks` WHERE TaskPBItemId ="
							+ taskPBItemId + " AND `TaskDone` = 0 ");
			if(rs.next()) {
				returnvalue = false;
			}else{
				returnvalue = true;
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnvalue;			
	}

	
}
