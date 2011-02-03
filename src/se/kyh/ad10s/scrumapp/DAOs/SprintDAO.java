package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import se.kyh.ad10s.scrumapp.DbManager;
import se.kyh.ad10s.scrumapp.PbItem;
import se.kyh.ad10s.scrumapp.Sprint;

import com.mysql.jdbc.Statement;

public class SprintDAO {

	/**
	 * Adds a PbItem to the Sprint
	 * @param PbItem object, Sprint ID
	 */
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

	/**
	 * Makes a new Sprint
	 * @param Sprintobject, Backlog ID
	 * @return Sprintobject
	 */
	public static Sprint makeNewSprint(Sprint sprint, int blid) {
		int sprintid = 0;
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"INSERT INTO Sprint (	SprintStartDate, " + "SprintEndDate, "+"SprintBacklogId)"
							+ "VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			s.setDate(1, new Date(sprint.startDate.getTimeInMillis()));
			s.setDate(2, new Date(sprint.endDate.getTimeInMillis()));
			s.setInt(3, blid);
			s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			rs.first();
			sprintid = rs.getInt(1);
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		sprint.sprintid = sprintid;
		return sprint;
	}

	/**
	 * Gets all items from a certain sprint
	 * @return arraylist with pbitem objects
	 */
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
				if(rs.getDate("PBItemDoneDate") != null) {
					pbitem.PbItemDoneDate.setTime(rs.getDate("PBItemDoneDate"));
				} else {
					pbitem.PbItemDoneDate.set(2000, 0, 01);
				}
				list.add(pbitem);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Removes PbItems from a sprint
	 * @param PbItem id
	 */
	public static void removeItemFromSprintBacklog(int id) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"UPDATE PBItems SET PBItemSprintId = ? WHERE PBItemId=?");
			s.setNull(1, Types.NULL);
			s.setInt(2, id);
			s.executeUpdate();
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets all sprints in database from a certain Backlog
	 * args: Backlog id
	 * returns an Arraylist with sprintobjects
	 */
	public static ArrayList<Sprint> getAllSprints(int id) {
		ArrayList<Sprint> list = new ArrayList<Sprint>();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT * FROM Sprint WHERE SprintBacklogId = "+id+" ORDER BY SprintStartDate ASC");
			while (rs.next()) {
				Sprint sprint = new Sprint();
				sprint.sprintid = rs.getInt("SprintId");
				sprint.startDate.setTime(rs.getDate("SprintStartDate"));
				sprint.endDate.setTime(rs.getDate("SprintEndDate"));
				sprint.sprintBacklogId = rs.getInt("SprintBacklogId");
				list.add(sprint);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Deletes a sprint from the database
	 * arg: SprintID
	 */
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

	/**
	 * Lists all PbItems not added to a sprint
	 * arg: Current BacklogID
	 * returns an arraylist with PbItem objects
	 */
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
	
	public static Sprint getSprintFromDB (int sprintid) {
		Sprint sprint = new Sprint();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();
			ResultSet rs = s
					.executeQuery("SELECT * FROM `Sprint` WHERE SprintId ="
							+ sprintid + "");
			while (rs.next()) {
				sprint.sprintid = rs.getInt("SprintId");
				sprint.startDate.setTime(rs.getDate("SprintStartDate"));
				sprint.endDate.setTime(rs.getDate("SprintEndDate"));
				sprint.sprintBacklogId = rs.getInt("SprintBacklogId");
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sprint;
	}
}
