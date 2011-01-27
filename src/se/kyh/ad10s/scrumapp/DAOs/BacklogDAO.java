package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.DbManager;
import se.kyh.ad10s.scrumapp.PbItem;


public class BacklogDAO {
	
	/**
	 * Gets all Backlogs from database, 
	 * @return arraylist with objects.
	 * 
	 */
	
	public static ArrayList<Backlog> getAllBacklogsFromDB() {
		ArrayList<Backlog> list = new ArrayList<Backlog>();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();

			ResultSet rs = s
					.executeQuery("SELECT * FROM Backlog ORDER BY BacklogId ASC");
			while (rs.next()) {
				Backlog bl  = new Backlog();
				bl.blid = rs.getInt("BacklogId");
				bl.backlogName = rs.getString("BacklogName");
				bl.backlogDescription = rs.getString("BacklogDescription");
				list.add(bl);
			}
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * Creates a new backlog
	 * @param Backlog object
	 * @return backlog object
	 */
	
	public static Backlog createNewBacklog(Backlog bl) {
		int blid = 0;
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"INSERT INTO Backlog (	BacklogName, " + "BacklogDescription)"
							+ "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			s.setString(1, bl.backlogName);
			s.setString(2, bl.backlogDescription);

			s.executeUpdate();
			ResultSet rs = s.getGeneratedKeys();
			rs.first();
			blid = rs.getInt(1);
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		bl.blid = blid;
		return bl;
	}
	
	/**
	 * Deletes a backlog from the database
	 * arg: backlog ID
	 */
	public static void deleteBacklogFromDB (int blid) {
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"DELETE FROM Backlog WHERE BacklogId ="+blid+"");
			s.executeUpdate();
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets all PbItems in a Backlog
	 * @param Backlog object
	 * @return Arraylist of PbItem objects
	 */
	public static ArrayList<PbItem> getAllPbItemsFromBacklog(Backlog bl) {
		ArrayList<PbItem> list = new ArrayList<PbItem>();
		try {
			Statement s = (Statement) DbManager.getConnection()
					.createStatement();

			ResultSet rs = s
					.executeQuery("SELECT * FROM PBItems WHERE PBItemBacklogId ="+bl.blid+"");
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
