package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DQLDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		Class.forName(driver);
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:oracle";
		String username = "c##admin";
		String password = "your_passwd";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		Statement st = conn.createStatement();

		String sql = "SELECT id, name FROM zk_demo";
		ResultSet rs = st.executeQuery(sql);

		System.out.println(rs);
		
		conn.close();
	}

}
