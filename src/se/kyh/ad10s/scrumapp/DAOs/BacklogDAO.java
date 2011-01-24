package se.kyh.ad10s.scrumapp.DAOs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import se.kyh.ad10s.scrumapp.Backlog;
import se.kyh.ad10s.scrumapp.DbManager;

public class BacklogDAO {
	
	/**
	 * Gets all Backlogs from database, returns arraylist with objects.
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
	
	public static int createNewBacklog(String backlogName, String backlogDescription) {
		int blid = 0;
		try {
			PreparedStatement s = DbManager.getConnection().prepareStatement(
					"INSERT INTO Backlog (	BacklogName, " + "BacklogDescription)"
							+ "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
			s.setString(1, backlogName);
			s.setString(2, backlogDescription);

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
}
