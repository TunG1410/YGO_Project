package data_access_object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.JDBCUtil;

public class GameDAO {

	public static GameDAO getInstance() {
		return new GameDAO();
	}

	public void insert(String StartTime, String PlayTime, String NamePlayer1, String NamePlayer2, int NumberTurn,
			String NameWinner) {

		try {

			Connection con = JDBCUtil.getConnection();

			String sql = "INSERT INTO game (StartTime, PlayTime, NamePlayer1, NamePlayer2, NumberTurn, NameWinner)" +
						" VALUES (?, ?, ?, ?, ?, ?)";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, StartTime);
			pst.setString(2, PlayTime);
			pst.setString(3, NamePlayer1);
			pst.setString(4, NamePlayer2);
			pst.setInt(5, NumberTurn);
			pst.setString(6, NameWinner);

			pst.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int IdGame, String StartTime, String PlayTime, String NamePlayer1, String NamePlayer2, int NumberTurn,
			String NameWinner) {
		try {

			Connection con = JDBCUtil.getConnection();

			String sql = "UPDATE game" +
						" SET" +
						" StartTime=?," +
						" PlayTime=?," +
						" NamePlayer1=?," +
						" NamePlayer2=?," +
						" NumberTurn=?," +
						" NameWinner=?" +
						" WHERE IdGame=?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, StartTime);
			pst.setString(2, PlayTime);
			pst.setString(3, NamePlayer1);
			pst.setString(4, NamePlayer2);
			pst.setInt(5, NumberTurn);
			pst.setString(6, NameWinner);
			pst.setInt(7, IdGame);

			pst.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int IdGame) {
		try {

			Connection con = JDBCUtil.getConnection();

			String sql = "DELETE FROM game" + " WHERE IdGame=?";

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, IdGame);

			pst.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
