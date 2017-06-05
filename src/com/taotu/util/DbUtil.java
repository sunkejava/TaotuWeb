package com.taotu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.taotu.entity.Taotu;

/**
 * Mysql���ݿ������
 * 
 * @author Administrator
 *
 */
public class DbUtil {
	private String dbUrl = "jdbc:mysql://localhost:3306/db_taotu?useUnicode=true&characterEncoding=utf8";// ���ݿ����ӵ�ַ
	private String dbUserName = "root";// �û���
	private String dbPassword = "perp123";// ����
	private String jdbcName = "com.mysql.jdbc.Driver";// ��������

	/**
	 * ��ȡ���ݿ�����
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return con;
	}

	/**
	 * �ر����ݿ�����
	 * 
	 * @param con
	 * @throws Exception
	 */
	public void closeCon(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("���ݿ����ӳɹ�����");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ���");
		}
		System.out.println(DbUtil.isindb("aHR0cHM6Ly93d3cubWVpdHVsdS5jb20vaXRlbS82ODY4Lmh0bWw="));
	}

	public static boolean insertTaotu(Taotu taotu) {
		boolean resu = false;
		DbUtil dbutil = new DbUtil();
		Connection con = null;
		try {
			con = dbutil.getCon();
			String sql = "INSERT INTO db_taotu (NAME,url,imgurl,tagName,typeName,ADDTIME,crawlTime) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, taotu.getTitle());
			ps.setString(2, StringUtil.Base64encode(taotu.getUrl()));
			ps.setString(3, taotu.getImgUrl());
			ps.setString(4, taotu.getTagsName());
			ps.setString(5, taotu.getTypeName());
			ps.setString(6, taotu.getAddTime());
			ps.setString(7, taotu.getCrawlTime());
			int result = ps.executeUpdate();
			if (result > 0) {
				resu = true;
			} else {
				resu = false;
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("���ݿ�����ʧ�ܣ���");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resu;

	}

	public static boolean insertTaotuDetail(String[] taotus, String conText, String purl, int pid) {
		boolean resu = false;
		DbUtil dbutil = new DbUtil();
		Connection con = null;
		try {
			con = dbutil.getCon();
			String sql = "INSERT INTO db_taotudetail (url,purl,context,pid) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			int result = 0;
			for (int i = 0; i < taotus.length; i++) {
				ps.setString(1, taotus[i]);
				ps.setString(2, purl);
				ps.setString(3, conText);
				ps.setInt(4, pid);
				result = ps.executeUpdate();
				System.out.println("��ʼ���룺" + taotus[i] + "--" + purl + "--" + conText + "--" + pid);
			}
			if (result > 0) {
				resu = true;

			} else {
				resu = false;
			}
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("���ݿ�����ʧ�ܣ���");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return resu;

	}

	/**
	 * ��ȡ��ҳ��ҳ��
	 * 
	 * @param limit
	 *            ҳ����
	 * @param id
	 *            idֵ
	 * @return
	 */
	public static String getsumPages(String limit, String id) {
		String a = "";
		DbUtil dbutil = new DbUtil();
		Connection con = null;
		try {
			con = dbutil.getCon();
			String sql = "SELECT CASE WHEN COUNT(*) MOD " + limit + " > 0 THEN COUNT(*) DIV " + limit
					+ " +1 ELSE COUNT(*) DIV " + limit + " END AS Pages FROM db_taotudetail WHERE pid = " + id;
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int as = 1;
			while (rs.next()) {
				System.out.println("���ڻ�ȡdb_taotu�еĵ�" + as + "�����ݣ���");
				a = a + rs.getString(1);
				as++;
			}
			pstmt.close();
		} catch (Exception e1) {
			System.err.println("���ݿ�����ʧ�ܣ���");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return a;
	}

	/**
	 * ��ȡdb_taotu��ѯ��ҳ��
	 * 
	 * @param limit
	 *            ҳ����
	 * @param id
	 *            ����
	 * @return
	 */
	public static String getsumPagesofTable(String limit, String id) {
		String a = "";
		DbUtil dbutil = new DbUtil();
		Connection con = null;
		try {
			con = dbutil.getCon();
			String sql = "SELECT CASE WHEN COUNT(*) MOD " + limit + " > 0 THEN COUNT(*) DIV " + limit
					+ " +1 ELSE COUNT(*) DIV " + limit + " END AS Pages FROM db_taotu WHERE typeName = '" + id
					+ "' OR NAME LIKE '%" + id + "%' OR tagName LIKE '%" + id + "%'";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int as = 1;
			while (rs.next()) {
				a = a + rs.getString(1);
				as++;
			}
			pstmt.close();
		} catch (Exception e1) {
			System.err.println("���ݿ�����ʧ�ܣ���");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return a;
	}

	public static String getresult() {
		String a = "";
		DbUtil dbutil = new DbUtil();
		Connection con = null;
		try {
			con = dbutil.getCon();
			String sql = "SELECT url FROM db_taotu";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int as = 1;
			while (rs.next()) {
				System.out.println("���ڻ�ȡdb_taotu�еĵ�" + as + "�����ݣ���");
				a = a + rs.getString(1) + "----";
				as++;
			}
			pstmt.close();
		} catch (Exception e1) {
			System.err.println("���ݿ�����ʧ�ܣ���");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return a;
	}

	public static String getAll() {
		DbUtil dbutil = new DbUtil();
		Connection con = null;
		String result = "";
		try {
			con = dbutil.getCon();
			String sql = "SELECT * FROM db_taotu WHERE id NOT IN (SELECT  pid FROM db_taotudetail GROUP BY pid)";
			PreparedStatement pstmt;
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("============================");
			int a = 1;
			while (rs.next()) {
				System.out.println("���ڻ�ȡdb_taotu�еĵ�" + a + "�����ݣ���");
				result = result + rs.getString(3) + "----" + rs.getInt(1) + ",";
				a++;
			}
			pstmt.close();
			System.out.println("============================");
		} catch (Exception e1) {
			System.err.println("���ݿ�����ʧ�ܣ���");
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static boolean deleteDistinct() {
		DbUtil dbutil = new DbUtil();
		Connection con = null;
		boolean result = false;
		try {
			con = dbutil.getCon();
			PreparedStatement pstmt;
			String sql = "DELETE FROM db_taotu WHERE url IN (SELECT DISTINCT url FROM(SELECT DISTINCT url FROM db_taotu GROUP BY url HAVING (COUNT(url)) > 1)a) AND id NOT IN (SELECT DISTINCT id FROM (SELECT MIN(id)id FROM db_taotu GROUP BY url HAVING (COUNT(url)) > 1)b)";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			int rs = pstmt.executeUpdate();
			System.out.println("============================");
			if (rs >= 1) {
				result = true;
			} else {
				result = false;
			}
			pstmt.close();
		} catch (Exception e1) {
			System.err.println("���ݿ�����ʧ�ܣ���");
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/**
	 * �ж�b�Ƿ��Ѿ����ڣ����ڷ���true
	 * @param b
	 * @return
	 */
	public static boolean isindb(String b) {
		DbUtil dbutil = new DbUtil();
		Connection con = null;
		boolean result = false;
		try {
			con = dbutil.getCon();
			PreparedStatement pstmt;
			String sql = "select * FROM db_taotu WHERE url = '" + b+"'";
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("============================");
			rs.last();
			int rsRowCount= rs.getRow();
			if (rsRowCount >= 1) {
				result = true;
			} else {
				result = false;
			}
			pstmt.close();
		} catch (Exception e1) {
			System.err.println("���ݿ�����ʧ�ܣ���"+e1);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
