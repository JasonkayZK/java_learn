package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DriverManagerDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.OracleDriver");
//		System.out.println("OK!");
		
//		1. Connect to the Oracle DB ---------------------------------
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:oracle";
		String user = "c##admin";
		String password = "your_password";
		
		Connection conn = DriverManager.getConnection(url, user, password);
//		System.out.println(conn.getClass());
		
//		2. Create Statement Object
		Statement st = conn.createStatement();
		
//		3. Execute DB by Java -----------------------------
		String ddl = "create TABLE zk_demo"
				   + "(id NUMBER(7), "
				   + "name VARCHAR2(100)"
				   + ")";
		
//		String ddl = "DROP TABLE zk_demo";
		
		boolean b = st.execute(ddl);
		
		System.out.println(b);

//		4. Close DB!!!!!!!!!!!!!
		conn.close();
	}

}
