package club.jasonkayzk666.JDBC_MySQL_Day01;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtilsDemo1 {
	private static String JDBC_DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;
	
	static {
		Properties cfg = null;
		InputStream in = null;
		try {
			cfg = new Properties();
			in = DbUtilsDemo1.class.getClassLoader().getResourceAsStream("db.properties");
			cfg.load(in);
			DbUtilsDemo1.JDBC_DRIVER = cfg.getProperty("jdbc.driver");
			DbUtilsDemo1.URL = cfg.getProperty("jdbc.url") + "/" + cfg.getProperty("jdbc.sqlname");
			DbUtilsDemo1.USERNAME = cfg.getProperty("jdbc.username");
			DbUtilsDemo1.PASSWORD = cfg.getProperty("jdbc.password");
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName(DbUtilsDemo1.JDBC_DRIVER);
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		return conn;
	}
	
	
	public static void main(String[] args) {
		System.out.println(DbUtilsDemo1.JDBC_DRIVER);
		
		try {
			Connection conn = DbUtilsDemo1.getConnection();
			System.out.println(conn.getClass());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
