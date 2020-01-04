package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entry.Account;

/**
 * Dao 是 数据持久层 也叫 模型层 就是MVC中的M
 * 
 * Dao的命名规则: 实体类名+Dao
 */

public class AccountDao {
	public class as{
		System.out.println(123);
                System.out.println(“实体搜图搜合同搜狐”);
		}

	public class aaa{

		System.out.println("tiangjialei yitiao shuj ");
		}

	/**
	 * 得到数据库链接
	 * 
	 * @return
	 */
	private static Connection getConn() {
		Connection conn = null;
		try {
			// 根据数据库的驱动类路径(反射)加载数据库的驱动
			String className = PropertiesUtil.getValue("driver");
			Class.forName(className);
			// 根据url和账户名,密码得到数据库的链接
			String url = PropertiesUtil.getValue("url");
			String user = PropertiesUtil.getValue("username");
			String password = PropertiesUtil.getValue("password");
			conn = (Connection) DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 得到数据库链接
	 * 
	 * @return
	 */
	// private Connection getConn() {
//		Connection conn = null;
//		try {
//			// 根据数据库的驱动类路径(反射)加载数据库的驱动
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// 根据url和账户名,密码得到数据库的链接
//			conn = (Connection) DriverManager
//					.getConnection("jdbc:mysql://localhost:3306/java?useSSL=false&serverTimezone=UTC", "root", "123");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}

	/**
	 * 添加
	 * 
	 * @param account
	 */
	public void add(Account account) {
		try {

			Connection conn = getConn();// ，用于在已经建立数据库连接的基础上，向数据库发送要执行的SQL语句。Statement对象，用于执行不带参数的简单SQL语句。用于执行静态 SQL
			String sql = "insert into account(acc,pswd) values(?,?)";// 创建一个要执行的sql
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, account.getAcc());
			st.setString(2, account.getPswd());
			st.executeUpdate(); // PreparedStatement 在执行 executeUpdate 时不需要再加sql!!!!!
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	/**
//	 * 更新数据
//	 */
//	public void update(Account account) {
//		try {
//			Connection conn = getConn();
//			String sql = " update account set pswd =? where  acc=? ";// 创建一个要执行的sql
//			PreparedStatement st = conn.prepareStatement(sql);
//			st.setString(1, account.getPswd());
//			st.setString(2, account.getAcc());
//			st.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

//	/**
//	 * 删除数据
//	 */
//	public void delete(String acc) {
//		try {
//			Connection conn = getConn();
//			String sql = " delete from account where  acc=? ";// 创建一个要执行的sql
//			PreparedStatement st = conn.prepareStatement(sql);
//			st.setString(1, acc);
//			st.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	/**
//	 * 查询数据
//	 */
//	public List<Account> query() {
//		List<Account> list = new ArrayList<>();
//		try {
//			Connection conn = getConn();
//			Statement st = conn.createStatement();
//			String sql = "select * from account ";
//			ResultSet rs = st.executeQuery(sql); // 要执行select 语句必须使用 executeQuery 方法 将查询出来的数据放到了ResultSet对象中
//			while (rs.next()) { // 这里是在取查询结果 在ResultSet对象中的数据,需要通过while循环才能取出来 ResultSet的对象.next是就向下取一个数据
//				// 其实就是一个隐式游标 每向下走一个,如果有数据就会进来,则直接用ResultSet对像.方法(如果是int就.getInt,..)就能得到相应的值
//				Account we = new Account();
//				we.setAcc(rs.getString("acc"));
//				we.setPswd(rs.getString("pswd"));
//				list.add(we); // 添加到集合中
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	/**
	 * 根据账户名和密码查出对象
	 * 
	 * @param acc
	 * @param pswd
	 * @return Account;
	 */
	public Account getAccountByAccAndPswd(String acc, String pswd) {
		Account account = null;
		try {
			Connection conn = getConn();
			String sql = " select * from account where acc = ? and pswd = ? ";
			PreparedStatement pst = conn.prepareStatement(sql); // PreparedStatement是用来执行sql的
			pst.setString(1, acc);
			pst.setString(2, pswd);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				account = new Account();// 查到有值,进来装时才new
				account.setAcc(rs.getString("acc"));
				account.setPswd(rs.getString("pswd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

//	/**
//	 * 根据账户名查出对象
//	 * 
//	 * @param acc
//	 * @return Account;
//	 */
//	public Account get(String acc) {
//		Account account = null;
//		try {
//			Connection conn = getConn();
//			String sql = " select * from account where acc = ? ";
//			PreparedStatement pst = conn.prepareStatement(sql); // PreparedStatement是用来执行sql的
//			pst.setString(1, acc);
//			ResultSet rs = pst.executeQuery();
//			while (rs.next()) {
//				account = new Account();// 查到有值,进来装时才new
//				account.setAcc(rs.getString("acc"));
//				account.setPswd(rs.getString("pswd"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return account;
//	}
}
