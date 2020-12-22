package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import exceptions.LoginException;
import exceptions.RegistorException;

public class Transaction {

	public static void main(String[] args) {
		Connection conn = DBUtils.getConnection();
		String username = "admin";
		String pwd = "your_passwd";
		try {
			System.out.println(login(username, pwd, conn));
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}

	public static boolean registorTest(String username, Connection conn) {
		Statement st = null;
		try {
			st = conn.createStatement();
			// 查询数据库中是否有重复的用户名
			String dql = "SELECT COUNT(*) FROM loginInfo WHERE username = " + "\'" + username + "\'";
			ResultSet rs = st.executeQuery(dql);
			while (rs.next()) {
				if (rs.getInt(1) == 0) {
					return true;
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean registor(String nickname, String username, String pwd, Connection conn) throws RegistorException {
		Statement st = null;
		try {
			if (registorTest(username, conn)) {
				st = conn.createStatement();
				String dml = "INSERT INTO loginInfo (nickname, username, pwd, time) VALUES " + "(" + "\'" + nickname + "\', " + "\'" + username + "\', " + "\'" + pwd + "\'" + ", NOW())";
				if (st.executeUpdate(dml) == 1) {
					return true;
				} else {
					throw new RegistorException("账号注册失败！");
				}
			} else {
				throw new RegistorException("用户名已被使用！");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	public static boolean login(String username, String password, Connection conn) throws LoginException {
		Statement st = null;
		try {
			if (registorTest(username, conn)) {
				return false;
			}
			st = conn.createStatement();
			String dql = "SELECT pwd FROM loginInfo WHERE username = " + "\'" + username + "\'";
			ResultSet rs = st.executeQuery(dql);
			while (rs.next()) {
				if (rs.getString(1).equals(password)) {
					return true;
				} else {
					return false;
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException(e);
		} finally {
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
