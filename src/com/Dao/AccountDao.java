package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entry.Account;

/**
 * Dao �� ���ݳ־ò� Ҳ�� ģ�Ͳ� ����MVC�е�M
 * 
 * Dao����������: ʵ������+Dao
 */
public class AccountDao {

	/**
	 * �õ����ݿ�����
	 * 
	 * @return
	 */
	private static Connection getConn() {
		Connection conn = null;
		try {
			// �������ݿ��������·��(����)�������ݿ������
			String className = PropertiesUtil.getValue("driver");
			Class.forName(className);
			// ����url���˻���,����õ����ݿ������
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
	 * �õ����ݿ�����
	 * 
	 * @return
	 */
	// private Connection getConn() {
//		Connection conn = null;
//		try {
//			// �������ݿ��������·��(����)�������ݿ������
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			// ����url���˻���,����õ����ݿ������
//			conn = (Connection) DriverManager
//					.getConnection("jdbc:mysql://localhost:3306/java?useSSL=false&serverTimezone=UTC", "root", "123");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//	}

	/**
	 * ���
	 * 
	 * @param account
	 */
	public void add(Account account) {
		try {

			Connection conn = getConn();// ���������Ѿ��������ݿ����ӵĻ����ϣ������ݿⷢ��Ҫִ�е�SQL��䡣Statement��������ִ�в��������ļ�SQL��䡣����ִ�о�̬ SQL
			String sql = "insert into account(acc,pswd) values(?,?)";// ����һ��Ҫִ�е�sql
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, account.getAcc());
			st.setString(2, account.getPswd());
			st.executeUpdate(); // PreparedStatement ��ִ�� executeUpdate ʱ����Ҫ�ټ�sql!!!!!
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	/**
//	 * ��������
//	 */
//	public void update(Account account) {
//		try {
//			Connection conn = getConn();
//			String sql = " update account set pswd =? where  acc=? ";// ����һ��Ҫִ�е�sql
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
//	 * ɾ������
//	 */
//	public void delete(String acc) {
//		try {
//			Connection conn = getConn();
//			String sql = " delete from account where  acc=? ";// ����һ��Ҫִ�е�sql
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
//	 * ��ѯ����
//	 */
//	public List<Account> query() {
//		List<Account> list = new ArrayList<>();
//		try {
//			Connection conn = getConn();
//			Statement st = conn.createStatement();
//			String sql = "select * from account ";
//			ResultSet rs = st.executeQuery(sql); // Ҫִ��select ������ʹ�� executeQuery ���� ����ѯ���������ݷŵ���ResultSet������
//			while (rs.next()) { // ��������ȡ��ѯ��� ��ResultSet�����е�����,��Ҫͨ��whileѭ������ȡ���� ResultSet�Ķ���.next�Ǿ�����ȡһ������
//				// ��ʵ����һ����ʽ�α� ÿ������һ��,��������ݾͻ����,��ֱ����ResultSet����.����(�����int��.getInt,..)���ܵõ���Ӧ��ֵ
//				Account we = new Account();
//				we.setAcc(rs.getString("acc"));
//				we.setPswd(rs.getString("pswd"));
//				list.add(we); // ��ӵ�������
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}

	/**
	 * �����˻���������������
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
			PreparedStatement pst = conn.prepareStatement(sql); // PreparedStatement������ִ��sql��
			pst.setString(1, acc);
			pst.setString(2, pswd);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				account = new Account();// �鵽��ֵ,����װʱ��new
				account.setAcc(rs.getString("acc"));
				account.setPswd(rs.getString("pswd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}

//	/**
//	 * �����˻����������
//	 * 
//	 * @param acc
//	 * @return Account;
//	 */
//	public Account get(String acc) {
//		Account account = null;
//		try {
//			Connection conn = getConn();
//			String sql = " select * from account where acc = ? ";
//			PreparedStatement pst = conn.prepareStatement(sql); // PreparedStatement������ִ��sql��
//			pst.setString(1, acc);
//			ResultSet rs = pst.executeQuery();
//			while (rs.next()) {
//				account = new Account();// �鵽��ֵ,����װʱ��new
//				account.setAcc(rs.getString("acc"));
//				account.setPswd(rs.getString("pswd"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return account;
//	}
}
