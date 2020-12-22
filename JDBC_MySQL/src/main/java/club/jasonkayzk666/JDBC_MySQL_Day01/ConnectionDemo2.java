package club.jasonkayzk666.JDBC_MySQL_Day01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo2 {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection conn = null;
		Statement st = null;
		try {
			conn = DbUtilsDemo1.getConnection();
			st = conn.createStatement();
			String sql = "SELECT * FROM employee";
			
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("nam");
				
				System.out.println("Id: " + id + ", name: " + name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
