package jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static String JDBC_DRIVER;
	private static String URL;
	private static String USERNAME;
	private static String PASSWORD;

	private static int initSize;
	private static int maxAcive;
	
	private static BasicDataSource ds;
	
	static {
		ds = null;
	
		Properties cfg = null;
		InputStream in = null;
		
		try {
			// 创建连接池
			ds = new BasicDataSource();
			cfg = new Properties();
			in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
			// 读入配置文件
			cfg.load(in);
			DBUtils.JDBC_DRIVER = cfg.getProperty("jdbc.driver");
			DBUtils.URL = cfg.getProperty("jdbc.url") + "/" + cfg.getProperty("jdbc.sqlname");
			DBUtils.USERNAME = cfg.getProperty("jdbc.username");
			DBUtils.PASSWORD = cfg.getProperty("jdbc.password");
			
			DBUtils.initSize = Integer.parseInt(cfg.getProperty("dbcp.initSize"));
			DBUtils.maxAcive = Integer.parseInt(cfg.getProperty("dbcp.maxActive"));
			// 初始化连接池
			ds.setDriverClassName(JDBC_DRIVER);
			ds.setUrl(URL);
			ds.setUsername(USERNAME);
			ds.setPassword(PASSWORD);
			
			ds.setInitialSize(initSize);
			ds.setMaxActive(maxAcive);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void main(String[] args) {
//		Connection conn = DBUtils.getConnection();
//		System.out.println("OK!");
	}

	public static Connection getConnection() {
		try {
			Connection conn = ds.getConnection();
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
