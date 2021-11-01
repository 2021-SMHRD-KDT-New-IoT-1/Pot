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
	CalendarVO vo = null;
	ArrayList<CalendarVO> al = null;

	public void connection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_a_2_1025";
			String password = "smhrd2";
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("----------");
			e.printStackTrace();
			System.out.println("연결실패...");
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

	// 1. 캘린더 값 조회
	public ArrayList<CalendarVO> calendar() {
		al = new ArrayList<CalendarVO>();

		try {
			connection();
			String sql = "SELECT * FROM state";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {

				String get_PtNum = rs.getString(1);
				String get_Date = rs.getString(2);
				String get_State = rs.getString(3);

				vo = new CalendarVO(get_PtNum, get_Date, get_State);

				al.add(vo);
			}
			System.out.println("조회 성공!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회 실패");
		} finally {
			close();
		}

		return al;
	}
}
