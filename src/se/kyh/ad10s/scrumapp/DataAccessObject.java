package se.kyh.ad10s.scrumapp;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.Statement;

public class DataAccessObject {

	//------------SprintDatabaseMethods
	public static void addItemToSprintBacklog(PbItem pbitem, int sprintid) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE PBItems SET PBItemSprintId = ? WHERE PBItemId=?");
			s.setInt(1, sprintid);
			s.setInt(2, pbitem.dbid);

			s.executeUpdate();

			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int makeNewSprint(Calendar startDate, Calendar endDate) {
		int sprintid = 0;
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"INSERT INTO Sprint (	SprintStartDate, " +
											"SprintEndDate)" +
										"VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			s.setDate(1, new Date( startDate.getTimeInMillis() ));
			s.setDate(2, new Date (endDate.getTimeInMillis() ));

			s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			rs.first();
			sprintid = rs.getInt(1);
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sprintid;
	}
	
	public static List<PbItem> getAllItemsInSprint(int sprintid) {
		List<PbItem> list = new ArrayList<PbItem>();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();

			ResultSet rs = s
					.executeQuery("SELECT * FROM PBItems WHERE PBItemSprintId = "
							+ sprintid + " ORDER BY PBItemPrio ASC");
			while (rs.next()) {
				PbItem pbitem = new PbItem();
				pbitem.dbid = rs.getInt("PBItemId");
				pbitem.name = rs.getString("PBItemName");
				pbitem.description = rs.getString("PBItemDescription");
				pbitem.est = rs.getInt("PBItemEST");
				pbitem.prio = rs.getInt("PBItemPrio");
				pbitem.SprintId = rs.getInt("PBItemSprintId");
				pbitem.BacklogId = rs.getInt("PBItemBacklogId");
				list.add(pbitem);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}
	
	public void removeItemFromSprintBacklog(int index) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE PBItems SET PBItemSprintId = ? WHERE PBItemId=?");
			s.setNull(1, Types.NULL);
			s.setInt(2, index);

			s.executeUpdate();

			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//------------END SprintDatabaseMethods
	
	//------------PbItemDatabaseMethods
	public static int sendPBItemToDB(String name, String description, int est, int prio) {
		int blid = 0;
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
										"INSERT INTO PBItems (	PBItemName, " +
																"PBItemDescription, " +
																"PBItemEST," +
																"PBItemPrio," +
																"PBItemBacklogId) " +
										"VALUES (?, ?, ?, ?, ?)"
																,Statement.RETURN_GENERATED_KEYS);
			s.setString(1, name);
			s.setString(2, description);
			s.setInt(3, est);
			s.setInt(4, prio);
			s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			rs.first();
			blid = rs.getInt(1);
			s.close();
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return blid;
	}
	
}
