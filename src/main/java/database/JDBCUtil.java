package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection c = null;
		try {
			// Đăng ký Driver với DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			// Các thông số
			String url = "jdbc:mysql://localhost:3306/yugioh_database";
			String username = "root";
			String password = "tung12345";
			// Tạo kết nối
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	// Ngắt kết nối
	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
}
