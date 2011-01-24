package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import se.kyh.ad10s.scrumapp.DbManager;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.Task;

import com.mysql.jdbc.Statement;

public class PbItemDAO {
	public static int sendPBItemToDB(PbItem pbitem) {
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
		return blid;
	}

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

	public static void deletePbItemFromDB(int pbId){
		
			try {
				PreparedStatement s = DbManager.getConnection().prepareStatement(
						"DELETE FROM PBItems WHERE PBItemId ="+pbId+"");
				s.executeUpdate();
				s.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	public static void addTaskToPbItem(Task task, int taskId) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE Tasks SET TaskPBItemId = ? WHERE TaskId=?");
			s.setInt(1, taskId);
			s.setInt(2, task.dbid);
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Add task to pbitem

}
