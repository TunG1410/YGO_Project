package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.JDBCUtil;

public class CardDAO {
	
	public static CardDAO getInstance() {
		return new CardDAO();
	}

	public void insert(String Name, String Type, int Level, int Attack, int Defense, String Effect) {
		
		try {
			
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT IGNORE INTO card (Name, Type, Level, Attack, Defense, Effect)" + 
						" VALUES (?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, Name);
			pst.setString(2, Type);
			pst.setInt(3, Level);
			pst.setInt(4, Attack);
			pst.setInt(5, Defense);
			pst.setString(6, Effect);
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(String Name, String Type, int Level, int Attack, int Defense, String Effect) {
		try {
			
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE card" +
						" SET" +
						" Type=?," +
						" Level=?," +
						" Attack=?," +
						" Defense=?," +
						" Effect=?" +
						" WHERE Name=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, Type);
			pst.setInt(2, Level);
			pst.setInt(3, Attack);
			pst.setInt(4, Defense);
			pst.setString(5, Effect);
			pst.setString(6, Name);
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String Name) {
		try {
			
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE FROM card" +
						" WHERE Name=?";
			
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, Name);
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAll() {
		try {
			
			Connection con = JDBCUtil.getConnection();
			
			String sql = "TRUNCATE card";
			
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.executeUpdate();
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
