package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CalendarDAO {
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	int cnt = 0;
	CalendarVO cvo = null;
	ArrayList<CalendarVO> cal = null;

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

	// 1. Ķ���� �� ��ȸ
	public ArrayList<CalendarVO> calendar(String num) {
		cal = new ArrayList<CalendarVO>();

		try {
			connection();
			String sql = "SELECT p.pt_num, s.st_date, s.st_state FROM ts_plant p, ts_state s WHERE p.pt_num=s.pt_num AND p.pt_num= ?";
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, num);

			rs = pst.executeQuery();

			while (rs.next()) {

				String get_PtNum = rs.getString(1);
				String get_Date = rs.getString(2);
				String get_State = rs.getString(3);

				cvo = new CalendarVO(get_PtNum, get_Date, get_State);

				cal.add(cvo);
			}
			System.out.println("��ȸ ����!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��ȸ ����");
		} finally {
			close();
		}
		return cal;
	}
	
	// 2. 
	public int waterPump(String pt_num) {
		int state = 1;
		try {
			connection();
			
			String sql = "INSERT INTO ts_state VALUES (?, sysdate+(interval '9' hour), ?)";
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, pt_num);
			pst.setInt(2, state);
			
			System.out.println(pt_num + " " + state);
			
			cnt = pst.executeUpdate();
			
			System.out.println("�Է¼���");
		} catch (Exception e) {
			System.out.println("�Է½���");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}
}
