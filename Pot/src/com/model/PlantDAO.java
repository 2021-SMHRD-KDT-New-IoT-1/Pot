package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlantDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt = 0;
	MemberVO vo = null;
	ArrayList<MemberVO> al = null;
	boolean check = false;

	public void connection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_a_2_1025";
			String password = "smhrd2";
			System.out.println("jdbc driver �ε� ����");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("----------");
			e.printStackTrace();
			System.out.println("�������...");
		}

	}

	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pst != null) {
				pst.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	// 01. �Ĺ� ��� ���
	public int joinPlant(String comment, String pt_nick, int mem_num) {

		try {
			connection();

			String sql = "INSERT INTO ts_plant VALUES (TS_PLANT_SEQ.NEXTVAL, sysdate, ?, ?, ?)";

			pst = conn.prepareStatement(sql);

			pst.setString(1, comment);
			pst.setString(2, pt_nick);
			pst.setInt(3, mem_num);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("�Ĺ� ���� �Է� ����");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 02. �Ĺ� �˻� ���
	public void selectPlant() {

		try {
			connection();

			String sql = "INSERT INTO ts_plant VALUES (TS_PLANT_SEQ.NEXTVAL, sysdate, ?, ?, ?)";

			pst = conn.prepareStatement(sql);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("�Ĺ� ���� �Է� ����");
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
