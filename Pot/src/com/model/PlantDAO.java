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
	PlantVO pvo = null;
	ArrayList<PlantVO> pal = null;
	boolean check = false;

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

	// 01. 식물 등록 기능
	public int joinPlant(String comment, String pt_nick, int mem_num) {
		
		
		try {
			connection();

			String sql = "INSERT INTO plant VALUES (PLANT_SEQ.NEXTVAL, sysdate, ?, ?, ?)";

			pst = conn.prepareStatement(sql);

			pst.setString(1, comment);
			pst.setString(2, pt_nick);
			pst.setInt(3, mem_num);

			cnt = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("식물 정보 입력 실패");
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}

	// 02. 식물 검색 기능
	public ArrayList<PlantVO> selectPlant(String mem_num) {
		try {
			pal = new ArrayList<PlantVO>();
			connection();
			
			int set_mem_num = Integer.parseInt(mem_num);
			
			String sql = "SELECT DISTINCT p.pt_num, p.pt_comment, p.pt_plant FROM plant p, state WHERE p.pt_num=p.pt_num AND p.mem_num= ?";
			pst = conn.prepareStatement(sql);

			pst.setInt(1, set_mem_num);

			rs = pst.executeQuery();

			while (rs.next()) {
				
				String get_pt_num = rs.getString(1);
				String get_pt_comment = rs.getString(2);
				String get_pt_plant = rs.getString(3);
//				System.out.println("데이터" + get_pt_num);
//				System.out.println("데이터" + get_pt_comment);
//				System.out.println("데이터" + get_pt_plant);
//				System.out.println("데이터" + mem_num);
				pvo = new PlantVO(get_pt_comment, get_pt_plant, mem_num, get_pt_num);
				pal.add(pvo);
//				System.out.println("인설트");
			} 

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("조회 실패!");
		} finally {
			close();
		}
		return pal;
	}
	
}
