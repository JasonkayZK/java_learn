package club.jasonkayzk666.JDBC_MySQL_Day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDemo1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		Class.forName(JDBC_DRIVER);
//		System.out.println("OK!");
		
		final String url = "jdbc:mysql://localhost:3306/SQL_Learning";
		final String password = "your_passwd";
		final String username = "admin";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		Statement st = conn.createStatement();
		
		int index = 2;
		while (index <= 1000) {
			String dml = "INSERT INTO employee "
						+ "(id, nam) "
						+ "VALUES "
						+ "(" + index + ", 'zk" + index + "')";
			st.execute(dml);
			index++;
		}
		
		String sql = "SELECT * FROM employee";
		
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("nam");
			System.out.println("Id: " + id + ", " + "name: " + name);
		}
		
		rs.close();
		st.close();
		conn.close();
	}

}
