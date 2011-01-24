package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import se.kyh.ad10s.scrumapp.DbManager;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.Sprint;

import com.mysql.jdbc.Statement;

public class SprintDAO {

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
					"INSERT INTO Sprint (	SprintStartDate, " + "SprintEndDate)"
							+ "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			s.setDate(1, new Date(startDate.getTimeInMillis()));
			s.setDate(2, new Date(endDate.getTimeInMillis()));

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
				pbitem.pBItemSprintId = rs.getInt("PBItemSprintId");
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

	public static ArrayList<Sprint> getAllSprints() {
		ArrayList<Sprint> list = new ArrayList<Sprint>();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();

			ResultSet rs = s
					.executeQuery("SELECT * FROM Sprint ORDER BY SprintStartDate ASC");
			while (rs.next()) {
				Sprint sprint = new Sprint();
				sprint.sprintid = rs.getInt("SprintId");
				sprint.sprintid = rs.getInt("SprintStartDate");
				sprint.sprintid = rs.getInt("SprintEndDate");
				list.add(sprint);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void deleteSprintFromDB(int sprintId) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"DELETE FROM Sprint WHERE SprintId =" + sprintId + "");
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<PbItem> getAllPbItemsFromDBWithNoSprint(int blid) {
		ArrayList<PbItem> list = new ArrayList<PbItem>();
		try {
			PreparedStatement s = DbManager
					.getConnection()
					.prepareStatement(
							"SELECT * FROM PBItems WHERE PBItemSprintId IS ? AND PBItemBacklogId = ? ORDER BY PBItemPrio ASC");
			s.setNull(1, Types.NULL);
			s.setInt(2, blid);
			ResultSet rs = s.executeQuery();
			while (rs.next()) {
				PbItem pbitem = new PbItem();
				pbitem.dbid = rs.getInt("PBItemId");
				pbitem.name = rs.getString("PBItemName");
				pbitem.description = rs.getString("PBItemDescription");
				pbitem.est = rs.getInt("PBItemEST");
				pbitem.prio = rs.getInt("PBItemPrio");
				pbitem.pBItemSprintId = rs.getInt("PBItemSprintId");
				pbitem.BacklogId = rs.getInt("PBItemBacklogId");
				list.add(pbitem);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return list;
	}

}
