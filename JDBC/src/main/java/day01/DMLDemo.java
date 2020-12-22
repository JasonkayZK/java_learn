package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DMLDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:oracle";
		String username = "c##admin";
		String password = "your_password";
		
		Connection conn = DriverManager.getConnection(url, username, password);
		
		Statement st = conn.createStatement();
		
//		1. Insert
//		String dml = "INSERT INTO zk_demo"
//				  	+ "(id, name)"
//				  	+ "VALUES"
//				  	+ "(1, 'Tom')";
		
//		2. UPDATE
//		String dml = "UPDATE zk_demo SET name='Jerry' WHERE id=1";
		
//		3. DELETE
		String dml = "DELETE FROM zk_demo WHERE id = 1";
		
		int n = st.executeUpdate(dml);
		System.out.println(n);
		
		conn.close();
	}

}
